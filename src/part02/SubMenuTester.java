package part02;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import part01.SubMenu;

public class SubMenuTester {

    public static void main(String[] args) {
        boolean allPassed = true;
        System.out.println("Class in Test: SubMenu");
        System.out.println();
        allPassed &= testConstructor();
        allPassed &= testGetType();
        System.out.println("All Features Passed: " + allPassed);
    }

    /**
     * Test Suit for the constructor using the print of getUserChoice
     * @return all tests passed
     */
    public static boolean testConstructor() {
        System.out.println("\tFeature: SubMenu constructor via getUserChoice");

        boolean allPassed = true;

        /**
         * Normal Construction
         */
        {
            String input = "1\n";
            ByteArrayInputStream s = new ByteArrayInputStream(input.getBytes());
            System.setIn(s);
            String subMenuType = "Tester";
            SubMenu testMenu = new SubMenu(subMenuType);
            String expectedResult = "Manage Testers\n" +
                    "++++++++++++++\n" +
                    "1. Add Tester\n" +
                    "2. View Tester\n" +
                    "3. Update Tester\n" +
                    "4. Delete Tester\n" +
                    "5. Quit\n" +
                    "\n" +
                    "Enter Selection: ";
            String scenario = "Normal Construction";
            allPassed &= getUserChoiceTestCase(testMenu, expectedResult, scenario);
        }

        /**
         * null Parameter
         */
        {
            String input = "1\n";
            ByteArrayInputStream s = new ByteArrayInputStream(input.getBytes());
            System.setIn(s);
            String subMenuType = null;
            SubMenu testMenu = new SubMenu(subMenuType);
            String expectedResult = "Manage nulls\n" +
                    "++++++++++++\n" +
                    "1. Add null\n" +
                    "2. View null\n" +
                    "3. Update null\n" +
                    "4. Delete null\n" +
                    "5. Quit\n" +
                    "\n" +
                    "Enter Selection: ";
            String scenario = "Normal Construction";
            allPassed &= getUserChoiceTestCase(testMenu, expectedResult, scenario);
        }

        System.out.println("\tFeature Passed: " + allPassed);
        System.out.println();
        return allPassed;
    }

    /**
     * Test Suit for the getType method
     * @return all tests passed
     */
    public static boolean testGetType() {
        System.out.println("\tFeature: SubMenu getType");

        boolean allPassed = true;

        /**
         * Normal Operation
         */
        {
            String subMenuType = "Tester";
            SubMenu testMenu = new SubMenu(subMenuType);
            String expectedResult = "Tester";
            String scenario = "Normal Operation";
            allPassed &= getTypeTestCase(testMenu, expectedResult, scenario);
        }

        /**
         * null parameter
         */
        {
            String subMenuType = null;
            SubMenu testMenu = new SubMenu(subMenuType);
            String expectedResult = null;
            String scenario = "Normal Operation";
            allPassed &= getTypeTestCase(testMenu, expectedResult, scenario);
        }

        System.out.println("\tFeature Passed: " + allPassed);
        System.out.println();
        return allPassed;

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
}
