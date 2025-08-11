package com.example.yogijosim.data.domain;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CrawledDataRepository {
	Long save(CrawledData crawledData);

	List<CrawledData> findTop3ByProcessedFalse();
}
