package com.kodilla.fishingnotebook.mapper;

import com.kodilla.fishingnotebook.domain.imgw.Imgw;
import com.kodilla.fishingnotebook.domain.imgw.ImgwDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class ImgwMapperTest {

    @InjectMocks
    private ImgwMapper imgwMapper;

    @Test
    public void mapToImgw() {
        //Given
        ImgwDto imgwDto = new ImgwDto("id", "stacja", "rzeka", "stanWody", "stanWodyDataPomiaru");

        //When
        Imgw imgwResult = imgwMapper.mapToImgw(imgwDto);

        //Then
        assertEquals(imgwDto.getIdStacji(), imgwResult.getIdStacji());
        assertEquals(imgwDto.getStacja(), imgwResult.getStacja());
        assertEquals(imgwDto.getRzeka(), imgwResult.getRzeka());
        assertEquals(imgwDto.getStanWody(), imgwResult.getStanWody());
        assertEquals(imgwDto.getStanWodyDataPomiaru(), imgwResult.getStanWodyDataPomiaru());
    }
}