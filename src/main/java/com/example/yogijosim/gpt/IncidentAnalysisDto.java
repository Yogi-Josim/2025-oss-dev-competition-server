package com.example.yogijosim.gpt;

import com.example.yogijosim.incident.domain.DangerCategory;
import com.fasterxml.jackson.annotation.JsonProperty;

public record IncidentAnalysisDto(
    String summary,
    DangerCategory category,
    String location,

    @JsonProperty("danger_level")
    int dangerLevel,
    int reliability
) {}