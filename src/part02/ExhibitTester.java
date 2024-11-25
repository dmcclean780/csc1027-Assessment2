package part02;

import java.util.ArrayList;

import part01.Exhibit;

public class ExhibitTester {
    public static void main(String[] args) {
        boolean allPassed = true;
        System.out.println("Class in Test: Exhibit");
        System.out.println();
        allPassed &= testConstructor();
        allPassed &= testGetID();
        allPassed &= testGetName();
        allPassed &= testSetName();
        allPassed &= testGetArtifactsID();
        allPassed &= testSetArtifactsID();
        allPassed &= testGetRoute();
        allPassed &= testSetRoute();
        allPassed &= testToString();
        allPassed &= testRemoveArtifact();
        allPassed &= testRemoveSign();
        allPassed &= testFindArtifactIndex();
        allPassed &= testGetRouteArray();
        System.out.println("All Features Passed: " + allPassed);
        System.out.println();
    }

    /**
     * Test Suit for the constructor method
     * 
     * @return all tests passed
     */
    public static boolean testConstructor() {
        System.out.println("\tFeature: Exhibit Constructor");
        boolean allPassed = true;

        /**
         * normal exhibit
         */
        {
            String testName = "test";
            ArrayList<Integer> testArtifacts = new ArrayList<>();
            testArtifacts.add(0);
            testArtifacts.add(1);
            testArtifacts.add(2);
            testArtifacts.add(3);
            ArrayList<String> testRoute = new ArrayList<>();
            testRoute.add("a");
            testRoute.add("b");
            testRoute.add("c");
            testRoute.add("d");
            String expectedResult = "no exception";
            String scenario = "valid Parameters";

            allPassed &= ExhibitTestCases.constructorTestCase(testName, testArtifacts, testRoute, expectedResult, scenario);
        }

        /**
         * Shorter route than artifacts
         */
        {
            String testName = "test";
            ArrayList<Integer> testArtifacts = new ArrayList<>();
            testArtifacts.add(0);
            testArtifacts.add(1);
            testArtifacts.add(2);
            testArtifacts.add(3);
            ArrayList<String> testRoute = new ArrayList<>();
            testRoute.add("a");
            testRoute.add("b");
            testRoute.add("c");
            String expectedResult = "exception thrown";
            String scenario = "more artifacts than route";

            allPassed &= ExhibitTestCases.constructorTestCase(testName, testArtifacts, testRoute, expectedResult, scenario);
        }

        /**
         * less artifacts than route
         */
        {
            String testName = "test";
            ArrayList<Integer> testArtifacts = new ArrayList<>();
            testArtifacts.add(0);
            testArtifacts.add(1);
            testArtifacts.add(2);
            ArrayList<String> testRoute = new ArrayList<>();
            testRoute.add("a");
            testRoute.add("b");
            testRoute.add("c");
            testRoute.add("d");
            String expectedResult = "exception thrown";
            String scenario = "more route than artifacts";

            allPassed &= ExhibitTestCases.constructorTestCase(testName, testArtifacts, testRoute, expectedResult, scenario);
        }

        /**
         * empty artifacts
         */
        {
            String testName = "test";
            ArrayList<Integer> testArtifacts = new ArrayList<>();
            ArrayList<String> testRoute = new ArrayList<>();
            testRoute.add("a");
            testRoute.add("b");
            testRoute.add("c");
            testRoute.add("d");
            String expectedResult = "exception thrown";
            String scenario = "empty artifacts";

            allPassed &= ExhibitTestCases.constructorTestCase(testName, testArtifacts, testRoute, expectedResult, scenario);
        }

        /**
         * empty route
         */
        {
            String testName = "test";
            ArrayList<Integer> testArtifacts = new ArrayList<>();
            testArtifacts.add(0);
            testArtifacts.add(1);
            testArtifacts.add(2);
            testArtifacts.add(3);
            ArrayList<String> testRoute = new ArrayList<>();
            String expectedResult = "exception thrown";
            String scenario = "empty route";

            allPassed &= ExhibitTestCases.constructorTestCase(testName, testArtifacts, testRoute, expectedResult, scenario);
        }

        /**
         * both empty
         */
        {
            String testName = "test";
            ArrayList<Integer> testArtifacts = new ArrayList<>();
            ArrayList<String> testRoute = new ArrayList<>();
            String expectedResult = "no exception";
            String scenario = "both empty";

            allPassed &= ExhibitTestCases.constructorTestCase(testName, testArtifacts, testRoute, expectedResult, scenario);
        }

        /**
         * null artifacts
         */
        {
            String testName = "test";
            ArrayList<Integer> testArtifacts = null;
            ArrayList<String> testRoute = new ArrayList<>();
            testRoute.add("a");
            testRoute.add("b");
            testRoute.add("c");
            testRoute.add("d");
            String expectedResult = "exception thrown";
            String scenario = "null artifacts";

            allPassed &= ExhibitTestCases.constructorTestCase(testName, testArtifacts, testRoute, expectedResult, scenario);
        }

        /**
         * null route
         */
        {
            String testName = "test";
            ArrayList<Integer> testArtifacts = new ArrayList<>();
            testArtifacts.add(0);
            testArtifacts.add(1);
            testArtifacts.add(2);
            testArtifacts.add(3);
            ArrayList<String> testRoute = null;
            String expectedResult = "exception thrown";
            String scenario = "null route";

            allPassed &= ExhibitTestCases.constructorTestCase(testName, testArtifacts, testRoute, expectedResult, scenario);
        }

        /**
         * both null
         */
        {
            String testName = "test";
            ArrayList<Integer> testArtifacts = null;
            ArrayList<String> testRoute = null;
            String expectedResult = "exception thrown";
            String scenario = "both null";

            allPassed &= ExhibitTestCases.constructorTestCase(testName, testArtifacts, testRoute, expectedResult, scenario);
        }

        System.out.println("\tFeature Passed: " + allPassed);
        System.out.println();
        return allPassed;
    }

