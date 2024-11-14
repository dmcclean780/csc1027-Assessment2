package part02;

import part01.ArraysMethods;
import part01.Months;

public class MonthsTester {

    public static void main(String[] args) {
        boolean allPassed = true;
        allPassed &= testToString();
        allPassed &= testGetId();
        allPassed &= testGetByString();
        allPassed &= testGetById();
        allPassed &= testToArray();
        System.out.println("All Features Passed: " + allPassed);

    }

    public static boolean testToString() {
        System.out.println("Feature: Months enum toString");

        boolean allPassed = true;
        String[] months = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
                "October", "November", "December" };

        for (int i = 0; i < Months.values().length; i++) {

            Months month = Months.values()[i];
            String expectedString = months[i];
            String result = month.toString();
            boolean thisPassed = result.equals(expectedString);
            allPassed &= thisPassed;

            if (!thisPassed) {
                System.out.println();
                System.out.println("Scenario: Months enum is " + Months.values()[i]);
                System.out.println("Given: expected months are " + ArraysMethods.toString(months));
                System.out.println("When: month.toString() called");
                System.out.println("Then: " + months[i] + " is returned");
                System.out.println("Passed: " + thisPassed);
                System.out.println("Expected Value: " + expectedString);
                System.out.println("Given Value: " + result);
                System.out.println();
            }

        }

        System.out.println("Feature Passed: " + allPassed);
        System.out.println();
        return allPassed;
    }

    public static boolean testGetId() {
        System.out.println("Feature: Months enum getId");

        boolean allPassed = true;
        int[] expectedIds = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };
        for (int i = 0; i < Months.values().length; i++) {

            Months month = Months.values()[i];
            int expectedId = expectedIds[i];
            int result = month.getId();
            boolean thisPassed = expectedId == result;
            allPassed &= thisPassed;

            if (!thisPassed) {
                System.out.println();
                System.out.println("Scenario: Months enum is " + month);
                System.out.println("Given: expected ids are " + ArraysMethods.toString(expectedIds));
                System.out.println("When: month.getid() called");
                System.out.println("Then: " + expectedId + " is returned");
                System.out.println("Passed: " + thisPassed);
                System.out.println("Expected Value: " + expectedId);
                System.out.println("Given Value: " + result);
                System.out.println();
            }

        }

        System.out.println("Feature Passed: " + allPassed);
        System.out.println();
        return allPassed;
    }

    public static boolean testGetByString() {
        System.out.println("Feature: Get Months enum by String");

        boolean allPassed = true;
        String[] months = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
                "October", "November", "December" };
        for (int i = 0; i < Months.values().length; i++) {
            String monthString = months[i];
            Months month = Months.values()[i];
            Months result = Months.get(monthString);
            boolean thisPassed = result == month;
            allPassed &= thisPassed;

            if (!thisPassed) {
                System.out.println();
                System.out.println("Scenario: String given is " + monthString);
                System.out.println("Given: expected months are " + ArraysMethods.toString(months));
                System.out.println("When: Months.get() called with " + monthString);
                System.out.println("Then: m is " + month);
                System.out.println("Passed: " + allPassed);
                System.out.println("Expected Value: " + month);
                System.out.println("Given Value: " + result);
                System.out.println();
            }
        }
        System.out.println("Feature Passed: " + allPassed);
        System.out.println();
        return allPassed;

    }

    public static boolean testGetById() {
        System.out.println("Feature: Get Months enum by id");

        boolean allPassed = true;
        int[] expectedIds = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };
        for (int i = 0; i < Months.values().length; i++) {
            Months month = Months.values()[i];
            Months result = Months.get(expectedIds[i]);
            boolean thisPassed =  result== month;
            allPassed &= thisPassed;

            if (!thisPassed) {
                System.out.println();
                System.out.println("Scenario: id given is " + i);
                System.out.println("Given: expected ids are " + ArraysMethods.toString(expectedIds));
                System.out.println("When: Months.get() called with " + expectedIds[i]);
                System.out.println("Then: m is " + month);
                System.out.println("Passed: " + thisPassed);
                System.out.println("Expected Value: " + month);
                System.out.println("Given Value: " + result);
                System.out.println();
            }
        }
        System.out.println("Feature Passed: " + allPassed);
        System.out.println();
        return allPassed;

    }

    public static boolean testToArray() {
        System.out.println("Feature: toArray gives array of month names");

        boolean allPassed = true;
        String[] months = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
                "October", "November", "December" };
        String[] result = Months.toArray();
        boolean thisPassed = ArraysMethods.equals(result, months);
        allPassed &= thisPassed;

        if (!thisPassed) {
            System.out.println();
            System.out.println("Scenario: toArray called");
            System.out.println("Given: expected months are " + ArraysMethods.toString(months));
            System.out.println("When: toArray is called");
            System.out.println("Then: array is " + ArraysMethods.toString(months));
            System.out.println("Passed: " + thisPassed);
            System.out.println("Expected Value: " + ArraysMethods.toString(months));
            System.out.println("Given Value: " + ArraysMethods.toString(result));
            System.out.println();
        }
        System.out.println("Feature Passed: " + allPassed);
        System.out.println();
        return allPassed;

    }

}
