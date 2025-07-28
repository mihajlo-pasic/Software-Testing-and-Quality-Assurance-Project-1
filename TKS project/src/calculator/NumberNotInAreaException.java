package calculator;

/**
 * Exception class for when a number not in a defined area.
 * 
 * @author Mihajlo Pasic
 * @version 1.0
 * @since 4.12.2023
 *
 */

public class NumberNotInAreaException extends Exception{
	public NumberNotInAreaException() {
		super("Number not in defined area!");
	}
}
