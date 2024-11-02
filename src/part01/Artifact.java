package part01;

public class Artifact {
    private final int id;
    private String name;
    private String type;
    private int engagementTime;
    private static int nextID = 0;

    /**
     * 
     * @param name - name of the artifact
     * @param type - type of the artifact
     * @param engagementTime - int value of expected engagement time
     * @throws TimeIsNegativeException
     */
    public Artifact(String name, String type, int engagementTime) throws TimeIsNegativeException{
        this.id = nextID;
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
     * @return int
     */
    public int getId() {
        return this.id;
    }

    
    /** 
     * @return String
     */
    public String getName() {
        return this.name;
    }

    
    /** 
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    
    /** 
     * @return String
     */
    public String getType() {
        return this.type;
    }

    
    /** 
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    
    /** 
     * @return int
     */
    public int getEngagementTime() {
        return this.engagementTime;
    }

    
    /** 
     * @param engagementTime
     */
    public void setEngagementTime(int engagementTime) throws TimeIsNegativeException{
        if(engagementTime >0){
            this.engagementTime= engagementTime;
        }
        else{
            throw new TimeIsNegativeException();
        }
    }


    @Override
    public String toString() {
        return "ID: " + getId() +"\tName: "+getName()+"\tType: "+getType()+"\tEngagement Time: "+getEngagementTime();
    }



}
