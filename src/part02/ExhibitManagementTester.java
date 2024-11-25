package part02;

import java.util.ArrayList;

import part01.ArtifactManagement;
import part01.Exhibit;
import part01.ExhibitManagement;

public class ExhibitManagementTester {

    private static int exhibitsCreated = -1;
    private static int artifactsCreated = -1;

    public static void main(String[] args) {
        boolean allPassed = true;
        System.out.println("Class in Test: ExhibitManagement");
        System.out.println();
        allPassed &= testDefaultConstructor();
        allPassed &= testConstructor();
        allPassed &= testGetExhibitArrayLength();
        allPassed &= testAddExhibit();
        allPassed &= testExhibitsMenu();
        allPassed &= testExhibitsToArray();
        allPassed &= testExhibitArrayToNameArray();
        allPassed &= testSortExhibitArray();
        allPassed &= testSearchExhibits();
        allPassed &= testGetExhibitMenu();
        allPassed &= testGetExhibitString();
        allPassed &= testRemoveExhibit();
        allPassed &= testGetExhibitArtifactNames();
        allPassed &= testGetExhibitArtifactMenu();
        allPassed &= testGetArtifactNumber();
        allPassed &= testGetExhibitRoute();
        allPassed &= testGetExhibitArtifacts();
        allPassed &= testGetExhibitArtifactsByID();
        allPassed &= testUpdateExhibit();
        allPassed &= testRemoveArtifactsWithID();
        allPassed &= testGetExhibitionExhibtNames();
        allPassed &= testFindExhibit();
        allPassed &= testGetExhibitID();
        allPassed &= testAnyDuplicateArtifacts();
        System.out.println("All Features Passed: " + allPassed);
        System.out.println();
    }

    /**
     * Test Suit For the Default Constructor this also tests getExhibits and
     * getExhibitArray
     * 
     * @return all tests passed
     */
    public static boolean testDefaultConstructor() {
        System.out.println("\tFeature: ExhibitManagment default constructor");
        boolean allPassed = true;

        /**
         * Test for Default Constructer Array Property with getExhibitArray
         */
        {
            Exhibit[] expectedResult = {};
            String scenario = "Default Constructor Array Property";

            allPassed &= ExhibitManagementTestCases.defaultConstructorTestCase(expectedResult, scenario);
        }

        /**
         * Test for Default Constructer ArrayList Property with getExhibits
         */
        {
            ArrayList<Exhibit> expectedResult = new ArrayList<>();
            String scenario = "Default Constructor ArrayList Property";

            allPassed &= ExhibitManagementTestCases.defaultConstructorTestCase(expectedResult, scenario);
        }

        System.out.println("\tFeature Passed: " + allPassed);
        System.out.println();
        return allPassed;
    }

    /**
     * Test Suit For the Default Constructorthis also tests getExhibits and
     * getExhibitArray
     * 
     * @return
     */
    public static boolean testConstructor() {
        System.out.println("\tFeature: ArtifactMangement default constructor");
        boolean allPassed = true;

        /**
         * Test for Constructer Array Property with getExhibitArray
         */
        {
            Exhibit a0 = Resources.createTestExhibit();
            exhibitsCreated++;
            Exhibit a1 = Resources.createTestExhibit();
            exhibitsCreated++;
            Exhibit a2 = Resources.createTestExhibit();
            exhibitsCreated++;
            Exhibit a3 = Resources.createTestExhibit();
            exhibitsCreated++;
            Exhibit a4 = Resources.createTestExhibit();
            exhibitsCreated++;
            ArrayList<Exhibit> exhibitManagementData = new ArrayList<>();
            exhibitManagementData.add(a0);
            exhibitManagementData.add(a1);
            exhibitManagementData.add(a2);
            exhibitManagementData.add(a3);
            exhibitManagementData.add(a4);

            Exhibit[] expectedResult = { a0, a1, a2, a3, a4 };
            String scenario = "Constructor Array Property";

            allPassed &= ExhibitManagementTestCases.constructorTestCase(exhibitManagementData, expectedResult,
                    scenario);
        }

        /**
         * Test for Constructer ArrayList Property with getExhibits
         */
        {
            Exhibit a0 = Resources.createTestExhibit();
            exhibitsCreated++;
            Exhibit a1 = Resources.createTestExhibit();
            exhibitsCreated++;
            Exhibit a2 = Resources.createTestExhibit();
            exhibitsCreated++;
            Exhibit a3 = Resources.createTestExhibit();
            exhibitsCreated++;
            Exhibit a4 = Resources.createTestExhibit();
            exhibitsCreated++;
            ArrayList<Exhibit> exhibitManagementData = new ArrayList<>();
            exhibitManagementData.add(a0);
            exhibitManagementData.add(a1);
            exhibitManagementData.add(a2);
            exhibitManagementData.add(a3);
            exhibitManagementData.add(a4);

            ArrayList<Exhibit> expectedResult = new ArrayList<>();
            expectedResult.add(a0);
            expectedResult.add(a1);
            expectedResult.add(a2);
            expectedResult.add(a3);
            expectedResult.add(a4);
            String scenario = "constructor ArrayList Property";

            allPassed &= ExhibitManagementTestCases.constructorTestCase(exhibitManagementData, expectedResult,
                    scenario);
        }

        /**
         * Test for Constructer ArrayList Property with getExhibits that causes an
         * exception
         */
        {
            ArrayList<Exhibit> exhibitManagementData = new ArrayList<>();
            exhibitManagementData.add(null);
            exhibitManagementData.add(null);
            exhibitManagementData.add(null);
            exhibitManagementData.add(null);
            exhibitManagementData.add(null);

            String expectedResult = "exhibits cannot contain null";
            String scenario = "constructor with null in ArrayList";

            allPassed &= ExhibitManagementTestCases.constructorTestCase(exhibitManagementData, expectedResult,
                    scenario);
        }

        System.out.println("\tFeature Passed: " + allPassed);
        System.out.println();
        return allPassed;
    }

    /**
     * Test Suit For getExhibitArrayLength method
     * 
     * @return all tests passed
     */
    public static boolean testGetExhibitArrayLength() {
        System.out.println("\tFeature: ExhibitManagement getExhibitArrayLength");
        boolean allPassed = true;

        /**
         * Normal use with poopulated manager
         */
        {
            ExhibitManagement testExhibitManagement = Resources.createTestExhibitManagement();
            exhibitsCreated += 10;
            int expectedResult = 10;
            String scenario = "normal use";

            allPassed &= ExhibitManagementTestCases.getExhibitArrayLengthTestCase(testExhibitManagement,
                    expectedResult, scenario);
        }

        /**
         * Normal Use with empty manager
         */
        {
            ExhibitManagement testExhibitManagement = Resources.createEmptyTestExhibitManagement();
            int expectedResult = 0;
            String scenario = "normal use";

            allPassed &= ExhibitManagementTestCases.getExhibitArrayLengthTestCase(testExhibitManagement,
                    expectedResult, scenario);

        }

        System.out.println("\tFeature Passed: " + allPassed);
        System.out.println();
        return allPassed;
    }

