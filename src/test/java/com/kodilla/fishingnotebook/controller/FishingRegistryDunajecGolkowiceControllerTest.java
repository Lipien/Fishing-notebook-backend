package com.kodilla.fishingnotebook.controller;

import com.google.gson.Gson;
import com.kodilla.fishingnotebook.domain.registry.DunajecGolkowiceRegistry;
import com.kodilla.fishingnotebook.domain.registry.DunajecGolkowiceRegistryDto;
import com.kodilla.fishingnotebook.mapper.registry.FishingRegistryDunajecGolkowiceMapper;
import com.kodilla.fishingnotebook.service.DbServiceFishingRegistryDunajecGolkowiceRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(FishingRegistryDunajecGolkowiceController.class)
public class FishingRegistryDunajecGolkowiceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DbServiceFishingRegistryDunajecGolkowiceRepository dbServiceFishingRegistryDunajecGolkowiceRepository;

    @MockBean
    private FishingRegistryDunajecGolkowiceMapper fishingRegistryDunajecGolkowiceMapper;

    @Test
    public void getDunajecGolkowiceRegistry() throws Exception {
        //Given
        List <DunajecGolkowiceRegistry> dunajecGolkowiceRegistryList = new ArrayList <>();
        dunajecGolkowiceRegistryList.add(new DunajecGolkowiceRegistry(1L, "18-06-2019", "trout", "42", "1"));
        dunajecGolkowiceRegistryList.add(new DunajecGolkowiceRegistry(2L, "22-06-2019", "grayling", "35", "1"));

        when(dbServiceFishingRegistryDunajecGolkowiceRepository.getAllFish()).thenReturn(dunajecGolkowiceRegistryList);

        //When & Then
        mockMvc.perform((get("/v1/registry/getDunajecGolkowiceRegistry").contentType(MediaType.APPLICATION_JSON)))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$", hasSize(2)));
    }

    @Test
    public void getDunajecGolkowiceEmptyRegistry() throws Exception {
        //Given
        List <DunajecGolkowiceRegistry> dunajecGolkowiceRegistryList = new ArrayList <>();
        when(dbServiceFishingRegistryDunajecGolkowiceRepository.getAllFish()).thenReturn(dunajecGolkowiceRegistryList);

        //When & Then
        mockMvc.perform((get("/v1/registry/getDunajecGolkowiceRegistry").contentType(MediaType.APPLICATION_JSON)))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$", hasSize(0)));
    }

    @Test
    public void createDunajecGolkowiceRegistry() throws Exception {
        //Given
        DunajecGolkowiceRegistryDto dunajecGolkowiceRegistryDto = new DunajecGolkowiceRegistryDto(11L, "18-06-2019", "trout", "34cm", "1");
        DunajecGolkowiceRegistry dunajecGolkowiceRegistry = new DunajecGolkowiceRegistry(11L, "18-06-2019", "trout", "34cm", "1");

        when(dbServiceFishingRegistryDunajecGolkowiceRepository.saveFish(any(DunajecGolkowiceRegistry.class))).thenReturn(dunajecGolkowiceRegistry);
        when(fishingRegistryDunajecGolkowiceMapper.mapToDunajecGolkowice(any(DunajecGolkowiceRegistryDto.class))).thenReturn(dunajecGolkowiceRegistry);

        Gson gson = new Gson();
        String jsonContent = gson.toJson(dunajecGolkowiceRegistryDto);

        //When & Then
        mockMvc.perform(post("/v1/registry/createDunajecGolkowiceRegistry")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(status().isOk());
        verify(dbServiceFishingRegistryDunajecGolkowiceRepository, times(1)).saveFish(any(DunajecGolkowiceRegistry.class));
    }

    @Test
    public void deleteDunajecGolkowiceRegistry() throws Exception {
        //When & Then
        mockMvc.perform(delete("/v1/registry/deleteDunajecGolkowiceRegistry?id=12")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void updateDunajecGolkowiceRegistry() throws Exception {
        //Given
        DunajecGolkowiceRegistryDto dunajecGolkowiceRegistryDto = new DunajecGolkowiceRegistryDto(11L, "18-06-2019", "trout", "34cm", "1");
        DunajecGolkowiceRegistry dunajecGolkowiceRegistry = new DunajecGolkowiceRegistry(11L, "18-06-2019", "trout", "34cm", "1");

        when(dbServiceFishingRegistryDunajecGolkowiceRepository.updateFish(any(DunajecGolkowiceRegistry.class))).thenReturn(dunajecGolkowiceRegistry);
        when(fishingRegistryDunajecGolkowiceMapper.mapToDunajecGolkowiceDto(any(DunajecGolkowiceRegistry.class))).thenReturn(dunajecGolkowiceRegistryDto);
        when(fishingRegistryDunajecGolkowiceMapper.mapToDunajecGolkowice(any(DunajecGolkowiceRegistryDto.class))).thenReturn(dunajecGolkowiceRegistry);

        Gson gson = new Gson();
        String jsonContent = gson.toJson(dunajecGolkowiceRegistryDto);

        //When & Then
        mockMvc.perform(put("/v1/registry/updateDunajecGolkowiceRegistry")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(11)))
                .andExpect(jsonPath("$.catchDate", is("18-06-2019")))
                .andExpect(jsonPath("$.fishType", is("trout")))
                .andExpect(jsonPath("$.length", is("34cm")))
                .andExpect(jsonPath("$.qty", is("1")));
    }
}