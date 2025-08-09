package com.example.yogijosim.incident.application.dto;

import com.example.yogijosim.incident.domain.DangerCategory;
import com.example.yogijosim.incident.domain.Incident;
import java.time.LocalDateTime;

public record IncidentResponseDto(
	Long incidentId,
	String summary,
	DangerCategory category,
	String location,
	int dangerLevel,
	LocalDateTime analyzedAt
) {
	public static IncidentResponseDto from(Incident incident) {
		return new IncidentResponseDto(
			incident.getId(),
			incident.getSummary(),
			incident.getCategory(),
			incident.getLocation(),
			incident.getDangerLevel(),
			incident.getCreatedAt()
		);
	}
}