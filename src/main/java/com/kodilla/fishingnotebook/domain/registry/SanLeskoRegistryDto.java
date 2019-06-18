package com.kodilla.fishingnotebook.domain.registry;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SanLeskoRegistryDto {

    private Long id;

    private String catchDate;

    private String fishType;

    private String length;

    private String qty;
}
