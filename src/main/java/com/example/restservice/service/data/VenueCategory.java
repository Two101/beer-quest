package com.example.restservice.service.data;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum VenueCategory {
    PUB_REVIEW("Pub reviews"),
    BAR_REVIEW("Bar reviews"),
    OTHER_REVIEW("Other reviews"),
    CLOSED_VENUE("Closed venues"),
    UNCATEGORISED("Uncategorized");

    private String description;
}
