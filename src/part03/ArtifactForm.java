package part03;

public class ArtifactForm {
    private String HTML;

    public ArtifactForm() {
        this.HTML = "<div class = 'flex flex-row justify-center h-full my-10'>";
            this.HTML += "<form  class = 'flex flex-col justify-around w-2/3 px-8 bg-gray-400 rounded-lg' action='add_artifact/create_artifact'>";
                this.HTML += "<div class = 'flex flex-row justify-around my-2 h-1/3'>";
                    this.HTML += "<label for 'myName' class='pr-4 font-bold text-xl'>Name:</label>";
                    this.HTML += "<INPUT  type='text' id='myName' name='myNameInForm' class = 'w-2/3 rounded-md'>";
                this.HTML += "</div>";
                this.HTML += "<div class = 'flex flex-row justify-around my-2 h-1/3'>";
                    this.HTML += "<LABEL for 'myType' class='pr-4 font-bold text-xl'>Type:</LABEL>";
                    this.HTML += "<INPUT  type='text' id='myType' name='myTypeInForm' class = 'w-2/3 rounded-md'>";
                this.HTML += "</div>";
                this.HTML += "<div class = 'flex flex-row justify-around my-2 h-1/3'>";
                    this.HTML += "<LABEL for 'myTime' class='pr-4 font-bold text-xl'>Time:</LABEL>";
                    this.HTML += "<INPUT  type='number' id='myTime' name='myTimeInForm' min='1' class = 'w-2/3 rounded-md'>";
                this.HTML += "</div>";
                this.HTML += "<INPUT  type='submit' value='Submit' class = ' rounded-md py-2 bg-green-500 font-bold text-white text-xl'>";
            this.HTML += "</FORM>";
        this.HTML += "</div>";
    }

    public String toString(){
        return this.HTML;
    }
}
