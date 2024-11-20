package part02;

import part01.ArraysMethods;

public class ArraysMethodsTester {
    public static void main(String[] args) {
        boolean allPassed = true;
        System.out.println("Class in Test: ArraysMethods");
        System.out.println();
        allPassed &= testStringtoString();
        allPassed &= testIntToString();
        allPassed &= testStringEquals();
        System.out.println("All Features Passed: " + allPassed);
    }

    /**
     * Test String[] toString()
     * 
     * @return all tests passed
     */
    public static boolean testStringtoString() {

        System.out.println("\tFeature: String[] to String");
        boolean allPassed = true;

        /**
         * normal array
         */
        {
            String[] testStringArr = { "This", "is", "a", "test", "string" };
            String expectedResult = "[\"This\", \"is\", \"a\", \"test\", \"string\"]";
            String scenario = "normal array";
            allPassed &= stringToStringTestCase(testStringArr, expectedResult, scenario);
        }

        /**
         * empty array
         */
        {
            String[] testStringArr = {};
            String expectedResult = "[]";
            String scenario = "empty array";
            allPassed &= stringToStringTestCase(testStringArr, expectedResult, scenario);
        }

        /**
         * null
         */
        {
            String[] testStringArr = null;
            String expectedResult = "null";
            String scenario = "null";
            allPassed &= stringToStringTestCase(testStringArr, expectedResult, scenario);
        }

        /**
         * null array
         */
        {
            String[] testStringArr = { null, null, null };
            String expectedResult = "[null, null, null]";
            String scenario = "array of null";
            allPassed &= stringToStringTestCase(testStringArr, expectedResult, scenario);
        }

        /**
         * null and String mix
         */
        {
            String[] testStringArr = { null, "test", null, "array", null, "string" };
            String expectedResult = "[null, \"test\", null, \"array\", null, \"string\"]";
            String scenario = "array of null";
            allPassed &= stringToStringTestCase(testStringArr, expectedResult, scenario);
        }

        System.out.println("\tFeature Passed: " + allPassed);
        System.out.println();
        return allPassed;

    }

    /**
     * test int toString()
     * 
     * @return all tests passed
     */
    public static boolean testIntToString() {
        System.out.println("\tFeature: int[] to String");
        boolean allPassed = true;

        /**
         * normal array
         */
        {
            int[] testIntArr = { 1, 2, 3, 10, -1, 0 };
            String expectedResult = "[1, 2, 3, 10, -1, 0]";
            String scenario = "normal array";
            allPassed &= intToStringTestCase(testIntArr, expectedResult, scenario);
        }

        /**
         * empty array
         */
        {
            int[] testIntArr = {};
            String expectedResult = "[]";
            String scenario = "empty array";
            allPassed &= intToStringTestCase(testIntArr, expectedResult, scenario);
        }

        /**
         * null
         */
        {
            int[] testIntArr = null;
            String expectedResult = "null";
            String scenario = "empty array";
            allPassed &= intToStringTestCase(testIntArr, expectedResult, scenario);
        }

        System.out.println("\tFeature Passed: " + allPassed);
        System.out.println();
        return allPassed;
    }

