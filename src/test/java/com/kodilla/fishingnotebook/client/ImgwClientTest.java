package com.kodilla.fishingnotebook.client;

import com.kodilla.fishingnotebook.config.ImgwConfig;
import com.kodilla.fishingnotebook.domain.imgw.ImgwDto;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ImgwClientTest {

    @InjectMocks
    private ImgwClient imgwClient;

    @Mock
    private RestTemplate restTemplate;

    @Mock
    private ImgwConfig imgwConfig;

    @Before
    public void init() {
        when(imgwConfig.getImgwApiEndpoint()).thenReturn("http://test.com");
    }

    @Test
    public void shouldFetchImgwStationsHydroData() throws URISyntaxException {
        //Given
        ImgwDto[] imgwResponse = new ImgwDto[1];
        imgwResponse[0] = new ImgwDto("test_Id", "test_Station", "test_River", "test_Water_Level", "test_Date");

        URI url = new URI("http://test.com");

        when(restTemplate.getForObject(url, ImgwDto[].class)).thenReturn(imgwResponse);

        //When
        List <ImgwDto> fetchedImgwHydroStations = imgwClient.getImgwStations();

        //Then
        assertEquals(1, fetchedImgwHydroStations.size());
        assertEquals("test_Id", fetchedImgwHydroStations.get(0).getIdStacji());
        assertEquals("test_Station", fetchedImgwHydroStations.get(0).getStacja());
        assertEquals("test_River", fetchedImgwHydroStations.get(0).getRzeka());
        assertEquals("test_Water_Level", fetchedImgwHydroStations.get(0).getStanWody());
        assertEquals("test_Date", fetchedImgwHydroStations.get(0).getStanWodyDataPomiaru());
    }

    @Test
    public void shouldReturnEmptyList() throws URISyntaxException {
        // Given
        URI url = new URI("http://test.com");

        //When
        List <ImgwDto> fetchedImgwHydroStations = imgwClient.getImgwStations();

        //Then
        assertEquals(0, fetchedImgwHydroStations.size());
    }
}