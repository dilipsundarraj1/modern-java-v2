package com.modernjava.streamgatherers;

import com.modernjava.streamgatherers.domain.MovieGenre;
import com.modernjava.streamgatherers.domain.Movie;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Gatherer;
import java.util.stream.Gatherers;

/**
 * MovieDemo class demonstrating various Gatherer functions with MovieWithLocalDate
 * This class explores the complete Gatherer API including:
 * - Value
 * - GathererImpl
 * - Composite
 * - Gatherers() factory methods
 * - windowFixed(int)
 * - windowSliding(int)
 * - fold(Supplier, BiFunction)
 * - scan(Supplier, BiFunction)
 * - mapConcurrent(int, Function)
 */
public class StreamGatherersDemo {

    static void main(String[] args) {
        System.out.println("=== MovieDemo: Exploring Gatherer Functions ===\n");

        List<Movie> movies = createSampleMovies();

        System.out.println("Sample Movies:");
        movies.forEach(System.out::println);
        System.out.println();

        // Demonstrate all Gatherer functions
        demonstrateWindowFixed(movies);
        demonstrateWindowSliding(movies);
        demonstrateFold(movies);
        demonstrateScan(movies);
        demonstrateMapConcurrent(movies);
        demonstrateCompositeGatherers(movies);
        demonstrateCustomGathererImpl(movies);
    }

    /**
     * Demonstrates windowFixed(int) - Groups elements into fixed-size windows
     */
    private static void demonstrateWindowFixed(List<Movie> movies) {
        System.out.println("=== windowFixed(3) - Fixed-size windows ===");

        movies.stream()
            .gather(Gatherers.windowFixed(3))
            .forEach(window -> {
                System.out.println("Window of 3 movies:");
                window.forEach(movie -> System.out.println("  - " + movie.title()));
                System.out.println();
            });
    }

    /**
     * Demonstrates windowSliding(int) - Creates sliding windows of specified size
     */
    private static void demonstrateWindowSliding(List<Movie> movies) {
        System.out.println("=== windowSliding(2) - Sliding windows ===");

        movies.stream()
            .limit(5) // Limit for clarity
            .gather(Gatherers.windowSliding(2))
            .forEach(window -> {
                System.out.println("Sliding window:");
                window.forEach(movie -> System.out.println("  - " + movie.title()));
                System.out.println();
            });
    }

    /**
     * Demonstrates fold(Supplier, BiFunction) - Reduces all elements to a single value
     */
    private static void demonstrateFold(List<Movie> movies) {
        System.out.println("=== fold() - Folding operations ===");

        // Calculate total duration of all movies
        Integer totalDuration = movies.stream()
            .gather(Gatherers.fold(
                () -> 0,
                (acc, movie) -> acc + movie.duration()
            ))
            .findFirst()
            .orElse(0);

        System.out.println("Total duration of all movies: " + totalDuration + " minutes");

        // Calculate average rating
        double averageRating = movies.stream()
            .gather(Gatherers.fold(
                () -> 0.0,
                (acc, movie) -> acc + movie.rating()
            ))
            .findFirst()
            .orElse(0.0) / movies.size();

        System.out.println("Average rating: " + String.format("%.2f", averageRating));

        // Concatenate all movie titles
        String allTitles = movies.stream()
            .gather(Gatherers.fold(
                () -> "",
                (acc, movie) -> acc.isEmpty() ? movie.title() : acc + ", " + movie.title()
            ))
            .findFirst()
            .orElse("");

        System.out.println("All movie titles: " + allTitles);
        System.out.println();
    }

    /**
     * Demonstrates scan(Supplier, BiFunction) - Produces intermediate results
     */
    private static void demonstrateScan(List<Movie> movies) {
        System.out.println("=== scan() - Scanning operations ===");

        // Running total of movie durations
        System.out.println("Running total of movie durations:");
        movies.stream()
            .gather(Gatherers.scan(
                () -> 0,
                (acc, movie) -> acc + movie.duration()
            ))
            .forEach(runningTotal ->
                System.out.println("Running total: " + runningTotal + " minutes"));

        System.out.println();

        // Running average of ratings
        System.out.println("Running average of ratings:");
        AtomicInteger count = new AtomicInteger(0);
        movies.stream()
            .gather(Gatherers.scan(
                () -> 0.0,
                (acc, movie) -> {
                    int currentCount = count.incrementAndGet();
                    return (acc * (currentCount - 1) + movie.rating()) / currentCount;
                }
            ))
            .forEach(runningAvg ->
                System.out.println("Running average: " + String.format("%.2f", runningAvg)));

        System.out.println();
    }