    /**
     * Test Suit for addExhibit method
     * 
     * @return tests all passed
     */
    public static boolean testAddExhibit() {
        System.out.println("\tFeature: ExhibitManagement addExhibit");
        boolean allPassed = true;

        /**
         * Normal use
         */
        {
            ExhibitManagement testExhibitManagement = Resources.createTestExhibitManagement();
            String testExhibitName = "add Artifact";
            ArrayList<Integer> testExhibitArtifacts = new ArrayList<>();
            testExhibitArtifacts.add(1);
            testExhibitArtifacts.add(2);
            testExhibitArtifacts.add(3);
            ArrayList<String> testExhibitRoute = new ArrayList<>();
            testExhibitRoute.add("a");
            testExhibitRoute.add("b");
            testExhibitRoute.add("c");
            boolean expectedResult = true;
            exhibitsCreated += 10;
            String scenario = "normal use";
            allPassed &= ExhibitManagementTestCases.addExhibitTestCase(testExhibitManagement, testExhibitName,
                    testExhibitArtifacts, testExhibitRoute, expectedResult, scenario);
            exhibitsCreated++;
        }

        /**
         * Route is longer
         */
        {
            ExhibitManagement testExhibitManagement = Resources.createTestExhibitManagement();
            String testExhibitName = "add Artifact";
            ArrayList<Integer> testExhibitArtifacts = new ArrayList<>();
            testExhibitArtifacts.add(1);
            testExhibitArtifacts.add(2);
            ArrayList<String> testExhibitRoute = new ArrayList<>();
            testExhibitRoute.add("a");
            testExhibitRoute.add("b");
            testExhibitRoute.add("c");
            boolean expectedResult = false;
            exhibitsCreated += 10;
            String scenario = "Route is longer";
            allPassed &= ExhibitManagementTestCases.addExhibitTestCase(testExhibitManagement, testExhibitName,
                    testExhibitArtifacts, testExhibitRoute, expectedResult, scenario);

        }

        /**
         * artifacts is longer
         */
        {
            ExhibitManagement testExhibitManagement = Resources.createTestExhibitManagement();
            String testExhibitName = "add Artifact";
            ArrayList<Integer> testExhibitArtifacts = new ArrayList<>();
            testExhibitArtifacts.add(1);
            testExhibitArtifacts.add(2);
            testExhibitArtifacts.add(3);
            ArrayList<String> testExhibitRoute = new ArrayList<>();
            testExhibitRoute.add("a");
            testExhibitRoute.add("b");
            boolean expectedResult = false;
            exhibitsCreated += 10;
            String scenario = "artifacts is longer";
            allPassed &= ExhibitManagementTestCases.addExhibitTestCase(testExhibitManagement, testExhibitName,
                    testExhibitArtifacts, testExhibitRoute, expectedResult, scenario);

        }

        /**
         * route and artifacts contain null
         */
        {
            ExhibitManagement testExhibitManagement = Resources.createTestExhibitManagement();
            String testExhibitName = "add Artifact";
            ArrayList<Integer> testExhibitArtifacts = new ArrayList<>();
            testExhibitArtifacts.add(1);
            testExhibitArtifacts.add(null);
            testExhibitArtifacts.add(3);
            ArrayList<String> testExhibitRoute = new ArrayList<>();
            testExhibitRoute.add("a");
            testExhibitRoute.add(null);
            testExhibitRoute.add("c");
            boolean expectedResult = false;
            exhibitsCreated += 10;
            String scenario = "route and artifacts contain null";
            allPassed &= ExhibitManagementTestCases.addExhibitTestCase(testExhibitManagement, testExhibitName,
                    testExhibitArtifacts, testExhibitRoute, expectedResult, scenario);
        }

        /**
         * route and artifacts are null
         */
        {
            ExhibitManagement testExhibitManagement = Resources.createTestExhibitManagement();
            String testExhibitName = "add Artifact";
            ArrayList<Integer> testExhibitArtifacts = null;

            ArrayList<String> testExhibitRoute = null;

            boolean expectedResult = false;
            exhibitsCreated += 10;
            String scenario = "route and artifacts contain null";
            allPassed &= ExhibitManagementTestCases.addExhibitTestCase(testExhibitManagement, testExhibitName,
                    testExhibitArtifacts, testExhibitRoute, expectedResult, scenario);
        }

        System.out.println("\tFeature Passed: " + allPassed);
        System.out.println();
        return allPassed;
    }

    /**
     * Test Suit for exhibitsMenu method
     * 
     * @return all tests passed
     */
    public static boolean testExhibitsMenu() {
        System.out.println("\tFeature: ExhibitManagement exhibitsMenu");
        boolean allPassed = true;

        /**
         * Normal Use
         */
        {
            ExhibitManagement testExhibitManagement = Resources.createTestExhibitManagement();
            exhibitsCreated += 10;
            String expectedResult = "Exhibits\n" + //
                    "++++++++\n" + //
                    "1. test\n" + //
                    "2. test\n" + //
                    "3. test\n" + //
                    "4. test\n" + //
                    "5. test\n" + //
                    "6. test\n" + //
                    "7. test\n" + //
                    "8. test\n" + //
                    "9. test\n" + //
                    "10. test\n" + //
                    "11. Search\n" + //
                    "12. Clear\n" + //
                    "13. Quit\n" + //
                    "\n" + //
                    "Enter Selection:";
            String scenario = "normal use";

            allPassed &= ExhibitManagementTestCases.exhibitsMenuTestCase(testExhibitManagement, expectedResult,
                    scenario);
        }

        /**
         * Empty Exhibit Management
         */
        {
            ExhibitManagement testExhibitManagement = Resources.createEmptyTestExhibitManagement();
            String expectedResult = "Exhibits\n" + //
                    "++++++++\n" + //
                    "1. Search\n" + //
                    "2. Clear\n" + //
                    "3. Quit\n" + //
                    "\n" + //
                    "Enter Selection:";
            String scenario = "empty exhibitManagement use";

            allPassed &= ExhibitManagementTestCases.exhibitsMenuTestCase(testExhibitManagement, expectedResult,
                    scenario);
        }

        System.out.println("\tFeature Passed: " + allPassed);
        System.out.println();
        return allPassed;
    }

    /**
     * Test Suit for exhibitsToArray method
     * 
     * @return all tests passed
     */
    public static boolean testExhibitsToArray() {
        System.out.println("\tFeature: ExhibitManagement exhibitsToArray");
        boolean allPassed = true;

        /**
         * Normal Use
         */
        {
            Exhibit a0 = Resources.createTestExhibit();
            exhibitsCreated++;
            Exhibit a1 = Resources.createTestExhibit();
            exhibitsCreated++;
            Exhibit a2 = Resources.createTestExhibit();
            exhibitsCreated++;
            Exhibit a3 = Resources.createTestExhibit();
            exhibitsCreated++;
            Exhibit a4 = Resources.createTestExhibit();
            exhibitsCreated++;
            ArrayList<Exhibit> exhibitManagementData = new ArrayList<>();
            exhibitManagementData.add(a0);
            exhibitManagementData.add(a1);
            exhibitManagementData.add(a2);
            exhibitManagementData.add(a3);
            exhibitManagementData.add(a4);

            ExhibitManagement testExhibitManagement;
            try {
                testExhibitManagement = new ExhibitManagement(exhibitManagementData);
            } catch (Exception e) {
                testExhibitManagement = null;
            }
            Exhibit[] expectedResult = { a0, a1, a2, a3, a4 };
            String scenario = "normal use";

            allPassed &= ExhibitManagementTestCases.exhibitsToArrayTestCase(testExhibitManagement, expectedResult,
                    scenario);
        }

        /**
         * empty ArtifactManagement
         */
        {

            ExhibitManagement testExhibitManagement = Resources.createEmptyTestExhibitManagement();

            Exhibit[] expectedResult = {};
            String scenario = "empty ArtifactManagement";

            allPassed &= ExhibitManagementTestCases.exhibitsToArrayTestCase(testExhibitManagement, expectedResult,
                    scenario);
        }

        /**
         * Normal Use of static version
         */
        {
            Exhibit a0 = Resources.createTestExhibit();
            exhibitsCreated++;
            Exhibit a1 = Resources.createTestExhibit();
            exhibitsCreated++;
            Exhibit a2 = Resources.createTestExhibit();
            exhibitsCreated++;
            Exhibit a3 = Resources.createTestExhibit();
            exhibitsCreated++;
            Exhibit a4 = Resources.createTestExhibit();
            exhibitsCreated++;
            ArrayList<Exhibit> exhibitManagementData = new ArrayList<>();
            exhibitManagementData.add(a0);
            exhibitManagementData.add(a1);
            exhibitManagementData.add(a2);
            exhibitManagementData.add(a3);
            exhibitManagementData.add(a4);

            Exhibit[] expectedResult = { a0, a1, a2, a3, a4 };
            String scenario = "normal use of static method";

            allPassed &= ExhibitManagementTestCases.exhibitsToArrayTestCase(exhibitManagementData, expectedResult,
                    scenario);
        }

        /**
         * Empty ArrayList with static method
         */
        {
            ArrayList<Exhibit> exhibitManagementData = new ArrayList<>();

            Exhibit[] expectedResult = {};
            String scenario = "empty array list with static method";

            allPassed &= ExhibitManagementTestCases.exhibitsToArrayTestCase(exhibitManagementData, expectedResult,
                    scenario);
        }

        System.out.println("\tFeature Passed: " + allPassed);
        System.out.println();
        return allPassed;
    }

    /**
     * Test Suit for exhibitArrayToNameArray method
     * 
     * @return all tests passed
     */
    public static boolean testExhibitArrayToNameArray() {
        System.out.println("\tFeature: ExhibitManagement exhibitArrayToNameArray");
        boolean allPassed = true;

        /**
         * Normal Use
         */
        {
            Exhibit a0 = Resources.createTestExhibit();
            exhibitsCreated++;
            Exhibit a1 = Resources.createTestExhibit();
            exhibitsCreated++;
            Exhibit a2 = Resources.createTestExhibit();
            exhibitsCreated++;
            Exhibit a3 = Resources.createTestExhibit();
            exhibitsCreated++;
            Exhibit a4 = Resources.createTestExhibit();
            exhibitsCreated++;
            ArrayList<Exhibit> exhibitManagementData = new ArrayList<>();
            exhibitManagementData.add(a0);
            exhibitManagementData.add(a1);
            exhibitManagementData.add(a2);
            exhibitManagementData.add(a3);
            exhibitManagementData.add(a4);

            ExhibitManagement testExhibitManagement;
            try {
                testExhibitManagement = new ExhibitManagement(exhibitManagementData);
            } catch (Exception e) {
                testExhibitManagement = null;
            }

            String[] expectedResult = { "test", "test", "test", "test", "test" };
            String scenario = "normal use";

            allPassed &= ExhibitManagementTestCases.exhibitArrayToNameArrayTestCase(testExhibitManagement,
                    expectedResult, scenario);
        }

        /**
         * empty array
         */
        {

            ExhibitManagement testExhibitManagement = Resources.createEmptyTestExhibitManagement();
            String[] expectedResult = {};
            String scenario = "empty array";

            allPassed &= ExhibitManagementTestCases.exhibitArrayToNameArrayTestCase(testExhibitManagement,
                    expectedResult, scenario);

        }

        System.out.println("\tFeature Passed: " + allPassed);
        System.out.println();
        return allPassed;

    }

