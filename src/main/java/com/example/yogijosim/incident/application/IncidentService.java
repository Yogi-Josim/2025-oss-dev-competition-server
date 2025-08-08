package com.example.yogijosim.incident.application;

import com.example.yogijosim.incident.application.dto.IncidentDetailResponseDto;
import com.example.yogijosim.incident.application.dto.IncidentResponseDto;
import com.example.yogijosim.incident.domain.Incident;
import com.example.yogijosim.incident.domain.IncidentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class IncidentService {
	private final IncidentRepository incidentRepository;

	@Transactional(readOnly = true)
	public IncidentResponseDto findIncidentById(Long id) {
		Incident incident = incidentRepository.findByIdWithCrawledData(id)
			.orElseThrow(() -> new IllegalArgumentException("해당 Incident 를 찾을 수 없습니다"));
		return IncidentResponseDto.from(incident);
	}

	@Transactional(readOnly = true)
	public IncidentDetailResponseDto findDetailIncidentById(Long id) {
		Incident incident = incidentRepository.findByIdWithCrawledData(id)
			.orElseThrow(() -> new IllegalArgumentException("해당 Incident 를 찾을 수 없습니다"));
		return IncidentDetailResponseDto.from(incident, incident.getCrawledData());
	}
}
