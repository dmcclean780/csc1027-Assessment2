package part02;

import java.util.ArrayList;

import part01.Artifact;
import part01.ArtifactManagement;

public class ArtifactManagementTester {
    private static int artifactsCreated = -1;

    public static void main(String[] args) {
        boolean allPassed = true;
        System.out.println("Class in Test: ArtifactManagement");
        System.out.println();
        allPassed &= testDefaultConstructor();
        allPassed &= testConstructor();
        allPassed &= testGetArtifactArrayLength();
        allPassed &= testGetArtifactID();
        allPassed &= testAddArtifact();
        allPassed &= testUpdateArtifact();
        allPassed &= testUpdateArtifactByID();
        allPassed &= testGetArtifactString();
        allPassed &= testArtifactsMenu();
        allPassed &= testArtifactsToArray();
        allPassed &= testArtifactArrayToNameArray();
        allPassed &= testSortArtifactArray();
        allPassed &= testSearchArtifacts();
        allPassed &= testRemoveArtifact();
        allPassed &= testGetArtifactMenu();
        allPassed &= testGetExhibitArtifacts();
        allPassed &= testFindArtifact();
        allPassed &= testGetArtifactNames();
        allPassed &= testGetExhibitEngagmentTime();
        System.out.println("All Features Passed: " + allPassed);
        System.out.println();
    }

    /**
     * Test Suit For the Default Constructor this also tests getArtifacts and
     * getArtifactArray
     * 
     * @return
     */
    public static boolean testDefaultConstructor() {
        System.out.println("\tFeature: ArtifactMangement default constructor");
        boolean allPassed = true;

        /**
         * Test for Default Constructer Array Property with getArtifactArray
         */
        {
            Artifact[] expectedResult = {};
            String scenario = "Default Constructor Array Property";

            allPassed &= ArtifactManagementTestCases.defaultConstructorTestCase(expectedResult, scenario);
        }

        /**
         * Test for Default Constructer ArrayList Property with getArtifacts
         */
        {
            ArrayList<Artifact> expectedResult = new ArrayList<>();
            String scenario = "Default Constructor ArrayList Property";

            allPassed &= ArtifactManagementTestCases.defaultConstructorTestCase(expectedResult, scenario);
        }

        System.out.println("\tFeature Passed: " + allPassed);
        System.out.println();
        return allPassed;
    }

    /**
     * Test Suit For the Default Constructorthis also tests getArtifacts and
     * getArtifactArray
     * 
     * @return
     */
    public static boolean testConstructor() {
        System.out.println("\tFeature: ArtifactMangement default constructor");
        boolean allPassed = true;

        /**
         * Test for Constructer Array Property with getArtifactArray
         */
        {
            Artifact a0 = Resources.createTestArtifact();
            artifactsCreated++;
            Artifact a1 = Resources.createTestArtifact();
            artifactsCreated++;
            Artifact a2 = Resources.createTestArtifact();
            artifactsCreated++;
            Artifact a3 = Resources.createTestArtifact();
            artifactsCreated++;
            Artifact a4 = Resources.createTestArtifact();
            artifactsCreated++;
            ArrayList<Artifact> artifactManagementData = new ArrayList<>();
            artifactManagementData.add(a0);
            artifactManagementData.add(a1);
            artifactManagementData.add(a2);
            artifactManagementData.add(a3);
            artifactManagementData.add(a4);

            Artifact[] expectedResult = { a0, a1, a2, a3, a4 };
            String scenario = "Constructor Array Property";

            allPassed &= ArtifactManagementTestCases.constructorTestCase(artifactManagementData, expectedResult,
                    scenario);
        }

        /**
         * Test for Constructer ArrayList Property with getArtifacts
         */
        {
            Artifact a0 = Resources.createTestArtifact();
            artifactsCreated++;
            Artifact a1 = Resources.createTestArtifact();
            artifactsCreated++;
            Artifact a2 = Resources.createTestArtifact();
            artifactsCreated++;
            Artifact a3 = Resources.createTestArtifact();
            artifactsCreated++;
            Artifact a4 = Resources.createTestArtifact();
            artifactsCreated++;
            ArrayList<Artifact> artifactManagementData = new ArrayList<>();
            artifactManagementData.add(a0);
            artifactManagementData.add(a1);
            artifactManagementData.add(a2);
            artifactManagementData.add(a3);
            artifactManagementData.add(a4);

            ArrayList<Artifact> expectedResult = new ArrayList<>();
            expectedResult.add(a0);
            expectedResult.add(a1);
            expectedResult.add(a2);
            expectedResult.add(a3);
            expectedResult.add(a4);
            String scenario = "constructor ArrayList Property";

            allPassed &= ArtifactManagementTestCases.constructorTestCase(artifactManagementData, expectedResult,
                    scenario);
        }

        /**
         * Test for Constructer ArrayList Property with getArtifacts
         */
        {
            ArrayList<Artifact> artifactManagementData = new ArrayList<>();
            artifactManagementData.add(null);
            artifactManagementData.add(null);
            artifactManagementData.add(null);
            artifactManagementData.add(null);
            artifactManagementData.add(null);

            String expectedResult = "artifacts cannot contain null";
            String scenario = "constructor with null in ArrayList";

            allPassed &= ArtifactManagementTestCases.constructorTestCase(artifactManagementData, expectedResult,
                    scenario);
        }

        System.out.println("\tFeature Passed: " + allPassed);
        System.out.println();
        return allPassed;
    }

    /**
     * Test Suit For getArtifactArrayLength method
     * 
     * @return all tests passed
     */
    public static boolean testGetArtifactArrayLength() {
        System.out.println("\tFeature: ArtifactManagement getArtifactArrayLength");
        boolean allPassed = true;

        /**
         * Normal use with poopulated manager
         */
        {
            ArtifactManagement testArtifactManagement = Resources.createTestArtifactManagement();
            artifactsCreated += 10;
            int expectedResult = 10;
            String scenario = "normal use";

            allPassed &= ArtifactManagementTestCases.getArtifactArrayLengthTestCase(testArtifactManagement,
                    expectedResult, scenario);
        }

        /**
         * Normal Use with empty manager
         */
        {
            ArtifactManagement testArtifactManagement = Resources.createEmptyTestArtifactManagement();
            int expectedResult = 0;
            String scenario = "Normal Use with empty manager";

            allPassed &= ArtifactManagementTestCases.getArtifactArrayLengthTestCase(testArtifactManagement,
                    expectedResult, scenario);

        }

        System.out.println("\tFeature Passed: " + allPassed);
        System.out.println();
        return allPassed;
    }

    /**
     * Test Suit for getArtifactID method
     * 
     * @return all tests passed
     */
    public static boolean testGetArtifactID() {
        System.out.println("\tFeature: ArtifactManagement getArtifactID");
        boolean allPassed = true;

        /**
         * Normal vailid test
         */
        {
            ArtifactManagement testArtifactManagement = Resources.createTestArtifactManagement();
            int testArtifactIndex = 0;
            int expectedResult = artifactsCreated + 1;
            artifactsCreated += 10;
            String scenario = "normal use";

            allPassed &= ArtifactManagementTestCases.getArtifactIDTestCase(testArtifactManagement, testArtifactIndex,
                    expectedResult, scenario);
        }

        /**
         * Test with empty manager
         */
        {
            ArtifactManagement testArtifactManagement = Resources.createEmptyTestArtifactManagement();
            int testArtifactIndex = 0;
            String expectedResult = "Artifact Choice Out of Range";
            String scenario = "empty manager";

            allPassed &= ArtifactManagementTestCases.getArtifactIDTestCase(testArtifactManagement, testArtifactIndex,
                    expectedResult, scenario);

        }

        /**
         * Test with a neagtive artifactChoice
         */
        {
            ArtifactManagement testArtifactManagement = Resources.createTestArtifactManagement();
            int testArtifactIndex = -1;
            String expectedResult = "Artifact Choice Out of Range";
            artifactsCreated += 10;
            String scenario = "negative index";

            allPassed &= ArtifactManagementTestCases.getArtifactIDTestCase(testArtifactManagement, testArtifactIndex,
                    expectedResult, scenario);

        }

        /**
         * Test With artifact past artifacts
         */
        {
            ArtifactManagement testArtifactManagement = Resources.createTestArtifactManagement();
            int testArtifactIndex = 11;
            String expectedResult = "Artifact Choice Out of Range";
            artifactsCreated += 10;
            String scenario = "index out of range";

            allPassed &= ArtifactManagementTestCases.getArtifactIDTestCase(testArtifactManagement, testArtifactIndex,
                    expectedResult, scenario);

        }

        System.out.println("\tFeature Passed: " + allPassed);
        System.out.println();
        return allPassed;
    }

