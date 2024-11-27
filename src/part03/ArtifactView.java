package part03;

import part01.Artifact;

public class ArtifactView {
    
    private String HTML;

    public ArtifactView(Artifact artifact){
        this.HTML  = "<div class = 'flex flex-row h-full justify-center my-10'>";
            this.HTML += "<div  class = 'flex flex-col justify-around w-2/3 h-full px-8'>";
                this.HTML += "<div class = 'flex flex-row bg-gray-400 p-4 rounded-lg justify-between'>";
                    this.HTML += "<div class = 'flex flex-col w-1/2'>";
                        this.HTML += "<div class = 'flex flex-row justify-between'>";
                            this.HTML += "<div class = 'flex flex-row'>";
                                this.HTML += "<div class = 'pr-4 font-bold text-xl'>ID: </div>";
                                this.HTML += "<div class = 'font-bold text-xl'>" + artifact.getID() + "</div>";
                            this.HTML += "</div>";
                            this.HTML += "<div class = 'flex flex-row'>";
                                this.HTML += "<div class = 'pr-4 font-bold text-xl'>Name: </div>";
                                this.HTML += "<div class = 'font-bold text-xl'>" + artifact.getName() + "</div>";
                            this.HTML += "</div>";
                        this.HTML += "</div>";
                        this.HTML += "<div class = 'flex flex-row'>";
                            this.HTML += "<div class = 'pr-4 font-bold text-xl'>Type: </div>";
                            this.HTML += "<div class = 'font-bold text-xl'>" + artifact.getType() + "</div>";
                        this.HTML += "</div>";
                        this.HTML += "<div class = 'flex flex-row'>";
                            this.HTML += "<div class = 'pr-4 font-bold text-xl'>Engagement Time: </div>";
                            this.HTML += "<div class = 'font-bold text-xl'>" + artifact.getEngagementTime() + "</div>";
                        this.HTML += "</div>";
                    this.HTML += "</div>";
                    this.HTML += "<div class = 'h-full bg-green-500'> Artifact Image In Future";
                    this.HTML += "</div>";
                this.HTML += "</div>";
            this.HTML += "</div>";
        this.HTML += "</div>";
    }

    public String toString(){
        return this.HTML;
    }
    
}
