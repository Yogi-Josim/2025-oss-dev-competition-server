package com.example.yogijosim.incident.application;

import com.example.yogijosim.incident.application.dto.IncidentDetailResponseDto;
import com.example.yogijosim.incident.application.dto.IncidentResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class IncidentController {
	private final IncidentService incidentService;

	@GetMapping("/incidents/{id}")
	public ResponseEntity<IncidentResponseDto> findIncident(@PathVariable Long id) {
		IncidentResponseDto response = incidentService.findIncidentById(id);
		return ResponseEntity.ok(response);
	}

	@GetMapping("/incidents/{id}/details")
	public ResponseEntity<IncidentDetailResponseDto> findDetailIncident(@PathVariable Long id) {
		IncidentDetailResponseDto response = incidentService.findDetailIncidentById(id);
		return ResponseEntity.ok(response);
	}
}
