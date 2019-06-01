package com.kodilla.fishingnotebook.service;

import com.kodilla.fishingnotebook.domain.Accuweather;
import com.kodilla.fishingnotebook.domain.Imgw;
import com.kodilla.fishingnotebook.repository.AccuWeatherRepository;
import com.kodilla.fishingnotebook.repository.ImgwRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class DbService {
    @Autowired
    private ImgwRepository imgwRepository;

    @Autowired
    private AccuWeatherRepository accuWeatherRepository;

    public Imgw saveImgwStations(final Imgw imgw) {
        return imgwRepository.save(imgw);
    }

    public Accuweather saveAccuWeather(final Accuweather accuweather) {
        return accuWeatherRepository.save(accuweather);
    }
}
