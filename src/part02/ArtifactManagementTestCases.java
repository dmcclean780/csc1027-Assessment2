package part02;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import part01.Artifact;
import part01.ArtifactManagement;
import part01.Menu;

public class ArtifactManagementTestCases {

    /**
     * Test for the default constructor artifactsArray property
     * 
     * @param expectedResult
     * @param scenario
     * @return passed
     */
    public static boolean defaultConstructorTestCase(Artifact[] expectedResult, String scenario) {
        ArtifactManagement testArtifactManagement = new ArtifactManagement();
        Artifact[] result = testArtifactManagement.getArtifactArray();
        boolean thisPassed = ArraysMethods.equals(result, expectedResult);

       // if (!thisPassed) {
            System.err.println();
            System.err.println("\t\tScenario:" + scenario);
            System.err.println("\t\tWhen: new ArtifactManagement() called");
            System.err.println("\t\tThen: output of getArtifactArray() is:\n" + ArraysMethods.toString(expectedResult));
            System.err.println("\t\tPassed: " + thisPassed);
            System.err.println("\t\tExpected Value:\n" + expectedResult);
            System.err.println("\t\tGiven Value:\n" + result);
            System.err.println();
        //}
        return thisPassed;
    }

    /**
     * Test for default constructor artifacts property
     * 
     * @param expectedResult
     * @param scenario
     * @return passed
     */
    public static boolean defaultConstructorTestCase(ArrayList<Artifact> expectedResult, String scenario) {
        ArtifactManagement testArtifactManagement = new ArtifactManagement();
        ArrayList<Artifact> result = testArtifactManagement.getArtifacts();
        boolean thisPassed = result.equals(expectedResult);

        //if (!thisPassed) {
            System.err.println();
            System.err.println("\t\tScenario:" + scenario);
            System.err.println("\t\tWhen: new ArtifactManagement() called");
            System.err.println("\t\tThen: output of getArtifacts() is:\n" + expectedResult);
            System.err.println("\t\tPassed: " + thisPassed);
            System.err.println("\t\tExpected Value:\n" + expectedResult);
            System.err.println("\t\tGiven Value:\n" + result);
            System.err.println();
        //}
        return thisPassed;
    }

    /**
     * Test for the constructor artifactsArray property
     * 
     * @param expectedResult
     * @param scenario
     * @return passed
     */
    public static boolean constructorTestCase(ArrayList<Artifact> artifactManagementData, Artifact[] expectedResult,
            String scenario) {
        ArtifactManagement testArtifactManagement;
        try {
            testArtifactManagement = new ArtifactManagement(artifactManagementData);
        } catch (Exception e) {
            testArtifactManagement = null;
        }
        Artifact[] result = testArtifactManagement.getArtifactArray();
        boolean thisPassed = ArraysMethods.equals(result, expectedResult);

        //if (!thisPassed) {
            System.err.println();
            System.err.println("\t\tScenario:" + scenario);
            System.err.println("\t\tWhen: new ArtifactManagement() called with " + artifactManagementData);
            System.err.println("\t\tThen: output of getArtifactArray() is:\n" + ArraysMethods.toString(expectedResult));
            System.err.println("\t\tPassed: " + thisPassed);
            System.err.println("\t\tExpected Value:\n" + expectedResult);
            System.err.println("\t\tGiven Value:\n" + result);
            System.err.println();
        //}
        return thisPassed;
    }

