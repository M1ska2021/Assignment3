# Assignment 3 — Bridge Pattern

**Name:** Maksut Alibi
**Group:** SE-2523
**Topic:** A — Drawing
**Pattern:** Bridge Pattern
**Language:** Java 17
**Repository:**M1ska2021/Assignment3

## 1. Project Description

This project demonstrates the **Bridge Design Pattern** using a drawing application.

The Bridge Pattern separates two independently changing dimensions:

1. **Abstraction:** Shape, Circle, Square
2. **Implementation:** Renderer, VectorRenderer, RasterRenderer, AsciiRenderer

The abstraction hierarchy contains different shapes, while the implementation hierarchy contains different rendering methods.

The two hierarchies are connected using **composition** through the `Renderer` interface.

This allows a shape to work with different renderers without creating a separate class for every possible combination.

## 2. Role Map

| Bridge Role             | Class            | Source                    |
| ----------------------- | ---------------- | ------------------------- |
| Abstraction             | `Shape`          | `src/Shape.java`          |
| Refined Abstraction A1  | `Circle`         | `src/Circle.java`         |
| Refined Abstraction A2  | `Square`         | `src/Square.java`         |
| Implementor             | `Renderer`       | `src/Renderer.java`       |
| Concrete Implementor I1 | `VectorRenderer` | `src/VectorRenderer.java` |
| Concrete Implementor I2 | `RasterRenderer` | `src/RasterRenderer.java` |
| Concrete Implementor I3 | `AsciiRenderer`  | `src/AsciiRenderer.java`  |
| Client                  | `Main`           | `src/Main.java`           |

## 3. Bridge Implementation

The bridge is the `Renderer` interface reference stored inside the `Shape` abstraction.

The `Shape` constructor receives a `Renderer` object and stores it.

The main methods are:

* `execute()` — performs the shape operation using the current renderer.
* `setImplementation(...)` — replaces the renderer at runtime.

The abstraction classes do not create concrete renderers directly. They communicate with the implementation through the `Renderer` interface.

## 4. Required Behavior

### Circle

Circle uses:

* Radius = `2`

### Square

Square uses:

* Side = `3`

### Renderers

`VectorRenderer`, `RasterRenderer`, and `AsciiRenderer` return different rendering descriptions while preserving the shape and its dimension.

## 5. Runtime Switching

T5 demonstrates runtime replacement of the implementation.

The same `Circle` object is first executed using `VectorRenderer`.

Then its renderer is replaced with `RasterRenderer` using:

`setImplementation(...)`

The Circle object itself does not change.

Its ID and domain data remain unchanged, while the rendering result changes.

The test also uses reference equality (`==`) to prove that the same abstraction object is used before and after the switch.

## 6. Demonstration Tests

The program supports:

```bash
java -cp out Main --demo
```

The demo runs seven checks:

| Test | Description                                | Expected |
| ---- | ------------------------------------------ | -------- |
| T1   | Circle + VectorRenderer                    | PASS     |
| T2   | Circle + RasterRenderer                    | PASS     |
| T3   | Square + VectorRenderer                    | PASS     |
| T4   | Square + RasterRenderer                    | PASS     |
| T5   | Same Circle switches from Vector to Raster | PASS     |
| T6   | Circle + AsciiRenderer                     | PASS     |
| T7   | Square + AsciiRenderer                     | PASS     |

Expected final result:

```text
SUMMARY: 7/7 PASS
```

## 7. Build and Run

The project can be compiled without an IDE.

### Compile

```bash
javac --release 17 -encoding UTF-8 -d out "@sources.txt"
```

### Run

```bash
java -cp out Main --demo
```

The program does not require interactive input.

## 8. I3 Extension

The third implementation, `AsciiRenderer`, was added after the initial two-by-two solution was completed.

The existing classes were not modified:

* `Shape`
* `Circle`
* `Square`
* `Renderer`
* `VectorRenderer`
* `RasterRenderer`

Only the new `AsciiRenderer` class and the demonstration code in `Main` were changed for the extension.

The source difference is stored in:

```text
extension.diff
```

## 9. Bridge vs Adapter

**Bridge** is used when we want to separate two independently changing class hierarchies.

In this project, shapes and renderers can change independently.

**Adapter** has a different purpose. It allows an existing incompatible class or interface to work with another interface expected by the client.

Therefore, Bridge focuses on **separating abstraction from implementation**, while Adapter focuses on **making incompatible interfaces work together**.

## 10. Advantages

* Shapes and renderers can evolve independently.
* New renderers can be added without changing existing shape classes.
* Runtime implementation switching is possible.
* Avoids creating a class for every shape-renderer combination.
* Uses composition instead of inheritance for connecting the two hierarchies.

## 11. Trade-off

The main trade-off is additional abstraction and more classes/interfaces.

For a very small application, Bridge can make the design more complex than necessary. However, it is useful when both dimensions are expected to change independently.

## 12. Files

The submission contains:

```text
src/
sources.txt
README.md
report.pdf
demo-output.txt
extension.diff
```

## 13. Conclusion

This project demonstrates how the Bridge Pattern separates the Shape abstraction from the Renderer implementation.

A single shape can use different renderers, and the renderer can be replaced at runtime without changing the shape object.

The addition of `AsciiRenderer` also demonstrates that a new implementation can be added without modifying the existing abstraction hierarchy.
