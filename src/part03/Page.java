package part03;

public class Page {
    private String HTML;
    
    public Page(String title, String content, String footer, String previous){
        this.HTML  = "<HTML> <head><link href='https://unpkg.com/tailwindcss@^1.0/dist/tailwind.min.css' rel='stylesheet'></head><BODY>";
        this.HTML += "<div class = 'flex flex-col justify-between h-screen bg-gray-700 overflow-y-auto'>";
        this.HTML += "<div class = 'flex flex-row text-center bg-green-500 text-2xl text-white font-bold p-2''>";
        this.HTML += "<button class='w-1/6 text-left pl-4' onClick=navigate(\""+previous.toLowerCase()+"\")> Back </button>";
        this.HTML += "<div class = 'text-center bg-green-500 text-2xl text-white font-bold p-2 w-2/3'>" + title + "</div>";
        this.HTML += "</div>";
        this.HTML += content;
        this.HTML += "<div class = 'text-center bg-green-500 text-xl text-white font-bold p-2'>" + footer + "</div>";
        this.HTML+="<script type='text/javascript'>";
        this.HTML+="function navigate(pageTitle){\n" + //
                        "    pageTitle= pageTitle.replace(\" \", \"_\")\n" + //
                        "    console.log(pageTitle)\n" +
                        "    window.location.href = \"/\"+pageTitle;\n" + //
                        "\n" + //
                        "}";
        this.HTML+="</script>";
        this.HTML += "</div>";
        this.HTML += "</BODY></HTML>";
    }

   public String toString() {
       return HTML;
   }
}
