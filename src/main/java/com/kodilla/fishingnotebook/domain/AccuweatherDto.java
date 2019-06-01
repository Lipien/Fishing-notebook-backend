package com.kodilla.fishingnotebook.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class AccuweatherDto {

    private Long id;

    @JsonProperty("LocalObservationDateTime")
    private String localObservationDateTimeDto;

    @JsonProperty("WeatherText")
    private String weatherDto;

    @JsonProperty("HasPrecipitation")
    private String precipitationDto;

    @JsonProperty("Temperature")
    private AccuTemperatureDto accuTemperatureDto;
}
