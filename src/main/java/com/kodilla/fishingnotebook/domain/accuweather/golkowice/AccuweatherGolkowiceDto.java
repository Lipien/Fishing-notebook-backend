package com.kodilla.fishingnotebook.domain.accuweather.golkowice;

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
public class AccuweatherGolkowiceDto {

    private Long id;

    @JsonProperty("LocalObservationDateTime")
    private String localObservationDateTimeDto;

    @JsonProperty("WeatherText")
    private String weatherDto;

    @JsonProperty("HasPrecipitation")
    private String precipitationDto;

    @JsonProperty("Temperature")
    private AccuTemperatureGolkowiceDto accuTemperatureGolkowiceDto;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AccuweatherGolkowiceDto that = (AccuweatherGolkowiceDto) o;

        return getAccuTemperatureGolkowiceDto().equals(that.getAccuTemperatureGolkowiceDto());
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