    /**
     * Test Suit for sortExhibitArray method
     * 
     * @return all tests passed
     */
    public static boolean testSortExhibitArray() {
        System.out.println("\tFeature: ExhibitManagement sortExhibitArray");
        boolean allPassed = true;

        /**
         * Normal Use
         */
        {
            Exhibit a0 = Resources.createTestExhibitWithName(5);
            exhibitsCreated++;
            Exhibit a1 = Resources.createTestExhibitWithName(4);
            exhibitsCreated++;
            Exhibit a2 = Resources.createTestExhibitWithName(3);
            exhibitsCreated++;
            Exhibit a3 = Resources.createTestExhibitWithName(2);
            exhibitsCreated++;
            Exhibit a4 = Resources.createTestExhibitWithName(1);
            exhibitsCreated++;
            ArrayList<Exhibit> exhibitManagementData = new ArrayList<>();
            exhibitManagementData.add(a0);
            exhibitManagementData.add(a1);
            exhibitManagementData.add(a2);
            exhibitManagementData.add(a3);
            exhibitManagementData.add(a4);

            ExhibitManagement testExhibitManagement;
            try {
                testExhibitManagement = new ExhibitManagement(exhibitManagementData);
            } catch (Exception e) {
                testExhibitManagement = null;
            }
            Exhibit[] expectedResult = { a4, a3, a2, a1, a0 };
            String scenario = "normal use";

            allPassed &= ExhibitManagementTestCases.sortExhibittArrayTestCase(testExhibitManagement, expectedResult,
                    scenario);
        }

        {

            ExhibitManagement testExhibitManagement = Resources.createEmptyTestExhibitManagement();

            Exhibit[] expectedResult = {};
            String scenario = "normal use, empty array";

            allPassed &= ExhibitManagementTestCases.sortExhibittArrayTestCase(testExhibitManagement, expectedResult,
                    scenario);
        }

        System.out.println("\tFeature Passed: " + allPassed);
        System.out.println();
        return allPassed;
    }

    /**
     * Test Suit for searchExhibits method
     * 
     * @return all tests passed
     */
    public static boolean testSearchExhibits() {
        System.out.println("\tFeature: ExhibitManagement searchExhibits");
        boolean allPassed = true;

        /**
         * Normal Use, criteria 1, search id
         */
        {
            Exhibit a0 = Resources.createTestExhibitWithName(5);
            exhibitsCreated++;
            Exhibit a1 = Resources.createTestExhibitWithName(4);
            exhibitsCreated++;
            Exhibit a2 = Resources.createTestExhibitWithName(3);
            exhibitsCreated++;
            Exhibit a3 = Resources.createTestExhibitWithName(2);
            exhibitsCreated++;
            Exhibit a4 = Resources.createTestExhibitWithName(1);
            exhibitsCreated++;
            ArrayList<Exhibit> exhibitManagementData = new ArrayList<>();
            exhibitManagementData.add(a0);
            exhibitManagementData.add(a1);
            exhibitManagementData.add(a2);
            exhibitManagementData.add(a3);
            exhibitManagementData.add(a4);

            ExhibitManagement testExhibitManagement;
            try {
                testExhibitManagement = new ExhibitManagement(exhibitManagementData);
            } catch (Exception e) {
                testExhibitManagement = null;
            }
            int criteriaChoice = 1;

            String searchValue = "" + exhibitsCreated;

            Exhibit[] expectedResult = { a4 };
            String scenario = "normal use, criteria 1, search id";

            allPassed &= ExhibitManagementTestCases.searchExhibitsTestCase(testExhibitManagement, criteriaChoice,
                    searchValue, expectedResult, scenario);
        }

        /**
         * Normal Use, criteria 2, search name
         */
        {
            Exhibit a0 = Resources.createTestExhibitWithName(5);
            exhibitsCreated++;
            Exhibit a1 = Resources.createTestExhibitWithName(4);
            exhibitsCreated++;
            Exhibit a2 = Resources.createTestExhibitWithName(3);
            exhibitsCreated++;
            Exhibit a3 = Resources.createTestExhibitWithName(2);
            exhibitsCreated++;
            Exhibit a4 = Resources.createTestExhibitWithName(1);
            exhibitsCreated++;
            ArrayList<Exhibit> exhibitManagementData = new ArrayList<>();
            exhibitManagementData.add(a0);
            exhibitManagementData.add(a1);
            exhibitManagementData.add(a2);
            exhibitManagementData.add(a3);
            exhibitManagementData.add(a4);

            ExhibitManagement testExhibitManagement;
            try {
                testExhibitManagement = new ExhibitManagement(exhibitManagementData);
            } catch (Exception e) {
                testExhibitManagement = null;
            }
            int criteriaChoice = 2;

            String searchValue = "5";

            Exhibit[] expectedResult = { a0 };
            String scenario = "normal use, criteria 2, search name";

            allPassed &= ExhibitManagementTestCases.searchExhibitsTestCase(testExhibitManagement, criteriaChoice,
                    searchValue, expectedResult, scenario);
        }

        /**
         * Normal Use, criteria 5, no search
         */
        {
            Exhibit a0 = Resources.createTestExhibitWithName(5);
            exhibitsCreated++;
            Exhibit a1 = Resources.createTestExhibitWithName(4);
            exhibitsCreated++;
            Exhibit a2 = Resources.createTestExhibitWithName(3);
            exhibitsCreated++;
            Exhibit a3 = Resources.createTestExhibitWithName(2);
            exhibitsCreated++;
            Exhibit a4 = Resources.createTestExhibitWithName(1);
            exhibitsCreated++;
            ArrayList<Exhibit> exhibitManagementData = new ArrayList<>();
            exhibitManagementData.add(a0);
            exhibitManagementData.add(a1);
            exhibitManagementData.add(a2);
            exhibitManagementData.add(a3);
            exhibitManagementData.add(a4);

            ExhibitManagement testExhibitManagement;
            try {
                testExhibitManagement = new ExhibitManagement(exhibitManagementData);
            } catch (Exception e) {
                testExhibitManagement = null;
            }
            int criteriaChoice = 5;
            String searchValue = "1";

            Exhibit[] expectedResult = { a0, a1, a2, a3, a4 };
            String scenario = "normal use, criteria 5, no search";

            allPassed &= ExhibitManagementTestCases.searchExhibitsTestCase(testExhibitManagement, criteriaChoice,
                    searchValue, expectedResult, scenario);
        }

        /**
         * Normal Use, criteria 0, no search
         */
        {
            Exhibit a0 = Resources.createTestExhibitWithName(5);
            exhibitsCreated++;
            Exhibit a1 = Resources.createTestExhibitWithName(4);
            exhibitsCreated++;
            Exhibit a2 = Resources.createTestExhibitWithName(3);
            exhibitsCreated++;
            Exhibit a3 = Resources.createTestExhibitWithName(2);
            exhibitsCreated++;
            Exhibit a4 = Resources.createTestExhibitWithName(1);
            exhibitsCreated++;
            ArrayList<Exhibit> exhibitManagementData = new ArrayList<>();
            exhibitManagementData.add(a0);
            exhibitManagementData.add(a1);
            exhibitManagementData.add(a2);
            exhibitManagementData.add(a3);
            exhibitManagementData.add(a4);

            ExhibitManagement testExhibitManagement;
            try {
                testExhibitManagement = new ExhibitManagement(exhibitManagementData);
            } catch (Exception e) {
                testExhibitManagement = null;
            }
            int criteriaChoice = 0;
            String searchValue = "1";

            Exhibit[] expectedResult = { a0, a1, a2, a3, a4 };
            String scenario = "normal use, criteria 0,  no search";

            allPassed &= ExhibitManagementTestCases.searchExhibitsTestCase(testExhibitManagement, criteriaChoice,
                    searchValue, expectedResult, scenario);
        }

        /**
         * Normal Use, criteria -1, no search
         */
        {
            Exhibit a0 = Resources.createTestExhibitWithName(5);
            exhibitsCreated++;
            Exhibit a1 = Resources.createTestExhibitWithName(4);
            exhibitsCreated++;
            Exhibit a2 = Resources.createTestExhibitWithName(3);
            exhibitsCreated++;
            Exhibit a3 = Resources.createTestExhibitWithName(2);
            exhibitsCreated++;
            Exhibit a4 = Resources.createTestExhibitWithName(1);
            exhibitsCreated++;
            ArrayList<Exhibit> exhibitManagementData = new ArrayList<>();
            exhibitManagementData.add(a0);
            exhibitManagementData.add(a1);
            exhibitManagementData.add(a2);
            exhibitManagementData.add(a3);
            exhibitManagementData.add(a4);

            ExhibitManagement testExhibitManagement;
            try {
                testExhibitManagement = new ExhibitManagement(exhibitManagementData);
            } catch (Exception e) {
                testExhibitManagement = null;
            }
            int criteriaChoice = -1;
            String searchValue = "1";

            Exhibit[] expectedResult = { a0, a1, a2, a3, a4 };
            String scenario = "normal use, criteria -1,  no search";

            allPassed &= ExhibitManagementTestCases.searchExhibitsTestCase(testExhibitManagement, criteriaChoice,
                    searchValue, expectedResult, scenario);
        }

        System.out.println("\tFeature Passed: " + allPassed);
        System.out.println();
        return allPassed;
    }

