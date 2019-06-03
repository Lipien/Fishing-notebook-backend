package com.kodilla.fishingnotebook.controller;

import com.kodilla.fishingnotebook.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/notebook")
public class NotebookController {

    @Autowired
    private DbService dbService;

    @GetMapping(value = "getSanLeskoWater")
    public String getSanLeskoWater() {
        return dbService.getSanLeskoWaterLevel();
    }

    @GetMapping(value = "getDunajecKroscienkoWater")
    public String getDunajecKroscienkoWater() {
        return dbService.getDunajecKroscienkoWaterLevel();
    }

    @GetMapping(value = "getDunajecGolokowiceWater")
    public String getDunajecGolokowiceWater() {
        return dbService.getDunajecGolkowiceWaterLevel();
    }

    @GetMapping(value = "getSanLeskoWeather")
    public String getSanLeskoWeather() {
        return dbService.getSanLeskoWeather();
    }

    @GetMapping(value = "getDunajecKroscienkoWeather")
    public String getDunajecKroscienkoWeather() {
        return dbService.getDunajecKroscienkoWeather();
    }

    @GetMapping(value = "getDunajecGolkowiceWeather")
    public String getDunajecGolkowiceWeather() {
        return dbService.getDunajecGolkowiceWeather();
    }
}