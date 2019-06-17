package com.kodilla.fishingnotebook.domain.accuweather.kroscienko;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Component
public class AccuWeatherKroscienkoDto {

    private Long id;

    @JsonProperty("LocalObservationDateTime")
    private String localObservationDateTimeDto;

    @JsonProperty("WeatherText")
    private String weatherDto;

    @JsonProperty("HasPrecipitation")
    private String precipitationDto;

    @JsonProperty("Temperature")
    private AccuTemperatureKroscienkoDto accuTemperatureDto;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AccuWeatherKroscienkoDto that = (AccuWeatherKroscienkoDto) o;

        return getAccuTemperatureDto().equals(that.getAccuTemperatureDto());
    }
}
