package com.example.yogijosim.data.persistence;

import com.example.yogijosim.data.domain.CrawledData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CrawledDataJpaRepository extends JpaRepository<CrawledData, Long> {
}
