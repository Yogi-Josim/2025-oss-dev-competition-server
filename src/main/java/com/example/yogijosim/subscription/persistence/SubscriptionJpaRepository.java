package com.example.yogijosim.subscription.persistence;

import com.example.yogijosim.region.domain.Region;
import com.example.yogijosim.mail.MailFrequency;
import com.example.yogijosim.subscription.domain.Subscription;
import com.example.yogijosim.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface SubscriptionJpaRepository extends JpaRepository<Subscription, Long> {
	@Query("SELECT s FROM Subscription s " +
		"JOIN FETCH s.user " +
		"JOIN FETCH s.region " +
		"WHERE s.mailFrequency = :frequency AND s.isActive = true")
	List<Subscription> findSubscriptionWithDetailsByFrequency(MailFrequency mailFrequency);

	@Query("SELECT s FROM Subscription s " +
		"JOIN FETCH s.user " +
		"WHERE s.region = :region AND s.isActive = true")
	List<Subscription> findActiveSubscriptionsByRegionWithUser(Region region);

	List<Subscription> findByUser(User user);

	Optional<Subscription> findByUserAndRegion(User user, Region region);
}
