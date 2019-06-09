package com.kodilla.fishingnotebook.mapper.accuweather;

import com.kodilla.fishingnotebook.domain.accuweather.lesko.*;
import org.springframework.stereotype.Component;

@Component
public class AccuweatherMapperLesko {

    public AccuWeatherLesko mapToAccuweatherLesko(final AccuWeatherLeskoDto accuWeatherLeskoDto) {
        return new AccuWeatherLesko(
                accuWeatherLeskoDto.getId(),
                accuWeatherLeskoDto.getLocalObservationDateTimeDto(),
                accuWeatherLeskoDto.getWeatherDto(),
                accuWeatherLeskoDto.getPrecipitationDto(),
                mapToAccuTemperature(accuWeatherLeskoDto.getAccuTemperatureDto()));
    }

    public AccuTemperatureLesko mapToAccuTemperature(final AccuTemperatureLeskoDto accuTemperatureDto) {
        return new AccuTemperatureLesko(
                mapToAccuMetricLesko(accuTemperatureDto.getAccuMetricDto()));
    }

    public AccuMetricLesko mapToAccuMetricLesko(final AccuMetricLeskoDto accuMetricLeskoDto) {
        return new AccuMetricLesko(
                accuMetricLeskoDto.getValueDto());
    }
}
