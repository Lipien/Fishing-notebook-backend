package com.kodilla.fishingnotebook.domain.accuweather.kroscienko;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class AccuTemperatureKroscienko {

    @Embedded
    private AccuMetricKroscienko accuMetricKroscienko;
}
