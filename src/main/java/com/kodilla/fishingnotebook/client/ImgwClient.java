package com.kodilla.fishingnotebook.client;

import com.kodilla.fishingnotebook.config.ImgwConfig;
import com.kodilla.fishingnotebook.domain.imgw.ImgwDto;
import com.kodilla.fishingnotebook.mapper.ImgwMapper;
import com.kodilla.fishingnotebook.service.DbService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Optional.ofNullable;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class ImgwClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(ImgwClient.class);

    @Autowired
    private ImgwConfig imgwConfig;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DbService dbService;

    @Autowired
    private ImgwMapper imgwMapper;

    public List <ImgwDto> getImgwStations() {

        URI url = UriComponentsBuilder.fromHttpUrl(imgwConfig.getImgwApiEndpoint())
                .build()
                .encode()
                .toUri();
        try {
            ImgwDto[] imgwResponse = restTemplate.getForObject(url, ImgwDto[].class);
            return Arrays.asList(ofNullable(imgwResponse).orElse(new ImgwDto[0]));
        } catch (RestClientException e) {
            LOGGER.error(e.getMessage(), e);
            return new ArrayList <>();
        }
    }
}

