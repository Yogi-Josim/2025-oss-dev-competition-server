package com.example.yogijosim.subscription.application.presentation;

import com.example.yogijosim.subscription.application.presentation.service.SubscriptionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class SubscriptionController {
	private final SubscriptionService subscriptionService;

	@PostMapping("/subscribe")
	public ResponseEntity<String> subscribe(@Valid @RequestBody SubscriptionRequestDto requestDto) {
		subscriptionService.createSubscription(requestDto);
		return ResponseEntity.ok("구독이 성공적으로 완료되었습니다.");
	}
}