    /**
     * Test for constructor artifacts property
     * 
     * @param expectedResult
     * @param scenario
     * @return passed
     */
    public static boolean constructorTestCase(ArrayList<Artifact> artifactManagementData,
            ArrayList<Artifact> expectedResult, String scenario) {
        
                ArtifactManagement testArtifactManagement;
        String result = "";
        boolean thisPassed = false;
        try {
            testArtifactManagement = new ArtifactManagement(artifactManagementData);
            ArrayList<Artifact> resultArray = testArtifactManagement.getArtifacts();
            thisPassed = resultArray.equals(expectedResult);
            result = resultArray.toString();
        } catch (Exception e) {
            result = e.getMessage();
        }
        

        //if (!thisPassed) {
            System.err.println();
            System.err.println("\t\tScenario:" + scenario);
            System.err.println("\t\tWhen: new ArtifactManagement() called with " + artifactManagementData);
            System.err.println("\t\tThen: output of getArtifacts() is:\n" + expectedResult);
            System.err.println("\t\tPassed: " + thisPassed);
            System.err.println("\t\tExpected Value:\n" + expectedResult);
            System.err.println("\t\tGiven Value:\n" + result);
            System.err.println();
        //}
        return thisPassed;
    }

    /**
     * Test for constructor artifacts property
     * 
     * @param expectedResult
     * @param scenario
     * @return passed
     */
    public static boolean constructorTestCase(ArrayList<Artifact> artifactManagementData,
           String expectedResult, String scenario) {
        
        ArtifactManagement testArtifactManagement;
        String result = "";
        boolean thisPassed = false;
        try {
            testArtifactManagement = new ArtifactManagement(artifactManagementData);
            ArrayList<Artifact> resultArray = testArtifactManagement.getArtifacts();

            result = resultArray.toString();
        } catch (Exception e) {
            result = e.getMessage();
            thisPassed = result.equals(expectedResult);
        }
        

        //if (!thisPassed) {
            System.err.println();
            System.err.println("\t\tScenario:" + scenario);
            System.err.println("\t\tWhen: new ArtifactManagement() called with " + artifactManagementData);
            System.err.println("\t\tThen: output of getArtifacts() is:\n" + expectedResult);
            System.err.println("\t\tPassed: " + thisPassed);
            System.err.println("\t\tExpected Value:\n" + expectedResult);
            System.err.println("\t\tGiven Value:\n" + result);
            System.err.println();
       // }
        return thisPassed;
    }

    /**
     * Test for getArtifactArrayLength method
     * 
     * @param testArtifactManagement
     * @param expectedResult
     * @param scenario
     * @return passed
     */
    public static boolean getArtifactArrayLengthTestCase(ArtifactManagement testArtifactManagement, int expectedResult,
            String scenario) {
        int result = testArtifactManagement.getArtifactArrayLength();
        boolean thisPassed = result == expectedResult;

       // if (!thisPassed) {
            System.err.println();
            System.err.println("\t\tScenario:" + scenario);
            System.err.println("\t\tGiven: testArtifactManagement is " + testArtifactManagement);
            System.err.println("\t\tWhen: getArtifactArrayLength called");
            System.err.println("\t\tThen: output is:\n" + expectedResult);
            System.err.println("\t\tPassed: " + thisPassed);
            System.err.println("\t\tExpected Value:\n" + expectedResult);
            System.err.println("\t\tGiven Value:\n" + result);
            System.err.println();
        //}
        return thisPassed;
    }

    /**
     * Test for getArtifactID to compare returned ID
     * 
     * @param testArtifactManagement
     * @param testArtifacrIndex
     * @param expectedResult
     * @param scenario
     * @return passed
     */
    public static boolean getArtifactIDTestCase(ArtifactManagement testArtifactManagement, int testArtifacrIndex,
            int expectedResult,
            String scenario) {

        boolean thisPassed = false;
        int result = -1;
        try {
            result = testArtifactManagement.getArtifactID(testArtifacrIndex);
            thisPassed = result == expectedResult;
        } catch (Exception e) {
            System.err.println(e);
        }

        //if (!thisPassed) {
            System.err.println();
            System.err.println("\t\tScenario:" + scenario);
            System.err.println("\t\tGiven: testArtifactManagement is " + testArtifactManagement);
            System.err.println("\t\tWhen: getArtifactID called with " + testArtifacrIndex);
            System.err.println("\t\tThen: output is:\n" + expectedResult);
            System.err.println("\t\tPassed: " + thisPassed);
            System.err.println("\t\tExpected Value:\n" + expectedResult);
            System.err.println("\t\tGiven Value:\n" + result);
            System.err.println();
        //}
        return thisPassed;
    }

