package part02;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import part01.ExhibitManagement;
import part01.ExhibitionPlan;
import part01.Months;

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
            allPassed &= constructorTestCase(testExhibionPlan, exhibitManagement, expectedResult, scenario);
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
            allPassed &= constructorTestCase(testExhibionPlan, exhibitManagement, expectedResult, scenario);
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
            testRan += 10;
            allPassed &= constructorTestCase(testExhibionPlan, exhibitManagement, expectedResult, scenario);

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
            testRan += 10;
            allPassed &= constructorTestCase(testExhibionPlan, exhibitManagement, expectedResult, scenario);

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

            allPassed &= getNumberOfHallsTestCase(testExhibitionPlan, expectedResult, scenario);
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
            allPassed &= getNumberOfHallsTestCase(testExhibitionPlan, expectedResult, scenario);
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
            allPassed &= getExhibitionPlan(testExhibitionPlan, expectedResult, scenario);
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

            allPassed &= getExhibitionPlan(testExhibitionPlan, expectedResult, scenario);
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

            allPassed &= getExhibitsinMonthTestCase(testExhibitionPlan, testMonth, expectedResult, scenario);
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

            allPassed &= getExhibitsinMonthTestCase(testExhibitionPlan, testMonth, expectedResult, scenario);
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

            allPassed &= getExhibitsInMonthTestCase(testExhibitionPlan, testMonth, expectedResult, scenario);
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

            allPassed &= getExhibitsInMonthTestCase(testExhibitionPlan, testMonth, expectedResult, scenario);
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

            allPassed &= getExhibitsInMonthTestCase(testExhibitionPlan, testMonth, expectedResult, scenario);
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

            allPassed &= getExhibitsInMonthTestCase(testExhibitionPlan, testMonth, expectedResult, scenario);
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

            allPassed &= getExhibitsInMonthTestCase(testExhibitionPlan, testMonth, expectedResult, scenario);
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

            allPassed &= getExhibitsInMonthTestCase(testExhibitionPlan, testMonth, expectedResult, scenario);
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

            allPassed &= getExhibitsInMonthTestCase(testExhibitionPlan, testMonth, expectedResult, scenario);
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

            allPassed &= getExhibitsInMonthTestCase(testExhibitionPlan, testMonth, expectedResult, scenario);
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

            allPassed &= getExhibitsInHallTestCase(testExhibitionPlan, testHall, expectedResult, scenario);
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

            allPassed &= getExhibitsInHallTestCase(testExhibitionPlan, testHall, expectedResult, scenario);
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

            allPassed &= getExhibitsInHallTestCase(testExhibitionPlan, testHall, expectedResult, scenario);
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

            allPassed &= getExhibitsInHallTestCase(testExhibitionPlan, testHall, expectedResult, scenario);
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

            allPassed &= getExhibitsNamesTestCase(testExhibitionPlan, exhibitManagement, expectedResult, scenario);
        }

        /**
         * Test With Empty Plan
         */
        {
            ExhibitManagement exhibitManagement = Resources.createTestExhibitManagement();
            ExhibitionPlan testExhibitionPlan = Resources.createTestExhibitionPlan(true, exhibitManagement);

            String[][] expectedResult = { {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {} };
            String scenario = "empty plan";

            allPassed &= getExhibitsNamesTestCase(testExhibitionPlan, exhibitManagement, expectedResult, scenario);
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

            allPassed &= getExhibitNamesStringTestCase(testExhibitionPlan, testExhibits, exhibitManagement,
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

            allPassed &= getExhibitNamesInMonthTestCase(testExhibitionPlan, testMonth, exhibitManagement,
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

            allPassed &= getExhibitNamesInMonthTestCase(testExhibitionPlan, testMonth, exhibitManagement,
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

            allPassed &= getExhibitNamesInMonthTestCase(testExhibitionPlan, testMonth, exhibitManagement,
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

            allPassed &= getExhibitNamesInMonthTestCase(testExhibitionPlan, testMonth, exhibitManagement,
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

            allPassed &= getExhibitNamesInMonthTestCase(testExhibitionPlan, testMonth, exhibitManagement,
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

            allPassed &= getExhibitNamesInMonthTestCase(testExhibitionPlan, testMonth, exhibitManagement,
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

            allPassed &= getExhibitNamesInHallTestCase(testExhibitionPlan, hallNo, exhibitManagement,
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

            allPassed &= getExhibitNamesInHallTestCase(testExhibitionPlan, hallNo, exhibitManagement,
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

            allPassed &= getExhibitNamesInHallTestCase(testExhibitionPlan, hallNo, exhibitManagement,
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

            allPassed &= getExhibitNamesInHallTestCase(testExhibitionPlan, hallNo, exhibitManagement,
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

            allPassed &= getPlanStringTestCase(testExhibitionPlan, exhibitManagement, expectedResult, scenario);
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

            allPassed &= getPlanStringTestCase(testExhibitionPlan, exhibitManagement, expectedResult, scenario);
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

            allPassed &= getMonthPlanTestCase(testExhibitionPlan, exhibitManagement, testMonth, expectedResult,
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

            allPassed &= getMonthPlanTestCase(testExhibitionPlan, exhibitManagement, testMonth, expectedResult,
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

            allPassed &= getMonthPlanTestCase(testExhibitionPlan, exhibitManagement, testMonth, expectedResult,
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

            allPassed &= getMonthPlanTestCase(testExhibitionPlan, exhibitManagement, testMonth, expectedResult,
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

            allPassed &= getMonthPlanTestCase(testExhibitionPlan, exhibitManagement, testMonth, expectedResult,
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

            allPassed &= getMonthPlanTestCase(testExhibitionPlan, exhibitManagement, testMonth, expectedResult,
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

            allPassed &= getHallPlanStringTestCase(testExhibitionPlan, hallNo, exhibitManagement,
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

            allPassed &= getHallPlanStringTestCase(testExhibitionPlan, hallNo, exhibitManagement,
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

            allPassed &= getHallPlanStringTestCase(testExhibitionPlan, hallNo, exhibitManagement,
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

            allPassed &= getHallPlanStringTestCase(testExhibitionPlan, hallNo, exhibitManagement,
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

            allPassed &= addExhibitTestCase(testExhibitionPlan, exhibitManagement, newExhibit, month, hall,
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

            allPassed &= addExhibitTestCase(testExhibitionPlan, exhibitManagement, newExhibit, month, hall,
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

            allPassed &= addExhibitTestCase(testExhibitionPlan, exhibitManagement, newExhibit, month, hall,
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

            allPassed &= addExhibitTestCase(testExhibitionPlan, exhibitManagement, newExhibit, month, hall,
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

            allPassed &= addExhibitTestCase(testExhibitionPlan, exhibitManagement, newExhibit, month, hall,
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

            allPassed &= addExhibitTestCase(testExhibitionPlan, exhibitManagement, newExhibit, month, hall,
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

            allPassed &= addExhibitTestCase(testExhibitionPlan, exhibitManagement, newExhibit, month, hall,
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

            allPassed &= addExhibitTestCase(testExhibitionPlan, exhibitManagement, newExhibit, month, hall,
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

            allPassed &= addExhibitTestCase(testExhibitionPlan, exhibitManagement, newExhibit, month, hall,
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

            allPassed &= addExhibitTestCase(testExhibitionPlan, exhibitManagement, newExhibit, month, hall,
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

            allPassed &= addExhibitTestCase(testExhibitionPlan, exhibitManagement, newExhibit, month, hall,
                    expectedResult, scenario);
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
            System.err.println("Given: exhibitionPlan data " + ArraysMethods.deepToString(testExhibitionPlan));
            System.err.println("When: new ExhibitionPlan with " + ArraysMethods.deepToString(testExhibitionPlan));
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
     * 
     * @param testExhibitionPlan
     * @param expectedResult
     * @param scenario
     * @return passed
     */
    public static boolean getNumberOfHallsTestCase(ExhibitionPlan testExhibitionPlan, int expectedResult,
            String scenario) {
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

    /**
     * Test for getExhibitionPlan method
     * 
     * @param testExhibitionPlan
     * @param expectedResult
     * @param scenario
     * @return passed
     */
    public static boolean getExhibitionPlan(ExhibitionPlan testExhibitionPlan, int[][] expectedResult,
            String scenario) {
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

    /**
     * Test for the getExhibitsInMonth with a Months Enum
     * 
     * @param testExhibitionPlan
     * @param testMonth
     * @param expectedResult
     * @param scenario
     * @return passed
     */
    public static boolean getExhibitsinMonthTestCase(ExhibitionPlan testExhibitionPlan, Months testMonth,
            int[] expectedResult, String scenario) {
        int[] result = testExhibitionPlan.getExibitsInMonth(testMonth);
        boolean thisPassed = ArraysMethods.equals(expectedResult, result);

        if (!thisPassed) {
            System.err.println();
            System.err.println("Scenario:" + scenario);
            System.err.println("Given: exhibitionPlan is " + testExhibitionPlan);
            System.err.println("When: getExhibitsInMonth called with Months enum " + testMonth);
            System.err.println("Then: output is:\n" + ArraysMethods.toString(expectedResult));
            System.err.println("Passed: " + thisPassed);
            System.err.println("Expected Value:\n" + ArraysMethods.toString(expectedResult));
            System.err.println("Given Value:\n" + ArraysMethods.toString(result));
            System.err.println();
        }
        return thisPassed;
    }

    /**
     * Test for the getExhibitsInMonth with a Months String
     * 
     * @param testExhibitionPlan
     * @param testMonth
     * @param expectedResult
     * @param scenario
     * @return passed
     */
    public static boolean getExhibitsInMonthTestCase(ExhibitionPlan testExhibitionPlan, String testMonth,
            int[] expectedResult, String scenario) {

        PrintStream stderr = System.err;
        ByteArrayOutputStream errorOutput = new ByteArrayOutputStream();
        System.setErr(new PrintStream(errorOutput));

        int[] result = testExhibitionPlan.getExibitsInMonth(testMonth);
        boolean thisPassed = ArraysMethods.equals(expectedResult, result);
        System.setErr(stderr);

        if (!thisPassed) {
            System.err.println();
            System.err.println("Scenario:" + scenario);
            System.err.println("Given: exhibitionPlan is " + testExhibitionPlan);
            System.err.println("When: getExhibitsInMonth called with Months enum " + testMonth);
            System.err.println("Then: output is:\n" + ArraysMethods.toString(expectedResult));
            System.err.println("Passed: " + thisPassed);
            System.err.println("Expected Value:\n" + ArraysMethods.toString(expectedResult));
            System.err.println("Given Value:\n" + ArraysMethods.toString(result));
            System.err.println();
        }
        return thisPassed;
    }

    /**
     * Test for the getExhibitsInMonth with a Months int id
     * 
     * @param testExhibitionPlan
     * @param testMonth
     * @param expectedResult
     * @param scenario
     * @return passed
     */
    public static boolean getExhibitsInMonthTestCase(ExhibitionPlan testExhibitionPlan, int testMonth,
            int[] expectedResult, String scenario) {

        PrintStream stderr = System.err;
        ByteArrayOutputStream errorOutput = new ByteArrayOutputStream();
        System.setErr(new PrintStream(errorOutput));

        int[] result = testExhibitionPlan.getExibitsInMonth(testMonth);
        boolean thisPassed = ArraysMethods.equals(expectedResult, result);
        System.setErr(stderr);

        if (!thisPassed) {
            System.err.println();
            System.err.println("Scenario:" + scenario);
            System.err.println("Given: exhibitionPlan is " + testExhibitionPlan);
            System.err.println("When: getExhibitsInMonth called with Months enum " + testMonth);
            System.err.println("Then: output is:\n" + ArraysMethods.toString(expectedResult));
            System.err.println("Passed: " + thisPassed);
            System.err.println("Expected Value:\n" + ArraysMethods.toString(expectedResult));
            System.err.println("Given Value:\n" + ArraysMethods.toString(result));
            System.err.println();
        }
        return thisPassed;
    }

    /**
     * Test for getExhibitsInHall method
     * 
     * @param testExhibitionPlan
     * @param testHall
     * @param expectedResult
     * @param scenario
     * @return passed
     */
    public static boolean getExhibitsInHallTestCase(ExhibitionPlan testExhibitionPlan, int testHall,
            int[] expectedResult, String scenario) {

        PrintStream stderr = System.err;
        ByteArrayOutputStream errorOutput = new ByteArrayOutputStream();
        System.setErr(new PrintStream(errorOutput));

        int[] result = testExhibitionPlan.getExhibitsInHall(testHall);
        boolean thisPassed = ArraysMethods.equals(expectedResult, result);
        System.setErr(stderr);

        if (!thisPassed) {
            System.err.println();
            System.err.println("Scenario:" + scenario);
            System.err.println("Given: exhibitionPlan is " + testExhibitionPlan);
            System.err.println("When: getExhibitsInHall called with hall num " + testHall);
            System.err.println("Then: output is:\n" + ArraysMethods.toString(expectedResult));
            System.err.println("Passed: " + thisPassed);
            System.err.println("Expected Value:\n" + ArraysMethods.toString(expectedResult));
            System.err.println("Given Value:\n" + ArraysMethods.toString(result));
            System.err.println();
        }
        return thisPassed;
    }

    /**
     * Test for getExhibitNames method
     * 
     * @param testExhibitionPlan
     * @param exhibitManagement
     * @param expectedResult
     * @param scenario
     * @return passed
     */
    public static boolean getExhibitsNamesTestCase(ExhibitionPlan testExhibitionPlan,
            ExhibitManagement exhibitManagement, String[][] expectedResult, String scenario) {
        String[][] result = testExhibitionPlan.getExhibitNames(exhibitManagement);
        boolean thisPassed = ArraysMethods.deepEquals(result, expectedResult);

        if (!thisPassed) {
            System.err.println();
            System.err.println("Scenario:" + scenario);
            System.err.println("Given: exhibitionPlan is " + testExhibitionPlan);
            System.err.println("When: getExhibitNames called with " + exhibitManagement);
            System.err.println("Then: output is:\n" + ArraysMethods.deepToString(expectedResult));
            System.err.println("Passed: " + thisPassed);
            System.err.println("Expected Value:\n" + ArraysMethods.deepToString(expectedResult));
            System.err.println("Given Value:\n" + ArraysMethods.deepToString(result));
            System.err.println();
        }
        return thisPassed;
    }

    /**
     * Test for getExhibitNamesString method
     * 
     * @param testExhibitionPlan
     * @param testExhibits
     * @param exhibitManagement
     * @param expectedResult
     * @param scenario
     * @return passed
     */
    public static boolean getExhibitNamesStringTestCase(ExhibitionPlan testExhibitionPlan, int[] testExhibits,
            ExhibitManagement exhibitManagement, String[] expectedResult, String scenario) {

        String[] result = testExhibitionPlan.getExhibitNamesString(testExhibits, exhibitManagement);
        boolean thisPassed = ArraysMethods.equals(result, expectedResult);

        if (!thisPassed) {
            System.err.println();
            System.err.println("Scenario:" + scenario);
            System.err.println("Given: exhibitionPlan is " + testExhibitionPlan);
            System.err.println("When: getExhibitNamesString called with " + exhibitManagement);
            System.err.println("Then: output is:\n" + ArraysMethods.toString(expectedResult));
            System.err.println("Passed: " + thisPassed);
            System.err.println("Expected Value:\n" + ArraysMethods.toString(expectedResult));
            System.err.println("Given Value:\n" + ArraysMethods.toString(result));
            System.err.println();
        }
        return thisPassed;
    }

    public static boolean getExhibitNamesInMonthTestCase(ExhibitionPlan testExhibitionPlan, int testMonth,
            ExhibitManagement exhibitManagement, String[] expectedResult, String scenario) {

        String[] result = testExhibitionPlan.getExhibitNamesInMonth(exhibitManagement, testMonth);
        boolean thisPassed = ArraysMethods.equals(result, expectedResult);

        if (!thisPassed) {
            System.err.println();
            System.err.println("Scenario:" + scenario);
            System.err.println("Given: exhibitionPlan is " + testExhibitionPlan);
            System.err.println("When: getExhibitNamesInMonth called with hall num " + exhibitManagement);
            System.err.println("AND: " + testMonth);
            System.err.println("Then: output is:\n" + ArraysMethods.toString(expectedResult));
            System.err.println("Passed: " + thisPassed);
            System.err.println("Expected Value:\n" + ArraysMethods.toString(expectedResult));
            System.err.println("Given Value:\n" + ArraysMethods.toString(result));
            System.err.println();
        }
        return thisPassed;
    }

    public static boolean getExhibitNamesInMonthTestCase(ExhibitionPlan testExhibitionPlan, Months testMonth,
            ExhibitManagement exhibitManagement, String[] expectedResult, String scenario) {

        String[] result = testExhibitionPlan.getExhibitNamesInMonth(exhibitManagement, testMonth);
        boolean thisPassed = ArraysMethods.equals(result, expectedResult);

        if (!thisPassed) {
            System.err.println();
            System.err.println("Scenario:" + scenario);
            System.err.println("Given: exhibitionPlan is " + testExhibitionPlan);
            System.err.println("When: getExhibitNamesInMonth called with hall num " + exhibitManagement);
            System.err.println("AND: " + testMonth);
            System.err.println("Then: output is:\n" + ArraysMethods.toString(expectedResult));
            System.err.println("Passed: " + thisPassed);
            System.err.println("Expected Value:\n" + ArraysMethods.toString(expectedResult));
            System.err.println("Given Value:\n" + ArraysMethods.toString(result));
            System.err.println();
        }
        return thisPassed;
    }

    /**
     * Test for getExhibitNamesInMonth method
     * 
     * @param testExhibitionPlan
     * @param testMonth
     * @param exhibitManagement
     * @param expectedResult
     * @param scenario
     * @return passed
     */
    public static boolean getExhibitNamesInMonthTestCase(ExhibitionPlan testExhibitionPlan, String testMonth,
            ExhibitManagement exhibitManagement, String[] expectedResult, String scenario) {

        String[] result = testExhibitionPlan.getExhibitNamesInMonth(exhibitManagement, testMonth);
        boolean thisPassed = ArraysMethods.equals(result, expectedResult);

        if (!thisPassed) {
            System.err.println();
            System.err.println("Scenario:" + scenario);
            System.err.println("Given: exhibitionPlan is " + testExhibitionPlan);
            System.err.println("When: getExhibitNamesInMonth called with hall num " + exhibitManagement);
            System.err.println("AND: " + testMonth);
            System.err.println("Then: output is:\n" + ArraysMethods.toString(expectedResult));
            System.err.println("Passed: " + thisPassed);
            System.err.println("Expected Value:\n" + ArraysMethods.toString(expectedResult));
            System.err.println("Given Value:\n" + ArraysMethods.toString(result));
            System.err.println();
        }
        return thisPassed;
    }

    /**
     * Test for getExhibitNamesInHall method
     * 
     * @param testExhibitionPlan
     * @param testMonth
     * @param exhibitManagement
     * @param expectedResult
     * @param scenario
     * @return passed
     */
    public static boolean getExhibitNamesInHallTestCase(ExhibitionPlan testExhibitionPlan, int hallNo,
            ExhibitManagement exhibitManagement, String[] expectedResult, String scenario) {

        PrintStream stderr = System.err;
        ByteArrayOutputStream errorOutput = new ByteArrayOutputStream();
        System.setErr(new PrintStream(errorOutput));

        String[] result = testExhibitionPlan.getExhibitNamesInHall(exhibitManagement, hallNo);
        boolean thisPassed = ArraysMethods.equals(result, expectedResult);

        System.setErr(stderr);

        if (!thisPassed) {
            System.err.println();
            System.err.println("Scenario:" + scenario);
            System.err.println("Given: exhibitionPlan is " + testExhibitionPlan);
            System.err.println("When: getExhibitNamesInHall called with hall num " + exhibitManagement);
            System.err.println("AND: " + hallNo);
            System.err.println("Then: output is:\n" + ArraysMethods.toString(expectedResult));
            System.err.println("Passed: " + thisPassed);
            System.err.println("Expected Value:\n" + ArraysMethods.toString(expectedResult));
            System.err.println("Given Value:\n" + ArraysMethods.toString(result));
            System.err.println();
        }
        return thisPassed;
    }

    /**
     * Test for getPlanString method
     * 
     * @param testExhibitionPlan
     * @param exhibitManagement
     * @param expectedResult
     * @param scenario
     * @return passed
     */
    public static boolean getPlanStringTestCase(ExhibitionPlan testExhibitionPlan, ExhibitManagement exhibitManagement,
            String expectedResult, String scenario) {
        String result = testExhibitionPlan.getPlanString(exhibitManagement);
        boolean thisPassed = result.trim().equals(expectedResult.trim());

        if (!thisPassed) {
            System.err.println();
            System.err.println("Scenario:" + scenario);
            System.err.println("Given: exhibitionPlan is " + testExhibitionPlan);
            System.err.println("When: getPlanString called with " + exhibitManagement);
            System.err.println("Then: output is:\n" + expectedResult);
            System.err.println("Passed: " + thisPassed);
            System.err.println("Expected Value:\n" + expectedResult);
            System.err.println("Given Value:\n" + result);
            System.err.println();
        }
        return thisPassed;
    }

    /**
     * Test for getMonthPlanString with int month
     * 
     * @param testExhibitionPlan
     * @param exhibitManagement
     * @param testMonth
     * @param expectedResult
     * @param scenario
     * @return
     */
    public static boolean getMonthPlanTestCase(ExhibitionPlan testExhibitionPlan, ExhibitManagement exhibitManagement,
            int testMonth, String expectedResult, String scenario) {

        String result = testExhibitionPlan.getMonthPlanString(exhibitManagement, testMonth);
        boolean thisPassed = result.trim().equals(expectedResult.trim());

        if (!thisPassed) {
            System.err.println();
            System.err.println("Scenario:" + scenario);
            System.err.println("Given: exhibitionPlan is " + testExhibitionPlan);
            System.err.println("When: getMonthPlanString called with " + exhibitManagement);
            System.err.println("Then: output is:\n" + expectedResult);
            System.err.println("Passed: " + thisPassed);
            System.err.println("Expected Value:\n" + expectedResult);
            System.err.println("Given Value:\n" + result);
            System.err.println();
        }
        return thisPassed;
    }

    /**
     * Test for getMonthPlanStrin with Months month
     * 
     * @param testExhibitionPlan
     * @param exhibitManagement
     * @param testMonth
     * @param expectedResult
     * @param scenario
     * @return
     */
    public static boolean getMonthPlanTestCase(ExhibitionPlan testExhibitionPlan, ExhibitManagement exhibitManagement,
            Months testMonth, String expectedResult, String scenario) {

        String result = testExhibitionPlan.getMonthPlanString(exhibitManagement, testMonth);
        boolean thisPassed = result.trim().equals(expectedResult.trim());

        if (!thisPassed) {
            System.err.println();
            System.err.println("Scenario:" + scenario);
            System.err.println("Given: exhibitionPlan is " + testExhibitionPlan);
            System.err.println("When: getMonthPlanString called with " + exhibitManagement);
            System.err.println("Then: output is:\n" + expectedResult);
            System.err.println("Passed: " + thisPassed);
            System.err.println("Expected Value:\n" + expectedResult);
            System.err.println("Given Value:\n" + result);
            System.err.println();
        }
        return thisPassed;
    }

    /**
     * Test for getMonthPlan method with String month
     * 
     * @param testExhibitionPlan
     * @param exhibitManagement
     * @param testMonth
     * @param expectedResult
     * @param scenario
     * @return passed
     */
    public static boolean getMonthPlanTestCase(ExhibitionPlan testExhibitionPlan, ExhibitManagement exhibitManagement,
            String testMonth, String expectedResult, String scenario) {

        String result = testExhibitionPlan.getMonthPlanString(exhibitManagement, testMonth);
        boolean thisPassed = result.trim().equals(expectedResult.trim());

        if (!thisPassed) {
            System.err.println();
            System.err.println("Scenario:" + scenario);
            System.err.println("Given: exhibitionPlan is " + testExhibitionPlan);
            System.err.println("When: getMonthPlanString called with " + exhibitManagement);
            System.err.println("Then: output is:\n" + expectedResult);
            System.err.println("Passed: " + thisPassed);
            System.err.println("Expected Value:\n" + expectedResult);
            System.err.println("Given Value:\n" + result);
            System.err.println();
        }
        return thisPassed;
    }

    /**
     * Test for getHallPlanString Method
     * 
     * @param testExhibitionPlan
     * @param hallNo
     * @param exhibitManagement
     * @param expectedResult
     * @param scenario
     * @return passed
     */
    public static boolean getHallPlanStringTestCase(ExhibitionPlan testExhibitionPlan, int hallNo,
            ExhibitManagement exhibitManagement, String expectedResult, String scenario) {

        PrintStream stderr = System.err;
        ByteArrayOutputStream errorOutput = new ByteArrayOutputStream();
        System.setErr(new PrintStream(errorOutput));

        String result = testExhibitionPlan.getHallPlanString(exhibitManagement, hallNo);
        boolean thisPassed = result.trim().equals(expectedResult.trim());

        System.setErr(stderr);

        if (!thisPassed) {
            System.err.println();
            System.err.println("Scenario:" + scenario);
            System.err.println("Given: exhibitionPlan is " + testExhibitionPlan);
            System.err.println("When: getHallPlanString called with " + exhibitManagement);
            System.err.println("Then: output is:\n" + expectedResult);
            System.err.println("Passed: " + thisPassed);
            System.err.println("Expected Value:\n" + expectedResult);
            System.err.println("Given Value:\n" + result);
            System.err.println();
        }
        return thisPassed;
    }

    /**
     * Test for addExhbit with int month
     * 
     * @param testExhibitionPlan
     * @param exhibitManagement
     * @param newExhibit
     * @param month
     * @param hall
     * @param expectedResult
     * @param scenario
     * @return
     */
    public static boolean addExhibitTestCase(ExhibitionPlan testExhibitionPlan, ExhibitManagement exhibitManagement,
            int newExhibit, int month, int hall, String expectedResult, String scenario) {

        String result = "";
        try {
            testExhibitionPlan.addExhibit(newExhibit, month, hall, exhibitManagement);
            result = "no exception";
        } catch (Exception e) {
            result = "exception thrown";
        }
        boolean thisPassed = result.trim().equals(expectedResult.trim());

        if (!thisPassed) {
            System.err.println();
            System.err.println("Scenario:" + scenario);
            System.err.println("Given: exhibitionPlan is " + testExhibitionPlan);
            System.err.println("When: addExhbit called with " + exhibitManagement);
            System.err.println("AND: " + month);
            System.err.println("AND: " + hall);
            System.err.println("AND: " + newExhibit);
            System.err.println("Then: output is:\n" + expectedResult);
            System.err.println("Passed: " + thisPassed);
            System.err.println("Expected Value:\n" + expectedResult);
            System.err.println("Given Value:\n" + result);
            System.err.println();
        }
        return thisPassed;
    }

    /**
     * Test for addExhibit with String month
     * 
     * @param testExhibitionPlan
     * @param exhibitManagement
     * @param newExhibit
     * @param month
     * @param hall
     * @param expectedResult
     * @param scenario
     * @return
     */
    public static boolean addExhibitTestCase(ExhibitionPlan testExhibitionPlan, ExhibitManagement exhibitManagement,
            int newExhibit, String month, int hall, String expectedResult, String scenario) {

        String result = "";
        try {
            testExhibitionPlan.addExhibit(newExhibit, month, hall, exhibitManagement);
            result = "no exception";
        } catch (Exception e) {
            result = "exception thrown";
        }
        boolean thisPassed = result.trim().equals(expectedResult.trim());

        if (!thisPassed) {
            System.err.println();
            System.err.println("Scenario:" + scenario);
            System.err.println("Given: exhibitionPlan is " + testExhibitionPlan);
            System.err.println("When: addExhbit called with " + exhibitManagement);
            System.err.println("AND: " + month);
            System.err.println("AND: " + hall);
            System.err.println("AND: " + newExhibit);
            System.err.println("Then: output is:\n" + expectedResult);
            System.err.println("Passed: " + thisPassed);
            System.err.println("Expected Value:\n" + expectedResult);
            System.err.println("Given Value:\n" + result);
            System.err.println();
        }
        return thisPassed;
    }

    /**
     * Test for addExhibit with Months month
     * 
     * @param testExhibitionPlan
     * @param exhibitManagement
     * @param newExhibit
     * @param month
     * @param hall
     * @param expectedResult
     * @param scenario
     * @return
     */
    public static boolean addExhibitTestCase(ExhibitionPlan testExhibitionPlan, ExhibitManagement exhibitManagement,
            int newExhibit, Months month, int hall, String expectedResult, String scenario) {

        String result = "";
        try {
            testExhibitionPlan.addExhibit(newExhibit, month, hall, exhibitManagement);
            result = "no exception";
        } catch (Exception e) {
            result = "exception thrown";
        }
        boolean thisPassed = result.trim().equals(expectedResult.trim());

        if (!thisPassed) {
            System.err.println();
            System.err.println("Scenario:" + scenario);
            System.err.println("Given: exhibitionPlan is " + testExhibitionPlan);
            System.err.println("When: addExhbit called with " + exhibitManagement);
            System.err.println("AND: " + month);
            System.err.println("AND: " + hall);
            System.err.println("AND: " + newExhibit);
            System.err.println("Then: output is:\n" + expectedResult);
            System.err.println("Passed: " + thisPassed);
            System.err.println("Expected Value:\n" + expectedResult);
            System.err.println("Given Value:\n" + result);
            System.err.println();
        }
        return thisPassed;
    }
}
