package com.example.restservice.api.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.restservice.service.VenueService;
import com.example.restservice.service.data.Tag;
import com.example.restservice.service.data.Venue;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@AutoConfigureMockMvc
public class VenueControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private VenueService venueService;

    @Test
    void getVenueReturnsSomething() throws Exception {
        Venue venue = createVenue(1L, "Test Venue");
        Tag tag = venue.getTags().get(0);
        when(venueService.getVenue(1L)).thenReturn(venue);
        this.mockMvc.perform(get("/venue/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(venue.getId()))
                .andExpect(jsonPath("$.name").value(venue.getName()))
                .andExpect(jsonPath("$.tags[0].id").value(tag.getId()))
                .andExpect(jsonPath("$.tags[0].name").value(tag.getName()));
    }

    private Venue createVenue(Long id, String name) {
        return Venue.builder()
                .id(id)
                .name(name)
                .tags(Collections.singletonList(Tag.builder()
                        .id(1L)
                        .name("has beer")
                        .build()))
                .build();
    }
}
