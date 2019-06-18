package com.kodilla.fishingnotebook.controller;

import com.kodilla.fishingnotebook.client.AccuweatherClient;
import com.kodilla.fishingnotebook.config.AccuweatherConfig;
import com.kodilla.fishingnotebook.domain.accuweather.golkowice.*;
import com.kodilla.fishingnotebook.mapper.accuweather.AccuweatherMapperGolkowice;
import com.kodilla.fishingnotebook.mapper.accuweather.AccuweatherMapperKroscienko;
import com.kodilla.fishingnotebook.mapper.accuweather.AccuweatherMapperLesko;
import com.kodilla.fishingnotebook.service.DbService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebMvcTest(AccuweatherController.class)
public class AccuweatherControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AccuweatherClient accuweatherClient;

    @MockBean
    private AccuweatherMapperGolkowice accuweatherMapperGolkowice;

    @MockBean
    private AccuweatherMapperKroscienko accuweatherMapperKroscienko;

    @MockBean
    private AccuweatherMapperLesko accuweatherMapperLesko;

    @MockBean
    private DbService dbService;

    @Test
    public void getWeatherGolkowice() throws Exception {
        //Given
        AccuweatherGolkowiceDto accuweatherGolkowiceDto = new AccuweatherGolkowiceDto(1L, "test_date", "test_weather",
                "test_precipitation", new AccuTemperatureGolkowiceDto(new AccuMetricGolkowiceDto(11.5)));
        List <AccuweatherGolkowiceDto> accuweatherGolkowiceDtos = new ArrayList <>();
        accuweatherGolkowiceDtos.add(accuweatherGolkowiceDto);

        //When

    }

    /*public void getWeatherGolkowice() {

        List <AccuweatherGolkowiceDto> weatherData = accuweatherClient.getWeatherGolkowice();

        weatherData.forEach((temp) ->
                dbService.saveAccuWeather(accuweatherMapperGolkowice.mapToAccuweather(temp)));
    }*/

    @Test
    public void getWeatherLesko() throws Exception {
    }

    @Test
    public void getWeatherKroscienko() throws Exception{
    }
}