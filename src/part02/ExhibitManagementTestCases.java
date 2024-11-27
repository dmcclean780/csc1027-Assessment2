package part02;

import java.util.ArrayList;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import part01.ArtifactManagement;
import part01.Exhibit;
import part01.ExhibitManagement;
import part01.Menu;

public class ExhibitManagementTestCases {

    /**
     * Test for the default constructor exhibitArray property
     * 
     * @param expectedResult
     * @param scenario
     * @return passed
     */
    public static boolean defaultConstructorTestCase(Exhibit[] expectedResult, String scenario) {
        ExhibitManagement testExhibitManagement = new ExhibitManagement();
        Exhibit[] result = testExhibitManagement.getExhibitArray();
        boolean thisPassed = ArraysMethods.equals(result, expectedResult);

        //if (!thisPassed) {
            System.err.println();
            System.err.println("\t\tScenario:" + scenario);
            System.err.println("\t\tWhen: new ExhibitManagement() called");
            System.err.println("\t\tThen: output of getExhibitArray() is:\n" + ArraysMethods.toString(expectedResult));
            System.err.println("\t\tPassed: " + thisPassed);
            System.err.println("\t\tExpected Value:\n" + expectedResult);
            System.err.println("\t\tGiven Value:\n" + result);
            System.err.println();
       // }
        return thisPassed;
    }

    /**
     * Test for default constructor exhibits property
     * 
     * @param expectedResult
     * @param scenario
     * @return passed
     */
    public static boolean defaultConstructorTestCase(ArrayList<Exhibit> expectedResult, String scenario) {
        ExhibitManagement testExhibitManagement = new ExhibitManagement();
        ArrayList<Exhibit> result = testExhibitManagement.getExhibits();
        boolean thisPassed = result.equals(expectedResult);

       // if (!thisPassed) {
            System.err.println();
            System.err.println("\t\tScenario:" + scenario);
            System.err.println("\t\tWhen: new ExhibitManagement() called");
            System.err.println("\t\tThen: output of getExhibits() is:\n" + expectedResult);
            System.err.println("\t\tPassed: " + thisPassed);
            System.err.println("\t\tExpected Value:\n" + expectedResult);
            System.err.println("\t\tGiven Value:\n" + result);
            System.err.println();
       // }
        return thisPassed;
    }

    /**
     * Test for the constructor exhibitArray property
     * 
     * @param exhibitManagementData
     * @param expectedResult
     * @param scenario
     * @return
     */
    public static boolean constructorTestCase(ArrayList<Exhibit> exhibitManagementData, Exhibit[] expectedResult,
            String scenario) {
        ExhibitManagement testExhibitManagement;
        try {
            testExhibitManagement = new ExhibitManagement(exhibitManagementData);
        } catch (Exception e) {
            testExhibitManagement = null;
        }
        Exhibit[] result = testExhibitManagement.getExhibitArray();
        boolean thisPassed = ArraysMethods.equals(result, expectedResult);

        //if (!thisPassed) {
            System.err.println();
            System.err.println("\t\tScenario:" + scenario);
            System.err.println("\t\tWhen: new ExhibitManagement() called with " + exhibitManagementData);
            System.err.println("\t\tThen: output of getExhibitArray() is:\n" + ArraysMethods.toString(expectedResult));
            System.err.println("\t\tPassed: " + thisPassed);
            System.err.println("\t\tExpected Value:\n" + expectedResult);
            System.err.println("\t\tGiven Value:\n" + result);
            System.err.println();
       // }
        return thisPassed;
    }

    /**
     * Test for constructor exhibits property
     * 
     * @param exhibitManagementData
     * @param expectedResult
     * @param scenario
     * @return
     */
    public static boolean constructorTestCase(ArrayList<Exhibit> exhibitManagementData,
            ArrayList<Exhibit> expectedResult, String scenario) {

        ExhibitManagement testExhibitManagement;
        String result = "";
        boolean thisPassed = false;
        try {
            testExhibitManagement = new ExhibitManagement(exhibitManagementData);
            ArrayList<Exhibit> resultArray = testExhibitManagement.getExhibits();
            thisPassed = resultArray.equals(expectedResult);
            result = resultArray.toString();
        } catch (Exception e) {
            result = e.getMessage();
        }

        //if (!thisPassed) {
            System.err.println();
            System.err.println("\t\tScenario:" + scenario);
            System.err.println("\t\tWhen: new ExhibitManagement() called with " + exhibitManagementData);
            System.err.println("\t\tThen: output of getExhibits() is:\n" + expectedResult);
            System.err.println("\t\tPassed: " + thisPassed);
            System.err.println("\t\tExpected Value:\n" + expectedResult);
            System.err.println("\t\tGiven Value:\n" + result);
            System.err.println();
        //}
        return thisPassed;
    }

