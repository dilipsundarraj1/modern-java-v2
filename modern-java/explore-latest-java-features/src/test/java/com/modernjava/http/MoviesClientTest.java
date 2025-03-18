package com.modernjava.http;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@Disabled
public class MoviesClientTest {

    MoviesClient moviesClient = new MoviesClient();

    @Test
    void getAllMoviesV2() {
        var moviesList = moviesClient.getAllMoviesV2();
        assert moviesList.size()==10;
    }

    @Test
    void getAllMoviesV2Async() {
        var moviesList = moviesClient.getAllMoviesV2Async().join();
        assert moviesList.size()==10;
    }

    @Test
    void getMovieById() {
        var movie = moviesClient.getMovieById();
        assertEquals("Batman Begins", movie.name());
    }

    @Test
    void getMovieByIdAsync() {
        var movie = moviesClient.getMovieByIdAsync().join();
        assertEquals("Batman Begins", movie.name());
    }
}
