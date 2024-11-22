package part02;

import part01.ExhibitManagement;
import part01.ExhibitionPlan;
import part01.Months;

/**
 * Tests for ExhibitionPlanß
 */
public class ExhibitionPlanTester {

    private static int testRan = 0;

    public static void main(String[] args) {
        boolean allPassed = true;
        System.out.println("Class in Test: ExhibitionPlan");
        System.out.println();
        allPassed &= testConstructor();
        allPassed &= testGetNumberOfHalls();
        allPassed &= testGetExhibitionPlan();
        allPassed &= testGetExhibitsInMonthWithEnum();
        allPassed &= testGetExhibitsInMonthWithString();
        allPassed &= testGetExhibitsInMonthWithInt();
        allPassed &= testGetExhibitsinHall();
        allPassed &= testGetExhibitNames();
        allPassed &= testGetExhibitNamesString();
        allPassed &= testGetExhibitNamesInMonth();
        allPassed &= testGetExhibitNamesInHall();
        allPassed &= testGetPlanString();
        allPassed &= testGetMonthPlanString();
        allPassed &= testGetHallPlanString();
        allPassed &= testAddExhibit();
        allPassed &= testAddExhibitsToMonth();
        allPassed &= testAddExhibitsToHall();
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
            int[][] testExhibionPlan = { { testRan + 0, testRan + 1, testRan + 2 },
                    { testRan + 0, testRan + 1, testRan + 2 }, { testRan + 0, testRan + 1, testRan + 2 },
                    { testRan + 0, testRan + 1, testRan + 2 }, { testRan + 0, testRan + 1, testRan + 2 },
                    { testRan + 0, testRan + 1, testRan + 2 },
                    { testRan + 0, testRan + 1, testRan + 2 }, { testRan + 0, testRan + 1, testRan + 2 },
                    { testRan + 0, testRan + 1, testRan + 2 }, { testRan + 0, testRan + 1, testRan + 2 },
                    { testRan + 0, testRan + 1, testRan + 2 },
                    { testRan + 0, testRan + 1, testRan + 2 } };
            String expectedResult = "no exception";
            String scenario = "valid consruction";
            ExhibitManagement exhibitManagement = Resources.createTestExhibitManagement();
            testRan += 10;
            allPassed &= ExhibitionPlanTestCases.constructorTestCase(testExhibionPlan, exhibitManagement, expectedResult, scenario);
        }

        /**
         * Too Few Months
         */
        {
            int[][] testExhibionPlan = { { testRan + 0, testRan + 1, testRan + 2 },
                    { testRan + 0, testRan + 1, testRan + 2 }, { testRan + 0, testRan + 1, testRan + 2 },
                    { testRan + 0, testRan + 1, testRan + 2 }, { testRan + 0, testRan + 1, testRan + 2 },
                    { testRan + 0, testRan + 1, testRan + 2 },
                    { testRan + 0, testRan + 1, testRan + 2 }, { testRan + 0, testRan + 1, testRan + 2 },
                    { testRan + 0, testRan + 1, testRan + 2 }, { testRan + 0, testRan + 1, testRan + 2 },
                    { testRan + 0, testRan + 1, testRan + 2 } };
            String expectedResult = "Incorrect Months Exception";
            String scenario = "invalid consruction, not enough months";
            ExhibitManagement exhibitManagement = Resources.createTestExhibitManagement();
            testRan += 10;
            allPassed &= ExhibitionPlanTestCases.constructorTestCase(testExhibionPlan, exhibitManagement, expectedResult, scenario);
        }

        /**
         * Too Many Months
         */
        {
            int[][] testExhibionPlan = { { testRan + 0, testRan + 1, testRan + 2 },
                    { testRan + 0, testRan + 1, testRan + 2 }, { testRan + 0, testRan + 1, testRan + 2 },
                    { testRan + 0, testRan + 1, testRan + 2 }, { testRan + 0, testRan + 1, testRan + 2 },
                    { testRan + 0, testRan + 1, testRan + 2 },
                    { testRan + 0, testRan + 1, testRan + 2 }, { testRan + 0, testRan + 1, testRan + 2 },
                    { testRan + 0, testRan + 1, testRan + 2 }, { testRan + 0, testRan + 1, testRan + 2 },
                    { testRan + 0, testRan + 1, testRan + 2 },
                    { testRan + 0, testRan + 1, testRan + 2 }, { testRan + 0, testRan + 1, testRan + 2 } };
            String expectedResult = "Incorrect Months Exception";
            String scenario = "invalid consruction, too many months";
            ExhibitManagement exhibitManagement = Resources.createTestExhibitManagement();
            testRan += 10;
            allPassed &= ExhibitionPlanTestCases.constructorTestCase(testExhibionPlan, exhibitManagement, expectedResult, scenario);

        }

        /**
         * no Months
         */
        {
            int[][] testExhibionPlan = {};
            String expectedResult = "Incorrect Months Exception";
            String scenario = "invalid consruction, empty array";
            ExhibitManagement exhibitManagement = Resources.createTestExhibitManagement();
            testRan += 10;
            allPassed &= ExhibitionPlanTestCases.constructorTestCase(testExhibionPlan, exhibitManagement, expectedResult, scenario);

        }

        /**
         * Duplicate exhibits -> duplicate artifacts in the same month
         */
        {
            int[][] testExhibionPlan = { { testRan + 0, testRan + 0, testRan + 2 },
                    { testRan + 0, testRan + 1, testRan + 2 }, { testRan + 0, testRan + 1, testRan + 2 },
                    { testRan + 0, testRan + 1, testRan + 2 }, { testRan + 0, testRan + 1, testRan + 2 },
                    { testRan + 0, testRan + 1, testRan + 2 },
                    { testRan + 0, testRan + 1, testRan + 2 }, { testRan + 0, testRan + 1, testRan + 2 },
                    { testRan + 0, testRan + 1, testRan + 2 }, { testRan + 0, testRan + 1, testRan + 2 },
                    { testRan + 0, testRan + 1, testRan + 2 },
                    { testRan + 0, testRan + 1, testRan + 2 } };
            String expectedResult = "duplicate artifacts exception";
            String scenario = "invalid consruction, duplicate artifacts";
            ExhibitManagement exhibitManagement = Resources.createTestExhibitManagement();
            testRan += 10;
            allPassed &= ExhibitionPlanTestCases.constructorTestCase(testExhibionPlan, exhibitManagement, expectedResult, scenario);

        }

