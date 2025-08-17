package com.example.yogijosim.subscription.application.presentation;

import com.example.yogijosim.subscription.application.presentation.service.SubscriptionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/subscriptions")
@RequiredArgsConstructor
public class SubscriptionController {
	private final SubscriptionService subscriptionService;

	@PostMapping
	public ResponseEntity<List<Long>> createSubscription(@Valid @RequestBody SubscriptionRequestDto requestDto) {
		List<Long> createdSubscriptionIds = subscriptionService.createSubscription(requestDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdSubscriptionIds);
	}

	@DeleteMapping("/unsubscribe")
	public ResponseEntity<Map<String, String>> unsubscribe(@RequestParam("token") String token) {
		subscriptionService.unsubscribe(token);
		return ResponseEntity.ok(Map.of("message", "구독이 성공적으로 취소되었습니다. 더 이상 메일이 발송되지 않습니다."));
	}
}
