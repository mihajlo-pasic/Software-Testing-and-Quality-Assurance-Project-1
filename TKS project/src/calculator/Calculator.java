package calculator;

/**
 * Class Calculator serves the purpose of adding, subtracting, multiplying or dividing two values.
 * 
 * @author Mihajlo Pasic
 * @version 1.0
 * @since 4.12.2023
 */

public class Calculator {
	private double currentValue = 0;

	/**
	 * Getter for the private attribute currentValue
	 * 
	 * @return currentValue from Calculator
	 */
	public double getCurrentValue() {
		return currentValue;
	}

	/**
	 * Setter for the private attribute currentValue
	 * 
	 * @param currentValue in calculator
	 */
	public void setCurrentValue(double currentValue) {
		this.currentValue = currentValue;
	}
	
	/**
	 * Method calculate is used to perform the operation that the function provides.
	 * 
	 * @param value  the second operand.
	 * @param operator wanted operation.
	 * @throws DivisionByZeroException is thrown when a number is divided by 0
	 * @throws NotSupportedOperationException is thrown when a unsupported operator is provided as an argument
	 */
	public void calculate(Double value, char operator) throws DivisionByZeroException, NotSupportedOperationException {
		switch (operator) {
		case '+':
			this.currentValue += value;
			break;
		case '-':
			this.currentValue -= value;
			break;
		case '*':
			this.currentValue *= value;
			break;
		case '/':
			if (value == 0.0) throw new DivisionByZeroException();
			this.currentValue /= value;
			break;
		default:
			throw new NotSupportedOperationException();
		}

	}

}
