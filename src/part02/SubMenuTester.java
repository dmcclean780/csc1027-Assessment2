package part02;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import part01.SubMenu;

public class SubMenuTester {

    public static void main(String[] args) {
        boolean allPassed = true;
        allPassed &= testConstructor();
        allPassed &= testGetType();
        System.out.println("All Features Passed: " + allPassed);
    }

    public static boolean testConstructor() {
        System.out.println("Feature: SubMenu constructor via getUserChoice");

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

        System.out.println("Feature Passed: " + allPassed);
        System.out.println();
        return allPassed;
    }

    public static boolean testGetType() {
        System.out.println("Feature: SubMenu getType");

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

        System.out.println("Feature Passed: " + allPassed);
        System.out.println();
        return allPassed;

    }

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
            System.out.println();
            System.out.println("Scenario:" + scenario);
            System.out.println("Given: given Menu is " + testMenu);
            System.out.println("When: menu.getUserChoice called");
            System.out.println("Then: output is:\n" + expectedResult);
            System.out.println("Passed: " + thisPassed);
            System.out.println("Expected Value:\n" + expectedResult);
            System.out.println("Given Value:\n" + result);
            System.out.println();
        }
        return thisPassed;
    }

    public static boolean getTypeTestCase(SubMenu testMenu, String expectedResult, String scenario){
        String result = testMenu.getType();

        boolean thisPassed = result==null ?  expectedResult==null : result.equals(expectedResult);

        if (!thisPassed) {
            System.out.println();
            System.out.println("Scenario:" + scenario);
            System.out.println("Given: given Menu is " + testMenu);
            System.out.println("When: menu.getUserChoice called");
            System.out.println("Then: output is:\n" + expectedResult);
            System.out.println("Passed: " + thisPassed);
            System.out.println("Expected Value:\n" + expectedResult);
            System.out.println("Given Value:\n" + result);
            System.out.println();
        }
        return thisPassed;
    }
}
