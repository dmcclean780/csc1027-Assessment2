package part01;

import java.util.ArrayList;

public class Exhibit{

    private final int ID;
    private String name;
    private ArrayList<Integer> artifactsID;
    private ArrayList<String> route;
    private static int nextID = 0;

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

    

    public void removeArtifact(int i) throws Exception {
        if(i>0 && i<this.artifactsID.size()){
            this.artifactsID.remove(i);
            this.route.remove(i);
            if(!checkArtifacts(this.artifactsID)){
                throw new Exception("artifacts do not match route");
            }
        }
        
    }

    public void removeSign(int i) throws Exception{
        if(i>0 && i<this.route.size()){
            this.route.remove(i);
            this.artifactsID.remove(i);
            if(!checkArtifacts(this.artifactsID)){
                throw new Exception("route does not match artifacts");
            }
        }

    }

    public int findArtifactIndex(Integer id) {
        for (int i = 0; i < this.artifactsID.size(); i++) {
            if (this.artifactsID.get(i) == id) {
                return i;
            }
        }
        return -1;

    }

    public String[] getRouteArray() {
        String[] routeArray = new String[this.route.size()];
        for (int i = 0; i < routeArray.length; i++) {
            routeArray[i] = this.route.get(i);
        }
        return routeArray;
    }

    protected static void reset(){
        nextID = 0;
    }

    

}
