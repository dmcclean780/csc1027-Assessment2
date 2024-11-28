package part03;

public class DeletedArtifact {
    
    private String HTML;

    public DeletedArtifact(String name){
        this.HTML = "<div class = 'flex flex-row justify-center h-full w-full' >";
        this.HTML += "<div class = 'flex flex-col justify-center h-full w-2/3'>";
        this.HTML += "<div class = 'flex flex-row justify-center bg-gray-400 rounded-lg h-2/3'>";
        this.HTML += "<div class = 'flex flex-col justify-center  h-full'>";
        this.HTML += "<div class= 'text-center font-bold text-xl lg:text-4xl p-4 underline'>Artifact Deleted</div>";
        this.HTML += "<div class= 'text-center font-bold text-xl lg:text-4xl p-4'>"+name+"</div>";
        this.HTML += "<button class = 'w-full bg-green-500 font-bold text-white p-4 rounded-md' onClick='navigate(\"manage_artifacts/delete_artifact\")'>OK</button>";
        this.HTML += "</div>";
        this.HTML += "</div>";
        this.HTML += "</div>";
        this.HTML += "</div>";
    }

    public String toString(){
        return this.HTML;
    }
}