    /**
     * Test Suit for getExhibitMenu method
     * 
     * @return all tests passed
     */
    public static boolean testGetExhibitMenu() {
        System.out.println("\tFeature: ExhibitMenu getExhibitMenu");
        boolean allPassed = true;

        /**
         * Normal Use
         */
        {
            Exhibit a0 = Resources.createTestExhibitWithName(5);
            exhibitsCreated++;
            Exhibit a1 = Resources.createTestExhibitWithName(4);
            exhibitsCreated++;
            Exhibit a2 = Resources.createTestExhibitWithName(3);
            exhibitsCreated++;
            Exhibit a3 = Resources.createTestExhibitWithName(2);
            exhibitsCreated++;
            Exhibit a4 = Resources.createTestExhibitWithName(1);
            exhibitsCreated++;
            ArrayList<Exhibit> exhibitManagementData = new ArrayList<>();
            exhibitManagementData.add(a0);
            exhibitManagementData.add(a1);
            exhibitManagementData.add(a2);
            exhibitManagementData.add(a3);
            exhibitManagementData.add(a4);

            ExhibitManagement testExhibitManagement;
            try {
                testExhibitManagement = new ExhibitManagement(exhibitManagementData);
            } catch (Exception e) {
                testExhibitManagement = null;
            }
            String expectedResult = "Exhibits\n" + //
                    "++++++++\n" + //
                    "1. test1\n" + //
                    "2. test2\n" + //
                    "3. test3\n" + //
                    "4. test4\n" + //
                    "5. test5\n" + //
                    "6. Search\n" + //
                    "7. Clear\n" + //
                    "8. Quit\n" + //
                    "\n" + //
                    "Enter Selection:";
            String scenario = "normal use";

            allPassed &= ExhibitManagementTestCases.exhibitsMenuTestCase(testExhibitManagement, expectedResult,
                    scenario);
        }

        /**
         * Empty Artifact Management
         */
        {
            ExhibitManagement testExhibitManagement = Resources.createEmptyTestExhibitManagement();
            String expectedResult = "Exhibits\n" + //
                    "++++++++\n" + //
                    "1. Search\n" + //
                    "2. Clear\n" + //
                    "3. Quit\n" + //
                    "\n" + //
                    "Enter Selection:";
            String scenario = "empty artifactManagement use";

            allPassed &= ExhibitManagementTestCases.exhibitsMenuTestCase(testExhibitManagement, expectedResult,
                    scenario);
        }

        System.out.println("\tFeature Passed: " + allPassed);
        System.out.println();
        return allPassed;
    }

    /**
     * Test Suit for getExhibitString method
     * 
     * @return all tests passed
     */
    public static boolean testGetExhibitString() {
        System.out.println("\tFeature: ExhibitManagement getExhibitString");
        boolean allPassed = true;

        /**
         * Normal Use
         */
        {
            ArtifactManagement testArtifactManagement = Resources.createTestArtifactManagement();
            artifactsCreated += 10;
            ExhibitManagement testExhibitManagement = Resources.createTestExhibitManagement(testArtifactManagement);
            exhibitsCreated += 10;
            int exhibitChoice = 9;
            String expectedResult = "ID: " + exhibitsCreated + "Name: test\n" + //
                    "Artifacts for the Exhibit\n" + //
                    "test\n" + //
                    "\n" + //
                    "Route:\n" + //
                    "Steps                                      Signs\n" + //
                    "1. test                                    a\n" + //
                    "\n" + //
                    "Total Engagement Time: 4 minutes";
            String scenario = "normal use";

            allPassed &= ExhibitManagementTestCases.getExhibitStringTestCase(testExhibitManagement, exhibitChoice,
                    testArtifactManagement, expectedResult, scenario);

        }

        /**
         * choice exceeds created artifacts
         */
        {
            ArtifactManagement testArtifactManagement = Resources.createTestArtifactManagement();
            artifactsCreated += 10;
            ExhibitManagement testExhibitManagement = Resources.createTestExhibitManagement(testArtifactManagement);
            exhibitsCreated += 10;
            int exhibitChoice = 11;
            String expectedResult = "exhibit choice out of range";
            String scenario = "choice exceeds created artifacts";

            allPassed &= ExhibitManagementTestCases.getExhibitStringTestCase(testExhibitManagement, exhibitChoice,
                    testArtifactManagement, expectedResult, scenario);

        }

        /**
         * choice below created artifacts
         */
        {
            ArtifactManagement testArtifactManagement = Resources.createTestArtifactManagement();
            artifactsCreated += 10;
            ExhibitManagement testExhibitManagement = Resources.createTestExhibitManagement(testArtifactManagement);
            exhibitsCreated += 10;
            int exhibitChoice = -10;
            String expectedResult = "exhibit choice out of range";
            String scenario = "choice below created artifacts";

            allPassed &= ExhibitManagementTestCases.getExhibitStringTestCase(testExhibitManagement, exhibitChoice,
                    testArtifactManagement, expectedResult, scenario);
        }

        /**
         * artifactIDs not in artifactManagement
         */
        {
            ArtifactManagement testArtifactManagement = Resources.createTestArtifactManagement();
            artifactsCreated += 10;
            ExhibitManagement testExhibitManagement = Resources.createTestExhibitManagement();
            exhibitsCreated += 10;
            int exhibitChoice = 9;
            String expectedResult = "ID: " + exhibitsCreated + "Name: test\n" + //
                    "Artifacts for the Exhibit\n" + //
                    "\n" + //
                    "Route:\n" + //
                    "Steps                                      Signs\n" + //
                    "\n" + //
                    "Total Engagement Time: 0 minutes";
            String scenario = "artifactIDs not in artifactManagement";

            allPassed &= ExhibitManagementTestCases.getExhibitStringTestCase(testExhibitManagement, exhibitChoice,
                    testArtifactManagement, expectedResult, scenario);
        }

        /**
         * artifactManagement is null
         */
        {
            ArtifactManagement testArtifactManagement = null;
            ExhibitManagement testExhibitManagement = Resources.createTestExhibitManagement();
            exhibitsCreated += 10;
            int exhibitChoice = 9;
            String expectedResult = "ID: " + exhibitsCreated + "Name: test\n" + //
                    "Artifacts for the Exhibit\n" + //
                    "\n" + //
                    "Route:\n" + //
                    "Steps                                      Signs\n" + //
                    "\n" + //
                    "Total Engagement Time: 0 minutes";
            String scenario = "artifactManagement is null";

            allPassed &= ExhibitManagementTestCases.getExhibitStringTestCase(testExhibitManagement, exhibitChoice,
                    testArtifactManagement, expectedResult, scenario);
        }

        System.out.println("\tFeature Passed: " + allPassed);
        System.out.println();
        return allPassed;
    }

