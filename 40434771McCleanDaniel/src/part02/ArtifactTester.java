package part02;

import part01.Artifact;

public class ArtifactTester {
    public static void main(String[] args) {
        boolean allPassed = true;
        System.out.println("Class in Test: Artifact");
        System.out.println();
        allPassed &= testConstructor();
        allPassed &= testGetId();
        allPassed &= testGetName();
        allPassed &= testSetName();
        allPassed &= testGetType();
        allPassed &= testSetType();
        allPassed &= testGetEngagementTime();
        allPassed &= testSetEngagementTime();
        allPassed &= testToString();
        System.out.println("All Features Passed: " + allPassed);
        System.out.println();
    }

    /**
     * Test Suit for the constructor method
     * @return all tests passed
     */
    public static boolean testConstructor() {
        System.out.println("\tFeature: Artifact Constructor");
        boolean allPassed = true;

        /**
         * Valid Artifact
         */
        {
            String testName = "test";
            String testtype = "artifact";
            int testEngagementTime = 10;
            String expectedResult = "no exception";
            String scenario = "valid Parameters";

            allPassed &= ArtifactTestCases.constructorTestCase(testName, testtype, testEngagementTime, expectedResult, scenario);
        }

        /**
         * Time is 0, Invalid
         */
        {
            String testName = "test";
            String testtype = "artifact";
            int testEngagementTime = 0;
            String expectedResult = "exception thrown";
            String scenario = "invalid parameters, time is 0";

            allPassed &= ArtifactTestCases.constructorTestCase(testName, testtype, testEngagementTime, expectedResult, scenario);
        }

        /**
         * Time is negative, Invalid
         */
        {
            String testName = "test";
            String testtype = "artifact";
            int testEngagementTime = -10;
            String expectedResult = "exception thrown";
            String scenario = "invalid parameters, time is negative";

            allPassed &= ArtifactTestCases.constructorTestCase(testName, testtype, testEngagementTime, expectedResult, scenario);
        }

        System.out.println("\tFeature Passed: " + allPassed);
        System.out.println();
        return allPassed;
    }

    /**
     * Test Suit for the getID method
     * @return all tests passed
     */
    public static boolean testGetId() {
        System.out.println("\tFeature: Artifact getID()");
        boolean allPassed = true;

        /**
         * Normal getID()
         */
        {
            Artifact testArtifact = null;
            try {
                testArtifact = new Artifact("test", "artifact", 10);
            } catch (Exception e) {

            }
            int expectedResult = 1;
            String scenario = "normal Artifact";

            allPassed &= ArtifactTestCases.getIDTestCase(testArtifact, expectedResult, scenario);
        }

        /**
         * Check ID increments
         */
        {
            Artifact testArtifact = null;
            Artifact testArtifact2 = null;
            Artifact testArtifact3 = null;
            try {
                testArtifact = new Artifact("test", "artifact", 10);
                testArtifact2 = new Artifact("test", "artifact", 10);
                testArtifact3 = new Artifact("test", "artifact", 10);
            } catch (Exception e) {

            }
            int expectedResult = 2; // starts at 1 as an artifact was created by the previous test case
            String scenario = "multiple Artifacts iterate the ID";

            allPassed &= ArtifactTestCases.getIDTestCase(testArtifact, expectedResult, scenario);
            expectedResult++;
            allPassed &= ArtifactTestCases.getIDTestCase(testArtifact2, expectedResult, scenario);
            expectedResult++;
            allPassed &= ArtifactTestCases.getIDTestCase(testArtifact3, expectedResult, scenario);
        }

        /**
         * Check getID() when other paremters are null
         */
        {
            Artifact testArtifact = null;
            try {
                testArtifact = new Artifact(null, null, 1);
            } catch (Exception e) {

            }
            int expectedResult = 5;
            String scenario = "null Properties";

            allPassed &= ArtifactTestCases.getIDTestCase(testArtifact, expectedResult, scenario);
        }

        System.out.println("\tFeature Passed: " + allPassed);
        System.out.println();
        return allPassed;
    }

