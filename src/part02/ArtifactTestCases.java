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
        //if (!thisPassed) {
            System.err.println();
            System.err.println("\t\tScenario:" + scenario);
            System.err.println("\t\tGiven: testArtifact " + testArtifact);
            System.err.println("\t\tWhen: testArtifact.toString()");
            System.err.println("\t\tThen: output of toString() is:\n" + expectedResult);
            System.err.println("\t\tPassed: " + thisPassed);
            System.err.println("\t\tExpected Value:\n" + expectedResult);
            System.err.println("\t\tGiven Value:\n" + result);
            System.err.println();
        //}
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
        //if (!thisPassed) {
            System.err.println();
            System.err.println("\t\tScenario:" + scenario);
            System.err.println("\t\tGiven: testArtifact " + testArtifact);
            System.err.println("\t\tWhen: testArtifact.setEngagementTime() called with " + newEngagementTime);
            System.err.println("\t\tThen: output of getEngagementTime() is:\n" + expectedResult);
            System.err.println("\t\tPassed: " + thisPassed);
            System.err.println("\t\tExpected Value:\n" + expectedResult);
            System.err.println("\t\tGiven Value:\n" + result);
            System.err.println();
        //}
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
        //if (!thisPassed) {
            System.err.println();
            System.err.println("\t\tScenario:" + scenario);
            System.err.println("\t\tGiven: testArtifact " + testArtifact);
            System.err.println("\t\tWhen: testArtifact.getEngagementTime()");
            System.err.println("\t\tThen: output is:\n" + expectedResult);
            System.err.println("\t\tPassed: " + thisPassed);
            System.err.println("\t\tExpected Value:\n" + expectedResult);
            System.err.println("\t\tGiven Value:\n" + result);
            System.err.println();
        //}
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
        //if (!thisPassed) {
            System.err.println();
            System.err.println("\t\tScenario:" + scenario);
            System.err.println("\t\tGiven: testArtifact " + testArtifact);
            System.err.println("\t\tWhen: testArtifact.setType() called with " + newName);
            System.err.println("\t\tThen: output of getType() is:\n" + expectedResult);
            System.err.println("\t\tPassed: " + thisPassed);
            System.err.println("\t\tExpected Value:\n" + expectedResult);
            System.err.println("\t\tGiven Value:\n" + result);
            System.err.println();
        //}
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
        //if (!thisPassed) {
            System.err.println();
            System.err.println("\t\tScenario:" + scenario);
            System.err.println("\t\tGiven: testArtifact " + testArtifact);
            System.err.println("\t\tWhen: testArtifact.getType()");
            System.err.println("\t\tThen: output is:\n" + expectedResult);
            System.err.println("\t\tPassed: " + thisPassed);
            System.err.println("\t\tExpected Value:\n" + expectedResult);
            System.err.println("\t\tGiven Value:\n" + result);
            System.err.println();
        //}
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
        //if (!thisPassed) {
            System.err.println();
            System.err.println("\t\tScenario:" + scenario);
            System.err.println("\t\tGiven: testArtifact " + testArtifact);
            System.err.println("\t\tWhen: testArtifact.setName called with " + newName);
            System.err.println("\t\tThen: output of getName is:\n" + expectedResult);
            System.err.println("\t\tPassed: " + thisPassed);
            System.err.println("\t\tExpected Value:\n" + expectedResult);
            System.err.println("\t\tGiven Value:\n" + result);
            System.err.println();
        //}
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
        //if (!thisPassed) {
            System.err.println();
            System.err.println("\t\tScenario:" + scenario);
            System.err.println("\t\tGiven: testArtifact " + testArtifact);
            System.err.println("\t\tWhen: testArtifact.getName");
            System.err.println("\t\tThen: output is:\n" + expectedResult);
            System.err.println("\t\tPassed: " + thisPassed);
            System.err.println("\t\tExpected Value:\n" + expectedResult);
            System.err.println("\t\tGiven Value:\n" + result);
            System.err.println();
        //}
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
        //if (!thisPassed) {
            System.err.println();
            System.err.println("\t\tScenario:" + scenario);
            System.err.println("\t\tGiven: testArtifact " + testArtifact);
            System.err.println("\t\tWhen: testArtifact.getID");
            System.err.println("\t\tThen: output is:\n" + expectedResult);
            System.err.println("\t\tPassed: " + thisPassed);
            System.err.println("\t\tExpected Value:\n" + expectedResult);
            System.err.println("\t\tGiven Value:\n" + result);
            System.err.println();
        //}
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
        
        //if (!thisPassed) {
            System.err.println();
            System.err.println("\t\tScenario:" + scenario);
            System.err.println("\t\tGiven: artifact name is " + testName);
            System.err.println("\t\tAND: artifact type is " + testType);
            System.err.println("\t\tAND: artifact engagementTime is " + testEngagementTime);
            System.err.println("\t\tWhen: new Artifact");
            System.err.println("\t\tThen: output is:\n" + expectedResult);
            System.err.println("\t\tPassed: " + thisPassed);
            System.err.println("\t\tExpected Value:\n" + expectedResult);
            System.err.println("\t\tGiven Value:\n" + result);
            System.err.println();
       // }
        return thisPassed;
    }
    
}
