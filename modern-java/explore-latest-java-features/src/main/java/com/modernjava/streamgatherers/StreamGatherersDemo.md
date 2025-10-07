# StreamGatherersDemo.java - Mastering Java Stream Gatherers API

## Overview
This file demonstrates the comprehensive use of Java's Stream Gatherers API introduced as a preview feature. It showcases advanced stream processing techniques using Movie objects to illustrate real-world data manipulation scenarios. The class explores all core Gatherer operations including windowing, folding, scanning, concurrent mapping, and custom implementations, providing practical examples of how to leverage this powerful API for complex data transformations.

## Prompts for Replication

### Prompt 1: Window Fixed Operations - Creating Fixed-Size Groups
**Task**: Create a method that demonstrates fixed-size windowing of Movie collections.

**Expected Function Signature**: `private static void demonstrateWindowFixed(List<Movie> movies)`

**Requirements**:
- Print section header: "=== windowFixed(3) - Fixed-size windows ==="
- Use `Gatherers.windowFixed(3)` to group movies into windows of 3
- Process each window as a separate collection
- Print window contents with proper formatting: "Window of 3 movies:"
- Display each movie title with indentation: "  - " + movie.title()
- Add spacing between windows for clarity
- Handle cases where final window may contain fewer than 3 movies

---

### Prompt 2: Window Sliding Operations - Creating Overlapping Groups
**Task**: Create a method demonstrating sliding window operations for sequential data analysis.

**Expected Function Signature**: `private static void demonstrateWindowSliding(List<Movie> movies)`

**Requirements**:
- Print section header: "=== windowSliding(2) - Sliding windows ==="
- Limit movies to first 5 using `limit(5)` for clarity
- Use `Gatherers.windowSliding(2)` to create overlapping windows
- Each window contains 2 consecutive movies with overlap
- Print each sliding window: "Sliding window:"
- Display movie titles with indentation: "  - " + movie.title()
- Show how windows overlap between iterations
- Add spacing between windows for readability

---

### Prompt 3: Fold Operations - Reducing to Single Values
**Task**: Create a method demonstrating various fold operations that reduce entire collections to single values.

**Expected Function Signature**: `private static void demonstrateFold(List<Movie> movies)`

**Requirements**:
- Print section header: "=== fold() - Folding operations ==="
- Calculate total duration: `Gatherers.fold(() -> 0, (acc, movie) -> acc + movie.duration())`
- Calculate average rating by folding then dividing by size
- Concatenate all movie titles with comma separation
- Use proper null handling with `findFirst().orElse()` pattern
- Format output: "Total duration of all movies: X minutes"
- Format average: "Average rating: X.XX" using String.format("%.2f", value)
- Display concatenated titles: "All movie titles: title1, title2, ..."

---

### Prompt 4: Scan Operations - Producing Intermediate Results
**Task**: Create a method demonstrating scan operations that produce running calculations.

**Expected Function Signature**: `private static void demonstrateScan(List<Movie> movies)`

**Requirements**:
- Print section header: "=== scan() - Scanning operations ==="
- Implement running total of durations: `Gatherers.scan(() -> 0, (acc, movie) -> acc + movie.duration())`
- Calculate running average of ratings using AtomicInteger for count tracking
- Display each intermediate result: "Running total: X minutes"
- Show running averages: "Running average: X.XX" with proper formatting
- Reset counter between different scan operations
- Demonstrate how scan differs from fold by showing intermediate values

---

### Prompt 5: Concurrent Mapping Operations - Parallel Processing
**Task**: Create a method demonstrating concurrent processing with controlled parallelism.

**Expected Function Signature**: `private static void demonstrateMapConcurrent(List<Movie> movies)`

**Requirements**:
- Print section header: "=== mapConcurrent(2) - Concurrent processing ==="
- Use `Gatherers.mapConcurrent(2, function)` with 2 concurrent threads
- Simulate expensive operation with `Thread.sleep(100)` in processing function
- Handle InterruptedException properly with `Thread.currentThread().interrupt()`
- Return Map.Entry with movie title as key and processed info as value
- Format processed result: "Processed: GENRE (Xmin, X.X★)"
- Display results: "TITLE -> Processed: ..."
- Demonstrate performance benefits of concurrent processing

---

### Prompt 6: Composite Gatherers - Chaining Multiple Operations
**Task**: Create a method demonstrating how to combine multiple gatherer operations in sequence.

**Expected Function Signature**: `private static void demonstrateCompositeGatherers(List<Movie> movies)`

