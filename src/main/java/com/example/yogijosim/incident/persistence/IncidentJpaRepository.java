package com.example.yogijosim.incident.persistence;

import com.example.yogijosim.incident.domain.Incident;
import com.example.yogijosim.region.domain.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface IncidentJpaRepository extends JpaRepository<Incident, Long> {
	@Query("SELECT i FROM Incident i JOIN FETCH i.crawledData WHERE i.id = :id")
	Optional<Incident> findByIdWithCrawledData(Long id);

	@Query("SELECT i FROM Incident i JOIN FETCH i.crawledData cd WHERE i.createdAt BETWEEN :startTime AND :endTime AND cd.region IN :regions")
	List<Incident> findIncidentsBetweenDatesAndInRegions(@Param("startTime") LocalDateTime startTime,
														 @Param("endTime") LocalDateTime endTime,
														 @Param("regions") List<Region> regions);

	List<Incident> findAllByCreatedAtBetween(LocalDateTime yesterday, LocalDateTime today);
}
