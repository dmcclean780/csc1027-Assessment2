package part03;

public class Menu {

    private String HTMLString;

    // Generic menu that takes string[] of options and create buttons that has these options as test and navigates to pages
    // named for these options(spaces become -)
    public Menu(String[] menuOptions , String current){
        this.HTMLString = "<div class = 'flex flex-row justify-center h-full'>";
        this.HTMLString += "<div class = 'flex flex-col justify-around w-2/3 h-full'>";
        for (String option : menuOptions) {
           String url = (!current.equals("")) ? current+"/"+option.toLowerCase() : option.toLowerCase();
            this.HTMLString += "<button class='bg-gray-400 flex-grow my-10 text-xl font-bold rounded-lg' onClick='navigate(\""+url+"\")'>" + option + "</button>";
        }
        this.HTMLString+="</div>";
        this.HTMLString+="</div>";
    }

    public String toString(){
        return HTMLString;
    }
}