    /**
     * Test for getArtifactIndex to compare exception messages
     * 
     * @param testArtifactManagement
     * @param testArtifacrIndex
     * @param expectedResult
     * @param scenario
     * @return passed
     */
    public static boolean getArtifactIDTestCase(ArtifactManagement testArtifactManagement, int testArtifacrIndex,
            String expectedResult,
            String scenario) {

        boolean thisPassed = false;
        String result = "";
        try {
            result += testArtifactManagement.getArtifactID(testArtifacrIndex);
        } catch (Exception e) {
            result = e.getMessage();
            thisPassed = result.equals(expectedResult);
        }

        //if (!thisPassed) {
            System.err.println();
            System.err.println("\t\tScenario:" + scenario);
            System.err.println("\t\tGiven: testArtifactManagement is " + testArtifactManagement);
            System.err.println("\t\tWhen: getArtifactID called with " + testArtifacrIndex);
            System.err.println("\t\tThen: output is:\n" + expectedResult);
            System.err.println("\t\tPassed: " + thisPassed);
            System.err.println("\t\tExpected Value:\n" + expectedResult);
            System.err.println("\t\tGiven Value:\n" + result);
            System.err.println();
        //}
        return thisPassed;
    }

    /**
     * Test For addArtifact method
     * 
     * @param testArtifactManagement
     * @param testArtifactName
     * @param testArtifactType
     * @param testArtifactTime
     * @param expectedResult
     * @param scenario
     * @return passed
     */
    public static boolean addArtifactTestCase(ArtifactManagement testArtifactManagement, String testArtifactName,
            String testArtifactType, int testArtifactTime, boolean expectedResult, String scenario) {

        boolean result = testArtifactManagement.addArtifact(testArtifactName, testArtifactType, testArtifactTime);
        boolean thisPassed = result == expectedResult;

        //if (!thisPassed) {
            System.err.println();
            System.err.println("\t\tScenario:" + scenario);
            System.err.println("\t\tGiven: testArtifactManagement is " + testArtifactManagement);
            System.err.println("\t\tWhen: addArtifact called with " + testArtifactName);
            System.err.println("\t\tAnd: " + testArtifactType);
            System.err.println("\t\tAnd: " + testArtifactTime);
            System.err.println("\t\tThen: output is:\n" + expectedResult);
            System.err.println("\t\tPassed: " + thisPassed);
            System.err.println("\t\tExpected Value:\n" + expectedResult);
            System.err.println("\t\tGiven Value:\n" + result);
            System.err.println();
        //}
        return thisPassed;
    }

    /**
     * Test for updateArtifact method
     * 
     * @param testArtifactManagement
     * @param artifactChoice
     * @param testArtifactName
     * @param testArtifactType
     * @param testArtifactTime
     * @param expectedResult
     * @param scenario
     * @return passed
     */
    public static boolean updateArtifactTestCase(ArtifactManagement testArtifactManagement, int artifactChoice,
            String testArtifactName, String testArtifactType, String testArtifactTime, boolean expectedResult,
            String scenario) {

        boolean result = testArtifactManagement.updateArtifact(artifactChoice, testArtifactName, testArtifactType,
                testArtifactTime);
        boolean thisPassed = result == expectedResult;

        //if (!thisPassed) {
            System.err.println();
            System.err.println("\t\tScenario:" + scenario);
            System.err.println("\t\tGiven: testArtifactManagement is " + testArtifactManagement);
            System.err.println("\t\tWhen: updateArtifact called with " + artifactChoice);
            System.err.println("\t\tAnd: " + testArtifactName);
            System.err.println("\t\tAnd: " + testArtifactType);
            System.err.println("\t\tAnd: " + testArtifactTime);
            System.err.println("\t\tThen: output is:\n" + expectedResult);
            System.err.println("\t\tPassed: " + thisPassed);
            System.err.println("\t\tExpected Value:\n" + expectedResult);
            System.err.println("\t\tGiven Value:\n" + result);
            System.err.println();
       // }
        return thisPassed;
    }

