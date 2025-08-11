package com.example.yogijosim.incident.application.dto;

import com.example.yogijosim.data.domain.CrawledData;
import com.example.yogijosim.incident.domain.DangerCategory;
import com.example.yogijosim.incident.domain.Incident;
import java.time.LocalDateTime;

public record IncidentDetailResponseDto(
    Long incidentId,
    OriginalDataDto originalData,
    ProcessedDataDto processedData
) {
    public record OriginalDataDto(
        String sourceCommunity,
        String sourceUrl,
        String rawContent,
        LocalDateTime crawledAt
    ) {
        public static OriginalDataDto from(CrawledData crawledData) {
            return new OriginalDataDto(
                crawledData.getSourceCommunity(),
                crawledData.getSourceUrl(),
                crawledData.getRawContent(),
                crawledData.getCreatedAt()
            );
        }
    }
    public record ProcessedDataDto(
        String summary,
        DangerCategory category,
        String location,
        int dangerLevel,
        int reliability,
        LocalDateTime analyzedAt
    ) {
        public static ProcessedDataDto from(Incident incident) {
            return new ProcessedDataDto(
                incident.getSummary(),
                incident.getCategory(),
                incident.getLocation(),
                incident.getDangerLevel(),
                incident.getReliability(),
                incident.getCreatedAt()
            );
        }
    }
    
    public static IncidentDetailResponseDto from(Incident incident, CrawledData crawledData) {
        return new IncidentDetailResponseDto(
            incident.getId(),
            OriginalDataDto.from(crawledData),
            ProcessedDataDto.from(incident)
        );
    }
}