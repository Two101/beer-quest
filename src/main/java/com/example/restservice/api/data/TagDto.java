package com.example.restservice.api.data;

import com.example.restservice.service.data.Tag;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TagDto {
    private final Long id;
    private final String name;

    public static TagDto createFrom(Tag tag) {
        return TagDto.builder()
                .id(tag.getId())
                .name(tag.getName())
                .build();
    }
}
