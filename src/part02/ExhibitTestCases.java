package part02;

import java.util.ArrayList;

import part01.Exhibit;

public class ExhibitTestCases {

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
    
}
