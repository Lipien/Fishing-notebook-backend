package com.kodilla.fishingnotebook.domain.accuweather.golkowice;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class AccuTemperatureGolkowiceDto {

    @JsonProperty("Metric")
    private AccuMetricGolkowiceDto accuMetricGolkowiceDto;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AccuTemperatureGolkowiceDto that = (AccuTemperatureGolkowiceDto) o;

        return getAccuMetricGolkowiceDto().equals(that.getAccuMetricGolkowiceDto());
    }
}