    /**
     * Test suit for the equals method for string arrays
     * @return all tests passed
     */
    public static boolean testStringEquals() {
        System.out.println("\tFeature: int[] to String");
        boolean allPassed = true;

        /**
         * normal arrays
         */
        {
            String[] testStringArr1 = { "This", "is", "a", "test", "string" };
            String[] testStringArr2 = { "This", "is", "a", "test", "string" };
            boolean expectedResult = true;
            String scenario = "normal test";

            allPassed &= stringEqualsTestCase(testStringArr1, testStringArr2, expectedResult, scenario);
        }

        /**
         * empty arrays
         */
        {
            String[] testStringArr1 = {};
            String[] testStringArr2 = {};
            boolean expectedResult = true;
            String scenario = "both arrays are empty";

            allPassed &= stringEqualsTestCase(testStringArr1, testStringArr2, expectedResult, scenario);
        }

        /**
         * not equal length arrays
         */
        {
            String[] testStringArr1 = { "This", "is", "a", "test", "string" };
            String[] testStringArr2 = { "This", "is", "not", "a", "test", "string" };
            boolean expectedResult = false;
            String scenario = "Arrays are not equal length";

            allPassed &= stringEqualsTestCase(testStringArr1, testStringArr2, expectedResult, scenario);
        }

        /**
         * not equal arrays
         */
        {
            String[] testStringArr1 = { "This", "is", "a", "test", "string" };
            String[] testStringArr2 = { "This", "is", "not", "a", "string" };
            boolean expectedResult = false;
            String scenario = "Arrays are not equal of same length";

            allPassed &= stringEqualsTestCase(testStringArr1, testStringArr2, expectedResult, scenario);
        }

        /**
         * null array and normal array
         */
        {
            String[] testStringArr1 = null;
            String[] testStringArr2 = { "This", "is", "a", "test", "string" };
            boolean expectedResult = false;
            String scenario = "null array and normal array";

            allPassed &= stringEqualsTestCase(testStringArr1, testStringArr2, expectedResult, scenario);
        }

        /**
         * null array and empty array
         */
        {
            String[] testStringArr1 = null;
            String[] testStringArr2 = {};
            boolean expectedResult = false;
            String scenario = "null and empty array";

            allPassed &= stringEqualsTestCase(testStringArr1, testStringArr2, expectedResult, scenario);
        }

        /**
         * noramal array and null
         */
        {
            String[] testStringArr1 = { "This", "is", "a", "test", "string" };
            String[] testStringArr2 = null;
            boolean expectedResult = false;
            String scenario = "normal array and null";

            allPassed &= stringEqualsTestCase(testStringArr1, testStringArr2, expectedResult, scenario);
        }

        /**
         * empty array and null
         */
        {
            String[] testStringArr1 = {};
            String[] testStringArr2 = null;
            boolean expectedResult = false;
            String scenario = "empty array and null";

            allPassed &= stringEqualsTestCase(testStringArr1, testStringArr2, expectedResult, scenario);
        }

        /**
         * both null
         */
        {
            String[] testStringArr1 = null;
            String[] testStringArr2 = null;
            boolean expectedResult = true;
            String scenario = "both null";

            allPassed &= stringEqualsTestCase(testStringArr1, testStringArr2, expectedResult, scenario);
        }

        /**
         * both array of nulls
         */
        {
            String[] testStringArr1 = { null, null, null };
            String[] testStringArr2 = { null, null, null };
            boolean expectedResult = true;
            String scenario = "both arrays of null";

            allPassed &= stringEqualsTestCase(testStringArr1, testStringArr2, expectedResult, scenario);
        }

        /**
         * arrays of nulls of different length
         */
        {
            String[] testStringArr1 = { null, null, null };
            String[] testStringArr2 = { null, null, null, null };
            boolean expectedResult = false;
            String scenario = "both arrays of null of different length";

            allPassed &= stringEqualsTestCase(testStringArr1, testStringArr2, expectedResult, scenario);
        }

        /**
         * array of nulls and normal array
         */
        {
            String[] testStringArr1 = { null, null, null };
            String[] testStringArr2 = { "This", "is", "a", "test", "string" };
            boolean expectedResult = false;
            String scenario = "array of null and normal array";

            allPassed &= stringEqualsTestCase(testStringArr1, testStringArr2, expectedResult, scenario);
        }

        /**
         * normal array and array of nulls
         */
        {
            String[] testStringArr1 = { "This", "is", "a", "test", "string" };
            String[] testStringArr2 = { null, null, null };
            boolean expectedResult = false;
            String scenario = "normal array and array of null";

            allPassed &= stringEqualsTestCase(testStringArr1, testStringArr2, expectedResult, scenario);
        }

        /**
         * array of nulls and empty arrays
         */
        {
            String[] testStringArr1 = { null, null, null };
            String[] testStringArr2 = {};
            boolean expectedResult = false;
            String scenario = "array of null and empty array";

            allPassed &= stringEqualsTestCase(testStringArr1, testStringArr2, expectedResult, scenario);
        }

        /**
         * empty arrays and array of nulls
         */
        {
            String[] testStringArr1 = {};
            String[] testStringArr2 = { null, null, null };
            boolean expectedResult = false;
            String scenario = "empty array and array of null";

            allPassed &= stringEqualsTestCase(testStringArr1, testStringArr2, expectedResult, scenario);
        }

        /**
         * mix of null and Strings arrays
         */
        {
            String[] testStringArr1 = { null, "test", null, "array", null, "string" };
            String[] testStringArr2 = { null, "test", null, "array", null, "string" };
            boolean expectedResult = true;
            String scenario = "2 arrays mix of nulls and strings";

            allPassed &= stringEqualsTestCase(testStringArr1, testStringArr2, expectedResult, scenario);
        }

        /**
         * mix of null and Strings arrays different length
         */
        {
            String[] testStringArr1 = { null, "test", null, "array", null, "string" };
            String[] testStringArr2 = { null, "test", null, "array", null, "string", null };
            boolean expectedResult = false;
            String scenario = "2 arrays mix of nulls and strings of different length";

            allPassed &= stringEqualsTestCase(testStringArr1, testStringArr2, expectedResult, scenario);
        }

        /**
         * mix of null and Strings arrays different
         */
        {
            String[] testStringArr1 = { null, "test", null, "array", null, "string" };
            String[] testStringArr2 = { null, "test", null, "array", "string", null };
            boolean expectedResult = false;
            String scenario = "2 arrays mix of nulls and strings of different length";

            allPassed &= stringEqualsTestCase(testStringArr1, testStringArr2, expectedResult, scenario);
        }

        /**
         * mix of null and Strings array and empty array
         */
        {
            String[] testStringArr1 = { null, "test", null, "array", null, "string" };
            String[] testStringArr2 = {};
            boolean expectedResult = false;
            String scenario = "array mix of nulls and strings amd empty array";

            allPassed &= stringEqualsTestCase(testStringArr1, testStringArr2, expectedResult, scenario);
        }

        /**
         * mix of null and Strings arrays and null
         */
        {
            String[] testStringArr1 = { null, "test", null, "array", null, "string" };
            String[] testStringArr2 = null;
            boolean expectedResult = false;
            String scenario = "array mix of nulls and strings amd empty array";

            allPassed &= stringEqualsTestCase(testStringArr1, testStringArr2, expectedResult, scenario);
        }

        /**
         * mix of null and Strings arrays and null array
         */
        {
            String[] testStringArr2 = { null, "test", null, "array", null, "string" };
            String[] testStringArr1 = { null, null, null };
            boolean expectedResult = false;
            String scenario = "array mix of nulls and strings amd empty array";

            allPassed &= stringEqualsTestCase(testStringArr1, testStringArr2, expectedResult, scenario);
        }

        /**
         * empty array and mix of null and Strings arrays
         */
        {
            String[] testStringArr1 = {};
            String[] testStringArr2 = { null, "test", null, "array", null, "string" };
            boolean expectedResult = false;
            String scenario = "array mix of nulls and strings amd empty array";

            allPassed &= stringEqualsTestCase(testStringArr1, testStringArr2, expectedResult, scenario);
        }

        /**
         * null and mix of null and Strings arrays
         */
        {
            String[] testStringArr1 = null;
            String[] testStringArr2 = { null, "test", null, "array", null, "string" };
            boolean expectedResult = false;
            String scenario = "array mix of nulls and strings amd empty array";

            allPassed &= stringEqualsTestCase(testStringArr1, testStringArr2, expectedResult, scenario);
        }

        /**
         * null array and mix of null and Strings arrays
         */
        {
            String[] testStringArr1 = { null, null, null };
            String[] testStringArr2 = { null, "test", null, "array", null, "string" };
            boolean expectedResult = false;
            String scenario = "array mix of nulls and strings amd empty array";

            allPassed &= stringEqualsTestCase(testStringArr1, testStringArr2, expectedResult, scenario);
        }

        System.out.println("\tFeature Passed: " + allPassed);
        System.out.println();
        return allPassed;
    }