    /**
     * Test Suit for getID method
     * 
     * @return all test passed
     */
    public static boolean testGetID() {
        System.out.println("\tFeature: Exhibit getID");
        boolean allPassed = true;

        /**
         * Normal getID()
         */
        {
            Exhibit testExhibit = Resources.createTestExhibit();
            int expectedResult = 2;
            String scenario = "normal Exhibit";

            allPassed &= ExhibitTestCases.getIDTestCase(testExhibit, expectedResult, scenario);
        }

        /**
         * Check ID increments
         */
        {

            Exhibit testExhibit = Resources.createTestExhibit();
            Exhibit testExhibit2 = Resources.createTestExhibit();
            Exhibit testExhibit3 = Resources.createTestExhibit();
            int expectedResult = 3; // starts at 1 as an artifact was created by the previous test case
            String scenario = "multiple Exhibits iterate the ID";

            allPassed &= ExhibitTestCases.getIDTestCase(testExhibit, expectedResult, scenario);
            expectedResult++;
            allPassed &= ExhibitTestCases.getIDTestCase(testExhibit2, expectedResult, scenario);
            expectedResult++;
            allPassed &= ExhibitTestCases.getIDTestCase(testExhibit3, expectedResult, scenario);
        }

        System.out.println("\tFeature Passed: " + allPassed);
        System.out.println();
        return allPassed;
    }

    /**
     * Test Suit for getName method
     * 
     * @return all test passed
     */
    public static boolean testGetName() {
        System.out.println("\tFeature: Exhibit getName");
        boolean allPassed = true;

        /**
         * Normal getID()
         */
        {
            Exhibit testExhibit = Resources.createTestExhibit();
            String expectedResult = "test";
            String scenario = "normal Exhibit";

            allPassed &= ExhibitTestCases.getNameTestCase(testExhibit, expectedResult, scenario);
        }

        System.out.println("\tFeature Passed: " + allPassed);
        System.out.println();
        return allPassed;
    }

    /**
     * Test Suit for setName method
     * 
     * @return all test passed
     */
    public static boolean testSetName() {
        System.out.println("\tFeature: Artifact setName()");
        boolean allPassed = true;

        /**
         * Normal setName()
         */
        {
            Exhibit testExhibit = Resources.createTestExhibit();
            String newName = "set name test";
            String expectedResult = "set name test";
            String scenario = "normal exhibit";

            allPassed &= ExhibitTestCases.setNameTestCase(testExhibit, newName, expectedResult, scenario);
        }

        /**
         * New Name is null
         */
        {
            Exhibit testExhibit = Resources.createTestExhibit();
            String newName = null;
            String expectedResult = null;
            String scenario = "set name to null";

            allPassed &= ExhibitTestCases.setNameTestCase(testExhibit, newName, expectedResult, scenario);
        }

        System.out.println("\tFeature Passed: " + allPassed);
        System.out.println();
        return allPassed;
    }

