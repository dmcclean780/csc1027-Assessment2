package part02;

import java.io.ByteArrayInputStream;

import part01.Menu;

public class MenuTester {

    public static void main(String[] args) {
        boolean allPassed = true;
        System.out.println("Class in Test: Menu");
        System.out.println();
        allPassed &= testGetUserChoice();
        System.out.println("All Features Passed: " + allPassed);
        System.out.println();
    }

    /**
     * Test Suit for the getUserChoice method
     * @return all tests passed
     */
    public static boolean testGetUserChoice() {
        System.out.println("\tFeature: Menu getUserChoice");

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
            allPassed &= MenuTestCases.getUserChoiceTestCase(testMenu, expectedResult, scenario);
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
            allPassed &= MenuTestCases.getUserChoiceTestCase(testMenu, expectedResult, scenario);
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
            allPassed &= MenuTestCases.getUserChoiceTestCase(testMenu, expectedResult, scenario);
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
            allPassed &= MenuTestCases.getUserChoiceTestCase(testMenu, expectedResult, scenario);
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
            allPassed &= MenuTestCases.getUserChoiceTestCase(testMenu, expectedResult, scenario);
        }

        /**
         * Check it returns the correct choice
         */
        {

            String input = "2\n";
            ByteArrayInputStream s = new ByteArrayInputStream(input.getBytes());
            System.setIn(s);
            String[] testOptions = { "opt1", "opt2", "opt3" };
            Menu testMenu = new Menu("test menu", testOptions);
            int expectedResult = 2;
            String scenario = "Check returned choice is correct";
            allPassed &= MenuTestCases.getUserChoiceTestCase(testMenu, expectedResult, scenario);
        }

        System.out.println("\tFeature Passed: " + allPassed);
        System.out.println();
        return allPassed;

    }
}
