package com.kodilla.fishingnotebook.mapper.registry;

import com.kodilla.fishingnotebook.domain.registry.DunajecKroscienkoRegistry;
import com.kodilla.fishingnotebook.domain.registry.DunajecKroscienkoRegistryDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class FishingRegistryDunajecKroscienkoMapperTest {

    @InjectMocks
    private FishingRegistryDunajecKroscienkoMapper fishingRegistryDunajecKroscienkoMapper;

    @Test
    public void mapToDunajecKroscienkoDto() {
        //Given
        DunajecKroscienkoRegistry dunajecKroscienkoRegistry = new DunajecKroscienkoRegistry(1L, "catchDate", "fishType", "length", "qty");

        //When
        DunajecKroscienkoRegistryDto resultingDunajecKroscienkoRegistryDto = fishingRegistryDunajecKroscienkoMapper.mapToDunajecKroscienkoDto(dunajecKroscienkoRegistry);

        //Then
        assertEquals(dunajecKroscienkoRegistry.getId(), resultingDunajecKroscienkoRegistryDto.getId());
        assertEquals(dunajecKroscienkoRegistry.getCatchDate(), resultingDunajecKroscienkoRegistryDto.getCatchDate());
        assertEquals(dunajecKroscienkoRegistry.getFishType(), resultingDunajecKroscienkoRegistryDto.getFishType());
        assertEquals(dunajecKroscienkoRegistry.getLength(), resultingDunajecKroscienkoRegistryDto.getLength());
        assertEquals(dunajecKroscienkoRegistry.getQty(), resultingDunajecKroscienkoRegistryDto.getQty());
    }

    @Test
    public void mapToDunajecKroscienko() {
        //Given
        DunajecKroscienkoRegistryDto dunajecKroscienkoRegistryDto = new DunajecKroscienkoRegistryDto(1L, "catchDate", "fishType", "length", "qty");

        //When
        DunajecKroscienkoRegistry resultingDunajecKroscienkoRegistry = fishingRegistryDunajecKroscienkoMapper.mapToDunajecKroscienko(dunajecKroscienkoRegistryDto);

        //Then
        assertEquals(dunajecKroscienkoRegistryDto.getId(), resultingDunajecKroscienkoRegistry.getId());
        assertEquals(dunajecKroscienkoRegistryDto.getCatchDate(), resultingDunajecKroscienkoRegistry.getCatchDate());
        assertEquals(dunajecKroscienkoRegistryDto.getFishType(), resultingDunajecKroscienkoRegistry.getFishType());
        assertEquals(dunajecKroscienkoRegistryDto.getLength(), resultingDunajecKroscienkoRegistry.getLength());
        assertEquals(dunajecKroscienkoRegistryDto.getQty(), resultingDunajecKroscienkoRegistry.getQty());
    }
}