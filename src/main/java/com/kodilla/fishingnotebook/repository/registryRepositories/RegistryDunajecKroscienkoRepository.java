package com.kodilla.fishingnotebook.repository.registryRepositories;

import com.kodilla.fishingnotebook.domain.registry.DunajecKroscienkoRegistry;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface RegistryDunajecKroscienkoRepository extends CrudRepository <DunajecKroscienkoRegistry, Long> {

    @Override
    List <DunajecKroscienkoRegistry> findAll();
}
