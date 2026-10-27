# Assignment 5 - Strategy Pattern

A small Java calculator. It uses a different strategy for each operation:
addition, subtraction, multiplication and division.

## Run

Install JDK 17 or newer. From the project folder, run:

```bash
javac -d out src/*.java
java -cp out Main
```

In IntelliJ IDEA, open the project, select JDK 17, mark `src` as Sources Root
if needed, and run `Main.java`.

Output:

```text
10.0 + 5.0 = 15.0
10.0 - 5.0 = 5.0
10.0 * 5.0 = 50.0
10.0 / 5.0 = 2.0
```

Change `a` and `b` in `Main.java` to try other numbers. Division by zero
throws `IllegalArgumentException` with the message `Cannot divide by zero`.

## Files

| File | Purpose |
| --- | --- |
| `src/OperationStrategy.java` | Common interface for the operations |
| `src/AddStrategy.java` | Addition |
| `src/SubtractStrategy.java` | Subtraction |
| `src/MultiplyStrategy.java` | Multiplication |
| `src/DivideStrategy.java` | Division |
| `src/Calculator.java` | Stores the strategy and calls it |
| `src/Main.java` | Creates the calculator and switches strategies |
| `REPORT.md` | Assignment report with UML and Clean Code examples |

## How it works

`Main` chooses an operation. `Calculator` stores it in the `strategy` field.
When `calculate(a, b)` is called, the calculator delegates to
`strategy.execute(a, b)`. Calling `setStrategy(...)` changes the operation
on the same calculator object.

## Add another strategy

For example, create `src/ModuloStrategy.java`:

```java
public class ModuloStrategy implements OperationStrategy {
    @Override
    public double execute(double a, double b) {
        return a % b;
    }
}
```

Use it in `Main`:

```java
calculator.setStrategy(new ModuloStrategy());
System.out.println(calculator.calculate(10, 3));
```

Recompile and run. The result is `1.0`. `Calculator` and the existing
strategies stay the same. Division was added in a separate commit using
this approach.

Full report: [REPORT.md](REPORT.md).
