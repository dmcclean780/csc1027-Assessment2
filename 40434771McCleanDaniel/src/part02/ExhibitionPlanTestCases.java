package part02;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import part01.ExhibitManagement;
import part01.ExhibitionPlan;
import part01.Months;

public class ExhibitionPlanTestCases {

    public static boolean addExhibitsToHallTestCase(ExhibitionPlan testExhibitionPlan,
            int[] newExhibit, int hall, String expectedResult, String scenario) {
    
        String result = "";
        try {
            testExhibitionPlan.addExhibitsToHall(newExhibit, hall);
            result = "no exception";
        } catch (Exception e) {
            result = "exception thrown";
        }
        boolean thisPassed = result.trim().equals(expectedResult.trim());
    
        //if (!thisPassed) {
            System.err.println();
            System.err.println("\t\tScenario:" + scenario);
            System.err.println("\t\tGiven: exhibitionPlan is " + testExhibitionPlan);
            System.err.println("\t\tWhen: addExhbitsToMonth called with " + ArraysMethods.toString(newExhibit));
            System.err.println("\t\tAND: " + hall);
            System.err.println("\t\tThen: output is:\n" + expectedResult);
            System.err.println("\t\tPassed: " + thisPassed);
            System.err.println("\t\tExpected Value:\n" + expectedResult);
            System.err.println("\t\tGiven Value:\n" + result);
            System.err.println();
        //}
        return thisPassed;
    }

    /**
     * Test for addExhibitsToMonth with String month
     * 
     * @param testExhibitionPlan
     * @param exhibitManagement
     * @param newExhibit
     * @param month
     * @param hall
     * @param expectedResult
     * @param scenario
     * @return
     */
    public static boolean addExhibitsToMonthTestCase(ExhibitionPlan testExhibitionPlan,
            int[] newExhibit, String month, String expectedResult, String scenario) {
    
        String result = "";
        try {
            testExhibitionPlan.addExhibitsToMonth(newExhibit, month);
            result = "no exception";
        } catch (Exception e) {
            result = "exception thrown";
        }
        boolean thisPassed = result.trim().equals(expectedResult.trim());
    
        //if (!thisPassed) {
            System.err.println();
            System.err.println("\t\tScenario:" + scenario);
            System.err.println("\t\tGiven: exhibitionPlan is " + testExhibitionPlan);
            System.err.println("\t\tWhen: addExhbitsToMonth called with " + ArraysMethods.toString(newExhibit));
            System.err.println("\t\tAND: " + month);
            System.err.println("\t\tThen: output is:\n" + expectedResult);
            System.err.println("\t\tPassed: " + thisPassed);
            System.err.println("\t\tExpected Value:\n" + expectedResult);
            System.err.println("\t\tGiven Value:\n" + result);
            System.err.println();
        //}
        return thisPassed;
    }

    /**
     * Test for addExhibitsToMonth with Months month
     * 
     * @param testExhibitionPlan
     * @param exhibitManagement
     * @param newExhibit
     * @param month
     * @param hall
     * @param expectedResult
     * @param scenario
     * @return
     */
    public static boolean addExhibitsToMonthTestCase(ExhibitionPlan testExhibitionPlan,
            int[] newExhibit, Months month, String expectedResult, String scenario) {
    
        String result = "";
        try {
            testExhibitionPlan.addExhibitsToMonth(newExhibit, month);
            result = "no exception";
        } catch (Exception e) {
            result = "exception thrown";
        }
        boolean thisPassed = result.trim().equals(expectedResult.trim());
    
        //if (!thisPassed) {
            System.err.println();
            System.err.println("\t\tScenario:" + scenario);
            System.err.println("\t\tGiven: exhibitionPlan is " + testExhibitionPlan);
            System.err.println("\t\tWhen: addExhbitsToMonth called with " + ArraysMethods.toString(newExhibit));
            System.err.println("\t\tAND: " + month);
            System.err.println("\t\tThen: output is:\n" + expectedResult);
            System.err.println("\t\tPassed: " + thisPassed);
            System.err.println("\t\tExpected Value:\n" + expectedResult);
            System.err.println("\t\tGiven Value:\n" + result);
            System.err.println();
        //}
        return thisPassed;
    }

