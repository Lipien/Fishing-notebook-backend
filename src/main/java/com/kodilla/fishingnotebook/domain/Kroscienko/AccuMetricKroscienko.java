package com.kodilla.fishingnotebook.domain.Kroscienko;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class AccuMetricKroscienko {

    private double value;
}