    /**
     * Test Suit for addArtifact method
     * 
     * @return tests all passed
     */
    public static boolean testAddArtifact() {
        System.out.println("\tFeature: ArtifactManagement addArtifact");
        boolean allPassed = true;

        /**
         * Normal use
         */
        {
            ArtifactManagement testArtifactManagement = Resources.createTestArtifactManagement();
            String testArtifactName = "add Artifact";
            String testArtifactType = "new Artifact";
            int testArtifactTime = 6;
            boolean expectedResult = true;
            artifactsCreated += 10;
            String scenario = "normal use";
            allPassed &= ArtifactManagementTestCases.addArtifactTestCase(testArtifactManagement, testArtifactName,
                    testArtifactType, testArtifactTime, expectedResult, scenario);
            artifactsCreated++;
        }

        /**
         * Zero engagement time
         */
        {
            ArtifactManagement testArtifactManagement = Resources.createTestArtifactManagement();
            String testArtifactName = "add Artifact";
            String testArtifactType = "new Artifact";
            int testArtifactTime = 0;
            boolean expectedResult = false;
            artifactsCreated += 10;
            String scenario = "Zero engagement time";

            allPassed &= ArtifactManagementTestCases.addArtifactTestCase(testArtifactManagement, testArtifactName,
                    testArtifactType, testArtifactTime, expectedResult, scenario);
        }

        /**
         * Negative enagagement time
         */
        {
            ArtifactManagement testArtifactManagement = Resources.createTestArtifactManagement();
            String testArtifactName = "add Artifact";
            String testArtifactType = "new Artifact";
            int testArtifactTime = -1;
            boolean expectedResult = false;
            artifactsCreated += 10;
            String scenario = "Negative enagagement time";

            allPassed &= ArtifactManagementTestCases.addArtifactTestCase(testArtifactManagement, testArtifactName,
                    testArtifactType, testArtifactTime, expectedResult, scenario);
        }

        System.out.println("\tFeature Passed: " + allPassed);
        System.out.println();
        return allPassed;
    }

    /**
     * Test Suit for updateArtifact method
     * @return all tests passed
     */
    public static boolean testUpdateArtifact() {
        System.out.println("\tFeature: ArtifactManagement updateArtifact");
        boolean allPassed = true;

        /**
         * Normal use
         */
        {
            ArtifactManagement testArtifactManagement = Resources.createTestArtifactManagement();
            int artifactChoice = 0;
            String testArtifactName = "add Artifact";
            String testArtifactType = "new Artifact";
            String testArtifactTime = "6";
            boolean expectedResult = true;
            artifactsCreated += 10;
            String scenario = "normal use";

            allPassed &= ArtifactManagementTestCases.updateArtifactTestCase(testArtifactManagement, artifactChoice,
                    testArtifactName, testArtifactType, testArtifactTime, expectedResult, scenario);
        }

        /**
         * Artifact Choice is negative
         */
        {
            ArtifactManagement testArtifactManagement = Resources.createTestArtifactManagement();
            int artifactChoice = -1;
            String testArtifactName = "add Artifact";
            String testArtifactType = "new Artifact";
            String testArtifactTime = "6";
            boolean expectedResult = false;
            artifactsCreated += 10;
            String scenario = "Artifact Choice is negative";

            allPassed &= ArtifactManagementTestCases.updateArtifactTestCase(testArtifactManagement, artifactChoice,
                    testArtifactName, testArtifactType, testArtifactTime, expectedResult, scenario);
        }

        /**
         * Artifact Choice is greater than artifact no
         */
        {
            ArtifactManagement testArtifactManagement = Resources.createTestArtifactManagement();
            int artifactChoice = 11;
            String testArtifactName = "add Artifact";
            String testArtifactType = "new Artifact";
            String testArtifactTime = "6";
            boolean expectedResult = false;
            artifactsCreated += 10;
            String scenario = "Artifact Choice is greater than artifact no";

            allPassed &= ArtifactManagementTestCases.updateArtifactTestCase(testArtifactManagement, artifactChoice,
                    testArtifactName, testArtifactType, testArtifactTime, expectedResult, scenario);
        }

        /**
         * Zero engagement time
         */
        {
            ArtifactManagement testArtifactManagement = Resources.createTestArtifactManagement();
            int artifactChoice = 0;
            String testArtifactName = "add Artifact";
            String testArtifactType = "new Artifact";
            String testArtifactTime = "0";
            boolean expectedResult = false;
            artifactsCreated += 10;
            String scenario = "Zero engagement time";

            allPassed &= ArtifactManagementTestCases.updateArtifactTestCase(testArtifactManagement, artifactChoice,
                    testArtifactName, testArtifactType, testArtifactTime, expectedResult, scenario);
        }

        /**
         * Negative enagagement time
         */
        {
            ArtifactManagement testArtifactManagement = Resources.createTestArtifactManagement();
            int artifactChoice = 0;
            String testArtifactName = "add Artifact";
            String testArtifactType = "new Artifact";
            String testArtifactTime = "-1";
            boolean expectedResult = false;
            artifactsCreated += 10;
            String scenario = "Negative enagagement time";

            allPassed &= ArtifactManagementTestCases.updateArtifactTestCase(testArtifactManagement, artifactChoice,
                    testArtifactName, testArtifactType, testArtifactTime, expectedResult, scenario);
        }

        /**
         * Don't Update anything
         */
        {
            ArtifactManagement testArtifactManagement = Resources.createTestArtifactManagement();
            int artifactChoice = 0;
            String testArtifactName = "";
            String testArtifactType = "";
            String testArtifactTime = "";
            String expectedResult = "ID: " + (artifactsCreated+1)
                    + ",\tName: test,\tType: artifact,\tEngagement Time: 4 minutes";
            artifactsCreated += 10;
            String scenario = "Don't Update anything";

            allPassed &= ArtifactManagementTestCases.updateArtifactTestCase(testArtifactManagement, artifactChoice,
                    testArtifactName, testArtifactType, testArtifactTime, expectedResult, scenario);
        }

        /**
         * update name
         */
        {
            ArtifactManagement testArtifactManagement = Resources.createTestArtifactManagement();
            int artifactChoice = 0;
            String testArtifactName = "new name";
            String testArtifactType = "";
            String testArtifactTime = "";
            String expectedResult = "ID: " + (artifactsCreated+1)
                    + ",\tName: new name,\tType: artifact,\tEngagement Time: 4 minutes";
            artifactsCreated += 10;
            String scenario = "update name";

            allPassed &= ArtifactManagementTestCases.updateArtifactTestCase(testArtifactManagement, artifactChoice,
                    testArtifactName, testArtifactType, testArtifactTime, expectedResult, scenario);
        }

        /**
         * update type
         */
        {
            ArtifactManagement testArtifactManagement = Resources.createTestArtifactManagement();
            int artifactChoice = 0;
            String testArtifactName = "";
            String testArtifactType = "new type";
            String testArtifactTime = "";
            String expectedResult = "ID: " + (artifactsCreated+1)
                    + ",\tName: test,\tType: new type,\tEngagement Time: 4 minutes";
            artifactsCreated += 10;
            String scenario = "update type";

            allPassed &= ArtifactManagementTestCases.updateArtifactTestCase(testArtifactManagement, artifactChoice,
                    testArtifactName, testArtifactType, testArtifactTime, expectedResult, scenario);
        }

        /**
         * update time
         */
        {
            ArtifactManagement testArtifactManagement = Resources.createTestArtifactManagement();
            int artifactChoice = 0;
            String testArtifactName = "";
            String testArtifactType = "";
            String testArtifactTime = "9";
            String expectedResult = "ID: " + (artifactsCreated+1)
                    + ",\tName: test,\tType: artifact,\tEngagement Time: 9 minutes";
            artifactsCreated += 10;
            String scenario = "update time";

            allPassed &= ArtifactManagementTestCases.updateArtifactTestCase(testArtifactManagement, artifactChoice,
                    testArtifactName, testArtifactType, testArtifactTime, expectedResult, scenario);
        }

        System.out.println("\tFeature Passed: " + allPassed);
        System.out.println();
        return allPassed;
    }

