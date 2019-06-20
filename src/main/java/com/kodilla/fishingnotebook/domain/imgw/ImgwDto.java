package com.kodilla.fishingnotebook.domain.imgw;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Component
public class ImgwDto {

    @JsonProperty("id_stacji")
    private String idStacji;

    @JsonProperty("stacja")
    private String stacja;

    @JsonProperty("rzeka")
    private String rzeka;

    @JsonProperty("stan_wody")
    private String stanWody;

    @JsonProperty("stan_wody_data_pomiaru")
    private String stanWodyDataPomiaru;
}
