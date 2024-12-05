package part01;

import java.util.ArrayList;

public class ArtifactManagement {

    private ArrayList<Artifact> artifacts; // List of all the Artifacts -> artifacts in a fixed order of asscending ID
    private Artifact[] artifactArray; // Array of Artifacts -> Used by QUBMuseum to be sorted and searched, does not always contain all the artifacts

    /**
     * Default Constructor for that starts with an empty list of Artifacts
     */
    public ArtifactManagement() {
        this.artifacts = new ArrayList<Artifact>();
        this.artifactArray = artifactsToArray();
    }

    /**
     * Constructor that takes an initial list of Artifacts
     * @param artifacts - List of artifacts that cannot contain a null Artifact
     * @throws Exception - Thrown if an Artifact is null
     */
    public  ArtifactManagement(ArrayList<Artifact> artifacts)  throws Exception{
        for (Artifact artifact : artifacts) {
            if(artifact == null){
                throw new Exception("artifacts cannot contain null");
            }
        }
        this.artifacts=artifacts;
        this.artifactArray=artifactsToArray();
    }

    /**
     * Get the list of Artifacts
     * @return artifacts property
     */
    public ArrayList<Artifact> getArtifacts() {
        return this.artifacts;
    }

    /**
     * Get the Array of Artifacts
     * @return
     */
    public Artifact[] getArtifactArray() {
        return this.artifactArray;
    }

    /**
     * Get the length of the Array Property
     * @return
     */
    public int getArtifactArrayLength() {
        return getArtifactArray().length;
    }

    /**
     * Get the ID of an artifact at a specific index inn the Array
     * @param artifactChoice index of artifact in artifactArray
     * @return artifact ID
     * @throws Exception if artifact chosen is outside the range of the Array
     */
    public int getArtifactID(int artifactChoice) throws Exception{
        if(artifactChoice < 0 || artifactChoice >= this.artifactArray.length){
            throw new Exception("Artifact Choice Out of Range");
        }
        return this.artifactArray[artifactChoice].getID();
    }

