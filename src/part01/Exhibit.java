package part01;

import java.util.ArrayList;

public class Exhibit {

    private final int ID; // Unique ID
    private String name; // Name of Exhibit -> Used in UI
    private ArrayList<Integer> artifactsID; // List of artifact IDs in the order they are in the exhibit
    private ArrayList<String> route; // List of Signs that correspond to the artifact at that index. i.e sign(1)
                                     // matches artifact(1)
    private static int nextID = 0; // the Unique ID of the next exhibit to be created

    /**
     * Constructor
     * articfactsID and route must be the same length
     * 
     * @param name        - name of the exhibit
     * @param artifactsID - an ArrayList containing the ids of the artifacts that
     *                    make the exhibit
     * @param route       - a String ArrayList of the signs for the exhibit
     * @throws Exception
     */
    public Exhibit(String name, ArrayList<Integer> artifactsID, ArrayList<String> route) throws Exception {
        boolean valid = checkRouteAndArtifacts(route, artifactsID);
        if (!valid) {
            throw new Exception("route and artifacts not consistant");
        }
        this.ID = nextID;
        this.name = name;
        this.artifactsID = new ArrayList<Integer>();
        for (int i : artifactsID) {
            this.artifactsID.add(i);
        }
        this.route = new ArrayList<String>();
        for (String i : route) {
            this.route.add(i);
        }
        nextID++;
    }

    /**
     * 
     * @return id
     */
    public int getID() {
        return this.ID;
    }

    /**
     * 
     * @return name
     */
    public String getName() {
        return this.name;
    }

    /**
     * change the exhibit name
     * 
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @return artifacts list
     */
    public ArrayList<Integer> getArtifactsID() {
        return this.artifactsID;
    }

    /**
     * Change list of artifacts, must be same length
     * 
     * @param artifactsID
     * @throws Exception
     */
    public void setArtifactsID(ArrayList<Integer> artifactsID) throws Exception {
        boolean valid = checkArtifacts(artifactsID);
        if (!valid) {
            throw new Exception("artifacts not consitant with route");
        }
        this.artifactsID = new ArrayList<Integer>();
        for (int i : artifactsID) {
            this.artifactsID.add(i);
        }
    }

    /**
     * 
     * @return route
     */
    public ArrayList<String> getRoute() {
        return this.route;
    }

    /**
     * Change the Route, must be same length
     * 
     * @param route
     * @throws Exception
     */
    public void setRoute(ArrayList<String> route) throws Exception {
        boolean valid = checkRoute(route);
        if (!valid) {
            throw new Exception("route not consitant with artifacts");
        }
        this.route = new ArrayList<String>();
        for (String i : route) {
            this.route.add(i);
        }
    }

    /**
     * Cahnge artifacts and route, new ones must both be the same length as each
     * other
     * 
     * @param artifactsID
     * @param route
     * @throws Exception
     */
    public void setArtifactsAndRoute(ArrayList<Integer> artifactsID, ArrayList<String> route) throws Exception {
        boolean valid = checkRouteAndArtifacts(route, artifactsID);
        if (!valid) {
            throw new Exception("route and artifacts not consistant");
        }
        this.artifactsID = new ArrayList<Integer>();
        for (int i : artifactsID) {
            this.artifactsID.add(i);
        }
        this.route = new ArrayList<String>();
        for (String i : route) {
            this.route.add(i);
        }
    }

    /**
     * Get String form of Exhibit, only includes name and ID
     */
    public String toString() {
        return "ID: " + getID() + "\tName: " + getName();
    }

    /**
     * 
     * @param route
     * @return boolean if route is the same length as the artifacts
     */
    private boolean checkRoute(ArrayList<String> route) {
        ArrayList<Integer> artifactsID = getArtifactsID();
        if (artifactsID.size() != route.size()) {
            return false;
        }
        return true;
    }

    /**
     * 
     * @param artifactsID
     * @return boolean if artifacts is the same length as the route
     */
    private boolean checkArtifacts(ArrayList<Integer> artifactsID) {
        ArrayList<String> route = getRoute();
        if (artifactsID.size() != route.size()) {
            return false;
        }
        return true;
    }

    /**
     * 
     * @param route
     * @param artifactsID
     * @return boolean if artifacts and route are the same length
     */
    private boolean checkRouteAndArtifacts(ArrayList<String> route, ArrayList<Integer> artifactsID) {
        if (artifactsID.size() != route.size()) {
            return false;
        }
        return true;
    }

    /**
     * Remove an artifact at an index
     * Will also remove the corrisponding sign
     * @param i index to remove from
     * @throws Exception if index is outside the range
     */
    public void removeArtifact(int i) throws Exception {
        if (i >= 0 && i < this.artifactsID.size()) {
            this.artifactsID.remove(i);
            this.route.remove(i);
            if (!checkArtifacts(this.artifactsID)) {
                throw new Exception("artifacts do not match route");
            }
        }

    }

    /**
     * Remove an sign at an index
     * Will also remove the corrisponding artifact
     * @param i index to remove from
     * @throws Exception if index is outside the range
     */
    public void removeSign(int i) throws Exception {
        if (i > 0 && i < this.route.size()) {
            this.route.remove(i);
            this.artifactsID.remove(i);
            if (!checkArtifacts(this.artifactsID)) {
                throw new Exception("route does not match artifacts");
            }
        }

    }

    /**
     * Find the index of an artifact based on it id
     * @param id 
     * @return index
     */
    public int findArtifactIndex(Integer id) {
        for (int i = 0; i < this.artifactsID.size(); i++) {
            if (this.artifactsID.get(i) == id) {
                return i;
            }
        }
        return -1;

    }

    /**
     * Get a String[] of the route
     * @return
     */
    public String[] getRouteArray() {
        String[] routeArray = new String[this.route.size()];
        for (int i = 0; i < routeArray.length; i++) {
            routeArray[i] = this.route.get(i);
        }
        return routeArray;
    }

    /**
     * Sets the nextID to 0
     * Should not be used in production - only for testing
     */
    protected static void reset() {
        nextID = 0;
    }

}
