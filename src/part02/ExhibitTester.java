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

            allPassed &= constructorTestCase(testName, testArtifacts, testRoute, expectedResult, scenario);
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

            allPassed &= constructorTestCase(testName, testArtifacts, testRoute, expectedResult, scenario);
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

            allPassed &= constructorTestCase(testName, testArtifacts, testRoute, expectedResult, scenario);
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

            allPassed &= constructorTestCase(testName, testArtifacts, testRoute, expectedResult, scenario);
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

            allPassed &= constructorTestCase(testName, testArtifacts, testRoute, expectedResult, scenario);
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

            allPassed &= constructorTestCase(testName, testArtifacts, testRoute, expectedResult, scenario);
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

            allPassed &= constructorTestCase(testName, testArtifacts, testRoute, expectedResult, scenario);
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

            allPassed &= constructorTestCase(testName, testArtifacts, testRoute, expectedResult, scenario);
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

            allPassed &= constructorTestCase(testName, testArtifacts, testRoute, expectedResult, scenario);
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

            allPassed &= getIDTestCase(testExhibit, expectedResult, scenario);
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

            allPassed &= getIDTestCase(testExhibit, expectedResult, scenario);
            expectedResult++;
            allPassed &= getIDTestCase(testExhibit2, expectedResult, scenario);
            expectedResult++;
            allPassed &= getIDTestCase(testExhibit3, expectedResult, scenario);
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

            allPassed &= getNameTestCase(testExhibit, expectedResult, scenario);
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

            allPassed &= setNameTestCase(testExhibit, newName, expectedResult, scenario);
        }

        /**
         * New Name is null
         */
        {
            Exhibit testExhibit = Resources.createTestExhibit();
            String newName = null;
            String expectedResult = null;
            String scenario = "set name to null";

            allPassed &= setNameTestCase(testExhibit, newName, expectedResult, scenario);
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
            allPassed &= getArtifactsIDTestCase(testExhibit, expectedResult, scenario);
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
            allPassed &= getArtifactsIDTestCase(testExhibit, expectedResult, scenario);
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
            allPassed &= setArtifactsIDTestCase(testExhibit, newArtifacts, expectedResult, scenario);
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
            allPassed &= setArtifactsIDTestCase(testExhibit, newArtifacts, expectedResult, scenario);
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
            allPassed &= setArtifactsIDTestCase(testExhibit, newArtifacts, expectedResult, scenario);
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
            allPassed &= getRouteTestCase(testExhibit, expectedResult, scenario);
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
            allPassed &= getRouteTestCase(testExhibit, expectedResult, scenario);
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
            allPassed &= setRouteTestCase(testExhibit, newRoute, expectedResult, scenario);
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
            allPassed &= setRouteTestCase(testExhibit, newRoute, expectedResult, scenario);
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
            allPassed &= setRouteTestCase(testExhibit, newRoute, expectedResult, scenario);
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
            allPassed &= toStringTestCase(testExhibit, expectedResult, scenario);
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
            allPassed &= removeArtifactTestCase(testExhibit, artifactToRemoveIndex, expectedResult, scenario);

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
            allPassed &= removeArtifactTestCase(testExhibit, artifactToRemoveIndex, expectedResult, scenario);

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
            allPassed &= removeArtifactTestCase(testExhibit, artifactToRemoveIndex, expectedResult, scenario);

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
            allPassed &= removeSignTestCase(testExhibit, artifactToRemoveIndex, expectedResult, scenario);

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
            allPassed &= removeSignTestCase(testExhibit, artifactToRemoveIndex, expectedResult, scenario);

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
            allPassed &= removeSignTestCase(testExhibit, artifactToRemoveIndex, expectedResult, scenario);

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

            allPassed &= findArtifactIndexTestCase(testExhibit, testArtifactID, expectedResult, scenario);

        }

        /**
         * artifact is not there
         */
        {
            Exhibit testExhibit = Resources.createTestExhibit();
            int testArtifactID = 5;
            int expectedResult = -1;
            String scenario = "normal use";

            allPassed &= findArtifactIndexTestCase(testExhibit, testArtifactID, expectedResult, scenario);

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

            allPassed &= getRouteArrayTestCase(testExhibit, expectedResult, scenario);
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

            allPassed &= getRouteArrayTestCase(testExhibit, expectedResult, scenario);
        }

        System.out.println("\tFeature Passed: " + allPassed);
        System.out.println();
        return allPassed;
    }

    /**
     * Test for the constructor method
     * 
     * @param name
     * @param artifacts
     * @param route
     * @param expectedResult
     * @param scenario
     * @return passed
     */
    public static boolean constructorTestCase(String name, ArrayList<Integer> artifacts, ArrayList<String> route,
            String expectedResult, String scenario) {
        String result;
        try {
            new Exhibit(name, artifacts, route);
            result = "no exception";
        } catch (Exception e) {
            result = "exception thrown";
        }
        boolean thisPassed = result.equals(expectedResult);
        if (!thisPassed) {
            System.out.println();
            System.out.println("Scenario:" + scenario);
            System.out.println("Given: exhibit name is " + name);
            System.out.println("AND: artifacts are " + artifacts);
            System.out.println("AND: route is " + route);
            System.out.println("When: new Artifact");
            System.out.println("Then: output is:\n" + expectedResult);
            System.out.println("Passed: " + thisPassed);
            System.out.println("Expected Value:\n" + expectedResult);
            System.out.println("Given Value:\n" + result);
            System.out.println();
        }
        return thisPassed;
    }

    /**
     * Test for getID method
     * 
     * @param testExhibit
     * @param expectedResult
     * @param scenario
     * @return passed
     */
    public static boolean getIDTestCase(Exhibit testExhibit, int expectedResult, String scenario) {
        int result = testExhibit.getID();
        boolean thisPassed = result == expectedResult;
        if (!thisPassed) {
            System.out.println();
            System.out.println("Scenario:" + scenario);
            System.out.println("Given: testExhibit " + testExhibit);
            System.out.println("When: testExhibit.getID");
            System.out.println("Then: output is:\n" + expectedResult);
            System.out.println("Passed: " + thisPassed);
            System.out.println("Expected Value:\n" + expectedResult);
            System.out.println("Given Value:\n" + result);
            System.out.println();
        }
        return thisPassed;
    }

    /**
     * Test for getName method
     * 
     * @param testExhibit
     * @param expectedResult
     * @param scenario
     * @return passed
     */
    public static boolean getNameTestCase(Exhibit testExhibit, String expectedResult, String scenario) {
        String result = testExhibit.getName();
        boolean thisPassed = result == null ? expectedResult == null : result.equals(expectedResult);
        if (!thisPassed) {
            System.out.println();
            System.out.println("Scenario:" + scenario);
            System.out.println("Given: testExhibit " + testExhibit);
            System.out.println("When: testExhibit.getName");
            System.out.println("Then: output is:\n" + expectedResult);
            System.out.println("Passed: " + thisPassed);
            System.out.println("Expected Value:\n" + expectedResult);
            System.out.println("Given Value:\n" + result);
            System.out.println();
        }
        return thisPassed;
    }

    /**
     * Test for setName method
     * 
     * @param testExhibit
     * @param expectedResult
     * @param scenario
     * @return passed
     */
    public static boolean setNameTestCase(Exhibit testExhibit, String newName, String expectedResult, String scenario) {
        testExhibit.setName(newName);
        String result = testExhibit.getName();
        boolean thisPassed = result == null ? expectedResult == null : result.equals(expectedResult);
        if (!thisPassed) {
            System.out.println();
            System.out.println("Scenario:" + scenario);
            System.out.println("Given: testExhibit " + testExhibit);
            System.out.println("When: testExhibit.setName callled with " + newName);
            System.out.println("Then: output of getName is:\n" + expectedResult);
            System.out.println("Passed: " + thisPassed);
            System.out.println("Expected Value:\n" + expectedResult);
            System.out.println("Given Value:\n" + result);
            System.out.println();
        }
        return thisPassed;
    }

    /**
     * Test for getArtifactsID method
     * 
     * @param testExhibit
     * @param expectedResult
     * @param scenario
     * @return passed
     */
    public static boolean getArtifactsIDTestCase(Exhibit testExhibit, ArrayList<Integer> expectedResult,
            String scenario) {
        ArrayList<Integer> result = testExhibit.getArtifactsID();
        boolean thisPassed = result.equals(expectedResult);
        if (!thisPassed) {
            System.out.println();
            System.out.println("Scenario:" + scenario);
            System.out.println("Given: testExhibit " + testExhibit);
            System.out.println("When: testExhibit.getArtifactsID");
            System.out.println("Then: output is:\n" + expectedResult);
            System.out.println("Passed: " + thisPassed);
            System.out.println("Expected Value:\n" + expectedResult);
            System.out.println("Given Value:\n" + result);
            System.out.println();
        }
        return thisPassed;
    }

    /**
     * Test for setArtifacstID with a valid list of artifacts
     * 
     * @param testExhibit
     * @param newArtifactsID
     * @param expectedResult
     * @param scenario
     * @return passed
     */
    public static boolean setArtifactsIDTestCase(Exhibit testExhibit, ArrayList<Integer> newArtifactsID,
            ArrayList<Integer> expectedResult, String scenario) {
        boolean thisPassed;
        String result;
        try {
            testExhibit.setArtifactsID(newArtifactsID);
            ArrayList<Integer> resultList = testExhibit.getArtifactsID();
            result = resultList.toString();
            thisPassed = resultList.equals(expectedResult);
        } catch (Exception e) {
            result = "exception thrown";
            thisPassed = false;
        }

        if (!thisPassed) {
            System.out.println();
            System.out.println("Scenario:" + scenario);
            System.out.println("Given: testExhibit " + testExhibit);
            System.out.println("When: testExhibit.setArtifactsID called with " + newArtifactsID);
            System.out.println("Then: output of getArtifactsID is:\n" + expectedResult);
            System.out.println("Passed: " + thisPassed);
            System.out.println("Expected Value:\n" + expectedResult);
            System.out.println("Given Value:\n" + result);
            System.out.println();
        }
        return thisPassed;
    }

    /**
     * Test for setArtifactsID with an invalid list of artifacts
     * 
     * @param testExhibit
     * @param newArtifactsID
     * @param expectedResult
     * @param scenario
     * @return passed
     */
    public static boolean setArtifactsIDTestCase(Exhibit testExhibit, ArrayList<Integer> newArtifactsID,
            String expectedResult, String scenario) {
        boolean thisPassed;
        String result;
        try {
            testExhibit.setArtifactsID(newArtifactsID);
            ArrayList<Integer> resultList = testExhibit.getArtifactsID();
            result = resultList.toString();
            thisPassed = false;
        } catch (Exception e) {
            result = "exception thrown";
            thisPassed = result.equals(expectedResult);
        }

        if (!thisPassed) {
            System.out.println();
            System.out.println("Scenario:" + scenario);
            System.out.println("Given: testExhibit " + testExhibit);
            System.out.println("When: testExhibit.setArtifactsID called with " + newArtifactsID);
            System.out.println("Then: output of getArtifactsID is:\n" + expectedResult);
            System.out.println("Passed: " + thisPassed);
            System.out.println("Expected Value:\n" + expectedResult);
            System.out.println("Given Value:\n" + result);
            System.out.println();
        }
        return thisPassed;
    }

    /**
     * Test for getArtifactsID method
     * 
     * @param testExhibit
     * @param expectedResult
     * @param scenario
     * @return passed
     */
    public static boolean getRouteTestCase(Exhibit testExhibit, ArrayList<String> expectedResult, String scenario) {
        ArrayList<String> result = testExhibit.getRoute();
        boolean thisPassed = result.equals(expectedResult);
        if (!thisPassed) {
            System.out.println();
            System.out.println("Scenario:" + scenario);
            System.out.println("Given: testExhibit " + testExhibit);
            System.out.println("When: testExhibit.getRoute");
            System.out.println("Then: output is:\n" + expectedResult);
            System.out.println("Passed: " + thisPassed);
            System.out.println("Expected Value:\n" + expectedResult);
            System.out.println("Given Value:\n" + result);
            System.out.println();
        }
        return thisPassed;
    }

    /**
     * Test for setArtifacstID with a valid list of artifacts
     * 
     * @param testExhibit
     * @param newArtifactsID
     * @param expectedResult
     * @param scenario
     * @return passed
     */
    public static boolean setRouteTestCase(Exhibit testExhibit, ArrayList<String> newRoute,
            ArrayList<String> expectedResult, String scenario) {
        boolean thisPassed;
        String result;
        try {
            testExhibit.setRoute(newRoute);
            ArrayList<String> resultList = testExhibit.getRoute();
            result = resultList.toString();
            thisPassed = resultList.equals(expectedResult);
        } catch (Exception e) {
            result = "exception thrown";
            thisPassed = false;
        }

        if (!thisPassed) {
            System.err.println();
            System.err.println("Scenario:" + scenario);
            System.err.println("Given: testExhibit " + testExhibit);
            System.err.println("When: testExhibit.setRoute called with " + newRoute);
            System.err.println("Then: output of getRoute is:\n" + expectedResult);
            System.err.println("Passed: " + thisPassed);
            System.err.println("Expected Value:\n" + expectedResult);
            System.err.println("Given Value:\n" + result);
            System.err.println();
        }
        return thisPassed;
    }

    /**
     * Test for setRoute with an invalid route
     * 
     * @param testExhibit
     * @param newArtifactsID
     * @param expectedResult
     * @param scenario
     * @return passed
     */
    public static boolean setRouteTestCase(Exhibit testExhibit, ArrayList<String> newRoute, String expectedResult,
            String scenario) {
        boolean thisPassed;
        String result;
        try {
            testExhibit.setRoute(newRoute);
            ArrayList<Integer> resultList = testExhibit.getArtifactsID();
            result = resultList.toString();
            thisPassed = false;
        } catch (Exception e) {
            result = "exception thrown";
            thisPassed = result.equals(expectedResult);
        }

        if (!thisPassed) {
            System.err.println();
            System.err.println("Scenario:" + scenario);
            System.err.println("Given: testExhibit " + testExhibit);
            System.err.println("When: testExhibit.setRoute called with " + newRoute);
            System.err.println("Then: output of getRoute is:\n" + expectedResult);
            System.err.println("Passed: " + thisPassed);
            System.err.println("Expected Value:\n" + expectedResult);
            System.err.println("Given Value:\n" + result);
            System.err.println();
        }
        return thisPassed;
    }

    /**
     * Test for toString method
     * 
     * @param testExhibit
     * @param expectedResult
     * @param scenario
     * @return passed
     */
    public static boolean toStringTestCase(Exhibit testExhibit, String expectedResult, String scenario) {
        String result = testExhibit.toString();
        boolean thisPassed = result.equals(expectedResult);

        if (!thisPassed) {
            System.err.println();
            System.err.println("Scenario:" + scenario);
            System.err.println("Given: testExhibit " + testExhibit);
            System.err.println("When: testExhibit.toString");
            System.err.println("Then: output is:\n" + expectedResult);
            System.err.println("Passed: " + thisPassed);
            System.err.println("Expected Value:\n" + expectedResult);
            System.err.println("Given Value:\n" + result);
            System.err.println();
        }
        return thisPassed;
    }

    /**
     * Test for removeArtifact method
     * 
     * @param testExhibit
     * @param artifactToRemoveIndex
     * @param expectedResult
     * @param scenario
     * @return passed
     */
    public static boolean removeArtifactTestCase(Exhibit testExhibit, int artifactToRemoveIndex,
            ArrayList<Integer> expectedResult, String scenario) {
        boolean thisPassed;
        String result;
        try {
            testExhibit.removeArtifact(artifactToRemoveIndex);
            ArrayList<Integer> resultArray = testExhibit.getArtifactsID();
            thisPassed = resultArray.equals(expectedResult);
            result = resultArray.toString();
        } catch (Exception e) {
            thisPassed = false;
            result = "Exception Thrown";
        }
        if (!thisPassed) {
            System.err.println();
            System.err.println("Scenario:" + scenario);
            System.err.println("Given: testExhibit " + testExhibit);
            System.err.println("When: testExhibit.removeArtifact called with " + artifactToRemoveIndex);
            System.err.println("Then: output is:\n" + expectedResult);
            System.err.println("Passed: " + thisPassed);
            System.err.println("Expected Value:\n" + expectedResult);
            System.err.println("Given Value:\n" + result);
            System.err.println();
        }
        return thisPassed;

    }

    /**
     * Test for removeArtifact method
     * 
     * @param testExhibit
     * @param artifactToRemoveIndex
     * @param expectedResult
     * @param scenario
     * @return passed
     */
    public static boolean removeSignTestCase(Exhibit testExhibit, int signToRemoveIndex,
            ArrayList<String> expectedResult, String scenario) {
        boolean thisPassed;
        String result;
        try {
            testExhibit.removeSign(signToRemoveIndex);
            ArrayList<String> resultArray = testExhibit.getRoute();
            thisPassed = resultArray.equals(expectedResult);
            result = resultArray.toString();
        } catch (Exception e) {
            thisPassed = false;
            result = "Exception Thrown";
        }
        if (!thisPassed) {
            System.err.println();
            System.err.println("Scenario:" + scenario);
            System.err.println("Given: testExhibit " + testExhibit);
            System.err.println("When: testExhibit.removeSign called with " + signToRemoveIndex);
            System.err.println("Then: output is:\n" + expectedResult);
            System.err.println("Passed: " + thisPassed);
            System.err.println("Expected Value:\n" + expectedResult);
            System.err.println("Given Value:\n" + result);
            System.err.println();
        }
        return thisPassed;

    }

    /**
     * Test for findArtifactIndex method
     * 
     * @param testExhibit
     * @param testArtifactID
     * @param expectedResult
     * @param scenario
     * @return passed
     */
    public static boolean findArtifactIndexTestCase(Exhibit testExhibit, int testArtifactID, int expectedResult,
            String scenario) {
        int result = testExhibit.findArtifactIndex(testArtifactID);
        boolean thisPassed = result == expectedResult;
        if (!thisPassed) {
            System.err.println();
            System.err.println("Scenario:" + scenario);
            System.err.println("Given: testExhibit " + testExhibit);
            System.err.println("When: testExhibit.findArtifactID called with " + testArtifactID);
            System.err.println("Then: output is:\n" + expectedResult);
            System.err.println("Passed: " + thisPassed);
            System.err.println("Expected Value:\n" + expectedResult);
            System.err.println("Given Value:\n" + result);
            System.err.println();
        }
        return thisPassed;
    }

    /**
     * Test for getRouteArray method
     * 
     * @param testExhibit
     * @param expectedResult
     * @param scenario
     * @return passed
     */
    public static boolean getRouteArrayTestCase(Exhibit testExhibit, String[] expectedResult, String scenario) {
        String[] result = testExhibit.getRouteArray();
        boolean thisPassed = ArraysMethods.equals(expectedResult, result);

        if (!thisPassed) {
            System.err.println();
            System.err.println("Scenario:" + scenario);
            System.err.println("Given: testExhibit " + testExhibit);
            System.err.println("When: testExhibit.getRouteArray");
            System.err.println("Then: output is:\n" + expectedResult);
            System.err.println("Passed: " + thisPassed);
            System.err.println("Expected Value:\n" + expectedResult);
            System.err.println("Given Value:\n" + result);
            System.err.println();
        }
        return thisPassed;

    }

    
}
