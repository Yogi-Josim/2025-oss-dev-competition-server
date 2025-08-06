package com.example.yogijosim.data.application.service;

import com.example.yogijosim.data.application.CrawledDataSaveRequestDto;
import com.example.yogijosim.data.domain.CrawledData;
import com.example.yogijosim.data.domain.CrawledDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CrawledDataService {
	private final CrawledDataRepository crawledDataRepository;

	public Long save(CrawledDataSaveRequestDto request) {
		return crawledDataRepository.save(CrawledData.from(request));
	}
}
