package com.kodilla.fishingnotebook.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ImgwDto {

    @JsonProperty("id_stacji")
    private String idStacji;

    @JsonProperty("stacja")
    private String stacja;

    @JsonProperty("rzeka")
    private String rzeka;

//    private String wojewodztwo;

    @JsonProperty("stan_wody")
    private String stanWody;

    @JsonProperty("stan_wody_data_pomiaru")
    private String stanWodyDataPomiaru;

/*    private String temperaturaWody;
    private String temperaturaWodyDataPomiaru;
    private String zjawiskoLodowe;
    private String zjawiskoLodoweDataPomiaru;
    private String zjawiskoZarastania;
    private String zjawiskoZarastaniaDataPomiaru;*/
}
