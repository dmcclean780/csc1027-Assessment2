package part02;

import java.util.ArrayList;

import part01.Utils;

public class UtilsTestCases {

    /**
     * Test for contains with int arrays
     * @param testArray
     * @param searchInt
     * @param expectedResult
     * @param scenario
     * @return passed
     */
    public static boolean containsTestCase(int[] testArray, int searchInt, boolean expectedResult,
            String scenario) {
    
        boolean result = Utils.contains(searchInt, testArray);
        boolean thisPassed = result == expectedResult;
    
        if (!thisPassed) {
            System.err.println();
            System.err.println("Scenario: " + scenario);
            System.err.println("Given: list is " + ArraysMethods.toString(testArray));
            System.err.println("And: search term is " + searchInt);
            System.err.println("When: contains() is called");
            System.err.println("Then: result is " + expectedResult);
            System.err.println("Passed: " + thisPassed);
            System.err.println("Expected Value: " + expectedResult);
            System.err.println("Given Value: " + result);
            System.err.println();
        }
    
        return thisPassed;
    }

    /**
     * Test for contains with Integer ArrayLists
     * @param testArrayList
     * @param searchInt
     * @param expectedResult
     * @param scenario
     * @return passed
     */
    public static boolean containsTestCase(ArrayList<Integer> testArrayList, int searchInt, boolean expectedResult,
            String scenario) {
    
        boolean result = Utils.contains(searchInt, testArrayList);
        boolean thisPassed = result == expectedResult;
    
        if (!thisPassed) {
            System.err.println();
            System.err.println("Scenario: " + scenario);
            System.err.println("Given: list is " + testArrayList);
            System.err.println("And: search term is " + searchInt);
            System.err.println("When: contains() is called");
            System.err.println("Then: result is " + expectedResult);
            System.err.println("Passed: " + thisPassed);
            System.err.println("Expected Value: " + expectedResult);
            System.err.println("Given Value: " + result);
            System.err.println();
        }
    
        return thisPassed;
    }

    /**
     * Test for concat with String arrays
     * @param testArr1
     * @param testArr2
     * @param expectedResult
     * @param scenario
     * @return passed
     */
    public static boolean stringConcatTestCase(String[] testArr1, String[] testArr2, String[] expectedResult,
            String scenario) {
    
        String[] result = Utils.concat(testArr1, testArr2);
        boolean thisPassed = ArraysMethods.equals(result, expectedResult);
    
        if (!thisPassed) {
            System.err.println();
            System.err.println("Scenario: " + scenario);
            System.err.println("Given: array 1 is " + ArraysMethods.toString(testArr1));
            System.err.println("And: array 2 is " + ArraysMethods.toString(testArr2));
            System.err.println("When: toString is called");
            System.err.println("Then: result is " + ArraysMethods.toString(expectedResult));
            System.err.println("Passed: " + thisPassed);
            System.err.println("Expected Value: " + ArraysMethods.toString(expectedResult));
            System.err.println("Given Value: " + ArraysMethods.toString(result));
            System.err.println();
        }
    
        return thisPassed;
    }
    
}
