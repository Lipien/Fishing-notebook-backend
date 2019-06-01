package com.kodilla.fishingnotebook.mapper;

import com.kodilla.fishingnotebook.domain.Imgw;
import com.kodilla.fishingnotebook.domain.ImgwDto;
import org.springframework.stereotype.Component;

@Component
public class ImgwMapper {
    public Imgw mapToImgw(final ImgwDto imgwDto) {
        return new Imgw(
                imgwDto.getId_stacji(),
                imgwDto.getStacja(),
                imgwDto.getRzeka(),
                imgwDto.getStanWody(),
                imgwDto.getStanWodyDataPomiaru());
    }
}
