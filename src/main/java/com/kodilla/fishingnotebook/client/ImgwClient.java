package com.kodilla.fishingnotebook.client;

import com.kodilla.fishingnotebook.domain.ImgwDto;
import com.kodilla.fishingnotebook.mapper.ImgwMapper;
import com.kodilla.fishingnotebook.service.DbService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class ImgwClient {

    @Value("${imgw.api.endpoint.hydro}")
    private String imgwEndpoint;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DbService dbService;

    @Autowired
    private ImgwMapper imgwMapper;

    public List <ImgwDto> getImgwStations() {
        ImgwDto[] imgwResponse = restTemplate.getForObject(
                imgwEndpoint,
                ImgwDto[].class);

        if (imgwResponse != null) {
            return Arrays.asList(imgwResponse);
        }
        return new ArrayList <>();
    }
}

