package com.kodilla.fishingnotebook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DbServiceFacade {

    @Autowired
    private DbService dbService;

    public List <String> getWeatherAndHydroReport() {

        List <String> report = new ArrayList <>();

        report.add("San Lesko water level: " + dbService.getSanLeskoWaterLevel() + "cm;" +
                " weather conditions: " + dbService.getSanLeskoWeather() + ".");

        report.add("Dunajec Krościenko water level: " + dbService.getDunajecKroscienkoWaterLevel() + "cm;" +
                " weather conditions: " + dbService.getDunajecKroscienkoWeather() + ".");

        report.add("Dunajec Gołkowice water level: " + dbService.getDunajecGolkowiceWaterLevel() + "cm;" +
                " weather conditions: " + dbService.getDunajecGolkowiceWeather() + ".");

        return report;
    }
}
