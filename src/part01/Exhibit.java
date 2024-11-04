package part01;

import java.util.ArrayList;

public class Exhibit {
    
    public final int id;
    public String name;
    public ArrayList<Integer> artifactsID;
    public ArrayList<String> route;
    public static int nextID = 0;

    /**
     * Constructor
     * articfactsID and route must be the same length
     * @param name - name of the exhibit
     * @param artifactsID - an ArrayList containing the ids of the artifacts that make the exhibit
     * @param route - a String ArrayList of the signs for the exhibit
     * @throws Exception
     */
    public Exhibit(String name, ArrayList<Integer> artifactsID, ArrayList<String> route) throws Exception{
        boolean valid = checkRouteAndArtifacts(route, artifactsID);
        if(!valid){
            throw new Exception("route and artifacts not consistant");
        }
        this.id = nextID;
        this.artifactsID= new ArrayList<Integer>();
        for (int i: artifactsID){
            this.artifactsID.add(i);
        }
        this.route = new ArrayList<String>();
        for (String i: route){
            this.route.add(i);
        }
        nextID++;
    }

    /**
     * 
     * @return id
     */
    public int getId() {
        return this.id;
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
        if(!valid){
            throw new Exception("artifacts not consitant with route");
        }
        this.artifactsID= new ArrayList<Integer>();
        for (int i: artifactsID){
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
    public void setRoute(ArrayList<String> route) throws Exception{
        boolean valid = checkRoute(route);
        if(!valid){
            throw new Exception("route not consitant with artifacts");
        }
        this.route = new ArrayList<String>();
        for (String i: route){
            this.route.add(i);
        }
    }

    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", artifactsID='" + getArtifactsID() + "'" +
            ", route='" + getRoute() + "'" +
            "}";
    }


    /**
     * 
     * @param route
     * @return boolean if route is the same length as the artifacts
     */
    private boolean checkRoute(ArrayList<String> route){
        ArrayList<Integer> artifactsID = getArtifactsID();
        if(artifactsID.size() != route.size()){
            return false;
        }
        return true;
    }

    /**
     * 
     * @param artifactsID
     * @return boolean if artifacts is the same length as the route
     */
    private boolean checkArtifacts(ArrayList<Integer> artifactsID){
        ArrayList<String> route = getRoute();
        if(artifactsID.size() != route.size()){
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
    private boolean checkRouteAndArtifacts(ArrayList<String> route, ArrayList<Integer> artifactsID){
        if(artifactsID.size() != route.size()){
            return false;
        }
        return true;
    }

}