    /**
     * Test for updateArtifact method
     * 
     * @param testArtifactManagement
     * @param artifactChoice
     * @param testArtifactName
     * @param testArtifactType
     * @param testArtifactTime
     * @param expectedResult
     * @param scenario
     * @return passed
     */
    public static boolean updateArtifactTestCase(ArtifactManagement testArtifactManagement, int artifactChoice,
            String testArtifactName, String testArtifactType, String testArtifactTime, String expectedResult,
            String scenario) {

        testArtifactManagement.updateArtifact(artifactChoice, testArtifactName, testArtifactType, testArtifactTime);
        String result = testArtifactManagement.getArtifactString(artifactChoice);
        boolean thisPassed = result.trim().equals(expectedResult.trim());

        //if (!thisPassed) {
            System.err.println();
            System.err.println("\t\tScenario:" + scenario);
            System.err.println("\t\tGiven: testArtifactManagement is " + testArtifactManagement);
            System.err.println("\t\tWhen: updateArtifact called with " + artifactChoice);
            System.err.println("\t\tAnd: " + testArtifactName);
            System.err.println("\t\tAnd: " + testArtifactType);
            System.err.println("\t\tAnd: " + testArtifactTime);
            System.err.println("\t\tThen: output of getArtifactString is: \n" + expectedResult);
            System.err.println("\t\tPassed: " + thisPassed);
            System.err.println("\t\tExpected Value:\n" + expectedResult);
            System.err.println("\t\tGiven Value:\n" + result);
            System.err.println();
       // }
        return thisPassed;
    }

    /**
     * Test for getArtifactString method
     * 
     * @param testArtifactManagement
     * @param artifactChoice
     * @param expectedResult
     * @param scenario
     * @return passed
     */
    public static boolean getArtifactStringTestCase(ArtifactManagement testArtifactManagement, int artifactChoice,
            String expectedResult, String scenario) {
        String result = testArtifactManagement.getArtifactString(artifactChoice);
        boolean thisPassed = result.equals(expectedResult);

        //if (!thisPassed) {
            System.err.println();
            System.err.println("\t\tScenario:" + scenario);
            System.err.println("\t\tGiven: testArtifactManagement is " + testArtifactManagement);
            System.err.println("\t\tWhen: getArtifactString called with " + artifactChoice);
            System.err.println("\t\tThen: output of getArtifactString is: \n" + expectedResult);
            System.err.println("\t\tPassed: " + thisPassed);
            System.err.println("\t\tExpected Value:\n" + expectedResult);
            System.err.println("\t\tGiven Value:\n" + result);
            System.err.println();
        //}
        return thisPassed;
    }

    /**
     * Test getArtifactsMenu through the display of the getUserChoice method of menu
     * 
     * @param testArtifactManagement
     * @param expectedResult
     * @param scenario
     * @return
     */
    public static boolean artifactsMenuTestCase(ArtifactManagement testArtifactManagement, String expectedResult,
            String scenario) {

        String input = "1\n";
        InputStream stdin = System.in;
        ByteArrayInputStream s = new ByteArrayInputStream(input.getBytes());
        System.setIn(s);

        PrintStream stdout = System.out;
        ByteArrayOutputStream result = new ByteArrayOutputStream();
        System.setOut(new PrintStream(result));

        Menu artifactMenu = testArtifactManagement.artifactsMenu();
        artifactMenu.getUserChoice();
        boolean thisPassed = false;
        try {
            thisPassed = expectedResult.trim().equals(result.toString("UTF-8").trim());
        } catch (Exception e) {
            System.out.println(e);
        }

        System.setOut(stdout);
        System.setIn(stdin);

        //if (!thisPassed) {
            System.err.println();
            System.err.println("\t\tScenario:" + scenario);
            System.err.println("\t\tGiven: testArtifactManagement is " + testArtifactManagement);
            System.err.println("\t\tWhen: getArtifactsMenu called");
            System.err.println("\t\tThen: display of getUserChoice is: \n" + expectedResult);
            System.err.println("\t\tPassed: " + thisPassed);
            System.err.println("\t\tExpected Value:\n" + expectedResult);
            System.err.println("\t\tGiven Value:\n" + result);
            System.err.println();
       // }
        return thisPassed;
    }

