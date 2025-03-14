# Calculator Library Unit Tests

This repository contains **JUnit** unit tests for the `calculator-1.0.jar` library.  
Each test class focuses on testing a **single method** from the library.

---

## Test Structure

✔ **Each Calculator method has a dedicated test class.**  
✔ **JUnit 5** is used for testing.  
✔ **Preconditions & Postconditions** are set with `@BeforeAll` and `@AfterAll`.  
✔ **Parameterized tests** ensure data-driven testing.  
✔ **Parallel execution** is enabled via JUnit settings.

---

## Parallel Execution Configuration

To enable **parallel execution**, the `junit-platform.properties` file was created with the following content:

```properties
junit.jupiter.execution.parallel.enabled = true
junit.jupiter.execution.parallel.config.strategy = dynamic
```
---

## How to Run Tests?

1. **Navigate to the `test` package** in your project directory.
2. **Right-click** the **test class** or the entire **test folder** you want to run.
3. Click **`Run Tests`**.

---

## Screenshots of Test Results
 **Test execution screenshots are available in the screenshots folder.**
