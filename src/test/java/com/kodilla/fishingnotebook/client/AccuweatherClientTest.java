package com.kodilla.fishingnotebook.client;

import com.kodilla.fishingnotebook.config.AccuweatherConfig;
import com.kodilla.fishingnotebook.domain.accuweather.golkowice.AccuMetricGolkowiceDto;
import com.kodilla.fishingnotebook.domain.accuweather.golkowice.AccuTemperatureGolkowiceDto;
import com.kodilla.fishingnotebook.domain.accuweather.golkowice.AccuweatherGolkowiceDto;
import com.kodilla.fishingnotebook.domain.accuweather.kroscienko.AccuMetricKroscienkoDto;
import com.kodilla.fishingnotebook.domain.accuweather.kroscienko.AccuTemperatureKroscienkoDto;
import com.kodilla.fishingnotebook.domain.accuweather.kroscienko.AccuWeatherKroscienkoDto;
import com.kodilla.fishingnotebook.domain.accuweather.lesko.AccuMetricLeskoDto;
import com.kodilla.fishingnotebook.domain.accuweather.lesko.AccuTemperatureLeskoDto;
import com.kodilla.fishingnotebook.domain.accuweather.lesko.AccuWeatherLeskoDto;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AccuweatherClientTest {

    @InjectMocks
    private AccuweatherClient accuweatherClient;

    @Mock
    private RestTemplate restTemplate;

    @Mock
    private AccuweatherConfig accuweatherConfig;

    @Before
    public void init() {
        when(accuweatherConfig.getAccuweatherApiEndpoint()).thenReturn("http://test.com/");
        when(accuweatherConfig.getAccuweatherAppKey()).thenReturn("test");
        when(accuweatherConfig.getAccuweatherApiLanguage()).thenReturn("test");
    }

    @Test
    public void shouldFetchgetWeatherLesko() throws URISyntaxException {
        //Given
        when(accuweatherConfig.getAccuweatherStationLesko()).thenReturn("test");

        AccuWeatherLeskoDto[] accuWeatherLeskoDtos = new AccuWeatherLeskoDto[1];
        accuWeatherLeskoDtos[0] = new AccuWeatherLeskoDto(1L, "test_date", "test_weather",
                "test_precipitation", new AccuTemperatureLeskoDto(new AccuMetricLeskoDto(10.5)));

        URI url = new URI("http://test.com/test?apikey=test&language=test");

        when(restTemplate.getForObject(url, AccuWeatherLeskoDto[].class)).thenReturn(accuWeatherLeskoDtos);

        //When
        List <AccuWeatherLeskoDto> fetchedImgwHydroLesko = accuweatherClient.getWeatherLesko();

        //Then
        assertEquals(1, fetchedImgwHydroLesko.size());
        assertEquals(java.util.Optional.of(1L), java.util.Optional.of(fetchedImgwHydroLesko.get(0).getId()));
        assertEquals("test_date", fetchedImgwHydroLesko.get(0).getLocalObservationDateTimeDto());
        assertEquals("test_weather", fetchedImgwHydroLesko.get(0).getWeatherDto());
        assertEquals("test_precipitation", fetchedImgwHydroLesko.get(0).getPrecipitationDto());
        assertEquals(new AccuTemperatureLeskoDto(new AccuMetricLeskoDto(10.5)), fetchedImgwHydroLesko.get(0).getAccuTemperatureDto());
    }

    @Test
    public void shouldReturnLeskoEmptyList() {
        //Given & When
        List <AccuWeatherLeskoDto> fetchedImgwHydroLesko = accuweatherClient.getWeatherLesko();

        //Then
        assertEquals(0, fetchedImgwHydroLesko.size());
    }

    @Test
    public void shouldFetchgetWeatherKroscienko() throws URISyntaxException {
        //Given
        when(accuweatherConfig.getAccuweatherStationKroscienko()).thenReturn("test");

        AccuWeatherKroscienkoDto[] accuWeatherKroscienkoDtos = new AccuWeatherKroscienkoDto[1];
        accuWeatherKroscienkoDtos[0] = new AccuWeatherKroscienkoDto(1L, "test_date", "test_weather",
                "test_precipitation", new AccuTemperatureKroscienkoDto(new AccuMetricKroscienkoDto(10.5)));

        URI url = new URI("http://test.com/test?apikey=test&language=test");

        when(restTemplate.getForObject(url, AccuWeatherKroscienkoDto[].class)).thenReturn(accuWeatherKroscienkoDtos);

        //When
        List <AccuWeatherKroscienkoDto> fetchedImgwHydroKroscienko = accuweatherClient.getWeatherKroscienko();

        //Then
        assertEquals(1, fetchedImgwHydroKroscienko.size());
        assertEquals(java.util.Optional.of(1L), java.util.Optional.of(fetchedImgwHydroKroscienko.get(0).getId()));
        assertEquals("test_date", fetchedImgwHydroKroscienko.get(0).getLocalObservationDateTimeDto());
        assertEquals("test_weather", fetchedImgwHydroKroscienko.get(0).getWeatherDto());
        assertEquals("test_precipitation", fetchedImgwHydroKroscienko.get(0).getPrecipitationDto());
        assertEquals(new AccuTemperatureKroscienkoDto(new AccuMetricKroscienkoDto(10.5)), fetchedImgwHydroKroscienko.get(0).getAccuTemperatureDto());
    }

    @Test
    public void shouldReturnKroscienkoEmptyList() throws URISyntaxException {
        //Given & When
        List <AccuWeatherKroscienkoDto> fetchedImgwHydroKroscienko = accuweatherClient.getWeatherKroscienko();

        //Then
        assertEquals(0, fetchedImgwHydroKroscienko.size());
    }

    @Test
    public void shouldFetchgetWeatherGolkowice() throws URISyntaxException {
        //Given
        when(accuweatherConfig.getAccuweatherStationGolkowice()).thenReturn("test");

        AccuweatherGolkowiceDto[] accuweatherGolkowiceDtos = new AccuweatherGolkowiceDto[1];
        accuweatherGolkowiceDtos[0] = new AccuweatherGolkowiceDto(1L, "test_date", "test_weather",
                "test_precipitation", new AccuTemperatureGolkowiceDto(new AccuMetricGolkowiceDto(10.5)));

        URI url = new URI("http://test.com/test?apikey=test&language=test");

        when(restTemplate.getForObject(url, AccuweatherGolkowiceDto[].class)).thenReturn(accuweatherGolkowiceDtos);

        //When
        List <AccuweatherGolkowiceDto> fetchedImgwHydroGolkowice = accuweatherClient.getWeatherGolkowice();

        //Then
        assertEquals(1, fetchedImgwHydroGolkowice.size());
        assertEquals(java.util.Optional.of(1L), java.util.Optional.of(fetchedImgwHydroGolkowice.get(0).getId()));
        assertEquals("test_date", fetchedImgwHydroGolkowice.get(0).getLocalObservationDateTimeDto());
        assertEquals("test_weather", fetchedImgwHydroGolkowice.get(0).getWeatherDto());
        assertEquals("test_precipitation", fetchedImgwHydroGolkowice.get(0).getPrecipitationDto());
        assertEquals(new AccuTemperatureGolkowiceDto(new AccuMetricGolkowiceDto(10.5)), fetchedImgwHydroGolkowice.get(0).getAccuTemperatureGolkowiceDto());
    }

    @Test
    public void shouldReturnGolkowiceEmptyList() throws URISyntaxException {
        //Given & When
        List <AccuweatherGolkowiceDto> fetchedImgwHydroGolkowice = accuweatherClient.getWeatherGolkowice();

        //Then
        assertEquals(0, fetchedImgwHydroGolkowice.size());
    }
}