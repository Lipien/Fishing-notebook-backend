package com.kodilla.fishingnotebook.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity(name = "accuweather")
public class Accuweather {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "LocalObservationDateTime")
    private String localObservationDateTime;

    @Column(name = "WeatherText")
    private String weather;

    @Column(name = "HasPrecipitation")
    private String precipitation;

    @Transient
    private AccuTemperature temperature;

    @Column(name = "Temperature")
    private String getTemperature(){
        return String.valueOf(temperature.getAccuMetric());
    }

    /*"LocalObservationDateTime": "2019-05-31T14:30:00+02:00",
    "EpochTime": 1559305800,
    "WeatherText": "Chmury i słońce",
    "WeatherIcon": 4,
    "HasPrecipitation": false,
    "PrecipitationType": null,
    "IsDayTime": true,
    "Temperature": {
      "Metric": {
        "Value": 18.7,
        "Unit": "C",*/
}


