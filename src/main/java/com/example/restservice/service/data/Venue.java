package com.example.restservice.service.data;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter @Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Venue {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "venue_sequence")
    @SequenceGenerator(name = "venue_sequence", sequenceName = "venue_id_seq", allocationSize = 1)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column
    @Enumerated(EnumType.STRING)
    private VenueCategory category;

    @Column
    private String url;

    @Column(name = "date_added")
    private LocalDateTime dateAdded;

    @Column
    private String excerpt;

    @Column(name = "thumbnail_url")
    private String thumbnailUrl;

    @Column(columnDefinition = "numeric", precision = 9, scale = 7)
    private Double latitude;

    @Column(columnDefinition = "numeric", precision = 10, scale = 7)
    private Double longitude;

    @Column
    private String address;

    @Column
    private String phone;

    @Column
    private String twitter;

    @Column(name = "stars_beer", columnDefinition = "numeric", precision = 2, scale = 1)
    private Double beerStars;

    @Column(name = "stars_atmosphere", columnDefinition = "numeric", precision = 2, scale = 1)
    private Double atmosphereStars;

    @Column(name = "stars_amenities", columnDefinition = "numeric", precision = 2, scale = 1)
    private Double amenityStars;

    @Column(name = "stars_value", columnDefinition = "numeric", precision = 2, scale = 1)
    private Double valueStars;

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(
            name = "venue_tag",
            joinColumns = @JoinColumn(name = "venue_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private List<Tag> tags;
}
