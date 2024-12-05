package part03;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import part01.Exhibit;
import part01.ExhibitManagement;
import part01.Months;

public class CreateAnnualPlan {

    private String HTML;

    public CreateAnnualPlan(ExhibitManagement exhibitManagement) {

        exhibitManagement.refreshExhibitArray();
        exhibitManagement.sortExhibitArray();
        Exhibit[] exhibitArray = exhibitManagement.getExhibitArray();
        ArrayList<Map<String, String>> jsonData = new ArrayList<>();
        for (Exhibit exhibit : exhibitArray) {
            Map<String, String> exhibitMap = new HashMap<String, String>();
            exhibitMap.put("ID", "" + exhibit.getID());
            exhibitMap.put("Name", exhibit.getName());
            jsonData.add(exhibitMap);
        }

        Map<Integer, ArrayList<Integer>> exhibitsThatShareArtifacts = new HashMap<Integer, ArrayList<Integer>>();
        ArrayList<Exhibit> exhibits = exhibitManagement.getExhibits();
        for (Exhibit exhibitA : exhibits) {
            ArrayList<Integer> listOfSharingExhibits = new ArrayList<>();
            for (Exhibit exhibitB : exhibits) {
                if (Utility.checkForDuplicates(exhibitA, exhibitB)) {
                    listOfSharingExhibits.add(exhibitB.getID());
                }
            }
            exhibitsThatShareArtifacts.put(exhibitA.getID(), listOfSharingExhibits);
        }

        String[] monthsArray = Months.toArray();
        ArrayList<String> monthsList = new ArrayList<>();
        for (String string : monthsArray) {
            monthsList.add(string);
        }
        try {
            String monthsJSON = JSONSerializer.serializeJSON(monthsList);
            String exhibitManagementJSON = JSONSerializer.serializeJSON(jsonData);
            String exhibitsSharingArtifactsJSON = JSONSerializer.serializeJSON(exhibitsThatShareArtifacts);
            this.HTML = "<div class='flex flex-row h-full justify-center my-10 overflow-y-auto max-h-full'>";
            this.HTML += "<script>const months = " + monthsJSON + ";</script>";
            this.HTML += "<script>const exhibitData = " + exhibitManagementJSON + ";</script>";
            this.HTML += "<script>const exhibitsSharingArtifacts = " + exhibitsSharingArtifactsJSON + ";</script>";
            this.HTML += "<script src='http://localhost:9990/javascript/createAnnualPlanFunctions.js'></script>";
            this.HTML += "<div class='flex flex-col justify-around w-11/12 max-h-full'>";
            this.HTML += "<div class='p-2 rounded-md bg-green-700 w-1/3'>";
            this.HTML += "<label for 'hallNoInput' class='text-white font-bold'>Number of Halls: </label>";
            this.HTML += "<input type=number id='hallNoInput' name='hallNoInput' min='1'>";
            this.HTML += "</div>";
            this.HTML += "<form class='flex flex-col justify-center h-full ' action='create_annual_plan/create' method=\"POST\" enctype=\"multipart/form-data\">";
            this.HTML += "<input type=hidden id='hallNoInputHidden' name='hallNoInput' value='0'>";
            this.HTML += "<div class='bg-gray-400 p-4 rounded-t-lg'>You cannot select exhibit that share artifacts in the same month</div>";
            this.HTML += "<div class='overflow-x-auto flex flex-row justify-center bg-gray-400 p-4 rounded-b-lg'>";

            this.HTML += "<div id='planGrid' class='grid grid-cols-[repeat(1,minmax(0,max-content))] grid-rows-12 auto-cols-max  w-full'>";
            this.HTML += "<div class='bg-green-500 border-t-2 border-l-2 border-r border-b text-green-500'>Blank Text</div>";
            for (int i = 0; i < 12; i++) {
                String bottomBorder = (i % 11 == 0 && i != 0) ? "border-b-2 " : "";
                String colour = (i % 2 == 1) ? "green" : "gray";
                this.HTML += "<div class='bg-" + colour + "-400 pl-2 font-bold border-l-2 border-r " + bottomBorder
                        + "'>" + Months.get(i).toString() + "</div>";
            }
            this.HTML += "</div>";
            this.HTML += "</div>";
            this.HTML += "<INPUT  type='submit' value='Submit' class = 'rounded-md py-2 bg-green-500 font-bold text-white text-xl mt-4'>";
            this.HTML += "</form>";
            this.HTML += "</div>";
            this.HTML += "</div>";
        } catch (Exception e) {
            System.out.println(e);
            this.HTML=e.getMessage();
        }
    }

    public String toString() {
        return this.HTML;
    }
}