    /**
     * Test the toString method for string arrays
     * @param testStringArr
     * @param expectedResult
     * @param scenario
     * @return passed
     */
    public static boolean stringToStringTestCase(String[] testStringArr, String expectedResult, String scenario) {
        String result = ArraysMethods.toString(testStringArr);
        boolean thisPassed = result.equals(expectedResult);

        if (!thisPassed) {
            System.out.println();
            System.out.println("Scenario: " + scenario);
            System.out.println("Given: array is " + ArraysMethods.toString(testStringArr));
            System.out.println("When: toString is called");
            System.out.println("Then: result is " + expectedResult);
            System.out.println("Passed: " + thisPassed);
            System.out.println("Expected Value: " + expectedResult);
            System.out.println("Given Value: " + result);
            System.out.println();
        }

        return thisPassed;
    }

    /**
     * Test the toString method for int arrays
     * @param testIntArr
     * @param expectedResult
     * @param scenario
     * @return passed
     */
    public static boolean intToStringTestCase(int[] testIntArr, String expectedResult, String scenario) {
        String result = ArraysMethods.toString(testIntArr);
        boolean thisPassed = result.equals(expectedResult);

        if (!thisPassed) {
            System.out.println();
            System.out.println("Scenario: " + scenario);
            System.out.println("Given: array is " + ArraysMethods.toString(testIntArr));
            System.out.println("When: toString is called");
            System.out.println("Then: result is " + expectedResult);
            System.out.println("Passed: " + thisPassed);
            System.out.println("Expected Value: " + expectedResult);
            System.out.println("Given Value: " + result);
            System.out.println();
        }

        return thisPassed;
    }

    /**
     * Test the equals method for String arrays
     * @param testStringArr1
     * @param testStringArr2
     * @param expectedResult
     * @param scenario
     * @return passed
     */
    public static boolean stringEqualsTestCase(String[] testStringArr1, String[] testStringArr2, boolean expectedResult,
            String scenario) {
        boolean result = ArraysMethods.equals(testStringArr1, testStringArr2);
        boolean thisPassed = result == expectedResult;

        if (!thisPassed) {
            System.out.println();
            System.out.println("Scenario: " + scenario);
            System.out.println("Given: array 1 is " + ArraysMethods.toString(testStringArr1));
            System.out.println("And: array 2 is " + ArraysMethods.toString(testStringArr2));
            System.out.println("When: toString is called");
            System.out.println("Then: result is " + expectedResult);
            System.out.println("Passed: " + thisPassed);
            System.out.println("Expected Value: " + expectedResult);
            System.out.println("Given Value: " + result);
            System.out.println();
        }

        return thisPassed;
    }
}