    /**
     * Test Suit for getArtifactsID method
     * 
     * @return all tests passed
     */
    public static boolean testGetArtifactsID() {
        System.out.println("\tFeature: Exhibit getArtifactsID");
        boolean allPassed = true;

        /**
         * Test the normal use of the method
         */
        {
            Exhibit testExhibit = Resources.createTestExhibit();
            ArrayList<Integer> expectedResult = new ArrayList<>();
            expectedResult.add(0);
            expectedResult.add(1);
            expectedResult.add(2);
            expectedResult.add(3);
            String scenario = "normal exhibit";
            allPassed &= ExhibitTestCases.getArtifactsIDTestCase(testExhibit, expectedResult, scenario);
        }

        /**
         * Test when Exhibit has no artifacts
         */
        {
            Exhibit testExhibit = null;
            String testName = "test";
            ArrayList<Integer> testArtifacts = new ArrayList<>();
            ArrayList<String> testRoute = new ArrayList<>();
            try {
                testExhibit = new Exhibit(testName, testArtifacts, testRoute);
            } catch (Exception e) {

            }
            ArrayList<Integer> expectedResult = new ArrayList<>();
            String scenario = "no artifacts";
            allPassed &= ExhibitTestCases.getArtifactsIDTestCase(testExhibit, expectedResult, scenario);
        }

        System.out.println("\tFeature Passed: " + allPassed);
        System.out.println();
        return allPassed;
    }

    /**
     * Test Suit for setArtifactsID method
     * 
     * @return all tests pass
     */
    public static boolean testSetArtifactsID() {
        System.out.println("\tFeature: Exhibit setArtifactsID");
        boolean allPassed = true;

        /**
         * Normal use
         */
        {
            Exhibit testExhibit = Resources.createTestExhibit();

            ArrayList<Integer> newArtifacts = new ArrayList<>();
            newArtifacts.add(4);
            newArtifacts.add(5);
            newArtifacts.add(6);
            newArtifacts.add(7);

            ArrayList<Integer> expectedResult = new ArrayList<>();
            expectedResult.add(4);
            expectedResult.add(5);
            expectedResult.add(6);
            expectedResult.add(7);

            String scenario = "normal valid use";
            allPassed &= ExhibitTestCases.setArtifactsIDTestCase(testExhibit, newArtifacts, expectedResult, scenario);
        }

        /**
         * Too Few Artifacts
         */
        {
            Exhibit testExhibit = Resources.createTestExhibit();

            ArrayList<Integer> newArtifacts = new ArrayList<>();
            newArtifacts.add(4);
            newArtifacts.add(5);
            newArtifacts.add(6);

            String expectedResult = "exception thrown";

            String scenario = "invalid use, too few artifacts";
            allPassed &= ExhibitTestCases.setArtifactsIDTestCase(testExhibit, newArtifacts, expectedResult, scenario);
        }

        /**
         * Too many artifacts
         */
        {
            Exhibit testExhibit = Resources.createTestExhibit();

            ArrayList<Integer> newArtifacts = new ArrayList<>();
            newArtifacts.add(4);
            newArtifacts.add(5);
            newArtifacts.add(6);
            newArtifacts.add(7);
            newArtifacts.add(8);

            String expectedResult = "exception thrown";

            String scenario = "invalid use, too many artifacts";
            allPassed &= ExhibitTestCases.setArtifactsIDTestCase(testExhibit, newArtifacts, expectedResult, scenario);
        }

        System.out.println("\tFeature Passed: " + allPassed);
        System.out.println();
        return allPassed;
    }

    /**
     * Test Suit for getArtifactsID method
     * 
     * @return all tests passed
     */
    public static boolean testGetRoute() {
        System.out.println("\tFeature: Exhibit getRoute");
        boolean allPassed = true;

        /**
         * Normal Use
         */
        {
            Exhibit testExhibit = Resources.createTestExhibit();
            ArrayList<String> expectedResult = new ArrayList<>();
            expectedResult.add("a");
            expectedResult.add("b");
            expectedResult.add("c");
            expectedResult.add("d");
            String scenario = "normal exhibit";
            allPassed &= ExhibitTestCases.getRouteTestCase(testExhibit, expectedResult, scenario);
        }

        /**
         * Route is empty
         */
        {
            Exhibit testExhibit = null;
            String testName = "test";
            ArrayList<Integer> testArtifacts = new ArrayList<>();
            ArrayList<String> testRoute = new ArrayList<>();
            try {
                testExhibit = new Exhibit(testName, testArtifacts, testRoute);
            } catch (Exception e) {

            }
            ArrayList<String> expectedResult = new ArrayList<>();
            String scenario = "no route";
            allPassed &= ExhibitTestCases.getRouteTestCase(testExhibit, expectedResult, scenario);
        }

        System.out.println("\tFeature Passed: " + allPassed);
        System.out.println();
        return allPassed;
    }

