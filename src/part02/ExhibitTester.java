package part02;

import java.util.ArrayList;

import part01.Exhibit;

public class ExhibitTester {
    public static void main(String[] args) {
        boolean allPassed = true;
        System.out.println("Class in Test: Menu");
        System.out.println();
        allPassed &= testConstructor();
        System.out.println("All Features Passed: " + allPassed);
    }

    /**
     * Test Suit for the constructor method
     * @return all tests passed
     */
    public static boolean testConstructor() {
        System.out.println("\tFeature: Artifact Constructor");
        boolean allPassed = true;

        /**
         * normal exhibit
         */
        {
            String testName = "test";
            ArrayList<Integer> testArtifacts = new ArrayList<>();
            testArtifacts.add(0);
            testArtifacts.add(1);
            testArtifacts.add(2);
            testArtifacts.add(3);
            ArrayList<String> testRoute = new ArrayList<>();
            testRoute.add("a");
            testRoute.add("b");
            testRoute.add("c");
            testRoute.add("d");
            String expectedResult = "no exception";
            String scenario = "valid Parameters";

            allPassed &= constructorTestCase(testName, testArtifacts, testRoute, expectedResult, scenario);
        }

        /**
         * Shorter route than artifacts
         */
        {
            String testName = "test";
            ArrayList<Integer> testArtifacts = new ArrayList<>();
            testArtifacts.add(0);
            testArtifacts.add(1);
            testArtifacts.add(2);
            testArtifacts.add(3);
            ArrayList<String> testRoute = new ArrayList<>();
            testRoute.add("a");
            testRoute.add("b");
            testRoute.add("c");
            String expectedResult = "exception thrown";
            String scenario = "more artifacts than route";

            allPassed &= constructorTestCase(testName, testArtifacts, testRoute, expectedResult, scenario);
        }

        /**
         * less artifacts than route
         */
        {
            String testName = "test";
            ArrayList<Integer> testArtifacts = new ArrayList<>();
            testArtifacts.add(0);
            testArtifacts.add(1);
            testArtifacts.add(2);
            ArrayList<String> testRoute = new ArrayList<>();
            testRoute.add("a");
            testRoute.add("b");
            testRoute.add("c");
            testRoute.add("d");
            String expectedResult = "exception thrown";
            String scenario = "more route than artifacts";

            allPassed &= constructorTestCase(testName, testArtifacts, testRoute, expectedResult, scenario);
        }

        /**
         * empty artifacts
         */
        {
            String testName = "test";
            ArrayList<Integer> testArtifacts = new ArrayList<>();
            ArrayList<String> testRoute = new ArrayList<>();
            testRoute.add("a");
            testRoute.add("b");
            testRoute.add("c");
            testRoute.add("d");
            String expectedResult = "exception thrown";
            String scenario = "empty artifacts";

            allPassed &= constructorTestCase(testName, testArtifacts, testRoute, expectedResult, scenario);
        }

        /**
         * empty route
         */
        {
            String testName = "test";
            ArrayList<Integer> testArtifacts = new ArrayList<>();
            testArtifacts.add(0);
            testArtifacts.add(1);
            testArtifacts.add(2);
            testArtifacts.add(3);
            ArrayList<String> testRoute = new ArrayList<>();
            String expectedResult = "exception thrown";
            String scenario = "empty route";

            allPassed &= constructorTestCase(testName, testArtifacts, testRoute, expectedResult, scenario);
        }

        /**
         * both empty
         */
        {
            String testName = "test";
            ArrayList<Integer> testArtifacts = new ArrayList<>();
            ArrayList<String> testRoute = new ArrayList<>();
            String expectedResult = "no exception";
            String scenario = "both empty";

            allPassed &= constructorTestCase(testName, testArtifacts, testRoute, expectedResult, scenario);
        }

        /**
         * null artifacts
         */
        {
            String testName = "test";
            ArrayList<Integer> testArtifacts = null;
            ArrayList<String> testRoute = new ArrayList<>();
            testRoute.add("a");
            testRoute.add("b");
            testRoute.add("c");
            testRoute.add("d");
            String expectedResult = "exception thrown";
            String scenario = "null artifacts";

            allPassed &= constructorTestCase(testName, testArtifacts, testRoute, expectedResult, scenario);
        }

        /**
         * null route
         */
        {
            String testName = "test";
            ArrayList<Integer> testArtifacts = new ArrayList<>();
            testArtifacts.add(0);
            testArtifacts.add(1);
            testArtifacts.add(2);
            testArtifacts.add(3);
            ArrayList<String> testRoute = null;
            String expectedResult = "exception thrown";
            String scenario = "null route";

            allPassed &= constructorTestCase(testName, testArtifacts, testRoute, expectedResult, scenario);
        }

        /**
         * both null
         */
        {
            String testName = "test";
            ArrayList<Integer> testArtifacts =null;
            ArrayList<String> testRoute = null;
            String expectedResult = "exception thrown";
            String scenario = "both null";

            allPassed &= constructorTestCase(testName, testArtifacts, testRoute, expectedResult, scenario);
        }

        System.out.println("\tFeature Passed: " + allPassed);
        System.out.println();
        return allPassed;
    }

    /**
     * Test for the constructor method
     * @param name
     * @param artifacts
     * @param route
     * @param expectedResult
     * @param scenario
     * @return passed
     */
    public static boolean constructorTestCase(String name, ArrayList<Integer> artifacts, ArrayList<String> route,
            String expectedResult, String scenario) {
        String result;
        try {
            new Exhibit(name, artifacts, route);
            result = "no exception";
        } catch (Exception e) {
            result = "exception thrown";
        }
        boolean thisPassed = result.equals(expectedResult);
        if (!thisPassed) {
            System.out.println();
            System.out.println("Scenario:" + scenario);
            System.out.println("Given: artifact name is " + name);
            System.out.println("AND: artifacts are " + artifacts);
            System.out.println("AND: route is " + route);
            System.out.println("When: new Artifact");
            System.out.println("Then: output is:\n" + expectedResult);
            System.out.println("Passed: " + thisPassed);
            System.out.println("Expected Value:\n" + expectedResult);
            System.out.println("Given Value:\n" + result);
            System.out.println();
        }
        return thisPassed;
    }
}
