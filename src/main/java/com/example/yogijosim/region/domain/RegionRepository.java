package com.example.yogijosim.region.domain;

import java.util.Optional;

public interface RegionRepository {
	Optional<Region> findByCityNameAndDistrictName(String cityName, String districtName);
}
