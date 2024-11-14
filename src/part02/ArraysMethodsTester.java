package part02;

import part01.ArraysMethods;

public class ArraysMethodsTester {
    public static void main(String[] args) {
        boolean allPassed = true;
        allPassed &= testStringtoString();
        allPassed &= testIntToString();
        allPassed&= testStringEquals();
        System.out.println("All Features Passed: " + allPassed);
    }

    public static boolean testStringtoString() {

        System.out.println("Feature: String[] to String");
        boolean allPassed = true;

        {
            String[] testStringArr = { "This", "is", "a", "test", "string" };
            String expectedResult = "[This, is, a, test, string]";
            String scenario = "normal array";
            allPassed &= stringToStringTestCase(testStringArr, expectedResult, scenario);
        }

        {
            String[] testStringArr = {};
            String expectedResult = "[]";
            String scenario = "empty array";
            allPassed &= stringToStringTestCase(testStringArr, expectedResult, scenario);
        }

        System.out.println("Feature Passed: " + allPassed);
        System.out.println();
        return allPassed;

    }

    public static boolean stringToStringTestCase(String[] testStringArr, String expectedResult, String scenario) {
        boolean thisPassed = ArraysMethods.toString(testStringArr).equals(expectedResult);

        if (!thisPassed) {
            System.out.println();
            System.out.println("Scenario: "+scenario);
            System.out.println("Given: array is " + ArraysMethods.toString(testStringArr));
            System.out.println("When: toString is called");
            System.out.println("Then: result is " + expectedResult);
            System.out.println("Passed: " + thisPassed);
            System.out.println("Expected Value: " + expectedResult);
            System.out.println("Given Value: " + ArraysMethods.toString(testStringArr));
            System.out.println();
        }

        return thisPassed;
    }

    public static boolean testIntToString(){
        System.out.println("Feature: int[] to String");
        boolean allPassed = true;

        {
            int[] testIntArr = { 1, 2, 3, 10, -1, 0 };
            String expectedResult = "[1, 2, 3, 10, -1, 0]";
            String scenario = "normal array";
            allPassed &= intToStringTestCase(testIntArr, expectedResult, scenario);
        }

        {
            int[] testIntArr = {};
            String expectedResult = "[]";
            String scenario = "empty array";
            allPassed &= intToStringTestCase(testIntArr, expectedResult, scenario);
        }

        System.out.println("Feature Passed: " + allPassed);
        System.out.println();
        return allPassed;
    }

    public static boolean intToStringTestCase(int[] testIntArr, String expectedResult, String scenario) {
        boolean thisPassed = ArraysMethods.toString(testIntArr).equals(expectedResult);

        if (!thisPassed) {
            System.out.println();
            System.out.println("Scenario: "+scenario);
            System.out.println("Given: array is " + ArraysMethods.toString(testIntArr));
            System.out.println("When: toString is called");
            System.out.println("Then: result is " + expectedResult);
            System.out.println("Passed: " + thisPassed);
            System.out.println("Expected Value: " + expectedResult);
            System.out.println("Given Value: " + ArraysMethods.toString(testIntArr));
            System.out.println();
        }

        return thisPassed;
    }

    public static boolean testStringEquals(){
        System.out.println("Feature: int[] to String");
        boolean allPassed = true;

        {
            String[] testStringArr1 = { "This", "is", "a", "test", "string" };
            String[] testStringArr2 = { "This", "is", "a", "test", "string" };
            boolean expectedResult = true;
            String scenario = "normal test";

            allPassed &= stringEqualsTestCase(testStringArr1, testStringArr2, expectedResult, scenario);
        }

        {
            String[] testStringArr1 = {  };
            String[] testStringArr2 = {  };
            boolean expectedResult = true;
            String scenario = "both arrays are empty";

            allPassed &= stringEqualsTestCase(testStringArr1, testStringArr2, expectedResult, scenario);
        }

        {
            String[] testStringArr1 = { "This", "is", "a", "test", "string" };
            String[] testStringArr2 = { "This", "is", "not", "a", "test", "string" };
            boolean expectedResult = false;
            String scenario = "Arrays are not equal";

            allPassed &= stringEqualsTestCase(testStringArr1, testStringArr2, expectedResult, scenario);
        }

        System.out.println("Feature Passed: " + allPassed);
        System.out.println();
        return allPassed;
    }

    public static boolean stringEqualsTestCase(String[] testStringArr1, String[] testStringArr2, boolean expectedResult, String scenario){
        boolean thisPassed = ArraysMethods.equals(testStringArr1, testStringArr2) == expectedResult;

        if (!thisPassed) {
            System.out.println();
            System.out.println("Scenario: "+scenario);
            System.out.println("Given: array 1 is " + ArraysMethods.toString(testStringArr1));
            System.out.println("Given: array 2 is " + ArraysMethods.toString(testStringArr2));
            System.out.println("When: toString is called");
            System.out.println("Then: result is " + expectedResult);
            System.out.println("Passed: " + thisPassed);
            System.out.println("Expected Value: " + expectedResult);
            System.out.println("Given Value: " + ArraysMethods.equals(testStringArr1, testStringArr2));
            System.out.println();
        }

        return thisPassed;
    }
}
