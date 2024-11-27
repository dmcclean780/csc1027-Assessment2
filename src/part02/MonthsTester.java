package part02;

import part01.Months;

public class MonthsTester {

    public static void main(String[] args) {
        boolean allPassed = true;
        System.out.println("Class in Test: Months");
        System.out.println();
        allPassed &= testToString();
        allPassed &= testGetId();
        allPassed &= testGetByString();
        allPassed &= testGetById();
        allPassed &= testToArray();
        System.out.println("All Features Passed: " + allPassed);
        System.out.println();

    }

    /**
     * Test that each of the Months enums give the expected String
     * 
     * @return pass status of the entire test suite
     */
    public static boolean testToString() {
        System.out.println("\tFeature: Months enum toString");

        boolean allPassed = true;
        String[] months = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
                "October", "November", "December" };

        for (int i = 0; i < Months.values().length; i++) {

            Months month = Months.values()[i];
            String expectedString = months[i];
            String result = month.toString();
            boolean thisPassed = result.equals(expectedString);
            allPassed &= thisPassed;

            //if (!thisPassed) {
                System.out.println();
                System.out.println("\t\tScenario: Months enum is " + Months.values()[i]);
                System.out.println("\t\tGiven: expected months are " + ArraysMethods.toString(months));
                System.out.println("\t\tWhen: month.toString() called");
                System.out.println("\t\tThen: " + months[i] + " is returned");
                System.out.println("\t\tPassed: " + thisPassed);
                System.out.println("\t\tExpected Value: " + expectedString);
                System.out.println("\t\tGiven Value: " + result);
                System.out.println();
            //}

        }

        System.out.println("\tFeature Passed: " + allPassed);
        System.out.println();
        return allPassed;
    }

    /**
     * Test that every Months enum gives the correct int
     * 
     * @return passed
     */
    public static boolean testGetId() {
        System.out.println("\tFeature: Months enum getId");

        boolean allPassed = true;
        int[] expectedIds = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };
        for (int i = 0; i < Months.values().length; i++) {

            Months month = Months.values()[i];
            int expectedId = expectedIds[i];
            int result = month.getId();
            boolean thisPassed = expectedId == result;
            allPassed &= thisPassed;

            //if (!thisPassed) {
                System.out.println();
                System.out.println("\t\tScenario: Months enum is " + month);
                System.out.println("\t\tGiven: expected ids are " + ArraysMethods.toString(expectedIds));
                System.out.println("\t\tWhen: month.getid() called");
                System.out.println("\t\tThen: " + expectedId + " is returned");
                System.out.println("\t\tPassed: " + thisPassed);
                System.out.println("\t\tExpected Value: " + expectedId);
                System.out.println("\t\tGiven Value: " + result);
                System.out.println();
            //}

        }

        System.out.println("\tFeature Passed: " + allPassed);
        System.out.println();
        return allPassed;
    }

    /**
     * Test the get by String method
     * 
     * @return passed
     */
    public static boolean testGetByString() {
        System.out.println("\tFeature: Get Months enum by String");

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
                allPassed &= MonthsTestCases.getbyStringTestCase(givenString, expectedResult, scenario);
            }
        }
        /**
         * Test an invalid String gives null;
         */
        {
            String givenString = "abcdce";
            Months expectedResult = null;
            String scenario = "invalid id given";
            allPassed &= MonthsTestCases.getbyStringTestCase(givenString, expectedResult, scenario);
        }
        /**
         * Test a null String gives null
         */
        {
            String givenString = null;
            Months expectedResult = null;
            String scenario = "invalid id given";
            allPassed &= MonthsTestCases.getbyStringTestCase(givenString, expectedResult, scenario);
        }
        System.out.println("\tFeature Passed: " + allPassed);
        System.out.println();
        return allPassed;

    }

    /**
     * Test the get by int method
     * 
     * @return passed
     */
    public static boolean testGetById() {
        System.out.println("\tFeature: Get Months enum by id");

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
                allPassed &= MonthsTestCases.getbyIDTestCase(givenId, expectedResult, scenario);
            }
        }
        /**
         * Test an invalid int returns null
         */
        {
            int givenID = 12;
            Months expectedResult = null;
            String scenario = "invalid id given";
            allPassed &= MonthsTestCases.getbyIDTestCase(givenID, expectedResult, scenario);
        }
        System.out.println("\tFeature Passed: " + allPassed);
        System.out.println();
        return allPassed;

    }

    /**
     * Test the toArray method returns the expected array
     * 
     * @return passed
     */
    public static boolean testToArray() {
        System.out.println("\tFeature: toArray gives array of month names");

        boolean allPassed = true;
        String[] months = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
                "October", "November", "December" };
        String[] result = Months.toArray();
        boolean thisPassed = ArraysMethods.equals(result, months);
        allPassed &= thisPassed;

        //if (!thisPassed) {
            System.err.println();
            System.out.println("\t\tScenario: toArray called");
            System.err.println("\t\tGiven: expected months are " + ArraysMethods.toString(months));
            System.err.println("\t\tWhen: toArray is called");
            System.err.println("\t\tThen: array is " + ArraysMethods.toString(months));
            System.err.println("\t\tPassed: " + thisPassed);
            System.err.println("\t\tExpected Value: " + ArraysMethods.toString(months));
            System.err.println("\t\tGiven Value: " + ArraysMethods.toString(result));
            System.err.println();
        //}
        System.out.println("\tFeature Passed: " + allPassed);
        System.out.println();
        return allPassed;

    }

}
