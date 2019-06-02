package com.kodilla.fishingnotebook.domain.Kroscienko;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity(name = "accuweather_kroscienko")
public class AccuWeatherKroscienko {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "LocalObservationDateTime")
    private String localObservationDateTime;

    @Column(name = "WeatherText")
    private String weather;

    @Column(name = "HasPrecipitation")
    private String precipitation;

    @Embedded
    @Column(name = "Temperature")
    public AccuTemperatureKroscienko temperature;
}
