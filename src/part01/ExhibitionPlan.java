package part01;

public class ExhibitionPlan {
    private int[][] exhibitionPlan; // 2d Array for exhibits stored by [month][hall]

    /**
     * constructor for an exhibition plan
     * 
     * @param exhibitionPlan    2D array of exhibit IDx, must be of length 12
     * @param exhibitManagement used to check that no exhibits in the same month
     *                          share an artifact
     * @throws Exception if months !=12 or there are shared artifacts
     */
    public ExhibitionPlan(int[][] exhibitionPlan, ExhibitManagement exhibitManagement) throws Exception {
        if (exhibitionPlan.length != 12) {
            throw new Exception("Incorrect number of Months");
        }
        for (int[] monthExhibits : exhibitionPlan) {
            if (exhibitManagement.anyDuplicateArtifcats(monthExhibits)) {
                throw new Exception("Exhibits that share Artifacts in the same Month");
            }
            ;
        }
        this.exhibitionPlan = exhibitionPlan;

    }

    /**
     * Add a new exhibit to a specific month and hall
     * 
     * @param exhibitID
     * @param month             as an int id
     * @param hallNo
     * @param exhibitManagement used to check for duplicate artifacts
     * @throws Exception if there are duplicate artifacts
     */
    public void addExhibit(int exhibitID, int month, int hallNo, ExhibitManagement exhibitManagement) throws Exception {
        int[] monthExhibits = this.exhibitionPlan[month];
        if (exhibitManagement.anyDuplicateArtifcats(monthExhibits, exhibitID, hallNo - 1)) {
            throw new Exception("Exhibits that share Artifacts in the same Month");
        }
        this.exhibitionPlan[month][hallNo - 1] = exhibitID;
    }

    /**
     * Add a new exhibit to a specific month and hall
     * 
     * @param exhibitID
     * @param month             as an String name
     * @param hallNo
     * @param exhibitManagement used to check for duplicate artifacts
     * @throws Exception if there are duplicate artifacts
     */
    public void addExhibit(int exhibitID, String month, int hallNo, ExhibitManagement exhibitManagement)
            throws Exception {
        int[] monthExhibits = this.exhibitionPlan[Months.get(month).getId()];
        if (exhibitManagement.anyDuplicateArtifcats(monthExhibits, exhibitID, hallNo - 1)) {
            throw new Exception("Exhibits that share Artifacts in the same Month");
        }
        this.exhibitionPlan[Months.get(month).getId()][hallNo - 1] = exhibitID;
    }

    /**
     * Add a new exhibit to a specific month and hall
     * 
     * @param exhibitID
     * @param month             as a Months enum
     * @param hallNo
     * @param exhibitManagement used to check for duplicate artifacts
     * @throws Exception if there are duplicate artifacts
     */
    public void addExhibit(int exhibitID, Months month, int hallNo, ExhibitManagement exhibitManagement)
            throws Exception {
        int[] monthExhibits = this.exhibitionPlan[month.getId()];
        if (exhibitManagement.anyDuplicateArtifcats(monthExhibits, exhibitID, hallNo - 1)) {
            throw new Exception("Exhibits that share Artifacts in the same Month");
        }
        this.exhibitionPlan[month.getId()][hallNo - 1] = exhibitID;
    }

    /**
     * Add a set of exhibits to each hall in a month
     * 
     * @param exhibitsID array of length equal to the number of halls
     * @param month      as an int ID
     */
    public void addExhibitsToMonth(int[] exhibitsID, int month) {
        for (int i = 0; i < this.exhibitionPlan[month].length; i++) {
            this.exhibitionPlan[month][i] = exhibitsID[i];
        }
    }

    /**
     * Add a set of exhibits to each hall in a month
     * 
     * @param exhibitsID array of length equal to the number of halls
     * @param month      as a String name
     */
    public void addExhibitsToMonth(int[] exhibitsID, String month) {
        for (int i = 0; i < this.exhibitionPlan[Months.get(month).getId()].length; i++) {
            this.exhibitionPlan[Months.get(month).getId()][i] = exhibitsID[i];
        }
    }

    /**
     * Add a set of exhibits to each hall in a month
     * 
     * @param exhibitsID array of length equal to the number of halls
     * @param month      as a Months enum
     */
    public void addExhibitsToMonth(int[] exhibitsID, Months month) {
        for (int i = 0; i < this.exhibitionPlan[month.getId()].length; i++) {
            this.exhibitionPlan[month.getId()][i] = exhibitsID[i];
        }
    }

    /**
     * Add an array of 12 exhibit IDs to a hall in everyt month
     * 
     * @param exhibitsID int[] of length 12
     * @param hallNo
     */
    public void addExhibitsToHall(int[] exhibitsID, int hallNo) {
        for (int i = 0; i < this.exhibitionPlan.length; i++) {
            this.exhibitionPlan[i][hallNo - 1] = exhibitsID[i];
        }
    }

