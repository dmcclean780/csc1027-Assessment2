package part02;

import java.util.ArrayList;

public class UtilsTester {
    public static void main(String[] args) {
        boolean allPassed = true;
        System.out.println("Class in Test: Utils");
        System.out.println();
        allPassed &= testStringConcat();
        allPassed &= testArrayListContains();
        allPassed &= testArrayContains();
        System.out.println("All Features Passed: " + allPassed);
        
    }

    /**
     * Test the concat two String[] method
     * 
     * @return all tests passed
     */
    public static boolean testStringConcat() {
        System.out.println("\tFeature: concat 2 String[] arrays");
        boolean allPassed = true;

        /**
         * Two normal arrays
         */
        {
            String[] testArr1 = { "This", "is", "a" };
            String[] testArr2 = { "test", "string" };
            String[] expectedResult = { "This", "is", "a", "test", "string" };
            String scenario = "2 normal arrays";

            allPassed &= UtilsTestCases.stringConcatTestCase(testArr1, testArr2, expectedResult, scenario);
        }

        /**
         * Normal and empty array
         */
        {
            String[] testArr1 = { "This", "is", "a" };
            String[] testArr2 = {};
            String[] expectedResult = { "This", "is", "a" };
            String scenario = "empty array to normal array";

            allPassed &= UtilsTestCases.stringConcatTestCase(testArr1, testArr2, expectedResult, scenario);
        }

        /**
         * normal array and array of null values
         */
        {
            String[] testArr1 = { "This", "is", "a" };
            String[] testArr2 = { null, null, null };
            String[] expectedResult = { "This", "is", "a", null, null, null };
            String scenario = "null array to normal array";

            allPassed &= UtilsTestCases.stringConcatTestCase(testArr1, testArr2, expectedResult, scenario);
        }

        /**
         * normal array and array of mix of null and String
         */
        {
            String[] testArr1 = { "This", "is", "a" };
            String[] testArr2 = { null, "test", null, "string", null };
            String[] expectedResult = { "This", "is", "a", null, "test", null, "string", null };
            String scenario = "string and null array to normal array";

            allPassed &= UtilsTestCases.stringConcatTestCase(testArr1, testArr2, expectedResult, scenario);
        }

        /**
         * normal array and null
         */
        {
            String[] testArr1 = { "This", "is", "a" };
            String[] testArr2 = null;
            String[] expectedResult = { "This", "is", "a" };
            String scenario = "null to normal array";

            allPassed &= UtilsTestCases.stringConcatTestCase(testArr1, testArr2, expectedResult, scenario);
        }

        /**
         * empty array and normal array
         */
        {
            String[] testArr1 = {};
            String[] testArr2 = { "test", "string" };
            String[] expectedResult = { "test", "string" };
            String scenario = "normal array to empty array";

            allPassed &= UtilsTestCases.stringConcatTestCase(testArr1, testArr2, expectedResult, scenario);
        }

        /**
         * empty array and empty array
         */
        {
            String[] testArr1 = {};
            String[] testArr2 = {};
            String[] expectedResult = {};
            String scenario = "2 empty arrays";

            allPassed &= UtilsTestCases.stringConcatTestCase(testArr1, testArr2, expectedResult, scenario);
        }

        /**
         * empty array and array of null values
         */
        {
            String[] testArr1 = {};
            String[] testArr2 = { null, null, null };
            String[] expectedResult = { null, null, null };
            String scenario = "null array to empty array";

            allPassed &= UtilsTestCases.stringConcatTestCase(testArr1, testArr2, expectedResult, scenario);
        }

        /**
         * emoty array and array of null and String mix
         */
        {
            String[] testArr1 = {};
            String[] testArr2 = { null, "test", null, "string", null };
            String[] expectedResult = { null, "test", null, "string", null };
            String scenario = "null and string array to empty array";

            allPassed &= UtilsTestCases.stringConcatTestCase(testArr1, testArr2, expectedResult, scenario);
        }

        /**
         * empty array and null
         */
        {
            String[] testArr1 = {};
            String[] testArr2 = null;
            String[] expectedResult = {};
            String scenario = "null to empty array";

            allPassed &= UtilsTestCases.stringConcatTestCase(testArr1, testArr2, expectedResult, scenario);
        }

        /**
         * null array and normal array
         */
        {
            String[] testArr1 = { null, null, null };
            String[] testArr2 = { "test", "string" };
            String[] expectedResult = { null, null, null, "test", "string" };
            String scenario = "normal array to null array";

            allPassed &= UtilsTestCases.stringConcatTestCase(testArr1, testArr2, expectedResult, scenario);
        }

        /**
         * null array and emoty array
         */
        {
            String[] testArr1 = { null, null, null };
            String[] testArr2 = {};
            String[] expectedResult = { null, null, null };
            String scenario = "empty array to null array";

            allPassed &= UtilsTestCases.stringConcatTestCase(testArr1, testArr2, expectedResult, scenario);
        }

        /**
         * null array and null array
         */
        {
            String[] testArr1 = { null, null, null };
            String[] testArr2 = { null, null, null };
            String[] expectedResult = { null, null, null, null, null, null };
            String scenario = "2 null arrays";

            allPassed &= UtilsTestCases.stringConcatTestCase(testArr1, testArr2, expectedResult, scenario);
        }

        /**
         * null array and null and String mix array
         */
        {
            String[] testArr1 = { null, null, null };
            String[] testArr2 = { null, "test", null, "string", null };
            String[] expectedResult = { null, null, null, null, "test", null, "string", null };
            String scenario = "null and string array to null array";

            allPassed &= UtilsTestCases.stringConcatTestCase(testArr1, testArr2, expectedResult, scenario);
        }

        /**
         * null array and null
         */
        {
            String[] testArr1 = { null, null, null };
            String[] testArr2 = null;
            String[] expectedResult = { null, null, null };
            String scenario = "null to null array";

            allPassed &= UtilsTestCases.stringConcatTestCase(testArr1, testArr2, expectedResult, scenario);
        }

        /**
         * null and String mix array and normal array
         */
        {
            String[] testArr1 = { null, "test", null, "string", null };
            String[] testArr2 = { "test", "string" };
            String[] expectedResult = { null, "test", null, "string", null, "test", "string" };
            String scenario = "normal array to null and string array";

            allPassed &= UtilsTestCases.stringConcatTestCase(testArr1, testArr2, expectedResult, scenario);
        }

        /**
         * null and String mix array and empty array
         */
        {
            String[] testArr1 = { null, "test", null, "string", null };
            String[] testArr2 = {};
            String[] expectedResult = { null, "test", null, "string", null };
            String scenario = "empty array to null and string array";

            allPassed &= UtilsTestCases.stringConcatTestCase(testArr1, testArr2, expectedResult, scenario);
        }

        /**
         * null and String mix array and null array
         */
        {
            String[] testArr1 = { null, "test", null, "string", null };
            String[] testArr2 = { null, null, null };
            String[] expectedResult = { null, "test", null, "string", null, null, null, null };
            String scenario = "null array to null and string array";

            allPassed &= UtilsTestCases.stringConcatTestCase(testArr1, testArr2, expectedResult, scenario);
        }

        /**
         * null and String mix array and null and String mix array
         */
        {
            String[] testArr1 = { null, "test", null, "string", null };
            String[] testArr2 = { null, "test", null, "string", null };
            String[] expectedResult = { null, "test", null, "string", null, null, "test", null, "string", null };
            String scenario = "2 null and string arrays";

            allPassed &= UtilsTestCases.stringConcatTestCase(testArr1, testArr2, expectedResult, scenario);
        }

        /**
         * null and String mix array and null
         */
        {
            String[] testArr1 = { null, "test", null, "string", null };
            String[] testArr2 = null;
            String[] expectedResult = { null, "test", null, "string", null };
            String scenario = "null to null and string array";

            allPassed &= UtilsTestCases.stringConcatTestCase(testArr1, testArr2, expectedResult, scenario);
        }

        /**
         * null and normal array
         */
        {
            String[] testArr1 = null;
            String[] testArr2 = { "test", "string" };
            String[] expectedResult = { "test", "string" };
            String scenario = "normal array to null";

            allPassed &= UtilsTestCases.stringConcatTestCase(testArr1, testArr2, expectedResult, scenario);
        }

        /**
         * null and empty array
         */
        {
            String[] testArr1 = null;
            String[] testArr2 = {};
            String[] expectedResult = {};
            String scenario = "empty array to null";

            allPassed &= UtilsTestCases.stringConcatTestCase(testArr1, testArr2, expectedResult, scenario);
        }

        /**
         * null and null array
         */
        {
            String[] testArr1 = null;
            String[] testArr2 = { null, null, null };
            String[] expectedResult = { null, null, null };
            String scenario = "null array to null";

            allPassed &= UtilsTestCases.stringConcatTestCase(testArr1, testArr2, expectedResult, scenario);
        }

        /**
         * null and null and String mix array
         */
        {
            String[] testArr1 = null;
            String[] testArr2 = { null, "test", null, "string", null };
            String[] expectedResult = { null, "test", null, "string", null };
            String scenario = "null and string array to null";

            allPassed &= UtilsTestCases.stringConcatTestCase(testArr1, testArr2, expectedResult, scenario);
        }

        /** null and null */
        {
            String[] testArr1 = null;
            String[] testArr2 = null;
            String[] expectedResult = null;
            String scenario = "2 nulls";

            allPassed &= UtilsTestCases.stringConcatTestCase(testArr1, testArr2, expectedResult, scenario);
        }

        System.out.println("\tFeature Passed: " + allPassed);
        System.out.println();
        return allPassed;

    }

