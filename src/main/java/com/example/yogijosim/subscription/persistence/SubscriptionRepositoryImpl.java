package com.example.yogijosim.subscription.persistence;

import com.example.yogijosim.region.domain.Region;
import com.example.yogijosim.mail.MailFrequency;
import com.example.yogijosim.subscription.domain.Subscription;
import com.example.yogijosim.subscription.domain.SubscriptionRepository;
import com.example.yogijosim.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class SubscriptionRepositoryImpl implements SubscriptionRepository {
	private final SubscriptionJpaRepository subscriptionJpaRepository;

	@Override
	public boolean existsByUserAndRegion(User user, Region region) {
		return subscriptionJpaRepository.existsByUserAndRegion(user, region);
	}

	@Override
	public Subscription save(Subscription subscription) {
		return subscriptionJpaRepository.save(subscription);
	}

	@Override
	public List<Subscription> findSubscriptionWithDetailsByFrequency(MailFrequency frequency) {
		return subscriptionJpaRepository.findSubscriptionWithDetailsByFrequency(frequency);
	}

	@Override
	public List<Subscription> findActiveSubscriptionsByRegionWithUser(Region region) {
		return subscriptionJpaRepository.findActiveSubscriptionsByRegionWithUser(region);
	}

	@Override
	public List<Subscription> findByUser(User user) {
		return subscriptionJpaRepository.findByUser(user);
	}

	@Override
	public Optional<Subscription> findByUserAndRegion(User user, Region region) {
		return subscriptionJpaRepository.findByUserAndRegion(user, region);
	}
}
