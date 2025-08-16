package com.example.yogijosim.incident.domain;

import lombok.Getter;

@Getter
public enum DangerCategory {
	NATURAL_DISASTER("자연 재해"),
	VIOLENT_CRIME("칼부림/총기"),
	SUBWAY_FIRE("지하철 화재"),
	PEST_OUTBREAK("러브버그/해충"),
	SINKHOLE("싱크홀/도로 파손"),
	ACCIDENT("사건/사고"),
	ETC("기타");

	private final String description;

	DangerCategory(String description) {
		this.description = description;
	}
}