    /**
     * Test for artifactsToArray method
     * 
     * @param testArtifactManagement
     * @param expectedResult
     * @param scenario
     * @return passed
     */
    public static boolean artifactsToArrayTestCase(ArtifactManagement testArtifactManagement, Artifact[] expectedResult,
            String scenario) {

        Artifact[] result = testArtifactManagement.artifactsToArray();
        boolean thisPassed = ArraysMethods.equals(expectedResult, result);

        //if (!thisPassed) {
            System.err.println();
            System.err.println("\t\tScenario:" + scenario);
            System.err.println("\t\tGiven: testArtifactManagement is " + testArtifactManagement);
            System.err.println("\t\tWhen: artifactsToArray called");
            System.err.println("\t\tThen: output is: \n" + ArraysMethods.toString(expectedResult));
            System.err.println("\t\tPassed: " + thisPassed);
            System.err.println("\t\tExpected Value:\n" + ArraysMethods.toString(expectedResult));
            System.err.println("\t\tGiven Value:\n" + ArraysMethods.toString(result));
            System.err.println();
        //}
        return thisPassed;
    }

    /**
     * Test for artifactsToArray method static version
     * 
     * @param testArtifactManagement
     * @param expectedResult
     * @param scenario
     * @return passed
     */
    public static boolean artifactsToArrayTestCase(ArrayList<Artifact> testArtifactManagement,
            Artifact[] expectedResult,
            String scenario) {

        Artifact[] result = ArtifactManagement.artifactsToArray(testArtifactManagement);
        boolean thisPassed = ArraysMethods.equals(expectedResult, result);

        //if (!thisPassed) {
            System.err.println();
            System.err.println("\t\tScenario:" + scenario);
            System.err.println("\t\tGiven: testArtifactManagement is " + testArtifactManagement);
            System.err.println("\t\tWhen: artifactsToArray called");
            System.err.println("\t\tThen: output is: \n" + ArraysMethods.toString(expectedResult));
            System.err.println("\t\tPassed: " + thisPassed);
            System.err.println("E\t\txpected Value:\n" + ArraysMethods.toString(expectedResult));
            System.err.println("\t\tGiven Value:\n" + ArraysMethods.toString(result));
            System.err.println();
        //}
        return thisPassed;
    }

    /**
     * Test For artifactArrayToNameArray method
     * 
     * @param testArray
     * @param expectedResult
     * @param scenario
     * @return passed
     */
    public static boolean artifactArrayToNameArrayTestCase(ArtifactManagement testArtifactManagement, String[] expectedResult,
            String scenario) {
        String[] result = testArtifactManagement.artifactArrayToNameArray();
        boolean thisPassed = ArraysMethods.equals(expectedResult, result);

        //if (!thisPassed) {
            System.err.println();
            System.err.println("\t\tScenario:" + scenario);
            System.err.println("\t\tGiven: testArtifactManagement is " + testArtifactManagement);
            System.err.println("\t\tWhen: artifactsToArray called ");
            System.err.println("\t\tThen: output is: \n" + ArraysMethods.toString(expectedResult));
            System.err.println("\t\tPassed: " + thisPassed);
            System.err.println("\t\tExpected Value:\n" + ArraysMethods.toString(expectedResult));
            System.err.println("\t\tGiven Value:\n" + ArraysMethods.toString(result));
            System.err.println();
       // }
        return thisPassed;
    }

