package com.example.yogijosim.data.persistence;

import com.example.yogijosim.data.domain.CrawledData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CrawledDataJpaRepository extends JpaRepository<CrawledData, Long> {
	List<CrawledData> findTop3ByProcessedFalse();
}
