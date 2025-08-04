package com.example.yogijosim.subscription.persistence;

import com.example.yogijosim.region.domain.Region;
import com.example.yogijosim.subscription.domain.Subscription;
import com.example.yogijosim.subscription.domain.SubscriptionRepository;
import com.example.yogijosim.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class SubscriptionRepositoryImpl implements SubscriptionRepository {
	private final SubscriptionJpaRepository subscriptionJpaRepository;

	@Override
	public boolean existsByUserAndRegion(User user, Region region) {
		return subscriptionJpaRepository.existsByUserAndRegion(user, region);
	}

	@Override
	public void save(Subscription subscription) {
		subscriptionJpaRepository.save(subscription);
	}
}
