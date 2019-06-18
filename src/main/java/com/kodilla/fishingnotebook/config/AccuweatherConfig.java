package com.kodilla.fishingnotebook.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class AccuweatherConfig {

   //@Value("${accuweather.api.prod}")
    private String accuweatherApiEndpoint = "http://dataservice.accuweather.com/currentconditions/v1/";

    //@Value("${accuweather.api.key}")
    private String accuweatherAppKey = "Bx3XRoUI6nyFsvoFMmOE62ijlUbJOMsl";

//    @Value("${accuweather.api.language}")
    private String accuweatherApiLanguage = "en-us";

//    @Value("${accuweather.api.station.dunajec.kroscienko}")
    private String accuweatherStationKroscienko = "268277";

//    @Value("${accuweather.api.station.dunajec.golkowice}")
    private String accuweatherStationGolkowice = "2718104";

//    @Value("${accuweather.api.station.san.lesko}")
    private String accuweatherStationLesko = "1400917";
}
