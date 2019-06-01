package com.kodilla.fishingnotebook.repository;

import com.kodilla.fishingnotebook.domain.Accuweather;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AccuWeatherRepository extends CrudRepository <Accuweather, String> {

    List <Accuweather> save(List <Accuweather> accuweathers);
}
