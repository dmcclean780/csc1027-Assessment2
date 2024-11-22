package part02;

import part01.Artifact;

public class ArtifactTestCases {

    /**
     * Test for the toString method
     * @param testArtifact
     * @param expectedResult
     * @param scenario
     * @return passed
     */
    public static boolean toStringTestCase(Artifact testArtifact, String expectedResult, String scenario) {
        String result = testArtifact.toString();
    
        boolean thisPassed = result.equals(expectedResult);
        if (!thisPassed) {
            System.err.println();
            System.err.println("Scenario:" + scenario);
            System.err.println("Given: testArtifact " + testArtifact);
            System.err.println("When: testArtifact.toString()");
            System.err.println("Then: output of toString() is:\n" + expectedResult);
            System.err.println("Passed: " + thisPassed);
            System.err.println("Expected Value:\n" + expectedResult);
            System.err.println("Given Value:\n" + result);
            System.err.println();
        }
        return thisPassed;
    }

    /**
     * Test for the setEngagementTime method
     * @param testArtifact
     * @param newEngagementTime
     * @param expectedResult
     * @param scenario
     * @return passed
     */
    public static boolean setEngagementTimeTestCase(Artifact testArtifact, int newEngagementTime, int expectedResult,
            String scenario) {
        int result;
    
        try {
            testArtifact.setEngagementTime(expectedResult);
            result = testArtifact.getEngagementTime();
        } catch (Exception e) {
            result = -1;
        }
    
        boolean thisPassed = result == expectedResult;
        if (!thisPassed) {
            System.err.println();
            System.err.println("Scenario:" + scenario);
            System.err.println("Given: testArtifact " + testArtifact);
            System.err.println("When: testArtifact.setEngagementTime() called with " + newEngagementTime);
            System.err.println("Then: output of getEngagementTime() is:\n" + expectedResult);
            System.err.println("Passed: " + thisPassed);
            System.err.println("Expected Value:\n" + expectedResult);
            System.err.println("Given Value:\n" + result);
            System.err.println();
        }
        return thisPassed;
    }

    /**
     * Test for the getEngagementTime method
     * @param testArtifact
     * @param expectedResult
     * @param scenario
     * @return passed
     */
    public static boolean getEngagementTimeTestCase(Artifact testArtifact, int expectedResult, String scenario) {
        int result = testArtifact.getEngagementTime();
        boolean thisPassed = result == expectedResult;
        if (!thisPassed) {
            System.err.println();
            System.err.println("Scenario:" + scenario);
            System.err.println("Given: testArtifact " + testArtifact);
            System.err.println("When: testArtifact.getEngagementTime()");
            System.err.println("Then: output is:\n" + expectedResult);
            System.err.println("Passed: " + thisPassed);
            System.err.println("Expected Value:\n" + expectedResult);
            System.err.println("Given Value:\n" + result);
            System.err.println();
        }
        return thisPassed;
    }

    /**
     * Test for the setType method
     * @param testArtifact
     * @param newName
     * @param expectedResult
     * @param scenario
     * @return passed
     */
    public static boolean setTypeTestCase(Artifact testArtifact, String newName, String expectedResult,
            String scenario) {
    
        testArtifact.setType(newName);
        String result = testArtifact.getType();
        boolean thisPassed = result == null ? expectedResult == null : result.equals(expectedResult);
        if (!thisPassed) {
            System.err.println();
            System.err.println("Scenario:" + scenario);
            System.err.println("Given: testArtifact " + testArtifact);
            System.err.println("When: testArtifact.setType() called with " + newName);
            System.err.println("Then: output of getType() is:\n" + expectedResult);
            System.err.println("Passed: " + thisPassed);
            System.err.println("Expected Value:\n" + expectedResult);
            System.err.println("Given Value:\n" + result);
            System.err.println();
        }
        return thisPassed;
    }

