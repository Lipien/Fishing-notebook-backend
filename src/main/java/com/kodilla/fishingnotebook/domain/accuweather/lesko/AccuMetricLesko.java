package com.kodilla.fishingnotebook.domain.accuweather.lesko;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class AccuMetricLesko {

    private double value;
}
