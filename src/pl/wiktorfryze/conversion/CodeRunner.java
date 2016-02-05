package pl.wiktorfryze.conversion;

public class CodeRunner {

    public static void main(String[] args) {

        System.out.println("\n\n\n############################## [ROMAN TO DECIMAL CONVERSION - CODE] ###############################\n");

        if (args.length != 1) {
            System.out.println(" Calculation result: FAILED:\n\n Incorrect number of program input arguments.");
        } else {
            String input = args[0];
            System.out.println(" Input value is [ " + input + " ].");
            System.out.println();
            RomanToDecimalConverter converter = new RomanToDecimalConverter();
            int result = 0;
            try {
                result = converter.convertRomToDec(input);
                System.out.println(" Calculation result: SUCCESS.\n\n Number representation of Roman Numeral [ " + input
                        + " ] is [ " + result + " ].");
            } catch (IllegalArgumentException ex) {
                System.out.println(" Calculation result: FAILED.\n\n Input value [ " + input
                        + " ] is incorrect. Reason: " + ex.getMessage() + ".");
            }
        }
        System.out.println("\n###################################################################################################\n\n\n");
    }
}