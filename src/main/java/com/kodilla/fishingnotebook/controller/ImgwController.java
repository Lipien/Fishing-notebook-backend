package com.kodilla.fishingnotebook.controller;

import com.kodilla.fishingnotebook.client.ImgwClient;
import com.kodilla.fishingnotebook.domain.ImgwDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/hydro")
public class ImgwController {

    @Autowired
    private ImgwClient imgwClient;

    @GetMapping(value = "getHydro")
    public void getHydro() {

        List <ImgwDto> hydroData = imgwClient.getImgwStations();

        hydroData.forEach(imgwDto ->
                System.out.println(imgwDto.getRzeka() + " " + imgwDto.getStanWody()));
    }
}
