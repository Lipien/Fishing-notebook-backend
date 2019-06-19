package com.kodilla.fishingnotebook.domain.accuweather.golkowice;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class AccuTemperatureGolkowice {

    @Embedded
    private AccuMetricGolkowice accuMetricGolkowice;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AccuTemperatureGolkowice that = (AccuTemperatureGolkowice) o;

        return getAccuMetricGolkowice().equals(that.getAccuMetricGolkowice());
    }
}
