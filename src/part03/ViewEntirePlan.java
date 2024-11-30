package part03;

import part01.Months;

public class ViewEntirePlan {
    
    private String HTML;

    public ViewEntirePlan(String[][] exhibitNames){
        this.HTML = "<div class='flex flex-row justify-center h-full'>";
        this.HTML += "<div class='flex flex-col justify-center w-2/3'>";
        this.HTML += "<div class='grid grid-rows-12 grid-cols-"+(exhibitNames[0].length+1)+" bg-gray-400 p-4 rounded-lg'>";
        this.HTML+="<div class='bg-green-500 border-t-2 border-l-2 border-r border-b'></div>";
        for(int i=0; i<exhibitNames[0].length; i++){
            String rigntBorder = ((i+1)%(exhibitNames[0].length)==0 && (i!=0 || exhibitNames[0].length==1)) ? "border-r-2" : "";
            this.HTML+="<div class='font-bold bg-green-500 border-t-2 "+rigntBorder+" border-b pl-2'>Hall "+(i+1)+"</div>";
        }
        for (int i=0; i<exhibitNames.length; i++) {
            String bottomBorder = (i%11==0 && i!=0) ? "border-b-2 " : "";
            String colour = (i%2==1) ? "green" : "gray";
            this.HTML+="<div class='bg-"+colour+"-400 pl-2 font-bold border-l-2 border-r "+bottomBorder+"'>"+Months.get(i).toString()+"</div>";
            for (int j=0; j<exhibitNames[i].length; j++) {
                
                String rigntBorder = ((j+1)%(exhibitNames[i].length)==0 && j!=0) ? "border-r-2" : "border-r";
                this.HTML+="<div class='bg-"+colour+"-400 "+bottomBorder+rigntBorder+" pl-2'>"+exhibitNames[i][j]+"</div>";
            }
        }
        this.HTML+="</div>";
        this.HTML+="</div>";
        this.HTML+="</div>";
    }

    public String toString(){
        return this.HTML;
    }
}
