package part01;

public class Artifact {

    private final int id;
    private String name;
    private String type;
    private int engagementTime;
    private static int nextID = 0;

    public Artifact(String name, String type, int engagementTime){
        this.id = nextID;
        this.name=name;
        this.type= type;
        this.engagementTime= engagementTime;
        nextID++;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getEngagementTime() {
        return this.engagementTime;
    }

    public void setEngagementTime(int engagementTime) {
        this.engagementTime = engagementTime;
    }


}
