# Calculator Project

This project implements a `Calculator` and an `CalculatorAdvanced` class in Java, providing basic arithmetic operations, as well as more complex functionalities like factorials, exponentiation, and checking for Armstrong or perfect numbers. Unit tests are written using JUnit 5 and Hamcrest matchers to ensure code correctness and maintainability.

## Table of Contents

* [Project Description](#project-description)
* [Features](#features)
* [Exceptions](#exceptions)
* [Testing](#testing)
* [Getting Started](#getting-started)
    * [Prerequisites](#prerequisites)
    * [Installation](#installation)
    * [Running Tests](#running-tests)
* [Usage](#usage)
* [Documentation](#documentation)
* [Author](#author)
* [License](#license)

## Project Description

[cite_start]The core of this project is the `Calculator` class, which handles fundamental arithmetic operations: addition, subtraction, multiplication, and division[cite: 7]. [cite_start]Building upon this, the `CalculatorAdvanced` class extends the functionality to include more sophisticated calculations and number characteristic checks[cite: 10, 12, 17]. [cite_start]All operations are designed to handle potential issues gracefully through custom exception handling[cite: 8, 9, 14, 15, 18, 19]. [cite_start]The project emphasizes robust testing using JUnit 5 parameterized tests and Hamcrest matchers to ensure high code coverage and reliability[cite: 21, 22, 23, 26].

## Features

### `Calculator` Class
* [cite_start]**Basic Arithmetic Operations**: Supports addition (`+`), subtraction (`-`), multiplication (`*`), and division (`/`)[cite: 7].
* [cite_start]**`currentValue`**: A private `double` attribute to store the current result, with getter and setter methods[cite: 4, 5].
* [cite_start]**Division by Zero Handling**: Throws `DivisionByZeroException` if an attempt is made to divide by zero[cite: 8].
* [cite_start]**Unsupported Operation Handling**: Throws `NotSupportedOperationException` for invalid operators[cite: 9].

### [cite_start]`CalculatorAdvanced` Class (Extends `Calculator`) [cite: 10]
* [cite_start]**Factorial Calculation**: Calculates the factorial of the integer part of `currentValue` when the `action` is `'!'`[cite: 12].
    * [cite_start]**Constraint**: `currentValue` must be within the range $[0, 10]$ for factorial calculation; otherwise, `NumberNotInAreaException` is thrown[cite: 13, 14].
* [cite_start]**Exponentiation**: Calculates the power of the integer part of `currentValue` when the `action` is a digit from `'0'` to `'9'`[cite: 12].
* [cite_start]**Armstrong Number Check**: Determines if the integer part of `currentValue` is an Armstrong number when the `value` is `'A'`[cite: 17].
    * [cite_start]*Definition*: An n-digit number is an Armstrong number if it is equal to the sum of the n-th powers of its digits (e.g., $153 = 1^3 + 5^3 + 3^3$)[cite: 30, 31].
* [cite_start]**Perfect Number Check**: Determines if the integer part of `currentValue` is a perfect number when the `value` is `'P'`[cite: 17].
    * [cite_start]*Definition*: A perfect number is a natural number that is equal to the sum of its positive divisors, including 1, but not counting the number itself (e.g., $6 = 1 + 2 + 3$)[cite: 32, 33].
* [cite_start]**Number Not in Area Handling**: Throws `NumberNotInAreaException` if the integer part of `currentValue` is less than 1 for characteristic checks[cite: 18].
* [cite_start]**Unsupported Operation Handling**: Throws `NotSupportedOperationException` for unsupported `action` or `value` parameters[cite: 15, 19].

## Exceptions

* [cite_start]`DivisionByZeroException`: Thrown when division by zero is attempted[cite: 8].
* [cite_start]`NotSupportedOperationException`: Thrown when an unsupported operator or action is provided[cite: 9, 15, 19].
* [cite_start]`NumberNotInAreaException`: Thrown when a number is outside a defined valid range for an operation (e.g., factorial of a negative number, or characteristic check for numbers less than 1)[cite: 14, 18].

## Testing

[cite_start]The project includes comprehensive unit tests using JUnit 5 and Hamcrest[cite: 21, 23].
* [cite_start]All tests are located in a separate folder in the project[cite: 23].
* [cite_start]Parameterized tests are extensively used where applicable to cover various scenarios[cite: 22].
* [cite_start]Hamcrest matchers are utilized for assertions[cite: 23].
* [cite_start]The tests aim for full code coverage[cite: 26].

## Getting Started

### Prerequisites

* Java Development Kit (JDK) 8 or higher
* Maven (or Gradle, if you prefer, but the project setup assumes Maven)
* JUnit 5 libraries
* Hamcrest libraries

### Installation

1.  **Clone the repository:**
    ```bash
    git clone [https://github.com/your-username/calculator-project.git](https://github.com/your-username/calculator-project.git)
    cd calculator-project
    ```

2.  **Build the project (using Maven):**
    ```bash
    mvn clean install
    ```

### Running Tests

To run the unit tests, use Maven:

```bash
mvn test