    /**
     * Test Suit for the contains method for ArrayLists
     * @return all tests passed
     */
    public static boolean testArrayContains() {
        System.out.println("\tFeature: int[] contains an int");
        boolean allPassed = true;

        /**
         * valid seacrch
         */
        {
            int[] testArray = {1,2,3,4,5,6,7,8,9};
            int searchInt = 5;
            boolean expectedResult = true;
            String scenario = "int in normal list";
            allPassed &= UtilsTestCases.containsTestCase(testArray, searchInt, expectedResult, scenario);
        }

        /**
         * value not presant
         */
        {
            int[] testArray = {1,2,3,4,5,6,7,8,9};
            int searchInt = 11;
            boolean expectedResult = false;
            String scenario = "int not in normal list";
            allPassed &= UtilsTestCases.containsTestCase(testArray, searchInt, expectedResult, scenario);
        }

        /**
         * list is empty
         */
        {
            int[] testArray = {};
            int searchInt = 5;
            boolean expectedResult = false;
            String scenario = "int not in empty list";
            allPassed &= UtilsTestCases.containsTestCase(testArray, searchInt, expectedResult, scenario);
        }

        /**
         * list is null
         */
        {
            int[] testArray = null;
            int searchInt = 5;
            boolean expectedResult = false;
            String scenario = "int not in null";
            allPassed &= UtilsTestCases.containsTestCase(testArray, searchInt, expectedResult, scenario);
        }

        /**
         * list is negative
         */
        {
            int[] testArray = {-1,-2,-3,-4,-5,-6,-7,-8,-9};
            int searchInt = -5;
            boolean expectedResult = true;
            String scenario = "int in normal list";
            allPassed &= UtilsTestCases.containsTestCase(testArray, searchInt, expectedResult, scenario);
        }

        System.out.println("\tFeature Passed: " + allPassed);
        System.out.println();
        return allPassed;

    }

