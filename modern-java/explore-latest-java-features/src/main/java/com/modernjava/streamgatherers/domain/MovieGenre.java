package com.modernjava.streamgatherers.domain;

/**
 * Movie genres enumeration for Collections demonstrations
 */
public enum MovieGenre {
    ACTION("Action"),
    COMEDY("Comedy"),
    DRAMA("Drama"),
    HORROR("Horror"),
    ROMANCE("Romance"),
    SCIENCE_FICTION("Science Fiction"),
    THRILLER("Thriller"),
    DOCUMENTARY("Documentary"),
    ANIMATION("Animation"),
    FANTASY("Fantasy");

    private final String displayName;

    MovieGenre(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}
