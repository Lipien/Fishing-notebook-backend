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
public class AccuMetricKroscienkoDto {

    @JsonProperty("Value")
    private double valueDto;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AccuMetricKroscienkoDto that = (AccuMetricKroscienkoDto) o;

        return Double.compare(that.getValueDto(), getValueDto()) == 0;
    }
}