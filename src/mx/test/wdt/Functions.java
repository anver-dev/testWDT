package mx.test.wdt;

import java.util.ArrayList;

/**
 * Functions to util
 * @author anver
 *
 */
public class Functions {
	
	/**
	 * Method to validate if a string is unique
	 * 
	 * @param stringToValidate string to validate
	 * @return true if unique, false if not
	 */
	public boolean hasUniqueCharacters(String stringToValidate) {
		String newStringToValidate = stringToValidate.toLowerCase(); 

		while (newStringToValidate.length() != 0) {
			for (int index = 1; index < newStringToValidate.length(); index++) {
				if (newStringToValidate.charAt(0) == newStringToValidate.charAt(index))
					return false;
			}
			newStringToValidate = newStringToValidate.replaceAll(newStringToValidate.charAt(0) + "", "");
		}
		return true;
	}
	
	/**
	 * Method to obtain the prime numbers of a given range
	 * 
	 * @param numberStart start of range
	 * @param numberEnd end of range
	 * @return list of prime numbers
	 */
	public ArrayList<Integer> primeNumbers(int numberStart, int numberEnd) {
		ArrayList<Integer> listPrimeNumbers = new ArrayList<>();
		
		for (int numberTest = numberStart; numberTest <= numberEnd; numberTest++) {
			if (isPrime(numberTest)) 
				listPrimeNumbers.add(numberTest);
		}
		
		return listPrimeNumbers;
	}
	
	/**
	 * Method to validate if a number is prime
	 * @param numberTest number to validate
	 * @return true if is prime, false if not.
	 */
	private boolean isPrime(int numberTest) {

		if (numberTest == 0 || numberTest == 1 || numberTest == 4)
			return false;

		for (int index = 2; index < numberTest / 2; index++) {
			if (numberTest % index == 0)
				return false;
		}
		return true;
	}
}
