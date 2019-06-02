package com.kodilla.fishingnotebook.mapper;

import com.kodilla.fishingnotebook.domain.golkowice.*;
import org.springframework.stereotype.Component;

@Component
public class AccuweatherMapperGolkowice {

    public AccuweatherGolkowice mapToAccuweather(final AccuweatherGolkowiceDto accuweatherGolkowiceDto) {
        return new AccuweatherGolkowice(
                accuweatherGolkowiceDto.getId(),
                accuweatherGolkowiceDto.getLocalObservationDateTimeDto(),
                accuweatherGolkowiceDto.getWeatherDto(),
                accuweatherGolkowiceDto.getPrecipitationDto(),
                mapToAccuTemperature(accuweatherGolkowiceDto.getAccuTemperatureGolkowiceDto()));
    }

    public AccuTemperatureGolkowice mapToAccuTemperature(final AccuTemperatureGolkowiceDto accuTemperatureGolkowiceDto) {
        return new AccuTemperatureGolkowice(
                mapToAccuMetric(accuTemperatureGolkowiceDto.getAccuMetricGolkowiceDto()));
    }

    public AccuMetricGolkowice mapToAccuMetric(final AccuMetricGolkowiceDto accuMetricGolkowiceDto) {
        return new AccuMetricGolkowice(
                accuMetricGolkowiceDto.getValueDto());
    }
}