**Requirements**:
- Print section header: "=== Composite Gatherers - Chaining operations ==="
- Filter high-rated movies: `filter(movie -> movie.rating() >= 8.0)`
- Apply fixed windowing: `gather(Gatherers.windowFixed(2))`
- Apply scanning to count windows: `gather(Gatherers.scan(() -> 0, (count, window) -> count + 1))`
- Display window numbers: "High-rated movie window #X"
- Show how operations can be chained for complex processing
- Demonstrate data flow through multiple transformation stages

---

### Prompt 7: Custom Gatherer Implementation - Creating Domain-Specific Gatherers
**Task**: Create a method demonstrating custom gatherer implementation for grouping movies by decade.

**Expected Function Signature**: `private static void demonstrateCustomGathererImpl(List<Movie> movies)`

**Requirements**:
- Print section header: "=== Custom Gatherer Implementation ==="
- Create custom gatherer: `Gatherer.ofSequential()` with proper type parameters
- Implement initializer: `() -> new HashMap<String, List<Movie>>()`
- Implement integrator that groups movies by decade using `movie.getReleaseYear() / 10 * 10`
- Format decade keys as "1970s", "1980s", etc.
- Implement finisher that pushes all map entries to downstream
- Display results: "Decade: 1970s" followed by movie list
- Show movie details: "  - TITLE (YEAR)" with proper indentation
- Demonstrate advanced gatherer creation patterns

---

### Prompt 8: Sample Data Creation and Utility Methods
**Task**: Create a method that generates comprehensive sample Movie data for demonstrations.

**Expected Function Signature**: `private static List<Movie> createSampleMovies()`

**Requirements**:
- Create List.of() with 12 diverse Movie instances
- Include movies from different decades (1940s through 2010s)
- Use various genres: DRAMA, ACTION, SCIENCE_FICTION, ROMANCE
- Include different ratings (8.3 to 9.3 range) and durations (102 to 195 minutes)
- Use proper LocalDate.of() construction for release dates
- Include classic movies: "The Godfather", "Casablanca", "Citizen Kane"
- Include modern movies: "Inception", "The Dark Knight", "The Matrix"
- Ensure data variety for meaningful windowing and grouping demonstrations

**Movie Data Requirements**:
- Mix of high and moderate ratings for filtering demonstrations
- Various durations for aggregation calculations
- Different decades for custom gatherer grouping
- Multiple genres for diverse categorization
- Realistic release dates using LocalDate

---

## Key Concepts Covered

### 1. Stream Gatherers Overview

**What you'll learn:**
- Understanding the Stream Gatherers API introduced in Java
- How gatherers extend stream processing beyond traditional collectors
- The relationship between gatherers and stream intermediate operations
- When to use gatherers vs traditional stream operations

**Code Examples:**
```java
// Basic gatherer usage pattern
stream.gather(Gatherers.windowFixed(3))
      .forEach(window -> processWindow(window));

// Chaining gatherers with other stream operations
movies.stream()
      .filter(movie -> movie.rating() >= 8.0)
      .gather(Gatherers.windowFixed(2))
      .gather(Gatherers.scan(() -> 0, (count, window) -> count + 1))
      .forEach(System.out::println);
```

**Key Points:**
- Gatherers provide stateful intermediate operations for streams
- They can be chained with traditional stream operations
- Gatherers maintain state across multiple elements unlike stateless operations
- They offer more flexibility than collectors for complex transformations

### 2. Fixed Window Operations

**What you'll learn:**
- How to partition stream elements into fixed-size groups
- Processing collections in manageable chunks
- Handling incomplete final windows gracefully
- Memory-efficient processing of large datasets

**Code Examples:**
```java
movies.stream()
    .gather(Gatherers.windowFixed(3))
    .forEach(window -> {
        System.out.println("Processing " + window.size() + " movies:");
        window.forEach(movie -> System.out.println("  - " + movie.title()));
    });
```

**Key Points:**
- `windowFixed(n)` creates non-overlapping groups of exactly n elements
- Final window may contain fewer elements if stream size isn't divisible by n
- Useful for batch processing and pagination scenarios
- Each window is a separate List that can be processed independently

### 3. Sliding Window Operations

**What you'll learn:**
- Creating overlapping windows for trend analysis
- Understanding window overlap patterns and data flow
- Sequential data analysis techniques
- Comparing consecutive elements or groups

