package com.example.yogijosim.incident.persistence;

import com.example.yogijosim.incident.domain.Incident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface IncidentJpaRepository extends JpaRepository<Incident, Long> {
	@Query("SELECT i FROM Incident i JOIN FETCH i.crawledData WHERE i.id = :id")
	Optional<Incident> findByIdWithCrawledData(Long id);
}
