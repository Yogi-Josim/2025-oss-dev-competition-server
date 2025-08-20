package com.example.yogijosim.schedular;

import com.example.yogijosim.data.domain.CrawledData;
import com.example.yogijosim.data.domain.CrawledDataRepository;
import com.example.yogijosim.gpt.GptService;
import com.example.yogijosim.gpt.IncidentAnalysisDto;
import com.example.yogijosim.incident.domain.Incident;
import com.example.yogijosim.incident.domain.IncidentRepository;
import com.example.yogijosim.mail.MailService;
import com.example.yogijosim.region.domain.Region;
import com.example.yogijosim.subscription.domain.Subscription;
import com.example.yogijosim.subscription.domain.SubscriptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@RequiredArgsConstructor
public class IncidentProcessingScheduler {
	private final CrawledDataRepository crawledDataRepository;
	private final IncidentRepository incidentRepository;
	private final SubscriptionRepository subscriptionRepository;
	private final GptService gptService;
	private final MailService mailService;

	@Scheduled(cron = "0 */5 * * * *")
	@Transactional
	public void processNewCrawledData() {
		List<CrawledData> unprocessedData = crawledDataRepository.findTop3ByProcessedFalse();

		try {
			for (CrawledData data : unprocessedData) {
				IncidentAnalysisDto analysisResult = gptService.analyze(data.getRawContent());

				Incident incident = Incident.from(analysisResult, data);
				incidentRepository.save(incident);
				if(incident.getDangerLevel()>=4){
					sendEmergencyMail(incident);
				}
				data.completeProcessing();
				Thread.sleep(2000);
			}
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void sendEmergencyMail(Incident incident) {
		Region incidentRegion = incident.getCrawledData().getRegion();
		if(incidentRegion == null) return;

		List<Subscription> subscriptions = subscriptionRepository.findActiveSubscriptionsByRegionWithUser(incidentRegion);
		subscriptions.forEach(sub-> {
			String userEmail = sub.getUser().getEmail();
			mailService.sendEmergencyReport(userEmail, incident);
		});
	}
}