    /**
     * Demonstrates mapConcurrent(int, Function) - Concurrent mapping with specified parallelism
     */
    private static void demonstrateMapConcurrent(List<Movie> movies) {
        System.out.println("=== mapConcurrent(2) - Concurrent processing ===");

        // Process movies concurrently to simulate expensive operations
        movies.stream()
            .gather(Gatherers.mapConcurrent(
                2, // Use 2 concurrent threads
                movie -> {
                    // Simulate some processing time
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }

                    // Return a processed result
                    return Map.entry(
                        movie.title(),
                        "Processed: " + movie.genre() + " (" + movie.duration() + "min, " + movie.rating() + "★)"
                    );
                }
            ))
            .forEach(result ->
                System.out.println(result.getKey() + " -> " + result.getValue()));

        System.out.println();
    }

    /**
     * Demonstrates composite gatherers - Combining multiple gatherer operations
     */
    private static void demonstrateCompositeGatherers(List<Movie> movies) {
        System.out.println("=== Composite Gatherers - Chaining operations ===");

        // Filter high-rated movies, then group into windows, then calculate stats per window
        movies.stream()
            .filter(movie -> movie.rating() >= 8.0)
            .gather(Gatherers.windowFixed(2))
            .gather(Gatherers.scan(
                () -> 0,
                (count, window) -> count + 1
            ))
            .forEach(windowCount ->
                System.out.println("High-rated movie window #" + windowCount));

        System.out.println();
    }

    /**
     * Demonstrates custom GathererImpl - Creating a custom gatherer
     */
    private static void demonstrateCustomGathererImpl(List<Movie> movies) {
        System.out.println("=== Custom Gatherer Implementation ===");

        // Custom gatherer to group movies by decade
        Gatherer<Movie, ?, Map.Entry<String, List<Movie>>> moviesByDecade =
            Gatherer.ofSequential(
                () -> new java.util.HashMap<String, List<Movie>>(),
                (map, movie, downstream) -> {
                    int decade = (movie.getReleaseYear() / 10) * 10;
                    String decadeKey = decade + "s";
                    map.computeIfAbsent(decadeKey, k -> new java.util.ArrayList<>()).add(movie);
                    return true;
                },
                (map, downstream) -> {
                    map.entrySet().forEach(downstream::push);
                }
            );

        System.out.println("Movies grouped by decade:");
        movies.stream()
            .gather(moviesByDecade)
            .forEach(entry -> {
                System.out.println("Decade: " + entry.getKey());
                entry.getValue().forEach(movie ->
                    System.out.println("  - " + movie.title() + " (" + movie.getReleaseYear() + ")"));
                System.out.println();
            });
    }

    /**
     * Creates sample MovieWithLocalDate instances for demonstration
     */
    private static List<Movie> createSampleMovies() {
        return List.of(
            new Movie("The Godfather", MovieGenre.DRAMA, LocalDate.of(1972, 3, 24), 9.2, 175),
            new Movie("The Shawshank Redemption", MovieGenre.DRAMA, LocalDate.of(1994, 9, 23), 9.3, 142),
            new Movie("Pulp Fiction", MovieGenre.DRAMA, LocalDate.of(1994, 10, 14), 8.9, 154),
            new Movie("The Dark Knight", MovieGenre.ACTION, LocalDate.of(2008, 7, 18), 9.0, 152),
            new Movie("Schindler's List", MovieGenre.DRAMA, LocalDate.of(1993, 12, 15), 9.0, 195),
            new Movie("Forrest Gump", MovieGenre.DRAMA, LocalDate.of(1994, 7, 6), 8.8, 142),
            new Movie("Inception", MovieGenre.SCIENCE_FICTION, LocalDate.of(2010, 7, 16), 8.8, 148),
            new Movie("The Matrix", MovieGenre.SCIENCE_FICTION, LocalDate.of(1999, 3, 31), 8.7, 136),
            new Movie("Goodfellas", MovieGenre.DRAMA, LocalDate.of(1990, 9, 19), 8.7, 146),
            new Movie("Star Wars: A New Hope", MovieGenre.SCIENCE_FICTION, LocalDate.of(1977, 5, 25), 8.6, 121),
            new Movie("Casablanca", MovieGenre.ROMANCE, LocalDate.of(1942, 11, 26), 8.5, 102),
            new Movie("Citizen Kane", MovieGenre.DRAMA, LocalDate.of(1941, 5, 1), 8.3, 119)
        );
    }
}