    /**
     * Test for addExhibitsToMonth with int month
     * 
     * @param testExhibitionPlan
     * @param exhibitManagement
     * @param newExhibit
     * @param month
     * @param hall
     * @param expectedResult
     * @param scenario
     * @return
     */
    public static boolean addExhibitsToMonthTestCase(ExhibitionPlan testExhibitionPlan,
            int[] newExhibit, int month, String expectedResult, String scenario) {
    
        String result = "";
        try {
            testExhibitionPlan.addExhibitsToMonth(newExhibit, month);
            result = "no exception";
        } catch (Exception e) {
            result = "exception thrown";
        }
        boolean thisPassed = result.trim().equals(expectedResult.trim());
    
        //if (!thisPassed) {
            System.err.println();
            System.err.println("\t\tScenario:" + scenario);
            System.err.println("\t\tGiven: exhibitionPlan is " + testExhibitionPlan);
            System.err.println("\t\tWhen: addExhbitsToMonth called with " + ArraysMethods.toString(newExhibit));
            System.err.println("\t\tAND: " + month);
            System.err.println("\t\tThen: output is:\n" + expectedResult);
            System.err.println("\t\tPassed: " + thisPassed);
            System.err.println("\t\tExpected Value:\n" + expectedResult);
            System.err.println("\t\tGiven Value:\n" + result);
            System.err.println();
        //}
        return thisPassed;
    }

    /**
     * Test for addExhibit with Months month
     * 
     * @param testExhibitionPlan
     * @param exhibitManagement
     * @param newExhibit
     * @param month
     * @param hall
     * @param expectedResult
     * @param scenario
     * @return
     */
    public static boolean addExhibitTestCase(ExhibitionPlan testExhibitionPlan, ExhibitManagement exhibitManagement,
            int newExhibit, Months month, int hall, String expectedResult, String scenario) {
    
        String result = "";
        try {
            testExhibitionPlan.addExhibit(newExhibit, month, hall, exhibitManagement);
            result = "no exception";
        } catch (Exception e) {
            result = "exception thrown";
        }
        boolean thisPassed = result.trim().equals(expectedResult.trim());
    
        //if (!thisPassed) {
            System.err.println();
            System.err.println("\t\tScenario:" + scenario);
            System.err.println("\t\tGiven: exhibitionPlan is " + testExhibitionPlan);
            System.err.println("\t\tWhen: addExhbit called with " + exhibitManagement);
            System.err.println("\t\tAND: " + month);
            System.err.println("\t\tAND: " + hall);
            System.err.println("\t\tAND: " + newExhibit);
            System.err.println("\t\tThen: output is:\n" + expectedResult);
            System.err.println("\t\tPassed: " + thisPassed);
            System.err.println("\t\tExpected Value:\n" + expectedResult);
            System.err.println("\t\tGiven Value:\n" + result);
            System.err.println();
        //}
        return thisPassed;
    }

    /**
     * Test for addExhibit with String month
     * 
     * @param testExhibitionPlan
     * @param exhibitManagement
     * @param newExhibit
     * @param month
     * @param hall
     * @param expectedResult
     * @param scenario
     * @return
     */
    public static boolean addExhibitTestCase(ExhibitionPlan testExhibitionPlan, ExhibitManagement exhibitManagement,
            int newExhibit, String month, int hall, String expectedResult, String scenario) {
    
        String result = "";
        try {
            testExhibitionPlan.addExhibit(newExhibit, month, hall, exhibitManagement);
            result = "no exception";
        } catch (Exception e) {
            result = "exception thrown";
        }
        boolean thisPassed = result.trim().equals(expectedResult.trim());
    
        //if (!thisPassed) {
            System.err.println();
            System.err.println("\t\tScenario:" + scenario);
            System.err.println("\t\tGiven: exhibitionPlan is " + testExhibitionPlan);
            System.err.println("\t\tWhen: addExhbit called with " + exhibitManagement);
            System.err.println("\t\tAND: " + month);
            System.err.println("\t\tAND: " + hall);
            System.err.println("\t\tAND: " + newExhibit);
            System.err.println("\t\tThen: output is:\n" + expectedResult);
            System.err.println("\t\tPassed: " + thisPassed);
            System.err.println("\t\tExpected Value:\n" + expectedResult);
            System.err.println("\t\tGiven Value:\n" + result);
            System.err.println();
        //}
        return thisPassed;
    }

