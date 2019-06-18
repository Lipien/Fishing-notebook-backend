package com.kodilla.fishingnotebook.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class ImgwConfig {

    @Value(value = "${imgw.api.endpoint.hydro}")
    private String imgwApiEndpoint; //= "https://danepubliczne.imgw.pl/api/data/hydro/";
}
