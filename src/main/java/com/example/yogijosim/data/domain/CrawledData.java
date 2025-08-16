package com.example.yogijosim.data.domain;

import com.example.yogijosim.common.BaseTimeEntity;
import com.example.yogijosim.data.application.CrawledDataSaveRequestDto;
import com.example.yogijosim.region.domain.Region;
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
public class CrawledData extends BaseTimeEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "source_community", nullable = false)
	private String sourceCommunity;

	@Column(name = "source_url", nullable = false, unique = true)
	private String sourceUrl;

	@Lob
	@Column(name = "raw_content", nullable = false, columnDefinition = "TEXT")
	private String rawContent;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "region_id")
	private Region region;

	@Column(name = "processed")
	private boolean processed = false;

	public static CrawledData from(CrawledDataSaveRequestDto request) {
		return CrawledData.builder().
			sourceCommunity(request.sourceCommunity())
			.sourceUrl(request.sourceUrl())
			.rawContent(request.rawContent())
			.region(request.region())
			.build();
	}
	public void completeProcessing(){
		this.processed = true;
	}
}
