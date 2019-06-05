package com.kodilla.fishingnotebook.repository.weatherRepositories;

import com.kodilla.fishingnotebook.domain.kroscienko.AccuWeatherKroscienko;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface AccuweatherRepositoryKroscienko extends CrudRepository <AccuWeatherKroscienko, Long> {

    List <AccuWeatherKroscienko> save(List <AccuWeatherKroscienko> accuweathers);

    @Modifying
    @Transactional
    @Query("delete from accuweather_kroscienko")
    void deleteAllWithQuery();

    @Query(value = "SELECT local_observation_date_time, has_precipitation, value, weather_text FROM hydro_imgw.accuweather_kroscienko", nativeQuery = true)
    String retrieveDunajecKroscienkoWeather();
}
