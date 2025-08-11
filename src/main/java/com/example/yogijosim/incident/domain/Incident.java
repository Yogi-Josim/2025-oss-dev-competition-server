package com.example.yogijosim.incident.domain;

import com.example.yogijosim.common.BaseTimeEntity;
import com.example.yogijosim.data.domain.CrawledData;
import com.example.yogijosim.gpt.IncidentAnalysisDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Incident extends BaseTimeEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "crawled_data_id")
	private CrawledData crawledData;

	private String summary;

	@Enumerated(EnumType.STRING)
	private DangerCategory category;

	private String location;

	private int dangerLevel;

	private int reliability;

	public static Incident from(IncidentAnalysisDto result, CrawledData crawledData) {
		return Incident.builder()
			.crawledData(crawledData)
			.summary(result.summary())
			.category(result.category())
			.location(result.location())
			.dangerLevel(result.dangerLevel())
			.reliability(result.reliability())
			.build();
	}
}
