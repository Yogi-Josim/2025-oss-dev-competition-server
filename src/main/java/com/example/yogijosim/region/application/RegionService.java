package com.example.yogijosim.region.application;

import com.example.yogijosim.region.application.dto.RegionResponseDto;
import com.example.yogijosim.region.domain.Region;
import com.example.yogijosim.region.domain.RegionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RegionService {
	private final RegionRepository regionRepository;

	@Transactional(readOnly = true)
	public List<RegionResponseDto> getAllRegions() {
		List<Region> regions = regionRepository.findAll();

		Map<String, List<Region>> regionsByCity = regions.stream().collect(Collectors.groupingBy(Region::getCityName));

		return regionsByCity.entrySet().stream()
			.map(entry -> {
				String cityIdAndName = entry.getKey();
				List<RegionResponseDto.DistrictDto> districts = entry.getValue().stream()
					.map(region -> {
						String districtId = region.getCityName() + "-" + region.getDistrictName();
						return new RegionResponseDto.DistrictDto(districtId, region.getDistrictName());
					})
					.collect(Collectors.toList());
				return new RegionResponseDto(cityIdAndName, cityIdAndName, districts);
			})
			.collect(Collectors.toList());
	}
}