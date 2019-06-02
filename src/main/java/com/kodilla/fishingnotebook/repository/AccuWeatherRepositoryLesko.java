package com.kodilla.fishingnotebook.repository;

import com.kodilla.fishingnotebook.domain.lesko.AccuWeatherLesko;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AccuWeatherRepositoryLesko extends CrudRepository <AccuWeatherLesko, Long> {

    List <AccuWeatherLesko> save(List <AccuWeatherLesko> accuweathersLesko);
}
