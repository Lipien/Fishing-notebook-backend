package com.kodilla.fishingnotebook.domain.registry;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity(name = "registry_golkowice")
public class DunajecGolkowiceRegistry {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "catch_date")
    private String catchDate;

    @Column(name = "fish_type")
    private String fishType;

    @Column(name = "length")
    private String length;

    @Column(name = "qty")
    private String qty;
}
