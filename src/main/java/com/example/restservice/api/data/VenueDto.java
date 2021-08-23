package com.example.restservice.api.data;

import com.example.restservice.service.data.Venue;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
public class VenueDto {
    private final Long id;
    private final String name;
    private final String category;
    private final String url;
    private final String dateAdded;
    private final String excerpt;
    private final String thumbnailUrl;
    private final Double latitude;
    private final Double longitude;
    private final String address;
    private final String phone;
    private final String twitter;
    private final Double beerStars;
    private final Double atmosphereStars;
    private final Double valueStars;
    private final List<TagDto> tags;

    public static VenueDto createFrom(Venue venue) {
        return VenueDto.builder()
                .id(venue.getId())
                .name(venue.getName())
                .category(venue.getCategory() == null ? null : venue.getCategory().name())
                .url(venue.getUrl())
                .dateAdded(venue.getDateAdded() == null ? null : venue.getDateAdded().toString())
                .excerpt(venue.getExcerpt())
                .thumbnailUrl(venue.getThumbnailUrl())
                .latitude(venue.getLatitude())
                .longitude(venue.getLongitude())
                .address(venue.getAddress())
                .phone(venue.getPhone())
                .twitter(venue.getTwitter())
                .beerStars(venue.getBeerStars())
                .atmosphereStars(venue.getAtmosphereStars())
                .valueStars(venue.getAtmosphereStars())
                .tags(venue.getTags() == null ? null : venue.getTags()
                        .stream()
                        .map(TagDto::createFrom)
                        .collect(Collectors.toList()))
                .build();
    }
}