    /**
     * Test For sortArtifactArray method
     * 
     * @param testArtifactManagement
     * @param expectedResult
     * @param scenario
     * @return passed
     */
    public static boolean sortArtifactArrayTestCase(ArtifactManagement testArtifactManagement,
            Artifact[] expectedResult, String scenario) {
        testArtifactManagement.sortArtifactArray();
        Artifact[] result = testArtifactManagement.getArtifactArray();
        boolean thisPassed = ArraysMethods.equals(expectedResult, result);

        //if (!thisPassed) {
            System.err.println();
            System.err.println("\t\tScenario:" + scenario);
            System.err.println("\t\tGiven: testArtifactManagement is " + testArtifactManagement);
            System.err.println("\t\tWhen: sortArtifactsArray called ");
            System.err.println("\t\tThen: output of getArtifactArray is: \n" + ArraysMethods.toString(expectedResult));
            System.err.println("\t\tPassed: " + thisPassed);
            System.err.println("\t\tExpected Value:\n" + ArraysMethods.toString(expectedResult));
            System.err.println("\t\tGiven Value:\n" + ArraysMethods.toString(result));
            System.err.println();
       // }
        return thisPassed;
    }

    /**
     * Test For searchArtifacts method
     * 
     * @param testArtifactManagement
     * @param criteriaChoice
     * @param searchValue
     * @param expectedResult
     * @param scenario
     * @return
     */
    public static boolean searchArtifactsTestCase(ArtifactManagement testArtifactManagement, int criteriaChoice,
            String searchValue, Artifact[] expectedResult, String scenario) {
        testArtifactManagement.searchArtifacts(criteriaChoice, searchValue);
        Artifact[] result = testArtifactManagement.getArtifactArray();
        boolean thisPassed = ArraysMethods.equals(expectedResult, result);

        //if (!thisPassed) {
            System.err.println();
            System.err.println("\t\tScenario:" + scenario);
            System.err.println("\t\tGiven: testArtifactManagement is " + testArtifactManagement);
            System.err.println("\t\tWhen: searchArtifacts called with " + criteriaChoice);
            System.err.println("\t\tAnd: " + searchValue);
            System.err.println("\t\tThen: output of getArtifactArray is: \n" + ArraysMethods.toString(expectedResult));
            System.err.println("\t\tPassed: " + thisPassed);
            System.err.println("\t\tExpected Value:\n" + ArraysMethods.toString(expectedResult));
            System.err.println("\t\tGiven Value:\n" + ArraysMethods.toString(result));
            System.err.println();
       // }
        return thisPassed;
    }

    /**
     * Test For removeArtifact method
     * 
     * @param testArtifactManagement
     * @param artifactChoice
     * @param expectedResult
     * @param scenario
     * @return passed
     */
    public static boolean removeArtifactTestCase(ArtifactManagement testArtifactManagement, int artifactChoice,
            ArrayList<Artifact> expectedResult, String scenario) {
        testArtifactManagement.removeArtifact(artifactChoice);
        ArrayList<Artifact> result = testArtifactManagement.getArtifacts();
        boolean thisPassed = result.equals(expectedResult);

        //if (!thisPassed) {
            System.err.println();
            System.err.println("\t\tScenario:" + scenario);
            System.err.println("\t\tGiven: testArtifactManagement is " + testArtifactManagement);
            System.err.println("\t\tWhen: removeArtifact called with " + artifactChoice);
            System.err.println("\t\tThen: output of getArtifacts is: \n" + expectedResult);
            System.err.println("\t\tPassed: " + thisPassed);
            System.err.println("\t\tExpected Value:\n" + expectedResult);
            System.err.println("\t\tGiven Value:\n" + result);
            System.err.println();
        //}
        return thisPassed;
    }

