package com.kodilla.fishingnotebook.repository;

import com.kodilla.fishingnotebook.domain.kroscienko.AccuWeatherKroscienko;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface AccuweatherRepositoryKroscienko extends CrudRepository <AccuWeatherKroscienko, Long> {

    List <AccuWeatherKroscienko> save(List <AccuWeatherKroscienko> accuweathers);

    @Modifying
    @Transactional
    @Query("delete from accuweather_kroscienko")
    void deleteAllWithQuery();
}
