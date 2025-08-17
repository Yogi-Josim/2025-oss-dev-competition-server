package com.example.yogijosim.mail;

import com.example.yogijosim.common.JwtUtil;
import com.example.yogijosim.incident.domain.Incident;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class MailService {

	private final JavaMailSender javaMailSender;
	private final SpringTemplateEngine templateEngine;
	private final JwtUtil jwtUtil;

	public void sendPeriodicReport(String toEmail, List<Incident> incidents) {
		String subject = "[여기조심] 구독하신 지역의 주간/일일 위험 정보 리포트입니다.";
		sendMail(toEmail, subject, "periodic-report", Map.of("incidents", incidents));
	}

	public void sendEmergencyReport(String toEmail, Incident incident) {
		String subject = "🚨 [긴급] 구독하신 지역에 새로운 위험 정보가 발생했습니다!";
		sendMail(toEmail, subject, "emergency-report", Map.of("incident", incident));
	}

	private void sendMail(String toEmail, String subject, String templateName, Map<String, Object> variables) {
		try {
			MimeMessage mimeMessage = javaMailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");

			helper.setTo(toEmail);
			helper.setSubject(subject);

			String unsubscribeToken = jwtUtil.generateUnsubscribeToken(toEmail);
			Context context = new Context();
			context.setVariables(variables);
			context.setVariable("unsubscribeToken", unsubscribeToken);

			String html = templateEngine.process(templateName, context);
			helper.setText(html, true);
			helper.addInline("logoImage", new ClassPathResource("static/images/logo.png"));
			javaMailSender.send(mimeMessage);
		} catch (Exception e) {
			throw new RuntimeException("메일 발송에 실패했습니다: " + toEmail, e);
		}
	}
}
