package com.example.yogijosim.schedular;

import com.example.yogijosim.incident.domain.Incident;
import com.example.yogijosim.incident.domain.IncidentRepository;
import com.example.yogijosim.mail.MailFrequency;
import com.example.yogijosim.mail.MailService;
import com.example.yogijosim.region.domain.Region;
import com.example.yogijosim.subscription.domain.Subscription;
import com.example.yogijosim.subscription.domain.SubscriptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class MailSenderScheduler {
	private final SubscriptionRepository subscriptionRepository;
	private final IncidentRepository incidentRepository;
	private final MailService mailService;

	@Scheduled(cron = "0 0 8 * * *") // 매일 아침 8시에 실행
	public void sendPeriodicReports() {
		LocalDateTime today = LocalDate.now().atStartOfDay();
		boolean isMonday = today.getDayOfWeek() == DayOfWeek.MONDAY;

		sendReportForFrequency(MailFrequency.DAILY, today.minusDays(1), today);
		if (isMonday) {
			sendReportForFrequency(MailFrequency.WEEKLY, today.minusWeeks(1), today);
		}
	}

	private void sendReportForFrequency(MailFrequency frequency, LocalDateTime startTime, LocalDateTime endTime) {
		Map<String, List<Subscription>> subsByEmail = subscriptionRepository.findSubscriptionWithDetailsByFrequency(frequency)
			.stream()
			.collect(Collectors.groupingBy(sub -> sub.getUser().getEmail()));

		subsByEmail.forEach((email, subscriptions) -> {
			List<Region> regions = subscriptions
				.stream()
				.map(Subscription::getRegion)
				.toList();

			List<Incident> incidents = incidentRepository.findIncidentsBetweenDatesAndInRegions(startTime, endTime, regions)
				.stream()
				.filter(incident -> incident.getDangerLevel() < 4) // 긴급(4점 이상) 제외
				.toList();

			if (!incidents.isEmpty()) {
				mailService.sendPeriodicReport(email, incidents);
			}
		});
	}
}