    /**
     * Test for addExhbit with int month
     * 
     * @param testExhibitionPlan
     * @param exhibitManagement
     * @param newExhibit
     * @param month
     * @param hall
     * @param expectedResult
     * @param scenario
     * @return
     */
    public static boolean addExhibitTestCase(ExhibitionPlan testExhibitionPlan, ExhibitManagement exhibitManagement,
            int newExhibit, int month, int hall, String expectedResult, String scenario) {
    
        String result = "";
        try {
            testExhibitionPlan.addExhibit(newExhibit, month, hall, exhibitManagement);
            result = "no exception";
        } catch (Exception e) {
            result = "exception thrown";
        }
        boolean thisPassed = result.trim().equals(expectedResult.trim());
    
        //if (!thisPassed) {
            System.err.println();
            System.err.println("\t\tScenario:" + scenario);
            System.err.println("\t\tGiven: exhibitionPlan is " + testExhibitionPlan);
            System.err.println("\t\tWhen: addExhbit called with " + exhibitManagement);
            System.err.println("\t\tAND: " + month);
            System.err.println("\t\tAND: " + hall);
            System.err.println("\t\tAND: " + newExhibit);
            System.err.println("\t\tThen: output is:\n" + expectedResult);
            System.err.println("\t\tPassed: " + thisPassed);
            System.err.println("\t\tExpected Value:\n" + expectedResult);
            System.err.println("\t\tGiven Value:\n" + result);
            System.err.println();
        //}
        return thisPassed;
    }

    /**
     * Test for getHallPlanString Method
     * 
     * @param testExhibitionPlan
     * @param hallNo
     * @param exhibitManagement
     * @param expectedResult
     * @param scenario
     * @return passed
     */
    public static boolean getHallPlanStringTestCase(ExhibitionPlan testExhibitionPlan, int hallNo,
            ExhibitManagement exhibitManagement, String expectedResult, String scenario) {
    
        PrintStream stderr = System.err;
        ByteArrayOutputStream errorOutput = new ByteArrayOutputStream();
        System.setErr(new PrintStream(errorOutput));
    
        String result = testExhibitionPlan.getHallPlanString(exhibitManagement, hallNo);
        boolean thisPassed = result.trim().equals(expectedResult.trim());
    
        System.setErr(stderr);
    
        //if (!thisPassed) {
            System.err.println();
            System.err.println("\t\tScenario:" + scenario);
            System.err.println("\t\tGiven: exhibitionPlan is " + testExhibitionPlan);
            System.err.println("\t\tWhen: getHallPlanString called with " + exhibitManagement);
            System.err.println("\t\tThen: output is:\n" + expectedResult);
            System.err.println("\t\tPassed: " + thisPassed);
            System.err.println("\t\tExpected Value:\n" + expectedResult);
            System.err.println("\t\tGiven Value:\n" + result);
            System.err.println();
        //}
        return thisPassed;
    }

    /**
     * Test for getMonthPlan method with String month
     * 
     * @param testExhibitionPlan
     * @param exhibitManagement
     * @param testMonth
     * @param expectedResult
     * @param scenario
     * @return passed
     */
    public static boolean getMonthPlanTestCase(ExhibitionPlan testExhibitionPlan, ExhibitManagement exhibitManagement,
            String testMonth, String expectedResult, String scenario) {
    
        String result = testExhibitionPlan.getMonthPlanString(exhibitManagement, testMonth);
        boolean thisPassed = result.trim().equals(expectedResult.trim());
    
        //if (!thisPassed) {
            System.err.println();
            System.err.println("\t\tScenario:" + scenario);
            System.err.println("\t\tGiven: exhibitionPlan is " + testExhibitionPlan);
            System.err.println("\t\tWhen: getMonthPlanString called with " + exhibitManagement);
            System.err.println("\t\tThen: output is:\n" + expectedResult);
            System.err.println("\t\tPassed: " + thisPassed);
            System.err.println("\t\tExpected Value:\n" + expectedResult);
            System.err.println("\t\tGiven Value:\n" + result);
            System.err.println();
        //}
        return thisPassed;
    }

