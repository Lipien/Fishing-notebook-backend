package com.kodilla.fishingnotebook.repository;

import com.kodilla.fishingnotebook.domain.Imgw;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ImgwRepository extends CrudRepository <Imgw, String> {

    List <Imgw> save(List <Imgw> imgw);
}
