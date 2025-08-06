package com.example.yogijosim.subscription.application.presentation.service;

import com.example.yogijosim.region.domain.Region;
import com.example.yogijosim.region.domain.RegionRepository;
import com.example.yogijosim.subscription.domain.Subscription;
import com.example.yogijosim.subscription.domain.SubscriptionRepository;
import com.example.yogijosim.subscription.application.presentation.SubscriptionRequestDto;
import com.example.yogijosim.user.domain.User;
import com.example.yogijosim.user.domain.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SubscriptionService {
	private final UserRepository userRepository;
	private final RegionRepository regionRepository;
	private final SubscriptionRepository subscriptionRepository;

	@Transactional
	public List<Long> createSubscription(SubscriptionRequestDto requestDto) {
		User user = userRepository.findByEmail(requestDto.email()).orElseGet(() -> userRepository.save(User.from(requestDto.email())));

		List<Long> createdSubscriptionIds = new ArrayList<>();
		for (String regionName : requestDto.regions()) {
			String[] parts = regionName.split(" ");
			String cityName = parts[0];
			String districtName = parts[1];

			Region region = regionRepository.findByCityNameAndDistrictName(cityName, districtName)
				.orElseThrow(() -> new IllegalArgumentException("존재하지 않는 지역입니다: " + regionName));

			if (!subscriptionRepository.existsByUserAndRegion(user, region)) {
				Subscription newSubscription = subscriptionRepository.save(Subscription.from(user, region));
				createdSubscriptionIds.add(newSubscription.getId());
			}
		}
		return createdSubscriptionIds;
	}
}
