package calculator;

/**
 * Class Calculator serves the purpose of performing a more complex set of operations which includes 
 * factorials, exponents and checking if a number is perfect or Armstrong.
 * 
 * @author Mihajlo Pasic
 * @version 1.0
 * @since 4.12.2023
 */
public class CalculatorAdvanced extends Calculator {

	/**
	 * Private method that returns the factorial of the given number.
	 * 
	 * @param num value for which factorial is calculated.
	 * @return the factorial result.
	 */
	private int factorial(int num) {
		if (num == 0 || num == 1)
			return 1;
		int factorial = 1;
		while (num != 1) {
			factorial *= num;
			num--;
		}
		return factorial;
	}

	/**
	 * Private method that returns the value to the power of the given exponent.
	 * 
	 * @param num value given to perform the operation.
	 * @param pow given exponent.
	 * @return the result of the power function.
	 */
	private int power(int num, int pow) {
		if (pow == 0)
			return 1;
		int result = 1;
		for (int i = 0; i < pow; i++) {
			result *= num;
		}
		return result;

	}

	/**
	 * Method calculateAdvanced performs different operations based on the input character.
	 * If the input character is '!' then factorial operation will be performed on the currentValue in the calculator.
	 * If the input character is a number between '0' and '9' then the exponentiation function will be performed.
	 * 
	 * @param action input character.
	 * @throws NotSupportedOperationException is thrown when a unsupported operator is provided as an argument.
	 * @throws NumberNotInAreaException is thrown when the current value in calculator is less or equal to 0.
	 */
	public void calculateAdvanced(char action) throws NotSupportedOperationException, NumberNotInAreaException {
		if (action == '!') {
			if (this.getCurrentValue() < 0 || this.getCurrentValue() > 10)
				throw new NumberNotInAreaException();
			this.setCurrentValue(factorial((int) this.getCurrentValue()));
			return;
		}
		if (action >= '0' && action <= '9') {
			int power = Integer.parseInt(String.valueOf(action));
			this.setCurrentValue(power((int) this.getCurrentValue(), power));
			return;
		}
		throw new NotSupportedOperationException();
	}

	/**
	 * Private function to check if a number is an Armstrong number.
	 * 
	 * @param num value to be checked.
	 * @return the check result.
	 */
	private Boolean checkIfArmstrong(int num) {
		int digitNum = 0;
		int temp = num;
		while (temp != 0) {
			temp /= 10;
			digitNum++;
		}
		temp = num;
		int digit;
		int result = 0;
		while (temp != 0) {
			digit = temp % 10;
			result += power(digit, digitNum);
			temp /= 10;
		}
		return result == num ? true : false;
	}

	/**
	 * Private function to check if a number is perfect.
	 * 
	 * @param num value to be checked.
	 * @return the check result.
	 */
	private Boolean checkIfPerfect(int num) {
		int result = 0;
		int x = 1;
		while (x <= num / 2) {
			if (num % x == 0)
				result += x;
			x++;
		}
		return result == num ? true : false;
	}

	/**
	 * Method hasCharacterisic performs different checking operations based on the input character.
	 * If the input character is 'A' then the function checks if the currentValue in calculator is an Armstrong number.
	 * If the input character is 'P' then the function checks if the currentValue in calculator is a perfect number.
	 * 
	 * @param value input character.
	 * @return the check result.
	 * @throws NotSupportedOperationException is thrown when a unsupported operator is provided as an argument.
	 * @throws NumberNotInAreaException is thrown when the current value in calculator is less or equal to 0.
	 */
	public Boolean hasCharacteristic(char value) throws NotSupportedOperationException, NumberNotInAreaException {
		if ((int) this.getCurrentValue() <= 0)
			throw new NumberNotInAreaException();
		if (value == 'A') {
			return checkIfArmstrong((int) this.getCurrentValue());
		}
		if (value == 'P') {
			return checkIfPerfect((int) this.getCurrentValue());
		}
		throw new NotSupportedOperationException();
	}


}
