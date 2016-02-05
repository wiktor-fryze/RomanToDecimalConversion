package pl.wiktorfryze.conversion;

public class RomanToDecimalConverter {

    public int convertRomToDec(String input) {

        if (input == null) {
            throw new IllegalArgumentException("input value can not be null");
        }

        input = input.trim();

        if (input.isEmpty()) {
            throw new IllegalArgumentException("input value can not be an empty string");
        }

        String uppercaseInput = input.toUpperCase();
        RomanNumberValidator validator = new RomanNumberValidator();
        if (!validator.validate(uppercaseInput)) {
            throw new IllegalArgumentException("input value is not a valid Roman number format");
        }

        int result = 0;
        int lastNumber = 0;
        for (int x = uppercaseInput.length() - 1; x >= 0; x--) {
            char nextChar = uppercaseInput.charAt(x);
            switch (nextChar) {
                case 'M':
                    result = addSubPrinciples(1000, lastNumber, result);
                    lastNumber = 1000;
                    break;
                case 'D':
                    result = addSubPrinciples(500, lastNumber, result);
                    lastNumber = 500;
                    break;
                case 'C':
                    result = addSubPrinciples(100, lastNumber, result);
                    lastNumber = 100;
                    break;
                case 'L':
                    result = addSubPrinciples(50, lastNumber, result);
                    lastNumber = 50;
                    break;
                case 'X':
                    result = addSubPrinciples(10, lastNumber, result);
                    lastNumber = 10;
                    break;
                case 'V':
                    result = addSubPrinciples(5, lastNumber, result);
                    lastNumber = 5;
                    break;
                case 'I':
                    result = addSubPrinciples(1, lastNumber, result);
                    lastNumber = 1;
                    break;
                default:
                    throw new IllegalArgumentException("input value contains not permitted chars");
            }
        }
        return result;
    }

    private int addSubPrinciples(int currentNumber, int lastNumber, int result) {
        if (lastNumber > currentNumber) {
            return result - currentNumber;
        } else {
            return result + currentNumber;
        }
    }
}