package com.kodilla.fishingnotebook.repository.registryRepositories;

import com.kodilla.fishingnotebook.domain.registry.DunajecGolkowiceRegistry;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface RegistryDunajecGolkowiceRepository extends CrudRepository <DunajecGolkowiceRegistry, Long> {

    @Override
    List <DunajecGolkowiceRegistry> findAll();

    @Override
    DunajecGolkowiceRegistry save(DunajecGolkowiceRegistry dunajecGolkowiceRegistry);

    @Override
    void deleteById(Long id);
}
