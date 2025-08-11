package com.example.yogijosim.subscription.persistence;

import com.example.yogijosim.region.domain.Region;
import com.example.yogijosim.subscription.domain.Subscription;
import com.example.yogijosim.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionJpaRepository extends JpaRepository<Subscription, Long> {
	boolean existsByUserAndRegion(User user, Region region);
}
