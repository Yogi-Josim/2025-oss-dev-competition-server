package com.example.yogijosim.region.domain;

import com.example.yogijosim.common.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
public class Region extends BaseTimeEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String cityName; //경기도

	@Column(nullable = false)
	private String districtName; //용인시
}