**Code Examples:**
```java
movies.stream()
    .limit(5)
    .gather(Gatherers.windowSliding(2))
    .forEach(window -> {
        System.out.println("Comparing: " + 
            window.get(0).title() + " vs " + window.get(1).title());
    });
```

**Key Points:**
- `windowSliding(n)` creates overlapping windows of size n
- Each window shares n-1 elements with the next window
- Excellent for comparing consecutive elements or detecting patterns
- Produces more windows than fixed windowing for same input size

### 4. Folding Operations

**What you'll learn:**
- Reducing entire streams to single accumulated values
- Implementing custom aggregation logic beyond standard collectors
- Understanding accumulator patterns and initialization
- Working with different data types in fold operations

**Code Examples:**
```java
// Calculate total duration
Integer totalDuration = movies.stream()
    .gather(Gatherers.fold(
        () -> 0,                              // Initializer
        (acc, movie) -> acc + movie.duration() // Accumulator
    ))
    .findFirst()
    .orElse(0);

// Concatenate titles
String allTitles = movies.stream()
    .gather(Gatherers.fold(
        () -> "",
        (acc, movie) -> acc.isEmpty() ? 
            movie.title() : acc + ", " + movie.title()
    ))
    .findFirst()
    .orElse("");
```

**Key Points:**
- Fold operations reduce entire stream to single value
- Requires initializer supplier and binary accumulator function
- Result is wrapped in Optional, use findFirst().orElse() to extract
- More flexible than reduce() for complex accumulation patterns

### 5. Scanning Operations

**What you'll learn:**
- Producing running totals and intermediate calculations
- Understanding the difference between fold and scan operations
- Implementing cumulative statistics and progressive analysis
- Tracking state changes throughout stream processing

**Code Examples:**
```java
// Running total of durations
movies.stream()
    .gather(Gatherers.scan(
        () -> 0,
        (acc, movie) -> acc + movie.duration()
    ))
    .forEach(runningTotal -> 
        System.out.println("Running total: " + runningTotal + " minutes"));

// Running average with external counter
AtomicInteger count = new AtomicInteger(0);
movies.stream()
    .gather(Gatherers.scan(
        () -> 0.0,
        (acc, movie) -> {
            int currentCount = count.incrementAndGet();
            return (acc * (currentCount - 1) + movie.rating()) / currentCount;
        }
    ))
    .forEach(avg -> System.out.println("Running average: " + avg));
```

**Key Points:**
- Scan produces intermediate results at each step, not just final result
- Each output represents the accumulated state up to that point
- Useful for progress tracking and incremental analysis
- Can use external variables (AtomicInteger) for complex calculations

### 6. Concurrent Mapping Operations

**What you'll learn:**
- Leveraging parallelism within stream processing
- Controlling concurrency levels for optimal performance
- Handling expensive operations efficiently
- Managing thread safety and interruption in concurrent contexts

**Code Examples:**
```java
movies.stream()
    .gather(Gatherers.mapConcurrent(
        2, // Use 2 concurrent threads
        movie -> {
            // Simulate expensive operation
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            
            return Map.entry(
                movie.title(),
                "Processed: " + movie.genre() + " (" + 
                movie.duration() + "min, " + movie.rating() + "★)"
            );
        }
    ))
    .forEach(result -> 
        System.out.println(result.getKey() + " -> " + result.getValue()));
```

**Key Points:**
- `mapConcurrent(n, function)` processes elements using n concurrent threads
- Ideal for I/O operations, network calls, or CPU-intensive transformations
- Maintains stream order despite concurrent processing
- Always handle InterruptedException properly in concurrent operations

### 7. Composite Gatherer Operations

**What you'll learn:**
- Chaining multiple gatherer operations for complex workflows
- Understanding data flow through multiple transformation stages
- Combining filtering, windowing, and aggregation operations
- Building reusable processing pipelines

**Code Examples:**
```java
movies.stream()
    .filter(movie -> movie.rating() >= 8.0)      // Filter first
    .gather(Gatherers.windowFixed(2))            // Then window
    .gather(Gatherers.scan(                      // Then scan
        () -> 0,
        (count, window) -> count + 1
    ))
    .forEach(windowNum -> 
        System.out.println("High-rated window #" + windowNum));
```

**Key Points:**
- Gatherers can be chained with both stream operations and other gatherers
- Order of operations affects final results and performance
- Filter before gathering to reduce processing load
- Each gatherer receives output from previous operation in chain

### 8. Custom Gatherer Implementation

