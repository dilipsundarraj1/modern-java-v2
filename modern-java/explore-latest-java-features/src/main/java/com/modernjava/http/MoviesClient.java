package com.modernjava.http;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import static java.net.http.HttpRequest.newBuilder;

public class MoviesClient {

    private final HttpClient client = HttpClient.newBuilder()
            .connectTimeout(Duration.ofSeconds(2))
            .build();

    public static String ALL_MOVIES_URL = "http://127.0.0.1:8000/explore-latest-java-features/src/main/resources/movies.json";
    public static String MOVIE_BY_ID_URL = "http://127.0.0.1:8000/explore-latest-java-features/src/main/resources/movie_by_id.json";

    private final ObjectMapper objectMapper = new ObjectMapper()
            .registerModule(new JavaTimeModule())
            .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);



    public Movie getMovieById() {

        try {

            var request = requestBuilder(MOVIE_BY_ID_URL);
            HttpResponse<String> response =
                    client.send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println("Status code: " + response.statusCode());
            System.out.println("Headers: " + response.headers());


            return objectMapper.readValue(response.body(), Movie.class);
        } catch (IOException | InterruptedException e) {
            System.err.println(e);
            throw new RuntimeException(e);
        }

    }

    public CompletableFuture<Movie> getMovieByIdAsync() {

        try {

            var request = requestBuilder(MOVIE_BY_ID_URL);
            var response =
                    client.sendAsync(request, HttpResponse.BodyHandlers.ofString());

            return response
                    .thenApply(httpResponse -> {
                        System.out.println("Status code: " + httpResponse.statusCode());
                        System.out.println("Headers: " + httpResponse.headers());
                        try {
                            return objectMapper.readValue(httpResponse.body(),Movie.class);
                        } catch (JsonProcessingException e) {
                            throw new RuntimeException(e);
                        }
                    });
        } catch (Exception e) {
            System.err.println(e);
            throw new RuntimeException(e);
        }

    }

    public List<Movie> getAllMoviesV2() {

        try {

            var request = requestBuilder(ALL_MOVIES_URL);
            var response =
                    client.send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println("Status code: " + response.statusCode());
            System.out.println("Headers: " + response.headers());

            return objectMapper.readValue(response.body(), new TypeReference<>() {
            });
        } catch (IOException | InterruptedException e) {
            System.err.println(e);
            throw new RuntimeException(e);
        }

    }

    public CompletableFuture<List<Movie>> getAllMoviesV2Async() {

        try {
            var request = requestBuilder(ALL_MOVIES_URL);
            var response =
                    client.sendAsync(request, HttpResponse.BodyHandlers.ofString());

            return response
                    .thenApply(httpResponse -> {
                        System.out.println("Status code: " + httpResponse.statusCode());
                        System.out.println("Headers: " + httpResponse.headers());
                        try {
                            return objectMapper.readValue(httpResponse.body(), new TypeReference<>() {
                            });
                        } catch (JsonProcessingException e) {
                            throw new RuntimeException(e);
                        }
                    });

        } catch (Exception e) {
            System.err.println(e);
            throw new RuntimeException(e);
        }

    }

    public static HttpRequest requestBuilder(String url) {
        return newBuilder()
                .uri(URI.create(url))
                .header("Accept", "application/json")
                .GET() // default (could leave that out)
                .build();
    }

}
