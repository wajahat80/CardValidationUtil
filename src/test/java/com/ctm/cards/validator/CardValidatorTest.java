package com.ctm.cards.validator;

import static org.junit.Assert.*;
import org.junit.Test;

import com.ctm.cards.validator.CardValidator;

public class CardValidatorTest {

	@Test
	public void testCardProcessor() throws Exception {
		assertTrue(CardValidator.validateCard("4111111111111111"));
		assertFalse(CardValidator.validateCard("4111111111111"));
		assertTrue(CardValidator.validateCard("4012888888881881"));
		assertTrue(CardValidator.validateCard("378282246310005"));
		assertTrue(CardValidator.validateCard("6011111111111117"));
		assertTrue(CardValidator.validateCard("5105105105105100"));
		assertFalse(CardValidator.validateCard("5105 1051 0510 5106"));
		assertFalse(CardValidator.validateCard("9111111111111111"));

	}
}