    /**
     * Add a new Artifact to the artifacts list
     * @param name
     * @param type
     * @param engagementTime
     * @return true or false if Artifact creation was successful
     */
    public boolean addArtifact(String name, String type, int engagementTime) {
        try {
            Artifact artifact = new Artifact(name, type, engagementTime);
            this.artifacts.add(artifact);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Update the properties of an artifact at a chosen index in the array
     * @param artifactChoice index of artifact in artifactArray
     * @param name -> "" will leave unchanged
     * @param type -> "" will leave unchanged
     * @param engagementTime -> "" will leave unchanged
     * @return boolean if update was successful
     */
    public boolean updateArtifact(int artifactChoice, String name, String type, String engagementTime){
        
        try{
            Artifact artifact = this.artifactArray[artifactChoice];
            if(engagementTime != ""){
                artifact.setEngagementTime(Integer.parseInt(engagementTime));
            }
            if(name != ""){
                artifact.setName(name);
            }
            if(type != ""){
                artifact.setType(type);
            }
            return true;
        }catch (Exception e){
            return false;
        }
    }

    /**
     * Update the properties of an artifact chosen by its ID
     * @param name -> "" will leave unchanged
     * @param type -> "" will leave unchanged
     * @param engagementTime -> "" will leave unchanged
     * @param artifactID -> ID of artifact to update
     * @return boolean if update was successful
     */
    public boolean updateArtifactByID(String name, String type, String engagementTime, int artifactID ){
        
        try{
            Artifact artifact = findArtifact(artifactID);
            if(engagementTime != ""){
                artifact.setEngagementTime(Integer.parseInt(engagementTime));
            }
            if(name != ""){
                artifact.setName(name);
            }
            if(type != ""){
                artifact.setType(type);
            }
            return true;
        }catch (Exception e){
            return false;
        }
    }

    /**
     * Get the String form of an Artifact at an index in the Array
     * @param artifactChoice index of artifact in artifactArray
     * @return
     */
    public String getArtifactString(int artifactChoice){
        try{
            return this.artifactArray[artifactChoice].toString();
        } catch(Exception e){
            return "Not A Valid Artifact Choice";
        }
        
    }

    /**
     * Get a Menu object of all the artifacts in the Array with the addition
     * of option to Search, Clear Search and Quit
     * @return Menu of Artifacts
     */
    public Menu artifactsMenu() {
        String[] artifactNames = artifactArrayToNameArray();
        String[] quit = { "Search", "Clear", "Quit" };
        String[] artifactOptions = Utils.concat(artifactNames, quit);
        Menu artifactMenu = new Menu("Artifacts", artifactOptions);
        return artifactMenu;
    }

    /**
     * Turns the ArrayList of artifcat into a Array of Artifacts
     * @return
     */
    public Artifact[] artifactsToArray() {
        Artifact[] artifactArray = new Artifact[this.artifacts.size()];
        for (int i = 0; i < artifactArray.length; i++) {
            artifactArray[i] = artifacts.get(i);
        }
        return artifactArray;
    }

    /**
     * Turns a given ArrayList of Artifacts into an Array of Artifacts
     * @param artifacts
     * @return
     */
    public static Artifact[] artifactsToArray(ArrayList<Artifact> artifacts) {
        Artifact[] artifactArray = new Artifact[artifacts.size()];
        for (int i = 0; i < artifactArray.length; i++) {
            artifactArray[i] = artifacts.get(i);
        }
        return artifactArray;
    }

    /**
     * Gets a String[] of the names of Artifacts in an array of Artifacts
     * @param artifactArray
     * @return
     */
    public String[] artifactArrayToNameArray() {
        if(artifactArray == null){
            return null;
        }
        String[] nameArray = new String[artifactArray.length];
        for (int i = 0; i < artifactArray.length; i++) {
            nameArray[i] = artifactArray[i].getName();
        }
        return nameArray;
    }

    /**
     * Sorts teh Artifact Array into alphabetical order based on Name
     * Case Sensitive
     */
    public void sortArtifactArray() {
        for (int i = 0; i < artifactArray.length; i++) {
            for (int j = 0; j < artifactArray.length - 1; j++) {
                if (artifactArray[j].getName().compareTo(artifactArray[j + 1].getName()) > 0) {
                    Artifact temp = artifactArray[j];
                    artifactArray[j] = artifactArray[j + 1];
                    artifactArray[j + 1] = temp;
                }
            }
        }
    }

    /**
     * Modifies the value of the Artifact Array property so it only contain artifacts that meet a given criteria
     * Can Search by any property of Artifact and only objects that match this will be included in the Array
     * @param criteriaChoice -> 1-4
     * @param searchValue - Value that object property must match
     * @return
     */
    public boolean searchArtifacts(int criteriaChoice, String searchValue) {

        ArrayList<Artifact> searchResults = new ArrayList<Artifact>();
        switch (criteriaChoice) {
            case 1: //Does ID match searchValue
                int id = Integer.valueOf(searchValue);
                for (int i = 0; i < this.artifactArray.length; i++) {
                    if (this.artifactArray[i].getID() == id) {
                        searchResults.add(this.artifactArray[i]);
                    }
                }
                break;

            case 2:// Does Name contain searchValue -> Case Insesetive
                for (int i = 0; i < this.artifactArray.length; i++) {
                    String artifactName = this.artifactArray[i].getName();
                    if (artifactName.toLowerCase().contains(searchValue.toLowerCase())) {
                        searchResults.add(this.artifactArray[i]);
                    }
                }
                break;
            case 3:// Does type contain searchValue -> Case Insesetive
                for (int i = 0; i < this.artifactArray.length; i++) {
                    String artifactType = this.artifactArray[i].getType();
                    if (artifactType.toLowerCase().contains(searchValue.toLowerCase())) {
                        searchResults.add(this.artifactArray[i]);
                    }
                }
                break;
            case 4:// Does engagementTime match searchValue
                for (int i = 0; i < this.artifactArray.length; i++) {
                    int engagementTime = Integer.valueOf(searchValue);
                    int artifactEngagementTime = this.artifactArray[i].getEngagementTime();
                    if (artifactEngagementTime == engagementTime) {
                        searchResults.add(this.artifactArray[i]);
                    }
                }
                break;

        }
        if (searchResults.size() == 0) {
            return false;
        } else {
            this.artifactArray = artifactsToArray(searchResults);
            return true;
        }

    }

    /**
     * set artifactArray back to be inline with artifacts list
     */
    public void refreshArtifactArray() {
        this.artifactArray = artifactsToArray();
    }

    /**
     * Return a menu of Artifact names in alphabetical orde
     * @return
     */
    public Menu getArtifactMenu() {
        sortArtifactArray();
        return artifactsMenu();
    }

    /**
     * Remove An artifact from artifacts
     * @param artifactID
     * @return
     */
    public boolean removeArtifact(int artifactID){
        
        for(int i=0; i<artifacts.size(); i++){
            if(artifacts.get(i).getID() == artifactID){
                artifacts.remove(i);
                return true;
            }
        }
        return false;
        
    }

    /**
     * get an array of Artifacts that match the ids given in an ArrayList
     * @param artifactsID
     * @return
     */
    public Artifact[] getExhibitArtifacts(ArrayList<Integer> artifactsID) {
        ArrayList<Artifact> artifactArray = new ArrayList<>();
        for (int i = 0; i < artifactsID.size(); i++) {
            try {
                Artifact a = findArtifact(artifactsID.get(i));
                if(a!=null){
                    artifactArray.add(a);
                }
                
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
        return artifactsToArray(artifactArray);
    }

    /**
     * Get an artifact that matches the id
     * @param id
     * @return
     * @throws Exception id does not belong to any artifact
     */
    public Artifact findArtifact(int id) throws Exception{
        for(int i=0; i<this.artifacts.size(); i++){
            if(this.artifacts.get(i).getID() == id){
                return artifacts.get(i);
            }
        }
        throw new Exception("No matching id in list");
    }

    /**
     * Get an String[] of names for a list of Artifact IDs
     * @param artifactIDs
     * @return
     */
    public String[] getArtifactNames(ArrayList<Integer> artifactIDs){
        Artifact[] exhibitArtifacts = getExhibitArtifacts(artifactIDs);
        String[] artifactNames = new String[exhibitArtifacts.length];
        for(int i=0; i<exhibitArtifacts.length; i++){
            artifactNames[i] = exhibitArtifacts[i].getName();
        }
        return artifactNames;
    }

    /**
     * Get the total engagementTime from a list of Artifact IDs
     * @param artifactIDs
     * @return
     */
    public int getExhibitEngagmentTime(ArrayList<Integer> artifactIDs){
        Artifact[] exhibitArtifacts = getExhibitArtifacts(artifactIDs);
        int totalEngagementTime = 0;
        for (Artifact artifact : exhibitArtifacts) {
            totalEngagementTime += artifact.getEngagementTime();
        }
        return totalEngagementTime;
    }

    /**
     * String form of the artifacts list -> used for testing
     */
    public String toString(){
        return this.artifacts.toString();
    }
}
