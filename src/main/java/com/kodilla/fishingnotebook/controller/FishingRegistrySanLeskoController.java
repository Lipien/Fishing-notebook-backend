package com.kodilla.fishingnotebook.controller;

import com.kodilla.fishingnotebook.domain.registry.SanLeskoRegistry;
import com.kodilla.fishingnotebook.domain.registry.SanLeskoRegistryDto;
import com.kodilla.fishingnotebook.mapper.registry.FishingRegistrySanLeskoMapper;
import com.kodilla.fishingnotebook.service.DbServiceFishingRegistrySanLeskoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/registry")
public class FishingRegistrySanLeskoController {

    @Autowired
    private DbServiceFishingRegistrySanLeskoRepository dbServiceFishingRegistrySanLeskoRepository;

    @Autowired
    private FishingRegistrySanLeskoMapper fishingRegistrySanLeskoMapper;

    @GetMapping(value = "getSanLeskoRegistry")
    public List <SanLeskoRegistry> getSanLeskoRegistry() {
        return dbServiceFishingRegistrySanLeskoRepository.getAllFish();
    }

    @PostMapping(value = "createSanLeskoRegistry")
    public void createSanLeskoRegistry(@RequestBody SanLeskoRegistryDto sanLeskoRegistryDto) {
        dbServiceFishingRegistrySanLeskoRepository.saveFish(fishingRegistrySanLeskoMapper.mapToSanLesko(sanLeskoRegistryDto));
    }

    @DeleteMapping(value = "deleteSanLeskoRegistry")
    public void deleteSanLeskoRegistry(@RequestParam Long id) {
        dbServiceFishingRegistrySanLeskoRepository.deleteFish(id);
    }

    @PutMapping(value = "updateSanLeskoRegistry")
    public SanLeskoRegistryDto updateSanLeskoRegistry(@RequestBody SanLeskoRegistryDto sanLeskoRegistryDto) {
        return fishingRegistrySanLeskoMapper.mapToSanLeskoDto(dbServiceFishingRegistrySanLeskoRepository.updateFish(fishingRegistrySanLeskoMapper.mapToSanLesko(sanLeskoRegistryDto)));
    }
}