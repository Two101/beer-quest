package com.example.restservice.service;

import com.example.restservice.service.data.Venue;
import com.example.restservice.service.data.VenueRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class VenueService {

    private final VenueRepository repository;

    public Page<Venue> listVenues(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Venue getVenue(long id) {
        return repository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    public Venue createVenue(Venue venue) {
        venue.setDateAdded(LocalDateTime.now());
        return repository.save(venue);
    }

    public void deleteVenue(long id) {
        repository.deleteById(id);
    }

    @Transactional
    public Venue updateVenue(Venue venue) {
        if (venue.getId() == null) {
            throw new IllegalArgumentException("Venue ID must not be null");
        }
        Venue existing = getVenue(venue.getId());
        updateWith(existing, venue);
        return repository.save(existing);
    }

    private void updateWith(Venue updatee, Venue updator) {
        updatee.setName(updator.getName());
        updatee.setCategory(updator.getCategory());
        updatee.setUrl(updator.getUrl());
        updatee.setExcerpt(updator.getExcerpt());
        updatee.setThumbnailUrl(updator.getThumbnailUrl());
        updatee.setLatitude(updator.getLatitude());
        updatee.setLongitude(updator.getLongitude());
        updatee.setAddress(updator.getAddress());
        updatee.setPhone(updator.getPhone());
        updatee.setTwitter(updator.getTwitter());
        updatee.setBeerStars(updator.getBeerStars());
        updatee.setAtmosphereStars(updator.getAtmosphereStars());
        updatee.setAmenityStars(updator.getAmenityStars());
        updatee.setValueStars(updator.getValueStars());
        updatee.setTags(updator.getTags());
    }
}
