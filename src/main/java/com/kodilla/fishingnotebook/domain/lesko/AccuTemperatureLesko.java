package com.kodilla.fishingnotebook.domain.lesko;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class AccuTemperatureLesko {

    @Embedded
    private AccuMetricLesko accuMetric;
}