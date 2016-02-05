package pl.wiktorfryze.conversion;

public class RomanNumberValidator {

    private final static String ROMAN_NUMBER_REGEX = "^M{0,4}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$";

    public boolean validate(final String input) {
        if (input == null || input.isEmpty()) {
            return false;
        } else {
            return input.trim().toUpperCase().matches(ROMAN_NUMBER_REGEX);
        }
    }
}