    /**
     * Test Suit for the getName method 
     * @return all tests passed
     */
    public static boolean testGetName() {
        System.out.println("\tFeature: Artifact getName()");
        boolean allPassed = true;

        /**
         * normal getName()
         */
        {
            Artifact testArtifact = null;
            try {
                testArtifact = new Artifact("test", "artifact", 10);
            } catch (Exception e) {

            }
            String expectedResult = "test";
            String scenario = "normal Artifact";

            allPassed &= ArtifactTestCases.getNameTestCase(testArtifact, expectedResult, scenario);
        }

        /**
         * Name is null
         */
        {
            Artifact testArtifact = null;
            try {
                testArtifact = new Artifact(null, "artifact", 10);
            } catch (Exception e) {

            }
            String expectedResult = null; // starts at 1 as an artifact was created by the previous test case
            String scenario = "null name";

            allPassed &= ArtifactTestCases.getNameTestCase(testArtifact, expectedResult, scenario);
        }

        System.out.println("\tFeature Passed: " + allPassed);
        System.out.println();
        return allPassed;
    }

    /**
     * Test Suit for the setName method
     * @return all tests passed
     */
    public static boolean testSetName() {
        System.out.println("\tFeature: Artifact setName()");
        boolean allPassed = true;

        /**
         * Normal setName()
         */
        {
            Artifact testArtifact = null;
            try {
                testArtifact = new Artifact("test", "artifact", 10);
            } catch (Exception e) {

            }
            String newName = "set name test";
            String expectedResult = "set name test";
            String scenario = "normal Artifact";

            allPassed &= ArtifactTestCases.setNameTestCase(testArtifact, newName, expectedResult, scenario);
        }

        /**
         * name is null initially
         */
        {
            Artifact testArtifact = null;
            try {
                testArtifact = new Artifact(null, "artifact", 10);
            } catch (Exception e) {

            }
            String newName = "set name test";
            String expectedResult = "set name test";
            String scenario = "set with initial name as null";

            allPassed &= ArtifactTestCases.setNameTestCase(testArtifact, newName, expectedResult, scenario);
        }

        /**
         * New Name is null
         */
        {
            Artifact testArtifact = null;
            try {
                testArtifact = new Artifact("test", "artifact", 10);
            } catch (Exception e) {

            }
            String newName = null;
            String expectedResult = null;
            String scenario = "set name to null";

            allPassed &= ArtifactTestCases.setNameTestCase(testArtifact, newName, expectedResult, scenario);
        }

        System.out.println("\tFeature Passed: " + allPassed);
        System.out.println();
        return allPassed;
    }

    /**
     * Test Suit for the getType method
     * @return all tests passed
     */
    public static boolean testGetType() {
        System.out.println("\tFeature: Artifact getType()");
        boolean allPassed = true;

        /**
         * Normal getType()
         */
        {
            Artifact testArtifact = null;
            try {
                testArtifact = new Artifact("test", "artifact", 10);
            } catch (Exception e) {

            }
            String expectedResult = "artifact";
            String scenario = "normal Artifact";

            allPassed &= ArtifactTestCases.getTypeTestCase(testArtifact, expectedResult, scenario);
        }

        /**
         * Type is null
         */
        {
            Artifact testArtifact = null;
            try {
                testArtifact = new Artifact("test", null, 10);
            } catch (Exception e) {

            }
            String expectedResult = null; // starts at 1 as an artifact was created by the previous test case
            String scenario = "null type";

            allPassed &= ArtifactTestCases.getTypeTestCase(testArtifact, expectedResult, scenario);
        }

        System.out.println("\tFeature Passed: " + allPassed);
        System.out.println();
        return allPassed;
    }

