package part02;

import part01.ExhibitManagement;
import part01.ExhibitionPlan;

public class ExhibitionPlanTester {
    public static void main(String[] args) {
        boolean allPassed = true;
        System.out.println("Class in Test: ExhibitionPlan");
        System.out.println();
        allPassed &= testConstructor();
        allPassed &= testGetNumberOfHalls();
        allPassed &= testGetExhibitionPlan();
        System.out.println("All Features Passed: " + allPassed);
    }

    /**
     * Test Suit for ExhibitionPlan constructor
     * 
     * @return all tests passed
     */
    public static boolean testConstructor() {
        System.out.println("\tFeature: ExhibitionPlan constructor");
        boolean allPassed = true;

        /**
         * Valid Construction
         */
        {
            int[][] testExhibionPlan = { { 0, 1, 2 }, { 0, 1, 2 }, { 0, 1, 2 }, { 0, 1, 2 }, { 0, 1, 2 }, { 0, 1, 2 },
                    { 0, 1, 2 }, { 0, 1, 2 }, { 0, 1, 2 }, { 0, 1, 2 }, { 0, 1, 2 }, { 0, 1, 2 } };
            String expectedResult = "no exception";
            String scenario = "valid consruction";
            ExhibitManagement exhibitManagement = Resources.createTestExhibitManagement();
            allPassed &= constructorTestCase(testExhibionPlan, exhibitManagement, expectedResult, scenario);
        }

        /**
         * Too Few Months
         */
        {
            int[][] testExhibionPlan = { { 0, 1, 2 }, { 0, 1, 2 }, { 0, 1, 2 }, { 0, 1, 2 }, { 0, 1, 2 }, { 0, 1, 2 },
                    { 0, 1, 2 }, { 0, 1, 2 }, { 0, 1, 2 }, { 0, 1, 2 }, { 0, 1, 2 } };
            String expectedResult = "Incorrect Months Exception";
            String scenario = "invalid consruction, not enough months";
            ExhibitManagement exhibitManagement = Resources.createTestExhibitManagement();
            allPassed &= constructorTestCase(testExhibionPlan, exhibitManagement, expectedResult, scenario);
        }

        /**
         * Too Many Months
         */
        {
            int[][] testExhibionPlan = { { 0, 1, 2 }, { 0, 1, 2 }, { 0, 1, 2 }, { 0, 1, 2 }, { 0, 1, 2 }, { 0, 1, 2 },
                    { 0, 1, 2 }, { 0, 1, 2 }, { 0, 1, 2 }, { 0, 1, 2 }, { 0, 1, 2 }, { 0, 1, 2 }, { 0, 1, 2 } };
            String expectedResult = "Incorrect Months Exception";
            String scenario = "invalid consruction, too many months";
            ExhibitManagement exhibitManagement = Resources.createTestExhibitManagement();
            allPassed &= constructorTestCase(testExhibionPlan, exhibitManagement, expectedResult, scenario);
        }

        /**
         * no Months
         */
        {
            int[][] testExhibionPlan = {};
            String expectedResult = "Incorrect Months Exception";
            String scenario = "invalid consruction, empty array";
            ExhibitManagement exhibitManagement = Resources.createTestExhibitManagement();
            allPassed &= constructorTestCase(testExhibionPlan, exhibitManagement, expectedResult, scenario);
        }

        /**
         * Duplicate exhibits -> duplicate artifacts in the same month
         */
        {
            int[][] testExhibionPlan = { { 0, 2, 2 }, { 0, 1, 2 }, { 0, 1, 2 }, { 0, 1, 2 }, { 0, 1, 2 }, { 0, 1, 2 },
                    { 0, 1, 2 }, { 0, 1, 2 }, { 0, 1, 2 }, { 0, 1, 2 }, { 0, 1, 2 }, { 0, 1, 2 } };
            String expectedResult = "duplicate artifacts exception";
            String scenario = "invalid consruction, duplicate artifacts";
            ExhibitManagement exhibitManagement = Resources.createTestExhibitManagement();
            allPassed &= constructorTestCase(testExhibionPlan, exhibitManagement, expectedResult, scenario);
        }

        /**
         * Empty array -> all are null so dupliacte
         */
        {
            int[][] testExhibionPlan = new int[12][3];
            String expectedResult = "duplicate artifacts exception";
            String scenario = "invalid consruction, null values";
            ExhibitManagement exhibitManagement = Resources.createTestExhibitManagement();
            allPassed &= constructorTestCase(testExhibionPlan, exhibitManagement, expectedResult, scenario);
        }

        /**
         * Each month array empty -> no halls but still valid
         */
        {
            int[][] testExhibionPlan = { {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {} };
            String expectedResult = "no exception";
            String scenario = "valid consruction, no halls";
            ExhibitManagement exhibitManagement = Resources.createTestExhibitManagement();
            allPassed &= constructorTestCase(testExhibionPlan, exhibitManagement, expectedResult, scenario);
        }

        System.out.println("\tFeature Passed: " + allPassed);
        System.out.println();
        return allPassed;
    }

    /**
     * Test Suit for getNumberOfHalls method
     * @return all tests passed
     */
    public static boolean testGetNumberOfHalls() {
        System.out.println("\tFeature: ExhibitionPlan getNumberOfHalls");
        boolean allPassed = true;

        /**
         * Normal Use Case
         */
        {
            ExhibitionPlan testExhibitionPlan = Resources.createTestExhibitionPlan();
            int expectedResult = 3;
            String scenario = "normal use";

            allPassed &= getNumberOfHallsTestCase(testExhibitionPlan, expectedResult, scenario);
        }

        /**
         * use of plan that has no halls
         */
        {
            ExhibitionPlan testExhibitionPlan = Resources.createTestExhibitionPlan(true);
            int expectedResult = 0;
            String scenario = "valid use, no halls in plan";
            allPassed &= getNumberOfHallsTestCase(testExhibitionPlan, expectedResult, scenario);
        }

        System.out.println("\tFeature Passed: " + allPassed);
        System.out.println();
        return allPassed;
    }

    public static boolean testGetExhibitionPlan(){
        System.out.println("\tFeature: ExhibitionPlan getExhibitionPlan");
        boolean allPassed = true;

         /**
         * Normal Use Case
         */
        {
            ExhibitionPlan testExhibitionPlan = Resources.createTestExhibitionPlan();
            int[][] expectedResult = { { 0, 1, 2 }, { 0, 1, 2 }, { 0, 1, 2 }, { 0, 1, 2 }, { 0, 1, 2 }, { 0, 1, 2 },
            { 0, 1, 2 }, { 0, 1, 2 }, { 0, 1, 2 }, { 0, 1, 2 }, { 0, 1, 2 }, { 0, 1, 2 } };
            String scenario = "normal use";

            allPassed &= getExhibitionPlan(testExhibitionPlan, expectedResult, scenario);
        }

        /**
         * Normal Use Case
         */
        {
            ExhibitionPlan testExhibitionPlan = Resources.createTestExhibitionPlan(true);
            int[][] expectedResult = { {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}};
            String scenario = "normal use";

            allPassed &= getExhibitionPlan(testExhibitionPlan, expectedResult, scenario);
        }

        System.out.println("\tFeature Passed: " + allPassed);
        System.out.println();
        return allPassed;
    }

    /**
     * Test for ExhibitionPlan constructor
     * 
     * @param testExhibionPlan
     * @param exhibitManagement
     * @param expectedResult
     * @param scenario
     * @return passed
     */
    public static boolean constructorTestCase(int[][] testExhibitionPlan, ExhibitManagement exhibitManagement,
            String expectedResult, String scenario) {
        String result = "";
        try {
            new ExhibitionPlan(testExhibitionPlan, exhibitManagement);
            result = "no exception";
        } catch (Exception e) {
            if (e.getMessage().equals("Incorrect number of Months")) {
                result = "Incorrect Months Exception";
            } else if (e.getMessage().equals("Exhibits that share Artifacts in the same Month")) {
                result = "duplicate artifacts exception";
            } else {
                result = e.getMessage();
            }
        }
        boolean thisPassed = result.equals(expectedResult);

        if (!thisPassed) {
            System.err.println();
            System.err.println("Scenario:" + scenario);
            System.err.println("Given: exhibitionPlan data " + testExhibitionPlan);
            System.err.println("When: new ExhibitionPlan with " + testExhibitionPlan);
            System.err.print("AND: " + exhibitManagement);
            System.err.println("Then: output is:\n" + expectedResult);
            System.err.println("Passed: " + thisPassed);
            System.err.println("Expected Value:\n" + expectedResult);
            System.err.println("Given Value:\n" + result);
            System.err.println();
        }
        return thisPassed;

    }

    /**
     * Test for getNumberOfHalls method
     * @param testExhibitionPlan
     * @param expectedResult
     * @param scenario
     * @return passed
     */
    public static boolean getNumberOfHallsTestCase(ExhibitionPlan testExhibitionPlan, int expectedResult, String scenario){
        int result = testExhibitionPlan.getNumberOfHalls();
        boolean thisPassed = result == expectedResult;


        if (!thisPassed) {
            System.err.println();
            System.err.println("Scenario:" + scenario);
            System.err.println("Given: exhibitionPlan data " + testExhibitionPlan);
            System.err.println("When: getNumberOfHalls called");
            System.err.println("Then: output is:\n" + expectedResult);
            System.err.println("Passed: " + thisPassed);
            System.err.println("Expected Value:\n" + expectedResult);
            System.err.println("Given Value:\n" + result);
            System.err.println();
        }
        return thisPassed;
    }

    public static boolean getExhibitionPlan(ExhibitionPlan testExhibitionPlan, int[][] expectedResult, String scenario){
        int[][] result = testExhibitionPlan.getExhibitionPlan();
        boolean thisPassed = ArraysMethods.deepEquals(result, expectedResult);
        
        if (!thisPassed) {
            System.err.println();
            System.err.println("Scenario:" + scenario);
            System.err.println("Given: exhibitionPlan is " + testExhibitionPlan);
            System.err.println("When: getExhibitionPlan called");
            System.err.println("Then: output is:\n" + ArraysMethods.deepToString(expectedResult));
            System.err.println("Passed: " + thisPassed);
            System.err.println("Expected Value:\n" + ArraysMethods.deepToString(expectedResult));
            System.err.println("Given Value:\n" + ArraysMethods.deepToString(result));
            System.err.println();
        }
        return thisPassed;
    }

}
