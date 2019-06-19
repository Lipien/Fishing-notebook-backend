package com.kodilla.fishingnotebook.mapper.accuweather;

import com.kodilla.fishingnotebook.domain.accuweather.golkowice.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class AccuweatherMapperGolkowiceTest {

    @InjectMocks
    private AccuweatherMapperGolkowice accuweatherMapperGolkowice;

    @Test
    public void mapToAccuweather() {
        //Given
        AccuweatherGolkowiceDto accuweatherGolkowiceDto = new AccuweatherGolkowiceDto(1L, "test_date", "test_weather",
                "test_precipitation", new AccuTemperatureGolkowiceDto(new AccuMetricGolkowiceDto(10.5)));

        //When
        AccuweatherGolkowice resultingAccuweatherGolkowice = accuweatherMapperGolkowice.mapToAccuweather(accuweatherGolkowiceDto);

        //Then
        assertEquals(accuweatherGolkowiceDto.getId(), resultingAccuweatherGolkowice.getId());
        assertEquals(accuweatherGolkowiceDto.getLocalObservationDateTimeDto(), resultingAccuweatherGolkowice.getLocalObservationDateTime());
        assertEquals(accuweatherGolkowiceDto.getWeatherDto(), resultingAccuweatherGolkowice.getWeather());
        assertEquals(accuweatherGolkowiceDto.getPrecipitationDto(), resultingAccuweatherGolkowice.getPrecipitation());
        assertEquals(accuweatherGolkowiceDto.getAccuTemperatureGolkowiceDto().getAccuMetricGolkowiceDto().getValueDto(),
                resultingAccuweatherGolkowice.getTemperature().getAccuMetricGolkowice().getValue(), 0.1);
    }

    @Test
    public void mapToAccuTemperature() {
        //Given
        AccuTemperatureGolkowiceDto accuTemperatureGolkowiceDto = new AccuTemperatureGolkowiceDto(new AccuMetricGolkowiceDto(11.3));

        //When
        AccuTemperatureGolkowice resultingAccuTemperatureGolkowice = accuweatherMapperGolkowice.mapToAccuTemperature(accuTemperatureGolkowiceDto);

        //Then
        assertEquals(accuTemperatureGolkowiceDto.getAccuMetricGolkowiceDto().getValueDto(),
                resultingAccuTemperatureGolkowice.getAccuMetricGolkowice().getValue(), 0.1);
    }

    @Test
    public void mapToAccuMetric() {
        //Given
        AccuMetricGolkowiceDto accuMetricGolkowiceDto = new AccuMetricGolkowiceDto(12.3);

        //When
        AccuMetricGolkowice resultingAccuMetricGolkowice = accuweatherMapperGolkowice.mapToAccuMetric(accuMetricGolkowiceDto);

        //Then
        assertEquals(accuMetricGolkowiceDto.getValueDto(), resultingAccuMetricGolkowice.getValue(), 0.1);
    }
}