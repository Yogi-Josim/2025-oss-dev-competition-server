package com.example.yogijosim.region.persistence;

import com.example.yogijosim.region.domain.Region;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RegionJpaRepository extends JpaRepository<Region, Long> {
	Optional<Region> findByCityNameAndDistrictName(String cityName, String districtName);
}
