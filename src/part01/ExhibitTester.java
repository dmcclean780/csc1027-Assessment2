package part01;

import java.util.ArrayList;

public class ExhibitTester {
    public static void main(String[] args){
       checkChageArtifacts();
       checkDeclaration();
       checkChageRoute();
    }

    public static void checkDeclaration(){
        ArrayList<Integer> artifactsID = new ArrayList<Integer>();
        ArrayList<String> route = new ArrayList<String>();
        for (int i=0; i<10; i++){
            Artifact a = new Artifact("hello", "world", i);
            artifactsID.add(a.getId());
        }
        for(int i=0; i<artifactsID.size(); i++){
            String r ="hello world";
            route.add(r);
        }
        String r ="hello world";
        route.add(r);
        Artifact a = new Artifact("hello", "world", 11);
        artifactsID.add(a.getId());
        try{
            Exhibit ex = new Exhibit("hello world", artifactsID, route);
            System.out.println("successful declaration");
        }catch(Exception e){
            System.out.println(e);
        }
    }

    public static void checkChageArtifacts(){
        ArrayList<Integer> artifactsID = new ArrayList<Integer>();
        ArrayList<String> route = new ArrayList<String>();
        for (int i=0; i<10; i++){
            Artifact a = new Artifact("hello", "world", i);
            artifactsID.add(a.getId());
        }
        for(int i=0; i<artifactsID.size(); i++){
            String r ="hello world";
            route.add(r);
        }
        try{
            Exhibit ex = new Exhibit("hello world", artifactsID, route);
            // Artifact a = new Artifact("hello", "world", 11);
            // artifactsID.add(a.getId());
            try{
                ex.setArtifactsID(artifactsID);
                System.out.println("successful change artifacts");
            }catch(Exception e){
                System.out.println(e);
            }
        }catch(Exception e){
            System.out.println(e);
        }
       
        
    }

    public static void checkChageRoute(){
        ArrayList<Integer> artifactsID = new ArrayList<Integer>();
        ArrayList<String> route = new ArrayList<String>();
        for (int i=0; i<10; i++){
            Artifact a = new Artifact("hello", "world", i);
            artifactsID.add(a.getId());
        }
        for(int i=0; i<artifactsID.size(); i++){
            String r ="hello world";
            route.add(r);
        }
        try{
            Exhibit ex = new Exhibit("hello world", artifactsID, route);
            String r ="hello world";
            //route.add(r);
            try{
                ex.setRoute(route);
                System.out.println("successful change route");
            }catch(Exception e){
                System.out.println(e);
            }
        }catch(Exception e){
            System.out.println(e);
        }
       
        
    }
}
