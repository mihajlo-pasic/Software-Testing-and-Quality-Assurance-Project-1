package tests;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.stream.Stream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import calculator.Calculator;
import calculator.DivisionByZeroException;
import calculator.NotSupportedOperationException;

class CalculatorTest {

	private Calculator calc = new Calculator();

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		calc.setCurrentValue(0.0);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetCurrentValue() {
		assertThat(Double.valueOf(0), is(calc.getCurrentValue()));
	}

	@Test
	void testSetCurrentValue() {
		calc.setCurrentValue(3);
		assertThat(Double.valueOf(3), is(calc.getCurrentValue()));
	}

	@ParameterizedTest
	@MethodSource("testCalculate")
	void testCalculate(double currVal, Double value, char operator, double result) throws DivisionByZeroException, NotSupportedOperationException {
		calc.setCurrentValue(currVal);
		calc.calculate(value, operator);
		assertThat(result, is(calc.getCurrentValue()));
	}

	private static Stream<Arguments> testCalculate() {
		return Stream.of(
				Arguments.of(0, 3.0, '+', 3.0),
				Arguments.of(0.0, -3.0, '+', -3.0),
				Arguments.of(5.0, 3.0, '-', 2.0),
				Arguments.of(5.0, -3.0, '-', 8.0),
				Arguments.of(-5.0, 3.0, '-', -8.0),
				Arguments.of(-5.0, -3.0, '-', -2.0),
				Arguments.of(5.0, 3.0, '*', 15.0),
				Arguments.of(5.0, -3.0, '*', -15.0),
				Arguments.of(0, 3.0, '*', 0.0),
				Arguments.of(-5.0, -3.0, '*', 15.0),
				Arguments.of(4.5, 3.0, '/', 1.5)
				);
	}

	@ParameterizedTest
	@MethodSource("calcException")
	void testCalculateException(Double currVal, double value, char operator, Class<? extends Exception> exception)
			throws DivisionByZeroException, NotSupportedOperationException {
		calc.setCurrentValue(currVal);
		assertThrows(exception, () -> calc.calculate(value, operator));
	}

	private static Stream<Arguments> calcException() {
		return Stream.of(
				Arguments.of(1.0, 0.0, '/', DivisionByZeroException.class),
				Arguments.of(5.0, 5, 'm', NotSupportedOperationException.class)
				);
	}
}
