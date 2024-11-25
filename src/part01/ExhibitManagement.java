package part01;

import java.util.ArrayList;

public class ExhibitManagement {

    private ArrayList<Exhibit> exhibits;
    private Exhibit[] exhibitArray;

    public ExhibitManagement() {
        this.exhibits = new ArrayList<Exhibit>();
        this.exhibitArray = exhibitsToArray();
    }

    public ExhibitManagement(ArrayList<Exhibit> exhibits) throws Exception {
        for (Exhibit exhibit : exhibits) {
            if (exhibit == null) {
                throw new Exception("exhibits cannot contain null");
            }
        }
        this.exhibits = exhibits;
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

    public boolean addExhibit(String name, ArrayList<Integer> artifacts, ArrayList<String> route) {
        try {
            Exhibit exhibit = new Exhibit(name, artifacts, route);
            this.exhibits.add(exhibit);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public Menu exhibitsMenu() {
        String[] exhibitNames = exhibitArrayToNameArray();
        String[] quit = { "Search", "Clear", "Quit" };
        String[] exhibitOptions = Utils.concat(exhibitNames, quit);
        Menu artifactMenu = new Menu("Exhibits", exhibitOptions);
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

    public String[] exhibitArrayToNameArray() {
        String[] nameArray = new String[exhibitArray.length];
        for (int i = 0; i < exhibitArray.length; i++) {
            nameArray[i] = exhibitArray[i].getName();
        }
        return nameArray;
    }

    public void sortExhibitArray() {
        for (int i = 0; i < exhibitArray.length; i++) {
            for (int j = 0; j < exhibitArray.length - 1; j++) {
                if (exhibitArray[j].getName().compareTo(exhibitArray[j + 1].getName()) > 0) {
                    Exhibit temp = exhibitArray[j];
                    exhibitArray[j] = exhibitArray[j + 1];
                    exhibitArray[j + 1] = temp;
                }
            }
        }
    }

    public boolean searchExhibits(int criteriaChoice, String searchValue) {

        ArrayList<Exhibit> searchResults = new ArrayList<Exhibit>();
        switch (criteriaChoice) {
            case 1:
                int id = Integer.valueOf(searchValue);
                for (int i = 0; i < this.exhibitArray.length; i++) {
                    if (this.exhibitArray[i].getID() == id) {
                        searchResults.add(this.exhibitArray[i]);
                    }
                }
                break;
            case 2:
                for (int i = 0; i < this.exhibitArray.length; i++) {
                    String exhibitName = this.exhibitArray[i].getName();
                    if (exhibitName.toLowerCase().contains(searchValue.toLowerCase())) {
                        searchResults.add(this.exhibitArray[i]);
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
        sortExhibitArray();
        return exhibitsMenu();
    }

    public String getExhibitString(int exhibitChoice, ArtifactManagement artifactManagement) {

        Exhibit exhibit = null;
        try {
            exhibit = this.exhibitArray[exhibitChoice];
        } catch (Exception e) {
            return "exhibit choice out of range";
        }

        String[] artifactNames = (artifactManagement == null) ? new String[0]
                : artifactManagement.getArtifactNames(exhibit.getArtifactsID());
        int totalEngagementTime = (artifactManagement == null) ? 0
                : artifactManagement.getExhibitEngagmentTime(exhibit.getArtifactsID());

        String[] routeArray = exhibit.getRouteArray();

        String exhibitString = exhibit.toString() + "\nArtifacts for the Exhibit\n";
        for (int i = 0; i < artifactNames.length; i++) {
            exhibitString += artifactNames[i] + "\n";
        }
        exhibitString += "\nRoute:\nSteps                                      Signs\n";
        for (int i = 0; i < artifactNames.length; i++) {
            exhibitString += (i + 1) + ". " + artifactNames[i];
            for (int j = 0; j < 40 - artifactNames[i].length(); j++) {
                exhibitString += " ";
            }
            exhibitString += routeArray[i] + "\n";
        }
        exhibitString += "\nTotal Engagement Time: " + totalEngagementTime + " minutes\n";
        return exhibitString;

    }

    public boolean removeExhibit(int exhibitChoice) {
        try {
            this.exhibits.remove(exhibitChoice);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String[] getExhibitArtifactNames(int exhibitChoice, ArtifactManagement artifactManagement) {
        Exhibit exhibit = null;
        try {
            exhibit = this.exhibitArray[exhibitChoice];
        } catch (Exception e) {
            System.err.println("exhibitChoice out of range");
            return new String[0];
        }

        Artifact[] artifactArray = (artifactManagement == null) ? new Artifact[0]
                : artifactManagement.getExhibitArtifacts(exhibit.getArtifactsID());
        String[] artifactNames = new String[artifactArray.length];
        for (int i = 0; i < artifactArray.length; i++) {
            artifactNames[i] = artifactArray[i].getName();
        }
        return artifactNames;
    }

    public Menu getExhibitArtifactMenu(int exhibitChoice, ArtifactManagement artifactManagement) {
        String[] artifactNames = getExhibitArtifactNames(exhibitChoice, artifactManagement);
        String[] quitOption = { "Quit" };
        String[] artifactOptions = Utils.concat(artifactNames, quitOption);
        return new Menu("Artifact To Change", artifactOptions);
    }

    public int getArtifactNumber(int exhibitChoice) {
        try {
            Exhibit exhibit = this.exhibitArray[exhibitChoice];
            return exhibit.getArtifactsID().size();
        } catch (Exception e) {
            System.err.println("exhibitChoice out of range");
            return -1;
        }
    }

    public ArrayList<String> getExhibitRoute(int exhibitChoice) {
        try {
            Exhibit exhibit = this.exhibitArray[exhibitChoice];
            return exhibit.getRoute();
        } catch (Exception e) {
            System.err.println("exhibitChoice out of range");
            return new ArrayList<>();
        }
    }

    public ArrayList<Integer> getExhibitArtifacts(int exhibitChoice) {
        try {
            Exhibit exhibit = this.exhibitArray[exhibitChoice];
            return exhibit.getArtifactsID();
        } catch (Exception e) {
            System.err.println("exhibitChoice out of range");
            return new ArrayList<>();
        }
    }

    public ArrayList<Integer> getExhibitArtifactsByID(int exhibitID) {
        for (int i = 0; i < exhibitArray.length; i++) {
            if (exhibitArray[i].getID() == exhibitID) {
                Exhibit exhibit = this.exhibitArray[i];
                return exhibit.getArtifactsID();
            }
        }
        return new ArrayList<Integer>();

    }

    public boolean updateExhibit(int exhibitChoice, String name, ArrayList<Integer> artifacts,
            ArrayList<String> route) {

        Exhibit exhibit = null;
        try {
            exhibit = this.exhibitArray[exhibitChoice];

        } catch (Exception e) {
            System.err.println("exhibitChoice out of range");
            return false;
        }

        try {
            exhibit.setArtifactsAndRoute(artifacts, route);
            if (name != "") {
                exhibit.setName(name);
            }
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public void removeArtifactsWithID(int id) {
        for (int i = 0; i < exhibits.size(); i++) {
            Exhibit exhibit = exhibits.get(i);
            int artifactIndex = exhibit.findArtifactIndex(id);
            if (artifactIndex != -1) {
                try {
                    exhibit.removeArtifact(artifactIndex);
                } catch (Exception e) {
                    removeArtifactsWithID(id); // Try Again
                }
            }

        }
    }

    public String[] getExhibitionExhibtNames(int[] exhibitIDs) {
        if(exhibitIDs == null){
            return new String[0];
        }
        String[] exhibitNames = new String[exhibitIDs.length];
        for (int i = 0; i < exhibitIDs.length; i++) {
            for (int j = 0; j < this.exhibits.size(); j++) {
                if (this.exhibits.get(j).getID() == exhibitIDs[i]) {
                    exhibitNames[i] = this.exhibits.get(j).getName();
                }
            }
            if(exhibitNames[i] == null){
                exhibitNames[i] = "Exhibit not Found";
            }
        }
        return exhibitNames;
    }

    public String[][] getExhibitionExhibtNames(int[][] exhibitIDs) {
        if(exhibitIDs == null){
            return new String[0][0];
        }
        int m=-1;
        for(int i=0; i<exhibitIDs.length; i++){
            if(exhibitIDs[i] != null){
                m=i;
                break;
            }
        }
        if(m==-1){
            return new String[0][0];
        }
        String[][] exhibitNames = new String[exhibitIDs.length][exhibitIDs[m].length];
        for (int i = 0; i < exhibitIDs.length; i++) {
            if(exhibitIDs[i] == null){
                exhibitNames[i] = null;
                continue;
            }
            for (int j = 0; j < exhibitIDs[i].length; j++) {
                for (int k = 0; k < this.exhibits.size(); k++) {
                    if (this.exhibits.get(k).getID() == exhibitIDs[i][j]) {
                        exhibitNames[i][j] = this.exhibits.get(k).getName();
                    }
                }
                if(exhibitNames[i][j] == null){
                    exhibitNames[i][j] = "Exhibit not Found";
                }
            }

        }
        return exhibitNames;
    }

    public Exhibit findExhibit(int id) throws Exception {
        for (int i = 0; i < this.exhibits.size(); i++) {
            if (this.exhibits.get(i).getID() == id) {
                return exhibits.get(i);
            }
        }
        throw new Exception("No mathcing id in list");
    }

    public int getExhibitID(int choice) {
        try {
            Exhibit exhibit = this.exhibitArray[choice];
            return exhibit.getID();
        } catch (Exception e) {
            System.err.println("exhibitChoice out of range");
            return -1;
        }
    }

    public boolean anyDuplicateArtifcats(int[] exhibits) {
        ArrayList<Integer> hallArtifacts = new ArrayList<>();
        for (int exhibit : exhibits) {
            ArrayList<Integer> exhibitArtifacts = getExhibitArtifactsByID(exhibit);
            for (Integer artifact : exhibitArtifacts) {
                if (Utils.contains(artifact, hallArtifacts)) {
                    return true;
                }
                hallArtifacts.add(artifact);
            }
        }
        return false;
    }

    public boolean anyDuplicateArtifcats(int[] ogExhibits, int newExhibit, int newExhibitLoc) {
        ArrayList<Integer> hallArtifacts = getExhibitArtifactsByID(newExhibit);
        for (int i = 0; i < ogExhibits.length; i++) {
            int exhibit = ogExhibits[i];
            if (i == newExhibitLoc) {
                continue;
            }
            ArrayList<Integer> exhibitArtifacts = getExhibitArtifactsByID(exhibit);
            for (Integer artifact : exhibitArtifacts) {
                if (Utils.contains(artifact, hallArtifacts)) {
                    return true;
                }
                hallArtifacts.add(artifact);
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return getExhibits().toString();
    }

}
