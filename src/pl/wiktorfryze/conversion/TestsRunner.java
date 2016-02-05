package pl.wiktorfryze.conversion;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestsRunner {

    public static void main(String[] args) {

        Result result = JUnitCore.runClasses(RomanToDecimalTest.class);

        int testsRun = result.getRunCount();
        int testsFailed = result.getFailureCount();
        int testsIgnored = result.getIgnoreCount();
        int testsSucceded = testsRun - testsFailed - testsIgnored;
        long time = result.getRunTime();

        System.out.println("\n\n\n############################## [ROMAN TO DECIMAL CONVERSION - TESTS] ##############################\n");

        System.out.println(" Tests result : " + (result.wasSuccessful() ? "SUCCESS" : "FAILURE" + "\n"));
        System.out.printf(" Tests run: %d, Succeded: %d, Failures: %d, Skipped: %d, Time elapsed: %d miliseconds\n",
                testsRun, testsSucceded, testsFailed, testsIgnored, time);

        if (!result.wasSuccessful()) {
            System.out.println("\n Failed tests:");
        }
        for (Failure failure : result.getFailures()) {
            System.out.println("  - " + failure.getDescription().getDisplayName());
            System.out.println("     " + failure.getMessage());
        }
        System.out.println("\n###################################################################################################\n\n\n");
    }
}