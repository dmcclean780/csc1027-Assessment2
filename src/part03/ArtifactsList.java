package part03;

import part01.ArtifactManagement;

public class ArtifactsList {
    
    private String HTML;

    public ArtifactsList(ArtifactManagement artifactManagement, String current){
        this.HTML  = "<div class ='flex flex-row justify-center'>";
            this.HTML += "<div class = 'flex flex-col justify-around w-2/3 bg-red-500'>";

            this.HTML += "<form action='search_artifact' class = 'flex flex-row m-4'>";
                this.HTML += "<label for 'criteriaChoice' class='pr-4 font-bold text-xl'>Property To Search:</label>";
                this.HTML += "<div class = 'w-2/3'>";             
                
                    this.HTML += "<input type='radio' id='id' name='criteriaChoice' value='1' onchange='hideText(this)' checked> ";
                    this.HTML += "<label for='id' class='pr-3'>ID</label> <br>";
                    
                    this.HTML += "<input type='radio' id='name' name='criteriaChoice' value='2' onchange='hideNumber(this)'> "; 
                    this.HTML += "<label for='name' class='pr-3'>Name</label> <br>";
                    
                    this.HTML += "<input type='radio' id='type' name='criteriaChoice' value='3' onchange='hideNumber(this)'> ";
                    this.HTML += "<label for='type' class='pr-3'>Type</label> <br>";    
                        
                    this.HTML += "<input type='radio' id='time' name='criteriaChoice' value='4' onchange='hideText(this)'> ";
                    this.HTML += "<label for='time' class='pr-3'>Engagement Time</label> ";  
                this.HTML +="</div>";

                this.HTML +="<div id='text' style=\"visibility:hidden\">";
                    this.HTML += "<LABEL for 'textInput' class='pr-4 font-bold'>String to Search:</LABEL>";
                    this.HTML += "<INPUT  type='text' id='textInput' name='textInputInForm' class = 'rounded-md'>";
                this.HTML +="</div>";

                this.HTML +="<div id='number'>";
                    this.HTML += "<LABEL for 'textInput' class='pr-4 font-bold'>Number to Search:</LABEL>";
                    this.HTML += "<INPUT  type='number' id='numberInput' name='numberInputInForm' min='0' class = 'rounded-md'>";
                this.HTML +="</div>";
                this.HTML += "<input type='hidden' id='currentPage' name='currentPage' value='view_artifact'>";
                this.HTML += "<INPUT  type='submit' value='Search' class = ' rounded-md px-4 my-3 bg-green-500 font-bold text-white text-xl'>";
            this.HTML += "</form>";

            this.HTML += "<form action='view_artifact/clear_search' class = 'flex flex-row m-4'>";
                this.HTML += "<input type='hidden' id='currentPage' name='currentPage' value='view_artifact'>";
                this.HTML += "<INPUT  type='submit' value='Clear' class = ' rounded-md px-4 my-3 bg-green-500 font-bold text-white text-xl'>";
            this.HTML += "</form>";

            this.HTML +="</div>";
        this.HTML +="</div>";

        this.HTML += "<div class='w-full bg-gray-700 h-full overflow-y-auto'>";
        this.HTML += "<div class = 'flex flex-row h-dvh justify-center my-10'>";
        this.HTML += "<div  class = 'flex flex-col justify-around w-2/3 h-full px-8'>";


        this.HTML+="<script type='text/javascript'>";
        this.HTML+="function hideText(x){\n" + //
                        "if (x.checked) {\n" + //
                            "document.getElementById(\"text\").style.visibility = \"hidden\";\n" + //
                            "document.getElementById(\"number\").style.visibility = \"visible\";\n" +
                        " }\n" + //
                    "}\n" +
                    "\n" +
                    "function hideNumber(x){\n" + //
                        "if (x.checked) {\n" + //
                            "document.getElementById(\"number\").style.visibility = \"hidden\";\n" + //
                            "document.getElementById(\"text\").style.visibility = \"visible\";\n" +
                        " }\n" + //
                    "}";
        this.HTML+="</script>";

        artifactManagement.sortArtifactArray();
        String[] artifactNames = artifactManagement.artifactArrayToNameArray();
        for (int i=0; i<artifactNames.length; i++) {
            int ID=-1;
            try{
                ID = artifactManagement.getArtifactID(i);
            } catch(Exception e){

            }
            String url = current+"/"+ID;
            this.HTML += "<button class='bg-gray-400 flex-grow my-10 text-xl font-bold rounded-lg p-4' onClick='navigate(\""+url+"\")'>" + artifactNames[i] + "</button>";
        }
        this.HTML+="</div>";
        this.HTML+="</div>";
        this.HTML+="</div>";
    }

    public String toString(){
        return this.HTML;
    }
}
