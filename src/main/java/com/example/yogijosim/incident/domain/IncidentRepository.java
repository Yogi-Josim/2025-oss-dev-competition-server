package com.example.yogijosim.incident.domain;

import com.example.yogijosim.region.domain.Region;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface IncidentRepository {
	Incident save(Incident incident);

	Optional<Incident> findByIdWithCrawledData(@Param("id") Long id);

	List<Incident> findIncidentsBetweenDatesAndInRegions(@Param("startTime") LocalDateTime startTime,
														 @Param("endTime") LocalDateTime endTime,
														 @Param("regions") List<Region> regions);
}
