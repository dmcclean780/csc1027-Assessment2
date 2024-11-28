package part03;

import part01.Artifact;

public class UpdateArtifact {
    private String HTML;

    public UpdateArtifact(Artifact artifact) {
        this.HTML = "<div class = 'flex flex-row justify-center h-full my-10'>";
            this.HTML += "<form  class = 'flex flex-col justify-around w-2/3 px-8 bg-gray-400 rounded-lg' action='update'>";
                this.HTML += "<div class = 'flex flex-row justify-around my-2 h-1/6'>";
                    this.HTML += "<label for 'myName' class='pr-4 font-bold text-xl'>Name:</label>";
                    this.HTML += "<input  type='text' id='myName' name='myNameInForm' placeholder='"+artifact.getName()+"' class = 'w-2/3 rounded-md'>";
                this.HTML += "</div>";
                this.HTML += "<div class = 'flex flex-row justify-around my-2 h-1/6'>";
                    this.HTML += "<label for 'myType' class='pr-4 font-bold text-xl'>Type:</label>";
                    this.HTML += "<input  type='text' id='myType' name='myTypeInForm' placeholder='"+artifact.getType()+"' class = 'w-2/3 rounded-md'>";
                this.HTML += "</div>";
                this.HTML += "<div class = 'flex flex-row justify-around my-2 h-1/6'>";
                    this.HTML += "<label for 'myTime' class='pr-4 font-bold text-xl'>Time:</label>";
                    this.HTML += "<input  type='number' id='myTime' name='myTimeInForm' min='1' placeholder='"+artifact.getEngagementTime()+"' class = 'w-2/3 rounded-md'>";
                this.HTML += "</div>";
                this.HTML += "<input  type='hidden' id='ID' name='ID' min='1' value='"+artifact.getID()+"' class = 'w-2/3 rounded-md'>";
                this.HTML += "<input  type='submit' value='Submit' class = ' rounded-md py-2 bg-green-500 font-bold text-white text-xl'>";
            this.HTML += "</FORM>";
        this.HTML += "</div>";
    }

    public String toString(){
        return this.HTML;
    }
}
