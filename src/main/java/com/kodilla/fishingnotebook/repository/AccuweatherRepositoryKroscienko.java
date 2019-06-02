package com.kodilla.fishingnotebook.repository;

import com.kodilla.fishingnotebook.domain.kroscienko.AccuWeatherKroscienko;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AccuweatherRepositoryKroscienko extends CrudRepository <AccuWeatherKroscienko, Long> {

    List <AccuWeatherKroscienko> save(List <AccuWeatherKroscienko> accuweathers);
}
