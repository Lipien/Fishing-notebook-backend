package com.kodilla.fishingnotebook.controller;

import com.kodilla.fishingnotebook.service.DbServiceFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/report")
public class HydroAndWeatherController {

    @Autowired
    private DbServiceFacade dbServiceFacade;

    @GetMapping(value = "getFishingConditionsReport")
    public List <String> getFishingConditionsReport() {
        return dbServiceFacade.getWeatherAndHydroReport();
    }
}