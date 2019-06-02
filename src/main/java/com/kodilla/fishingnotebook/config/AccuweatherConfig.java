package com.kodilla.fishingnotebook.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class AccuweatherConfig {

    @Value("${accuweather.api.prod}")
    private String accuweatherApiEndpoint;

    @Value("${accuweather.api.key}")
    private String accuweatherAppKey;

    @Value("${accuweather.api.language}")
    private String accuweatherApiLanguage;

    @Value("${accuweather.api.station.dunajec.kroscienko}")
    private String accuweatherStationKroscienko;

    @Value("${accuweather.api.station.dunajec.golkowice}")
    private String accuweatherStationGolkowice;

    @Value("${accuweather.api.station.san.lesko}")
    private String accuweatherStationLesko;
}
