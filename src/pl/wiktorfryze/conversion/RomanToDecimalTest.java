package pl.wiktorfryze.conversion;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class RomanToDecimalTest {

    private RomanToDecimalConverter converter;
    private RomanNumberValidator validator;

    @Before
    public void setUp() {
        converter = new RomanToDecimalConverter();
        validator = new RomanNumberValidator();
    }

    @Test(expected = IllegalArgumentException.class)
    public final void testIncorrectInputForNullValue() {
        converter.convertRomToDec(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public final void testIncorrectInputForEmptyString() {
        converter.convertRomToDec("");
    }

    @Test(expected = IllegalArgumentException.class)
    public final void testIncorrectInputForValueNotInRomanFormatWrongChars() {
        converter.convertRomToDec("AB");
    }

    @Test(expected = IllegalArgumentException.class)
    public final void testIncorrectInputForValueNotInRomanFormatAllowedChars() {
        converter.convertRomToDec("IIIVXI");
    }

    @Test
    public final void testCorrectInputForSingleChars() {
        assertEquals(converter.convertRomToDec("I"), 1);
        assertEquals(converter.convertRomToDec("V"), 5);
        assertEquals(converter.convertRomToDec("X"), 10);
        assertEquals(converter.convertRomToDec("L"), 50);
        assertEquals(converter.convertRomToDec("C"), 100);
        assertEquals(converter.convertRomToDec("D"), 500);
        assertEquals(converter.convertRomToDec("M"), 1000);
    }

    @Test
    public final void testCorrectInputForMultipleSameChars() {
        assertEquals(converter.convertRomToDec("II"), 2);
        assertEquals(converter.convertRomToDec("XXX"), 30);
    }

    @Test
    public final void testCorrectInputForAdditiveCalc() {
        assertEquals(converter.convertRomToDec("VI"), 6);
        assertEquals(converter.convertRomToDec("XXXVI"), 36);
        assertEquals(converter.convertRomToDec("MMXII"), 2012);
    }

    @Test
    public final void testCorrectInputForSubstractiveCalc() {
        assertEquals(converter.convertRomToDec("IV"), 4);
        assertEquals(converter.convertRomToDec("XIV"), 14);
        assertEquals(converter.convertRomToDec("MCMXCVII"), 1997);
    }

    @Test
    public final void testCorrectInputForLowercase() {
        assertEquals(converter.convertRomToDec("vi"), 6);
        assertEquals(converter.convertRomToDec("xxxvi"), 36);
        assertEquals(converter.convertRomToDec("mmxii"), 2012);
    }

    @Test
    public final void testCorrectInputForMixedcase() {
        assertEquals(converter.convertRomToDec("ViI"), 7);
        assertEquals(converter.convertRomToDec("xIv"), 14);
        assertEquals(converter.convertRomToDec("McmXCvii"), 1997);
    }

    @Test
    public final void testCorrectInputWithLeadingWhitespaces() {
        assertEquals(converter.convertRomToDec(" VII"), 7);
        assertEquals(converter.convertRomToDec("  XIV"), 14);
        assertEquals(converter.convertRomToDec("   MCMXCVII"), 1997);
    }

    @Test
    public final void testCorrectInputWithTrailingWhitespaces() {
        assertEquals(converter.convertRomToDec("VII "), 7);
        assertEquals(converter.convertRomToDec("XIV  "), 14);
        assertEquals(converter.convertRomToDec("MCMXCVII   "), 1997);
    }

    @Test
    public final void testValidatorIncorrectInputForNullValue() {
        assertTrue(!validator.validate(null));
    }

    @Test
    public final void testValidatorIncorrectInputForEmptyString() {
        assertTrue(!validator.validate(""));
    }

    @Test
    public final void testValidatorIncorrectInputForValueNotInRomanFormatWrongChars() {
        assertTrue(!validator.validate("AB"));
    }

    @Test
    public final void testValidatorIncorrectInputForValueNotInRomanFormatAllowedChars() {
        assertTrue(!validator.validate("IIIVXI"));
    }

    @Test
    public final void testValidatorCorrectRomanNumber() {
        assertTrue(validator.validate("XVIII"));
    }
}