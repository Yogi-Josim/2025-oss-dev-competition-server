package com.example.yogijosim.subscription.domain;

import com.example.yogijosim.region.domain.Region;
import com.example.yogijosim.user.domain.User;

public interface SubscriptionRepository {
	boolean existsByUserAndRegion(User user, Region region);

	void save(Subscription subscription);
}