    /**
     * Test for getMonthPlanStrin with Months month
     * 
     * @param testExhibitionPlan
     * @param exhibitManagement
     * @param testMonth
     * @param expectedResult
     * @param scenario
     * @return
     */
    public static boolean getMonthPlanTestCase(ExhibitionPlan testExhibitionPlan, ExhibitManagement exhibitManagement,
            Months testMonth, String expectedResult, String scenario) {
    
        String result = testExhibitionPlan.getMonthPlanString(exhibitManagement, testMonth);
        boolean thisPassed = result.trim().equals(expectedResult.trim());
    
        //if (!thisPassed) {
            System.err.println();
            System.err.println("\t\tScenario:" + scenario);
            System.err.println("\t\tGiven: exhibitionPlan is " + testExhibitionPlan);
            System.err.println("\t\tWhen: getMonthPlanString called with " + exhibitManagement);
            System.err.println("\t\tThen: output is:\n" + expectedResult);
            System.err.println("\t\tPassed: " + thisPassed);
            System.err.println("\t\tExpected Value:\n" + expectedResult);
            System.err.println("\t\tGiven Value:\n" + result);
            System.err.println();
        //}
        return thisPassed;
    }

    /**
     * Test for getMonthPlanString with int month
     * 
     * @param testExhibitionPlan
     * @param exhibitManagement
     * @param testMonth
     * @param expectedResult
     * @param scenario
     * @return
     */
    public static boolean getMonthPlanTestCase(ExhibitionPlan testExhibitionPlan, ExhibitManagement exhibitManagement,
            int testMonth, String expectedResult, String scenario) {
    
        String result = testExhibitionPlan.getMonthPlanString(exhibitManagement, testMonth);
        boolean thisPassed = result.trim().equals(expectedResult.trim());
    
       // if (!thisPassed) {
            System.err.println();
            System.err.println("\t\tScenario:" + scenario);
            System.err.println("\t\tGiven: exhibitionPlan is " + testExhibitionPlan);
            System.err.println("\t\tWhen: getMonthPlanString called with " + exhibitManagement);
            System.err.println("\t\tThen: output is:\n" + expectedResult);
            System.err.println("\t\tPassed: " + thisPassed);
            System.err.println("\t\tExpected Value:\n" + expectedResult);
            System.err.println("\t\tGiven Value:\n" + result);
            System.err.println();
        //}
        return thisPassed;
    }

    /**
     * Test for getPlanString method
     * 
     * @param testExhibitionPlan
     * @param exhibitManagement
     * @param expectedResult
     * @param scenario
     * @return passed
     */
    public static boolean getPlanStringTestCase(ExhibitionPlan testExhibitionPlan, ExhibitManagement exhibitManagement,
            String expectedResult, String scenario) {
        String result = testExhibitionPlan.getPlanString(exhibitManagement);
        boolean thisPassed = result.trim().equals(expectedResult.trim());
    
        //if (!thisPassed) {
            System.err.println();
            System.err.println("\t\tScenario:" + scenario);
            System.err.println("\t\tGiven: exhibitionPlan is " + testExhibitionPlan);
            System.err.println("\t\tWhen: getPlanString called with " + exhibitManagement);
            System.err.println("\t\tThen: output is:\n" + expectedResult);
            System.err.println("\t\tPassed: " + thisPassed);
            System.err.println("\t\tExpected Value:\n" + expectedResult);
            System.err.println("\t\tGiven Value:\n" + result);
            System.err.println();
        //}
        return thisPassed;
    }