    /**
     * Test Suit for updateArtifactByID method
     * @return all tests passed
     */
    public static boolean testUpdateArtifactByID() {
        System.out.println("\tFeature: ArtifactManagement updateArtifactByID");
        boolean allPassed = true;

        /**
         * Normal use
         */
        {
            ArtifactManagement testArtifactManagement = Resources.createTestArtifactManagement();
            int artifactChoice = 0;
            int artifactID = artifactsCreated+1;
            String testArtifactName = "add Artifact";
            String testArtifactType = "new Artifact";
            String testArtifactTime = "6";
            boolean expectedResult = true;
            artifactsCreated += 10;
            String scenario = "normal use";

            allPassed &= ArtifactManagementTestCases.updateArtifactByIDTestCase(testArtifactManagement, artifactID,
                    testArtifactName, testArtifactType, testArtifactTime, artifactChoice, expectedResult, scenario);
        }

        /**
         * Artifact ID is invalid
         */
        {
            ArtifactManagement testArtifactManagement = Resources.createTestArtifactManagement();
            int artifactChoice = 0;
            int artifactID = artifactsCreated;
            String testArtifactName = "add Artifact";
            String testArtifactType = "new Artifact";
            String testArtifactTime = "6";
            boolean expectedResult = false;
            artifactsCreated += 10;
            String scenario = "Artifact Choice is negative";

            allPassed &= ArtifactManagementTestCases.updateArtifactByIDTestCase(testArtifactManagement, artifactID,
                    testArtifactName, testArtifactType, testArtifactTime, artifactChoice, expectedResult, scenario);
        }

        /**
         * Zero engagement time
         */
        {
            ArtifactManagement testArtifactManagement = Resources.createTestArtifactManagement();
            int artifactChoice = 0;
            int artifactID = artifactsCreated+1;
            String testArtifactName = "add Artifact";
            String testArtifactType = "new Artifact";
            String testArtifactTime = "0";
            boolean expectedResult = false;
            artifactsCreated += 10;
            String scenario = "Zero engagement time";

            allPassed &= ArtifactManagementTestCases.updateArtifactByIDTestCase(testArtifactManagement, artifactID,
            testArtifactName, testArtifactType, testArtifactTime, artifactChoice, expectedResult, scenario);
        }

        /**
         * Negative enagagement time
         */
        {
            ArtifactManagement testArtifactManagement = Resources.createTestArtifactManagement();
            int artifactChoice = 0;
            int artifactID = artifactsCreated+1;
            String testArtifactName = "add Artifact";
            String testArtifactType = "new Artifact";
            String testArtifactTime = "-1";
            boolean expectedResult = false;
            artifactsCreated += 10;
            String scenario = "Negative enagagement time";

            allPassed &= ArtifactManagementTestCases.updateArtifactByIDTestCase(testArtifactManagement, artifactID,
                    testArtifactName, testArtifactType, testArtifactTime, artifactChoice, expectedResult, scenario);
        }

        /**
         * Don't Update anything
         */
        {
            ArtifactManagement testArtifactManagement = Resources.createTestArtifactManagement();
            int artifactChoice = 0;
            int artifactID = artifactsCreated+1;
            String testArtifactName = "";
            String testArtifactType = "";
            String testArtifactTime = "";
            String expectedResult = "ID: " + (artifactsCreated+1)
                    + ",\tName: test,\tType: artifact,\tEngagement Time: 4 minutes";
            artifactsCreated += 10;
            String scenario = "Don't Update anything";

            allPassed &= ArtifactManagementTestCases.updateArtifactByIDTestCase(testArtifactManagement, artifactID,
                    testArtifactName, testArtifactType, testArtifactTime, artifactChoice, expectedResult, scenario);
        }

        /**
         * update name
         */
        {
            ArtifactManagement testArtifactManagement = Resources.createTestArtifactManagement();
            int artifactChoice = 0;
            int artifactID = artifactsCreated+1;
            String testArtifactName = "new name";
            String testArtifactType = "";
            String testArtifactTime = "";
            String expectedResult = "ID: " + (artifactsCreated+1)
                    + ",\tName: new name,\tType: artifact,\tEngagement Time: 4 minutes";
            artifactsCreated += 10;
            String scenario = "update name";

            allPassed &= ArtifactManagementTestCases.updateArtifactByIDTestCase(testArtifactManagement, artifactID,
            testArtifactName, testArtifactType, testArtifactTime, artifactChoice, expectedResult, scenario);
        }

        /**
         * update type
         */
        {
            ArtifactManagement testArtifactManagement = Resources.createTestArtifactManagement();
            int artifactChoice = 0;
            int artifactID = artifactsCreated+1;
            String testArtifactName = "";
            String testArtifactType = "new type";
            String testArtifactTime = "";
            String expectedResult = "ID: " + (artifactsCreated+1)
                    + ",\tName: test,\tType: new type,\tEngagement Time: 4 minutes";
            artifactsCreated += 10;
            String scenario = "update type";

            allPassed &= ArtifactManagementTestCases.updateArtifactByIDTestCase(testArtifactManagement, artifactID,
                    testArtifactName, testArtifactType, testArtifactTime, artifactChoice, expectedResult, scenario);
        }

        /**
         * update time
         */
        {
            ArtifactManagement testArtifactManagement = Resources.createTestArtifactManagement();
            int artifactChoice = 0;
            int artifactID = artifactsCreated+1;
            String testArtifactName = "";
            String testArtifactType = "";
            String testArtifactTime = "9";
            String expectedResult = "ID: " + (artifactsCreated+1)
                    + ",\tName: test,\tType: artifact,\tEngagement Time: 9 minutes";
            artifactsCreated += 10;
            String scenario = "update time";

            allPassed &= ArtifactManagementTestCases.updateArtifactByIDTestCase(testArtifactManagement, artifactID,
                    testArtifactName, testArtifactType, testArtifactTime, artifactChoice, expectedResult, scenario);
        }

        System.out.println("\tFeature Passed: " + allPassed);
        System.out.println();
        return allPassed;
    }

