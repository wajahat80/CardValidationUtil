package com.rwa.cards;

import com.ctm.cards.validator.CardValidator;

public class CardValidationApp {

	public static void main(String... args) {
		String[] cardNumbersList = new String[] { 
				"4111111111111111", 
				"4111111111111", 
				"4012888888881881",
				"378282246310005", 
				"6011111111111117", 
				"5105105105105100", 
				"5105 1051 0510 5106", 
				"9111111111111111" 
				};

		validate(cardNumbersList);

	}

	/**
	 * Takes an String array of card numbers and print the result
	 * @param cardNos String array as input
	 */
	public static void validate(String[] cardNos) {
		for (int i = 0; i < cardNos.length; i++) CardValidator.validateCard(cardNos[i]);
	}

}
