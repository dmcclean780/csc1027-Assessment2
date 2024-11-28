package part03;

public class Page {
    private String HTML;
    
    public Page(String title, String content, String footer, String previous){
        this.HTML  = "<HTML class = 'h-full'> <head><link href='https://unpkg.com/tailwindcss@^2.0/dist/tailwind.min.css' rel='stylesheet'><script src='http://localhost:9990/jsFunctions.js'></script></head><BODY class = 'h-full'>";
        this.HTML += "<div class = 'flex flex-col justify-between h-full bg-gray-700 overflow-y-auto'>";
        this.HTML += "<div class = 'flex flex-row text-center bg-green-500 text-2xl text-white font-bold p-2''>";
        this.HTML += "<button class='w-1/6 text-left pl-4' onClick=navigate(\""+previous.toLowerCase()+"\")> Back </button>";
        this.HTML += "<div class = 'text-center bg-green-500 text-2xl text-white font-bold p-2 w-2/3'>" + title + "</div>";
        this.HTML += "</div>";
        this.HTML += content;
        this.HTML += "<div class = 'text-center bg-green-500 text-xl text-white font-bold p-2'>" + footer + "</div>";
        this.HTML += "</div>";
        this.HTML += "</BODY></HTML>";
    }

   public String toString() {
       return HTML;
   }
}