    /**
     * Test Suit for getArtifactString method
     * 
     * @return all tests passed
     */
    public static boolean testGetArtifactString() {
        System.out.println("\tFeature ArtifactManagement getArtifactString");
        boolean allPassed = true;

        /**
         * Normal Use
         */
        {
            ArtifactManagement testArtifactManagement = Resources.createTestArtifactManagement();
            int artifactChoice = 0;
            String expectedResult = "ID: " + (artifactsCreated + 1)
                    + ",\tName: test,\tType: artifact,\tEngagement Time: 4 minutes";
            artifactsCreated += 10;
            String scenario = "normal use";

            allPassed &= ArtifactManagementTestCases.getArtifactStringTestCase(testArtifactManagement, artifactChoice,
                    expectedResult, scenario);
        }

        /**
         * artifactChoice is negative
         */
        {
            ArtifactManagement testArtifactManagement = Resources.createTestArtifactManagement();
            int artifactChoice = -1;
            String expectedResult = "Not A Valid Artifact Choice";
            artifactsCreated += 10;
            String scenario = "artifactChoice is negative";

            allPassed &= ArtifactManagementTestCases.getArtifactStringTestCase(testArtifactManagement, artifactChoice,
                    expectedResult, scenario);
        }

        /**
         * artifactChoice exceeds last artifact
         */
        {
            ArtifactManagement testArtifactManagement = Resources.createTestArtifactManagement();
            int artifactChoice = 10;
            String expectedResult = "Not A Valid Artifact Choice";
            artifactsCreated += 10;

            String scenario = "artifactChoice exceeds last artifact";

            allPassed &= ArtifactManagementTestCases.getArtifactStringTestCase(testArtifactManagement, artifactChoice,
                    expectedResult, scenario);
        }

        System.out.println("\tFeature Passed: " + allPassed);
        System.out.println();
        return allPassed;
    }

    /**
     * Test Suit for getArtifactsMenu method
     * 
     * @return all tests passed
     */
    public static boolean testArtifactsMenu() {
        System.out.println("\tFeature: ArtifactManagement getArtifactsMenu");
        boolean allPassed = true;

        {
            ArtifactManagement testArtifactManagement = Resources.createTestArtifactManagement();
            artifactsCreated += 10;
            String expectedResult = "Artifacts\n" + //
                    "+++++++++\n" + //
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

            allPassed &= ArtifactManagementTestCases.artifactsMenuTestCase(testArtifactManagement, expectedResult,
                    scenario);
        }

        /**
         * Empty Artifact Management
         */
        {
            ArtifactManagement testArtifactManagement = Resources.createEmptyTestArtifactManagement();
            String expectedResult = "Artifacts\n" + //
                    "+++++++++\n" + //
                    "1. Search\n" + //
                    "2. Clear\n" + //
                    "3. Quit\n" + //
                    "\n" + //
                    "Enter Selection:";
            String scenario = "empty artifactManagement use";

            allPassed &= ArtifactManagementTestCases.artifactsMenuTestCase(testArtifactManagement, expectedResult,
                    scenario);
        }

        System.out.println("\tFeature Passed: " + allPassed);
        System.out.println();
        return allPassed;
    }

    /**
     * Test Suit for artifactsToArray method
     * 
     * @return all tests passed
     */
    public static boolean testArtifactsToArray() {
        System.out.println("\tFeature: ArtifactManagement artifactsToArray");
        boolean allPassed = true;

        /**
         * Normal Use
         */
        {
            Artifact a0 = Resources.createTestArtifact();
            artifactsCreated++;
            Artifact a1 = Resources.createTestArtifact();
            artifactsCreated++;
            Artifact a2 = Resources.createTestArtifact();
            artifactsCreated++;
            Artifact a3 = Resources.createTestArtifact();
            artifactsCreated++;
            Artifact a4 = Resources.createTestArtifact();
            artifactsCreated++;
            ArrayList<Artifact> artifactManagementData = new ArrayList<>();
            artifactManagementData.add(a0);
            artifactManagementData.add(a1);
            artifactManagementData.add(a2);
            artifactManagementData.add(a3);
            artifactManagementData.add(a4);
            ArtifactManagement testArtifactManagement;
            try {
                testArtifactManagement = new ArtifactManagement(artifactManagementData);
            } catch (Exception e) {
                testArtifactManagement = null;
            }
            Artifact[] expectedResult = { a0, a1, a2, a3, a4 };
            String scenario = "normal use";

            allPassed &= ArtifactManagementTestCases.artifactsToArrayTestCase(testArtifactManagement, expectedResult,
                    scenario);
        }

        /**
         * empty ArtifactManagement
         */
        {

            ArtifactManagement testArtifactManagement = Resources.createEmptyTestArtifactManagement();

            Artifact[] expectedResult = {};
            String scenario = "empty ArtifactManagement";

            allPassed &= ArtifactManagementTestCases.artifactsToArrayTestCase(testArtifactManagement, expectedResult,
                    scenario);
        }

        /**
         * Normal Use of static version
         */
        {
            Artifact a0 = Resources.createTestArtifact();
            artifactsCreated++;
            Artifact a1 = Resources.createTestArtifact();
            artifactsCreated++;
            Artifact a2 = Resources.createTestArtifact();
            artifactsCreated++;
            Artifact a3 = Resources.createTestArtifact();
            artifactsCreated++;
            Artifact a4 = Resources.createTestArtifact();
            artifactsCreated++;
            ArrayList<Artifact> artifactManagementData = new ArrayList<>();
            artifactManagementData.add(a0);
            artifactManagementData.add(a1);
            artifactManagementData.add(a2);
            artifactManagementData.add(a3);
            artifactManagementData.add(a4);

            Artifact[] expectedResult = { a0, a1, a2, a3, a4 };
            String scenario = "normal use of static method";

            allPassed &= ArtifactManagementTestCases.artifactsToArrayTestCase(artifactManagementData, expectedResult,
                    scenario);
        }

        /**
         * Empty ArrayList with static method
         */
        {
            ArrayList<Artifact> artifactManagementData = new ArrayList<>();

            Artifact[] expectedResult = {};
            String scenario = "empty array list with static method";

            allPassed &= ArtifactManagementTestCases.artifactsToArrayTestCase(artifactManagementData, expectedResult,
                    scenario);
        }

        System.out.println("\tFeature Passed: " + allPassed);
        System.out.println();
        return allPassed;
    }

    /**
     * Test Suit for artifactArrayToNameArray method
     * 
     * @return all tests passed
     */
    public static boolean testArtifactArrayToNameArray() {
        System.out.println("\tFeature: ArtifactManagement artifactArrayToNameArray");
        boolean allPassed = true;

        /**
         * Normal Use
         */
        {
            ArtifactManagement testArtifactManagement = Resources.createTestArtifactManagement();
            artifactsCreated+=10;
            String[] expectedResult = { "test", "test", "test", "test", "test", "test", "test", "test", "test", "test" };
            String scenario = "normal use";

            allPassed &= ArtifactManagementTestCases.artifactArrayToNameArrayTestCase(testArtifactManagement, expectedResult,
                    scenario);
        }

        /**
         * empty array
         */
        {

            ArtifactManagement testArtifactManagement = Resources.createEmptyTestArtifactManagement();
            String[] expectedResult = {};
            String scenario = "empty array";

            allPassed &= ArtifactManagementTestCases.artifactArrayToNameArrayTestCase(testArtifactManagement, expectedResult,
                    scenario);
        }

        System.out.println("\tFeature Passed: " + allPassed);
        System.out.println();
        return allPassed;

    }

    /**
     * Test Suit for sortArtifactArray method
     * 
     * @return all tests passed
     */
    public static boolean testSortArtifactArray() {
        System.out.println("\tFeature: ArtifactManagement sortArtifactArray");
        boolean allPassed = true;

        /**
         * Normal Use
         */
        {
            Artifact a0 = Resources.createTestArtifact(1);
            artifactsCreated++;
            Artifact a1 = Resources.createTestArtifact(2);
            artifactsCreated++;
            Artifact a2 = Resources.createTestArtifact(3);
            artifactsCreated++;
            Artifact a3 = Resources.createTestArtifact(4);
            artifactsCreated++;
            Artifact a4 = Resources.createTestArtifact(5);
            artifactsCreated++;

            ArrayList<Artifact> artifactManagementData = new ArrayList<>();
            artifactManagementData.add(a0);
            artifactManagementData.add(a1);
            artifactManagementData.add(a2);
            artifactManagementData.add(a3);
            artifactManagementData.add(a4);
            ArtifactManagement testArtifactManagement;
            try {
                testArtifactManagement = new ArtifactManagement(artifactManagementData);
            } catch (Exception e) {
                testArtifactManagement = null;
            }
            Artifact[] expectedResult = { a0, a1, a2, a3, a4 };
            String scenario = "normal use";

            allPassed &= ArtifactManagementTestCases.sortArtifactArrayTestCase(testArtifactManagement, expectedResult,
                    scenario);
        }

        {

            ArtifactManagement testArtifactManagement = Resources.createEmptyTestArtifactManagement();

            Artifact[] expectedResult = {};
            String scenario = "normal use, empty array";

            allPassed &= ArtifactManagementTestCases.sortArtifactArrayTestCase(testArtifactManagement, expectedResult,
                    scenario);
        }

        System.out.println("\tFeature Passed: " + allPassed);
        System.out.println();
        return allPassed;
    }

