package com.example.yogijosim.region.persistence;

import com.example.yogijosim.region.domain.Region;
import com.example.yogijosim.region.domain.RegionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class RegionRepositoryImpl implements RegionRepository {
	private final RegionJpaRepository regionJpaRepository;

	@Override
	public Optional<Region> findByCityNameAndDistrictName(String cityName, String districtName) {
		return regionJpaRepository.findByCityNameAndDistrictName(cityName, districtName);
	}
}
