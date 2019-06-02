package com.kodilla.fishingnotebook.repository;

import com.kodilla.fishingnotebook.domain.golkowice.AccuweatherGolkowice;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AccuWeatherRepositoryGolkowice extends CrudRepository <AccuweatherGolkowice, String> {

    List <AccuweatherGolkowice> save(List <AccuweatherGolkowice> accuweatherGolkowices);
}