    /**
     * Test Suit for removeExhibit method
     * 
     * @return all tests passed
     */
    public static boolean testRemoveExhibit() {
        System.out.println("\tFeature: ExhibitManagement  removeExhibit");
        boolean allPassed = true;

        /**
         * normal use
         */
        {
            Exhibit a0 = Resources.createTestExhibitWithName(5);
            exhibitsCreated++;
            Exhibit a1 = Resources.createTestExhibitWithName(4);
            exhibitsCreated++;
            Exhibit a2 = Resources.createTestExhibitWithName(3);
            exhibitsCreated++;
            Exhibit a3 = Resources.createTestExhibitWithName(2);
            exhibitsCreated++;
            Exhibit a4 = Resources.createTestExhibitWithName(1);
            exhibitsCreated++;
            ArrayList<Exhibit> exhibitManagementData = new ArrayList<>();
            exhibitManagementData.add(a0);
            exhibitManagementData.add(a1);
            exhibitManagementData.add(a2);
            exhibitManagementData.add(a3);
            exhibitManagementData.add(a4);

            ExhibitManagement testExhibitManagement;
            try {
                testExhibitManagement = new ExhibitManagement(exhibitManagementData);
            } catch (Exception e) {
                testExhibitManagement = null;
            }
            ArrayList<Exhibit> expectedResult = new ArrayList<>();
            expectedResult.add(a0);
            expectedResult.add(a1);
            expectedResult.add(a2);
            expectedResult.add(a3);
          

            int artifactChoice = exhibitsCreated;
            String scenario = "normal use";

            allPassed &= ExhibitManagementTestCases.removeExhibitTestCase(testExhibitManagement, artifactChoice,
                    expectedResult, scenario);
        }

        /**
         * out of range choice
         */
        {
            Exhibit a0 = Resources.createTestExhibitWithName(5);
            exhibitsCreated++;
            Exhibit a1 = Resources.createTestExhibitWithName(4);
            exhibitsCreated++;
            Exhibit a2 = Resources.createTestExhibitWithName(3);
            exhibitsCreated++;
            Exhibit a3 = Resources.createTestExhibitWithName(2);
            exhibitsCreated++;
            Exhibit a4 = Resources.createTestExhibitWithName(1);
            exhibitsCreated++;
            ArrayList<Exhibit> exhibitManagementData = new ArrayList<>();
            exhibitManagementData.add(a0);
            exhibitManagementData.add(a1);
            exhibitManagementData.add(a2);
            exhibitManagementData.add(a3);
            exhibitManagementData.add(a4);

            ExhibitManagement testExhibitManagement;
            try {
                testExhibitManagement = new ExhibitManagement(exhibitManagementData);
            } catch (Exception e) {
                testExhibitManagement = null;
            }
            ArrayList<Exhibit> expectedResult = new ArrayList<>();
            expectedResult.add(a0);
            expectedResult.add(a1);
            expectedResult.add(a2);
            expectedResult.add(a3);
            expectedResult.add(a4);

            int artifactChoice = -1;
            String scenario = "out of range choice";

            allPassed &= ExhibitManagementTestCases.removeExhibitTestCase(testExhibitManagement, artifactChoice,
                    expectedResult, scenario);
        }

        /**
         * out of range choice
         */
        {
            Exhibit a0 = Resources.createTestExhibitWithName(5);
            exhibitsCreated++;
            Exhibit a1 = Resources.createTestExhibitWithName(4);
            exhibitsCreated++;
            Exhibit a2 = Resources.createTestExhibitWithName(3);
            exhibitsCreated++;
            Exhibit a3 = Resources.createTestExhibitWithName(2);
            exhibitsCreated++;
            Exhibit a4 = Resources.createTestExhibitWithName(1);
            exhibitsCreated++;
            ArrayList<Exhibit> exhibitManagementData = new ArrayList<>();
            exhibitManagementData.add(a0);
            exhibitManagementData.add(a1);
            exhibitManagementData.add(a2);
            exhibitManagementData.add(a3);
            exhibitManagementData.add(a4);

            ExhibitManagement testExhibitManagement;
            try {
                testExhibitManagement = new ExhibitManagement(exhibitManagementData);
            } catch (Exception e) {
                testExhibitManagement = null;
            }
            ArrayList<Exhibit> expectedResult = new ArrayList<>();
            expectedResult.add(a0);
            expectedResult.add(a1);
            expectedResult.add(a2);
            expectedResult.add(a3);
            expectedResult.add(a4);

            int artifactChoice = 5;
            String scenario = "out of range choice";

            allPassed &= ExhibitManagementTestCases.removeExhibitTestCase(testExhibitManagement, artifactChoice,
                    expectedResult, scenario);
        }

        /**
         * empty exhibits
         */
        {

            ExhibitManagement tesetExhibitManagement = Resources.createEmptyTestExhibitManagement();

            ArrayList<Exhibit> expectedResult = new ArrayList<>();

            int artifactChoice = 2;
            String scenario = "empty exhibits";

            allPassed &= ExhibitManagementTestCases.removeExhibitTestCase(tesetExhibitManagement, artifactChoice,
                    expectedResult, scenario);
        }

        System.out.println("\tFeature Passed: " + allPassed);
        System.out.println();
        return allPassed;

    }

    /**
     * Test getExhibitArtifactNames method
     * 
     * @return all tests passed
     */
    public static boolean testGetExhibitArtifactNames() {
        System.out.println("\tFeature: ExhibitManagement getExhibitArtifactNames");
        boolean allPassed = true;

        /**
         * Normal use
         */
        {
            ArtifactManagement artifactManagement = Resources.createTestArtifactManagement();
            artifactsCreated += 10;
            ExhibitManagement exhibitManagement = Resources.createTestExhibitManagement(artifactManagement);
            exhibitsCreated += 10;
            int exhibitChoice = 0;
            String[] expectedResult = { "test" };
            String scenario = "normal use";

            allPassed &= ExhibitManagementTestCases.getExhibitArtifactNamesTestCase(exhibitManagement, exhibitChoice,
                    artifactManagement, expectedResult, scenario);
        }

        /**
         * exhibit Artifacts not in artifact management
         */
        {
            ArtifactManagement artifactManagement = Resources.createTestArtifactManagement();
            artifactsCreated += 10;
            ExhibitManagement exhibitManagement = Resources.createTestExhibitManagement();
            exhibitsCreated += 10;
            int exhibitChoice = 0;
            String[] expectedResult = {};
            String scenario = "normal use";

            allPassed &= ExhibitManagementTestCases.getExhibitArtifactNamesTestCase(exhibitManagement, exhibitChoice,
                    artifactManagement, expectedResult, scenario);
        }

        /**
         * artifact management is null
         */
        {
            ArtifactManagement artifactManagement = null;
            ExhibitManagement exhibitManagement = Resources.createTestExhibitManagement();
            exhibitsCreated += 10;
            int exhibitChoice = 0;
            String[] expectedResult = {};
            String scenario = "normal use";

            allPassed &= ExhibitManagementTestCases.getExhibitArtifactNamesTestCase(exhibitManagement, exhibitChoice,
                    artifactManagement, expectedResult, scenario);
        }

        /**
         * choice outside range
         */
        {
            ArtifactManagement artifactManagement = null;
            ExhibitManagement exhibitManagement = Resources.createTestExhibitManagement();
            exhibitsCreated += 10;
            int exhibitChoice = -1;
            String[] expectedResult = {};
            String scenario = "normal use";

            allPassed &= ExhibitManagementTestCases.getExhibitArtifactNamesTestCase(exhibitManagement, exhibitChoice,
                    artifactManagement, expectedResult, scenario);
        }

        /**
         * choice outside range
         */
        {
            ArtifactManagement artifactManagement = null;
            ExhibitManagement exhibitManagement = Resources.createTestExhibitManagement();
            exhibitsCreated += 10;
            int exhibitChoice = 10;
            String[] expectedResult = {};
            String scenario = "normal use";

            allPassed &= ExhibitManagementTestCases.getExhibitArtifactNamesTestCase(exhibitManagement, exhibitChoice,
                    artifactManagement, expectedResult, scenario);
        }

        System.out.println("\tFeature Passed: " + allPassed);
        System.out.println();
        return allPassed;
    }