    /**
     * Test Suit for searchArtifacts method
     * 
     * @return all tests passed
     */
    public static boolean testSearchArtifacts() {
        System.out.println("\tFeature: ArtifactManagement searchArtifacts");
        boolean allPassed = true;

        /**
         * Normal Use, criteria 1, search id
         */
        {
            Artifact a0 = Resources.createTestArtifact(1);
            artifactsCreated++;
            Artifact a1 = Resources.createTestArtifact(2);
            artifactsCreated++;
            Artifact a2 = Resources.createTestArtifact(3);
            artifactsCreated++;
            Artifact a3 = Resources.createTestArtifact(4);
            artifactsCreated++;
            Artifact a4 = Resources.createTestArtifact(5);
            artifactsCreated++;

            ArrayList<Artifact> artifactManagementData = new ArrayList<>();
            artifactManagementData.add(a0);
            artifactManagementData.add(a1);
            artifactManagementData.add(a2);
            artifactManagementData.add(a3);
            artifactManagementData.add(a4);
            ArtifactManagement testArtifactManagement;
            try {
                testArtifactManagement = new ArtifactManagement(artifactManagementData);
            } catch (Exception e) {
                testArtifactManagement = null;
            }
            int criteriaChoice = 1;
            // artifactsCreated = 235;
            String searchValue = "" + artifactsCreated;

            Artifact[] expectedResult = { a4 };
            String scenario = "normal use, criteria 1, search id";

            allPassed &= ArtifactManagementTestCases.searchArtifactsTestCase(testArtifactManagement, criteriaChoice,
                    searchValue, expectedResult, scenario);
        }

        /**
         * Normal Use, criteria 2, search name
         */
        {
            Artifact a0 = Resources.createTestArtifact(1);
            artifactsCreated++;
            Artifact a1 = Resources.createTestArtifact(2);
            artifactsCreated++;
            Artifact a2 = Resources.createTestArtifact(3);
            artifactsCreated++;
            Artifact a3 = Resources.createTestArtifact(4);
            artifactsCreated++;
            Artifact a4 = Resources.createTestArtifact(5);
            artifactsCreated++;

            ArrayList<Artifact> artifactManagementData = new ArrayList<>();
            artifactManagementData.add(a0);
            artifactManagementData.add(a1);
            artifactManagementData.add(a2);
            artifactManagementData.add(a3);
            artifactManagementData.add(a4);
            ArtifactManagement testArtifactManagement;
            try {
                testArtifactManagement = new ArtifactManagement(artifactManagementData);
            } catch (Exception e) {
                testArtifactManagement = null;
            }
            int criteriaChoice = 2;
            String searchValue = "1";

            Artifact[] expectedResult = { a0 };
            String scenario = "normal use, criteria 2, search name";

            allPassed &= ArtifactManagementTestCases.searchArtifactsTestCase(testArtifactManagement, criteriaChoice,
                    searchValue, expectedResult, scenario);
        }

        /**
         * Normal Use, criteria 3, search type
         */
        {
            Artifact a0 = Resources.createTestArtifact(1);
            artifactsCreated++;
            Artifact a1 = Resources.createTestArtifact(2);
            artifactsCreated++;
            Artifact a2 = Resources.createTestArtifact(3);
            artifactsCreated++;
            Artifact a3 = Resources.createTestArtifact(4);
            artifactsCreated++;
            Artifact a4 = Resources.createTestArtifact(5);
            artifactsCreated++;

            ArrayList<Artifact> artifactManagementData = new ArrayList<>();
            artifactManagementData.add(a0);
            artifactManagementData.add(a1);
            artifactManagementData.add(a2);
            artifactManagementData.add(a3);
            artifactManagementData.add(a4);
            ArtifactManagement testArtifactManagement;
            try {
                testArtifactManagement = new ArtifactManagement(artifactManagementData);
            } catch (Exception e) {
                testArtifactManagement = null;
            }
            int criteriaChoice = 3;
            String searchValue = "3";

            Artifact[] expectedResult = { a2 };
            String scenario = "normal use, criteria 3, search type";

            allPassed &= ArtifactManagementTestCases.searchArtifactsTestCase(testArtifactManagement, criteriaChoice,
                    searchValue, expectedResult, scenario);
        }

        /**
         * Normal Use, criteria 4, search time
         */
        {
            Artifact a0 = Resources.createTestArtifact(1);
            artifactsCreated++;
            Artifact a1 = Resources.createTestArtifact(2);
            artifactsCreated++;
            Artifact a2 = Resources.createTestArtifact(3);
            artifactsCreated++;
            Artifact a3 = Resources.createTestArtifact(4);
            artifactsCreated++;
            Artifact a4 = Resources.createTestArtifact(5);
            artifactsCreated++;

            ArrayList<Artifact> artifactManagementData = new ArrayList<>();
            artifactManagementData.add(a0);
            artifactManagementData.add(a1);
            artifactManagementData.add(a2);
            artifactManagementData.add(a3);
            artifactManagementData.add(a4);
            ArtifactManagement testArtifactManagement;
            try {
                testArtifactManagement = new ArtifactManagement(artifactManagementData);
            } catch (Exception e) {
                testArtifactManagement = null;
            }
            int criteriaChoice = 4;
            String searchValue = "8";

            Artifact[] expectedResult = { a3 };
            String scenario = "normal use, criteria 4, search time";

            allPassed &= ArtifactManagementTestCases.searchArtifactsTestCase(testArtifactManagement, criteriaChoice,
                    searchValue, expectedResult, scenario);
        }

        /**
         * Normal Use, criteria 5, no search
         */
        {
            Artifact a0 = Resources.createTestArtifact(1);
            artifactsCreated++;
            Artifact a1 = Resources.createTestArtifact(2);
            artifactsCreated++;
            Artifact a2 = Resources.createTestArtifact(3);
            artifactsCreated++;
            Artifact a3 = Resources.createTestArtifact(4);
            artifactsCreated++;
            Artifact a4 = Resources.createTestArtifact(5);
            artifactsCreated++;

            ArrayList<Artifact> artifactManagementData = new ArrayList<>();
            artifactManagementData.add(a0);
            artifactManagementData.add(a1);
            artifactManagementData.add(a2);
            artifactManagementData.add(a3);
            artifactManagementData.add(a4);
            ArtifactManagement testArtifactManagement;
            try {
                testArtifactManagement = new ArtifactManagement(artifactManagementData);
            } catch (Exception e) {
                testArtifactManagement = null;
            }
            int criteriaChoice = 5;
            String searchValue = "1";

            Artifact[] expectedResult = { a0, a1, a2, a3, a4 };
            String scenario = "normal use, criteria 5, no search";

            allPassed &= ArtifactManagementTestCases.searchArtifactsTestCase(testArtifactManagement, criteriaChoice,
                    searchValue, expectedResult, scenario);
        }

        /**
         * Normal Use, criteria 0, no search
         */
        {
            Artifact a0 = Resources.createTestArtifact(1);
            artifactsCreated++;
            Artifact a1 = Resources.createTestArtifact(2);
            artifactsCreated++;
            Artifact a2 = Resources.createTestArtifact(3);
            artifactsCreated++;
            Artifact a3 = Resources.createTestArtifact(4);
            artifactsCreated++;
            Artifact a4 = Resources.createTestArtifact(5);
            artifactsCreated++;

            ArrayList<Artifact> artifactManagementData = new ArrayList<>();
            artifactManagementData.add(a0);
            artifactManagementData.add(a1);
            artifactManagementData.add(a2);
            artifactManagementData.add(a3);
            artifactManagementData.add(a4);
            ArtifactManagement testArtifactManagement;
            try {
                testArtifactManagement = new ArtifactManagement(artifactManagementData);
            } catch (Exception e) {
                testArtifactManagement = null;
            }
            int criteriaChoice = 0;
            String searchValue = "1";

            Artifact[] expectedResult = { a0, a1, a2, a3, a4 };
            String scenario = "normal use, criteria 0,  no search";

            allPassed &= ArtifactManagementTestCases.searchArtifactsTestCase(testArtifactManagement, criteriaChoice,
                    searchValue, expectedResult, scenario);
        }

        /**
         * Normal Use, criteria -1, no search
         */
        {
            Artifact a0 = Resources.createTestArtifact(1);
            artifactsCreated++;
            Artifact a1 = Resources.createTestArtifact(2);
            artifactsCreated++;
            Artifact a2 = Resources.createTestArtifact(3);
            artifactsCreated++;
            Artifact a3 = Resources.createTestArtifact(4);
            artifactsCreated++;
            Artifact a4 = Resources.createTestArtifact(5);
            artifactsCreated++;

            ArrayList<Artifact> artifactManagementData = new ArrayList<>();
            artifactManagementData.add(a0);
            artifactManagementData.add(a1);
            artifactManagementData.add(a2);
            artifactManagementData.add(a3);
            artifactManagementData.add(a4);
            ArtifactManagement testArtifactManagement;
            try {
                testArtifactManagement = new ArtifactManagement(artifactManagementData);
            } catch (Exception e) {
                testArtifactManagement = null;
            }
            int criteriaChoice = -1;
            String searchValue = "1";

            Artifact[] expectedResult = { a0, a1, a2, a3, a4 };
            String scenario = "normal use, criteria -1,  no search";

            allPassed &= ArtifactManagementTestCases.searchArtifactsTestCase(testArtifactManagement, criteriaChoice,
                    searchValue, expectedResult, scenario);
        }

        System.out.println("\tFeature Passed: " + allPassed);
        System.out.println();
        return allPassed;
    }

