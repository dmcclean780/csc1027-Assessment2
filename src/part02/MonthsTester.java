package part02;

import part01.ArraysMethods;
import part01.Months;

public class MonthsTester {

    public static void main(String[] args) {
        boolean allPassed = true;
        allPassed &= testToString();
        allPassed &= testGetId();
        allPassed &= testGetByString();
        allPassed &= testGetById();
        allPassed &= testToArray();
        System.out.println("All Features Passed: " + allPassed);

    }

    /**
     * Test that each of the Months enums give the expected String
     * 
     * @return pass status of the entire test suite
     */
    public static boolean testToString() {
        System.out.println("Feature: Months enum toString");

        boolean allPassed = true;
        String[] months = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
                "October", "November", "December" };

        for (int i = 0; i < Months.values().length; i++) {

            Months month = Months.values()[i];
            String expectedString = months[i];
            String result = month.toString();
            boolean thisPassed = result.equals(expectedString);
            allPassed &= thisPassed;

            if (!thisPassed) {
                System.out.println();
                System.out.println("Scenario: Months enum is " + Months.values()[i]);
                System.out.println("Given: expected months are " + ArraysMethods.toString(months));
                System.out.println("When: month.toString() called");
                System.out.println("Then: " + months[i] + " is returned");
                System.out.println("Passed: " + thisPassed);
                System.out.println("Expected Value: " + expectedString);
                System.out.println("Given Value: " + result);
                System.out.println();
            }

        }

        System.out.println("Feature Passed: " + allPassed);
        System.out.println();
        return allPassed;
    }

    /**
     * Test that every Months enum gives the correct int
     * 
     * @return
     */
    public static boolean testGetId() {
        System.out.println("Feature: Months enum getId");

        boolean allPassed = true;
        int[] expectedIds = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };
        for (int i = 0; i < Months.values().length; i++) {

            Months month = Months.values()[i];
            int expectedId = expectedIds[i];
            int result = month.getId();
            boolean thisPassed = expectedId == result;
            allPassed &= thisPassed;

            if (!thisPassed) {
                System.out.println();
                System.out.println("Scenario: Months enum is " + month);
                System.out.println("Given: expected ids are " + ArraysMethods.toString(expectedIds));
                System.out.println("When: month.getid() called");
                System.out.println("Then: " + expectedId + " is returned");
                System.out.println("Passed: " + thisPassed);
                System.out.println("Expected Value: " + expectedId);
                System.out.println("Given Value: " + result);
                System.out.println();
            }

        }

        System.out.println("Feature Passed: " + allPassed);
        System.out.println();
        return allPassed;
    }

    /**
     * Test the get by String method
     * 
     * @return
     */
    public static boolean testGetByString() {
        System.out.println("Feature: Get Months enum by String");

        boolean allPassed = true;
        /**
         * Test each month can be got by its expected String
         */
        {
            String[] givenMonths = { "January", "February", "March", "April", "May", "June", "July", "August",
                    "September",
                    "October", "November", "December" };
            ;
            for (int i = 0; i < Months.values().length; i++) {
                Months expectedResult = Months.values()[i];
                String givenString = givenMonths[i];
                String scenario = "valid String";
                allPassed &= getbyStringTestCase(givenString, expectedResult, scenario);
            }
        }
        /**
         * Test an invalid String gives null;
         */
        {
            String givenString = "abcdce";
            Months expectedResult = null;
            String scenario = "invalid id given";
            allPassed &= getbyStringTestCase(givenString, expectedResult, scenario);
        }
        /**
         * Test a null String gives null
         */
        {
            String givenString = null;
            Months expectedResult = null;
            String scenario = "invalid id given";
            allPassed &= getbyStringTestCase(givenString, expectedResult, scenario);
        }
        System.out.println("Feature Passed: " + allPassed);
        System.out.println();
        return allPassed;

    }

    /**
     * Test the get by int method
     * 
     * @return
     */
    public static boolean testGetById() {
        System.out.println("Feature: Get Months enum by id");

        boolean allPassed = true;
        /**
         * Test each get return the correct Months enum for every
         * expected int
         */
        {
            int[] givenIds = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };
            for (int i = 0; i < Months.values().length; i++) {
                Months expectedResult = Months.values()[i];
                int givenId = givenIds[i];
                String scenario = "valid id";
                allPassed &= getbyIDTestCase(givenId, expectedResult, scenario);
            }
        }
        /**
         * Test an invalid int returns null
         */
        {
            int givenID = 12;
            Months expectedResult = null;
            String scenario = "invalid id given";
            allPassed &= getbyIDTestCase(givenID, expectedResult, scenario);
        }
        System.out.println("Feature Passed: " + allPassed);
        System.out.println();
        return allPassed;

    }

    /**
     * Test the toArray method returns the expected array
     * 
     * @return
     */
    public static boolean testToArray() {
        System.out.println("Feature: toArray gives array of month names");

        boolean allPassed = true;
        String[] months = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
                "October", "November", "December" };
        String[] result = Months.toArray();
        boolean thisPassed = ArraysMethods.equals(result, months);
        allPassed &= thisPassed;

        if (!thisPassed) {
            System.out.println();
            System.out.println("Scenario: toArray called");
            System.out.println("Given: expected months are " + ArraysMethods.toString(months));
            System.out.println("When: toArray is called");
            System.out.println("Then: array is " + ArraysMethods.toString(months));
            System.out.println("Passed: " + thisPassed);
            System.out.println("Expected Value: " + ArraysMethods.toString(months));
            System.out.println("Given Value: " + ArraysMethods.toString(result));
            System.out.println();
        }
        System.out.println("Feature Passed: " + allPassed);
        System.out.println();
        return allPassed;

    }

    public static boolean getbyStringTestCase(String givenString, Months expectedResult, String scenario) {
        Months result = Months.get(givenString);
        boolean thisPassed = result == expectedResult;

        if (!thisPassed) {
            System.out.println();
            System.out.println("Scenario:" + scenario);
            System.out.println("Given: given id is " + givenString);
            System.out.println("When: Months.get() called with " + givenString);
            System.out.println("Then: m is " + expectedResult);
            System.out.println("Passed: " + thisPassed);
            System.out.println("Expected Value: " + expectedResult);
            System.out.println("Given Value: " + result);
            System.out.println();
        }
        return thisPassed;
    }

    public static boolean getbyIDTestCase(int givenID, Months expectedResult, String scenario) {
        Months result = Months.get(givenID);
        boolean thisPassed = result == expectedResult;

        if (!thisPassed) {
            System.out.println();
            System.out.println("Scenario:" + scenario);
            System.out.println("Given: given id is " + givenID);
            System.out.println("When: Months.get() called with " + givenID);
            System.out.println("Then: m is " + expectedResult);
            System.out.println("Passed: " + thisPassed);
            System.out.println("Expected Value: " + expectedResult);
            System.out.println("Given Value: " + result);
            System.out.println();
        }
        return thisPassed;
    }

}
