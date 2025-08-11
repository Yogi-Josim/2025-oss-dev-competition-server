package com.example.yogijosim.incident.persistence;

import com.example.yogijosim.incident.domain.Incident;
import com.example.yogijosim.incident.domain.IncidentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

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
}
