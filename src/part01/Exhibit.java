package part01;

import java.util.ArrayList;

public class Exhibit {
    
    public final int id;
    public String name;
    public ArrayList<Integer> artifactsID;
    public ArrayList<String> route;
    public static int nextID = 0;


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

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Integer> getArtifactsID() {
        return this.artifactsID;
    }

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

    public ArrayList<String> getRoute() {
        return this.route;
    }

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

    private boolean checkRoute(ArrayList<String> route){
        ArrayList<Integer> artifactsID = getArtifactsID();
        if(artifactsID.size() != route.size()){
            return false;
        }
        return true;
    }

    private boolean checkArtifacts(ArrayList<Integer> artifactsID){
        ArrayList<String> route = getRoute();
        if(artifactsID.size() != route.size()){
            return false;
        }
        return true;
    }

    private boolean checkRouteAndArtifacts(ArrayList<String> route, ArrayList<Integer> artifactsID){
        if(artifactsID.size() != route.size()){
            return false;
        }
        return true;
    }

}
