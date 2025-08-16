package com.example.yogijosim.subscription.persistence;

import com.example.yogijosim.region.domain.Region;
import com.example.yogijosim.mail.MailFrequency;
import com.example.yogijosim.subscription.domain.Subscription;
import com.example.yogijosim.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubscriptionJpaRepository extends JpaRepository<Subscription, Long> {
	boolean existsByUserAndRegion(User user, Region region);

	List<Subscription> findByMailFrequency(MailFrequency mailFrequency);

	List<Subscription> findByRegion(Region region);
}
