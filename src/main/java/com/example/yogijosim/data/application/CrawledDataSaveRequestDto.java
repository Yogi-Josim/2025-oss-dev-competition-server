package com.example.yogijosim.data.application;

import jakarta.validation.constraints.NotEmpty;

public record CrawledDataSaveRequestDto(
	@NotEmpty
	String sourceCommunity,

	@NotEmpty
	String sourceUrl,

	@NotEmpty
	String rawContent
) {
}