    /**
     * Test for constructor exhibits property for correct exception message
     * 
     * @param exhibitManagementData
     * @param expectedResult
     * @param scenario
     * @return
     */
    public static boolean constructorTestCase(ArrayList<Exhibit> exhibitManagementData,
            String expectedResult, String scenario) {

        ExhibitManagement testExhibitManagement;
        String result = "";
        boolean thisPassed = false;
        try {
            testExhibitManagement = new ExhibitManagement(exhibitManagementData);
            ArrayList<Exhibit> resultArray = testExhibitManagement.getExhibits();

            result = resultArray.toString();
        } catch (Exception e) {
            result = e.getMessage();
            thisPassed = result.equals(expectedResult);
        }

       // if (!thisPassed) {
            System.err.println();
            System.err.println("\t\tScenario:" + scenario);
            System.err.println("\t\tWhen: new ExhibitManagement() called with " + exhibitManagementData);
            System.err.println("\t\tThen: output of getExhibits() is:\n" + expectedResult);
            System.err.println("\t\tPassed: " + thisPassed);
            System.err.println("\t\tExpected Value:\n" + expectedResult);
            System.err.println("\t\tGiven Value:\n" + result);
            System.err.println();
       // }
        return thisPassed;
    }

    /**
     * Test for getExhibitArrayLength method
     * 
     * @param testExhibitManagement
     * @param expectedResult
     * @param scenario
     * @return passed
     */
    public static boolean getExhibitArrayLengthTestCase(ExhibitManagement testExhibitManagement, int expectedResult,
            String scenario) {
        int result = testExhibitManagement.getExhibitArrayLength();
        boolean thisPassed = result == expectedResult;

        //if (!thisPassed) {
            System.err.println();
            System.err.println("\t\tScenario:" + scenario);
            System.err.println("\t\tGiven: testArtifactManagement is " + testExhibitManagement);
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
     * Test for addExhibit method
     * 
     * @param testExhibitManagement
     * @param testExhibitName
     * @param testExhibitArtifacts
     * @param testExhibitRoute
     * @param expectedResult
     * @param scenario
     * @return
     */
    public static boolean addExhibitTestCase(ExhibitManagement testExhibitManagement, String testExhibitName,
            ArrayList<Integer> testExhibitArtifacts, ArrayList<String> testExhibitRoute, boolean expectedResult,
            String scenario) {

        boolean result = testExhibitManagement.addExhibit(testExhibitName, testExhibitArtifacts, testExhibitRoute);
        boolean thisPassed = result == expectedResult;

        //if (!thisPassed) {
            System.err.println();
            System.err.println("\t\tScenario:" + scenario);
            System.err.println("\t\tGiven: testExhibitManagement is " + testExhibitName);
            System.err.println("\t\tWhen: addExhibit called with " + testExhibitName);
            System.err.println("\t\tAnd: " + testExhibitArtifacts);
            System.err.println("\t\tAnd: " + testExhibitRoute);
            System.err.println("\t\tThen: output is:\n" + expectedResult);
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
    public static boolean exhibitsMenuTestCase(ExhibitManagement testExhibitManagement, String expectedResult,
            String scenario) {

        String input = "1\n";
        InputStream stdin = System.in;
        ByteArrayInputStream s = new ByteArrayInputStream(input.getBytes());
        System.setIn(s);

        PrintStream stdout = System.out;
        ByteArrayOutputStream result = new ByteArrayOutputStream();
        System.setOut(new PrintStream(result));

        Menu artifactMenu = testExhibitManagement.getExhibitMenu();
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
            System.err.println("\t\tGiven: testExhibitManagement is " + testExhibitManagement);
            System.err.println("\t\tWhen: exhibitsMenu called");
            System.err.println("\t\tThen: display of getUserChoice is: \n" + expectedResult);
            System.err.println("\t\tPassed: " + thisPassed);
            System.err.println("\t\tExpected Value:\n" + expectedResult);
            System.err.println("\t\tGiven Value:\n" + result);
            System.err.println();
        //}
        return thisPassed;
    }

    /**
     * Test for exhibitsToArray
     * 
     * @param testExhibitManagement
     * @param expectedResult
     * @param scenario
     * @return
     */
    public static boolean exhibitsToArrayTestCase(ExhibitManagement testExhibitManagement, Exhibit[] expectedResult,
            String scenario) {

        Exhibit[] result = testExhibitManagement.exhibitsToArray();
        boolean thisPassed = ArraysMethods.equals(expectedResult, result);

        //if (!thisPassed) {
            System.err.println();
            System.err.println("\t\tScenario:" + scenario);
            System.err.println("\t\tGiven: testExhibitManagement is " + testExhibitManagement);
            System.err.println("\t\tWhen: exhibitsToArray called");
            System.err.println("\t\tThen: output is: \n" + ArraysMethods.toString(expectedResult));
            System.err.println("\t\tPassed: " + thisPassed);
            System.err.println("\t\tExpected Value:\n" + ArraysMethods.toString(expectedResult));
            System.err.println("\t\tGiven Value:\n" + ArraysMethods.toString(result));
            System.err.println();
       // }
        return thisPassed;
    }

    /**
     * Test for exhibitsToArray static version
     * 
     * @param testExhibitManagement
     * @param expectedResult
     * @param scenario
     * @return
     */
    public static boolean exhibitsToArrayTestCase(ArrayList<Exhibit> testExhibitManagement,
            Exhibit[] expectedResult,
            String scenario) {

        Exhibit[] result = ExhibitManagement.exhibitsToArray(testExhibitManagement);
        boolean thisPassed = ArraysMethods.equals(expectedResult, result);

        //if (!thisPassed) {
            System.err.println();
            System.err.println("\t\tScenario:" + scenario);
            System.err.println("\t\tGiven: testExhibitManagement is " + testExhibitManagement);
            System.err.println("\t\tWhen: exhibitsToArray called");
            System.err.println("\t\tThen: output is: \n" + ArraysMethods.toString(expectedResult));
            System.err.println("\t\tPassed: " + thisPassed);
            System.err.println("\t\tExpected Value:\n" + ArraysMethods.toString(expectedResult));
            System.err.println("\t\tGiven Value:\n" + ArraysMethods.toString(result));
            System.err.println();
       // }
        return thisPassed;
    }

    /**
     * Test for exhibitArrayToNameArray method
     * 
     * @param testExhibitManagement
     * @param expectedResult
     * @param scenario
     * @return passed
     */
    public static boolean exhibitArrayToNameArrayTestCase(ExhibitManagement testExhibitManagement,
            String[] expectedResult,
            String scenario) {
        String[] result = testExhibitManagement.exhibitArrayToNameArray();
        boolean thisPassed = ArraysMethods.equals(expectedResult, result);

       // if (!thisPassed) {
            System.err.println();
            System.err.println("\t\tScenario:" + scenario);
            System.err.println("\t\tGiven: testExhibitManagement is " + testExhibitManagement);
            System.err.println("\t\tWhen: artifactsToArray called ");
            System.err.println("\t\tThen: output is: \n" + ArraysMethods.toString(expectedResult));
            System.err.println("\t\tPassed: " + thisPassed);
            System.err.println("\t\tExpected Value:\n" + ArraysMethods.toString(expectedResult));
            System.err.println("\t\tGiven Value:\n" + ArraysMethods.toString(result));
            System.err.println();
        //}
        return thisPassed;
    }

    /**
     * Test for sortExhibitArray method
     * 
     * @param testExhibitManagement
     * @param expectedResult
     * @param scenario
     * @return passed
     */
    public static boolean sortExhibittArrayTestCase(ExhibitManagement testExhibitManagement,
            Exhibit[] expectedResult, String scenario) {
        testExhibitManagement.sortExhibitArray();
        Exhibit[] result = testExhibitManagement.getExhibitArray();
        boolean thisPassed = ArraysMethods.equals(expectedResult, result);

        //if (!thisPassed) {
            System.err.println();
            System.err.println("\t\tScenario:" + scenario);
            System.err.println("\t\tGiven: testExhibitManagement is " + testExhibitManagement);
            System.err.println("\t\tWhen: sortExhibitArray called ");
            System.err.println("\t\tThen: output of getExhibitArray is: \n" + ArraysMethods.toString(expectedResult));
            System.err.println("\t\tPassed: " + thisPassed);
            System.err.println("\t\tExpected Value:\n" + ArraysMethods.toString(expectedResult));
            System.err.println("\t\tGiven Value:\n" + ArraysMethods.toString(result));
            System.err.println();
        //}
        return thisPassed;
    }

    /**
     * Test for searchExhibits method
     * 
     * @param testExhibitManagement
     * @param criteriaChoice
     * @param searchValue
     * @param expectedResult
     * @param scenario
     * @return passed
     */
    public static boolean searchExhibitsTestCase(ExhibitManagement testExhibitManagement, int criteriaChoice,
            String searchValue, Exhibit[] expectedResult, String scenario) {

        testExhibitManagement.searchExhibits(criteriaChoice, searchValue);
        Exhibit[] result = testExhibitManagement.getExhibitArray();
        boolean thisPassed = ArraysMethods.equals(expectedResult, result);

        //if (!thisPassed) {
            System.err.println();
            System.err.println("\t\tScenario:" + scenario);
            System.err.println("\t\tGiven: testExhibitManagement is " + testExhibitManagement);
            System.err.println("\t\tWhen: searchExhibits called with " + criteriaChoice);
            System.err.println("\t\tAnd: " + searchValue);
            System.err.println("\t\tThen: output of getExhibitArray is: \n" + ArraysMethods.toString(expectedResult));
            System.err.println("\t\tPassed: " + thisPassed);
            System.err.println("\t\tExpected Value:\n" + ArraysMethods.toString(expectedResult));
            System.err.println("\t\tGiven Value:\n" + ArraysMethods.toString(result));
            System.err.println();
        //}
        return thisPassed;
    }

    /**
     * Test for getExhibitMenu method
     * 
     * @param testExhibitManagement
     * @param expectedResult
     * @param scenario
     * @return passed
     */
    public static boolean getExhibitMenuTestCase(ExhibitManagement testExhibitManagement, String expectedResult,
            String scenario) {

        String input = "1\n";
        InputStream stdin = System.in;
        ByteArrayInputStream s = new ByteArrayInputStream(input.getBytes());
        System.setIn(s);

        PrintStream stdout = System.out;
        ByteArrayOutputStream result = new ByteArrayOutputStream();
        System.setOut(new PrintStream(result));

        Menu exhibitMenu = testExhibitManagement.getExhibitMenu();
        exhibitMenu.getUserChoice();
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
            System.err.println("\t\tGiven: testExhibitManagement is " + testExhibitManagement);
            System.err.println("\t\tWhen: getExhibitMenu called");
            System.err.println("\t\tThen: display of getUserChoice is: \n" + expectedResult);
            System.err.println("\t\tPassed: " + thisPassed);
            System.err.println("\t\tExpected Value:\n" + expectedResult);
            System.err.println("\t\tGiven Value:\n" + result);
            System.err.println();
        //}
        return thisPassed;
    }

    /**
     * Test for getExhibitString method
     * 
     * @param testExhibitManagement
     * @param exhibitChoice
     * @param artifactManagement
     * @param expectedResult
     * @param scenario
     * @return passed
     */
    public static boolean getExhibitStringTestCase(ExhibitManagement testExhibitManagement, int exhibitChoice,
            ArtifactManagement artifactManagement, String expectedResult, String scenario) {

        PrintStream stdout = System.out;
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setErr(new PrintStream(output));

        String result = testExhibitManagement.getExhibitString(exhibitChoice, artifactManagement);
        result = result.replaceAll("\\p{C}", "");
        expectedResult = expectedResult.replaceAll("\\p{C}", "");
        boolean thisPassed = result.trim().equals(expectedResult.trim());

        System.setErr(stdout);
        //if (!thisPassed) {
            System.err.println();
            System.err.println("\t\tScenario:" + scenario);
            System.err.println("\t\tGiven: testExhibitManagement is " + testExhibitManagement);
            System.err.println("\t\tWhen: getExhibitString called with " + exhibitChoice);
            System.err.println("\t\tAND: " + artifactManagement);
            System.err.println("\t\tThen: output is: \n" + expectedResult);
            System.err.println("\t\tPassed: " + thisPassed);
            System.err.println("\t\tExpected Value:\n" + expectedResult);
            System.err.println("\t\tGiven Value:\n" + result);
            System.err.println();
       // }
        return thisPassed;
    }

    /**
     * Test for removeExhibit method
     * 
     * @param testExhibitManagement
     * @param exhibitChoice
     * @param expectedResult
     * @param scenario
     * @return
     */
    public static boolean removeExhibitTestCase(ExhibitManagement testExhibitManagement, int exhibitChoice,
            ArrayList<Exhibit> expectedResult, String scenario) {

        testExhibitManagement.removeExhibit(exhibitChoice);
        ArrayList<Exhibit> result = testExhibitManagement.getExhibits();
        boolean thisPassed = result.equals(expectedResult);

        //if (!thisPassed) {
            System.err.println();
            System.err.println("Scenario:" + scenario);
            System.err.println("Given: testExhibitManagement is " + testExhibitManagement);
            System.err.println("When: removeExhibit called with " + exhibitChoice);
            System.err.println("Then: output of getExhibits is: \n" + expectedResult);
            System.err.println("Passed: " + thisPassed);
            System.err.println("Expected Value:\n" + expectedResult);
            System.err.println("Given Value:\n" + result);
            System.err.println();
        //}
        return thisPassed;
    }

    /**
     * Test for getExhibitArtifactNames method
     * 
     * @param testExhibitManagement
     * @param exhibitChoice
     * @param artifactManagement
     * @param expectedResult
     * @param scenario
     * @return passed
     */
    public static boolean getExhibitArtifactNamesTestCase(ExhibitManagement testExhibitManagement, int exhibitChoice,
            ArtifactManagement artifactManagement, String[] expectedResult, String scenario) {

        PrintStream stdout = System.out;
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        PrintStream stderr = System.err;
        ByteArrayOutputStream err = new ByteArrayOutputStream();
        System.setErr(new PrintStream(err));

        String[] result = testExhibitManagement.getExhibitArtifactNames(exhibitChoice, artifactManagement);
        boolean thisPassed = ArraysMethods.equals(expectedResult, result);

        System.setOut(stdout);
        System.setErr(stderr);

        //if (!thisPassed) {
            System.err.println();
            System.err.println("\t\tScenario:" + scenario);
            System.err.println("\t\tGiven: testExhibitManagement is " + testExhibitManagement);
            System.err.println("\t\tWhen: getExhibitArtifactNames called with " + exhibitChoice);
            System.err.println("\t\tAnd: " + artifactManagement);
            System.err.println("\t\tThen: output is: \n" + ArraysMethods.toString(expectedResult));
            System.err.println("\t\tPassed: " + thisPassed);
            System.err.println("\t\tExpected Value:\n" + ArraysMethods.toString(expectedResult));
            System.err.println("\t\tGiven Value:\n" + ArraysMethods.toString(result));
            System.err.println();
        //}
        return thisPassed;

    }

    /**
     * Test for getExhibitArtifactMenu method
     * 
     * @param testExhibitManagement
     * @param exhibitChoice
     * @param artifactManagement
     * @param expectedResult
     * @param scenario
     * @return passed
     */
    public static boolean getExhibitArtifactMenuTestCase(ExhibitManagement testExhibitManagement, int exhibitChoice,
            ArtifactManagement artifactManagement, String expectedResult, String scenario) {
        String input = "1\n";
        InputStream stdin = System.in;
        ByteArrayInputStream s = new ByteArrayInputStream(input.getBytes());
        System.setIn(s);

        PrintStream stdout = System.out;
        ByteArrayOutputStream result = new ByteArrayOutputStream();
        System.setOut(new PrintStream(result));

        PrintStream sterr = System.out;
        ByteArrayOutputStream err = new ByteArrayOutputStream();
        System.setErr(new PrintStream(err));

        Menu exhibitMenu = testExhibitManagement.getExhibitArtifactMenu(exhibitChoice, artifactManagement);
        exhibitMenu.getUserChoice();
        boolean thisPassed = false;
        try {
            thisPassed = expectedResult.replaceAll("\\p{C}", "").trim()
                    .equals(result.toString("UTF-8").replaceAll("\\p{C}", "").trim());
        } catch (Exception e) {
            System.out.println(e);
        }

        System.setOut(stdout);
        System.setIn(stdin);
        System.setErr(sterr);

        //if (!thisPassed) {
            System.err.println();
            System.err.println("\t\tScenario:" + scenario);
            System.err.println("\t\tGiven: testExhibitManagement is " + testExhibitManagement);
            System.err.println("\t\tWhen: getExhibitArtifactMenu called");
            System.err.println("\t\tThen: display of getUserChoice is: \n" + expectedResult);
            System.err.println("\t\tPassed: " + thisPassed);
            System.err.println("\t\tExpected Value:\n" + expectedResult);
            System.err.println("\t\tGiven Value:\n" + result);
            System.err.println();
        //}
        return thisPassed;
    }

    /**
     * Test for getArtifactNumber method
     * 
     * @param testExhibitManagement
     * @param exhibitChoice
     * @param expectedResult
     * @param scenario
     * @return
     */
    public static boolean getArtifactNumberTestCase(ExhibitManagement testExhibitManagement, int exhibitChoice,
            int expectedResult, String scenario) {

        PrintStream sterr = System.out;
        ByteArrayOutputStream err = new ByteArrayOutputStream();
        System.setErr(new PrintStream(err));

        int result = testExhibitManagement.getArtifactNumber(exhibitChoice);
        boolean thisPassed = result == expectedResult;

        System.setErr(sterr);

        //if (!thisPassed) {
            System.err.println();
            System.err.println("\t\tScenario:" + scenario);
            System.err.println("\t\tGiven: testExhibitManagement is " + testExhibitManagement);
            System.err.println("\t\tWhen: getArtifactNumber called with " + exhibitChoice);
            System.err.println("\t\tThen: output is: \n" + expectedResult);
            System.err.println("\t\tPassed: " + thisPassed);
            System.err.println("\t\tExpected Value:\n" + expectedResult);
            System.err.println("\t\tGiven Value:\n" + result);
            System.err.println();
       // }
        return thisPassed;
    }

    /**
     * Test for getExhibitRoute method
     * 
     * @param testExhibitManagement
     * @param exhibitChoice
     * @param expectedResult
     * @param scenario
     * @return passed
     */
    public static boolean getExhibitRouteTestCase(ExhibitManagement testExhibitManagement, int exhibitChoice,
            ArrayList<String> expectedResult, String scenario) {
        PrintStream sterr = System.out;
        ByteArrayOutputStream err = new ByteArrayOutputStream();
        System.setErr(new PrintStream(err));

        ArrayList<String> result = testExhibitManagement.getExhibitRoute(exhibitChoice);
        boolean thisPassed = (result == null) ? (expectedResult == null) : (result.equals(expectedResult));

        System.setErr(sterr);

        //if (!thisPassed) {
            System.err.println();
            System.err.println("\t\tScenario:" + scenario);
            System.err.println("\t\tGiven: testExhibitManagement is " + testExhibitManagement);
            System.err.println("\t\tWhen: getExhibitRoute called with " + exhibitChoice);
            System.err.println("\t\tThen: output is: \n" + expectedResult);
            System.err.println("\t\tPassed: " + thisPassed);
            System.err.println("\t\tExpected Value:\n" + expectedResult);
            System.err.println("\t\tGiven Value:\n" + result);
            System.err.println();
        //}
        return thisPassed;
    }

    /**
     * Test for getExhibitArtifacts method
     * 
     * @param testExhibitManagement
     * @param exhibitChoice
     * @param expectedResult
     * @param scenario
     * @return passed
     */
    public static boolean getExhibitArtifactsTestCase(ExhibitManagement testExhibitManagement, int exhibitChoice,
            ArrayList<Integer> expectedResult, String scenario) {
        PrintStream sterr = System.out;
        ByteArrayOutputStream err = new ByteArrayOutputStream();
        System.setErr(new PrintStream(err));

        ArrayList<Integer> result = testExhibitManagement.getExhibitArtifacts(exhibitChoice);
        boolean thisPassed = (result == null) ? (expectedResult == null) : (result.equals(expectedResult));

        System.setErr(sterr);

        //if (!thisPassed) {
            System.err.println();
            System.err.println("\t\tScenario:" + scenario);
            System.err.println("\t\tGiven: testExhibitManagement is " + testExhibitManagement);
            System.err.println("\t\tWhen: getExhibitArtifacts called with " + exhibitChoice);
            System.err.println("\t\tThen: output is: \n" + expectedResult);
            System.err.println("\t\tPassed: " + thisPassed);
            System.err.println("\t\tExpected Value:\n" + expectedResult);
            System.err.println("\t\tGiven Value:\n" + result);
            System.err.println();
       // }
        return thisPassed;
    }

    /**
     * Test for getExhibitArtifactsByID method
     * 
     * @param testExhibitManagement
     * @param exhibitChoice
     * @param expectedResult
     * @param scenario
     * @return passed
     */
    public static boolean getExhibitArtifactsByIDTestCase(ExhibitManagement testExhibitManagement, int exhibitChoice,
            ArrayList<Integer> expectedResult, String scenario) {
        PrintStream sterr = System.out;
        ByteArrayOutputStream err = new ByteArrayOutputStream();
        System.setErr(new PrintStream(err));

        ArrayList<Integer> result = testExhibitManagement.getExhibitArtifactsByID(exhibitChoice);
        boolean thisPassed = (result == null) ? (expectedResult == null) : (result.equals(expectedResult));

        System.setErr(sterr);

       // if (!thisPassed) {
            System.err.println();
            System.err.println("\t\tScenario:" + scenario);
            System.err.println("\t\tGiven: testExhibitManagement is " + testExhibitManagement);
            System.err.println("\t\tWhen: getExhibitArtifactsByID called with " + exhibitChoice);
            System.err.println("\t\tThen: output is: \n" + expectedResult);
            System.err.println("\t\tPassed: " + thisPassed);
            System.err.println("\t\tExpected Value:\n" + expectedResult);
            System.err.println("\t\tGiven Value:\n" + result);
            System.err.println();
       // }
        return thisPassed;
    }

    /**
     * Test for updateExhibitMethod
     * 
     * @param testExhibitManagement
     * @param exhibitChoice
     * @param exhibitName
     * @param exhibitArtifacts
     * @param exhibitRoute
     * @param expectedResult
     * @param scenario
     * @return passed
     */
    public static boolean updateExhibitTestCase(ExhibitManagement testExhibitManagement, int exhibitChoice,
            String exhibitName, ArrayList<Integer> exhibitArtifacts, ArrayList<String> exhibitRoute,
            boolean expectedResult, String scenario) {

        PrintStream sterr = System.out;
        ByteArrayOutputStream err = new ByteArrayOutputStream();
        System.setErr(new PrintStream(err));

        boolean result = testExhibitManagement.updateExhibit(exhibitChoice, exhibitName, exhibitArtifacts,
                exhibitRoute);
        boolean thisPassed = result == expectedResult;

        System.setErr(sterr);

       // if (!thisPassed) {
            System.err.println();
            System.err.println("\t\tScenario:" + scenario);
            System.err.println("\t\tGiven: testExhibitManagement is " + testExhibitManagement);
            System.err.println("\t\tWhen: updateExhibit called with " + exhibitChoice);
            System.err.println("\t\tAnd: " + exhibitName);
            System.err.println("\t\tAnd: " + exhibitArtifacts);
            System.err.println("\t\tAnd: " + exhibitRoute);
            System.err.println("\t\tThen: output is: \n" + expectedResult);
            System.err.println("\t\tPassed: " + thisPassed);
            System.err.println("\t\tExpected Value:\n" + expectedResult);
            System.err.println("\t\tGiven Value:\n" + result);
            System.err.println();
       // }
        return thisPassed;
    }

    /**
     * Test for removeArtifactsWithID method
     * 
     * @param testExhibitManagement
     * @param artifactID
     * @param exhibitChoice
     * @param artifactManagement
     * @param expectedResult
     * @param scenario
     * @return passed
     */
    public static boolean removeArtifactsWithIDTestCase(ExhibitManagement testExhibitManagement, int artifactID,
            int exhibitChoice, ArtifactManagement artifactManagement, ArrayList<Integer> expectedResult,
            String scenario) {
        testExhibitManagement.removeArtifactsWithID(artifactID);

        PrintStream stdout = System.out;
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setErr(new PrintStream(output));

        ArrayList<Integer> result = testExhibitManagement.getExhibitArtifacts(exhibitChoice);

        boolean thisPassed = result.equals(expectedResult);

        System.setErr(stdout);

       // if (!thisPassed) {
            System.err.println();
            System.err.println("\t\tScenario:" + scenario);
            System.err.println("\t\tGiven: testExhibitManagement is " + testExhibitManagement);
            System.err.println("\t\tWhen: removeArtifactsWithID called with " + artifactID);
            System.err.println("\t\tThen: output of getExhibitArtifacts with: \n" + exhibitChoice);
            System.err.println("\t\tis: " + expectedResult);
            System.err.println("\t\tPassed: " + thisPassed);
            System.err.println("\t\tExpected Value:\n" + expectedResult);
            System.err.println("\t\tGiven Value:\n" + result);
            System.err.println();
       // }
        return thisPassed;

    }

    /**
     * Test for getExhibitionExhibtNames method that uses 1D arrays
     * 
     * @param testExhibitManagement
     * @param exhibitIDs
     * @param expectedResult
     * @param scenario
     * @return passed
     */
    public static boolean getExhibitionExhibtNamesTestCase(ExhibitManagement testExhibitManagement, int[] exhibitIDs,
            String[] expectedResult, String scenario) {
        String[] result = testExhibitManagement.getExhibitionExhibtNames(exhibitIDs);
        boolean thisPassed = ArraysMethods.equals(expectedResult, result);

       // if (!thisPassed) {
            System.err.println();
            System.err.println("\t\tScenario:" + scenario);
            System.err.println("\t\tGiven: testExhibitManagement is " + testExhibitManagement);
            System.err.println("\t\tWhen: getExhibitionExhibtNames called with " + ArraysMethods.toString(exhibitIDs));
            System.err.println("\t\tThen: output is: \n" + ArraysMethods.toString(expectedResult));
            System.err.println("\t\tPassed: " + thisPassed);
            System.err.println("\t\tExpected Value:\n" + ArraysMethods.toString(expectedResult));
            System.err.println("\t\tGiven Value:\n" + ArraysMethods.toString(result));
            System.err.println();
       // }
        return thisPassed;
    }

    /**
     * Test for getExhibitionExhibtNames method that uses 2D arrays
     * 
     * @param testExhibitManagement
     * @param exhibitIDs
     * @param expectedResult
     * @param scenario
     * @return
     */
    public static boolean getExhibitionExhibtNamesTestCase(ExhibitManagement testExhibitManagement, int[][] exhibitIDs,
            String[][] expectedResult, String scenario) {
        String[][] result = testExhibitManagement.getExhibitionExhibtNames(exhibitIDs);
        boolean thisPassed = ArraysMethods.deepEquals(expectedResult, result);

        //if (!thisPassed) {
            System.err.println();
            System.err.println("\t\tScenario:" + scenario);
            System.err.println("\t\tGiven: testExhibitManagement is " + testExhibitManagement);
            System.err.println("\t\tWhen: getExhibitionExhibtNames called with " + ArraysMethods.deepToString(exhibitIDs));
            System.err.println("\t\tThen: output is: \n" + ArraysMethods.deepToString(expectedResult));
            System.err.println("\t\tPassed: " + thisPassed);
            System.err.println("\t\tExpected Value:\n" + ArraysMethods.deepToString(expectedResult));
            System.err.println("\t\tGiven Value:\n" + ArraysMethods.deepToString(result));
            System.err.println();
       // }
        return thisPassed;
    }

    /**
     * Test for findExhibit method that the Exhibit
     * 
     * @param testExhibitManagement
     * @param exhibitID
     * @param expectedResult
     * @param scenario
     * @return
     */
    public static boolean findExhibitTestCase(ExhibitManagement testExhibitManagement, int exhibitID,
            Exhibit expectedResult, String scenario) {
        boolean thisPassed = false;
        String result = "";
        try {
            Exhibit resultRaw = testExhibitManagement.findExhibit(exhibitID);
            result = resultRaw.toString();
            thisPassed = resultRaw.getID() == expectedResult.getID()
                    && resultRaw.getName() == expectedResult.getName()
                    && resultRaw.getArtifactsID().equals(expectedResult.getArtifactsID())
                    && resultRaw.getRoute().equals(expectedResult.getRoute());
        } catch (Exception e) {
            result = e.getMessage();
        }

        //if (!thisPassed) {
            System.err.println();
            System.err.println("\t\tScenario:" + scenario);
            System.err.println("\t\tGiven: testExhibitManagement is " + testExhibitManagement);
            System.err.println("\t\tWhen: findExhibit called with " + exhibitID);
            System.err.println("\t\tThen: output is: \n" + expectedResult);
            System.err.println("\t\tPassed: " + thisPassed);
            System.err.println("\t\tExpected Value:\n" + exhibitID);
            System.err.println("\t\tGiven Value:\n" + result);
            System.err.println();
        //}
        return thisPassed;
    }

    /**
     * Test for findExhibit method that compares exception message
     * 
     * @param testExhibitManagement
     * @param exhibitID
     * @param expectedResult
     * @param scenario
     * @return
     */
    public static boolean findExhibitTestCase(ExhibitManagement testExhibitManagement, int exhibitID,
            String expectedResult, String scenario) {
        boolean thisPassed = false;
        String result = "";
        try {
            Exhibit resultRaw = testExhibitManagement.findExhibit(exhibitID);
            result = resultRaw.toString();
        } catch (Exception e) {
            result = e.getMessage();
            thisPassed = result.equals(expectedResult);
        }

      //  if (!thisPassed) {
            System.err.println();
            System.err.println("\t\tScenario:" + scenario);
            System.err.println("\t\tGiven: testExhibitManagement is " + testExhibitManagement);
            System.err.println("\t\tWhen: findExhibit called with " + exhibitID);
            System.err.println("\t\tThen: output is: \n" + expectedResult);
            System.err.println("Passed: " + thisPassed);
            System.err.println("\t\tExpected Value:\n" + expectedResult);
            System.err.println("\t\tGiven Value:\n" + result);
            System.err.println();
      //  }
        return thisPassed;
    }

    /**
     * Test for getExhibitID method that the Exhibit
     * 
     * @param testExhibitManagement
     * @param exhibitChoice
     * @param expectedResult
     * @param scenario
     * @return
     */
    public static boolean getExhibitIDTestCase(ExhibitManagement testExhibitManagement, int exhibitChoice,
            int expectedResult, String scenario) {

        PrintStream stdout = System.out;
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setErr(new PrintStream(output));

        boolean thisPassed = false;

        int result = testExhibitManagement.getExhibitID(exhibitChoice);
        thisPassed = result == expectedResult;

        System.setErr(stdout);

        //if (!thisPassed) {
            System.err.println();
            System.err.println("\t\tScenario:" + scenario);
            System.err.println("\t\tGiven: testExhibitManagement is " + testExhibitManagement);
            System.err.println("\t\tWhen: getExhibitID called with " + exhibitChoice);
            System.err.println("\t\tThen: output is: \n" + expectedResult);
            System.err.println("\t\tPassed: " + thisPassed);
            System.err.println("\t\tExpected Value:\n" + expectedResult);
            System.err.println("\t\tGiven Value:\n" + result);
            System.err.println();
       // }
        return thisPassed;
    }

    /**
     * Test for anyDuplicateArtifacts that takes a 1D array
     * @param testExhibitManagement
     * @param exhibits
     * @param expectedResult
     * @param scenario
     * @return
     */
    public static boolean anyDuplicateArtifactsTestCase(ExhibitManagement testExhibitManagement, int[] exhibits,
            boolean expectedResult, String scenario){
        
        boolean result = testExhibitManagement.anyDuplicateArtifcats(exhibits);
        boolean thisPassed = result == expectedResult;

        //if (!thisPassed) {
            System.err.println();
            System.err.println("\t\tScenario:" + scenario);
            System.err.println("\t\tGiven: testExhibitManagement is " + testExhibitManagement);
            System.err.println("\t\tWhen: anyDuplicateArtifcats called with " + ArraysMethods.toString(exhibits));
            System.err.println("\t\tThen: output is: \n" + expectedResult);
            System.err.println("\t\tPassed: " + thisPassed);
            System.err.println("\t\tExpected Value:\n" + expectedResult);
            System.err.println("\t\tGiven Value:\n" + result);
            System.err.println();
       // }
        return thisPassed;
    }

    /**
     * Test for anyDuplicateArtifacts that takes a 1D array and a new exhibit ID and location
     * @param testExhibitManagement
     * @param exhibits
     * @param expectedResult
     * @param scenario
     * @return
     */
    public static boolean anyDuplicateArtifactsTestCase(ExhibitManagement testExhibitManagement, int[] exhibits, int newExhibit, int newExhibitLoc,
            boolean expectedResult, String scenario){
        
        boolean result = testExhibitManagement.anyDuplicateArtifcats(exhibits);
        boolean thisPassed = result == expectedResult;

        //if (!thisPassed) {
            System.err.println();
            System.err.println("\t\tScenario:" + scenario);
            System.err.println("\t\tGiven: testExhibitManagement is " + testExhibitManagement);
            System.err.println("\t\tWhen: anyDuplicateArtifcats called with " + ArraysMethods.toString(exhibits));
            System.err.println("\t\tThen: output is: \n" + expectedResult);
            System.err.println("\t\tPassed: " + thisPassed);
            System.err.println("\t\tExpected Value:\n" + expectedResult);
            System.err.println("\t\tGiven Value:\n" + result);
            System.err.println();
        //}
        return thisPassed;
    }
}
