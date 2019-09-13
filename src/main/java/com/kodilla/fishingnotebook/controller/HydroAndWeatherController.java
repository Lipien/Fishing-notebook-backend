package com.kodilla.fishingnotebook.controller;

import com.kodilla.fishingnotebook.service.DbService;
import com.kodilla.fishingnotebook.service.DbServiceFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/report")
public class HydroAndWeatherController {

    @Autowired
    private DbServiceFacade dbServiceFacade;

    @Autowired
    private DbService dbService;

    @GetMapping(value = "getFishingConditionsReport")
    public String getFishingConditionsReport() {
        return dbService.getSanLeskoWeather();
    }
}