package com.kodilla.fishingnotebook.mapper;

import com.kodilla.fishingnotebook.domain.Imgw;
import com.kodilla.fishingnotebook.domain.ImgwDto;
import org.springframework.stereotype.Component;

@Component
public class ImgwMapper {
    public Imgw mapToImgw(final ImgwDto imgwDto){
        return new Imgw(
                imgwDto.getIdStacji(),
                imgwDto.getStacja(),
                imgwDto.getRzeka(),
                imgwDto.getStanWody(),
                imgwDto.getStanWodyDataPomiaru());
    }

    public Imgw mapToImgwDto(final Imgw imgw){
        return new Imgw(
                imgw.getIdStacji(),
                imgw.getStacja(),
                imgw.getRzeka(),
                imgw.getStanWody(),
                imgw.getStanWodyDataPomiaru());
    }
}