    /**
     * Test Suit for getExhibitArtifactMenu method
     * 
     * @return all tests passed
     */
    public static boolean testGetExhibitArtifactMenu() {
        System.out.println("\tFeature: ExhibitMenu getExhibitArtifactMenu");
        boolean allPassed = true;

        /**
         * Normal Use
         */
        {
            ArtifactManagement artifactManagement = Resources.createTestArtifactManagement();
            artifactsCreated += 10;
            ExhibitManagement exhibitManagement = Resources.createTestExhibitManagement(artifactManagement);
            exhibitsCreated += 10;
            int exhibitChoice = 0;
            String expectedResult = "Artifact To Change\n" + //
                    "++++++++++++++++++\n" + //
                    "1. test\n" + //
                    "2. Quit\n" + //
                    "\n" + //
                    "Enter Selection:";
            String scenario = "normal use";

            allPassed &= ExhibitManagementTestCases.getExhibitArtifactMenuTestCase(exhibitManagement, exhibitChoice,
                    artifactManagement, expectedResult,
                    scenario);
        }

        /**
         * Empty Artifact Management
         */
        {
            ArtifactManagement artifactManagement = Resources.createTestArtifactManagement();
            artifactsCreated += 10;
            ExhibitManagement exhibitManagement = Resources.createTestExhibitManagement();
            exhibitsCreated += 10;
            int exhibitChoice = 0;
            String expectedResult = "Artifact To Change\n" + //
                    "++++++++++++++++++\n" + //

                    "1. Quit\n" + //
                    "\n" + //
                    "Enter Selection:";
            String scenario = "empty artifactManagement use";

            allPassed &= ExhibitManagementTestCases.getExhibitArtifactMenuTestCase(exhibitManagement, exhibitChoice,
                    artifactManagement, expectedResult,
                    scenario);
        }

        /**
         * artifact management is null
         */
        {
            ArtifactManagement artifactManagement = null;
            ExhibitManagement exhibitManagement = Resources.createTestExhibitManagement();
            exhibitsCreated += 10;
            int exhibitChoice = 0;
            String expectedResult = "Artifact To Change\n" + //
                    "++++++++++++++++++\n" + //

                    "1. Quit\n" + //
                    "\n" + //
                    "Enter Selection:";
            String scenario = "artifact management is null";

            allPassed &= ExhibitManagementTestCases.getExhibitArtifactMenuTestCase(exhibitManagement, exhibitChoice,
                    artifactManagement, expectedResult,
                    scenario);
        }

        /**
         * choice outside range
         */
        {
            ArtifactManagement artifactManagement = null;
            ExhibitManagement exhibitManagement = Resources.createTestExhibitManagement();
            exhibitsCreated += 10;
            int exhibitChoice = -1;
            String expectedResult = "Artifact To Change\n" + //
                    "++++++++++++++++++\n" + //

                    "1. Quit\n" + //
                    "\n" + //
                    "Enter Selection:";
            String scenario = "choice outside range";

            allPassed &= ExhibitManagementTestCases.getExhibitArtifactMenuTestCase(exhibitManagement, exhibitChoice,
                    artifactManagement, expectedResult, scenario);
        }

        /**
         * choice outside range
         */
        {
            ArtifactManagement artifactManagement = null;
            ExhibitManagement exhibitManagement = Resources.createTestExhibitManagement();
            exhibitsCreated += 10;
            int exhibitChoice = 10;
            String expectedResult = "Artifact To Change\n" + //
                    "++++++++++++++++++\n" + //

                    "1. Quit\n" + //
                    "\n" + //
                    "Enter Selection:";
            String scenario = "choice outside range";

            allPassed &= ExhibitManagementTestCases.getExhibitArtifactMenuTestCase(exhibitManagement, exhibitChoice,
                    artifactManagement, expectedResult, scenario);
        }

        System.out.println("\tFeature Passed: " + allPassed);
        System.out.println();
        return allPassed;
    }

    /**
     * Test Suit for getExhibitArtifactMenu method
     * 
     * @return all tests passed
     */
    public static boolean testGetArtifactNumber() {
        System.out.println("\tFeature: ExhibitMenu getArtifactNumber");
        boolean allPassed = true;

        /**
         * Normal Use
         */
        {
            ExhibitManagement exhibitManagement = Resources.createTestExhibitManagement();
            exhibitsCreated += 10;
            int exhibitChoice = 0;
            int expectedResult = 4;
            String scenario = "normal use";

            allPassed &= ExhibitManagementTestCases.getArtifactNumberTestCase(exhibitManagement, exhibitChoice,
                    expectedResult,
                    scenario);
        }

        /**
         * choice outside range
         */
        {
            ExhibitManagement exhibitManagement = Resources.createTestExhibitManagement();
            exhibitsCreated += 10;
            int exhibitChoice = -1;
            int expectedResult = -1;
            String scenario = "choice outside range";

            allPassed &= ExhibitManagementTestCases.getArtifactNumberTestCase(exhibitManagement, exhibitChoice,
                    expectedResult,
                    scenario);
        }

        /**
         * choice outside range
         */
        {
            ExhibitManagement exhibitManagement = Resources.createTestExhibitManagement();
            exhibitsCreated += 10;
            int exhibitChoice = 10;
            int expectedResult = -1;
            String scenario = "choice outside range";

            allPassed &= ExhibitManagementTestCases.getArtifactNumberTestCase(exhibitManagement, exhibitChoice,
                    expectedResult,
                    scenario);
        }

        System.out.println("\tFeature Passed: " + allPassed);
        System.out.println();
        return allPassed;
    }

    /**
     * Test Suit for getExhibitRoute method
     * 
     * @return all tests passed
     */
    public static boolean testGetExhibitRoute() {
        System.out.println("\tFeature: ExhibitMenu getExhibitRoute");
        boolean allPassed = true;

        /**
         * Normal Use
         */
        {
            ExhibitManagement exhibitManagement = Resources.createTestExhibitManagement();
            exhibitsCreated += 10;
            int exhibitChoice = 0;
            ArrayList<String> expectedResult = new ArrayList<>();
            expectedResult.add("a");
            expectedResult.add("b");
            expectedResult.add("c");
            expectedResult.add("d");
            String scenario = "normal use";

            allPassed &= ExhibitManagementTestCases.getExhibitRouteTestCase(exhibitManagement, exhibitChoice,
                    expectedResult,
                    scenario);
        }

        /**
         * choice outside range
         */
        {
            ExhibitManagement exhibitManagement = Resources.createTestExhibitManagement();
            exhibitsCreated += 10;
            int exhibitChoice = -1;
            ArrayList<String> expectedResult = new ArrayList<>();
            String scenario = "choice outside range";

            allPassed &= ExhibitManagementTestCases.getExhibitRouteTestCase(exhibitManagement, exhibitChoice,
                    expectedResult,
                    scenario);
        }

        /**
         * choice outside range
         */
        {
            ExhibitManagement exhibitManagement = Resources.createTestExhibitManagement();
            exhibitsCreated += 10;
            int exhibitChoice = 10;
            ArrayList<String> expectedResult = new ArrayList<>();
            String scenario = "choice outside range";

            allPassed &= ExhibitManagementTestCases.getExhibitRouteTestCase(exhibitManagement, exhibitChoice,
                    expectedResult,
                    scenario);
        }

        System.out.println("\tFeature Passed: " + allPassed);
        System.out.println();
        return allPassed;
    }

    /**
     * Test Suit for getExhibitArtifacts method
     * 
     * @return all tests passed
     */
    public static boolean testGetExhibitArtifacts() {
        System.out.println("\tFeature: ExhibitMenu getExhibitArtifacts");
        boolean allPassed = true;

        /**
         * Normal Use
         */
        {
            ArtifactManagement artifactManagement = Resources.createTestArtifactManagement();

            ExhibitManagement exhibitManagement = Resources.createTestExhibitManagement(artifactManagement);

            int exhibitChoice = 0;
            artifactsCreated += 10;
            exhibitsCreated += 10;
            ArrayList<Integer> expectedResult = new ArrayList<>();
            expectedResult.add(artifactsCreated - 9);

            String scenario = "normal use";

            allPassed &= ExhibitManagementTestCases.getExhibitArtifactsTestCase(exhibitManagement, exhibitChoice,
                    expectedResult,
                    scenario);
        }

        /**
         * choice outside range
         */
        {
            ExhibitManagement exhibitManagement = Resources.createTestExhibitManagement();
            exhibitsCreated += 10;
            int exhibitChoice = -1;
            ArrayList<Integer> expectedResult = new ArrayList<>();
            String scenario = "choice outside range";

            allPassed &= ExhibitManagementTestCases.getExhibitArtifactsTestCase(exhibitManagement, exhibitChoice,
                    expectedResult,
                    scenario);
        }

        /**
         * choice outside range
         */
        {
            ExhibitManagement exhibitManagement = Resources.createTestExhibitManagement();
            exhibitsCreated += 10;
            int exhibitChoice = 10;
            ArrayList<Integer> expectedResult = new ArrayList<>();
            String scenario = "choice outside range";

            allPassed &= ExhibitManagementTestCases.getExhibitArtifactsTestCase(exhibitManagement, exhibitChoice,
                    expectedResult,
                    scenario);
        }

        System.out.println("\tFeature Passed: " + allPassed);
        System.out.println();
        return allPassed;
    }

    /**
     * Test Suit for getExhibitArtifactsByID method
     * 
     * @return all tests passed
     */
    public static boolean testGetExhibitArtifactsByID() {
        System.out.println("\tFeature: ExhibitMenu getExhibitArtifactsByID");
        boolean allPassed = true;

        /**
         * Normal Use
         */
        {
            ArtifactManagement artifactManagement = Resources.createTestArtifactManagement();

            ExhibitManagement exhibitManagement = Resources.createTestExhibitManagement(artifactManagement);

            int exhibitID = exhibitsCreated + 1;
            artifactsCreated += 10;
            exhibitsCreated += 10;
            ArrayList<Integer> expectedResult = new ArrayList<>();
            expectedResult.add(artifactsCreated - 9);

            String scenario = "normal use";

            allPassed &= ExhibitManagementTestCases.getExhibitArtifactsByIDTestCase(exhibitManagement, exhibitID,
                    expectedResult,
                    scenario);
        }

        /**
         * ID not in exhibitManagement
         */
        {
            ExhibitManagement exhibitManagement = Resources.createTestExhibitManagement();
            exhibitsCreated += 10;
            int exhibitID = exhibitsCreated + 1;
            ArrayList<Integer> expectedResult = new ArrayList<>();
            String scenario = "choice outside range";

            allPassed &= ExhibitManagementTestCases.getExhibitArtifactsByIDTestCase(exhibitManagement, exhibitID,
                    expectedResult,
                    scenario);
        }

        System.out.println("\tFeature Passed: " + allPassed);
        System.out.println();
        return allPassed;
    }

