package com.kodilla.fishingnotebook.mapper;

import com.kodilla.fishingnotebook.domain.Imgw;
import com.kodilla.fishingnotebook.domain.ImgwDto;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;

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

    public Imgw mapToImgwDto(final Imgw imgw) {
        return new Imgw(
                imgw.getId_stacji(),
                imgw.getStacja(),
                imgw.getRzeka(),
                imgw.getStanWody(),
                imgw.getStanWodyDataPomiaru());
    }

    public List <Imgw> mapToImgwList(final List <ImgwDto> imgwDtoLists) {
        return imgwDtoLists.stream()
                .map(imgwDto -> new Imgw(imgwDto.getId_stacji(),
                        imgwDto.getStacja(),
                        imgwDto.getRzeka(),
                        imgwDto.getStanWody(),
                        imgwDto.getStanWodyDataPomiaru()))
                .collect(toList());
    }
}
