package com.kodilla.fishingnotebook.service;

import com.kodilla.fishingnotebook.domain.Accuweather;
import com.kodilla.fishingnotebook.domain.Imgw;
import com.kodilla.fishingnotebook.domain.Kroscienko.AccuWeatherKroscienko;
import com.kodilla.fishingnotebook.domain.Lesko.AccuWeatherLesko;
import com.kodilla.fishingnotebook.repository.AccuWeatherRepository;
import com.kodilla.fishingnotebook.repository.AccuWeatherRepositoryLesko;
import com.kodilla.fishingnotebook.repository.AccuweatherRepositoryKroscienko;
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

    @Autowired
    private AccuweatherRepositoryKroscienko accuweatherRepositoryKroscienko;

    @Autowired
    private AccuWeatherRepositoryLesko accuWeatherRepositoryLesko;

    public Imgw saveImgwStations(final Imgw imgw) {
        return imgwRepository.save(imgw);
    }

    public Accuweather saveAccuWeather(final Accuweather accuweather) {
        return accuWeatherRepository.save(accuweather);
    }

    public AccuWeatherKroscienko saveAccuWeatherKroscienko(final AccuWeatherKroscienko accuWeatherKroscienko) {
        return accuweatherRepositoryKroscienko.save(accuWeatherKroscienko);
    }

    public AccuWeatherLesko saveAccuWeatherLesko(final AccuWeatherLesko accuWeatherLesko) {
        return accuWeatherRepositoryLesko.save(accuWeatherLesko);
    }
}
