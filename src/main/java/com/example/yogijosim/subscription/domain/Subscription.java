package com.example.yogijosim.subscription.domain;

import com.example.yogijosim.common.BaseTimeEntity;
import com.example.yogijosim.mail.MailFrequency;
import com.example.yogijosim.region.domain.Region;
import com.example.yogijosim.user.domain.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Getter
public class Subscription extends BaseTimeEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "region_id", nullable = false)
	private Region region;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private MailFrequency mailFrequency;

	@Builder.Default
	@Column(nullable = false)
	private boolean isActive = true;

	public void activate() {
		this.isActive = true;
	}

	public void deactivate() {
		this.isActive = false;
	}

	public static Subscription from(User user, Region region, MailFrequency mailFrequency) {
		return Subscription.builder()
			.user(user)
			.region(region)
			.mailFrequency(mailFrequency)
			.build();
	}
}