    /**
     * Test for getExhibitNamesInHall method
     * 
     * @param testExhibitionPlan
     * @param testMonth
     * @param exhibitManagement
     * @param expectedResult
     * @param scenario
     * @return passed
     */
    public static boolean getExhibitNamesInHallTestCase(ExhibitionPlan testExhibitionPlan, int hallNo,
            ExhibitManagement exhibitManagement, String[] expectedResult, String scenario) {
    
        PrintStream stderr = System.err;
        ByteArrayOutputStream errorOutput = new ByteArrayOutputStream();
        System.setErr(new PrintStream(errorOutput));
    
        String[] result = testExhibitionPlan.getExhibitNamesInHall(exhibitManagement, hallNo);
        boolean thisPassed = ArraysMethods.equals(result, expectedResult);
    
        System.setErr(stderr);
    
        //if (!thisPassed) {
            System.err.println();
            System.err.println("\t\tScenario:" + scenario);
            System.err.println("\t\tGiven: exhibitionPlan is " + testExhibitionPlan);
            System.err.println("\t\tWhen: getExhibitNamesInHall called with " + exhibitManagement);
            System.err.println("\t\tAND: " + hallNo);
            System.err.println("\t\tThen: output is:\n" + ArraysMethods.toString(expectedResult));
            System.err.println("\t\tPassed: " + thisPassed);
            System.err.println("\t\tExpected Value:\n" + ArraysMethods.toString(expectedResult));
            System.err.println("\t\tGiven Value:\n" + ArraysMethods.toString(result));
            System.err.println();
        //}
        return thisPassed;
    }

    /**
     * Test for getExhibitNamesInMonth method
     * 
     * @param testExhibitionPlan
     * @param testMonth
     * @param exhibitManagement
     * @param expectedResult
     * @param scenario
     * @return passed
     */
    public static boolean getExhibitNamesInMonthTestCase(ExhibitionPlan testExhibitionPlan, String testMonth,
            ExhibitManagement exhibitManagement, String[] expectedResult, String scenario) {
    
        String[] result = testExhibitionPlan.getExhibitNamesInMonth(exhibitManagement, testMonth);
        boolean thisPassed = ArraysMethods.equals(result, expectedResult);
    
        //if (!thisPassed) {
            System.err.println();
            System.err.println("\t\tScenario:" + scenario);
            System.err.println("\t\tGiven: exhibitionPlan is " + testExhibitionPlan);
            System.err.println("\t\tWhen: getExhibitNamesInMonth called with " + exhibitManagement);
            System.err.println("\t\tAND: " + testMonth);
            System.err.println("\t\tThen: output is:\n" + ArraysMethods.toString(expectedResult));
            System.err.println("\t\tPassed: " + thisPassed);
            System.err.println("\t\tExpected Value:\n" + ArraysMethods.toString(expectedResult));
            System.err.println("\t\tGiven Value:\n" + ArraysMethods.toString(result));
            System.err.println();
       // }
        return thisPassed;
    }

    /**
     * Test For getExhibitNamesInMonth method with Months month
     * @param testExhibitionPlan
     * @param testMonth
     * @param exhibitManagement
     * @param expectedResult
     * @param scenario
     * @return
     */
    public static boolean getExhibitNamesInMonthTestCase(ExhibitionPlan testExhibitionPlan, Months testMonth,
            ExhibitManagement exhibitManagement, String[] expectedResult, String scenario) {
    
        String[] result = testExhibitionPlan.getExhibitNamesInMonth(exhibitManagement, testMonth);
        boolean thisPassed = ArraysMethods.equals(result, expectedResult);
    
       // if (!thisPassed) {
            System.err.println();
            System.err.println("\t\tScenario:" + scenario);
            System.err.println("\t\tGiven: exhibitionPlan is " + testExhibitionPlan);
            System.err.println("\t\tWhen: getExhibitNamesInMonth called with " + exhibitManagement);
            System.err.println("\t\tAND: " + testMonth);
            System.err.println("\t\tThen: output is:\n" + ArraysMethods.toString(expectedResult));
            System.err.println("\t\tPassed: " + thisPassed);
            System.err.println("\t\tExpected Value:\n" + ArraysMethods.toString(expectedResult));
            System.err.println("\t\tGiven Value:\n" + ArraysMethods.toString(result));
            System.err.println();
       // }
        return thisPassed;
    }

