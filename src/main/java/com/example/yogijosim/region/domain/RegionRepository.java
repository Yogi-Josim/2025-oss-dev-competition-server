package com.example.yogijosim.region.domain;

import java.util.List;
import java.util.Optional;

public interface RegionRepository {
	Optional<Region> findByCityNameAndDistrictName(String cityName, String districtName);

	List<Region> findAll();
}
