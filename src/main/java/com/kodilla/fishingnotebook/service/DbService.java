package com.kodilla.fishingnotebook.service;

import com.kodilla.fishingnotebook.domain.Imgw;
import com.kodilla.fishingnotebook.repository.ImgwRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class DbService {
    @Autowired
    private ImgwRepository repository;

    public List <Imgw> saveImgwStations(final List <Imgw> imgw) {
        return repository.save(imgw);
    }
}
