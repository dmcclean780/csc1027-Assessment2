package part02;

import java.util.ArrayList;
import java.util.Random;

import part01.Exhibit;
import part01.ExhibitManagement;
import part01.ExhibitionPlan;

public class Resources {
    /**
     * Helper method to create an exhibit for testing
     * 
     * @return new Exhibit
     */
    public static Exhibit createTestExhibit() {
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
        try {
            return new Exhibit(testName, testArtifacts, testRoute);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Helper Method to create Exhibit with random artifact IDs based on a seed
     * 
     * @param i
     * @return new Exhibit
     */
    public static Exhibit createTestExhibit(int i) {
        Random generator = new Random(i);
        String testName = "test";
        ArrayList<Integer> testArtifacts = new ArrayList<>();
        testArtifacts.add(generator.nextInt(10000));
        testArtifacts.add(generator.nextInt(10000));
        testArtifacts.add(generator.nextInt(10000));
        testArtifacts.add(generator.nextInt(10000));
        ArrayList<String> testRoute = new ArrayList<>();
        testRoute.add("a");
        testRoute.add("b");
        testRoute.add("c");
        testRoute.add("d");
        try {
            return new Exhibit(testName, testArtifacts, testRoute);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Helper method to create an Exhibit Managemnet filled with exhibits with
     * random artifacts
     * 
     * @return
     */
    public static ExhibitManagement createTestExhibitManagement() {
        ArrayList<Exhibit> testExhibits = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            testExhibits.add(createTestExhibit(i));
        }
        return new ExhibitManagement(testExhibits);
    }

    public static ExhibitionPlan createTestExhibitionPlan() {
        int[][] testExhibionPlan = { { 0, 1, 2 }, { 0, 1, 2 }, { 0, 1, 2 }, { 0, 1, 2 }, { 0, 1, 2 }, { 0, 1, 2 },
                { 0, 1, 2 }, { 0, 1, 2 }, { 0, 1, 2 }, { 0, 1, 2 }, { 0, 1, 2 }, { 0, 1, 2 } };
        ExhibitManagement exhibitManagement = createTestExhibitManagement();
        try{
            return new ExhibitionPlan(testExhibionPlan, exhibitManagement);
        } catch(Exception e){
            System.out.println("Construction Failed");
            return null;
        }

    }

    public static ExhibitionPlan createTestExhibitionPlan(boolean empty) {
        int[][] testExhibionPlan= { {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {} };
        ExhibitManagement exhibitManagement = createTestExhibitManagement();
        try{
            return new ExhibitionPlan(testExhibionPlan, exhibitManagement);
        } catch(Exception e){
            System.out.println("Construction Failed");
            return null;
        }

    }
}
