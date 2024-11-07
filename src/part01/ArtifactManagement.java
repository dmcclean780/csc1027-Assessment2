package part01;

import java.util.ArrayList;

public class ArtifactManagement {

    private ArrayList<Artifact> artifacts;
    private Artifact[] artifactArray;

    public ArtifactManagement() {
        this.artifacts = new ArrayList<Artifact>();
        this.artifactArray = artifactsToArray();
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

    public int getArtifactID(int artifactChoice){
        return this.artifactArray[artifactChoice].getId();
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
        Artifact artifact = this.artifactArray[artifactChoice];
        try{
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
        return this.artifactArray[artifactChoice].toString();
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

    public Artifact[] artifactsToArray(ArrayList<Artifact> artifacts) {
        Artifact[] artifactArray = new Artifact[artifacts.size()];
        for (int i = 0; i < artifactArray.length; i++) {
            artifactArray[i] = artifacts.get(i);
        }
        return artifactArray;
    }

    public String[] artifactArrayToNameArray(Artifact[] artifactArray) {
        String[] nameArray = new String[artifactArray.length];
        for (int i = 0; i < artifactArray.length; i++) {
            nameArray[i] = artifactArray[i].getName();
        }
        return nameArray;
    }

    public Artifact[] sort(Artifact[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j].getName().compareTo(array[j + 1].getName()) > 0) {
                    Artifact temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }

    public boolean searchArtifacts(int criteriaChoice, String searchValue) {

        ArrayList<Artifact> searchResults = new ArrayList<Artifact>();
        switch (criteriaChoice) {
            case 1:
                int id = Integer.valueOf(searchValue);
                for (int i = 0; i < this.artifactArray.length; i++) {
                    if (this.artifactArray[i].getId() == id) {
                        searchResults.add(this.artifactArray[i]);
                    }
                }
                break;

            case 2:
                for (int i = 0; i < this.artifactArray.length; i++) {
                    String artifactName = this.artifactArray[i].getName();
                    if (artifactName.equals(searchValue)) {
                        searchResults.add(this.artifactArray[i]);
                    }
                }
                break;
            case 3:
                for (int i = 0; i < this.artifactArray.length; i++) {
                    String artifactType = this.artifactArray[i].getType();
                    if (artifactType.equals(searchValue)) {
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
        this.artifactArray = sort(this.artifactArray);
        return artifactsMenu(this.artifactArray);
    }

    public void removeArtifact(int artifactChoice){
        artifacts.remove(artifactChoice);
    }
}
