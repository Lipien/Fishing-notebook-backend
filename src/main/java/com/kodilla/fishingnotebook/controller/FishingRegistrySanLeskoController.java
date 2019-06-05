package com.kodilla.fishingnotebook.controller;

import com.kodilla.fishingnotebook.domain.registry.SanLeskoRegistry;
import com.kodilla.fishingnotebook.service.DbServiceFishingRegistrySanLeskoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/registry")
public class FishingRegistrySanLeskoController {

    @Autowired
    private DbServiceFishingRegistrySanLeskoRepository dbServiceFishingRegistrySanLeskoRepository;

    @GetMapping(value = "getSanLeskoRegistry")
    public List <SanLeskoRegistry> getSanLeskoRegistry() {
        return dbServiceFishingRegistrySanLeskoRepository.getAllFish();
    }
}