    /**
     * Test for getExhibitNamesInMonth with int month
     * @param testExhibitionPlan
     * @param testMonth
     * @param exhibitManagement
     * @param expectedResult
     * @param scenario
     * @return
     */
    public static boolean getExhibitNamesInMonthTestCase(ExhibitionPlan testExhibitionPlan, int testMonth,
            ExhibitManagement exhibitManagement, String[] expectedResult, String scenario) {
    
        String[] result = testExhibitionPlan.getExhibitNamesInMonth(exhibitManagement, testMonth);
        boolean thisPassed = ArraysMethods.equals(result, expectedResult);
    
        //if (!thisPassed) {
            System.err.println();
            System.err.println("\t\tScenario:" + scenario);
            System.err.println("\t\tGiven: exhibitionPlan is " + testExhibitionPlan);
            System.err.println("\t\tWhen: getExhibitNamesInMonth called with" + exhibitManagement);
            System.err.println("\t\tAND: " + testMonth);
            System.err.println("\t\tThen: output is:\n" + ArraysMethods.toString(expectedResult));
            System.err.println("\t\tPassed: " + thisPassed);
            System.err.println("\t\tExpected Value:\n" + ArraysMethods.toString(expectedResult));
            System.err.println("\t\tGiven Value:\n" + ArraysMethods.toString(result));
            System.err.println();
        //}
        return thisPassed;
    }

    /**
     * Test for getExhibitNamesString method
     * 
     * @param testExhibitionPlan
     * @param testExhibits
     * @param exhibitManagement
     * @param expectedResult
     * @param scenario
     * @return passed
     */
    public static boolean getExhibitNamesStringTestCase(ExhibitionPlan testExhibitionPlan, int[] testExhibits,
            ExhibitManagement exhibitManagement, String[] expectedResult, String scenario) {
    
        String[] result = testExhibitionPlan.getExhibitNamesString(testExhibits, exhibitManagement);
        boolean thisPassed = ArraysMethods.equals(result, expectedResult);
    
        //if (!thisPassed) {
            System.err.println();
            System.err.println("\t\tScenario:" + scenario);
            System.err.println("\t\tGiven: exhibitionPlan is " + testExhibitionPlan);
            System.err.println("\t\tWhen: getExhibitNamesString called with " + exhibitManagement);
            System.err.println("\t\tThen: output is:\n" + ArraysMethods.toString(expectedResult));
            System.err.println("\t\tPassed: " + thisPassed);
            System.err.println("\t\tExpected Value:\n" + ArraysMethods.toString(expectedResult));
            System.err.println("\t\tGiven Value:\n" + ArraysMethods.toString(result));
            System.err.println();
        //}
        return thisPassed;
    }

    /**
     * Test for getExhibitNames method
     * 
     * @param testExhibitionPlan
     * @param exhibitManagement
     * @param expectedResult
     * @param scenario
     * @return passed
     */
    public static boolean getExhibitsNamesTestCase(ExhibitionPlan testExhibitionPlan,
            ExhibitManagement exhibitManagement, String[][] expectedResult, String scenario) {
        String[][] result = testExhibitionPlan.getExhibitNames(exhibitManagement);
        boolean thisPassed = ArraysMethods.deepEquals(result, expectedResult);
    
        //if (!thisPassed) {
            System.err.println();
            System.err.println("\t\tScenario:" + scenario);
            System.err.println("\t\tGiven: exhibitionPlan is " + testExhibitionPlan);
            System.err.println("\t\tWhen: getExhibitNames called with " + exhibitManagement);
            System.err.println("\t\tThen: output is:\n" + ArraysMethods.deepToString(expectedResult));
            System.err.println("\t\tPassed: " + thisPassed);
            System.err.println("\t\tExpected Value:\n" + ArraysMethods.deepToString(expectedResult));
            System.err.println("\t\tGiven Value:\n" + ArraysMethods.deepToString(result));
            System.err.println();
        //}
        return thisPassed;
    }

    /**
     * Test for getExhibitsInHall method
     * 
     * @param testExhibitionPlan
     * @param testHall
     * @param expectedResult
     * @param scenario
     * @return passed
     */
    public static boolean getExhibitsInHallTestCase(ExhibitionPlan testExhibitionPlan, int testHall,
            int[] expectedResult, String scenario) {
    
        PrintStream stderr = System.err;
        ByteArrayOutputStream errorOutput = new ByteArrayOutputStream();
        System.setErr(new PrintStream(errorOutput));
    
        int[] result = testExhibitionPlan.getExhibitsInHall(testHall);
        boolean thisPassed = ArraysMethods.equals(expectedResult, result);
        System.setErr(stderr);
    
       // if (!thisPassed) {
            System.err.println();
            System.err.println("\t\tScenario:" + scenario);
            System.err.println("\t\tGiven: exhibitionPlan is " + testExhibitionPlan);
            System.err.println("\t\tWhen: getExhibitsInHall called with hall num " + testHall);
            System.err.println("\t\tThen: output is:\n" + ArraysMethods.toString(expectedResult));
            System.err.println("\t\tPassed: " + thisPassed);
            System.err.println("\t\tExpected Value:\n" + ArraysMethods.toString(expectedResult));
            System.err.println("\t\tGiven Value:\n" + ArraysMethods.toString(result));
            System.err.println();
        //}
        return thisPassed;
    }