    /**
     * Test Suit for removeArtifact method
     * @return all tests passed
     */
    public static boolean testRemoveArtifact() {
        System.out.println("\tFeature: ArtifactManagement  removeArtifact");
        boolean allPassed = true;

        /**
         * normal use
         */
        {
            Artifact a0 = Resources.createTestArtifact(1);
            artifactsCreated++;
            Artifact a1 = Resources.createTestArtifact(2);
            artifactsCreated++;
            Artifact a2 = Resources.createTestArtifact(3);
            artifactsCreated++;
            Artifact a3 = Resources.createTestArtifact(4);
            artifactsCreated++;
            Artifact a4 = Resources.createTestArtifact(5);
            artifactsCreated++;

            ArrayList<Artifact> artifactManagementData = new ArrayList<>();
            artifactManagementData.add(a0);
            artifactManagementData.add(a1);
            artifactManagementData.add(a2);
            artifactManagementData.add(a3);
            artifactManagementData.add(a4);
            ArtifactManagement testArtifactManagement;
            try {
                testArtifactManagement = new ArtifactManagement(artifactManagementData);
            } catch (Exception e) {
                testArtifactManagement = null;
            }
            ArrayList<Artifact> expectedResult = new ArrayList<>();
            expectedResult.add(a0);
            expectedResult.add(a1);
            expectedResult.add(a2);
            expectedResult.add(a3);
            

            int artifactChoice = artifactsCreated;
            String scenario = "normal use";

            allPassed &= ArtifactManagementTestCases.removeArtifactTestCase(testArtifactManagement, artifactChoice,
                    expectedResult, scenario);
        }

        /**
         * out of range choice
         */
        {
            Artifact a0 = Resources.createTestArtifact(1);
            artifactsCreated++;
            Artifact a1 = Resources.createTestArtifact(2);
            artifactsCreated++;
            Artifact a2 = Resources.createTestArtifact(3);
            artifactsCreated++;
            Artifact a3 = Resources.createTestArtifact(4);
            artifactsCreated++;
            Artifact a4 = Resources.createTestArtifact(5);
            artifactsCreated++;

            ArrayList<Artifact> artifactManagementData = new ArrayList<>();
            artifactManagementData.add(a0);
            artifactManagementData.add(a1);
            artifactManagementData.add(a2);
            artifactManagementData.add(a3);
            artifactManagementData.add(a4);
            ArtifactManagement testArtifactManagement;
            try {
                testArtifactManagement = new ArtifactManagement(artifactManagementData);
            } catch (Exception e) {
                testArtifactManagement = null;
            }
            ArrayList<Artifact> expectedResult = new ArrayList<>();
            expectedResult.add(a0);
            expectedResult.add(a1);
            expectedResult.add(a2);
            expectedResult.add(a3);
            expectedResult.add(a4);

            int artifactChoice = -1;
            String scenario = "out of range choice";

            allPassed &= ArtifactManagementTestCases.removeArtifactTestCase(testArtifactManagement, artifactChoice,
                    expectedResult, scenario);
        }

        /**
         * out of range choice
         */
        {
            Artifact a0 = Resources.createTestArtifact(1);
            artifactsCreated++;
            Artifact a1 = Resources.createTestArtifact(2);
            artifactsCreated++;
            Artifact a2 = Resources.createTestArtifact(3);
            artifactsCreated++;
            Artifact a3 = Resources.createTestArtifact(4);
            artifactsCreated++;
            Artifact a4 = Resources.createTestArtifact(5);
            artifactsCreated++;

            ArrayList<Artifact> artifactManagementData = new ArrayList<>();
            artifactManagementData.add(a0);
            artifactManagementData.add(a1);
            artifactManagementData.add(a2);
            artifactManagementData.add(a3);
            artifactManagementData.add(a4);
            ArtifactManagement testArtifactManagement;
            try {
                testArtifactManagement = new ArtifactManagement(artifactManagementData);
            } catch (Exception e) {
                testArtifactManagement = null;
            }
            ArrayList<Artifact> expectedResult = new ArrayList<>();
            expectedResult.add(a0);
            expectedResult.add(a1);
            expectedResult.add(a2);
            expectedResult.add(a3);
            expectedResult.add(a4);

            int artifactChoice = artifactsCreated+10;
            String scenario = "out of range choice";

            allPassed &= ArtifactManagementTestCases.removeArtifactTestCase(testArtifactManagement, artifactChoice,
                    expectedResult, scenario);
        }

        /**
         * empty artifacts
         */
        {

            ArtifactManagement testArtifactManagement = Resources.createEmptyTestArtifactManagement();

            ArrayList<Artifact> expectedResult = new ArrayList<>();

            int artifactChoice = artifactsCreated;
            String scenario = "empty artifacts";

            allPassed &= ArtifactManagementTestCases.removeArtifactTestCase(testArtifactManagement, artifactChoice,
                    expectedResult, scenario);
        }

        System.out.println("\tFeature Passed: " + allPassed);
        System.out.println();
        return allPassed;

    }

