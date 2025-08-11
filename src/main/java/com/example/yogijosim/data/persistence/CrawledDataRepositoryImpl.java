package com.example.yogijosim.data.persistence;

import com.example.yogijosim.data.domain.CrawledData;
import com.example.yogijosim.data.domain.CrawledDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CrawledDataRepositoryImpl implements CrawledDataRepository {
	private final CrawledDataJpaRepository crawledDataJpaRepository;

	@Override
	public Long save(CrawledData crawledData) {
		return crawledDataJpaRepository.save(crawledData).getId();
	}

	@Override
	public List<CrawledData> findTop3ByProcessedFalse() {
		return crawledDataJpaRepository.findTop3ByProcessedFalse();
	}
}
