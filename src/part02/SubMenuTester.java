package part02;

import java.io.ByteArrayInputStream;

import part01.SubMenu;

public class SubMenuTester {

    public static void main(String[] args) {
        boolean allPassed = true;
        System.out.println("Class in Test: SubMenu");
        System.out.println();
        allPassed &= testConstructor();
        allPassed &= testGetType();
        System.out.println("All Features Passed: " + allPassed);
        System.out.println();
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
            allPassed &= SubMenuTestCases.getUserChoiceTestCase(testMenu, expectedResult, scenario);
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
            allPassed &= SubMenuTestCases.getUserChoiceTestCase(testMenu, expectedResult, scenario);
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
            allPassed &= SubMenuTestCases.getTypeTestCase(testMenu, expectedResult, scenario);
        }

        /**
         * null parameter
         */
        {
            String subMenuType = null;
            SubMenu testMenu = new SubMenu(subMenuType);
            String expectedResult = null;
            String scenario = "Normal Operation";
            allPassed &= SubMenuTestCases.getTypeTestCase(testMenu, expectedResult, scenario);
        }

        System.out.println("\tFeature Passed: " + allPassed);
        System.out.println();
        return allPassed;

    }
}
