package com.example.yogijosim.incident.persistence;

import com.example.yogijosim.incident.domain.Incident;
import com.example.yogijosim.incident.domain.IncidentRepository;
import com.example.yogijosim.region.domain.Region;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class IncidentRepositoryImpl implements IncidentRepository {
	private final IncidentJpaRepository incidentJpaRepository;

	@Override
	public Incident save(Incident incident) {
		return incidentJpaRepository.save(incident);
	}

	@Override
	public Optional<Incident> findByIdWithCrawledData(Long id) {
		return incidentJpaRepository.findByIdWithCrawledData(id);
	}

	@Override
	public List<Incident> findIncidentsBetweenDatesAndInRegions(LocalDateTime startTime, LocalDateTime endTime, List<Region> regions) {
		return incidentJpaRepository.findIncidentsBetweenDatesAndInRegions(startTime, endTime, regions);
	}
}