    /**
     * Test Suit for updateExhibit method
     * 
     * @return all tests passed
     */
    public static boolean testUpdateExhibit() {
        System.out.println("\tFeature: ArtifactManagement updateExhibit");
        boolean allPassed = true;

        /**
         * Normal use
         */
        {

            ExhibitManagement exhibitManagement = Resources.createTestExhibitManagement();
            exhibitsCreated += 10;
            int exhibitChoice = 0;
            String exhibitName = "update";
            ArrayList<Integer> artifacts = new ArrayList<>();
            artifacts.add(1);
            ArrayList<String> route = new ArrayList<>();
            route.add("a");
            boolean expectedResult = true;
            String scenario = "normal use";

            allPassed &= ExhibitManagementTestCases.updateExhibitTestCase(exhibitManagement, exhibitChoice,
                    exhibitName, artifacts, route, expectedResult, scenario);
        }

        /**
         * Route is longer
         */
        {

            ExhibitManagement exhibitManagement = Resources.createTestExhibitManagement();
            exhibitsCreated += 10;
            int exhibitChoice = 0;
            String exhibitName = "update";
            ArrayList<Integer> artifacts = new ArrayList<>();
            artifacts.add(1);
            ArrayList<String> route = new ArrayList<>();
            route.add("a");
            route.add("b");
            boolean expectedResult = false;
            String scenario = " Route is longer";

            allPassed &= ExhibitManagementTestCases.updateExhibitTestCase(exhibitManagement, exhibitChoice,
                    exhibitName, artifacts, route, expectedResult, scenario);
        }

        /**
         * artifacts is longer
         */
        {

            ExhibitManagement exhibitManagement = Resources.createTestExhibitManagement();
            exhibitsCreated += 10;
            int exhibitChoice = 0;
            String exhibitName = "update";
            ArrayList<Integer> artifacts = new ArrayList<>();
            artifacts.add(1);
            artifacts.add(2);
            ArrayList<String> route = new ArrayList<>();
            route.add("a");
            boolean expectedResult = false;
            String scenario = " artifacts is longer";

            allPassed &= ExhibitManagementTestCases.updateExhibitTestCase(exhibitManagement, exhibitChoice,
                    exhibitName, artifacts, route, expectedResult, scenario);
        }

        /**
         * both are empty
         */
        {

            ExhibitManagement exhibitManagement = Resources.createTestExhibitManagement();
            exhibitsCreated += 10;
            int exhibitChoice = 0;
            String exhibitName = "update";
            ArrayList<Integer> artifacts = new ArrayList<>();

            ArrayList<String> route = new ArrayList<>();

            boolean expectedResult = true;
            String scenario = " both are empty";

            allPassed &= ExhibitManagementTestCases.updateExhibitTestCase(exhibitManagement, exhibitChoice,
                    exhibitName, artifacts, route, expectedResult, scenario);
        }

        /**
         * both are null
         */
        {

            ExhibitManagement exhibitManagement = Resources.createTestExhibitManagement();
            exhibitsCreated += 10;
            int exhibitChoice = 0;
            String exhibitName = "update";
            ArrayList<Integer> artifacts = null;

            ArrayList<String> route = null;

            boolean expectedResult = false;
            String scenario = " both are null";

            allPassed &= ExhibitManagementTestCases.updateExhibitTestCase(exhibitManagement, exhibitChoice,
                    exhibitName, artifacts, route, expectedResult, scenario);
        }

        System.out.println("\tFeature Passed: " + allPassed);
        System.out.println();
        return allPassed;
    }

    /**
     * Test Suit for removeArtifactsWithID method, all tested using the last exhibit
     * in exhibitManagement
     * 
     * @return all tests passed
     */
    public static boolean testRemoveArtifactsWithID() {
        System.out.println("\tFeature: ExhibitManagement removeArtifactsWithID");
        boolean allPassed = true;

        /**
         * Normal Use
         */
        {
            ArtifactManagement artifactManagement = Resources.createTestArtifactManagement();
            artifactsCreated += 10;
            ExhibitManagement exhibitManagement = Resources.createTestExhibitManagement(artifactManagement);
            exhibitsCreated += 10;
            int artifactID = artifactsCreated;
            int exhibitChoice = 9;
            ArrayList<Integer> expectedResult = new ArrayList<>();
            String scenario = "normal use";

            allPassed &= ExhibitManagementTestCases.removeArtifactsWithIDTestCase(exhibitManagement, artifactID,
                    exhibitChoice, artifactManagement, expectedResult, scenario);
        }

        /**
         * negative id
         */
        {
            ArtifactManagement artifactManagement = Resources.createTestArtifactManagement();
            artifactsCreated += 10;
            ExhibitManagement exhibitManagement = Resources.createTestExhibitManagement(artifactManagement);
            exhibitsCreated += 10;
            int artifactID = -1;
            int exhibitChoice = 9;
            ArrayList<Integer> expectedResult = new ArrayList<>();
            expectedResult.add(artifactsCreated);
            String scenario = "negative id";

            allPassed &= ExhibitManagementTestCases.removeArtifactsWithIDTestCase(exhibitManagement, artifactID,
                    exhibitChoice, artifactManagement, expectedResult, scenario);
        }

        System.out.println("\tFeature Passed: " + allPassed);
        System.out.println();
        return allPassed;
    }

    /**
     * Test Suit for getExhibitionExhibtNames method
     * 
     * @return all tests passed
     */
    public static boolean testGetExhibitionExhibtNames() {
        System.out.println("\tFeature: ExhibitManagement removeArtifactsWithID");
        boolean allPassed = true;

        /**
         * Normal Use, 1D
         */
        {
            ExhibitManagement exhibitManagement = Resources.createTestExhibitManagement();
            exhibitsCreated += 10;
            int[] exhibitIDs = { exhibitsCreated - 9, exhibitsCreated - 8, exhibitsCreated - 7 };
            String[] expectedResult = { "test", "test", "test" };
            String scenario = "normal use, 1D";

            allPassed &= ExhibitManagementTestCases.getExhibitionExhibtNamesTestCase(exhibitManagement, exhibitIDs,
                    expectedResult, scenario);
        }

        /**
         * Normal Use, 2D
         */
        {
            ExhibitManagement exhibitManagement = Resources.createTestExhibitManagement();
            exhibitsCreated += 10;
            int[][] exhibitIDs = { { exhibitsCreated - 9, exhibitsCreated - 8, exhibitsCreated - 7 },
                    { exhibitsCreated - 6, exhibitsCreated - 5, exhibitsCreated - 4 },
                    { exhibitsCreated - 3, exhibitsCreated - 2, exhibitsCreated - 1 } };
            String[][] expectedResult = { { "test", "test", "test" }, { "test", "test", "test" },
                    { "test", "test", "test" } };
            String scenario = "normal use, 2D";

            allPassed &= ExhibitManagementTestCases.getExhibitionExhibtNamesTestCase(exhibitManagement, exhibitIDs,
                    expectedResult, scenario);
        }

        /**
         * exhibitIDs is null, 1D
         */
        {
            ExhibitManagement exhibitManagement = Resources.createTestExhibitManagement();
            exhibitsCreated += 10;
            int[] exhibitIDs = null;
            String[] expectedResult = {};
            String scenario = "exhibitIDs is null, 1D";

            allPassed &= ExhibitManagementTestCases.getExhibitionExhibtNamesTestCase(exhibitManagement, exhibitIDs,
                    expectedResult, scenario);
        }

        /**
         * exhibitIDs is null, 2D
         */
        {
            ExhibitManagement exhibitManagement = Resources.createTestExhibitManagement();
            exhibitsCreated += 10;
            int[][] exhibitIDs = null;
            String[][] expectedResult = {};
            String scenario = "exhibitIDs is null, 2D";

            allPassed &= ExhibitManagementTestCases.getExhibitionExhibtNamesTestCase(exhibitManagement, exhibitIDs,
                    expectedResult, scenario);
        }

        /**
         * exhibitIDs contains null, 2D
         */
        {
            ExhibitManagement exhibitManagement = Resources.createTestExhibitManagement();
            exhibitsCreated += 10;
            int[][] exhibitIDs = { null, null, null };
            String[][] expectedResult = {};
            String scenario = "exhibitIDs contains null, 2D";

            allPassed &= ExhibitManagementTestCases.getExhibitionExhibtNamesTestCase(exhibitManagement, exhibitIDs,
                    expectedResult, scenario);
        }

        /**
         * exhibitIDs contains null, 2D
         */
        {
            ExhibitManagement exhibitManagement = Resources.createTestExhibitManagement();
            exhibitsCreated += 10;
            int[][] exhibitIDs = { null, { exhibitsCreated - 9, exhibitsCreated - 8, exhibitsCreated - 7 },
                    { exhibitsCreated - 5, exhibitsCreated - 4, exhibitsCreated - 3 } };
            String[][] expectedResult = { null, { "test", "test", "test" }, { "test", "test", "test" } };
            String scenario = "exhibitIDs contains null, 2D";

            allPassed &= ExhibitManagementTestCases.getExhibitionExhibtNamesTestCase(exhibitManagement, exhibitIDs,
                    expectedResult, scenario);
        }

        /**
         * Exhibit IDs don't exist
         */
        {
            ExhibitManagement exhibitManagement = Resources.createTestExhibitManagement();
            exhibitsCreated += 10;
            int[] exhibitIDs = { 1, 2, 3 };
            String[] expectedResult = { "Exhibit not Found", "Exhibit not Found", "Exhibit not Found" };
            String scenario = "normal use, 1D";

            allPassed &= ExhibitManagementTestCases.getExhibitionExhibtNamesTestCase(exhibitManagement, exhibitIDs,
                    expectedResult, scenario);
        }

        /**
         * Exhibit IDs don't exist
         */
        {
            ExhibitManagement exhibitManagement = Resources.createTestExhibitManagement();
            exhibitsCreated += 10;
            int[][] exhibitIDs = { { 1, 2, 3 }, { 1, 2, 3 }, { 1, 2, 3 } };
            String[][] expectedResult = { { "Exhibit not Found", "Exhibit not Found", "Exhibit not Found" },
                    { "Exhibit not Found", "Exhibit not Found", "Exhibit not Found" },
                    { "Exhibit not Found", "Exhibit not Found", "Exhibit not Found" } };
            String scenario = "normal use, 2D";

            allPassed &= ExhibitManagementTestCases.getExhibitionExhibtNamesTestCase(exhibitManagement, exhibitIDs,
                    expectedResult, scenario);
        }

        System.out.println("\tFeature Passed: " + allPassed);
        System.out.println();
        return allPassed;
    }

