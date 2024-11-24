package part02;

import java.util.ArrayList;

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
        System.out.println("All Features Passed: " + allPassed);
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
         * Test for Constructer ArrayList Property with getExhibits that causes an exception
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
            artifactsCreated++;
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
}
