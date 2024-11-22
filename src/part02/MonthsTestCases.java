package part02;

import part01.Months;

public class MonthsTestCases {

    /**
     * Test for get with an id
     * @param givenID
     * @param expectedResult
     * @param scenario
     * @return passed
     */
    public static boolean getbyIDTestCase(int givenID, Months expectedResult, String scenario) {
        Months result = Months.get(givenID);
        boolean thisPassed = result == expectedResult;
    
        if (!thisPassed) {
            System.err.println();
            System.err.println("Scenario:" + scenario);
            System.err.println("Given: given id is " + givenID);
            System.err.println("When: Months.get() called with " + givenID);
            System.err.println("Then: m is " + expectedResult);
            System.err.println("Passed: " + thisPassed);
            System.err.println("Expected Value: " + expectedResult);
            System.err.println("Given Value: " + result);
            System.err.println();
        }
        return thisPassed;
    }

    /**
     * Test for get by a name
     * @param givenString
     * @param expectedResult
     * @param scenario
     * @return passed
     */
    public static boolean getbyStringTestCase(String givenString, Months expectedResult, String scenario) {
        Months result = Months.get(givenString);
        boolean thisPassed = result == expectedResult;
    
        if (!thisPassed) {
            System.err.println();
            System.err.println("Scenario:" + scenario);
            System.err.println("Given: given id is " + givenString);
            System.err.println("When: Months.get() called with " + givenString);
            System.err.println("Then: m is " + expectedResult);
            System.err.println("Passed: " + thisPassed);
            System.err.println("Expected Value: " + expectedResult);
            System.err.println("Given Value: " + result);
            System.err.println();
        }
        return thisPassed;
    }
    
}
