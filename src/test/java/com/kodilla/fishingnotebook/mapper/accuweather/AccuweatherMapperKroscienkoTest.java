package com.kodilla.fishingnotebook.mapper.accuweather;

import com.kodilla.fishingnotebook.domain.accuweather.kroscienko.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class AccuweatherMapperKroscienkoTest {

    @InjectMocks
    private AccuweatherMapperKroscienko accuweatherMapperKroscienko;

    @Test
    public void mapToAccuweatherKroscienko() {
        //Given
        AccuWeatherKroscienkoDto accuWeatherKroscienkoDto = new AccuWeatherKroscienkoDto(1L, "test_date", "test_weather",
                "test_precipitation", new AccuTemperatureKroscienkoDto(new AccuMetricKroscienkoDto(10.5)));

        //When
        AccuWeatherKroscienko resultingAccuweatherKroscienko = accuweatherMapperKroscienko.mapToAccuweatherKroscienko(accuWeatherKroscienkoDto);

        //Then
        assertEquals(accuWeatherKroscienkoDto.getId(), resultingAccuweatherKroscienko.getId());
        assertEquals(accuWeatherKroscienkoDto.getLocalObservationDateTimeDto(), resultingAccuweatherKroscienko.getLocalObservationDateTime());
        assertEquals(accuWeatherKroscienkoDto.getWeatherDto(), resultingAccuweatherKroscienko.getWeather());
        assertEquals(accuWeatherKroscienkoDto.getPrecipitationDto(), resultingAccuweatherKroscienko.getPrecipitation());
        assertEquals(accuWeatherKroscienkoDto.getAccuTemperatureDto().getAccuMetricDto().getValueDto(),
                resultingAccuweatherKroscienko.getTemperature().getAccuMetricKroscienko().getValue(), 0.1);
    }

    @Test
    public void mapToAccuTemperatureKroscienko() {
        //Given
        AccuTemperatureKroscienkoDto accuTemperatureKroscienkoDto = new AccuTemperatureKroscienkoDto(new AccuMetricKroscienkoDto(11.3));

        //When
        AccuTemperatureKroscienko resultingAccuTemperatureKroscienko = accuweatherMapperKroscienko.mapToAccuTemperatureKroscienko(accuTemperatureKroscienkoDto);

        //Then
        assertEquals(accuTemperatureKroscienkoDto.getAccuMetricDto().getValueDto(), resultingAccuTemperatureKroscienko.getAccuMetricKroscienko().getValue(), 0.1);
    }

    @Test
    public void mapToAccuMetricKroscienko() {
        //Given
        AccuMetricKroscienkoDto accuMetricKroscienkoDto = new AccuMetricKroscienkoDto(12.3);

        //When
        AccuMetricKroscienko resultingAccuMetricKroscienko = accuweatherMapperKroscienko.mapToAccuMetricKroscienko(accuMetricKroscienkoDto);

        //Then
        assertEquals(accuMetricKroscienkoDto.getValueDto(), resultingAccuMetricKroscienko.getValue(), 0.1);
    }
}