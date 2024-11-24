package part01;

import java.util.ArrayList;

public class ArtifactManagement {

    private ArrayList<Artifact> artifacts;
    private Artifact[] artifactArray;

    public ArtifactManagement() {
        this.artifacts = new ArrayList<Artifact>();
        this.artifactArray = artifactsToArray();
    }

    public  ArtifactManagement(ArrayList<Artifact> artifacts)  throws Exception{
        for (Artifact artifact : artifacts) {
            if(artifact == null){
                throw new Exception("artifacts cannot contain null");
            }
        }
        this.artifacts=artifacts;
        this.artifactArray=artifactsToArray();
    }

    public ArrayList<Artifact> getArtifacts() {
        return this.artifacts;
    }

    public Artifact[] getArtifactArray() {
        return this.artifactArray;
    }

    public int getArtifactArrayLength() {
        return getArtifactArray().length;
    }

    public int getArtifactID(int artifactChoice) throws Exception{
        if(artifactChoice < 0 || artifactChoice >= this.artifactArray.length){
            throw new Exception("Artifact Choice Out of Range");
        }
        return this.artifactArray[artifactChoice].getID();
    }

    public boolean addArtifact(String name, String type, int engagementTime) {
        try {
            Artifact artifact = new Artifact(name, type, engagementTime);
            this.artifacts.add(artifact);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

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

    public String getArtifactString(int artifactChoice){
        try{
            return this.artifactArray[artifactChoice].toString();
        } catch(Exception e){
            return "Not A Valid Artifact Choice";
        }
        
    }

    public Menu artifactsMenu(Artifact[] artifactArray) {
        String[] artifactNames = artifactArrayToNameArray(artifactArray);
        String[] quit = { "Search", "Clear", "Quit" };
        String[] artifactOptions = Utils.concat(artifactNames, quit);
        Menu artifactMenu = new Menu("Artifacts", artifactOptions);
        return artifactMenu;
    }

    public Artifact[] artifactsToArray() {
        Artifact[] artifactArray = new Artifact[this.artifacts.size()];
        for (int i = 0; i < artifactArray.length; i++) {
            artifactArray[i] = artifacts.get(i);
        }
        return artifactArray;
    }

    public static Artifact[] artifactsToArray(ArrayList<Artifact> artifacts) {
        Artifact[] artifactArray = new Artifact[artifacts.size()];
        for (int i = 0; i < artifactArray.length; i++) {
            artifactArray[i] = artifacts.get(i);
        }
        return artifactArray;
    }

    public static String[] artifactArrayToNameArray(Artifact[] artifactArray) {
        if(artifactArray == null){
            return null;
        }
        String[] nameArray = new String[artifactArray.length];
        for (int i = 0; i < artifactArray.length; i++) {
            nameArray[i] = artifactArray[i].getName();
        }
        return nameArray;
    }

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

    public boolean searchArtifacts(int criteriaChoice, String searchValue) {

        ArrayList<Artifact> searchResults = new ArrayList<Artifact>();
        switch (criteriaChoice) {
            case 1:
                int id = Integer.valueOf(searchValue);
                for (int i = 0; i < this.artifactArray.length; i++) {
                    if (this.artifactArray[i].getID() == id) {
                        searchResults.add(this.artifactArray[i]);
                    }
                }
                break;

            case 2:
                for (int i = 0; i < this.artifactArray.length; i++) {
                    String artifactName = this.artifactArray[i].getName();
                    if (artifactName.contains(searchValue)) {
                        searchResults.add(this.artifactArray[i]);
                    }
                }
                break;
            case 3:
                for (int i = 0; i < this.artifactArray.length; i++) {
                    String artifactType = this.artifactArray[i].getType();
                    if (artifactType.contains(searchValue)) {
                        searchResults.add(this.artifactArray[i]);
                    }
                }
                break;
            case 4:
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

    public void refreshArtifactArray() {
        this.artifactArray = artifactsToArray();
    }

    public Menu getArtifactMenu() {
        sortArtifactArray();
        return artifactsMenu(this.artifactArray);
    }

    public boolean removeArtifact(int artifactChoice){
        try{
            artifacts.remove(artifactChoice);
            return true;
        } catch(Exception e){
            return false;
        }
        
    }

    public Artifact[] getExhibitArtifacts(ArrayList<Integer> artifactsID) {
        ArrayList<Artifact> artifactArray = new ArrayList<>();
        for (int i = 0; i < artifactsID.size(); i++) {
            try {
                Artifact a = findArtifact(artifactsID.get(i));
                if(a!=null){
                    artifactArray.add(a);
                }
                
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return artifactsToArray(artifactArray);
    }

    public Artifact findArtifact(int id) throws Exception{
        for(int i=0; i<this.artifacts.size(); i++){
            if(this.artifacts.get(i).getID() == id){
                return artifacts.get(i);
            }
        }
        throw new Exception("No matching id in list");
    }

    public String[] getArtifactNames(ArrayList<Integer> artifactIDs){
        Artifact[] exhibitArtifacts = getExhibitArtifacts(artifactIDs);
        String[] artifactNames = new String[exhibitArtifacts.length];
        for(int i=0; i<exhibitArtifacts.length; i++){
            artifactNames[i] = exhibitArtifacts[i].getName();
        }
        return artifactNames;
    }

    public int getExhibitEngagmentTime(ArrayList<Integer> artifactIDs){
        Artifact[] exhibitArtifacts = getExhibitArtifacts(artifactIDs);
        int totalEngagementTime = 0;
        for (Artifact artifact : exhibitArtifacts) {
            totalEngagementTime += artifact.getEngagementTime();
        }
        return totalEngagementTime;
    }

    public String toString(){
        return this.artifacts.toString();
    }
}
