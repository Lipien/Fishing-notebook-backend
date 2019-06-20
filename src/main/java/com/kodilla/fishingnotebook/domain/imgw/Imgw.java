package com.kodilla.fishingnotebook.domain.imgw;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity(name = "waterstations")
public class Imgw {

    @Id
    @Column(name = "id_stacji")
    private String idStacji;

    @Column(name = "stacja")
    private String stacja;

    @Column(name = "rzeka")
    private String rzeka;

    @Column(name = "stan_wody")
    private String stanWody;

    @Column(name = "stan_wody_data_pomiaru")
    private String stanWodyDataPomiaru;
}
