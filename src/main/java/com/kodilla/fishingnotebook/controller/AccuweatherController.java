package com.kodilla.fishingnotebook.controller;

import com.kodilla.fishingnotebook.client.AccuweatherClient;
import com.kodilla.fishingnotebook.domain.AccuweatherDto;
import com.kodilla.fishingnotebook.mapper.AccuweatherMapper;
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
      private AccuweatherMapper accuweatherMapper;

    @Autowired
    private DbService dbService;

    @GetMapping(value = "getWeather")
    public void getWeather() {

        List <AccuweatherDto> weatherData = accuweatherClient.getWeather();

        weatherData.forEach((temp) ->
                dbService.saveAccuWeather(accuweatherMapper.mapToAccuweather(temp)));
    }
}
