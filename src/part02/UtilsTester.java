package part02;

import java.util.ArrayList;

import part01.ArraysMethods;
import part01.Utils;

public class UtilsTester {
    public static void main(String[] args){
        boolean allPassed = true;
        allPassed &= testStringConcat();
        allPassed &= testContains();
        System.out.println("All Features Passed: " + allPassed);
    }

    public static boolean testStringConcat(){
        System.out.println("Feature: concat 2 String[] arrays");
        boolean allPassed = true;

        {
            String[] testArr1 = { "This", "is", "a"};
            String[] testArr2 = { "test", "string" };
            String[] expectedResult = { "This", "is", "a", "test", "string" };
            String scenario = "2 normal arrays";

            allPassed &= stringConcatTestCase(testArr1, testArr2, expectedResult, scenario);
        }

        {
            String[] testArr1 = { };
            String[] testArr2 = { "test", "string" };
            String[] expectedResult = { "test", "string" };
            String scenario = "normal array to empty array";

            allPassed &= stringConcatTestCase(testArr1, testArr2, expectedResult, scenario);
        }

        {
            String[] testArr1 = { "This", "is", "a"};
            String[] testArr2 = {  };
            String[] expectedResult = { "This", "is", "a" };
            String scenario = "empty array to normal array";

            allPassed &= stringConcatTestCase(testArr1, testArr2, expectedResult, scenario);
        }

        {
            String[] testArr1 = { };
            String[] testArr2 = {  };
            String[] expectedResult = {  };
            String scenario = "2 empty arrays";

            allPassed &= stringConcatTestCase(testArr1, testArr2, expectedResult, scenario);
        }

        System.out.println("Feature Passed: " + allPassed);
        System.out.println();
        return allPassed;


       
    }

    public static boolean stringConcatTestCase(String[] testArr1, String[] testArr2, String[] expectedResult, String scenario) {

        String[] result = Utils.concat(testArr1, testArr2);
        boolean thisPassed = ArraysMethods.equals(result, expectedResult);

        if (!thisPassed) {
            System.out.println();
            System.out.println("Scenario: "+scenario);
            System.out.println("Given: array 1 is " + ArraysMethods.toString(testArr1));
            System.out.println("And: array 2 is " + ArraysMethods.toString(testArr2));
            System.out.println("When: toString is called");
            System.out.println("Then: result is " + ArraysMethods.toString(expectedResult));
            System.out.println("Passed: " + thisPassed);
            System.out.println("Expected Value: " + ArraysMethods.toString(expectedResult));
            System.out.println("Given Value: " + ArraysMethods.toString(result));
            System.out.println();
        }

        return thisPassed;
    }

    public static boolean testContains(){
        System.out.println("Feature: ArrayList<Integer> contains an int");
        boolean allPassed = true;

        {
            ArrayList<Integer> testArrayList = new ArrayList<>();
            for(int i=0; i<10; i++){
                testArrayList.add(i);
            }
            int searchInt = 5;
            boolean expectedResult = true;
            String scenario = "int in normal list";
            allPassed &= containsTestCase(testArrayList, searchInt, expectedResult, scenario);
        }

        {
            ArrayList<Integer> testArrayList = new ArrayList<>();
            for(int i=0; i<10; i++){
                testArrayList.add(i);
            }
            int searchInt = 11;
            boolean expectedResult = false;
            String scenario = "int in normal list";
            allPassed &= containsTestCase(testArrayList, searchInt, expectedResult, scenario);
        }

        {
            ArrayList<Integer> testArrayList = new ArrayList<>();
            int searchInt = 5;
            boolean expectedResult = false;
            String scenario = "int in normal list";
            allPassed &= containsTestCase(testArrayList, searchInt, expectedResult, scenario);
        }

        {
            ArrayList<Integer> testArrayList = new ArrayList<>();
            for(int i=-10; i<0; i++){
                testArrayList.add(i);
            }
            int searchInt = -5;
            boolean expectedResult = true;
            String scenario = "int in normal list";
            allPassed &= containsTestCase(testArrayList, searchInt, expectedResult, scenario);
        }

        System.out.println("Feature Passed: " + allPassed);
        System.out.println();
        return allPassed;

    }

    public static boolean containsTestCase(ArrayList<Integer> testArrayList, int searchInt, boolean expectedResult, String scenario) {

        boolean result = Utils.contains(searchInt, testArrayList);
        boolean thisPassed = result == expectedResult;

        if (!thisPassed) {
            System.out.println();
            System.out.println("Scenario: "+scenario);
            System.out.println("Given: list is " + testArrayList);
            System.out.println("And: search term is " + searchInt);
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
