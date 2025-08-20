package com.example.yogijosim.subscription.domain;

import com.example.yogijosim.mail.MailFrequency;
import com.example.yogijosim.region.domain.Region;
import com.example.yogijosim.user.domain.User;

import java.util.List;
import java.util.Optional;

public interface SubscriptionRepository {
	boolean existsByUserAndRegion(User user, Region region);

	Subscription save(Subscription subscription);

	List<Subscription> findSubscriptionWithDetailsByFrequency(MailFrequency frequency);

	List<Subscription> findByRegion(Region region);

	List<Subscription> findByUser(User user);

	Optional<Subscription> findByUserAndRegion(User user, Region region);
}
