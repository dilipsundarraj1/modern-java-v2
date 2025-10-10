# UnnamedVariables.java - Unnamed Variables Concepts

<!-- TOC -->
* [UnnamedVariables.java - Unnamed Variables Concepts](#unnamedvariablesjava---unnamed-variables-concepts)
  * [Prompts for Replication](#prompts-for-replication)
    * [Prompt 1: Lambda Parameters with Unnamed Variables](#prompt-1-lambda-parameters-with-unnamed-variables)
    * [Prompt 2: Exception Handling with Unnamed Variables](#prompt-2-exception-handling-with-unnamed-variables)
  * [Key Concepts Demonstrated](#key-concepts-demonstrated)
<!-- TOC -->

This file demonstrates the unnamed variables feature in modern Java (Java 22+). Unnamed variables use the underscore `_` to indicate that a variable is intentionally unused, improving code readability and expressing developer intent clearly.

## Prompts for Replication

### Prompt 1: Lambda Parameters with Unnamed Variables
**Task**: Create a method that demonstrates using unnamed variables in lambda expressions when only caring about specific parameters.

**Expected Function Signature**: `private static void demonstrateLambdaWithUnnamed()`

**Requirements**:
- Print section header: "Slide 2: lambda parameters with unnamed variable"
- Create a Map with String keys and Integer values: `Map<String, Integer> freq = Map.of("a", 1, "b", 2, "c", 3)`
- Use forEach with lambda that only uses the key parameter: `freq.forEach((k, _) -> System.out.println("key: " + k ))`
- The underscore `_` indicates we don't care about the value parameter

**JavaDoc Requirements**:
- Method-level JavaDoc: "Slide 1 + 2: lambdas with unnamed parameters" with bullet point explaining "(value, _) -> we only care about the first parameter"

### Prompt 2: Exception Handling with Unnamed Variables
**Task**: Create a method that demonstrates using unnamed variables in exception handling combined with stream operations for parsing data.

**Expected Function Signature**: `public static void demonstrateExceptionHandling()`

**Requirements**:
- Print section header: "=== Multiple Unnamed Variables ==="
- Add inline comment: "Nested try-catch with multiple exceptions we don't care about"
- Create a list of mixed strings: `var operations = List.of("123", "divide", "10")`
- Use stream operations to process the list:
  - Map each string using a helper method `getInteger(s)`
  - Convert to list using `.toList()`
  - Store result in `var intList`
- Include a commented alternative showing method reference: `// .map(UnnamedVariables::getInteger)`
- Print the result: `System.out.println("Parsed integers: " + intList)`

**Helper Method Requirements**:
- Create private static method `getInteger(String s)` that returns `Integer`
- Uses try-catch with unnamed variable: `catch (Exception _)`
- Attempts to parse string to Integer using `Integer.parseInt(s)`
- On exception, prints "Failed to parse: " + s and returns null
- Uses unnamed variable to show we don't care about exception details

**JavaDoc Requirements**:
- Class-level JavaDoc: "Advanced examples of unnamed variables in Java" with description about best practices and readability
- Method-level JavaDoc: "Using multiple unnamed variables in different contexts"

**Main Method**:
- Create static main method that calls both `demonstrateLambdaWithUnnamed()` and `demonstrateExceptionHandling()`

---

## Key Concepts Demonstrated

1. **Lambda Parameters**: Using `_` in lambda expressions when only some parameters are needed
2. **Exception Handling**: Using `_` in catch blocks when exception details are not needed
3. **Stream Operations**: Combining unnamed variables with stream processing and method references
4. **Code Intent**: Expressing that variables are intentionally unused for better readability
5. **Map Iteration**: Using forEach with unnamed variables to focus on specific data
6. **Null Handling**: Graceful failure handling in data processing pipelines
7. **Best Practices**: JavaDoc documentation and clean code structure with unnamed variables