    /**
     * Test Suit for the setType method
     * @return all tests passed
     */
    public static boolean testSetType() {
        System.out.println("\tFeature: Artifact setType()");
        boolean allPassed = true;

        /**
         * Normal setType()
         */
        {
            Artifact testArtifact = null;
            try {
                testArtifact = new Artifact("test", "artifact", 10);
            } catch (Exception e) {

            }
            String newType = "set type test";
            String expectedResult = "set type test";
            String scenario = "normal Artifact";

            allPassed &= ArtifactTestCases.setTypeTestCase(testArtifact, newType, expectedResult, scenario);
        }

        /**
         * type is null initially
         */
        {
            Artifact testArtifact = null;
            try {
                testArtifact = new Artifact("test", null, 10);
            } catch (Exception e) {

            }
            String newType = "set name test";
            String expectedResult = "set name test";
            String scenario = "set with initial type as null";

            allPassed &= ArtifactTestCases.setTypeTestCase(testArtifact, newType, expectedResult, scenario);
        }

        /**
         * new type is null
         */
        {
            Artifact testArtifact = null;
            try {
                testArtifact = new Artifact("test", "artifact", 10);
            } catch (Exception e) {

            }
            String newType = null;
            String expectedResult = null;
            String scenario = "set type to null";

            allPassed &= ArtifactTestCases.setTypeTestCase(testArtifact, newType, expectedResult, scenario);
        }

        System.out.println("\tFeature Passed: " + allPassed);
        System.out.println();
        return allPassed;
    }

    /**
     * Test Suit for the getEngagementTime method
     * @return all tests passed
     */
    public static boolean testGetEngagementTime() {
        System.out.println("\tFeature: Artifact getEngagementTime()");
        boolean allPassed = true;

        /**
         * normal getEngagementTime()
         */
        {
            Artifact testArtifact = null;
            try {
                testArtifact = new Artifact("test", "artifact", 10);
            } catch (Exception e) {

            }
            int expectedResult = 10;
            String scenario = "normal Artifact";

            allPassed &= ArtifactTestCases.getEngagementTimeTestCase(testArtifact, expectedResult, scenario);
        }

        System.out.println("\tFeature Passed: " + allPassed);
        System.out.println();
        return allPassed;
    }

    /**
     * Test Suit for the setEngagement time method
     * @return all tests passed
     */
    public static boolean testSetEngagementTime() {
        System.out.println("\tFeature: Artifact setEngagementTime()");
        boolean allPassed = true;

        /**
         * Normal setEngagementTime()
         */
        {
            Artifact testArtifact = null;
            try {
                testArtifact = new Artifact("test", "artifact", 10);
            } catch (Exception e) {

            }
            int newEngagementTime = 5;
            int expectedResult = 5;
            String scenario = "normal use";
            allPassed &= ArtifactTestCases.setEngagementTimeTestCase(testArtifact, newEngagementTime, expectedResult, scenario);
        }

        /**
         * try to set time to a negative
         */
        {
            Artifact testArtifact = null;
            try {
                testArtifact = new Artifact("test", null, 10);
            } catch (Exception e) {

            }
            int newEngagementTime = -5;
            int expectedResult = -1; // result set to -1 in test code if an exception is thrown be setter
            String scenario = "invalid time";

            allPassed &= ArtifactTestCases.setEngagementTimeTestCase(testArtifact, newEngagementTime, expectedResult, scenario);
        }

        System.out.println("\tFeature Passed: " + allPassed);
        System.out.println();
        return allPassed;
    }

    /**
     * Test Suit for the toString method
     * @return all tests passed
     */
    public static boolean testToString() {
        System.out.println("\tFeature: Artifact toString()");
        boolean allPassed = true;

        /**
         * Normal toString
         */
        {
            Artifact testArtifact = null;
            try {
                testArtifact = new Artifact("test", "artifact", 10);
            } catch (Exception e) {

            }
            String expectedResult = "ID: "+testArtifact.getID()+",\tName: test,\tType: artifact,\tEngagement Time: 10 minutes";
            String scenario = "normal use";
            allPassed &= ArtifactTestCases.toStringTestCase(testArtifact, expectedResult, scenario);
        }

        System.out.println("\tFeature Passed: " + allPassed);
        System.out.println();
        return allPassed;
    }

}
