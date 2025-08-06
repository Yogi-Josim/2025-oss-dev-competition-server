package com.example.yogijosim.data.domain;

import org.springframework.stereotype.Repository;

@Repository
public interface CrawledDataRepository {
	Long save(CrawledData crawledData);
}
