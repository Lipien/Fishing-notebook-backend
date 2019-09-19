package com.kodilla.fishingnotebook.repository.weatherrepositories;

import com.kodilla.fishingnotebook.domain.accuweather.lesko.AccuWeatherLesko;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface AccuWeatherRepositoryLesko extends CrudRepository <AccuWeatherLesko, Long> {

    List <AccuWeatherLesko> save(List <AccuWeatherLesko> accuweathersLesko);

    @Modifying
    @Transactional
    @Query("delete from accuweather_lesko")
    void deleteAllWithQuery();

    @Query(value = "SELECT local_observation_date_time, has_precipitation, value, weather_text FROM accuweather_lesko", nativeQuery = true)
    String retrieveSanLeskoWeather();
}
