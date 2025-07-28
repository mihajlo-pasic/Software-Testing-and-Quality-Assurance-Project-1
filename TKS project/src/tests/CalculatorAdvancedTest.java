package tests;
import calculator.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CalculatorAdvancedTest {

	private CalculatorAdvanced ca = new CalculatorAdvanced();
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		ca.setCurrentValue(0.0);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@ParameterizedTest
	@MethodSource("calcAdv")
	void testCalculateAdvanced(double currVal, char action, double expectedRes) throws NotSupportedOperationException, NumberNotInAreaException {
		ca.setCurrentValue(currVal);
		ca.calculateAdvanced(action);
		assertThat(expectedRes, is(ca.getCurrentValue()));
	}
	
	private static Stream<Arguments> calcAdv(){
		return Stream.of(
				Arguments.of(0, '!', 1),
				Arguments.of(1, '!', 1),
				Arguments.of(5.0, '!', 120.0),
				Arguments.of(10.0,'!',3628800),
				Arguments.of(5.0, '0', 1.0),
				Arguments.of(2.0,'1',2),
				Arguments.of(2.0, '3', 8.0),
				Arguments.of(2.0, '9', 512)
				);
	}
	
	@ParameterizedTest
	@MethodSource("calcAdvExcept")
	void testCalculateAdvancedException(double currVal, char action, Class<? extends Exception> exception) throws NotSupportedOperationException, NumberNotInAreaException {
		ca.setCurrentValue(currVal);
		assertThrows(exception, () -> ca.calculateAdvanced(action));
	}
	
	private static Stream<Arguments> calcAdvExcept(){
		return Stream.of(
				Arguments.of(-1, '!', NumberNotInAreaException.class),
				Arguments.of(-0.000001,'!',NumberNotInAreaException.class),
				Arguments.of(10.000001, '!', NumberNotInAreaException.class),
				Arguments.of(11, '!', NumberNotInAreaException.class),
				Arguments.of(5.0, 'm', NotSupportedOperationException.class),
				Arguments.of(2.0,'=',NotSupportedOperationException.class)
				);
	}

	@ParameterizedTest
	@MethodSource("hasCharacteristic")
	void testHasCharacteristic(double num, char value, Boolean result) throws NotSupportedOperationException, NumberNotInAreaException {
		ca.setCurrentValue(num);
		assertThat(result, is(ca.hasCharacteristic(value)));
	}
	
	private static Stream<Arguments> hasCharacteristic(){
		return Stream.of(
				Arguments.of(153.43, 'A', true),
				Arguments.of(5.0	, 'A', true),
				Arguments.of(13.211, 'A', false),
				Arguments.of(28.0, 'P', true),
				Arguments.of(3.0, 'P', false)
				);
	}
	
	@ParameterizedTest
	@MethodSource("hasCharacteristicExcept")
	void testHasCharacteristicException(double num, char value, Class<? extends Exception> exception) throws NotSupportedOperationException, NumberNotInAreaException {
		ca.setCurrentValue(num);
		assertThrows(exception, () -> ca.hasCharacteristic(value));
	}
	
	private static Stream<Arguments> hasCharacteristicExcept(){
		return Stream.of(
				Arguments.of(-1, 'A', NumberNotInAreaException.class),
				Arguments.of(0.25,'A',NumberNotInAreaException.class),
				Arguments.of(0.999999, 'P', NumberNotInAreaException.class),
				Arguments.of(11, '2', NotSupportedOperationException.class),
				Arguments.of(5.0, 'm', NotSupportedOperationException.class)
				);
	}
	
	
	
	
	

}
