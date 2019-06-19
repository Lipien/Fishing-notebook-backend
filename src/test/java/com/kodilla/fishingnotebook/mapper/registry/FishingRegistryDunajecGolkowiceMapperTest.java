package com.kodilla.fishingnotebook.mapper.registry;

import com.kodilla.fishingnotebook.domain.registry.DunajecGolkowiceRegistry;
import com.kodilla.fishingnotebook.domain.registry.DunajecGolkowiceRegistryDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class FishingRegistryDunajecGolkowiceMapperTest {

    @InjectMocks
    private FishingRegistryDunajecGolkowiceMapper fishingRegistryDunajecGolkowiceMapper;

    @Test
    public void mapToDunajecGolkowiceDto() {
        //Given
        DunajecGolkowiceRegistry dunajecGolkowiceRegistry = new DunajecGolkowiceRegistry(1L, "catchDate", "fishType", "length", "qty");

        //When
        DunajecGolkowiceRegistryDto resultingDunajecGolkowiceRegistryDto = fishingRegistryDunajecGolkowiceMapper.mapToDunajecGolkowiceDto(dunajecGolkowiceRegistry);

        //Then
        assertEquals(dunajecGolkowiceRegistry.getId(), resultingDunajecGolkowiceRegistryDto.getId());
        assertEquals(dunajecGolkowiceRegistry.getCatchDate(), resultingDunajecGolkowiceRegistryDto.getCatchDate());
        assertEquals(dunajecGolkowiceRegistry.getFishType(), resultingDunajecGolkowiceRegistryDto.getFishType());
        assertEquals(dunajecGolkowiceRegistry.getLength(), resultingDunajecGolkowiceRegistryDto.getLength());
        assertEquals(dunajecGolkowiceRegistry.getQty(), resultingDunajecGolkowiceRegistryDto.getQty());
    }

    @Test
    public void mapToDunajecGolkowice() {
        //Given
        DunajecGolkowiceRegistryDto dunajecGolkowiceRegistryDto = new DunajecGolkowiceRegistryDto(1L, "catchDate", "fishType", "length", "qty");

        //When
        DunajecGolkowiceRegistry resultingDunajecGolkowiceRegistry = fishingRegistryDunajecGolkowiceMapper.mapToDunajecGolkowice(dunajecGolkowiceRegistryDto);

        //Then
        assertEquals(dunajecGolkowiceRegistryDto.getId(), resultingDunajecGolkowiceRegistry.getId());
        assertEquals(dunajecGolkowiceRegistryDto.getCatchDate(), resultingDunajecGolkowiceRegistry.getCatchDate());
        assertEquals(dunajecGolkowiceRegistryDto.getFishType(), resultingDunajecGolkowiceRegistry.getFishType());
        assertEquals(dunajecGolkowiceRegistryDto.getLength(), resultingDunajecGolkowiceRegistry.getLength());
        assertEquals(dunajecGolkowiceRegistryDto.getQty(), resultingDunajecGolkowiceRegistry.getQty());
    }
}