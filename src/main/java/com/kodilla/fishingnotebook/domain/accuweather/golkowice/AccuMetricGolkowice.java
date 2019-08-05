package com.kodilla.fishingnotebook.domain.accuweather.golkowice;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class AccuMetricGolkowice {
    private double value;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AccuMetricGolkowice that = (AccuMetricGolkowice) o;

        return Double.compare(that.getValue(), getValue()) == 0;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