    /**
     * Test Suit for getArtifactMenu method
     * 
     * @return all tests passed
     */
    public static boolean testGetArtifactMenu() {
        System.out.println("\tFeature: ArtifactManagement getArtifactsMenu");
        boolean allPassed = true;

        /**
         * Normal Use
         */
        {
            Artifact a0 = Resources.createTestArtifact(1);
            artifactsCreated++;
            Artifact a1 = Resources.createTestArtifact(2);
            artifactsCreated++;
            Artifact a2 = Resources.createTestArtifact(3);
            artifactsCreated++;
            Artifact a3 = Resources.createTestArtifact(4);
            artifactsCreated++;
            Artifact a4 = Resources.createTestArtifact(5);
            artifactsCreated++;

            ArrayList<Artifact> artifactManagementData = new ArrayList<>();
            artifactManagementData.add(a0);
            artifactManagementData.add(a1);
            artifactManagementData.add(a2);
            artifactManagementData.add(a3);
            artifactManagementData.add(a4);
            ArtifactManagement testArtifactManagement;
            try {
                testArtifactManagement = new ArtifactManagement(artifactManagementData);
            } catch (Exception e) {
                testArtifactManagement = null;
            }            
            String expectedResult = "Artifacts\n" + //
                    "+++++++++\n" + //
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

            allPassed &= ArtifactManagementTestCases.artifactsMenuTestCase(testArtifactManagement, expectedResult,
                    scenario);
        }

        /**
         * Empty Artifact Management
         */
        {
            ArtifactManagement testArtifactManagement = Resources.createEmptyTestArtifactManagement();
            String expectedResult = "Artifacts\n" + //
                    "+++++++++\n" + //
                    "1. Search\n" + //
                    "2. Clear\n" + //
                    "3. Quit\n" + //
                    "\n" + //
                    "Enter Selection:";
            String scenario = "empty artifactManagement use";

            allPassed &= ArtifactManagementTestCases.artifactsMenuTestCase(testArtifactManagement, expectedResult,
                    scenario);
        }

        System.out.println("\tFeature Passed: " + allPassed);
        System.out.println();
        return allPassed;
    }

    /**
     * Test Suit for getExhibitArtifacts method
     * @return all tests passed
     */
    public static boolean testGetExhibitArtifacts(){
        System.out.println("\tFeature: ArtifactManagement getExhibitArtifacts");
        boolean allPassed = true;

        /**
         * Normal Use
         */
        {
            Artifact a0 = Resources.createTestArtifact(1);
            Artifact a1 = Resources.createTestArtifact(2);
            Artifact a2 = Resources.createTestArtifact(3);
            Artifact a3 = Resources.createTestArtifact(4);
            Artifact a4 = Resources.createTestArtifact(5);

            ArrayList<Artifact> artifactManagementData = new ArrayList<>();
            artifactManagementData.add(a0);
            artifactManagementData.add(a1);
            artifactManagementData.add(a2);
            artifactManagementData.add(a3);
            artifactManagementData.add(a4);
            ArtifactManagement testArtifactManagement;
            try {
                testArtifactManagement = new ArtifactManagement(artifactManagementData);
            } catch (Exception e) {
                testArtifactManagement = null;
            }            
            ArrayList<Integer> exhibitArtifacts = new ArrayList<>();
            exhibitArtifacts.add(artifactsCreated+1);
            exhibitArtifacts.add(artifactsCreated+2);
            exhibitArtifacts.add(artifactsCreated+3);
            exhibitArtifacts.add(artifactsCreated+3);
            exhibitArtifacts.add(artifactsCreated+4);

            artifactsCreated+=5;
            Artifact[] expectedResult = {a0, a1, a2, a2, a3};
            String scenario = "normal use";

            allPassed &= ArtifactManagementTestCases.getExhibitArtifactsTestCase(testArtifactManagement, exhibitArtifacts, expectedResult, scenario);
        }

        /**
         * empty list of artifacts
         */
        {
            Artifact a0 = Resources.createTestArtifact(1);
            Artifact a1 = Resources.createTestArtifact(2);
            Artifact a2 = Resources.createTestArtifact(3);
            Artifact a3 = Resources.createTestArtifact(4);
            Artifact a4 = Resources.createTestArtifact(5);

            ArrayList<Artifact> artifactManagementData = new ArrayList<>();
            artifactManagementData.add(a0);
            artifactManagementData.add(a1);
            artifactManagementData.add(a2);
            artifactManagementData.add(a3);
            artifactManagementData.add(a4);
            ArtifactManagement testArtifactManagement;
            try {
                testArtifactManagement = new ArtifactManagement(artifactManagementData);
            } catch (Exception e) {
                testArtifactManagement = null;
            }            
            ArrayList<Integer> exhibitArtifacts = new ArrayList<>();

            artifactsCreated+=5;
            Artifact[] expectedResult = {};
            String scenario = "empty list of artifacts";

            allPassed &= ArtifactManagementTestCases.getExhibitArtifactsTestCase(testArtifactManagement, exhibitArtifacts, expectedResult, scenario);
        }

        /**
         * empty artifactManagement
         */
        {
            ArtifactManagement testArtifactManagement = Resources.createEmptyTestArtifactManagement();
            
            ArrayList<Integer> exhibitArtifacts = new ArrayList<>();
            exhibitArtifacts.add(artifactsCreated+1);
            exhibitArtifacts.add(artifactsCreated+2);
            exhibitArtifacts.add(artifactsCreated+3);
            exhibitArtifacts.add(artifactsCreated+3);
            exhibitArtifacts.add(artifactsCreated+4);

            Artifact[] expectedResult = {};
            String scenario = "empty artifactManagement";

            allPassed &= ArtifactManagementTestCases.getExhibitArtifactsTestCase(testArtifactManagement, exhibitArtifacts, expectedResult, scenario);
        }

        System.out.println("\tFeature Passed: " + allPassed);
        System.out.println();
        return allPassed;
    }

    /**
     * Test Suit for findArtifact method
     * @return all tests passed
     */
    public static boolean testFindArtifact(){
        System.out.println("\tFeature: ArtifactManagement findArtifact");
        boolean allPassed = true;

        /**
         * Normal Use
         */
        {
            Artifact a0 = Resources.createTestArtifact(1);
            Artifact a1 = Resources.createTestArtifact(2);
            Artifact a2 = Resources.createTestArtifact(3);
            Artifact a3 = Resources.createTestArtifact(4);
            Artifact a4 = Resources.createTestArtifact(5);

            ArrayList<Artifact> artifactManagementData = new ArrayList<>();
            artifactManagementData.add(a0);
            artifactManagementData.add(a1);
            artifactManagementData.add(a2);
            artifactManagementData.add(a3);
            artifactManagementData.add(a4);
            ArtifactManagement testArtifactManagement;
            try {
                testArtifactManagement = new ArtifactManagement(artifactManagementData);
            } catch (Exception e) {
                testArtifactManagement = null;
            }            
            int testArtifact = artifactsCreated+1;

            artifactsCreated+=5;
            Artifact expectedResult = a0;
            String scenario = "normal use";

            allPassed &= ArtifactManagementTestCases.findArtifactTestCase(testArtifactManagement, testArtifact, expectedResult, scenario);
        }

        /**
         * id not in list
         */
        {
            Artifact a0 = Resources.createTestArtifact(1);
            Artifact a1 = Resources.createTestArtifact(2);
            Artifact a2 = Resources.createTestArtifact(3);
            Artifact a3 = Resources.createTestArtifact(4);
            Artifact a4 = Resources.createTestArtifact(5);

            ArrayList<Artifact> artifactManagementData = new ArrayList<>();
            artifactManagementData.add(a0);
            artifactManagementData.add(a1);
            artifactManagementData.add(a2);
            artifactManagementData.add(a3);
            artifactManagementData.add(a4);
            ArtifactManagement testArtifactManagement;
            try {
                testArtifactManagement = new ArtifactManagement(artifactManagementData);
            } catch (Exception e) {
                testArtifactManagement = null;
            }            
            int testArtifact = artifactsCreated;

            artifactsCreated+=5;
            String expectedResult = "No matching id in list";
            String scenario = "id not in list";

            allPassed &= ArtifactManagementTestCases.findArtifactTestCase(testArtifactManagement, testArtifact, expectedResult, scenario);
        }

        /**
         * empty list of artifacts
         */
        {
            ArtifactManagement testArtifactManagement = Resources.createEmptyTestArtifactManagement();


            int testArtifact = artifactsCreated+1;
            String expectedResult = "No matching id in list";
            String scenario = "empty list of artifacts";

            allPassed &= ArtifactManagementTestCases.findArtifactTestCase(testArtifactManagement, testArtifact, expectedResult, scenario);
        }

        System.out.println("\tFeature Passed: " + allPassed);
        System.out.println();
        return allPassed;
    }

