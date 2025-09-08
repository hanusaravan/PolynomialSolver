# PolynomialSolver

## Description
Reads a JSON file containing polynomial roots and prints the k-th root in sorted order in JSON format.

## Folder Structure

PolynomialSolver/

├── lib/

│   └── json-simple-1.1.1.jar

├── src/

│   └── PolynomialSolver.java

└── input.json



## Compile & Run

### Windows
```cmd
javac -cp ".;lib/json-simple-1.1.1.jar" src/PolynomialSolver.java
java -cp ".;lib/json-simple-1.1.1.jar;src" PolynomialSolver
````

### Linux / Mac

```bash
javac -cp ".:lib/json-simple-1.1.1.jar" src/PolynomialSolver.java
java -cp ".:lib/json-simple-1.1.1.jar:src" PolynomialSolver
```

## Sample Output

```json
{
  "c": 11760
}
```

## Notes

* Works for any `n` and `k`.
* Handles non-consecutive keys (like `1,2,3,6`).
* Always prints in the format expected for submission.



