package com.example.yogijosim.data.application;

import com.example.yogijosim.region.domain.Region;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record CrawledDataSaveRequestDto(
	@NotEmpty
	String sourceCommunity,

	@NotEmpty
	String sourceUrl,

	@NotEmpty
	String rawContent,

	@NotNull
	Region region
) {
}
