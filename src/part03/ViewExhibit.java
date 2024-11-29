package part03;

import part01.ArtifactManagement;
import part01.Exhibit;

public class ViewExhibit {

    private String HTML;

    public ViewExhibit(Exhibit exhibit, ArtifactManagement artifactManagement){
        this.HTML  = "<div class = 'flex flex-row h-full justify-center my-10 max-h-full overflow-y-auto'>";
            this.HTML += "<div  class = 'flex flex-col justify-around w-2/3 max-h-full px-8 '>";
                this.HTML += "<div class = 'flex flex-row bg-gray-400 p-4 rounded-lg justify-between'>";
                    this.HTML += "<div class = 'flex flex-col w-2/3 justify-around'>";
                        this.HTML += "<div class = 'flex flex-row justify-between'>";
                            this.HTML += "<div class = 'flex flex-row'>";
                                this.HTML += "<div class = 'pr-4 font-bold text-xl'>ID: </div>";
                                this.HTML += "<div class = 'font-bold text-xl'>" + exhibit.getID() + "</div>";
                            this.HTML += "</div>";
                            this.HTML += "<div class = 'flex flex-row'>";
                                this.HTML += "<div class = 'pr-4 font-bold text-xl'>Name: </div>";
                                this.HTML += "<div class = 'font-bold text-xl'>" + exhibit.getName() + "</div>";
                            this.HTML += "</div>";
                        this.HTML += "</div>";
                        this.HTML += "<div class = 'flex flex-col bg-green-700 py-4 px-4 rounded-md my-2 mr-4'>";
                            this.HTML += "<div class='font-bold text-white underline'>Artifacts</div>";
                            String[] exhibitNames = artifactManagement.getArtifactNames(exhibit.getArtifactsID());
                            for (String artifact : exhibitNames) {
                                this.HTML += "<div >"+artifact+"</div>";
                            }
                        this.HTML += "</div>";
                        
                    this.HTML += "</div>";
                    this.HTML += "<div class = 'flex flex-col justify-center'>";
                    this.HTML += "<img src='http://localhost:9990/images/exhibits/"+exhibit.getID()+".jpeg'  alt='No Image For this Exhibit' class='rounded-md'>";
                    this.HTML += "</div>";
                this.HTML += "</div>";
                this.HTML += "<div class = 'flex flex-col bg-green-700 py-4 px-4 rounded-md my-2 mr-4 w-full'>";
                this.HTML += "<div class='font-bold text-white'>ROUTE</div>";
                this.HTML += "<div class='flex flex-row'>";
                                this.HTML += "<div class ='w-1/12'></div>";
                                this.HTML += "<div class='w-1/3 font-bold text-white underline'>STEP</div>";
                                this.HTML += "<div class ='w-5/12 font-bold text-white underline'>SIGN</div>";
                                this.HTML += "</div>";
                        String[] route = exhibit.getRouteArray();
                            for(int i=0; i<exhibitNames.length; i++){
                                this.HTML += "<div class='flex flex-row'>";
                                this.HTML += "<div class ='w-1/12'>"+(i+1)+".</div>";
                                this.HTML += "<div class='w-1/3 font-bold'>"+exhibitNames[i]+"</div>";
                                this.HTML += "<div class ='w-5/12'>"+route[i]+"</div>";
                                this.HTML += "</div>";
                            }
                        this.HTML += "</div>";
            this.HTML += "</div>";
        this.HTML += "</div>";
    }

    public String toString(){
        return this.HTML;
    }
}
