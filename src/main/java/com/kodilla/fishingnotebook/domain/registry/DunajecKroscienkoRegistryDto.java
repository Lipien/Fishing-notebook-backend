package com.kodilla.fishingnotebook.domain.registry;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DunajecKroscienkoRegistryDto {

    private Long id;

    private String catchDate;

    private String fishType;

    private String length;

    private String qty;
}