    /**
     * Test for the getExhibitsInMonth with a Months int id
     * 
     * @param testExhibitionPlan
     * @param testMonth
     * @param expectedResult
     * @param scenario
     * @return passed
     */
    public static boolean getExhibitsInMonthTestCase(ExhibitionPlan testExhibitionPlan, int testMonth,
            int[] expectedResult, String scenario) {
    
        PrintStream stderr = System.err;
        ByteArrayOutputStream errorOutput = new ByteArrayOutputStream();
        System.setErr(new PrintStream(errorOutput));
    
        int[] result = testExhibitionPlan.getExibitsInMonth(testMonth);
        boolean thisPassed = ArraysMethods.equals(expectedResult, result);
        System.setErr(stderr);
    
        //if (!thisPassed) {
            System.err.println();
            System.err.println("\t\tScenario:" + scenario);
            System.err.println("\t\tGiven: exhibitionPlan is " + testExhibitionPlan);
            System.err.println("\t\tWhen: getExhibitsInMonth called with month id " + testMonth);
            System.err.println("\t\tThen: output is:\n" + ArraysMethods.toString(expectedResult));
            System.err.println("\t\tPassed: " + thisPassed);
            System.err.println("\t\tExpected Value:\n" + ArraysMethods.toString(expectedResult));
            System.err.println("\t\tGiven Value:\n" + ArraysMethods.toString(result));
            System.err.println();
        //}
        return thisPassed;
    }

    /**
     * Test for the getExhibitsInMonth with a Months String
     * 
     * @param testExhibitionPlan
     * @param testMonth
     * @param expectedResult
     * @param scenario
     * @return passed
     */
    public static boolean getExhibitsInMonthTestCase(ExhibitionPlan testExhibitionPlan, String testMonth,
            int[] expectedResult, String scenario) {
    
        PrintStream stderr = System.err;
        ByteArrayOutputStream errorOutput = new ByteArrayOutputStream();
        System.setErr(new PrintStream(errorOutput));
    
        int[] result = testExhibitionPlan.getExibitsInMonth(testMonth);
        boolean thisPassed = ArraysMethods.equals(expectedResult, result);
        System.setErr(stderr);
    
        //if (!thisPassed) {
            System.err.println();
            System.err.println("\t\tScenario:" + scenario);
            System.err.println("\t\tGiven: exhibitionPlan is " + testExhibitionPlan);
            System.err.println("\t\tWhen: getExhibitsInMonth called with month String " + testMonth);
            System.err.println("\t\tThen: output is:\n" + ArraysMethods.toString(expectedResult));
            System.err.println("\t\tPassed: " + thisPassed);
            System.err.println("\t\tExpected Value:\n" + ArraysMethods.toString(expectedResult));
            System.err.println("\t\tGiven Value:\n" + ArraysMethods.toString(result));
            System.err.println();
        //}
        return thisPassed;
    }

    /**
     * Test for the getExhibitsInMonth with a Months Enum
     * 
     * @param testExhibitionPlan
     * @param testMonth
     * @param expectedResult
     * @param scenario
     * @return passed
     */
    public static boolean getExhibitsinMonthTestCase(ExhibitionPlan testExhibitionPlan, Months testMonth,
            int[] expectedResult, String scenario) {
        int[] result = testExhibitionPlan.getExibitsInMonth(testMonth);
        boolean thisPassed = ArraysMethods.equals(expectedResult, result);
    
        //if (!thisPassed) {
            System.err.println();
            System.err.println("\t\tScenario:" + scenario);
            System.err.println("\t\tGiven: exhibitionPlan is " + testExhibitionPlan);
            System.err.println("\t\tWhen: getExhibitsInMonth called with Months enum " + testMonth);
            System.err.println("\t\tThen: output is:\n" + ArraysMethods.toString(expectedResult));
            System.err.println("\t\tPassed: " + thisPassed);
            System.err.println("\t\tExpected Value:\n" + ArraysMethods.toString(expectedResult));
            System.err.println("\t\tGiven Value:\n" + ArraysMethods.toString(result));
            System.err.println();
        //}
        return thisPassed;
    }