    /**
     * get the full plan
     * 
     * @return
     */
    public int[][] getExhibitionPlan() {
        return this.exhibitionPlan;
    }

    /**
     * get the plan for a specific month
     * 
     * @param month as a Months enum
     * @return
     */
    public int[] getExibitsInMonth(Months month) {
        return this.exhibitionPlan[month.getId()];
    }

    /**
     * get the plan for a specific month
     * 
     * @param month as a String name
     * @return
     */
    public int[] getExibitsInMonth(String month) {
        Months monthEnum = Months.get(month);
        if (monthEnum == null) {
            System.err.println("Not a valid month provided");
            int[] result = {};
            return result;
        }
        return this.exhibitionPlan[monthEnum.getId()];
    }

    /**
     * get the plan for a specific month
     * 
     * @param month as an int ID
     * @return
     */
    public int[] getExibitsInMonth(int month) {
        if (month < 0 || month > 11) {
            System.err.println("Not a valid month provided");
            int[] result = {};
            return result;
        }
        return this.exhibitionPlan[month];
    }

    /**
     * get the plan for a specific hall
     * 
     * @param hallNo
     * @return
     */
    public int[] getExhibitsInHall(int hallNo) {
        hallNo -= 1;
        if (hallNo < 0 || hallNo >= exhibitionPlan[0].length) {
            System.err.println("Not a valid hall provided");
            int[] result = {};
            return result;
        }
        int[] hallExhibits = new int[exhibitionPlan.length];
        for (int i = 0; i < exhibitionPlan.length; i++) {
            hallExhibits[i] = exhibitionPlan[i][hallNo];
        }
        return hallExhibits;
    }

    /**
     * Get a array of the names for every exhibit
     * 
     * @param exhibitManagement
     * @return 2D Array of names for every exhibit
     */
    public String[][] getExhibitNames(ExhibitManagement exhibitManagement) {
        int[][] exhibits = getExhibitionPlan();
        String[][] exhibitNames = new String[exhibits.length][exhibits[0].length];
        for (int i = 0; i < exhibits.length; i++) {
            int[] monthExhibits = exhibits[i];
            String[] montExhibitNames = getExhibitNamesString(monthExhibits, exhibitManagement);
            exhibitNames[i] = montExhibitNames;

        }
        return exhibitNames;
    }

    /**
     * Get an array of names for an Array of Exhibits
     * 
     * @param exhibits
     * @param exhibitManagement
     * @return 1D array of exhibit names
     */
    public String[] getExhibitNamesString(int[] exhibits, ExhibitManagement exhibitManagement) {
        String[] exhibitNames = new String[exhibits.length];
        for (int j = 0; j < exhibits.length; j++) {
            Exhibit ex;
            try {
                ex = exhibitManagement.findExhibit(exhibits[j]);
                exhibitNames[j] = ex.getName();
            } catch (Exception e) {
                exhibitNames[j] = "Exhibit Not Found";
            }

        }
        return exhibitNames;
    }

    /**
     * Get an array of the exhibit names in a month
     * 
     * @param exhibitManagement
     * @param month             as an int ID
     * @return array of names in month
     */
    public String[] getExhibitNamesInMonth(ExhibitManagement exhibitManagement, int month) {
        int[] exhibits = getExibitsInMonth(month);
        return getExhibitNamesString(exhibits, exhibitManagement);

    }

    /**
     * Get an array of the exhibit names in a month
     * 
     * @param exhibitManagement
     * @param month             as a Months enun
     * @return array of names in month
     */
    public String[] getExhibitNamesInMonth(ExhibitManagement exhibitManagement, Months month) {
        int[] exhibits = getExibitsInMonth(month);
        return getExhibitNamesString(exhibits, exhibitManagement);

    }

    /**
     * Get an array of the exhibit names in a month
     * 
     * @param exhibitManagement
     * @param month             as a String name
     * @return array of names in month
     */
    public String[] getExhibitNamesInMonth(ExhibitManagement exhibitManagement, String month) {
        int[] exhibits = getExibitsInMonth(month);
        return getExhibitNamesString(exhibits, exhibitManagement);

    }

    /**
     * Get an array of the exhibit names in a hall
     * 
     * @param exhibitManagement
     * @param hallNo
     * @return array of names in hall
     */
    public String[] getExhibitNamesInHall(ExhibitManagement exhibitManagement, int hallNo) {
        int[] exhibits = getExhibitsInHall(hallNo);
        return getExhibitNamesString(exhibits, exhibitManagement);
    }

