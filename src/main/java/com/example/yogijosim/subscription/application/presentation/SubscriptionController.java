package com.example.yogijosim.subscription.application.presentation;

import com.example.yogijosim.subscription.application.presentation.service.SubscriptionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class SubscriptionController {
	private final SubscriptionService subscriptionService;

	@PostMapping("/subscriptions")
	public ResponseEntity<List<Long>> createSubscription(@Valid @RequestBody SubscriptionRequestDto requestDto) {
		List<Long> createdSubscriptionIds = subscriptionService.createSubscription(requestDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdSubscriptionIds);
	}
}
