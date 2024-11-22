package part02;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import part01.SubMenu;

public class SubMenuTestCases {

    /**
     * Test for getType
     * @param testMenu
     * @param expectedResult
     * @param scenario
     * @return passed
     */
    public static boolean getTypeTestCase(SubMenu testMenu, String expectedResult, String scenario){
        String result = testMenu.getType();
    
        boolean thisPassed = result==null ?  expectedResult==null : result.equals(expectedResult);
    
        if (!thisPassed) {
            System.err.println();
            System.err.println("Scenario:" + scenario);
            System.err.println("Given: given Menu is " + testMenu);
            System.err.println("When: menu.getUserChoice called");
            System.err.println("Then: output is:\n" + expectedResult);
            System.err.println("Passed: " + thisPassed);
            System.err.println("Expected Value:\n" + expectedResult);
            System.err.println("Given Value:\n" + result);
            System.err.println();
        }
        return thisPassed;
    }

    /**
     * Tets for getUserChoice printing correctly
     * @param testMenu
     * @param expectedResult
     * @param scenario
     * @return choice
     */
    public static boolean getUserChoiceTestCase(SubMenu testMenu, String expectedResult, String scenario) {
    
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
    
        if (!thisPassed) {
            System.err.println();
            System.err.println("Scenario:" + scenario);
            System.err.println("Given: given Menu is " + testMenu);
            System.err.println("When: menu.getUserChoice called");
            System.err.println("Then: output is:\n" + expectedResult);
            System.err.println("Passed: " + thisPassed);
            System.err.println("Expected Value:\n" + expectedResult);
            System.err.println("Given Value:\n" + result);
            System.err.println();
        }
        return thisPassed;
    }
    
}
