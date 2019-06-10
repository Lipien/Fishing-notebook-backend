package com.kodilla.fishingnotebook.domain.accuweather.lesko;

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
public class AccuWeatherLeskoDto {

    private Long id;

    @JsonProperty("LocalObservationDateTime")
    private String localObservationDateTimeDto;

    @JsonProperty("WeatherText")
    private String weatherDto;

    @JsonProperty("HasPrecipitation")
    private String precipitationDto;

    @JsonProperty("Temperature")
    private AccuTemperatureLeskoDto accuTemperatureDto;
}