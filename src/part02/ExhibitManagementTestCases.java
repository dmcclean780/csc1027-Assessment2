package part02;

import java.util.ArrayList;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

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

        if (!thisPassed) {
            System.err.println();
            System.err.println("Scenario:" + scenario);
            System.err.println("When: new ExhibitManagement() called");
            System.err.println("Then: output of getExhibitArray() is:\n" + ArraysMethods.toString(expectedResult));
            System.err.println("Passed: " + thisPassed);
            System.err.println("Expected Value:\n" + expectedResult);
            System.err.println("Given Value:\n" + result);
            System.err.println();
        }
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

        if (!thisPassed) {
            System.err.println();
            System.err.println("Scenario:" + scenario);
            System.err.println("When: new ExhibitManagement() called");
            System.err.println("Then: output of getExhibits() is:\n" + expectedResult);
            System.err.println("Passed: " + thisPassed);
            System.err.println("Expected Value:\n" + expectedResult);
            System.err.println("Given Value:\n" + result);
            System.err.println();
        }
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

        if (!thisPassed) {
            System.err.println();
            System.err.println("Scenario:" + scenario);
            System.err.println("When: new ExhibitManagement() called with " + exhibitManagementData);
            System.err.println("Then: output of getExhibitArray() is:\n" + ArraysMethods.toString(expectedResult));
            System.err.println("Passed: " + thisPassed);
            System.err.println("Expected Value:\n" + expectedResult);
            System.err.println("Given Value:\n" + result);
            System.err.println();
        }
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

        if (!thisPassed) {
            System.err.println();
            System.err.println("Scenario:" + scenario);
            System.err.println("When: new ExhibitManagement() called with " + exhibitManagementData);
            System.err.println("Then: output of getExhibits() is:\n" + expectedResult);
            System.err.println("Passed: " + thisPassed);
            System.err.println("Expected Value:\n" + expectedResult);
            System.err.println("Given Value:\n" + result);
            System.err.println();
        }
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

        if (!thisPassed) {
            System.err.println();
            System.err.println("Scenario:" + scenario);
            System.err.println("When: new ExhibitManagement() called with " + exhibitManagementData);
            System.err.println("Then: output of getExhibits() is:\n" + expectedResult);
            System.err.println("Passed: " + thisPassed);
            System.err.println("Expected Value:\n" + expectedResult);
            System.err.println("Given Value:\n" + result);
            System.err.println();
        }
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

        if (!thisPassed) {
            System.err.println();
            System.err.println("Scenario:" + scenario);
            System.err.println("Given: testArtifactManagement is " + testExhibitManagement);
            System.err.println("When: getArtifactArrayLength called");
            System.err.println("Then: output is:\n" + expectedResult);
            System.err.println("Passed: " + thisPassed);
            System.err.println("Expected Value:\n" + expectedResult);
            System.err.println("Given Value:\n" + result);
            System.err.println();
        }
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

        if (!thisPassed) {
            System.err.println();
            System.err.println("Scenario:" + scenario);
            System.err.println("Given: testExhibitManagement is " + testExhibitName);
            System.err.println("When: addExhibit called with " + testExhibitName);
            System.err.println("And: " + testExhibitArtifacts);
            System.err.println("And: " + testExhibitRoute);
            System.err.println("Then: output is:\n" + expectedResult);
            System.err.println("Passed: " + thisPassed);
            System.err.println("Expected Value:\n" + expectedResult);
            System.err.println("Given Value:\n" + result);
            System.err.println();
        }
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

        Menu artifactMenu = testExhibitManagement.exhibitsMenu();
        artifactMenu.getUserChoice();
        boolean thisPassed = false;
        try {
            thisPassed = expectedResult.trim().equals(result.toString("UTF-8").trim());
        } catch (Exception e) {
            System.out.println(e);
        }

        System.setOut(stdout);
        System.setIn(stdin);

        if (!thisPassed) {
            System.err.println();
            System.err.println("Scenario:" + scenario);
            System.err.println("Given: testExhibitManagement is " + testExhibitManagement);
            System.err.println("When: exhibitsMenu called");
            System.err.println("Then: display of getUserChoice is: \n" + expectedResult);
            System.err.println("Passed: " + thisPassed);
            System.err.println("Expected Value:\n" + expectedResult);
            System.err.println("Given Value:\n" + result);
            System.err.println();
        }
        return thisPassed;
    }

   /**
    * Test for exhibitsToArray
    * @param testExhibitManagement
    * @param expectedResult
    * @param scenario
    * @return
    */
    public static boolean exhibitsToArrayTestCase(ExhibitManagement testExhibitManagement, Exhibit[] expectedResult,
            String scenario) {

        Exhibit[] result = testExhibitManagement.exhibitsToArray();
        boolean thisPassed = ArraysMethods.equals(expectedResult, result);

        if (!thisPassed) {
            System.err.println();
            System.err.println("Scenario:" + scenario);
            System.err.println("Given: testExhibitManagement is " + testExhibitManagement);
            System.err.println("When: exhibitsToArray called");
            System.err.println("Then: output is: \n" + ArraysMethods.toString(expectedResult));
            System.err.println("Passed: " + thisPassed);
            System.err.println("Expected Value:\n" + ArraysMethods.toString(expectedResult));
            System.err.println("Given Value:\n" + ArraysMethods.toString(result));
            System.err.println();
        }
        return thisPassed;
    }

    /**
     * Test for exhibitsToArray static version
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

        if (!thisPassed) {
            System.err.println();
            System.err.println("Scenario:" + scenario);
            System.err.println("Given: testExhibitManagement is " + testExhibitManagement);
            System.err.println("When: exhibitsToArray called");
            System.err.println("Then: output is: \n" + ArraysMethods.toString(expectedResult));
            System.err.println("Passed: " + thisPassed);
            System.err.println("Expected Value:\n" + ArraysMethods.toString(expectedResult));
            System.err.println("Given Value:\n" + ArraysMethods.toString(result));
            System.err.println();
        }
        return thisPassed;
    }

}
