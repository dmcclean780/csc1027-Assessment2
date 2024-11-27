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
    
        //if (!thisPassed) {
            System.err.println();
            System.err.println("\t\tScenario:" + scenario);
            System.err.println("\t\tGiven: given id is " + givenID);
            System.err.println("\t\tWhen: Months.get() called with " + givenID);
            System.err.println("\t\tThen: m is " + expectedResult);
            System.err.println("\t\tPassed: " + thisPassed);
            System.err.println("\t\tExpected Value: " + expectedResult);
            System.err.println("\t\tGiven Value: " + result);
            System.err.println();
        //}
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
    
        //if (!thisPassed) {
            System.err.println();
            System.err.println("\t\tScenario:" + scenario);
            System.err.println("\t\tGiven: given id is " + givenString);
            System.err.println("\t\tWhen: Months.get() called with " + givenString);
            System.err.println("\t\tThen: m is " + expectedResult);
            System.err.println("\t\tPassed: " + thisPassed);
            System.err.println("\t\tExpected Value: " + expectedResult);
            System.err.println("\t\tGiven Value: " + result);
            System.err.println();
        //}
        return thisPassed;
    }
    
}
