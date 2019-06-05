package com.kodilla.fishingnotebook.service;

import com.kodilla.fishingnotebook.domain.registry.DunajecGolkowiceRegistry;
import com.kodilla.fishingnotebook.repository.registryRepositories.RegistryDunajecGolkowiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class DbServiceFishingRegistryDunajecGolkowiceRepository {

    @Autowired
    private RegistryDunajecGolkowiceRepository registryDunajecGolkowiceRepository;

    public List <DunajecGolkowiceRegistry> getAllFish() {
        return registryDunajecGolkowiceRepository.findAll();
    }
}
