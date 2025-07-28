# Calculator Project

This project implements a `Calculator` and an `CalculatorAdvanced` class in Java, providing basic arithmetic operations, as well as more complex functionalities like factorials, exponentiation, and checking for Armstrong or perfect numbers. Unit tests are written using JUnit 5 and Hamcrest matchers to ensure code correctness and maintainability.

## Project Description

The core of this project is the `Calculator` class, which handles fundamental arithmetic operations: addition, subtraction, multiplication, and division. Building upon this, the `CalculatorAdvanced` class extends the functionality to include more sophisticated calculations and number characteristic checks. All operations are designed to handle potential issues gracefully through custom exception handling. The project emphasizes robust testing using JUnit 5 parameterized tests and Hamcrest matchers to ensure high code coverage and reliability.

## Features

### `Calculator` Class
* **Basic Arithmetic Operations**: Supports addition (`+`), subtraction (`-`), multiplication (`*`), and division (`/`).
* **`currentValue`**: A private `double` attribute to store the current result, with getter and setter methods.
* **Division by Zero Handling**: Throws `DivisionByZeroException` if an attempt is made to divide by zero.
* **Unsupported Operation Handling**: Throws `NotSupportedOperationException` for invalid operators.

### `CalculatorAdvanced` Class (Extends `Calculator`) 
* **Factorial Calculation**: Calculates the factorial of the integer part of `currentValue` when the `action` is `'!'`.
    * **Constraint**: `currentValue` must be within the range $[0, 10]$ for factorial calculation; otherwise, `NumberNotInAreaException` is thrown.
* **Exponentiation**: Calculates the power of the integer part of `currentValue` when the `action` is a digit from `'0'` to `'9'`.
* **Armstrong Number Check**: Determines if the integer part of `currentValue` is an Armstrong number when the `value` is `'A'`.
    * *Definition*: An n-digit number is an Armstrong number if it is equal to the sum of the n-th powers of its digits (e.g., $153 = 1^3 + 5^3 + 3^3$).
* **Perfect Number Check**: Determines if the integer part of `currentValue` is a perfect number when the `value` is `'P'`.
    * *Definition*: A perfect number is a natural number that is equal to the sum of its positive divisors, including 1, but not counting the number itself (e.g., $6 = 1 + 2 + 3$).
* **Number Not in Area Handling**: Throws `NumberNotInAreaException` if the integer part of `currentValue` is less than 1 for characteristic checks.
* **Unsupported Operation Handling**: Throws `NotSupportedOperationException` for unsupported `action` or `value` parameters.

## Exceptions

* `DivisionByZeroException`: Thrown when division by zero is attempted.
* `NotSupportedOperationException`: Thrown when an unsupported operator or action is provided.
* `NumberNotInAreaException`: Thrown when a number is outside a defined valid range for an operation (e.g., factorial of a negative number, or characteristic check for numbers less than 1).

## Testing

The project includes comprehensive unit tests using JUnit 5 and Hamcrest.
* All tests are located in a separate folder in the project.
* Parameterized tests are extensively used where applicable to cover various scenarios.
* Hamcrest matchers are utilized for assertions.
* The tests aim for full code coverage.

