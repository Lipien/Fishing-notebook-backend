package com.kodilla.fishingnotebook.mapper.accuweather;

import com.kodilla.fishingnotebook.domain.accuweather.lesko.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class AccuweatherMapperLeskoTest {

    @InjectMocks
    private AccuweatherMapperLesko accuweatherMapperLesko;

    @Test
    public void mapToAccuweatherLesko() {
        //Given
        AccuWeatherLeskoDto accuWeatherLeskoDto = new AccuWeatherLeskoDto(1L, "test_date", "test_weather",
                "test_precipitation", new AccuTemperatureLeskoDto(new AccuMetricLeskoDto(10.5)));

        //When
        AccuWeatherLesko resultingAccuweatherLesko = accuweatherMapperLesko.mapToAccuweatherLesko(accuWeatherLeskoDto);

        //Then
        assertEquals(accuWeatherLeskoDto.getId(), resultingAccuweatherLesko.getId());
        assertEquals(accuWeatherLeskoDto.getLocalObservationDateTimeDto(), resultingAccuweatherLesko.getLocalObservationDateTime());
        assertEquals(accuWeatherLeskoDto.getWeatherDto(), resultingAccuweatherLesko.getWeather());
        assertEquals(accuWeatherLeskoDto.getPrecipitationDto(), resultingAccuweatherLesko.getPrecipitation());
        assertEquals(accuWeatherLeskoDto.getAccuTemperatureDto().getAccuMetricDto().getValueDto(),
                resultingAccuweatherLesko.getTemperature().getAccuMetric().getValue(), 0.1);
    }

    @Test
    public void mapToAccuTemperature() {

        //Given
        AccuTemperatureLeskoDto accuTemperatureLeskoDto = new AccuTemperatureLeskoDto(new AccuMetricLeskoDto(11.3));

        //When
        AccuTemperatureLesko resultingAccuTemperatureLesko = accuweatherMapperLesko.mapToAccuTemperature(accuTemperatureLeskoDto);

        //Then
        assertEquals(accuTemperatureLeskoDto.getAccuMetricDto().getValueDto(), resultingAccuTemperatureLesko.getAccuMetric().getValue(), 0.1);
    }

    @Test
    public void mapToAccuMetricLesko() {
        //Given
        AccuMetricLeskoDto accuMetricLeskoDto = new AccuMetricLeskoDto(12.3);

        //When
        AccuMetricLesko resultingAccuMetricLesko = accuweatherMapperLesko.mapToAccuMetricLesko(accuMetricLeskoDto);

        //Then
        assertEquals(accuMetricLeskoDto.getValueDto(), resultingAccuMetricLesko.getValue(), 0.1);
    }
}