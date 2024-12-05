package part03;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import part01.Artifact;
import part01.ArtifactManagement;
import part01.Exhibit;

public class UpdateExhibit {
    private String HTML;

    public UpdateExhibit(Exhibit exhibit, ArtifactManagement artifactManagement){

    try{  
        artifactManagement.refreshArtifactArray();
        artifactManagement.sortArtifactArray();
        Artifact[] artifactArray = artifactManagement.getArtifactArray();
        ArrayList<Map<String, String>> jsonData = new ArrayList<>();
        for (Artifact artifact : artifactArray) {
            Map<String,String> artifactMap = new HashMap<String,String>();
            artifactMap.put("ID", ""+artifact.getID());
            artifactMap.put("Name", artifact.getName());
            jsonData.add(artifactMap);
        }
        String artifactManagementJSON = JSONSerializer.serializeJSON(jsonData);

        ArrayList<String> route = exhibit.getRoute();
        ArrayList<Integer> artifacts = exhibit.getArtifactsID();
        String routeJSON = JSONSerializer.serializeJSON(route);
        String artifactsJSON = JSONSerializer.serializeJSON(artifacts);

        this.HTML = "<div class = 'flex flex-row justify-center my-10'>";
            this.HTML += "<form  class = 'flex flex-col w-2/3 px-8 bg-gray-400 rounded-lg h-full' action='update' method=\"POST\" enctype=\"multipart/form-data\">";
                this.HTML += "<div class = 'flex flex-row justify-around my-2 overflow-y-auto'>";
                    this.HTML += "<label for 'myName' class='pr-4 font-bold text-xl'>Name:</label>";
                    this.HTML += "<INPUT  type='text' id='myName' name='myNameInForm' value=\"\" placeholder='"+exhibit.getName()+"' class = 'w-2/3 rounded-md'>";
                this.HTML += "</div>";
                this.HTML += "<div class = 'flex flex-row my-2 w-full justify-center'>";
                    this.HTML += "<div class = 'flex flex-col  w-3/4'>";
                        this.HTML += "<div class = 'flex flex-row justify-between w-full'>";
                            this.HTML += "<div class='font-bold underline text-xl'>Configure Route</div>";
                            this.HTML += "<button type='button' class='rounded-md bg-green-500 font-bold text-white px-2 py-1' onClick='addArtifact()'>Add New Step</button>";
                        this.HTML += "</div>";
                        this.HTML += "<div class = 'flex flex-col my-2 w-full bg-green-700 rounded-md' id='exhibitRoute'>";
                            this.HTML += "<input type='hidden' id='artifactCount' name='artifcatCount' value='"+exhibit.getArtifactsID().size()+"'>";
                            this.HTML += "<script>const artifactManagementData = " + artifactManagementJSON + ";</script>";
                            this.HTML += "<script>const artifactData = " + artifactsJSON + ";</script>";
                            this.HTML += "<script>const routeData = " + routeJSON + ";</script>";
                            this.HTML += "<script src='http://localhost:9990/javascript/exhibitAddUpdateFunctions.js'></script>";
                            this.HTML += "<div class = 'flex flex-row my-2 w-full'>";
                                this.HTML += "<div class='w-1/2 px-2 font-bold text-white'>Artifacts</div>";
                                this.HTML += "<div class='w-1/2 px-2 font-bold text-white'>Signs</div>";
                            this.HTML += "</div>";
                        this.HTML += "</div>";
                        this.HTML += "<div class = 'flex flex-row justify-end w-full'>";
                            this.HTML += "<button type='button' class='rounded-md bg-green-500 font-bold text-white px-2 py-1' onClick='removeArtifact()'>Remove Last Step</button>";
                        this.HTML += "</div>";
                    this.HTML += "</div>";
                this.HTML += "</div>";
                this.HTML += "<div class = 'flex flex-col justify-around my-2'>";
                    this.HTML += "<div for 'image' class='pr-4 font-bold text-xl'>Current Image:</div>";
                    this.HTML += "<img src='http://localhost:9990/images/exhibits/"+exhibit.getID()+".jpeg'  alt='No Image For this Exhibit' class='rounded-md'>";
                    this.HTML += "<div class = 'flex flex-row justify-around my-2'>";
                        this.HTML += "<LABEL for 'image' class='pr-4 font-bold text-xl'>Image:</LABEL>";
                        this.HTML += "<INPUT  type='file' id='image' name='image' class = 'rounded-md w-2/3'>";
                    this.HTML += "</div>";
                this.HTML += "</div>";
                this.HTML += "<INPUT  type='hidden' value='"+exhibit.getID()+"' id='exhibitID' name='exhibitID' class = 'rounded-md py-2 bg-green-500 font-bold text-white text-xl'>";
                this.HTML += "<INPUT  type='submit' value='Submit' class = 'rounded-md py-2 bg-green-500 font-bold text-white text-xl'>";
            this.HTML += "</FORM>";
        this.HTML += "</div>";
    } catch(Exception e){
        System.out.println(e);
    }

        
    }

    public String toString(){
        return this.HTML;
    }
}
