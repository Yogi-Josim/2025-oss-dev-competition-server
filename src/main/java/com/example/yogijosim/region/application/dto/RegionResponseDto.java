package com.example.yogijosim.region.application.dto;

import com.example.yogijosim.region.domain.Region;
import java.util.List;

public record RegionResponseDto(String id, String name, List<DistrictDto> districts) {

    public record DistrictDto(String id, String name) {
        public static DistrictDto from(Region region) {
            String districtId = region.getCityName() + "-" + region.getDistrictName();
            return new DistrictDto(districtId, region.getDistrictName());
        }
    }
}