package com.kodilla.fishingnotebook.client;

import com.kodilla.fishingnotebook.config.AccuweatherConfig;
import com.kodilla.fishingnotebook.domain.golkowice.AccuweatherGolkowiceDto;
import com.kodilla.fishingnotebook.domain.kroscienko.AccuWeatherKroscienkoDto;
import com.kodilla.fishingnotebook.domain.lesko.AccuWeatherLeskoDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class AccuweatherClient {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private AccuweatherConfig accuweatherConfig;

    public List <AccuweatherGolkowiceDto> getWeatherGolkowice() {

        URI url = UriComponentsBuilder.fromHttpUrl(accuweatherConfig.getAccuweatherApiEndpoint() + accuweatherConfig.getAccuweatherStationGolkowice())
                .queryParam("apikey", accuweatherConfig.getAccuweatherAppKey())
                .queryParam("language", accuweatherConfig.getAccuweatherApiLanguage())
                .build()
                .encode()
                .toUri();

        AccuweatherGolkowiceDto[] accuResponse = restTemplate.getForObject(url,
                AccuweatherGolkowiceDto[].class);

        if (accuResponse != null) {
            return Arrays.asList(accuResponse);
        }
        return new ArrayList <>();
    }

    public List <AccuWeatherLeskoDto> getWeatherLesko() {

        URI url = UriComponentsBuilder.fromHttpUrl(accuweatherConfig.getAccuweatherApiEndpoint() + accuweatherConfig.getAccuweatherStationLesko())
                .queryParam("apikey", accuweatherConfig.getAccuweatherAppKey())
                .queryParam("language", accuweatherConfig.getAccuweatherApiLanguage())
                .build()
                .encode()
                .toUri();

        AccuWeatherLeskoDto[] accuResponse = restTemplate.getForObject(url,
                AccuWeatherLeskoDto[].class);

        if (accuResponse != null) {
            return Arrays.asList(accuResponse);
        }
        return new ArrayList <>();
    }

    public List <AccuWeatherKroscienkoDto> getWeatherKroscienko() {

        URI url = UriComponentsBuilder.fromHttpUrl(accuweatherConfig.getAccuweatherApiEndpoint() + accuweatherConfig.getAccuweatherStationKroscienko())
                .queryParam("apikey", accuweatherConfig.getAccuweatherAppKey())
                .queryParam("language", accuweatherConfig.getAccuweatherApiLanguage())
                .build()
                .encode()
                .toUri();

        AccuWeatherKroscienkoDto[] accuResponse = restTemplate.getForObject(url,
                AccuWeatherKroscienkoDto[].class);

        if (accuResponse != null) {
            return Arrays.asList(accuResponse);
        }
        return new ArrayList <>();
    }
}