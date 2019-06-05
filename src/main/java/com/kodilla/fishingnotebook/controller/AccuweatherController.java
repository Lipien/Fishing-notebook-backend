package com.kodilla.fishingnotebook.controller;

import com.kodilla.fishingnotebook.client.AccuweatherClient;
import com.kodilla.fishingnotebook.domain.golkowice.AccuweatherGolkowiceDto;
import com.kodilla.fishingnotebook.domain.kroscienko.AccuWeatherKroscienkoDto;
import com.kodilla.fishingnotebook.domain.lesko.AccuWeatherLeskoDto;
import com.kodilla.fishingnotebook.mapper.accuweather.AccuweatherMapperGolkowice;
import com.kodilla.fishingnotebook.mapper.accuweather.AccuweatherMapperKroscienko;
import com.kodilla.fishingnotebook.mapper.accuweather.AccuweatherMapperLesko;
import com.kodilla.fishingnotebook.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/accuweather")
public class AccuweatherController {

    @Autowired
    private AccuweatherClient accuweatherClient;

    @Autowired
    private AccuweatherMapperGolkowice accuweatherMapperGolkowice;

    @Autowired
    private AccuweatherMapperKroscienko accuweatherMapperKroscienko;

    @Autowired
    private AccuweatherMapperLesko accuweatherMapperLesko;

    @Autowired
    private DbService dbService;

    @GetMapping(value = "getWeatherGolkowice")
    public void getWeatherGolkowice() {

        List <AccuweatherGolkowiceDto> weatherData = accuweatherClient.getWeatherGolkowice();

        weatherData.forEach((temp) ->
                dbService.saveAccuWeather(accuweatherMapperGolkowice.mapToAccuweather(temp)));
    }

    @GetMapping(value = "getWeatherLesko")
    public void getWeatherLesko() {

        List <AccuWeatherLeskoDto> weatherData = accuweatherClient.getWeatherLesko();

        weatherData.forEach((temp) ->
                dbService.saveAccuWeatherLesko(accuweatherMapperLesko.mapToAccuweatherLesko(temp)));
    }

    @GetMapping(value = "getWeatherKroscienko")
    public void getWeatherKroscienko() {

        List <AccuWeatherKroscienkoDto> weatherData = accuweatherClient.getWeatherKroscienko();

        weatherData.forEach((temp) ->
                dbService.saveAccuWeatherKroscienko(accuweatherMapperKroscienko.mapToAccuweatherKroscienko(temp)));
    }
}
