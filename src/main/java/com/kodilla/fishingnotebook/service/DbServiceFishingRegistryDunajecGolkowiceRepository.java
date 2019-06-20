package com.kodilla.fishingnotebook.service;

import com.kodilla.fishingnotebook.domain.registry.DunajecGolkowiceRegistry;
import com.kodilla.fishingnotebook.repository.registryrepositories.RegistryDunajecGolkowiceRepository;
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

    public DunajecGolkowiceRegistry saveFish(final DunajecGolkowiceRegistry dunajecGolkowiceRegistry) {
        return registryDunajecGolkowiceRepository.save(dunajecGolkowiceRegistry);
    }

    public void deleteFish(Long id) {
        registryDunajecGolkowiceRepository.deleteById(id);
    }

    public DunajecGolkowiceRegistry updateFish(final DunajecGolkowiceRegistry dunajecGolkowiceRegistry) {
        return registryDunajecGolkowiceRepository.save(dunajecGolkowiceRegistry);
    }
}