        /**
         * Each month array empty -> no halls but still valid
         */
        {
            int[][] testExhibionPlan = { {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {} };
            String expectedResult = "no exception";
            String scenario = "valid consruction, no halls";
            ExhibitManagement exhibitManagement = Resources.createTestExhibitManagement();
            testRan += 10;
            allPassed &= ExhibitionPlanTestCases.constructorTestCase(testExhibionPlan, exhibitManagement, expectedResult, scenario);

        }

        System.out.println("\tFeature Passed: " + allPassed);
        System.out.println();
        return allPassed;
    }

    /**
     * Test Suit for getNumberOfHalls method
     * 
     * @return all tests passed
     */
    public static boolean testGetNumberOfHalls() {
        System.out.println("\tFeature: ExhibitionPlan getNumberOfHalls");
        boolean allPassed = true;

        /**
         * Normal Use Case
         */
        {
            ExhibitManagement exhibitManagement = Resources.createTestExhibitManagement();
            testRan += 10;
            ExhibitionPlan testExhibitionPlan = Resources.createTestExhibitionPlan(exhibitManagement);
            int expectedResult = 3;
            String scenario = "normal use";

            allPassed &= ExhibitionPlanTestCases.getNumberOfHallsTestCase(testExhibitionPlan, expectedResult, scenario);
        }

        /**
         * use of plan that has no halls
         */
        {
            ExhibitManagement exhibitManagement = Resources.createTestExhibitManagement();
            testRan += 10;
            ExhibitionPlan testExhibitionPlan = Resources.createTestExhibitionPlan(true, exhibitManagement);
            int expectedResult = 0;
            String scenario = "valid use, no halls in plan";
            allPassed &= ExhibitionPlanTestCases.getNumberOfHallsTestCase(testExhibitionPlan, expectedResult, scenario);
        }

        System.out.println("\tFeature Passed: " + allPassed);
        System.out.println();
        return allPassed;
    }