    /**
     * Test getArtifactMenu through the display of the getUserChoice method of menu
     * 
     * @param testArtifactManagement
     * @param expectedResult
     * @param scenario
     * @return
     */
    public static boolean getArtifactMenuTestCase(ArtifactManagement testArtifactManagement, String expectedResult,
            String scenario) {

        String input = "1\n";
        InputStream stdin = System.in;
        ByteArrayInputStream s = new ByteArrayInputStream(input.getBytes());
        System.setIn(s);

        PrintStream stdout = System.out;
        ByteArrayOutputStream result = new ByteArrayOutputStream();
        System.setOut(new PrintStream(result));

        Menu artifactMenu = testArtifactManagement.getArtifactMenu();
        artifactMenu.getUserChoice();
        boolean thisPassed = false;
        try {
            thisPassed = expectedResult.trim().equals(result.toString("UTF-8").trim());
        } catch (Exception e) {
            System.out.println(e);
        }

        System.setOut(stdout);
        System.setIn(stdin);

        //if (!thisPassed) {
            System.err.println();
            System.err.println("\t\tScenario:" + scenario);
            System.err.println("\t\tGiven: testArtifactManagement is " + testArtifactManagement);
            System.err.println("\t\tWhen: getArtifactMenu called");
            System.err.println("\t\tThen: display of getUserChoice is: \n" + expectedResult);
            System.err.println("\t\tPassed: " + thisPassed);
            System.err.println("\t\tExpected Value:\n" + expectedResult);
            System.err.println("\t\tGiven Value:\n" + result);
            System.err.println();
       // }
        return thisPassed;
    }

    /**
     * Test getExhibitArtifacts method
     * 
     * @param testArtifactManagement
     * @param exhibitArtifacts
     * @param expectedResult
     * @param scenario
     * @return passed
     */
    public static boolean getExhibitArtifactsTestCase(ArtifactManagement testArtifactManagement,
            ArrayList<Integer> exhibitArtifacts, Artifact[] expectedResult, String scenario) {

        PrintStream stdout = System.err;
        ByteArrayOutputStream error = new ByteArrayOutputStream();
        System.setErr(new PrintStream(error));

        Artifact[] result = testArtifactManagement.getExhibitArtifacts(exhibitArtifacts);
        boolean thisPassed = ArraysMethods.equals(expectedResult, result);

        System.setErr(stdout);
        //if (!thisPassed) {
            System.err.println();
            System.err.println("\t\tScenario:" + scenario);
            System.err.println("\t\tGiven: testArtifactManagement is " + testArtifactManagement);
            System.err.println("\t\tWhen: getExhibitArtifacts called with " + exhibitArtifacts);
            System.err.println("\t\tThen: output is: \n" + ArraysMethods.toString(expectedResult));
            System.err.println("\t\tPassed: " + thisPassed);
            System.err.println("\t\tExpected Value:\n" + ArraysMethods.toString(expectedResult));
            System.err.println("\t\tGiven Value:\n" + ArraysMethods.toString(result));
            System.err.println();
        //}
        return thisPassed;
    }

    /**
     * Test for find Artifact to check the artifact returned
     * 
     * @param testArtifactManagement
     * @param testID
     * @param expectedResult
     * @param scenario
     * @return passed
     */
    public static boolean findArtifactTestCase(ArtifactManagement testArtifactManagement, int testID,
            Artifact expectedResult, String scenario) {
        String result = "";
        boolean thisPassed = false;
        try {
            Artifact resultArtifact = testArtifactManagement.findArtifact(testID);
            thisPassed = resultArtifact.getID() == expectedResult.getID();
            result = resultArtifact.toString();
        } catch (Exception e) {
            result = e.getMessage();
        }

        //if (!thisPassed) {
            System.err.println();
            System.err.println("\t\tScenario:" + scenario);
            System.err.println("\t\tGiven: testArtifactManagement is " + testArtifactManagement);
            System.err.println("\t\tWhen: findArtifact called with " + testID);
            System.err.println("\t\tThen: output is: \n" + expectedResult);
            System.err.println("\t\tPassed: " + thisPassed);
            System.err.println("\t\tExpected Value:\n" + expectedResult);
            System.err.println("\t\tGiven Value:\n" + result);
            System.err.println();
        //}
        return thisPassed;
    }

