package com.kodilla.fishingnotebook.domain.accuweather.kroscienko;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AccuTemperatureKroscienkoDto that = (AccuTemperatureKroscienkoDto) o;

        return getAccuMetricDto().equals(that.getAccuMetricDto());
    }
}