    public static boolean testGetExhibitionPlan() {
        System.out.println("\tFeature: ExhibitionPlan getExhibitionPlan");
        boolean allPassed = true;

        /**
         * Normal Use Case
         */
        {
            ExhibitManagement exhibitManagement = Resources.createTestExhibitManagement();

            ExhibitionPlan testExhibitionPlan = Resources.createTestExhibitionPlan(exhibitManagement);
            int[][] expectedResult = { { testRan + 0, testRan + 1, testRan + 2 },
                    { testRan + 0, testRan + 2, testRan + 1 }, { testRan + 1, testRan + 0, testRan + 2 },
                    { testRan + 1, testRan + 2, testRan + 0 }, { testRan + 2, testRan + 0, testRan + 1 },
                    { testRan + 2, testRan + 1, testRan + 0 },
                    { testRan + 0, testRan + 1, testRan + 3 }, { testRan + 0, testRan + 3, testRan + 1 },
                    { testRan + 1, testRan + 0, testRan + 3 }, { testRan + 1, testRan + 3, testRan + 0 },
                    { testRan + 3, testRan + 1, testRan + 0 },
                    { testRan + 3, testRan + 0, testRan + 1 } };
            String scenario = "normal use";
            testRan += 10;
            allPassed &= ExhibitionPlanTestCases.getExhibitionPlan(testExhibitionPlan, expectedResult, scenario);
        }

        /**
         * Normal Use Case with exhibhitionPlan with no halls
         */
        {
            ExhibitManagement exhibitManagement = Resources.createTestExhibitManagement();
            testRan += 10;
            ExhibitionPlan testExhibitionPlan = Resources.createTestExhibitionPlan(true, exhibitManagement);
            int[][] expectedResult = { {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {} };
            String scenario = "normal use but no halls";

            allPassed &= ExhibitionPlanTestCases.getExhibitionPlan(testExhibitionPlan, expectedResult, scenario);
        }

        System.out.println("\tFeature Passed: " + allPassed);
        System.out.println();
        return allPassed;
    }

    /**
     * Test Suit for the getExhibitsInMonth method that uses a Months enum
     * 
     * @return all tests passed
     */
    public static boolean testGetExhibitsInMonthWithEnum() {
        System.out.println("\tFeature: Exhibition Plan getExhibitsInMonth with Months enum");
        boolean allPassed = true;

        /**
         * Normal Test Case
         */
        {
            ExhibitManagement exhibitManagement = Resources.createTestExhibitManagement();
            ExhibitionPlan testExhibitionPlan = Resources.createTestExhibitionPlan(exhibitManagement);
            Months testMonth = Months.DEC;
            int[] expectedResult = { testRan + 3, testRan + 0, testRan + 1 };
            testRan += 10;
            String scenario = "normal use";

            allPassed &= ExhibitionPlanTestCases.getExhibitsinMonthTestCase(testExhibitionPlan, testMonth, expectedResult, scenario);
        }

        /**
         * Test on empty plan
         */
        {
            ExhibitManagement exhibitManagement = Resources.createTestExhibitManagement();
            testRan += 10;
            ExhibitionPlan testExhibitionPlan = Resources.createTestExhibitionPlan(true, exhibitManagement);
            Months testMonth = Months.FEB;
            int[] expectedResult = {};
            String scenario = "empty plan";

            allPassed &= ExhibitionPlanTestCases.getExhibitsinMonthTestCase(testExhibitionPlan, testMonth, expectedResult, scenario);
        }

        System.out.println("\tFeature Passed: " + allPassed);
        System.out.println();
        return allPassed;
    }

    /**
     * Test Suit for the getExhibitsInMonth method that uses a Months string name
     * 
     * @return all tests passed
     */
    public static boolean testGetExhibitsInMonthWithInt() {
        System.out.println("\tFeature: Exhibition Plan getExhibitsInMonth with Months int id");
        boolean allPassed = true;

        /**
         * Normal Test Case
         */
        {
            ExhibitManagement exhibitManagement = Resources.createTestExhibitManagement();

            ExhibitionPlan testExhibitionPlan = Resources.createTestExhibitionPlan(exhibitManagement);
            int testMonth = 11;
            int[] expectedResult = { testRan + 3, testRan + 0, testRan + 1 };
            testRan += 10;
            String scenario = "normal use";

            allPassed &= ExhibitionPlanTestCases.getExhibitsInMonthTestCase(testExhibitionPlan, testMonth, expectedResult, scenario);
        }

        /**
         * Test on empty plan
         */
        {
            ExhibitManagement exhibitManagement = Resources.createTestExhibitManagement();
            testRan += 10;
            ExhibitionPlan testExhibitionPlan = Resources.createTestExhibitionPlan(true, exhibitManagement);
            int testMonth = 1;
            int[] expectedResult = {};
            String scenario = "empty plan";

            allPassed &= ExhibitionPlanTestCases.getExhibitsInMonthTestCase(testExhibitionPlan, testMonth, expectedResult, scenario);
        }

        /**
         * Test with id exceeding range
         */
        {
            ExhibitManagement exhibitManagement = Resources.createTestExhibitManagement();
            testRan += 10;
            ExhibitionPlan testExhibitionPlan = Resources.createTestExhibitionPlan(exhibitManagement);
            int testMonth = 12;
            int[] expectedResult = {};
            String scenario = "invalid month name";

            allPassed &= ExhibitionPlanTestCases.getExhibitsInMonthTestCase(testExhibitionPlan, testMonth, expectedResult, scenario);
        }

        /**
         * Test id below range
         */
        {
            ExhibitManagement exhibitManagement = Resources.createTestExhibitManagement();
            testRan += 10;
            ExhibitionPlan testExhibitionPlan = Resources.createTestExhibitionPlan(exhibitManagement);
            int testMonth = -1;
            int[] expectedResult = {};
            String scenario = "null month name";

            allPassed &= ExhibitionPlanTestCases.getExhibitsInMonthTestCase(testExhibitionPlan, testMonth, expectedResult, scenario);
        }

        System.out.println("\tFeature Passed: " + allPassed);
        System.out.println();
        return allPassed;
    }

    /**
     * Test Suit for the getExhibitsInMonth method that uses a Months int id
     * 
     * @return all tests passed
     */
    public static boolean testGetExhibitsInMonthWithString() {
        System.out.println("\tFeature: Exhibition Plan getExhibitsInMonth with Months String name");
        boolean allPassed = true;

        /**
         * Normal Test Case
         */
        {
            ExhibitManagement exhibitManagement = Resources.createTestExhibitManagement();
            ExhibitionPlan testExhibitionPlan = Resources.createTestExhibitionPlan(exhibitManagement);
            String testMonth = "December";
            int[] expectedResult = { testRan + 3, testRan + 0, testRan + 1 };
            testRan += 10;
            String scenario = "normal use";

            allPassed &= ExhibitionPlanTestCases.getExhibitsInMonthTestCase(testExhibitionPlan, testMonth, expectedResult, scenario);
        }

        /**
         * Test on empty plan
         */
        {
            ExhibitManagement exhibitManagement = Resources.createTestExhibitManagement();
            testRan += 10;
            ExhibitionPlan testExhibitionPlan = Resources.createTestExhibitionPlan(true, exhibitManagement);
            String testMonth = "February";
            int[] expectedResult = {};
            String scenario = "empty plan";

            allPassed &= ExhibitionPlanTestCases.getExhibitsInMonthTestCase(testExhibitionPlan, testMonth, expectedResult, scenario);
        }

        /**
         * Test with an inalid month name
         */
        {
            ExhibitManagement exhibitManagement = Resources.createTestExhibitManagement();
            testRan += 10;
            ExhibitionPlan testExhibitionPlan = Resources.createTestExhibitionPlan(exhibitManagement);
            String testMonth = "Not a Valid Month";
            int[] expectedResult = {};
            String scenario = "invalid month name";

            allPassed &= ExhibitionPlanTestCases.getExhibitsInMonthTestCase(testExhibitionPlan, testMonth, expectedResult, scenario);
        }

        /**
         * Test with a null month name
         */
        {
            ExhibitManagement exhibitManagement = Resources.createTestExhibitManagement();
            testRan += 10;
            ExhibitionPlan testExhibitionPlan = Resources.createTestExhibitionPlan(exhibitManagement);
            String testMonth = null;
            int[] expectedResult = {};
            String scenario = "null month name";

            allPassed &= ExhibitionPlanTestCases.getExhibitsInMonthTestCase(testExhibitionPlan, testMonth, expectedResult, scenario);
        }

        System.out.println("\tFeature Passed: " + allPassed);
        System.out.println();
        return allPassed;
    }

    public static boolean testGetExhibitsinHall() {
        System.out.println("\tFeature: ExhibitionPlan getExhibitsInHall");
        boolean allPassed = true;

        /**
         * Normal Test Case
         */
        {
            ExhibitManagement exhibitManagement = Resources.createTestExhibitManagement();

            ExhibitionPlan testExhibitionPlan = Resources.createTestExhibitionPlan(exhibitManagement);
            int testHall = 3;
            int[] expectedResult = { testRan + 2, testRan + 1, testRan + 2, testRan + 0, testRan + 1, testRan + 0,
                    testRan + 3, testRan + 1, testRan + 3, testRan + 0, testRan + 0, testRan + 1 };
            testRan += 10;
            String scenario = "normal use";

            allPassed &= ExhibitionPlanTestCases.getExhibitsInHallTestCase(testExhibitionPlan, testHall, expectedResult, scenario);
        }

        /**
         * Test on empty plan
         */
        {
            ExhibitManagement exhibitManagement = Resources.createTestExhibitManagement();
            testRan += 10;
            ExhibitionPlan testExhibitionPlan = Resources.createTestExhibitionPlan(true, exhibitManagement);
            int testHall = 1;
            int[] expectedResult = {};
            String scenario = "empty plan";

            allPassed &= ExhibitionPlanTestCases.getExhibitsInHallTestCase(testExhibitionPlan, testHall, expectedResult, scenario);
        }

        /**
         * Test with an inalid month name
         */
        {
            ExhibitManagement exhibitManagement = Resources.createTestExhibitManagement();
            testRan += 10;
            ExhibitionPlan testExhibitionPlan = Resources.createTestExhibitionPlan(exhibitManagement);
            int testHall = 4;
            int[] expectedResult = {};
            String scenario = "invalid hall number";

            allPassed &= ExhibitionPlanTestCases.getExhibitsInHallTestCase(testExhibitionPlan, testHall, expectedResult, scenario);
        }

        /**
         * Test with a null month name
         */
        {
            ExhibitManagement exhibitManagement = Resources.createTestExhibitManagement();
            testRan += 10;
            ExhibitionPlan testExhibitionPlan = Resources.createTestExhibitionPlan(exhibitManagement);
            int testHall = -1;
            int[] expectedResult = {};
            String scenario = "invalid hall number";

            allPassed &= ExhibitionPlanTestCases.getExhibitsInHallTestCase(testExhibitionPlan, testHall, expectedResult, scenario);
        }

        System.out.println("\tFeature Passed: " + allPassed);
        System.out.println();
        return allPassed;
    }

    /**
     * Test Suit for getExhibitNames method
     * 
     * @return all tests passed
     */
    public static boolean testGetExhibitNames() {
        System.out.println("\tFeature: Exhibit getExhibitNames");
        boolean allPassed = true;

        /**
         * Normal Test
         */
        {
            ExhibitManagement exhibitManagement = Resources.createTestExhibitManagement();
            testRan += 10;
            ExhibitionPlan testExhibitionPlan = Resources.createTestExhibitionPlan(exhibitManagement);

            String[][] expectedResult = {
                    { "test", "test", "test" },
                    { "test", "test", "test" },
                    { "test", "test", "test" },
                    { "test", "test", "test" },
                    { "test", "test", "test" },
                    { "test", "test", "test" },
                    { "test", "test", "test" },
                    { "test", "test", "test" },
                    { "test", "test", "test" },
                    { "test", "test", "test" },
                    { "test", "test", "test" },
                    { "test", "test", "test" } };
            String scenario = "normal test";

            allPassed &= ExhibitionPlanTestCases.getExhibitsNamesTestCase(testExhibitionPlan, exhibitManagement, expectedResult, scenario);
        }

        /**
         * Test With Empty Plan
         */
        {
            ExhibitManagement exhibitManagement = Resources.createTestExhibitManagement();
            ExhibitionPlan testExhibitionPlan = Resources.createTestExhibitionPlan(true, exhibitManagement);

            String[][] expectedResult = { {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {} };
            String scenario = "empty plan";

            allPassed &= ExhibitionPlanTestCases.getExhibitsNamesTestCase(testExhibitionPlan, exhibitManagement, expectedResult, scenario);
            testRan += 10;
        }

        System.out.println("\tFeature Passed: " + allPassed);
        System.out.println();
        return allPassed;
    }

    /**
     * Test Suit for getExhibitNamesString method
     * 
     * @return all tests passed
     */
    public static boolean testGetExhibitNamesString() {
        System.out.println("\tFeature: ExhibitionPlan getExhibitNamesString");
        boolean allPassed = true;

        /**
         * Normal Test
         */
        {
            ExhibitManagement exhibitManagement = Resources.createTestExhibitManagement();

            ExhibitionPlan testExhibitionPlan = Resources.createTestExhibitionPlan(true, exhibitManagement);
            int[] testExhibits = { testRan + 0, testRan + 1, testRan + 2 };
            String[] expectedResult = { "test", "test", "test" };
            testRan += 10;
            String scenario = "normal use";

            allPassed &= ExhibitionPlanTestCases.getExhibitNamesStringTestCase(testExhibitionPlan, testExhibits, exhibitManagement,
                    expectedResult, scenario);
        }

        System.out.println("\tFeature Passed: " + allPassed);
        System.out.println();
        return allPassed;
    }

    /**
     * Test Suit for getExhibitNamesInMonth method
     * 
     * @return all tests passed
     */
    public static boolean testGetExhibitNamesInMonth() {
        System.out.println("\tFeature: ExhibitionPlan getExhibitNamesInMonth");
        boolean allPassed = true;

        /**
         * Test Using Month id int
         */
        {
            ExhibitManagement exhibitManagement = Resources.createTestExhibitManagement();

            ExhibitionPlan testExhibitionPlan = Resources.createTestExhibitionPlan(exhibitManagement);
            int testMonth = 5;
            String[] expectedResult = { "test", "test", "test" };
            testRan += 10;
            String scenario = "normal use int month";

            allPassed &= ExhibitionPlanTestCases.getExhibitNamesInMonthTestCase(testExhibitionPlan, testMonth, exhibitManagement,
                    expectedResult, scenario);
        }

        /**
         * Test Using Month id int and empty plan
         */
        {
            ExhibitManagement exhibitManagement = Resources.createTestExhibitManagement();

            ExhibitionPlan testExhibitionPlan = Resources.createTestExhibitionPlan(true, exhibitManagement);
            int testMonth = 5;
            String[] expectedResult = {};
            testRan += 10;
            String scenario = "normal use int month empty plan";

            allPassed &= ExhibitionPlanTestCases.getExhibitNamesInMonthTestCase(testExhibitionPlan, testMonth, exhibitManagement,
                    expectedResult, scenario);
        }

        /**
         * Test Using Months Enum
         */
        {
            ExhibitManagement exhibitManagement = Resources.createTestExhibitManagement();

            ExhibitionPlan testExhibitionPlan = Resources.createTestExhibitionPlan(exhibitManagement);
            Months testMonth = Months.MAY;
            String[] expectedResult = { "test", "test", "test" };
            testRan += 10;
            String scenario = "normal use Months month";

            allPassed &= ExhibitionPlanTestCases.getExhibitNamesInMonthTestCase(testExhibitionPlan, testMonth, exhibitManagement,
                    expectedResult, scenario);
        }

        /**
         * Test Using Months Enum and empty plan
         */
        {
            ExhibitManagement exhibitManagement = Resources.createTestExhibitManagement();

            ExhibitionPlan testExhibitionPlan = Resources.createTestExhibitionPlan(true, exhibitManagement);
            Months testMonth = Months.MAY;
            String[] expectedResult = {};
            testRan += 10;
            String scenario = "normal use Months month empty plan";

            allPassed &= ExhibitionPlanTestCases.getExhibitNamesInMonthTestCase(testExhibitionPlan, testMonth, exhibitManagement,
                    expectedResult, scenario);
        }

        /**
         * Test Using Months String name
         */
        {
            ExhibitManagement exhibitManagement = Resources.createTestExhibitManagement();

            ExhibitionPlan testExhibitionPlan = Resources.createTestExhibitionPlan(exhibitManagement);
            String testMonth = "March";
            String[] expectedResult = { "test", "test", "test" };
            testRan += 10;
            String scenario = "normal use String month";

            allPassed &= ExhibitionPlanTestCases.getExhibitNamesInMonthTestCase(testExhibitionPlan, testMonth, exhibitManagement,
                    expectedResult, scenario);
        }

        /**
         * Test Using Months String name and empty plan
         */
        {
            ExhibitManagement exhibitManagement = Resources.createTestExhibitManagement();

            ExhibitionPlan testExhibitionPlan = Resources.createTestExhibitionPlan(true, exhibitManagement);
            String testMonth = "March";
            String[] expectedResult = {};
            testRan += 10;
            String scenario = "normal use String month empty plan";

            allPassed &= ExhibitionPlanTestCases.getExhibitNamesInMonthTestCase(testExhibitionPlan, testMonth, exhibitManagement,
                    expectedResult, scenario);
        }

        System.out.println("\tFeature Passed: " + allPassed);
        System.out.println();
        return allPassed;
    }

    public static boolean testGetExhibitNamesInHall() {
        System.out.println("\tFeature: ExhibitionPlan getExhibitNamesInHall");
        boolean allPassed = true;

        /**
         * Test normal use
         */
        {
            ExhibitManagement exhibitManagement = Resources.createTestExhibitManagement();

            ExhibitionPlan testExhibitionPlan = Resources.createTestExhibitionPlan(exhibitManagement);
            int hallNo = 2;
            String[] expectedResult = { "test", "test", "test", "test", "test", "test", "test", "test", "test", "test",
                    "test", "test" };
            testRan += 10;
            String scenario = "normal use";

            allPassed &= ExhibitionPlanTestCases.getExhibitNamesInHallTestCase(testExhibitionPlan, hallNo, exhibitManagement,
                    expectedResult, scenario);
        }

        /**
         * Test normal hall and empty plan
         */
        {
            ExhibitManagement exhibitManagement = Resources.createTestExhibitManagement();

            ExhibitionPlan testExhibitionPlan = Resources.createTestExhibitionPlan(true, exhibitManagement);
            int hallNo = 2;
            String[] expectedResult = {};
            testRan += 10;
            String scenario = "normal use and empty plan";

            allPassed &= ExhibitionPlanTestCases.getExhibitNamesInHallTestCase(testExhibitionPlan, hallNo, exhibitManagement,
                    expectedResult, scenario);
        }

        /**
         * Test Using neagative hall
         */
        {
            ExhibitManagement exhibitManagement = Resources.createTestExhibitManagement();

            ExhibitionPlan testExhibitionPlan = Resources.createTestExhibitionPlan(exhibitManagement);
            int hallNo = -5;
            String[] expectedResult = {};
            testRan += 10;
            String scenario = "negative hall no";

            allPassed &= ExhibitionPlanTestCases.getExhibitNamesInHallTestCase(testExhibitionPlan, hallNo, exhibitManagement,
                    expectedResult, scenario);
        }

        /**
         * Test Using exceeding max hall
         */
        {
            ExhibitManagement exhibitManagement = Resources.createTestExhibitManagement();

            ExhibitionPlan testExhibitionPlan = Resources.createTestExhibitionPlan(true, exhibitManagement);
            int hallNo = 5;
            String[] expectedResult = {};
            testRan += 10;
            String scenario = "not created hall";

            allPassed &= ExhibitionPlanTestCases.getExhibitNamesInHallTestCase(testExhibitionPlan, hallNo, exhibitManagement,
                    expectedResult, scenario);
        }

        System.out.println("\tFeature Passed: " + allPassed);
        System.out.println();
        return allPassed;
    }

    /**
     * Test Suit for getPlanString method
     * 
     * @return all tests passed
     */
    public static boolean testGetPlanString() {
        System.out.println("\tFeature: ExhibitionPlan getPlanString");
        boolean allPassed = true;
        /**
         * Normal Test
         */
        {
            ExhibitManagement exhibitManagement = Resources.createTestExhibitManagement();
            testRan += 10;
            ExhibitionPlan testExhibitionPlan = Resources.createTestExhibitionPlan(exhibitManagement);

            String expectedResult = "             Exhibit Hall 1                          Exhibit Hall 2                          Exhibit Hall 3                          \n"
                    + //
                    "January      test                                    test                                    test                                    \n"
                    + //
                    "February     test                                    test                                    test                                    \n"
                    + //
                    "March        test                                    test                                    test                                    \n"
                    + //
                    "April        test                                    test                                    test                                    \n"
                    + //
                    "May          test                                    test                                    test                                    \n"
                    + //
                    "June         test                                    test                                    test                                    \n"
                    + //
                    "July         test                                    test                                    test                                    \n"
                    + //
                    "August       test                                    test                                    test                                    \n"
                    + //
                    "September    test                                    test                                    test                                    \n"
                    + //
                    "October      test                                    test                                    test                                    \n"
                    + //
                    "November     test                                    test                                    test                                    \n"
                    + //
                    "December     test                                    test                                    test                                    ";
            String scenario = "normal test";

            allPassed &= ExhibitionPlanTestCases.getPlanStringTestCase(testExhibitionPlan, exhibitManagement, expectedResult, scenario);
        }

        /**
         * Test with empty plan
         */
        {
            ExhibitManagement exhibitManagement = Resources.createTestExhibitManagement();
            testRan += 10;
            ExhibitionPlan testExhibitionPlan = Resources.createTestExhibitionPlan(true, exhibitManagement);

            String expectedResult = "             \n" +
                    "January      \n" +
                    "February     \n" +
                    "March        \n" +
                    "April        \n" +
                    "May          \n" +
                    "June         \n" +
                    "July         \n" +
                    "August       \n" +
                    "September    \n" +
                    "October      \n" +
                    "November     \n" +
                    "December     \n";
            String scenario = "normal test and empty plan";

            allPassed &= ExhibitionPlanTestCases.getPlanStringTestCase(testExhibitionPlan, exhibitManagement, expectedResult, scenario);
        }

        System.out.println("\tFeature Passed: " + allPassed);
        System.out.println();
        return allPassed;
    }

    /**
     * Test Suit for getMonthPlanString method
     * 
     * @return tests all passed
     */
    public static boolean testGetMonthPlanString() {
        System.out.println("\tFeature: ExhibitionPlan getMonthPlanString");
        boolean allPassed = true;

        /**
         * Test Using Month id int
         */
        {
            ExhibitManagement exhibitManagement = Resources.createTestExhibitManagement();

            ExhibitionPlan testExhibitionPlan = Resources.createTestExhibitionPlan(exhibitManagement);
            int testMonth = 5;
            String expectedResult = "\tExhibit Hall 1\tExhibit Hall 2\tExhibit Hall 3\t\n" +
                    "June\ttest\ttest\ttest\t";
            testRan += 10;
            String scenario = "normal use int month";

            allPassed &= ExhibitionPlanTestCases.getMonthPlanTestCase(testExhibitionPlan, exhibitManagement, testMonth, expectedResult,
                    scenario);

        }

        /**
         * Test Using Month id int and empty plan
         */
        {
            ExhibitManagement exhibitManagement = Resources.createTestExhibitManagement();

            ExhibitionPlan testExhibitionPlan = Resources.createTestExhibitionPlan(true, exhibitManagement);
            int testMonth = 5;
            String expectedResult = "\t\n" +
                    "June\t";
            testRan += 10;
            String scenario = "normal use int month and empty plan";

            allPassed &= ExhibitionPlanTestCases.getMonthPlanTestCase(testExhibitionPlan, exhibitManagement, testMonth, expectedResult,
                    scenario);

        }

        /**
         * Test Using Months Enum
         */
        {
            ExhibitManagement exhibitManagement = Resources.createTestExhibitManagement();

            ExhibitionPlan testExhibitionPlan = Resources.createTestExhibitionPlan(exhibitManagement);
            Months testMonth = Months.MAY;
            String expectedResult = "\tExhibit Hall 1\tExhibit Hall 2\tExhibit Hall 3\t\n" +
                    "May\ttest\ttest\ttest\t";
            testRan += 10;
            String scenario = "normal use Months month";

            allPassed &= ExhibitionPlanTestCases.getMonthPlanTestCase(testExhibitionPlan, exhibitManagement, testMonth, expectedResult,
                    scenario);
        }

        /**
         * Test Using Months Enum and empty plan
         */
        {
            ExhibitManagement exhibitManagement = Resources.createTestExhibitManagement();

            ExhibitionPlan testExhibitionPlan = Resources.createTestExhibitionPlan(true, exhibitManagement);
            Months testMonth = Months.MAY;
            String expectedResult = "\t\n" +
                    "May\t";
            testRan += 10;
            String scenario = "normal use Months month and empty plan";

            allPassed &= ExhibitionPlanTestCases.getMonthPlanTestCase(testExhibitionPlan, exhibitManagement, testMonth, expectedResult,
                    scenario);

        }

        /**
         * Test Using Months String name
         */
        {
            ExhibitManagement exhibitManagement = Resources.createTestExhibitManagement();

            ExhibitionPlan testExhibitionPlan = Resources.createTestExhibitionPlan(exhibitManagement);
            String testMonth = "March";
            String expectedResult = "\tExhibit Hall 1\tExhibit Hall 2\tExhibit Hall 3\t\n" +
                    "March\ttest\ttest\ttest\t";
            testRan += 10;
            String scenario = "normal use String month";

            allPassed &= ExhibitionPlanTestCases.getMonthPlanTestCase(testExhibitionPlan, exhibitManagement, testMonth, expectedResult,
                    scenario);

        }

        /**
         * Test Using Months String name and empty plan
         */
        {
            ExhibitManagement exhibitManagement = Resources.createTestExhibitManagement();

            ExhibitionPlan testExhibitionPlan = Resources.createTestExhibitionPlan(true, exhibitManagement);
            String testMonth = "March";
            String expectedResult = "\t\n" +
                    "March\t";
            testRan += 10;
            String scenario = "normal use String month empty plan";

            allPassed &= ExhibitionPlanTestCases.getMonthPlanTestCase(testExhibitionPlan, exhibitManagement, testMonth, expectedResult,
                    scenario);

        }

        System.out.println("\tFeature Passed: " + allPassed);
        System.out.println();
        return allPassed;
    }

    /**
     * Test Suit for getHallPlanString method
     * 
     * @return all tests passed
     */
    public static boolean testGetHallPlanString() {
        System.out.println("\tFeature: ExhibitionPlan getExhibitNamesInHall");
        boolean allPassed = true;

        /**
         * Test normal use
         */
        {
            ExhibitManagement exhibitManagement = Resources.createTestExhibitManagement();

            ExhibitionPlan testExhibitionPlan = Resources.createTestExhibitionPlan(exhibitManagement);
            int hallNo = 2;
            String expectedResult = "\tExhibit Hall 2\n" +
                    "January\ttest\n" +
                    "February\ttest\n" +
                    "March\ttest\n" +
                    "April\ttest\n" +
                    "May\ttest\n" +
                    "June\ttest\n" +
                    "July\ttest\n" +
                    "August\ttest\n" +
                    "September\ttest\n" +
                    "October\ttest\n" +
                    "November\ttest\n" +
                    "December\ttest\n";
            testRan += 10;
            String scenario = "normal use";

            allPassed &= ExhibitionPlanTestCases.getHallPlanStringTestCase(testExhibitionPlan, hallNo, exhibitManagement,
                    expectedResult, scenario);
        }

        /**
         * Test normal hall and empty plan
         */
        {
            ExhibitManagement exhibitManagement = Resources.createTestExhibitManagement();

            ExhibitionPlan testExhibitionPlan = Resources.createTestExhibitionPlan(true, exhibitManagement);
            int hallNo = 2;
            String expectedResult = "\tExhibit Hall 2\n";
            testRan += 10;
            String scenario = "normal use and empty plan";

            allPassed &= ExhibitionPlanTestCases.getHallPlanStringTestCase(testExhibitionPlan, hallNo, exhibitManagement,
                    expectedResult, scenario);
        }

        /**
         * Test Using neagative hall
         */
        {
            ExhibitManagement exhibitManagement = Resources.createTestExhibitManagement();

            ExhibitionPlan testExhibitionPlan = Resources.createTestExhibitionPlan(exhibitManagement);
            int hallNo = -5;
            String expectedResult = "\tExhibit Hall -5\n";
            testRan += 10;
            String scenario = "normal use";

            allPassed &= ExhibitionPlanTestCases.getHallPlanStringTestCase(testExhibitionPlan, hallNo, exhibitManagement,
                    expectedResult, scenario);
        }

        /**
         * Test Using exceeding max hall
         */
        {
            ExhibitManagement exhibitManagement = Resources.createTestExhibitManagement();

            ExhibitionPlan testExhibitionPlan = Resources.createTestExhibitionPlan(true, exhibitManagement);
            int hallNo = 5;
            String expectedResult = "\tExhibit Hall 5\n";
            testRan += 10;
            String scenario = "normal use";

            allPassed &= ExhibitionPlanTestCases.getHallPlanStringTestCase(testExhibitionPlan, hallNo, exhibitManagement,
                    expectedResult, scenario);
        }

        System.out.println("\tFeature Passed: " + allPassed);
        System.out.println();
        return allPassed;
    }

    /**
     * Test Suit for addExhibit method
     * 
     * @return all tests passed
     */
    public static boolean testAddExhibit() {
        System.out.println("\tFeature: ExhibitionPlan addExhibit");
        boolean allPassed = true;

        /**
         * Valid use with int month
         */
        {
            ExhibitManagement exhibitManagement = Resources.createTestExhibitManagement();

            ExhibitionPlan testExhibitionPlan = Resources.createTestExhibitionPlan(exhibitManagement);
            int newExhibit = testRan + 4;
            int month = 0;
            int hall = 1;
            testRan += 10;
            String expectedResult = "no exception";
            String scenario = "normal use int month";

            allPassed &= ExhibitionPlanTestCases.addExhibitTestCase(testExhibitionPlan, exhibitManagement, newExhibit, month, hall,
                    expectedResult, scenario);
        }

        /**
         * Invalid use with int month
         */
        {
            ExhibitManagement exhibitManagement = Resources.createTestExhibitManagement();

            ExhibitionPlan testExhibitionPlan = Resources.createTestExhibitionPlan(exhibitManagement);
            int newExhibit = testRan + 1;
            int month = 0;
            int hall = 1;
            testRan += 10;
            String expectedResult = "exception thrown";
            String scenario = "invalid use int month";

            allPassed &= ExhibitionPlanTestCases.addExhibitTestCase(testExhibitionPlan, exhibitManagement, newExhibit, month, hall,
                    expectedResult, scenario);
        }

        /**
         * Valid Use with String month
         */
        {
            ExhibitManagement exhibitManagement = Resources.createTestExhibitManagement();

            ExhibitionPlan testExhibitionPlan = Resources.createTestExhibitionPlan(exhibitManagement);
            int newExhibit = testRan + 4;
            String month = "January";
            int hall = 1;
            testRan += 10;
            String expectedResult = "no exception";
            String scenario = "normal use String month";

            allPassed &= ExhibitionPlanTestCases.addExhibitTestCase(testExhibitionPlan, exhibitManagement, newExhibit, month, hall,
                    expectedResult, scenario);
        }

        /**
         * Invalid Use with String month
         */
        {
            ExhibitManagement exhibitManagement = Resources.createTestExhibitManagement();

            ExhibitionPlan testExhibitionPlan = Resources.createTestExhibitionPlan(exhibitManagement);
            int newExhibit = testRan + 1;
            String month = "January";
            int hall = 1;
            testRan += 10;
            String expectedResult = "exception thrown";
            String scenario = "invalid use String month";

            allPassed &= ExhibitionPlanTestCases.addExhibitTestCase(testExhibitionPlan, exhibitManagement, newExhibit, month, hall,
                    expectedResult, scenario);
        }

        /**
         * Invalid Use with String month, not a month
         */
        {
            ExhibitManagement exhibitManagement = Resources.createTestExhibitManagement();

            ExhibitionPlan testExhibitionPlan = Resources.createTestExhibitionPlan(exhibitManagement);
            int newExhibit = testRan + 1;
            String month = "invalid month name";
            int hall = 1;
            testRan += 10;
            String expectedResult = "exception thrown";
            String scenario = "invalid use String month not a month";

            allPassed &= ExhibitionPlanTestCases.addExhibitTestCase(testExhibitionPlan, exhibitManagement, newExhibit, month, hall,
                    expectedResult, scenario);
        }

        /**
         * Invalid Use with String month, null
         */
        {
            ExhibitManagement exhibitManagement = Resources.createTestExhibitManagement();

            ExhibitionPlan testExhibitionPlan = Resources.createTestExhibitionPlan(exhibitManagement);
            int newExhibit = testRan + 1;
            String month = null;
            int hall = 1;
            testRan += 10;
            String expectedResult = "exception thrown";
            String scenario = "invalid use String month is null";

            allPassed &= ExhibitionPlanTestCases.addExhibitTestCase(testExhibitionPlan, exhibitManagement, newExhibit, month, hall,
                    expectedResult, scenario);
        }

        /**
         * Valid Use with Months months
         */
        {
            ExhibitManagement exhibitManagement = Resources.createTestExhibitManagement();

            ExhibitionPlan testExhibitionPlan = Resources.createTestExhibitionPlan(exhibitManagement);
            int newExhibit = testRan + 4;
            Months month = Months.MAR;
            int hall = 1;
            testRan += 10;
            String expectedResult = "no exception";
            String scenario = "normal use Months month";

            allPassed &= ExhibitionPlanTestCases.addExhibitTestCase(testExhibitionPlan, exhibitManagement, newExhibit, month, hall,
                    expectedResult, scenario);
        }

        /**
         * Invalid Use with Months month
         */
        {
            ExhibitManagement exhibitManagement = Resources.createTestExhibitManagement();

            ExhibitionPlan testExhibitionPlan = Resources.createTestExhibitionPlan(exhibitManagement);
            int newExhibit = testRan + 1;
            Months month = Months.JAN;
            int hall = 1;
            testRan += 10;
            String expectedResult = "exception thrown";
            String scenario = "invalid use Months month";

            allPassed &= ExhibitionPlanTestCases.addExhibitTestCase(testExhibitionPlan, exhibitManagement, newExhibit, month, hall,
                    expectedResult, scenario);
        }

        /**
         * Invalid Hall, too large
         */
        {
            ExhibitManagement exhibitManagement = Resources.createTestExhibitManagement();

            ExhibitionPlan testExhibitionPlan = Resources.createTestExhibitionPlan(exhibitManagement);
            int newExhibit = testRan + 4;
            Months month = Months.MAR;
            int hall = 4;
            testRan += 10;
            String expectedResult = "exception thrown";
            String scenario = "invalid use, hall too large";

            allPassed &= ExhibitionPlanTestCases.addExhibitTestCase(testExhibitionPlan, exhibitManagement, newExhibit, month, hall,
                    expectedResult, scenario);
        }

        /**
         * Invalid Hall, too small
         */
        {
            ExhibitManagement exhibitManagement = Resources.createTestExhibitManagement();

            ExhibitionPlan testExhibitionPlan = Resources.createTestExhibitionPlan(exhibitManagement);
            int newExhibit = testRan + 4;
            Months month = Months.MAR;
            int hall = 0;
            testRan += 10;
            String expectedResult = "exception thrown";
            String scenario = "invalid use hall too small";

            allPassed &= ExhibitionPlanTestCases.addExhibitTestCase(testExhibitionPlan, exhibitManagement, newExhibit, month, hall,
                    expectedResult, scenario);
        }

        /**
         * Invalid add to empty plan
         */
        {
            ExhibitManagement exhibitManagement = Resources.createTestExhibitManagement();

            ExhibitionPlan testExhibitionPlan = Resources.createTestExhibitionPlan(true, exhibitManagement);
            int newExhibit = testRan + 4;
            int month = 0;
            int hall = 1;
            testRan += 10;
            String expectedResult = "exception thrown";
            String scenario = "invalid use, plan is empty";

            allPassed &= ExhibitionPlanTestCases.addExhibitTestCase(testExhibitionPlan, exhibitManagement, newExhibit, month, hall,
                    expectedResult, scenario);
        }

        System.out.println("\tFeature Passed: " + allPassed);
        System.out.println();
        return allPassed;
    }

    /**
     * Test Suit for addExhibitsToMonth method
     * 
     * @return all tests passed
     */
    public static boolean testAddExhibitsToMonth() {
        System.out.println("\tFeature: ExhibitionPlan addExhibitsToMonth");
        boolean allPassed = true;

        /**
         * Normal Use with int month
         */
        {
            ExhibitManagement exhibitManagement = Resources.createTestExhibitManagement();

            ExhibitionPlan testExhibitionPlan = Resources.createTestExhibitionPlan(exhibitManagement);
            int month = 0;
            int[] newExhibit = { testRan + 4, testRan + 5, testRan + 6 };
            testRan += 10;
            String expectedResult = "no exception";
            String scenario = "normal use, int Month";

            allPassed &= ExhibitionPlanTestCases.addExhibitsToMonthTestCase(testExhibitionPlan, newExhibit, month,
                    expectedResult, scenario);
        }

        /**
         * invalid Use with int month, month too large
         */
        {
            ExhibitManagement exhibitManagement = Resources.createTestExhibitManagement();

            ExhibitionPlan testExhibitionPlan = Resources.createTestExhibitionPlan(exhibitManagement);
            int month = 12;
            int[] newExhibit = { testRan + 4, testRan + 5, testRan + 6 };
            testRan += 10;
            String expectedResult = "exception thrown";
            String scenario = "invalid Use with int month, month too large";

            allPassed &= ExhibitionPlanTestCases.addExhibitsToMonthTestCase(testExhibitionPlan, newExhibit, month,
                    expectedResult, scenario);
        }

        /**
         * invalid Use with int month, month too small
         */
        {
            ExhibitManagement exhibitManagement = Resources.createTestExhibitManagement();

            ExhibitionPlan testExhibitionPlan = Resources.createTestExhibitionPlan(exhibitManagement);
            int month = -5;
            int[] newExhibit = { testRan + 4, testRan + 5, testRan + 6 };
            testRan += 10;
            String expectedResult = "exception thrown";
            String scenario = "invalid Use with int month, month too small";

            allPassed &= ExhibitionPlanTestCases.addExhibitsToMonthTestCase(testExhibitionPlan, newExhibit, month,
                    expectedResult, scenario);
        }

        /**
         * valid Use with String month
         */
        {
            ExhibitManagement exhibitManagement = Resources.createTestExhibitManagement();

            ExhibitionPlan testExhibitionPlan = Resources.createTestExhibitionPlan(exhibitManagement);
            String month = "May";
            int[] newExhibit = { testRan + 4, testRan + 5, testRan + 6 };
            testRan += 10;
            String expectedResult = "no exception";
            String scenario = "valid Use with String month";

            allPassed &= ExhibitionPlanTestCases.addExhibitsToMonthTestCase(testExhibitionPlan, newExhibit, month,
                    expectedResult, scenario);
        }

        /**
         * invalid Use with String month, not a month
         */
        {
            ExhibitManagement exhibitManagement = Resources.createTestExhibitManagement();

            ExhibitionPlan testExhibitionPlan = Resources.createTestExhibitionPlan(exhibitManagement);
            String month = "not a month";
            int[] newExhibit = { testRan + 4, testRan + 5, testRan + 6 };
            testRan += 10;
            String expectedResult = "exception thrown";
            String scenario = "invalid Use with String month, not a month";

            allPassed &= ExhibitionPlanTestCases.addExhibitsToMonthTestCase(testExhibitionPlan, newExhibit, month,
                    expectedResult, scenario);
        }

        /**
         * invalid Use with String month, null
         */
        {
            ExhibitManagement exhibitManagement = Resources.createTestExhibitManagement();

            ExhibitionPlan testExhibitionPlan = Resources.createTestExhibitionPlan(exhibitManagement);
            String month = null;
            int[] newExhibit = { testRan + 4, testRan + 5, testRan + 6 };
            testRan += 10;
            String expectedResult = "exception thrown";
            String scenario = "invalid Use with String month, null";

            allPassed &= ExhibitionPlanTestCases.addExhibitsToMonthTestCase(testExhibitionPlan, newExhibit, month,
                    expectedResult, scenario);
        }

        /**
         * valid Use with Months month
         */
        {
            ExhibitManagement exhibitManagement = Resources.createTestExhibitManagement();

            ExhibitionPlan testExhibitionPlan = Resources.createTestExhibitionPlan(exhibitManagement);
            Months month = Months.AUG;
            int[] newExhibit = { testRan + 4, testRan + 5, testRan + 6 };
            testRan += 10;
            String expectedResult = "no exception";
            String scenario = "valid Use with Months month";

            allPassed &= ExhibitionPlanTestCases.addExhibitsToMonthTestCase(testExhibitionPlan, newExhibit, month,
                    expectedResult, scenario);
        }

        System.out.println("\tFeature Passed: " + allPassed);
        System.out.println();
        return allPassed;
    }

    /**
     * Test Suit for addExhibitsToHall method
     * 
     * @return tests all passed
     */
    public static boolean testAddExhibitsToHall() {
        System.out.println("\tFeature: ExhibitionPlan addExhibitsToHall");
        boolean allPassed = true;

        /**
         * Normal Test
         */
        {
            ExhibitManagement exhibitManagement = Resources.createTestExhibitManagement();

            ExhibitionPlan testExhibitionPlan = Resources.createTestExhibitionPlan(exhibitManagement);
            int hall = 2;
            int[] newExhibit = { testRan + 4, testRan + 5, testRan + 6, testRan + 7, testRan + 8, testRan + 9,
                    testRan + 0, testRan + 1, testRan + 2, testRan + 3, testRan + 5, testRan + 6 };
            testRan += 10;
            String expectedResult = "no exception";
            String scenario = "valid Use with Months month";

            allPassed &= ExhibitionPlanTestCases.addExhibitsToHallTestCase(testExhibitionPlan, newExhibit, hall,
                    expectedResult, scenario);
        }

        /**
         * Invalid Test, hall too small
         */
        {
            ExhibitManagement exhibitManagement = Resources.createTestExhibitManagement();

            ExhibitionPlan testExhibitionPlan = Resources.createTestExhibitionPlan(exhibitManagement);
            int hall = 0;
            int[] newExhibit = { testRan + 4, testRan + 5, testRan + 6, testRan + 7, testRan + 8, testRan + 9,
                    testRan + 0, testRan + 1, testRan + 2, testRan + 3, testRan + 5, testRan + 6 };
            testRan += 10;
            String expectedResult = "exception thrown";
            String scenario = "valid Use with Months month";

            allPassed &= ExhibitionPlanTestCases.addExhibitsToHallTestCase(testExhibitionPlan, newExhibit, hall,
                    expectedResult, scenario);
        }

        /**
         * Invalid Test, hall too large
         */
        {
            ExhibitManagement exhibitManagement = Resources.createTestExhibitManagement();

            ExhibitionPlan testExhibitionPlan = Resources.createTestExhibitionPlan(exhibitManagement);
            int hall = 4;
            int[] newExhibit = { testRan + 4, testRan + 5, testRan + 6, testRan + 7, testRan + 8, testRan + 9,
                    testRan + 0, testRan + 1, testRan + 2, testRan + 3, testRan + 5, testRan + 6 };
            testRan += 10;
            String expectedResult = "exception thrown";
            String scenario = "valid Use with Months month";

            allPassed &= ExhibitionPlanTestCases.addExhibitsToHallTestCase(testExhibitionPlan, newExhibit, hall,
                    expectedResult, scenario);
        }

        System.out.println("\tFeature Passed: " + allPassed);
        System.out.println();
        return allPassed;
    }

}