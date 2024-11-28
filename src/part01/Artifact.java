package part01;

public class Artifact{
    private final int ID; // Unique ID
    private String name; // Name String -> Used in menus
    private String type; // Type String 
    private int engagementTime; //Int that must be >0
    private static int nextID = 0;

    /**
     * Constructor for Artifact
     * @param name - name of the artifact
     * @param type - type of the artifact
     * @param engagementTime - int value of expected engagement time
     * @throws TimeIsNegativeException
     */
    public Artifact(String name, String type, int engagementTime) throws TimeIsNegativeException{
        this.ID = nextID;
        this.name=name;
        this.type= type;
        if(engagementTime >0){
            this.engagementTime= engagementTime;
        }
        else{
            throw new TimeIsNegativeException();
        }
        
        nextID++;
    }
    
    /** 
     * @return unique ID of the Artifact object
     */
    public int getID() {
        return this.ID;
    }

    
    /** 
     * @return String name of Artifact object
     */
    public String getName() {
        return this.name;
    }

    
    /** 
     * @param name new name for the Artifact object
     */
    public void setName(String name) {
        this.name = name;
    }

    
    /** 
     * @return String type of the Artifact object
     */
    public String getType() {
        return this.type;
    }

    
    /** 
     * @param type new type for the Artifact object
     */
    public void setType(String type) {
        this.type = type;
    }

    
    /** 
     * @return int EngagementTime for the Artifact object 
     */
    public int getEngagementTime() {
        return this.engagementTime;
    }

    
    /** 
     * @param engagementTime for the Artifact object
     */
    public void setEngagementTime(int engagementTime) throws TimeIsNegativeException{
        if(engagementTime >0){
            this.engagementTime= engagementTime;
        }
        else{
            throw new TimeIsNegativeException();
        }
    }


    /**
     * Returns a one line String form of the Artifact object
     */
    @Override
    public String toString() {
        return "ID: " + getID() +",\tName: "+getName()+",\tType: "+getType()+",\tEngagement Time: "+getEngagementTime()+" minutes";
    }

    /**
     * Sets the nextID to 0
     * Should not be used in production - only for testing
     */
    protected static void reset(){
        nextID = 0;
    }

    public static int getNextID(){
        return nextID;
    }



}
