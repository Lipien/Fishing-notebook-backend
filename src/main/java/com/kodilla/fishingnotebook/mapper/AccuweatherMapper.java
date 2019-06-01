package com.kodilla.fishingnotebook.mapper;

import com.kodilla.fishingnotebook.domain.*;
import org.springframework.stereotype.Component;

@Component
public class AccuweatherMapper {

    public Accuweather mapToAccuweather(final AccuweatherDto accuweatherDto) {
        return new Accuweather(
                accuweatherDto.getId(),
                accuweatherDto.getLocalObservationDateTimeDto(),
                accuweatherDto.getWeatherDto(),
                accuweatherDto.getPrecipitationDto(),
                mapToAccuTemperature(accuweatherDto.getAccuTemperatureDto()));
    }

    public AccuTemperature mapToAccuTemperature(final AccuTemperatureDto accuTemperatureDto) {
        return new AccuTemperature(
                mapToAccuMetric(accuTemperatureDto.getAccuMetricDto()));
    }

    public AccuMetric mapToAccuMetric(final AccuMetricDto accuMetricDto) {
        return new AccuMetric(
                accuMetricDto.getValueDto());
    }
}