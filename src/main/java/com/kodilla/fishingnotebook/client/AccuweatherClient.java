package com.kodilla.fishingnotebook.client;

import com.kodilla.fishingnotebook.config.AccuweatherConfig;
import com.kodilla.fishingnotebook.domain.accuweather.golkowice.AccuweatherGolkowiceDto;
import com.kodilla.fishingnotebook.domain.accuweather.kroscienko.AccuWeatherKroscienkoDto;
import com.kodilla.fishingnotebook.domain.accuweather.lesko.AccuWeatherLeskoDto;
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
public class AccuweatherClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccuweatherClient.class);

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private AccuweatherConfig accuweatherConfig;

    private String apikey ="apikey";

    private String language = "language";



    public List <AccuWeatherLeskoDto> getWeatherLesko() {

        URI url = UriComponentsBuilder.fromHttpUrl(accuweatherConfig.getAccuweatherApiEndpoint() + accuweatherConfig.getAccuweatherStationLesko())
                .queryParam(apikey, accuweatherConfig.getAccuweatherAppKey())
                .queryParam(language, accuweatherConfig.getAccuweatherApiLanguage())
                .build()
                .encode()
                .toUri();

        try {
            AccuWeatherLeskoDto[] accuResponse = restTemplate.getForObject(url, AccuWeatherLeskoDto[].class);
            return Arrays.asList(ofNullable(accuResponse).orElse(new AccuWeatherLeskoDto[0]));
        } catch (RestClientException e) {
            LOGGER.error(e.getMessage(), e);
            return new ArrayList <>();
        }
    }

    public List <AccuWeatherKroscienkoDto> getWeatherKroscienko() {

        URI url = UriComponentsBuilder.fromHttpUrl(accuweatherConfig.getAccuweatherApiEndpoint() + accuweatherConfig.getAccuweatherStationKroscienko())
                .queryParam(apikey, accuweatherConfig.getAccuweatherAppKey())
                .queryParam(language, accuweatherConfig.getAccuweatherApiLanguage())
                .build()
                .encode()
                .toUri();

        try {
            AccuWeatherKroscienkoDto[] accuResponse = restTemplate.getForObject(url, AccuWeatherKroscienkoDto[].class);
            return Arrays.asList(ofNullable(accuResponse).orElse(new AccuWeatherKroscienkoDto[0]));
        } catch (RestClientException e) {
            LOGGER.error(e.getMessage(), e);
            return new ArrayList <>();
        }
    }

    public List <AccuweatherGolkowiceDto> getWeatherGolkowice() {

        URI url = UriComponentsBuilder.fromHttpUrl(accuweatherConfig.getAccuweatherApiEndpoint() + accuweatherConfig.getAccuweatherStationGolkowice())
                .queryParam(apikey, accuweatherConfig.getAccuweatherAppKey())
                .queryParam(language, accuweatherConfig.getAccuweatherApiLanguage())
                .build()
                .encode()
                .toUri();

        try {
            AccuweatherGolkowiceDto[] accuResponse = restTemplate.getForObject(url, AccuweatherGolkowiceDto[].class);
            return Arrays.asList(ofNullable(accuResponse).orElse(new AccuweatherGolkowiceDto[0]));
        } catch (RestClientException e) {
            LOGGER.error(e.getMessage(), e);
            return new ArrayList <>();
        }
    }
}

