package com.kodilla.fishingnotebook.controller;

import com.kodilla.fishingnotebook.domain.registry.DunajecGolkowiceRegistry;
import com.kodilla.fishingnotebook.service.DbServiceFishingRegistryDunajecGolkowiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/registry")
public class FishingRegistryDunajecGolkowiceController {

    @Autowired
    DbServiceFishingRegistryDunajecGolkowiceRepository dbServiceFishingRegistryDunajecGolkowiceRepository;

    @GetMapping(value = "getDunajecGolkowiceRegistry")
    public List <DunajecGolkowiceRegistry> getDunajecGolkowiceRegistry() {
        return dbServiceFishingRegistryDunajecGolkowiceRepository.getAllFish();
    }
}
