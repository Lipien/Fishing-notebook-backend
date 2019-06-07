package com.kodilla.fishingnotebook;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

@SpringBootApplication
public class FishingNotebookApplication {

    public static void main(String[] args) {
        SpringApplication.run(FishingNotebookApplication.class, args);
    }
}
