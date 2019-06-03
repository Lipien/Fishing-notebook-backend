package com.kodilla.fishingnotebook.repository;

import com.kodilla.fishingnotebook.domain.Imgw;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface ImgwRepository extends CrudRepository <Imgw, String> {

    List <Imgw> save(List <Imgw> imgw);

    @Query(value = "SELECT stan_wody FROM hydro_imgw.waterstations WHERE id_stacji = 149220060", nativeQuery = true)
    String retrieveSanLeskoWaterLevel();

    @Query(value = "SELECT stan_wody FROM hydro_imgw.waterstations WHERE id_stacji = 149200160", nativeQuery = true)
    String retrieveDunajecKroscienkoWaterLevel();

    @Query(value = "SELECT stan_wody FROM hydro_imgw.waterstations WHERE id_stacji = 149200190", nativeQuery = true)
    String retrieveDunajecGolkowiceWaterLevel();
}