    /**
     * Get a String representing the entire plan
     * 
     * @param exhibitManagement
     * @return string of the plan
     */
    public String getPlanString(ExhibitManagement exhibitManagement) {
        String[][] exhibitNames = getExhibitNames(exhibitManagement);
        if (exhibitNames == null) {
            return "Exhibit in Plan not found in Exhibits";
        }
        String exhibitionPlan = "             ";
        for (int i = 0; i < exhibitNames[0].length; i++) {
            exhibitionPlan += "Exhibit Hall " + (i + 1);
            for (int j = 0; j < 40 - 14; j++) {
                exhibitionPlan += " ";
            }
        }
        exhibitionPlan += "\n";
        Months[] months = Months.values();
        for (int i = 0; i < exhibitNames.length; i++) {
            exhibitionPlan += months[i];
            for (int j = 0; j < 13 - months[i].toString().length(); j++) {
                exhibitionPlan += " ";
            }
            for (int j = 0; j < exhibitNames[i].length; j++) {
                exhibitionPlan += exhibitNames[i][j];
                for (int k = 0; k < 40 - exhibitNames[i][j].length(); k++) {
                    exhibitionPlan += " ";
                }
            }
            exhibitionPlan += "\n";
        }
        return exhibitionPlan;
    }

    /**
     * Get a String representing the plan for a specific month
     * 
     * @param exhibitManagement
     * @param month             as an int ID
     * @return string of the plan for chosen month
     */
    public String getMonthPlanString(ExhibitManagement exhibitManagement, int month) {
        String[] exhibitNames = getExhibitNamesInMonth(exhibitManagement, month);
        if (exhibitNames == null) {
            return "Exhibit in Plan not found in Exhibits";
        }
        String exhibitionPlan = "\t";
        for (int i = 0; i < exhibitNames.length; i++) {
            exhibitionPlan += "Exhibit Hall " + (i + 1) + "\t";
        }
        exhibitionPlan += "\n";
        String monthName = Months.get(month).toString();
        exhibitionPlan += monthName + "\t";
        for (int i = 0; i < exhibitNames.length; i++) {
            exhibitionPlan += exhibitNames[i] + "\t";
        }
        return exhibitionPlan;
    }

    /**
     * Get a String representing the plan for a specific month
     * 
     * @param exhibitManagement
     * @param month             as a String name
     * @return string of the plan for chosen month
     */
    public String getMonthPlanString(ExhibitManagement exhibitManagement, String month) {
        String[] exhibitNames = getExhibitNamesInMonth(exhibitManagement, month);
        if (exhibitNames == null) {
            return "Exhibit in Plan not found in Exhibits";
        }
        String exhibitionPlan = "\t";
        for (int i = 0; i < exhibitNames.length; i++) {
            exhibitionPlan += "Exhibit Hall " + (i + 1) + "\t";
        }
        exhibitionPlan += "\n";
        exhibitionPlan += month + "\t";
        for (int i = 0; i < exhibitNames.length; i++) {
            exhibitionPlan += exhibitNames[i] + "\t";
        }
        return exhibitionPlan;
    }

    /**
     * Get a String representing the plan for a specific month
     * 
     * @param exhibitManagement
     * @param month             as a Months enum
     * @return string of the plan for chosen month
     */
    public String getMonthPlanString(ExhibitManagement exhibitManagement, Months month) {
        String[] exhibitNames = getExhibitNamesInMonth(exhibitManagement, month);
        if (exhibitNames == null) {
            return "Exhibit in Plan not found in Exhibits";
        }
        String exhibitionPlan = "\t";
        for (int i = 0; i < exhibitNames.length; i++) {
            exhibitionPlan += "Exhibit Hall " + (i + 1) + "\t";
        }
        exhibitionPlan += "\n";
        exhibitionPlan += month + "\t";
        for (int i = 0; i < exhibitNames.length; i++) {
            exhibitionPlan += exhibitNames[i] + "\t";
        }
        return exhibitionPlan;
    }

    /**
     * Get a String representing the plan for a specific hall
     * 
     * @param exhibitManagement
     * @param hallNo
     * @return string of the plan for chosen hall
     */
    public String getHallPlanString(ExhibitManagement exhibitManagement, int hallNo) {
        String[] exhibitNames = getExhibitNamesInHall(exhibitManagement, hallNo);
        if (exhibitNames == null) {
            return "Exhibit in Plan not found in Exhibits";
        }
        String exhibitionPlan = "\tExhibit Hall " + hallNo + "\n";
        Months[] months = Months.values();
        for (int i = 0; i < exhibitNames.length; i++) {
            exhibitionPlan += months[i] + "\t" + exhibitNames[i] + "\n";
        }
        return exhibitionPlan;
    }

    /**
     * Get the number of halls defined for this ExhibitionPlan
     * 
     * @return number of halls
     */
    public int getNumberOfHalls() {
        return this.exhibitionPlan[0].length;
    }

}
