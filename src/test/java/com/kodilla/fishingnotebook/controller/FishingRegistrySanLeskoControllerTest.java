package com.kodilla.fishingnotebook.controller;

import com.kodilla.fishingnotebook.domain.registry.SanLeskoRegistry;
import com.kodilla.fishingnotebook.mapper.registry.FishingRegistrySanLeskoMapper;
import com.kodilla.fishingnotebook.service.DbServiceFishingRegistrySanLeskoRepository;
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
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(FishingRegistrySanLeskoController.class)
public class FishingRegistrySanLeskoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DbServiceFishingRegistrySanLeskoRepository dbServiceFishingRegistrySanLeskoRepository;

    @MockBean
    private FishingRegistrySanLeskoMapper fishingRegistrySanLeskoMapper;

    @Test
    public void getSanLeskoRegistry() throws Exception {
        //Given
        List <SanLeskoRegistry> sanLeskoRegistryList = new ArrayList <>();
        sanLeskoRegistryList.add(new SanLeskoRegistry(1L, "18-06-2019", "trout", "42", "1"));
        sanLeskoRegistryList.add(new SanLeskoRegistry(2L, "22-06-2019", "grayling", "35", "1"));

        when(dbServiceFishingRegistrySanLeskoRepository.getAllFish()).thenReturn(sanLeskoRegistryList);

        //When & Then
        mockMvc.perform((get("/v1/registry/getSanLeskoRegistry").contentType(MediaType.APPLICATION_JSON)))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$", hasSize(2)));
    }

    @Test
    public void getSanLeskoEmptyRegistry() throws Exception {
        //Given
        List <SanLeskoRegistry> sanLeskoRegistryList = new ArrayList <>();
        when(dbServiceFishingRegistrySanLeskoRepository.getAllFish()).thenReturn(sanLeskoRegistryList);

        //When & Then
        mockMvc.perform((get("/v1/registry/getSanLeskoRegistry").contentType(MediaType.APPLICATION_JSON)))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$", hasSize(0)));
    }

    @Test
    public void createSanLeskoRegistry() {
    }

    @Test
    public void deleteSanLeskoRegistry() {
    }

    @Test
    public void updateSanLeskoRegistry() {
    }
}