    /**
     * Test for findArtifact to check the exception message
     * 
     * @param testArtifactManagement
     * @param testID
     * @param expectedResult
     * @param scenario
     * @return passed
     */
    public static boolean findArtifactTestCase(ArtifactManagement testArtifactManagement, int testID,
            String expectedResult, String scenario) {
        String result = "";
        boolean thisPassed = false;
        try {
            Artifact resultArtifact = testArtifactManagement.findArtifact(testID);
            result = resultArtifact.toString();
        } catch (Exception e) {
            result = e.getMessage();
            thisPassed = result.equals(expectedResult);
        }

        //if (!thisPassed) {
            System.err.println();
            System.err.println("\t\tScenario:" + scenario);
            System.err.println("\t\tGiven: testArtifactManagement is " + testArtifactManagement);
            System.err.println("\t\tWhen: findArtifact called with " + testID);
            System.err.println("\t\tThen: output is: \n" + expectedResult);
            System.err.println("\t\tPassed: " + thisPassed);
            System.err.println("\t\tExpected Value:\n" + expectedResult);
            System.err.println("\t\tGiven Value:\n" + result);
            System.err.println();
       // }
        return thisPassed;
    }

    /**
     * Test for getArtifactNamesMethod
     * 
     * @param testArtifactManagement
     * @param exhibitArtifacts
     * @param expectedResult
     * @param scenario
     * @return passed
     */
    public static boolean getArtifactNamesTestCase(ArtifactManagement testArtifactManagement,
            ArrayList<Integer> exhibitArtifacts, String[] expectedResult, String scenario) {

        PrintStream stdout = System.err;
        ByteArrayOutputStream error = new ByteArrayOutputStream();
        System.setErr(new PrintStream(error));

        String[] result = testArtifactManagement.getArtifactNames(exhibitArtifacts);
        boolean thisPassed = ArraysMethods.equals(expectedResult, result);

        System.setErr(stdout);

        //if (!thisPassed) {
            System.err.println();
            System.err.println("\t\tScenario:" + scenario);
            System.err.println("\t\tGiven: testArtifactManagement is " + testArtifactManagement);
            System.err.println("\t\tWhen: getArtifactNames called with " + exhibitArtifacts);
            System.err.println("\t\tThen: output is: \n" + ArraysMethods.toString(expectedResult));
            System.err.println("\t\tPassed: " + thisPassed);
            System.err.println("\t\tExpected Value:\n" + ArraysMethods.toString(expectedResult));
            System.err.println("\t\tGiven Value:\n" + ArraysMethods.toString(result));
            System.err.println();
        //}
        return thisPassed;
    }

    /**
     * Test for getExhibitEngagmentTime method
     * 
     * @param testArtifactManagement
     * @param exhibitArtifacts
     * @param expectedResult
     * @param scenario
     * @return passed
     */
    public static boolean getExhibitEngagmentTimeTestCase(ArtifactManagement testArtifactManagement,
            ArrayList<Integer> exhibitArtifacts, int expectedResult, String scenario) {

        PrintStream stdout = System.err;
        ByteArrayOutputStream error = new ByteArrayOutputStream();
        System.setErr(new PrintStream(error));

        int result = testArtifactManagement.getExhibitEngagmentTime(exhibitArtifacts);
        boolean thisPassed = result == expectedResult;

        System.setErr(stdout);

        //if (!thisPassed) {
            System.err.println();
            System.err.println("\t\tScenario:" + scenario);
            System.err.println("\t\tGiven: testArtifactManagement is " + testArtifactManagement);
            System.err.println("\t\tWhen: getExhibitEngagmentTime called with " + exhibitArtifacts);
            System.err.println("\t\tThen: output is: \n" + expectedResult);
            System.err.println("\t\tPassed: " + thisPassed);
            System.err.println("\t\tExpected Value:\n" + expectedResult);
            System.err.println("\t\tGiven Value:\n" + result);
            System.err.println();
        //}
        return thisPassed;
    }
}
