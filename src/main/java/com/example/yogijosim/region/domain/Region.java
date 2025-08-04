package com.example.yogijosim.region.domain;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
public class Region {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String cityName; //경기도

	@Column(nullable = false)
	private String districtName; //용인시
}