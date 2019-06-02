package com.kodilla.fishingnotebook.domain.Kroscienko;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class AccuTemperatureKroscienkoDto {

    @JsonProperty("Metric")
    private AccuMetricKroscienkoDto accuMetricDto;
}
