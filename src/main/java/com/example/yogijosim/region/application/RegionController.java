package com.example.yogijosim.region.application;

import com.example.yogijosim.region.application.dto.RegionResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class RegionController {
	private final RegionService regionService;

	@GetMapping("/regions")
	public ResponseEntity<List<RegionResponseDto>> getRegions() {
		List<RegionResponseDto> regions = regionService.getAllRegions();
		return ResponseEntity.ok(regions);
	}
}