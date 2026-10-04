# Assignment 3 | Bridge Pattern

- **Student:** Alibi Maksut
- **Group:** SE-2301
- **Topic:** Option A (Drawing)
- **Repository URL:** https://github.com/M1ska2021/Assignment3_Bridge
- **Base Commit Hash:** `11ef76c1044c3b38667c3770c4925581593c8f98`

---

## 1. Role Map

| Role | Name | Source Path | Description |
|---|---|---|---|
| **Abstraction** | `Shape` | `src/Shape.java` | Abstract base class holding the `Renderer` bridge reference |
| **Refined Abstraction 1 (A1)** | `Circle` | `src/Circle.java` | Extends `Shape`, retains `radius = 2`, delegates to `renderCircle` |
| **Refined Abstraction 2 (A2)** | `Square` | `src/Square.java` | Extends `Shape`, retains `side = 3`, delegates to `renderSquare` |
| **Implementor** | `Renderer` | `src/Renderer.java` | Interface defining low-level primitive rendering operations |
| **Concrete Implementor 1 (I1)** | `VectorRenderer` | `src/VectorRenderer.java` | Implements vector-based coordinate output format |
| **Concrete Implementor 2 (I2)** | `RasterRenderer` | `src/RasterRenderer.java` | Implements raster-based pixel output format |
| **Concrete Implementor 3 (I3)** | `AsciiRenderer` | `src/AsciiRenderer.java` | Extension implementing ASCII-art output format |
| **Client** | `Main` | `src/Main.java` | Test harness running verification checks T1–T7 |

---

## 2. Key Code Pointers

- **Bridge Reference Field:** `Shape.java` (Line 5: `protected Renderer renderer;`)
- **Execution Operation:** `Shape.java` (Line 21: `public abstract String execute();`), refined in `Circle.java` (`execute() -> renderer.renderCircle(radius)`) and `Square.java` (`execute() -> renderer.renderSquare(side)`)
- **Runtime Switcher:** `Shape.java` (Line 17: `public void setImplementation(Renderer renderer)`)
- **Runtime Switching Verification (T5):** `Main.java` (Lines 46–78) proves reference identity (`refBefore == refAfter`), invariant state (`id` and `radius`), and implementation substitution.

---

## 3. Standard Build and Run Commands

```bash
javac --release 17 -encoding UTF-8 -d out "@sources.txt"
java -cp out Main --demo
```

---

## 4. Expected Demonstration Outcomes (T1–T7)

```text
T1 PASS | Circle + VectorRenderer | result=VECTOR circle radius=2
T2 PASS | Circle + RasterRenderer | result=RASTER circle radius=2
T3 PASS | Square + VectorRenderer | result=VECTOR square side=3
T4 PASS | Square + RasterRenderer | result=RASTER square side=3
T5 PASS | sameObject=true | stateUnchanged=true
 before=VECTOR circle radius=2 | after=RASTER circle radius=2
T6 PASS | Circle + AsciiRenderer | result=ASCII circle radius=2
T7 PASS | Square + AsciiRenderer | result=ASCII square side=3
SUMMARY: 7/7 PASS
```
