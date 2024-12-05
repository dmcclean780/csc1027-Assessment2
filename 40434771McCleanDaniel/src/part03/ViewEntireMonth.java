package part03;

import java.util.ArrayList;

import part01.Months;

public class ViewEntireMonth {

    private String HTML;

    public ViewEntireMonth(String[][] exhibitNames) {
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
            this.HTML += "<script src='http://localhost:9990/javascript/viewEntireMonthFunctions.js'></script>";
            this.HTML += "<div class='flex flex-col w-2/3'>";
            this.HTML += "<select id='monthChoice' name='monthChoice' class='rounded-md p-4 m-4'>";
            this.HTML += "<option value='-1' selected='selected'>Please Choose a Month to View</option>";
            for (int i = 0; i < monthNames.length; i++) {
                this.HTML += "<option value='" + i + "'>" + monthNames[i] + "</option>";
            }
            this.HTML += "</select>";
            this.HTML += "<div class='flex flex-col justify-center'>";
            this.HTML += "<div id='monthGrid' class='grid grid-rows-12 grid-cols-" + (exhibitNames[0].length + 1)
                    + " bg-gray-400 p-4 rounded-lg'>";
            this.HTML += "<div class='bg-green-500 border-t-2 border-l-2 border-r border-b'></div>";
            for (int i = 0; i < exhibitNames[0].length; i++) {
                String rigntBorder = (i % 2 == 0 && i != 0) ? "border-r-2" : "border-r";
                this.HTML += "<div class='font-bold bg-green-500 border-t-2 " + rigntBorder + " border-b pl-2'>Hall "
                        + (i + 1) + "</div>";
            }
            this.HTML += "<div id='month' class='invisible'></div>";
            for (int i = 0; i < exhibitNames[0].length; i++) {
                this.HTML += "<div id='exhibit"+i+"' class='invisible'></div>";
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