    /**
     * Test for getExhibitionPlan method
     * 
     * @param testExhibitionPlan
     * @param expectedResult
     * @param scenario
     * @return passed
     */
    public static boolean getExhibitionPlan(ExhibitionPlan testExhibitionPlan, int[][] expectedResult,
            String scenario) {
        int[][] result = testExhibitionPlan.getExhibitionPlan();
        boolean thisPassed = ArraysMethods.deepEquals(result, expectedResult);
    
        //if (!thisPassed) {
            System.err.println();
            System.err.println("\t\tScenario:" + scenario);
            System.err.println("\t\tGiven: exhibitionPlan is " + testExhibitionPlan);
            System.err.println("\t\tWhen: getExhibitionPlan called");
            System.err.println("\t\tThen: output is:\n" + ArraysMethods.deepToString(expectedResult));
            System.err.println("\t\tPassed: " + thisPassed);
            System.err.println("\t\tExpected Value:\n" + ArraysMethods.deepToString(expectedResult));
            System.err.println("\t\tGiven Value:\n" + ArraysMethods.deepToString(result));
            System.err.println();
        //}
        return thisPassed;
    }

    /**
     * Test for getNumberOfHalls method
     * 
     * @param testExhibitionPlan
     * @param expectedResult
     * @param scenario
     * @return passed
     */
    public static boolean getNumberOfHallsTestCase(ExhibitionPlan testExhibitionPlan, int expectedResult,
            String scenario) {
        int result = testExhibitionPlan.getNumberOfHalls();
        boolean thisPassed = result == expectedResult;
    
        //if (!thisPassed) {
            System.err.println();
            System.err.println("\t\tScenario:" + scenario);
            System.err.println("\t\tGiven: exhibitionPlan data " + testExhibitionPlan);
            System.err.println("\t\tWhen: getNumberOfHalls called");
            System.err.println("\t\tThen: output is:\n" + expectedResult);
            System.err.println("\t\tPassed: " + thisPassed);
            System.err.println("\t\tExpected Value:\n" + expectedResult);
            System.err.println("\t\tGiven Value:\n" + result);
            System.err.println();
        //}
        return thisPassed;
    }

    /**
     * Test for ExhibitionPlan constructor
     * 
     * @param testExhibionPlan
     * @param exhibitManagement
     * @param expectedResult
     * @param scenario
     * @return passed
     */
    public static boolean constructorTestCase(int[][] testExhibitionPlan, ExhibitManagement exhibitManagement,
            String expectedResult, String scenario) {
        String result = "";
        try {
            new ExhibitionPlan(testExhibitionPlan, exhibitManagement);
            result = "no exception";
        } catch (Exception e) {
            if (e.getMessage().equals("Incorrect number of Months")) {
                result = "Incorrect Months Exception";
            } else if (e.getMessage().equals("Exhibits that share Artifacts in the same Month")) {
                result = "duplicate artifacts exception";
            } else {
                result = e.getMessage();
            }
        }
        boolean thisPassed = result.equals(expectedResult);
    
        //if (!thisPassed) {
            System.err.println();
            System.err.println("\t\tScenario:" + scenario);
            System.err.println("\t\tGiven: exhibitionPlan data " + ArraysMethods.deepToString(testExhibitionPlan));
            System.err.println("\t\tWhen: new ExhibitionPlan with " + ArraysMethods.deepToString(testExhibitionPlan));
            System.err.print("\t\tAND: " + exhibitManagement);
            System.err.println("\t\tThen: output is:\n" + expectedResult);
            System.err.println("\t\tPassed: " + thisPassed);
            System.err.println("\t\tExpected Value:\n" + expectedResult);
            System.err.println("\t\tGiven Value:\n" + result);
            System.err.println();
        //}
        return thisPassed;
    
    }
    
}
