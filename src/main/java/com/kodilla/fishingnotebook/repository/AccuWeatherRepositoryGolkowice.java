package com.kodilla.fishingnotebook.repository;

import com.kodilla.fishingnotebook.domain.golkowice.AccuweatherGolkowice;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface AccuWeatherRepositoryGolkowice extends CrudRepository <AccuweatherGolkowice, String> {

    List <AccuweatherGolkowice> save(List <AccuweatherGolkowice> accuweatherGolkowices);

    @Modifying
    @Transactional
    @Query("delete from accuweather_golkowice")
    void deleteAllWithQuery();
}
