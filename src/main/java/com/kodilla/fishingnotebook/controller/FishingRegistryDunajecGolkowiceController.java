package com.kodilla.fishingnotebook.controller;

import com.kodilla.fishingnotebook.domain.registry.DunajecGolkowiceRegistry;
import com.kodilla.fishingnotebook.domain.registry.DunajecGolkowiceRegistryDto;
import com.kodilla.fishingnotebook.mapper.registry.FishingRegistryDunajecGolkowiceMapper;
import com.kodilla.fishingnotebook.service.DbServiceFishingRegistryDunajecGolkowiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/registry")
public class FishingRegistryDunajecGolkowiceController {

    @Autowired
    DbServiceFishingRegistryDunajecGolkowiceRepository dbServiceFishingRegistryDunajecGolkowiceRepository;

    @Autowired
    FishingRegistryDunajecGolkowiceMapper fishingRegistryDunajecGolkowiceMapper;

    @GetMapping(value = "getDunajecGolkowiceRegistry")
    public List <DunajecGolkowiceRegistry> getDunajecGolkowiceRegistry() {
        return dbServiceFishingRegistryDunajecGolkowiceRepository.getAllFish();
    }

    @PostMapping(value = "createDunajecGolkowiceRegistry")
    public void createDunajecGolkowiceRegistry(@RequestBody DunajecGolkowiceRegistryDto dunajecGolkowiceRegistryDto) {
        dbServiceFishingRegistryDunajecGolkowiceRepository.saveFish(fishingRegistryDunajecGolkowiceMapper.mapToDunajecGolkowice(dunajecGolkowiceRegistryDto));
    }
}
