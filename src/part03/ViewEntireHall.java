package part03;

import java.util.ArrayList;

import part01.Months;

public class ViewEntireHall {

    private String HTML;

    public ViewEntireHall(String[][] exhibitNames) {
        String[] monthNames = Months.toArray();
        try {
            ArrayList<ArrayList<String>> exhibitPlanList = new ArrayList<>();
            for (String[] exhibtMonth : exhibitNames) {
                ArrayList<String> exhibitHallList = new ArrayList<>();
                for (String exhibit : exhibtMonth) {
                    exhibitHallList.add(exhibit);
                }
                exhibitPlanList.add(exhibitHallList);
            }
            String exhibitPlanJSON = JSONSerializer.serializeJSON(exhibitPlanList);

            this.HTML = "<div class='flex flex-row justify-center h-full'>";
            this.HTML += "<script>const exhibitPlan = " + exhibitPlanJSON + ";</script>";
            this.HTML += "<script src='http://localhost:9990/part03/viewEntireHallFunctions.js'></script>";
            this.HTML += "<div class='flex flex-col w-2/3'>";
            this.HTML += "<select id='hallChoice' name='hallChoice' class='rounded-md p-4 m-4'>";
            this.HTML += "<option value='-1' selected='selected'>Please Choose a Hall to View</option>";
            for (int i = 0; i < exhibitNames[0].length; i++) {
                this.HTML += "<option value='" + i + "'> Hall No " + (i+1) + "</option>";
            }
            this.HTML += "</select>";
            this.HTML += "<div class='flex flex-col justify-center'>";
            this.HTML += "<div id='monthGrid' class='grid grid-rows-3 grid-cols-2"
                    + " bg-gray-400 p-4 rounded-lg'>";
            this.HTML += "<div class='bg-green-500 border-t-2 border-l-2 border-r border-b'></div>";
            this.HTML += "<div id='hall' class='bg-green-500 border-t-2 border-r-2 border-b'></div>";
            for(int i=0; i<monthNames.length; i++){
                String colour = (i%2==1) ? "green" : "gray";
                String bottomBorder = (i%11==0 && i!=0) ? "border-b-2 " : "";
                this.HTML+="<div class='bg-"+colour+"-400 pl-2 font-bold border-l-2 border-r "+bottomBorder+"'>"+Months.get(i).toString()+"</div>";
                this.HTML += "<div id='exhibit"+i+"' class='bg-"+colour+"-400 border-r-2 "+bottomBorder+"'></div>";
            }
            this.HTML += "</div>";
            this.HTML += "</div>";
            this.HTML += "</div>";
            this.HTML += "</div>";
        } catch (Exception e) {

        }
    }

    public String toString() {
        return this.HTML;
    }
}
