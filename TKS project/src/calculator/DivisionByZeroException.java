package calculator;

/**
 * Exception class for when a number is divided by zero.
 * 
 * @author Mihajlo Pasic
 * @version 1.0
 * @since 4.12.2023
 *
 */
public class DivisionByZeroException extends Exception {
	public DivisionByZeroException() {
		super("Division by zero!");
	}
}
