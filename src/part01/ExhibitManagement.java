package part01;

import java.util.ArrayList;

public class ExhibitManagement {

    private ArrayList<Exhibit> exhibits; // List of all the exhibits in oredr of ascending ID
    private Exhibit[] exhibitArray; // Array of the exhibits -> Used by QUBMuseum to be sorted and searched, does not always contain all the exhibits

    /**
     * Default Constructor that defines an empty list of artifacts
     */
    public ExhibitManagement() {
        this.exhibits = new ArrayList<Exhibit>();
        this.exhibitArray = exhibitsToArray();
    }

    /**
     * Constructor that takes an initial list of Exhibits
     * @param exhibits -> List of exhibits that cannot contain null
     * @throws Exception if exhibits contains null
     */
    public ExhibitManagement(ArrayList<Exhibit> exhibits) throws Exception {
        for (Exhibit exhibit : exhibits) {
            if (exhibit == null) {
                throw new Exception("exhibits cannot contain null");
            }
        }
        this.exhibits = exhibits;
        this.exhibitArray = exhibitsToArray();
    }

    /**
     * 
     * @return list of exhibits
     */
    public ArrayList<Exhibit> getExhibits() {
        return this.exhibits;
    }

    /**
     * 
     * @return array of Exhibits
     */
    public Exhibit[] getExhibitArray() {
        return this.exhibitArray;
    }

    /**
     * 
     * @return length of exhibitArray
     */
    public int getExhibitArrayLength() {
        return getExhibitArray().length;
    }