    /**
     * Test Suit for getArtifactNames method
     * @return all tests passed
     */
    public static boolean testGetArtifactNames(){
        System.out.println("\tFeature: ArtifactManagement getArtifactNames");
        boolean allPassed = true;

        /**
         * Normal Use
         */
        {
            Artifact a0 = Resources.createTestArtifact(1);
            Artifact a1 = Resources.createTestArtifact(2);
            Artifact a2 = Resources.createTestArtifact(3);
            Artifact a3 = Resources.createTestArtifact(4);
            Artifact a4 = Resources.createTestArtifact(5);

            ArrayList<Artifact> artifactManagementData = new ArrayList<>();
            artifactManagementData.add(a0);
            artifactManagementData.add(a1);
            artifactManagementData.add(a2);
            artifactManagementData.add(a3);
            artifactManagementData.add(a4);
            ArtifactManagement testArtifactManagement;
            try {
                testArtifactManagement = new ArtifactManagement(artifactManagementData);
            } catch (Exception e) {
                testArtifactManagement = null;
            }            
            ArrayList<Integer> exhibitArtifacts = new ArrayList<>();
            exhibitArtifacts.add(artifactsCreated+1);
            exhibitArtifacts.add(artifactsCreated+2);
            exhibitArtifacts.add(artifactsCreated+3);
            exhibitArtifacts.add(artifactsCreated+3);
            exhibitArtifacts.add(artifactsCreated+4);

            artifactsCreated+=5;
            String[] expectedResult = {"test1", "test2", "test3", "test3", "test4"};
            String scenario = "normal use";

            allPassed &= ArtifactManagementTestCases.getArtifactNamesTestCase(testArtifactManagement, exhibitArtifacts, expectedResult, scenario);
        }

        /**
         * empty list of artifacts
         */
        {
            Artifact a0 = Resources.createTestArtifact(1);
            Artifact a1 = Resources.createTestArtifact(2);
            Artifact a2 = Resources.createTestArtifact(3);
            Artifact a3 = Resources.createTestArtifact(4);
            Artifact a4 = Resources.createTestArtifact(5);

            ArrayList<Artifact> artifactManagementData = new ArrayList<>();
            artifactManagementData.add(a0);
            artifactManagementData.add(a1);
            artifactManagementData.add(a2);
            artifactManagementData.add(a3);
            artifactManagementData.add(a4);
            ArtifactManagement testArtifactManagement;
            try {
                testArtifactManagement = new ArtifactManagement(artifactManagementData);
            } catch (Exception e) {
                testArtifactManagement = null;
            }            
            ArrayList<Integer> exhibitArtifacts = new ArrayList<>();

            artifactsCreated+=5;
            String[] expectedResult = {};
            String scenario = "empty list of artifacts";

            allPassed &= ArtifactManagementTestCases.getArtifactNamesTestCase(testArtifactManagement, exhibitArtifacts, expectedResult, scenario);
        }

        /**
         * empty artifactManagement
         */
        {
            ArtifactManagement testArtifactManagement = Resources.createEmptyTestArtifactManagement();
            
            ArrayList<Integer> exhibitArtifacts = new ArrayList<>();
            exhibitArtifacts.add(artifactsCreated+1);
            exhibitArtifacts.add(artifactsCreated+2);
            exhibitArtifacts.add(artifactsCreated+3);
            exhibitArtifacts.add(artifactsCreated+3);
            exhibitArtifacts.add(artifactsCreated+4);

            String[] expectedResult = {};
            String scenario = "empty artifactManagement";

            allPassed &= ArtifactManagementTestCases.getArtifactNamesTestCase(testArtifactManagement, exhibitArtifacts, expectedResult, scenario);
        }

        System.out.println("\tFeature Passed: " + allPassed);
        System.out.println();
        return allPassed;
    }

    /**
     * Test Suit for getExhibitEngagmentTime method
     * @return all tests passed
     */
    public static boolean testGetExhibitEngagmentTime(){
        System.out.println("\tFeature: ArtifactManagement getExhibitEngagmentTime");
        boolean allPassed = true;

        /**
         * Normal Use
         */
        {
            Artifact a0 = Resources.createTestArtifact(1);
            Artifact a1 = Resources.createTestArtifact(2);
            Artifact a2 = Resources.createTestArtifact(3);
            Artifact a3 = Resources.createTestArtifact(4);
            Artifact a4 = Resources.createTestArtifact(5);

            ArrayList<Artifact> artifactManagementData = new ArrayList<>();
            artifactManagementData.add(a0);
            artifactManagementData.add(a1);
            artifactManagementData.add(a2);
            artifactManagementData.add(a3);
            artifactManagementData.add(a4);
            ArtifactManagement testArtifactManagement;
            try {
                testArtifactManagement = new ArtifactManagement(artifactManagementData);
            } catch (Exception e) {
                testArtifactManagement = null;
            }            
            ArrayList<Integer> exhibitArtifacts = new ArrayList<>();
            exhibitArtifacts.add(artifactsCreated+1);
            exhibitArtifacts.add(artifactsCreated+2);
            exhibitArtifacts.add(artifactsCreated+3);
            exhibitArtifacts.add(artifactsCreated+3);
            exhibitArtifacts.add(artifactsCreated+4);

            artifactsCreated+=5;
            int expectedResult = 33;
            String scenario = "normal use";

            allPassed &= ArtifactManagementTestCases.getExhibitEngagmentTimeTestCase(testArtifactManagement, exhibitArtifacts, expectedResult, scenario);
        }

        /**
         * empty list of artifacts
         */
        {
            Artifact a0 = Resources.createTestArtifact(1);
            Artifact a1 = Resources.createTestArtifact(2);
            Artifact a2 = Resources.createTestArtifact(3);
            Artifact a3 = Resources.createTestArtifact(4);
            Artifact a4 = Resources.createTestArtifact(5);

            ArrayList<Artifact> artifactManagementData = new ArrayList<>();
            artifactManagementData.add(a0);
            artifactManagementData.add(a1);
            artifactManagementData.add(a2);
            artifactManagementData.add(a3);
            artifactManagementData.add(a4);
            ArtifactManagement testArtifactManagement;
            try {
                testArtifactManagement = new ArtifactManagement(artifactManagementData);
            } catch (Exception e) {
                testArtifactManagement = null;
            }            
            ArrayList<Integer> exhibitArtifacts = new ArrayList<>();

            artifactsCreated+=5;
            int expectedResult = 0;
            String scenario = "empty list of artifacts";

            allPassed &= ArtifactManagementTestCases.getExhibitEngagmentTimeTestCase(testArtifactManagement, exhibitArtifacts, expectedResult, scenario);
        }

        /**
         * empty artifactManagement
         */
        {
            ArtifactManagement testArtifactManagement = Resources.createEmptyTestArtifactManagement();
            
            ArrayList<Integer> exhibitArtifacts = new ArrayList<>();
            exhibitArtifacts.add(artifactsCreated+1);
            exhibitArtifacts.add(artifactsCreated+2);
            exhibitArtifacts.add(artifactsCreated+3);
            exhibitArtifacts.add(artifactsCreated+3);
            exhibitArtifacts.add(artifactsCreated+4);

            int expectedResult = 0;
            String scenario = "empty artifactManagement";

            allPassed &= ArtifactManagementTestCases.getExhibitEngagmentTimeTestCase(testArtifactManagement, exhibitArtifacts, expectedResult, scenario);
        }

        System.out.println("\tFeature Passed: " + allPassed);
        System.out.println();
        return allPassed;
    }


}
