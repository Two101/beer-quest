package com.example.restservice.api.controller;

import com.example.restservice.api.data.VenueDto;
import com.example.restservice.service.VenueService;
import com.example.restservice.service.data.Venue;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/venue")
public class VenueController {

    private final VenueService venueService;

    @GetMapping("/{id}")
    public VenueDto getVenue(@PathVariable("id") long id) {
        return VenueDto.createFrom(venueService.getVenue(id));
    }

    @GetMapping
    public Page<VenueDto> getVenues(Pageable pageable) {
        return venueService.listVenues(pageable)
                .map(VenueDto::createFrom);
    }

    @PostMapping
    public VenueDto createVenue(@RequestBody Venue venue) {
        return VenueDto.createFrom(venueService.createVenue(venue));
    }

    @PutMapping("/{id}")
    public VenueDto updateVenue(@RequestBody Venue venue) {
        return VenueDto.createFrom(venueService.updateVenue(venue));
    }

    @DeleteMapping("/{id}")
    public void deleteVenue(@PathVariable("id") long id) {
        venueService.deleteVenue(id);
    }
}
