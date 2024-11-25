package part02;

import java.util.ArrayList;
import java.util.Random;

import part01.Artifact;
import part01.ArtifactManagement;
import part01.Exhibit;
import part01.ExhibitManagement;
import part01.ExhibitionPlan;

public class Resources {
    private static int exhibitManagementFirstID = 0;
    private static int artifactManagementFirstID = 0;

    /**
     * Helper method to create an Artifact
     * @return
     */
    public static Artifact createTestArtifact(){
        try{
            return new Artifact("test", "artifact", 4);
        } catch(Exception e){
            return null;
        }
    }

    /**
     * Helper method to create an Artifact with a unique property
     * @return
     */
    public static Artifact createTestArtifact(int unique){
        try{
            return new Artifact("test"+unique, "artifact"+unique, 4+unique);
        } catch(Exception e){
            return null;
        }
    }

    /**
     * Helper Method to create artifactManagement
     * @return
     */
    public static ArtifactManagement createTestArtifactManagement(){
        ArrayList<Artifact> testArtifacts = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            testArtifacts.add(createTestArtifact());
        }
        artifactManagementFirstID = testArtifacts.get(0).getID();
        try{
            return new ArtifactManagement(testArtifacts);
        } catch(Exception e){
            return null;
        }
    }

    /**
     * Helper Method to create a the default artifactManagement
     * @return 
     */
    public static ArtifactManagement createEmptyTestArtifactManagement(){
        return new ArtifactManagement();
    }

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
     * Helper method to create an exhibit for testing
     * 
     * @return new Exhibit
     */
    public static Exhibit createTestExhibitWithName(int i) {
        String testName = "test"+i;
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
     * Helper Method to create Exhibit with random artifact IDs based on a seed
     * 
     * @param i
     * @return new Exhibit
     */
    public static Exhibit createTestExhibitWithRealArtifacts(int i) {
        String testName = "test";
        ArrayList<Integer> testArtifacts = new ArrayList<>();
        testArtifacts.add(i);
        ArrayList<String> testRoute = new ArrayList<>();
        testRoute.add("a");
        try {
            return new Exhibit(testName, testArtifacts, testRoute);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Create test exhibit management filled with artifacts from an artifact management
     * @param artifactManagement
     * @return
     */
    public static ExhibitManagement createTestExhibitManagement(ArtifactManagement artifactManagement){
        ArrayList<Exhibit> testExhibits = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            testExhibits.add(createTestExhibitWithRealArtifacts(artifactManagementFirstID+i));
        }
        exhibitManagementFirstID = testExhibits.get(0).getID();
        try{
            return new ExhibitManagement(testExhibits);
        } catch(Exception e){
            return null;
        }
    }

    /**
     * Create empty test exhibit management
     * @param artifactManagement
     * @return
     */
    public static ExhibitManagement createEmptyTestExhibitManagement(){
        return new ExhibitManagement();
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
        exhibitManagementFirstID = testExhibits.get(0).getID();
        try{
            return new ExhibitManagement(testExhibits);
        } catch(Exception e){
            return null;
        }
    }

     /**
     * Helper method to create an Exhibit Managemnet filled with exhibits with
     * the same artifacts
     * 
     * @return
     */
    public static ExhibitManagement createTestExhibitManagement(boolean duplicateArtifact) {
        ArrayList<Exhibit> testExhibits = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            testExhibits.add(createTestExhibit());
        }
        exhibitManagementFirstID = testExhibits.get(0).getID();
        try{
            return new ExhibitManagement(testExhibits);
        } catch(Exception e){
            return null;
        }
    }

    public static ExhibitionPlan createTestExhibitionPlan(ExhibitManagement exhibitManagement) {
        int[][] testExhibionPlan = { { exhibitManagementFirstID + 0, exhibitManagementFirstID + 1, exhibitManagementFirstID + 2 },
                { exhibitManagementFirstID + 0, exhibitManagementFirstID + 2, exhibitManagementFirstID + 1 },
                { exhibitManagementFirstID + 1, exhibitManagementFirstID + 0, exhibitManagementFirstID + 2 },
                { exhibitManagementFirstID + 1, exhibitManagementFirstID + 2, exhibitManagementFirstID + 0 },
                { exhibitManagementFirstID + 2, exhibitManagementFirstID + 0, exhibitManagementFirstID + 1 },
                { exhibitManagementFirstID + 2, exhibitManagementFirstID + 1, exhibitManagementFirstID + 0 },
                { exhibitManagementFirstID + 0, exhibitManagementFirstID + 1, exhibitManagementFirstID + 3 },
                { exhibitManagementFirstID + 0, exhibitManagementFirstID + 3, exhibitManagementFirstID + 1 },
                { exhibitManagementFirstID + 1, exhibitManagementFirstID + 0, exhibitManagementFirstID + 3 },
                { exhibitManagementFirstID + 1, exhibitManagementFirstID + 3, exhibitManagementFirstID + 0 },
                { exhibitManagementFirstID + 3, exhibitManagementFirstID + 1, exhibitManagementFirstID + 0 },
                { exhibitManagementFirstID + 3, exhibitManagementFirstID + 0, exhibitManagementFirstID + 1 } };
        try {
            return new ExhibitionPlan(testExhibionPlan, exhibitManagement);
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Construction Failed");
            return null;
        }

    }

    public static ExhibitionPlan createTestExhibitionPlan(boolean empty,  ExhibitManagement exhibitManagement) {
        int[][] testExhibionPlan = { {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {} };
        try {
            return new ExhibitionPlan(testExhibionPlan, exhibitManagement);
        } catch (Exception e) {
            System.out.println("Construction Failed");
            return null;
        }

    }
}
