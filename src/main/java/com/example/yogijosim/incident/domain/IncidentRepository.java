package com.example.yogijosim.incident.domain;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IncidentRepository {
	Incident save(Incident incident);

	Optional<Incident> findByIdWithCrawledData(@Param("id") Long id);
}
