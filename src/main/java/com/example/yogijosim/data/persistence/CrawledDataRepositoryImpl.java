package com.example.yogijosim.data.persistence;

import com.example.yogijosim.data.domain.CrawledData;
import com.example.yogijosim.data.domain.CrawledDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CrawledDataRepositoryImpl implements CrawledDataRepository {
	private final CrawledDataJpaRepository crawledDataJpaRepository;

	@Override
	public Long save(CrawledData crawledData) {
		return crawledDataJpaRepository.save(crawledData).getId();
	}
}
