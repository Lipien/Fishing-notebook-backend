package com.kodilla.fishingnotebook.domain.golkowice;

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
}