    /**
     * Test Suit for setArtifactsID method
     * 
     * @return all tests pass
     */
    public static boolean testSetRoute() {
        System.out.println("\tFeature: Exhibit setArtifactsID");
        boolean allPassed = true;

        /**
         * Normal Use
         */
        {
            Exhibit testExhibit = Resources.createTestExhibit();

            ArrayList<String> newRoute = new ArrayList<>();
            newRoute.add("e");
            newRoute.add("f");
            newRoute.add("g");
            newRoute.add("h");

            ArrayList<String> expectedResult = new ArrayList<>();
            expectedResult.add("e");
            expectedResult.add("f");
            expectedResult.add("g");
            expectedResult.add("h");

            String scenario = "normal valid use";
            allPassed &= ExhibitTestCases.setRouteTestCase(testExhibit, newRoute, expectedResult, scenario);
        }

        /**
         * Route too short
         */
        {
            Exhibit testExhibit = Resources.createTestExhibit();

            ArrayList<String> newRoute = new ArrayList<>();
            newRoute.add("e");
            newRoute.add("f");
            newRoute.add("g");

            String expectedResult = "exception thrown";

            String scenario = "invalid use, too short route";
            allPassed &= ExhibitTestCases.setRouteTestCase(testExhibit, newRoute, expectedResult, scenario);
        }

        /**
         * Route too long
         */
        {
            Exhibit testExhibit = Resources.createTestExhibit();

            ArrayList<String> newRoute = new ArrayList<>();
            newRoute.add("e");
            newRoute.add("f");
            newRoute.add("g");
            newRoute.add("h");
            newRoute.add("i");

            String expectedResult = "exception thrown";

            String scenario = "invalid use, too long route";
            allPassed &= ExhibitTestCases.setRouteTestCase(testExhibit, newRoute, expectedResult, scenario);
        }

        System.out.println("\tFeature Passed: " + allPassed);
        System.out.println();
        return allPassed;
    }

    /**
     * Test Suit for toString method
     * 
     * @return tests all passed
     */
    public static boolean testToString() {
        System.out.println("\tFeature: Exhibit toString");
        boolean allPassed = true;

        /**
         * Normal use
         */
        {
            Exhibit testExhibit = Resources.createTestExhibit();
            String expectedResult = "ID: "+testExhibit.getID()+"\tName: test";
            String scenario = "normal exhibit toString";
            allPassed &= ExhibitTestCases.toStringTestCase(testExhibit, expectedResult, scenario);
        }

        System.out.println("\tFeature Passed: " + allPassed);
        System.out.println();
        return allPassed;
    }

    /**
     * Test removeArtifact method
     * 
     * @return all tests passed
     */
    public static boolean testRemoveArtifact() {
        System.out.println("\tFeature: Exhibit removeArtifact");
        boolean allPassed = true;

        /**
         * Normal Use
         */
        {
            Exhibit testExhibit = Resources.createTestExhibit();
            int artifactToRemoveIndex = 2;
            ArrayList<Integer> expectedResult = new ArrayList<>();
            expectedResult.add(0);
            expectedResult.add(1);
            expectedResult.add(3);
            String scenario = "Normal operation";
            allPassed &= ExhibitTestCases.removeArtifactTestCase(testExhibit, artifactToRemoveIndex, expectedResult, scenario);

        }

        /**
         * Index out of range
         */
        {
            Exhibit testExhibit = Resources.createTestExhibit();
            int artifactToRemoveIndex = 4;
            ArrayList<Integer> expectedResult = new ArrayList<>();
            expectedResult.add(0);
            expectedResult.add(1);
            expectedResult.add(2);
            expectedResult.add(3);
            String scenario = "Index to remove exceeds range - nothing done";
            allPassed &= ExhibitTestCases.removeArtifactTestCase(testExhibit, artifactToRemoveIndex, expectedResult, scenario);

        }

        /**
         * Index is neagtive
         */
        {
            Exhibit testExhibit = Resources.createTestExhibit();
            int artifactToRemoveIndex = -1;
            ArrayList<Integer> expectedResult = new ArrayList<>();
            expectedResult.add(0);
            expectedResult.add(1);
            expectedResult.add(2);
            expectedResult.add(3);
            String scenario = "Index to remove below range - nothing done";
            allPassed &= ExhibitTestCases.removeArtifactTestCase(testExhibit, artifactToRemoveIndex, expectedResult, scenario);

        }

        System.out.println("\tFeature Passed: " + allPassed);
        System.out.println();
        return allPassed;
    }

