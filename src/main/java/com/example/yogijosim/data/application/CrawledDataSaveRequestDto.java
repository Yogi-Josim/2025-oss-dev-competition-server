package com.example.yogijosim.data.application;

import com.example.yogijosim.region.domain.Region;
import jakarta.validation.constraints.NotEmpty;

public record CrawledDataSaveRequestDto(
	@NotEmpty
	String sourceCommunity,

	@NotEmpty
	String sourceUrl,

	@NotEmpty
	String rawContent,

	@NotEmpty
	Region region
) {
}
