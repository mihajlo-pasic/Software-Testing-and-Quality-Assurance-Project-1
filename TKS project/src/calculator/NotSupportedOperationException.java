package calculator;

/**
 * Exception class for when a unsupported operator is provided.
 * 
 * @author Mihajlo Pasic
 * @version 1.0
 * @since 4.12.2023
 *
 */
public class NotSupportedOperationException extends Exception {
	public NotSupportedOperationException() {
		super("Not supported operation!");
	}
}
