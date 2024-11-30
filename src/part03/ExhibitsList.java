package part03;

import part01.Exhibit;
import part01.ExhibitManagement;

public class ExhibitsList {

    private String HTML;

    public ExhibitsList(ExhibitManagement exhibitManagement, String current) {
        this.HTML = "<div class ='flex flex-row justify-center bg-green-700'>";
        this.HTML += "<script src='http://localhost:9990/part03/exhibitsListFunctions.js'></script>";
        this.HTML += "<div class = 'flex flex-col justify-around w-5/6 overflow-hidden'>";

        this.HTML += "<form action='search_exhibit' class = 'flex flex-row m-4 justify-around max-w-full'>";
        this.HTML += "<label for 'criteriaChoice' class='pr-4 font-bold text-l'>Property To Search:</label>";
        this.HTML += "<div class = 'w-1/3'>";

        this.HTML += "<input type='radio' id='id' name='criteriaChoice' value='1' onchange='showID(this)' checked> ";
        this.HTML += "<label for='id' class='pr-3'>ID</label> <br>";

        this.HTML += "<input type='radio' id='name' name='criteriaChoice' value='2' onchange='showName(this)'> ";
        this.HTML += "<label for='name' class='pr-3'>Name</label> <br>";

        this.HTML += "</div>";

        this.HTML += "<div id='IDInputDIV'>";
        this.HTML += "<LABEL for 'IDInput' class='pr-4 font-bold'>ID:</LABEL>";
        this.HTML += "<INPUT  type='search' id='IDInput' name='IDInput' min='0' list='exhibitIDs' class='rounded-md px-2'>";
        this.HTML += "</div>";

        this.HTML += "<div id='NameInputDIV' style=\"display: none\">";
        this.HTML += "<LABEL for 'NameInput' class='pr-4 font-bold'>Name:</LABEL>";
        this.HTML += "<INPUT  type='search' id='NameInput' name='NameInput' list='exhibitNames' class='rounded-md px-2'>";
        this.HTML += "</div>";

        this.HTML += "<input type='hidden' id='currentPage' name='currentPage' value='" + current + "'>";
        this.HTML += "<INPUT  type='submit' value='Search' class = 'flex shrink rounded-md px-4 my-3 bg-green-500 font-bold text-white text-xl'>";
        this.HTML += "</form>";

        this.HTML += "<form action='clear_search' class = 'flex flex-row w-full m-4 justify-center'>";
        this.HTML += "<input type='hidden' id='currentPage' name='currentPage' value='" + current + "'>";
        this.HTML += "<INPUT  type='submit' value='Clear' class = 'w-full rounded-md px-4 my-3 bg-green-500 font-bold text-white text-xl md:text-l sm:text-md'>";

        Exhibit[] exhibitArray = exhibitManagement.getExhibitArray();
        this.HTML += "<datalist id=\"exhibitIDs\">";
        for (Exhibit exhibit : exhibitArray) {
            this.HTML += "<option value=\"" + exhibit.getID() + "\"></option>";
        }
        this.HTML += "</datalist>";

        this.HTML += "<datalist id=\"exhibitNames\">";
        for (Exhibit exhibit : exhibitArray) {
            this.HTML += "<option value=\"" + exhibit.getName() + "\"></option>";
        }
        this.HTML += "</datalist>";
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
