package com.kodilla.fishingnotebook.repository;

import com.kodilla.fishingnotebook.domain.lesko.AccuWeatherLesko;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface AccuWeatherRepositoryLesko extends CrudRepository <AccuWeatherLesko, Long> {

    List <AccuWeatherLesko> save(List <AccuWeatherLesko> accuweathersLesko);

    @Modifying
    @Transactional
    @Query("delete from accuweather_lesko")
    void deleteAllWithQuery();
}