    /**
     * Test Suit for findExhibit method
     * 
     * @return all tests passed
     */
    public static boolean testFindExhibit() {
        System.out.println("\tFeature: ExhibitManagement findExhibit");
        boolean allPassed = true;

        /**
         * Normal Use
         */
        {
            Exhibit a0 = Resources.createTestExhibit();
            exhibitsCreated++;
            Exhibit a1 = Resources.createTestExhibit();
            exhibitsCreated++;
            Exhibit a2 = Resources.createTestExhibit();
            exhibitsCreated++;
            Exhibit a3 = Resources.createTestExhibit();
            exhibitsCreated++;
            Exhibit a4 = Resources.createTestExhibit();
            exhibitsCreated++;
            ArrayList<Exhibit> exhibitManagementData = new ArrayList<>();
            exhibitManagementData.add(a0);
            exhibitManagementData.add(a1);
            exhibitManagementData.add(a2);
            exhibitManagementData.add(a3);
            exhibitManagementData.add(a4);

            ExhibitManagement testExhibitManagement;
            try {
                testExhibitManagement = new ExhibitManagement(exhibitManagementData);
            } catch (Exception e) {
                testExhibitManagement = null;
            }
            int exhibitID = exhibitsCreated - 4;
            Exhibit expectedResult = a0;
            String scenario = "normal use";

            allPassed &= ExhibitManagementTestCases.findExhibitTestCase(testExhibitManagement, exhibitID,
                    expectedResult, scenario);
        }

        /**
         * Normal Use, not present
         */
        {
            Exhibit a0 = Resources.createTestExhibit();
            exhibitsCreated++;
            Exhibit a1 = Resources.createTestExhibit();
            exhibitsCreated++;
            Exhibit a2 = Resources.createTestExhibit();
            exhibitsCreated++;
            Exhibit a3 = Resources.createTestExhibit();
            exhibitsCreated++;
            Exhibit a4 = Resources.createTestExhibit();
            exhibitsCreated++;
            ArrayList<Exhibit> exhibitManagementData = new ArrayList<>();
            exhibitManagementData.add(a0);
            exhibitManagementData.add(a1);
            exhibitManagementData.add(a2);
            exhibitManagementData.add(a3);
            exhibitManagementData.add(a4);

            ExhibitManagement testExhibitManagement;
            try {
                testExhibitManagement = new ExhibitManagement(exhibitManagementData);
            } catch (Exception e) {
                testExhibitManagement = null;
            }
            int exhibitID = exhibitsCreated - 6;
            String expectedResult = "No mathcing id in list";
            String scenario = "normal use, exhibit not there";

            allPassed &= ExhibitManagementTestCases.findExhibitTestCase(testExhibitManagement, exhibitID,
                    expectedResult, scenario);
        }

        System.out.println("\tFeature Passed: " + allPassed);
        System.out.println();
        return allPassed;
    }

    /**
     * Test Suit for getExhibitID method
     * 
     * @return all tests passed
     */
    public static boolean testGetExhibitID() {
        System.out.println("\tFeature: ExhibitManagement getExhibitID");
        boolean allPassed = true;

        /**
         * Normal Use
         */
        {

            ExhibitManagement testExhibitManagement = Resources.createTestExhibitManagement();
            exhibitsCreated += 10;
            int exhibitChoice = 0;
            int expectedResult = exhibitsCreated - 9;
            String scenario = "normal use";

            allPassed &= ExhibitManagementTestCases.getExhibitIDTestCase(testExhibitManagement, exhibitChoice,
                    expectedResult, scenario);
        }

        /**
         * Normal Use, not present
         */
        {
            ExhibitManagement testExhibitManagement = Resources.createTestExhibitManagement();
            exhibitsCreated += 10;
            int exhibitChoice = 11;
            int expectedResult = -1;
            String scenario = "normal use, id out of range";

            allPassed &= ExhibitManagementTestCases.getExhibitIDTestCase(testExhibitManagement, exhibitChoice,
                    expectedResult, scenario);
        }

        System.out.println("\tFeature Passed: " + allPassed);
        System.out.println();
        return allPassed;
    }

    /**
     * Test Suit for anyDuplicateArtifacts method
     * 
     * @return all tests passed
     */
    public static boolean testAnyDuplicateArtifacts() {
        System.out.println("\tFeature: ExhibitManagement anyDuplicateArtifacts");
        boolean allPassed = true;

        /**
         * Normal Use, no duplicates
         */
        {

            ExhibitManagement testExhibitManagement = Resources.createTestExhibitManagement();
            exhibitsCreated += 10;
            int[] exhibits = { exhibitsCreated, exhibitsCreated - 1, exhibitsCreated - 2 };
            boolean expectedResult = false;
            String scenario = "normal use, no duplicates";

            allPassed &= ExhibitManagementTestCases.anyDuplicateArtifactsTestCase(testExhibitManagement, exhibits,
                    expectedResult, scenario);
        }

        /**
         * Normal Use, duplicates
         */
        {

            ExhibitManagement testExhibitManagement = Resources.createTestExhibitManagement(true);
            exhibitsCreated += 10;
            int[] exhibits = { exhibitsCreated, exhibitsCreated - 1, exhibitsCreated - 2 };
            boolean expectedResult = true;
            String scenario = "normal use, duplicates";

            allPassed &= ExhibitManagementTestCases.anyDuplicateArtifactsTestCase(testExhibitManagement, exhibits,
                    expectedResult, scenario);
        }

        /**
         * Normal Use, no duplicates
         */
        {

            ExhibitManagement testExhibitManagement = Resources.createTestExhibitManagement();
            exhibitsCreated += 10;
            int[] exhibits = { exhibitsCreated, exhibitsCreated - 1, exhibitsCreated - 2 };
            int exhibitID = exhibitsCreated - 3;
            int exhibitLoc = 2;
            boolean expectedResult = false;
            String scenario = "normal use, no duplicates";

            allPassed &= ExhibitManagementTestCases.anyDuplicateArtifactsTestCase(testExhibitManagement, exhibits,
                    exhibitID, exhibitLoc,
                    expectedResult, scenario);
        }

        /**
         * Normal Use, duplicates
         */
        {

            ExhibitManagement testExhibitManagement = Resources.createTestExhibitManagement(true);
            exhibitsCreated += 10;
            int[] exhibits = { exhibitsCreated, exhibitsCreated - 1, exhibitsCreated - 2 };
            int exhibitID = exhibitsCreated - 3;
            int exhibitLoc = 2;
            boolean expectedResult = true;
            String scenario = "normal use, duplicates";

            allPassed &= ExhibitManagementTestCases.anyDuplicateArtifactsTestCase(testExhibitManagement, exhibits,
                    exhibitID, exhibitLoc,
                    expectedResult, scenario);
        }

        System.out.println("\tFeature Passed: " + allPassed);
        System.out.println();
        return allPassed;
    }

}