**What you'll learn:**
- Creating domain-specific gatherer implementations
- Understanding gatherer internals: initializer, integrator, finisher
- Implementing stateful stream processing logic
- Building reusable components for complex data transformations

**Code Examples:**
```java
// Custom gatherer to group movies by decade
Gatherer<Movie, ?, Map.Entry<String, List<Movie>>> moviesByDecade =
    Gatherer.ofSequential(
        // Initializer: create initial state
        () -> new HashMap<String, List<Movie>>(),
        
        // Integrator: process each element
        (map, movie, downstream) -> {
            int decade = (movie.getReleaseYear() / 10) * 10;
            String decadeKey = decade + "s";
            map.computeIfAbsent(decadeKey, k -> new ArrayList<>()).add(movie);
            return true; // Continue processing
        },
        
        // Finisher: process final state
        (map, downstream) -> {
            map.entrySet().forEach(downstream::push);
        }
    );

movies.stream()
    .gather(moviesByDecade)
    .forEach(entry -> {
        System.out.println("Decade: " + entry.getKey());
        entry.getValue().forEach(movie ->
            System.out.println("  - " + movie.title() + " (" + movie.getReleaseYear() + ")"));
    });
```

**Key Points:**
- `Gatherer.ofSequential()` creates custom sequential gatherers
- Initializer provides starting state for accumulation
- Integrator processes each element and maintains state
- Finisher handles final state and produces output
- Return true from integrator to continue, false to short-circuit

## Performance Characteristics

| Operation | Memory Usage | Concurrency | Best Use Case |
|-----------|-------------|-------------|---------------|
| `windowFixed(n)` | O(n) per window | Sequential | Batch processing, pagination |
| `windowSliding(n)` | O(n) per window | Sequential | Trend analysis, comparisons |
| `fold()` | O(1) | Sequential | Aggregation, reduction |
| `scan()` | O(1) per element | Sequential | Running totals, progress tracking |
| `mapConcurrent(n)` | O(n) threads | Parallel | I/O operations, CPU-intensive tasks |
| Custom gatherers | Varies | Configurable | Domain-specific transformations |

## Best Practices with Stream Gatherers

1. **Choose Appropriate Window Size**: Balance memory usage with processing efficiency
2. **Handle Interruption**: Always properly handle InterruptedException in concurrent operations
3. **Filter Early**: Apply filters before gatherers to reduce processing load
4. **Null Safety**: Check for null values in custom gatherer implementations
5. **Thread Safety**: Use thread-safe collections in concurrent gatherers
6. **Memory Management**: Be mindful of memory usage with large windows
7. **Exception Handling**: Implement proper error handling in custom gatherers
8. **State Management**: Keep gatherer state minimal and focused

## Common Use Cases

- **Data Analysis**: Calculating moving averages, running totals, trend analysis
- **Batch Processing**: Processing large datasets in manageable chunks
- **Stream Partitioning**: Grouping related elements for specialized processing
- **Concurrent Processing**: Parallelizing expensive operations while maintaining order
- **Custom Aggregations**: Implementing domain-specific reduction operations
- **Window-based Operations**: Analyzing data in fixed or sliding time windows
- **Pipeline Processing**: Building complex data transformation workflows

## Real-World Applications

- **Financial Analysis**: Moving averages, portfolio analysis, risk calculations
- **Log Processing**: Analyzing log entries in time windows, error rate tracking
- **IoT Data Processing**: Sensor data aggregation, anomaly detection
- **Machine Learning**: Feature engineering, data preprocessing pipelines
- **Business Intelligence**: Sales trend analysis, performance metrics calculation
- **Real-time Analytics**: Stream processing, live dashboard updates
- **Data Migration**: Batch processing during system migrations
- **Content Processing**: Media file processing, document analysis workflows

## Movie Domain Model

The examples use a `Movie` record with the following structure:

```java
public record Movie(
    String title,           // Movie title
    MovieGenre genre,       // Genre enum (DRAMA, ACTION, etc.)
    LocalDate releaseDate,  // Release date
    double rating,          // Rating (0.0 to 10.0)
    int duration           // Duration in minutes
) {
    // Utility methods
    public int getReleaseYear() { return releaseDate.getYear(); }
    public boolean isClassic() { return releaseDate.isBefore(LocalDate.of(1980, 1, 1)); }
    public boolean isHighRated() { return rating >= 8.0; }
}
```

This rich domain model enables realistic demonstrations of gatherer operations with meaningful business logic and varied data characteristics.
