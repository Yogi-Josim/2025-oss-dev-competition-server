package com.example.yogijosim.subscription.domain;

import com.example.yogijosim.mail.MailFrequency;
import com.example.yogijosim.region.domain.Region;
import com.example.yogijosim.user.domain.User;

import java.util.List;

public interface SubscriptionRepository {
	boolean existsByUserAndRegion(User user, Region region);

	Subscription save(Subscription subscription);

	List<Subscription> findByMailFrequency(MailFrequency frequency);

	List<Subscription> findByRegion(Region region);

	List<Subscription> findByUser(User user);
}
