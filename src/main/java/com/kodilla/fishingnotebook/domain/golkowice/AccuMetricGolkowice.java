package com.kodilla.fishingnotebook.domain.golkowice;

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
}
