package mx.test.wdt;

import java.util.ArrayList;

/**
 * Flow management class
 * @author anver
 *
 */
public class Manejador {


	private Functions functions = new Functions();

	/**
	 * Window ends
	 *
	 */
	public void finaliza() {
		System.exit(0);
	}
	
	/**
	 * Method to validate if a string is unique
	 * 
	 * @param stringToValidate
	 * @return true if unique, false if not
	 */
	public boolean hasUniqueChair(String stringToValidate) {
		return functions.hasUniqueCharacters(stringToValidate);
	}
	
	/**
	 * Method to obtain the prime numbers of a given range
	 * 
	 * @param numberStart start of range
	 * @param numberEnd end of range
	 * @return list of prime numbers
	 */
	public ArrayList<Integer> getPrimeNumbers(String startNumber, String endNumber) {
		return functions.primeNumbers(Integer.parseInt(startNumber), Integer.parseInt(endNumber));
	}
}
