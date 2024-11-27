package part02;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import part01.Menu;

public class MenuTestCases {

    /**
     * Test getUserChoice method returns correct choice
     * @param testMenu
     * @param expectedResult
     * @param scenario
     * @return passed
     */
    public static boolean getUserChoiceTestCase(Menu testMenu, int expectedResult, String scenario) {
        PrintStream stdout = System.out;
        ByteArrayOutputStream result = new ByteArrayOutputStream();
        System.setOut(new PrintStream(result));
    
        int choice = testMenu.getUserChoice();
        boolean thisPassed = false;
        thisPassed = choice == expectedResult;
    
        System.setOut(stdout);
    
    
        if (!thisPassed) {
            System.err.println();
            System.err.println("Scenario:" + scenario);
            System.err.println("Given: given Menu is " + testMenu);
            System.err.println("When: menu.getUserChoice called");
            System.err.println("Then: output is:\n" + expectedResult);
            System.err.println("Passed: " + thisPassed);
            System.err.println("Expected Value:\n" + expectedResult);
            System.err.println("Given Value:\n" + choice);
            System.err.println();
        }
        return thisPassed;
    }

    /**
     * Test getUserChoice method prints correctly
     * @param testMenu
     * @param expectedResult
     * @param scenario
     * @return passed
     */
    public static boolean getUserChoiceTestCase(Menu testMenu, String expectedResult, String scenario) {
    
        PrintStream stdout = System.out;
        ByteArrayOutputStream result = new ByteArrayOutputStream();
        System.setOut(new PrintStream(result));
        testMenu.getUserChoice();
        boolean thisPassed = false;
        try {
            thisPassed = expectedResult.trim().equals(result.toString("UTF-8").trim());
        } catch (Exception e) {
            System.out.println(e);
        }
    
        System.setOut(stdout);
    
        //if (!thisPassed) {
            System.err.println();
            System.err.println("\t\tScenario:" + scenario);
            System.err.println("\t\tGiven: given Menu is " + testMenu);
            System.err.println("\t\tWhen: menu.getUserChoice called");
            System.err.println("\t\tThen: output is:\n" + expectedResult);
            System.err.println("\t\tPassed: " + thisPassed);
            System.err.println("\t\tExpected Value:\n" + expectedResult);
            System.err.println("\t\tGiven Value:\n" + result);
            System.err.println();
       // }
        return thisPassed;
    }
    
}
