package part03;

import part01.ArtifactManagement;
import part01.Artifact;

public class ArtifactsList {

    private String HTML;

    public ArtifactsList(ArtifactManagement artifactManagement, String current) {
        this.HTML = "<div class ='flex flex-row justify-center bg-green-700'>";
        this.HTML += "<div class = 'flex flex-col justify-around w-5/6 overflow-hidden'>";

        this.HTML += "<form action='search_artifact' class = 'flex flex-row m-4 justify-around max-w-full'>";
        this.HTML += "<label for 'criteriaChoice' class='pr-4 font-bold text-l'>Property To Search:</label>";
        this.HTML += "<div class = 'w-1/3'>";

        this.HTML += "<input type='radio' id='id' name='criteriaChoice' value='1' onchange='showID(this, \"artifact\")' checked> ";
        this.HTML += "<label for='id' class='pr-3'>ID</label> <br>";

        this.HTML += "<input type='radio' id='name' name='criteriaChoice' value='2' onchange='showName(this, \"artifact\")'> ";
        this.HTML += "<label for='name' class='pr-3'>Name</label> <br>";

        this.HTML += "<input type='radio' id='type' name='criteriaChoice' value='3' onchange='showType(this, \"artifact\")'> ";
        this.HTML += "<label for='type' class='pr-3'>Type</label> <br>";

        this.HTML += "<input type='radio' id='time' name='criteriaChoice' value='4' onchange='showTime(this, \"artifact\")'> ";
        this.HTML += "<label for='time' class='pr-3'>Engagement Time</label> ";
        this.HTML += "</div>";

        this.HTML += "<div id='IDInputDIV'>";
        this.HTML += "<LABEL for 'IDInput' class='pr-4 font-bold'>ID:</LABEL>";
        this.HTML += "<INPUT  type='search' pattern= ^\\d+$ id='IDInput' placeholder=\"positive integer\" name='IDInput' min='0' list='artifactIDs' class = 'rounded-md px-2'>";
        this.HTML += "</div>";

        this.HTML += "<div id='NameInputDIV' style=\"display: none\">";
        this.HTML += "<LABEL for 'NameInput' class='pr-4 font-bold'>Name:</LABEL>";
        this.HTML += "<INPUT  type='search' id='NameInput' name='NameInput' list='artifactNames' class='rounded-md px-2'>";
        this.HTML += "</div>";

        this.HTML += "<div id='TypeInputDIV' style=\"display: none\">";
        this.HTML += "<LABEL for 'TypeInput' class='pr-4 font-bold'>Type:</LABEL>";
        this.HTML += "<INPUT  type='search' id='TypeInput' name='TypeInput' list='artifactTypes' class='rounded-md px-2'>";
        this.HTML += "</div>";

        this.HTML += "<div id='TimeInputDIV' style=\"display: none\">";
        this.HTML += "<LABEL for 'TimeInput' class='pr-4 font-bold'>Time:</LABEL>";
        this.HTML += "<INPUT  type='search' pattern= ^[1-9][0-9]*$ id='TimeInput' placeholder=\">0\" name='TimeInput' min='0' list='artifactTimes' class = 'rounded-md px-2'>";
        this.HTML += "</div>";

        this.HTML += "<input type='hidden' id='currentPage' name='currentPage' value='" + current + "'>";
        this.HTML += "<INPUT  type='submit' value='Search' class = 'flex shrink rounded-md px-4 my-3 bg-green-500 font-bold text-white text-xl'>";

        Artifact[] artifactArray = artifactManagement.getArtifactArray();
        this.HTML += "<datalist id=\"artifactIDs\">";
        for (Artifact artifact : artifactArray) {
            this.HTML += "<option value=\"" + artifact.getID() + "\"></option>";
        }
        this.HTML += "</datalist>";

        this.HTML += "<datalist id=\"artifactNames\">";
        for (Artifact artifact : artifactArray) {
            this.HTML += "<option value=\"" + artifact.getName() + "\"></option>";
        }
        this.HTML += "</datalist>";

        this.HTML += "<datalist id=\"artifactTypes\">";
        for (Artifact artifact : artifactArray) {
            this.HTML += "<option value=\"" + artifact.getType() + "\"></option>";
        }
        this.HTML += "</datalist>";

        this.HTML += "<datalist id=\"artifactTimes\">";
        for (Artifact artifact : artifactArray) {
            this.HTML += "<option value=\"" + artifact.getEngagementTime() + "\"></option>";
        }
        this.HTML += "</datalist>";

        this.HTML += "</form>";

        this.HTML += "<form action='clear_search' class = 'flex flex-row w-full m-4 justify-center'>";
        this.HTML += "<input type='hidden' id='currentPage' name='currentPage' value='" + current + "'>";
        this.HTML += "<INPUT  type='submit' value='Clear' class = 'w-full rounded-md px-4 my-3 bg-green-500 font-bold text-white text-xl md:text-l sm:text-md'>";
        this.HTML += "</form>";

        this.HTML += "</div>";
        this.HTML += "</div>";

        this.HTML += "<div class='w-full bg-gray-700 h-full overflow-y-auto'>";
        this.HTML += "<div class = 'flex flex-row h-dvh justify-center my-10'>";
        this.HTML += "<div  class = 'flex flex-col justify-around w-2/3 h-full px-8'>";

        artifactManagement.sortArtifactArray();
        String[] artifactNames = artifactManagement.artifactArrayToNameArray();
        for (int i = 0; i < artifactNames.length; i++) {
            int ID = -1;
            try {
                ID = artifactManagement.getArtifactID(i);
            } catch (Exception e) {

            }
            String url = current + "/" + ID;
            this.HTML += "<button class='bg-gray-400 flex-grow my-10 text-xl font-bold rounded-lg p-4' onClick='navigate(\""
                    + url + "\")'>" + artifactNames[i] + "</button>";
        }
        this.HTML += "</div>";
        this.HTML += "</div>";
        this.HTML += "</div>";
    }

    public String toString() {
        return this.HTML;
    }
}
