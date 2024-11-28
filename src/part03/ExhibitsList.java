package part03;

import part01.ExhibitManagement;

public class ExhibitsList {

    private String HTML;

    public ExhibitsList(ExhibitManagement exhibitManagement, String current) {
            this.HTML = "<div class ='flex flex-row justify-center bg-green-700'>";
            this.HTML += "<div class = 'flex flex-col justify-around w-5/6 overflow-hidden'>";
    
            this.HTML += "<form action='search_exhibit' class = 'flex flex-row m-4 justify-around max-w-full'>";
            this.HTML += "<label for 'criteriaChoice' class='pr-4 font-bold text-l'>Property To Search:</label>";
            this.HTML += "<div class = 'w-1/3'>";
    
            this.HTML += "<input type='radio' id='id' name='criteriaChoice' value='1' onchange='hideText(this)' checked> ";
            this.HTML += "<label for='id' class='pr-3'>ID</label> <br>";
    
            this.HTML += "<input type='radio' id='name' name='criteriaChoice' value='2' onchange='hideNumber(this)'> ";
            this.HTML += "<label for='name' class='pr-3'>Name</label> <br>";
    
            this.HTML += "</div>";
    
            this.HTML += "<div id='text' style=\"display: none\">";
            this.HTML += "<LABEL for 'textInput' class='pr-4 font-bold'>String to Search:</LABEL>";
            this.HTML += "<INPUT  type='text' id='textInput' name='textInputInForm' class = ' rounded-md'>";
            this.HTML += "</div>";
    
            this.HTML += "<div id='number'>"; 
            this.HTML += "<LABEL for 'numberInput' class='pr-4 font-bold'>Number to Search:</LABEL>";
            this.HTML += "<INPUT  type='number' id='numberInput' name='numberInputInForm' min='0' class = 'rounded-md'>";
            this.HTML += "</div>";
    
            this.HTML += "<input type='hidden' id='currentPage' name='currentPage' value='"+current+"'>";
            this.HTML += "<INPUT  type='submit' value='Search' class = 'flex shrink rounded-md px-4 my-3 bg-green-500 font-bold text-white text-xl'>";
            this.HTML += "</form>";
    
            this.HTML += "<form action='clear_search' class = 'flex flex-row w-full m-4 justify-center'>";
            this.HTML += "<input type='hidden' id='currentPage' name='currentPage' value='"+current+"'>";
            this.HTML += "<INPUT  type='submit' value='Clear' class = 'w-full rounded-md px-4 my-3 bg-green-500 font-bold text-white text-xl md:text-l sm:text-md'>";
            this.HTML += "</form>";
    
            this.HTML += "</div>";
            this.HTML += "</div>";
    
            this.HTML += "<div class='w-full bg-gray-700 h-full overflow-y-auto'>";
            this.HTML += "<div class = 'flex flex-row h-dvh justify-center my-10'>";
            this.HTML += "<div  class = 'flex flex-col justify-around w-2/3 h-full px-8'>";
    
            exhibitManagement.sortExhibitArray();
            String[] exhibitNames = exhibitManagement.exhibitArrayToNameArray();
            for (int i = 0; i < exhibitNames.length; i++) {
                int ID = -1;
                try {
                    ID = exhibitManagement.getExhibitID(i);
                } catch (Exception e) {
    
                }
                String url = current + "/" + ID;
                this.HTML += "<button class='bg-gray-400 flex-grow my-10 text-xl font-bold rounded-lg p-4' onClick='navigate(\""
                        + url + "\")'>" + exhibitNames[i] + "</button>";
            }
            this.HTML += "</div>";
            this.HTML += "</div>";
            this.HTML += "</div>";
        }

    public String toString() {
        return this.HTML;
    }
}