    /**
     * Test for the getType method
     * @param testArtifact
     * @param expectedResult
     * @param scenario
     * @return passed
     */
    public static boolean getTypeTestCase(Artifact testArtifact, String expectedResult, String scenario) {
        String result = testArtifact.getType();
        boolean thisPassed = result == null ? expectedResult == null : result.equals(expectedResult);
        if (!thisPassed) {
            System.err.println();
            System.err.println("Scenario:" + scenario);
            System.err.println("Given: testArtifact " + testArtifact);
            System.err.println("When: testArtifact.getType()");
            System.err.println("Then: output is:\n" + expectedResult);
            System.err.println("Passed: " + thisPassed);
            System.err.println("Expected Value:\n" + expectedResult);
            System.err.println("Given Value:\n" + result);
            System.err.println();
        }
        return thisPassed;
    }

    /**
     * Test for the setName method
     * @param testArtifact
     * @param newName
     * @param expectedResult
     * @param scenario
     * @return passed
     */
    public static boolean setNameTestCase(Artifact testArtifact, String newName, String expectedResult,
            String scenario) {
    
        testArtifact.setName(newName);
        String result = testArtifact.getName();
        boolean thisPassed = result == null ? expectedResult == null : result.equals(expectedResult);
        if (!thisPassed) {
            System.err.println();
            System.err.println("Scenario:" + scenario);
            System.err.println("Given: testArtifact " + testArtifact);
            System.err.println("When: testArtifact.setName called with " + newName);
            System.err.println("Then: output of getName is:\n" + expectedResult);
            System.err.println("Passed: " + thisPassed);
            System.err.println("Expected Value:\n" + expectedResult);
            System.err.println("Given Value:\n" + result);
            System.err.println();
        }
        return thisPassed;
    }

    /**
     * Test for the getName method
     * @param testArtifact
     * @param expectedResult
     * @param scenario
     * @return passed
     */
    public static boolean getNameTestCase(Artifact testArtifact, String expectedResult, String scenario) {
        String result = testArtifact.getName();
        boolean thisPassed = result == null ? expectedResult == null : result.equals(expectedResult);
        if (!thisPassed) {
            System.err.println();
            System.err.println("Scenario:" + scenario);
            System.err.println("Given: testArtifact " + testArtifact);
            System.err.println("When: testArtifact.getName");
            System.err.println("Then: output is:\n" + expectedResult);
            System.err.println("Passed: " + thisPassed);
            System.err.println("Expected Value:\n" + expectedResult);
            System.err.println("Given Value:\n" + result);
            System.err.println();
        }
        return thisPassed;
    }

    /**
     * Test for the getID method
     * @param testArtifact
     * @param expectedResult
     * @param scenario
     * @return passed
     */
    public static boolean getIDTestCase(Artifact testArtifact, int expectedResult, String scenario) {
        int result = testArtifact.getID();
        boolean thisPassed = result == expectedResult;
        if (!thisPassed) {
            System.err.println();
            System.err.println("Scenario:" + scenario);
            System.err.println("Given: testArtifact " + testArtifact);
            System.err.println("When: testArtifact.getID");
            System.err.println("Then: output is:\n" + expectedResult);
            System.err.println("Passed: " + thisPassed);
            System.err.println("Expected Value:\n" + expectedResult);
            System.err.println("Given Value:\n" + result);
            System.err.println();
        }
        return thisPassed;
    }

    /**
     * Test for the constructor
     * @param testName
     * @param testType
     * @param testEngagementTime
     * @param expectedResult
     * @param scenario
     * @return passed
     */
    public static boolean constructorTestCase(String testName, String testType, int testEngagementTime, String expectedResult, String scenario){
        String result;
        try{
            new Artifact(testName, testType, testEngagementTime);
            result = "no exception";
        } catch(Exception e){
            result = "exception thrown";
        }
        boolean thisPassed = result.equals(expectedResult);
        if (!thisPassed) {
            System.err.println();
            System.err.println("Scenario:" + scenario);
            System.err.println("Given: artifact name is " + testName);
            System.err.println("AND: artifact type is " + testType);
            System.err.println("AND: artifact engagementTime is " + testEngagementTime);
            System.err.println("When: new Artifact");
            System.err.println("Then: output is:\n" + expectedResult);
            System.err.println("Passed: " + thisPassed);
            System.err.println("Expected Value:\n" + expectedResult);
            System.err.println("Given Value:\n" + result);
            System.err.println();
        }
        return thisPassed;
    }
    
}