    /**
     * Test removeArtifact method
     * 
     * @return all tests passed
     */
    public static boolean testRemoveSign() {
        System.out.println("\tFeature: Exhibit removeSign");
        boolean allPassed = true;

        /**
         * Normal Use
         */
        {
            Exhibit testExhibit = Resources.createTestExhibit();
            int artifactToRemoveIndex = 2;
            ArrayList<String> expectedResult = new ArrayList<>();
            expectedResult.add("a");
            expectedResult.add("b");
            expectedResult.add("d");
            String scenario = "Normal operation";
            allPassed &= ExhibitTestCases.removeSignTestCase(testExhibit, artifactToRemoveIndex, expectedResult, scenario);

        }

        /**
         * Index out of range
         */
        {
            Exhibit testExhibit = Resources.createTestExhibit();
            int artifactToRemoveIndex = 4;
            ArrayList<String> expectedResult = new ArrayList<>();
            expectedResult.add("a");
            expectedResult.add("b");
            expectedResult.add("c");
            expectedResult.add("d");
            String scenario = "Index to remove exceeds range - nothing done";
            allPassed &= ExhibitTestCases.removeSignTestCase(testExhibit, artifactToRemoveIndex, expectedResult, scenario);

        }

        /**
         * Index is neagtive
         */
        {
            Exhibit testExhibit = Resources.createTestExhibit();
            int artifactToRemoveIndex = -1;
            ArrayList<String> expectedResult = new ArrayList<>();
            expectedResult.add("a");
            expectedResult.add("b");
            expectedResult.add("c");
            expectedResult.add("d");
            String scenario = "Index to remove below range - nothing done";
            allPassed &= ExhibitTestCases.removeSignTestCase(testExhibit, artifactToRemoveIndex, expectedResult, scenario);

        }

        System.out.println("\tFeature Passed: " + allPassed);
        System.out.println();
        return allPassed;
    }

    /**
     * Test Suit for findArtifactIndex method
     * 
     * @return all tests passed
     */
    public static boolean testFindArtifactIndex() {
        System.out.println("\tFeature: Exhibit findArtifactIndex");
        boolean allPassed = true;

        /**
         * Normal use, Artifact is there
         */
        {
            Exhibit testExhibit = Resources.createTestExhibit();
            int testArtifactID = 0;
            int expectedResult = 0;
            String scenario = "normal use";

            allPassed &= ExhibitTestCases.findArtifactIndexTestCase(testExhibit, testArtifactID, expectedResult, scenario);

        }

        /**
         * artifact is not there
         */
        {
            Exhibit testExhibit = Resources.createTestExhibit();
            int testArtifactID = 5;
            int expectedResult = -1;
            String scenario = "normal use";

            allPassed &= ExhibitTestCases.findArtifactIndexTestCase(testExhibit, testArtifactID, expectedResult, scenario);

        }

        System.out.println("\tFeature Passed: " + allPassed);
        System.out.println();
        return allPassed;
    }

    /**
     * Test Suit for getRouteArray method
     * 
     * @return all tests passed
     */
    public static boolean testGetRouteArray() {
        System.out.println("\tFeature: Exhibit getRouteArray");
        boolean allPassed = true;

        /**
         * Normal use
         */
        {
            Exhibit testExhibit = Resources.createTestExhibit();
            String[] expectedResult = { "a", "b", "c", "d" };
            String scenario = "normal use";

            allPassed &= ExhibitTestCases.getRouteArrayTestCase(testExhibit, expectedResult, scenario);
        }

        /**
         * Route is empty
         */
        {
            Exhibit testExhibit = null;
            String testName = "test";
            ArrayList<Integer> testArtifacts = new ArrayList<>();
            ArrayList<String> testRoute = new ArrayList<>();
            try {
                testExhibit = new Exhibit(testName, testArtifacts, testRoute);
            } catch (Exception e) {

            }
            String[] expectedResult = { };
            String scenario = "normal use";

            allPassed &= ExhibitTestCases.getRouteArrayTestCase(testExhibit, expectedResult, scenario);
        }

        System.out.println("\tFeature Passed: " + allPassed);
        System.out.println();
        return allPassed;
    }

    
}
