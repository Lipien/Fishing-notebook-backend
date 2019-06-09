package com.kodilla.fishingnotebook.mapper.accuweather;

import com.kodilla.fishingnotebook.domain.accuweather.kroscienko.*;
import org.springframework.stereotype.Component;

@Component
public class AccuweatherMapperKroscienko {

    public AccuWeatherKroscienko mapToAccuweatherKroscienko(final AccuWeatherKroscienkoDto accuWeatherKroscienkoDto) {
        return new AccuWeatherKroscienko(
                accuWeatherKroscienkoDto.getId(),
                accuWeatherKroscienkoDto.getLocalObservationDateTimeDto(),
                accuWeatherKroscienkoDto.getWeatherDto(),
                accuWeatherKroscienkoDto.getPrecipitationDto(),
                mapToAccuTemperatureKroscienko(accuWeatherKroscienkoDto.getAccuTemperatureDto()));
    }

    public AccuTemperatureKroscienko mapToAccuTemperatureKroscienko(final AccuTemperatureKroscienkoDto accuTemperatureKroscienkoDto) {
        return new AccuTemperatureKroscienko(
                mapToAccuMetricKroscienko(accuTemperatureKroscienkoDto.getAccuMetricDto()));
    }

    public AccuMetricKroscienko mapToAccuMetricKroscienko(final AccuMetricKroscienkoDto accuMetricKroscienkoDto) {
        return new AccuMetricKroscienko(
                accuMetricKroscienkoDto.getValueDto());
    }
}
