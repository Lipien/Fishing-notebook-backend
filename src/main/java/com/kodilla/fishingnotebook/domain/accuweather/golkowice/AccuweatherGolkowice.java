package com.kodilla.fishingnotebook.domain.accuweather.golkowice;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity(name = "accuweather_golkowice")
public class AccuweatherGolkowice {

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
    public AccuTemperatureGolkowice temperature;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AccuweatherGolkowice that = (AccuweatherGolkowice) o;

        return getTemperature().equals(that.getTemperature());
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}


