package com.kodilla.fishingnotebook.mapper.registry;

import com.kodilla.fishingnotebook.domain.registry.SanLeskoRegistry;
import com.kodilla.fishingnotebook.domain.registry.SanLeskoRegistryDto;
import org.springframework.stereotype.Component;

@Component
public class FishingRegistrySanLeskoMapper {

    public SanLeskoRegistryDto mapToSanLeskoDto(final SanLeskoRegistry sanLeskoRegistry) {
        return new SanLeskoRegistryDto(
                sanLeskoRegistry.getId(),
                sanLeskoRegistry.getCatchDate(),
                sanLeskoRegistry.getFishType(),
                sanLeskoRegistry.getLength(),
                sanLeskoRegistry.getQty());
    }

    public SanLeskoRegistry mapToSanLesko(final SanLeskoRegistryDto sanLeskoRegistryDto) {
        return new SanLeskoRegistry(
                sanLeskoRegistryDto.getId(),
                sanLeskoRegistryDto.getCatchDate(),
                sanLeskoRegistryDto.getFishType(),
                sanLeskoRegistryDto.getLength(),
                sanLeskoRegistryDto.getQty());
    }
}