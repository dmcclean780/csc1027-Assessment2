package part01;

import java.util.ArrayList;
import java.util.Scanner;

public class ExhibitManagement {

    private ArrayList<Exhibit> exhibits;
    private Exhibit[] exhibitArray;

    public ExhibitManagement() {
        this.exhibits = new ArrayList<Exhibit>();
        this.exhibitArray = exhibitsToArray();
    }

    public ArrayList<Exhibit> getExhibits() {
        return this.exhibits;
    }

    public Exhibit[] getExhibitArray() {
        return this.exhibitArray;
    }

    public int getExhibitArrayLength() {
        return getExhibitArray().length;
    }

    public void addExhibit(String name, ArrayList<Integer> artifacts, ArrayList<String> route) {
        try {
            Exhibit exhibit = new Exhibit(name, artifacts, route);
            this.exhibits.add(exhibit);
        } catch (Exception e) {
            System.out.println("Bad Data");
        }

    }

    public static Menu exhibitsMenu(Exhibit[] exhibitArray) {
        String[] exhibitNames = exhibitArrayToNameArray(exhibitArray);
        String[] quit = { "Search", "Clear", "Quit" };
        String[] exhibitOptions = Utils.concat(exhibitNames, quit);
        Menu artifactMenu = new Menu("Artifacts", exhibitOptions);
        return artifactMenu;
    }

    public Exhibit[] exhibitsToArray() {
        Exhibit[] exhibitArray = new Exhibit[this.exhibits.size()];
        for (int i = 0; i < exhibitArray.length; i++) {
            exhibitArray[i] = this.exhibits.get(i);
        }
        return exhibitArray;
    }

    public static Exhibit[] exhibitsToArray(ArrayList<Exhibit> exhibits) {
        Exhibit[] exhibitArray = new Exhibit[exhibits.size()];
        for (int i = 0; i < exhibitArray.length; i++) {
            exhibitArray[i] = exhibits.get(i);
        }
        return exhibitArray;
    }

    public static String[] exhibitArrayToNameArray(Exhibit[] exhibitArray) {
        String[] nameArray = new String[exhibitArray.length];
        for (int i = 0; i < exhibitArray.length; i++) {
            nameArray[i] = exhibitArray[i].getName();
        }
        return nameArray;
    }

    public static Exhibit[] sort(Exhibit[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j].getName().compareTo(array[j + 1].getName()) > 0) {
                    Exhibit temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }

    public boolean searchExhibits(Scanner input, int criteriaChoice, String searchValue) {

        ArrayList<Exhibit> searchResults = new ArrayList<Exhibit>();
        switch (criteriaChoice) {
            case 1:
                while (true) {
                    int id = Integer.valueOf(searchValue);
                    for (int i = 0; i < this.exhibitArray.length; i++) {
                        if (this.exhibitArray[i].getId() == id) {
                            searchResults.add(exhibitArray[i]);
                        }
                    }
                    break;
                }
                break;

            case 2:
                for (int i = 0; i < exhibitArray.length; i++) {
                    String exhibitName = exhibitArray[i].getName();
                    if (exhibitName.equals(searchValue)) {
                        searchResults.add(exhibitArray[i]);
                    }
                }

                break;
        }
        if (searchResults.size() == 0) {
            return false;
        } else {
            this.exhibitArray = exhibitsToArray(searchResults);
            return true;
        }

    }

    public void refreshExhibitArray() {
        this.exhibitArray = exhibitsToArray();
    }

    public Menu getExhibitMenu() {
        this.exhibitArray = sort(this.exhibitArray);
        return exhibitsMenu(this.exhibitArray);
    }

    public String getExhibitString(int exhibitChoice, ArtifactManagement artifactManagement) {
        Exhibit exhibit = this.exhibitArray[exhibitChoice];

        Artifact[] artifactArray = exhibit.getArtifacts(artifactManagement.getArtifacts());

        String[] routeArray = exhibit.getRouteArray();

        String exhibitString = exhibit.toString() + "\nArtifacts for the Exhibit\n";
        for (int i = 0; i < artifactArray.length; i++) {
            exhibitString += artifactArray[i].getName() + "\n";
        }
        exhibitString += "\nRoute:\nSteps:\tSigns\n";
        for (int i = 0; i < artifactArray.length; i++) {
            exhibitString += (i + 1) + ". " + artifactArray[i].getName() + "\t" + routeArray[i] + "\n";
        }
        return exhibitString;
    }

    public void removeExhibit(int exhibitChoice) {
        this.exhibits.remove(exhibitChoice);
    }

    public String[] getExhibitArtifactNames(int exhibitChoice, ArtifactManagement artifactManagement) {
        Exhibit exhibit = this.exhibitArray[exhibitChoice];
        Artifact[] artifactArray = exhibit.getArtifacts(artifactManagement.getArtifacts());
        String[] artifactNames = new String[artifactArray.length];
        for (int i = 0; i < artifactArray.length; i++) {
            artifactNames[i] = artifactArray[i].getName();
        }
        return artifactNames;
    }

    public Menu getExhibitArtifactMenu(int exhibitChoice, ArtifactManagement artifactManagement){
        String[] artifactNames = getExhibitArtifactNames(exhibitChoice, artifactManagement);
        String[] quitOption = {"Quit"};
        String[] artifactOptions = Utils.concat(artifactNames, quitOption);
        return new Menu("Artifact To Change", artifactOptions);
    }

    public int getArtifactNumber(int exhibitChoice){
        Exhibit exhibit = this.exhibitArray[exhibitChoice];
        return exhibit.getArtifactsID().size();
    }

    public ArrayList<String> getExhibitRoute(int exhibitChoice){
        Exhibit exhibit = this.exhibitArray[exhibitChoice];
        return exhibit.getRoute();
    }

    public ArrayList<Integer> getExhibitArtifacts(int exhibitChoice){
        Exhibit exhibit = this.exhibitArray[exhibitChoice];
        return exhibit.getArtifactsID();
    }

    public boolean updateExhibit(int exhibitChoice, String name, ArrayList<Integer> artifacts, ArrayList<String> route){
        Exhibit exhibit = this.exhibitArray[exhibitChoice];
        
        try{
            exhibit.setArtifactsID(artifacts);
            exhibit.setRoute(route);
            if(name != ""){
                exhibit.setName(name);
            }
            return true;
        }catch(Exception e){
            return false;
        }
       
    }
}
