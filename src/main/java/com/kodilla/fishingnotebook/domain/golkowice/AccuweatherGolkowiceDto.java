package com.kodilla.fishingnotebook.domain.golkowice;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
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
}
