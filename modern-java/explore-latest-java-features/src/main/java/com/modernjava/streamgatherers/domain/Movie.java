package com.modernjava.streamgatherers.domain;

import java.time.LocalDate;

/**
 * MovieWithLocalDate Record - Simple record to represent a movie with a LocalDate release date.
 */
public record Movie(
    String title,
    MovieGenre genre,
    LocalDate releaseDate,
    double rating,
    int duration
) {
    public Movie {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Title cannot be null or blank");
        }
        if (rating < 0.0 || rating > 10.0) {
            throw new IllegalArgumentException("Rating must be between 0.0 and 10.0");
        }
        if (duration <= 0) {
            throw new IllegalArgumentException("Duration must be positive");
        }
    }

    public int getReleaseYear() {
        return releaseDate.getYear();
    }

    public boolean isClassic() {
        return releaseDate.isBefore(LocalDate.of(1980, 1, 1));
    }

    public boolean isHighRated() {
        return rating >= 8.0;
    }
}