    /**
     * Test Suit for the contains method with Arrays
     * @return all tests passed
     */
    public static boolean testArrayListContains(){
        System.out.println("\tFeature: ArrayList<Integer> contains an int");
        boolean allPassed = true;

        /**
         * valid seacrch
         */
        {
            ArrayList<Integer> testArrayList = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                testArrayList.add(i);
            }
            int searchInt = 5;
            boolean expectedResult = true;
            String scenario = "int in normal list";
            allPassed &= UtilsTestCases.containsTestCase(testArrayList, searchInt, expectedResult, scenario);
        }

        /**
         * value not presant
         */
        {
            ArrayList<Integer> testArrayList = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                testArrayList.add(i);
            }
            int searchInt = 11;
            boolean expectedResult = false;
            String scenario = "int not in normal list";
            allPassed &= UtilsTestCases.containsTestCase(testArrayList, searchInt, expectedResult, scenario);
        }

        /**
         * list is empty
         */
        {
            ArrayList<Integer> testArrayList = new ArrayList<>();
            int searchInt = 5;
            boolean expectedResult = false;
            String scenario = "int not in empty list";
            allPassed &= UtilsTestCases.containsTestCase(testArrayList, searchInt, expectedResult, scenario);
        }

        /**
         * list is null
         */
        {
            ArrayList<Integer> testArrayList = null;
            int searchInt = 5;
            boolean expectedResult = false;
            String scenario = "int not in null";
            allPassed &= UtilsTestCases.containsTestCase(testArrayList, searchInt, expectedResult, scenario);
        }

        /**
         * list contains only null
         */
        {
            ArrayList<Integer> testArrayList = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                testArrayList.add(null);
            }
            int searchInt = 11;
            boolean expectedResult = false;
            String scenario = "int in null list";
            allPassed &= UtilsTestCases.containsTestCase(testArrayList, searchInt, expectedResult, scenario);
        }

        /**
         * list contains a null value and number is there
         */
        {
            ArrayList<Integer> testArrayList = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                testArrayList.add(i);
            }
            testArrayList.add(null);
            int searchInt = 5;
            boolean expectedResult = true;
            String scenario = "int in list containing a null";
            allPassed &= UtilsTestCases.containsTestCase(testArrayList, searchInt, expectedResult, scenario);
        }

        /**
         * list contains a null and value is not there
         */
        {
            ArrayList<Integer> testArrayList = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                testArrayList.add(i);
            }
            testArrayList.add(null);
            int searchInt = 11;
            boolean expectedResult = false;
            String scenario = "int not in list containing a null";
            allPassed &= UtilsTestCases.containsTestCase(testArrayList, searchInt, expectedResult, scenario);
        }

        /**
         * list is negative
         */
        {
            ArrayList<Integer> testArrayList = new ArrayList<>();
            for (int i = -10; i < 0; i++) {
                testArrayList.add(i);
            }
            int searchInt = -5;
            boolean expectedResult = true;
            String scenario = "int in normal list";
            allPassed &= UtilsTestCases.containsTestCase(testArrayList, searchInt, expectedResult, scenario);
        }

        System.out.println("\tFeature Passed: " + allPassed);
        System.out.println();
        return allPassed;

    }
}
