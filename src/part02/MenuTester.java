package part02;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import part01.Menu;

public class MenuTester {

    public static void main(String[] args) {
        boolean allPassed = true;
        allPassed &= testGetUserChoice();
        System.out.println("All Features Passed: " + allPassed);
    }

    public static boolean testGetUserChoice() {
        System.out.println("Feature: Menu getUserChoice");

        boolean allPassed = true;
        /**
         * Valid Input
         */
        {
            String input = "1\n";
            ByteArrayInputStream s = new ByteArrayInputStream(input.getBytes());
            System.setIn(s);

            String[] testOptions = { "opt1", "opt2", "opt3" };
            Menu testMenu = new Menu("test menu", testOptions);
            String expectedResult = "test menu\n" +
                    "+++++++++\n" +
                    "1. opt1\n" +
                    "2. opt2\n" +
                    "3. opt3\n" +
                    "\n" +
                    "Enter Selection:";
            String scenario = "Valid Input to menu";
            allPassed &= getUserChoiceTestCase(testMenu, expectedResult, scenario);
        }

        /**
         * No Input then Valid Input
         */
        {

            String input = "\n2\n";
            ByteArrayInputStream s = new ByteArrayInputStream(input.getBytes());
            System.setIn(s);
            String[] testOptions = { "opt1", "opt2", "opt3" };
            Menu testMenu = new Menu("test menu", testOptions);
            String expectedResult = "test menu\n" +
                    "+++++++++\n" +
                    "1. opt1\n" +
                    "2. opt2\n" +
                    "3. opt3\n" +
                    "\n" +
                    "Enter Selection:";
            String scenario = "No Input then a Valid Input";
            allPassed &= getUserChoiceTestCase(testMenu, expectedResult, scenario);
        }

        /**
         * Value Greater Than Max Value then valid Value
         */
        {

           String input = "4\n3\n";
            ByteArrayInputStream s = new ByteArrayInputStream(input.getBytes());
            System.setIn(s);
            String[] testOptions = { "opt1", "opt2", "opt3" };
            Menu testMenu = new Menu("test menu", testOptions);
            String expectedResult = "test menu\n" +
                    "+++++++++\n" +
                    "1. opt1\n" +
                    "2. opt2\n" +
                    "3. opt3\n" +
                    "\n" +
                    "Enter Selection: Enter Selection:";
            String scenario = "Value Greater Than Max Value then valid Value";
            allPassed &= getUserChoiceTestCase(testMenu, expectedResult, scenario);
        }

        /**
         * Value Less Than Min Value then valid Value
         */
        {

            String input = "-1\n1\n";
            ByteArrayInputStream s = new ByteArrayInputStream(input.getBytes());
            System.setIn(s);
            String[] testOptions = { "opt1", "opt2", "opt3" };
            Menu testMenu = new Menu("test menu", testOptions);
            String expectedResult = "test menu\n" +
                    "+++++++++\n" +
                    "1. opt1\n" +
                    "2. opt2\n" +
                    "3. opt3\n" +
                    "\n" +
                    "Enter Selection: Enter Selection:";
            String scenario = "Value Greater Than Max Value then valid Value";
            allPassed &= getUserChoiceTestCase(testMenu, expectedResult, scenario);
        }

        /**
         * String Value then valid Value
         */
        {

            String input = "a\n1\n";
            ByteArrayInputStream s = new ByteArrayInputStream(input.getBytes());
            System.setIn(s);
            String[] testOptions = { "opt1", "opt2", "opt3" };
            Menu testMenu = new Menu("test menu", testOptions);
            String expectedResult = "test menu\n" +
                    "+++++++++\n" +
                    "1. opt1\n" +
                    "2. opt2\n" +
                    "3. opt3\n" +
                    "\n" +
                    "Enter Selection: Enter Selection:";
            String scenario = "Value Greater Than Max Value then valid Value";
            allPassed &= getUserChoiceTestCase(testMenu, expectedResult, scenario);
        }

        {

            String input = "2\n";
            ByteArrayInputStream s = new ByteArrayInputStream(input.getBytes());
            System.setIn(s);
            String[] testOptions = { "opt1", "opt2", "opt3" };
            Menu testMenu = new Menu("test menu", testOptions);
            int expectedResult = 2;
            String scenario = "Check returned choice is correct";
            allPassed &= getUserChoiceTestCase(testMenu, expectedResult, scenario);
        }

        System.out.println("Feature Passed: " + allPassed);
        System.out.println();
        return allPassed;

    }

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

    public static boolean getUserChoiceTestCase(Menu testMenu, int expectedResult, String scenario) {
        PrintStream stdout = System.out;
        ByteArrayOutputStream result = new ByteArrayOutputStream();
        System.setOut(new PrintStream(result));

        int choice = testMenu.getUserChoice();
        boolean thisPassed = false;
        thisPassed = choice == expectedResult;

        System.setOut(stdout);


        if (!thisPassed) {
            System.out.println();
            System.out.println("Scenario:" + scenario);
            System.out.println("Given: given Menu is " + testMenu);
            System.out.println("When: menu.getUserChoice called");
            System.out.println("Then: output is:\n" + expectedResult);
            System.out.println("Passed: " + thisPassed);
            System.out.println("Expected Value:\n" + expectedResult);
            System.out.println("Given Value:\n" + choice);
            System.out.println();
        }
        return thisPassed;
    }
}
