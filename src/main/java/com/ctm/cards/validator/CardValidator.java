package com.ctm.cards.validator;

public class CardValidator {
	
	private CardValidator(){
		
	}
	
	/**
	 * The method takes String argument validates the input String is a number
	 * validates Luhn Algorithm, Print result summary on the console and return
	 * result as true if validated else return false
	 * @param cardNo
	 * @return boolean validation result
	 */
	public static boolean validateCard(String cardNo) {
		String cardType = "Unknown";

		/** Replace the whitespace or hyphen */
		cardNo = cardNo.replaceAll("\\s+", "").replaceAll("[-]+", "");

		/** Validate input must be a number */
		boolean isNumber = cardNo.matches("[0-9]+");

		if (isNumber) {
			if ((cardNo.matches("3[47][0-9]+"))
					&& cardNo.length() == 15) {/** AMEX | 34 or37 | 15 | */
				cardType = "AMEX";
			} else if (cardNo.startsWith("6011")
					&& cardNo.length() == 16) {/** Discover | 6011|16| */
				cardType = "Discover";
			} else if (cardNo.matches("5[1-5][0-9]+") && cardNo.length() == 16) {/** MasterCard|51-55|16| */
				cardType = "MasterCard";
			} else if (cardNo.startsWith("4") && (cardNo.length() == 16
					|| cardNo.length() == 13)) { /** Visa|4|13 or 16| */
				cardType = "VISA";
			}
		}

		boolean isValidatedLuhn = validateLuhn(cardNo); /** Validate Luhn algorithm */

		if (isValidatedLuhn && isNumber) {
			System.out.println(cardType + ": " + cardNo + " (valid)");
			return true;
		} else {
			System.out.println(cardType + ": " + cardNo + " (invalid)");
			return false;
		}
	}

	/**
	 * The method takes String of digits as argument, validate Luhn algorithm
	 * and return true if condition validates successful otherwise return false;
	 * @param str String numeric number
	 * @return boolean value
	 */
	private static boolean validateLuhn(String str) {
		int[] intArr = convertToIntArr(str);
		int sum = 0; /** Sum of all the digits */
		boolean doMore = false; /** Flag for Perform further calculations */

		for (int i = intArr.length - 1; i >= 0; i--) {

			if (doMore == false) {
				sum += intArr[i];
				doMore = true;

			} else {
				if (intArr[i] * 2 <= 9) {
					sum += intArr[i] * 2;
				} else {
					int temp[] = convertToIntArr(Integer.toString((intArr[i] * 2)));
					sum += (temp[0] + temp[1]);
				}
				doMore = false;
			}
		}

		if (sum % 10 == 0) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * This method will take string of digits and convert it to int[]
	 * @param str String value
	 * @return int[]
	 */
	private static int[] convertToIntArr(String str) {
		return str.chars().map(x -> x - '0').toArray();
	}
}