    /**
     * Add a new exhibit to exhibits
     * @param name -> new exhibit name
     * @param artifacts -> List of Artifact IDs for exhibit, in correct order
     * @param route -> List of Signs for exhibit, in the same order as Artifacts
     * @return true if successful, false is not successful
     */
    public boolean addExhibit(String name, ArrayList<Integer> artifacts, ArrayList<String> route) {
        try {
            Exhibit exhibit = new Exhibit(name, artifacts, route);
            this.exhibits.add(exhibit);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    /**
     * Turn exhibitArray into a menu of names with Search, Clear and Quit options appended
     * @return Menu of exhibit names
     */
    public Menu exhibitsMenu() {
        String[] exhibitNames = exhibitArrayToNameArray();
        String[] quit = { "Search", "Clear", "Quit" };
        String[] exhibitOptions = Utils.concat(exhibitNames, quit);
        Menu artifactMenu = new Menu("Exhibits", exhibitOptions);
        return artifactMenu;
    }

    /**
     * Turn the exhibits property into an array
     * @return array form of exhibits list
     */
    public Exhibit[] exhibitsToArray() {
        Exhibit[] exhibitArray = new Exhibit[this.exhibits.size()];
        for (int i = 0; i < exhibitArray.length; i++) {
            exhibitArray[i] = this.exhibits.get(i);
        }
        return exhibitArray;
    }

    /**
     * Turn a list of exhibits into an Array
     * @param exhibits list to operate on
     * @return array of exhibits
     */
    public static Exhibit[] exhibitsToArray(ArrayList<Exhibit> exhibits) {
        Exhibit[] exhibitArray = new Exhibit[exhibits.size()];
        for (int i = 0; i < exhibitArray.length; i++) {
            exhibitArray[i] = exhibits.get(i);
        }
        return exhibitArray;
    }

    /**
     * Get an array of names for every exhibit exhibitArray
     * @return array of exhibit names
     */
    public String[] exhibitArrayToNameArray() {
        String[] nameArray = new String[exhibitArray.length];
        for (int i = 0; i < exhibitArray.length; i++) {
            nameArray[i] = exhibitArray[i].getName();
        }
        return nameArray;
    }

    /**
     * Sort the exhibitArray into alphabetical order by name
     */
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

    /**
     * Search the exhibitArray for a value that matches a property
     * Will change exhibitArray so it only contains exhibits that match the 
     * search criteria
     * @param criteriaChoice -> property of exhibit to search in: name or ID
     * @param searchValue -> value to search for
     * @return
     */
    public boolean searchExhibits(int criteriaChoice, String searchValue) {

        ArrayList<Exhibit> searchResults = new ArrayList<Exhibit>();
        switch (criteriaChoice) {
            case 1: // Does ID match searchValue
                int id = Integer.valueOf(searchValue);
                for (int i = 0; i < this.exhibitArray.length; i++) {
                    if (this.exhibitArray[i].getID() == id) {
                        searchResults.add(this.exhibitArray[i]);
                    }
                }
                break;
            case 2: // Does Name contain searchValue, Case Insensitive
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

    /**
     * Rescalcute exhibitArray so if reflects exhibits list
     */
    public void refreshExhibitArray() {
        this.exhibitArray = exhibitsToArray();
    }

    /**
     * Get sorted menu of exhibit names
     * @return sorted Menu of exhibit Names
     */
    public Menu getExhibitMenu() {
        sortExhibitArray();
        return exhibitsMenu();
    }

    /**
     * Get a String of an exhibit
     * contains:
     * ID, Name
     * List of Artifact Names
     * List of Artifact Names And Associated Sign
     * Total Engagement Time
     * @param exhibitChoice
     * @param artifactManagement
     * @return
     */
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

    /**
     * remove an exhibit fron exhibits list
     * @param exhibitID 
     * @return was removal successful
     */
    public boolean removeExhibit(int exhibitID) {
        try{
            int maxID = exhibits.get(exhibits.size()-1).getID();
            int idDiff = maxID+1-exhibits.size(); // difference between maxID and length is the amount of exhibits that have been removed 
                                                  // ID is adjusted by this to get an index
            exhibits.remove(exhibitID-idDiff); //Stored in exhibits in order so id-diff is the index
            return true;
        } catch(Exception e){
            return false;
        }
    }

    /**
     * get the names of the artifacts in an exhibit
     * @param exhibitChoice index of exhibit in exhibitArray
     * @param artifactManagement
     * @return array of artifact names
     */
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

    /**
     * get a menu for the artifacts in an exhibit
     * @param exhibitChoice index of exhibit in exhibitArray
     * @param artifactManagement
     * @return menu of exhibit artifacts
     */
    public Menu getExhibitArtifactMenu(int exhibitChoice, ArtifactManagement artifactManagement) {
        String[] artifactNames = getExhibitArtifactNames(exhibitChoice, artifactManagement);
        String[] quitOption = { "Quit" };
        String[] artifactOptions = Utils.concat(artifactNames, quitOption);
        return new Menu("Artifact To Change", artifactOptions);
    }

    /**
     * Get the number of artifacts in an exhibit
     * @param exhibitChoice index of exhibit in exhibitArray
     * @return number of artifacts
     */
    public int getArtifactNumber(int exhibitChoice) {
        try {
            Exhibit exhibit = this.exhibitArray[exhibitChoice];
            return exhibit.getArtifactsID().size();
        } catch (Exception e) {
            System.err.println("exhibitChoice out of range");
            return -1;
        }
    }

    /**
     * get the route of an exhibit
     * @param exhibitChoice index of exhibit in exhibitArray
     * @return exhibit route
     */
    public ArrayList<String> getExhibitRoute(int exhibitChoice) {
        try {
            Exhibit exhibit = this.exhibitArray[exhibitChoice];
            return exhibit.getRoute();
        } catch (Exception e) {
            System.err.println("exhibitChoice out of range");
            return new ArrayList<>();
        }
    }

    /**
     * get the artifacts in an exhibit
     * @param exhibitChoice index of exhibit in exhibitArray
     * @return exhibit artifacts
     */
    public ArrayList<Integer> getExhibitArtifacts(int exhibitChoice) {
        try {
            Exhibit exhibit = this.exhibitArray[exhibitChoice];
            return exhibit.getArtifactsID();
        } catch (Exception e) {
            System.err.println("exhibitChoice out of range");
            return new ArrayList<>();
        }
    }

    /**
     * get artifacts in an exhibit
     * @param exhibitID ID of an exhibit
     * @return exhibit artifacts
     */
    public ArrayList<Integer> getExhibitArtifactsByID(int exhibitID) {
        for (int i = 0; i < exhibitArray.length; i++) {
            if (exhibitArray[i].getID() == exhibitID) {
                Exhibit exhibit = this.exhibitArray[i];
                return exhibit.getArtifactsID();
            }
        }
        return new ArrayList<Integer>();

    }

    /**
     * Update exhibit properties
     * @param exhibitChoice index of exhibit in exhibitArray
     * @param name new name -> "" will leave unchanged
     * @param artifacts new artifact IDs list
     * @param route new list of signs
     * @return
     */
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

    /**
     * Update exhibit properties
     * @param exhibitChoice index of exhibit in exhibitArray
     * @param name new name -> "" will leave unchanged
     * @param artifacts new artifact IDs list
     * @param route new list of signs
     * @return
     */
    public boolean updateExhibitByID(String name, ArrayList<Integer> artifacts,
            ArrayList<String> route, int exhibitID) {

        Exhibit exhibit = null;
        try {
            exhibit = findExhibit(exhibitID);

        } catch (Exception e) {
            System.err.println("exhibitChoice out of range");
            return false;
        }

        try {
            exhibit.setArtifactsAndRoute(artifacts, route);
            if (!name.equals("")) {
                exhibit.setName(name);
            }
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    /**
     * Remove artifacts and their sign if there id matches
     * @param id id of artifacts to remove
     */
    public void removeArtifactsWithID(int id) {
        for (int i = 0; i < exhibits.size(); i++) {
            Exhibit exhibit = exhibits.get(i);
            int artifactIndex = exhibit.findArtifactIndex(id);
            if (artifactIndex != -1) {
                try {
                    exhibit.removeArtifact(artifactIndex);
                } catch (Exception e) {
                    System.err.println("exhibit artifact removal failed");
                }
            }

        }
    }

    /**
     * get the names of exhibits who are in a array of IDs
     * @param exhibitIDs list of IDs to get the names of
     * @return array of exhibit names
     */
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

     /**
     * get the names of exhibits who are in a 2D array of IDs
     * @param exhibitIDs list of IDs to get the names of
     * @return array of exhibit names
     */
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

    /**
     * find the exhibit with ID
     * @param id ID of exhiobit to find
     * @return 
     * @throws Exception if there is no exhibit with id
     */
    public Exhibit findExhibit(int id) throws Exception {
        for (int i = 0; i < this.exhibits.size(); i++) {
            if (this.exhibits.get(i).getID() == id) {
                return exhibits.get(i);
            }
        }
        throw new Exception("No mathcing id in list");
    }

    /**
     * Get the Id of exhibit
     * @param choice index of exhibit in exhibitArray
     * @return exhibit ID
     */
    public int getExhibitID(int choice) {
        try {
            Exhibit exhibit = this.exhibitArray[choice];
            return exhibit.getID();
        } catch (Exception e) {
            System.err.println("exhibitChoice out of range");
            return -1;
        }
    }

    /**
     * Check if exhibits in ID array share any artifacts
     * @param exhibits array of exhibit Ids
     * @return true if artifacts are shared
     */
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

    /**
     * Check if the newExhibit shares artifacts with any exhibit in ogExhibits
     * Except the exhibit at the index newExhibitLoc
     * @param ogExhibits array of exhibit IDs to check against
     * @param newExhibit new exhibit ID
     * @param newExhibitLoc intended index for the new exhibit
     * @return true if artifacts are shared
     */
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

    /**
     * Gets a string form of the exhibits list
     * Mainly for testing
     */
    @Override
    public String toString() {
        return getExhibits().toString();
    }

}
