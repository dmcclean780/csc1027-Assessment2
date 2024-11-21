package part01;

public class ExhibitionPlan {
    private int[][] exhibitionPlan;

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

    public void addExhibit(int exhibitID, int month, int hallNo, ExhibitManagement exhibitManagement) throws Exception {
        int[] monthExhibits = this.exhibitionPlan[month];
        if (exhibitManagement.anyDuplicateArtifcats(monthExhibits, exhibitID, hallNo - 1)) {
            throw new Exception("Exhibits that share Artifacts in the same Month");
        }
        this.exhibitionPlan[month][hallNo - 1] = exhibitID;
    }

    public void addExhibit(int exhibitID, String month, int hallNo, ExhibitManagement exhibitManagement) throws Exception  {
        int[] monthExhibits = this.exhibitionPlan[Months.get(month).getId()];
        if (exhibitManagement.anyDuplicateArtifcats(monthExhibits, exhibitID, hallNo - 1)) {
            throw new Exception("Exhibits that share Artifacts in the same Month");
        }
        this.exhibitionPlan[Months.get(month).getId()][hallNo - 1] = exhibitID;
    }

    public void addExhibit(int exhibitID, Months month, int hallNo, ExhibitManagement exhibitManagement) throws Exception  {
        int[] monthExhibits = this.exhibitionPlan[month.getId()];
        if (exhibitManagement.anyDuplicateArtifcats(monthExhibits, exhibitID, hallNo - 1)) {
            throw new Exception("Exhibits that share Artifacts in the same Month");
        }
        this.exhibitionPlan[month.getId()][hallNo - 1] = exhibitID;
    }

    public void addExhibitsToMonth(int[] exhibitsID, int month) {
        for (int i = 0; i < this.exhibitionPlan[month].length; i++) {
            this.exhibitionPlan[month][i] = exhibitsID[i];
        }
    }

    public void addExhibitsToMonth(int[] exhibitsID, String month) {
        for (int i = 0; i < this.exhibitionPlan[Months.get(month).getId()].length; i++) {
            this.exhibitionPlan[Months.get(month).getId()][i] = exhibitsID[i];
        }
    }

    public void addExhibitsToMonth(int[] exhibitsID, Months month) {
        for (int i = 0; i < this.exhibitionPlan[month.getId()].length; i++) {
            this.exhibitionPlan[month.getId()][i] = exhibitsID[i];
        }
    }

    public void addExhibitsToHall(int[] exhibitsID, int hallNo) {
        for (int i = 0; i < this.exhibitionPlan.length; i++) {
            this.exhibitionPlan[i][hallNo - 1] = exhibitsID[i];
        }
    }

    public int[][] getExhibitionPlan() {
        return this.exhibitionPlan;
    }

    public int[] getExibitsInMonth(Months month) {
        return this.exhibitionPlan[month.getId()];
    }

    public int[] getExibitsInMonth(String month) {
        Months monthEnum = Months.get(month);
        return this.exhibitionPlan[monthEnum.getId()];
    }

    public int[] getExibitsInMonth(int month) {
        return this.exhibitionPlan[month];
    }

    public int[] getExhibitsInHall(int hallNo) {
        hallNo -= 1;
        int[] hallExhibits = new int[exhibitionPlan.length];
        for (int i = 0; i < exhibitionPlan.length; i++) {
            hallExhibits[i] = exhibitionPlan[i][hallNo];
        }
        return hallExhibits;
    }

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

    public String[] getExhibitNamesInMonth(ExhibitManagement exhibitManagement, int month) {
        int[] exhibits = getExibitsInMonth(month);
        return getExhibitNamesString(exhibits, exhibitManagement);

    }

    public String[] getExhibitNamesInMonth(ExhibitManagement exhibitManagement, Months month) {
        int[] exhibits = getExibitsInMonth(month);
        return getExhibitNamesString(exhibits, exhibitManagement);

    }

    public String[] getExhibitNamesInMonth(ExhibitManagement exhibitManagement, String month) {
        int[] exhibits = getExibitsInMonth(month);
        return getExhibitNamesString(exhibits, exhibitManagement);

    }

    public String[] getExhibitNamesInHall(ExhibitManagement exhibitManagement, int hallNo) {
        int[] exhibits = getExhibitsInHall(hallNo);
        return getExhibitNamesString(exhibits, exhibitManagement);
    }

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

    public String getMonthPlanString(ExhibitManagement exhibitManagement, int month) {
        String[] exhibitNames = getExhibitNamesInMonth(exhibitManagement, month);
        if (exhibitNames == null) {
            return "Exhibit in Plan not found in Exhibits";
        }
        String exhibitionPlan = "\t";
        for (int i = 0; i < exhibitNames.length; i++) {
            exhibitionPlan += "Exhibit Hall " + i + "\t";
        }
        exhibitionPlan += "\n";
        String monthName = Months.get(month).toString();
        exhibitionPlan += monthName + "\t";
        for (int i = 0; i < exhibitNames.length; i++) {
            exhibitionPlan += exhibitNames[i] + "\t";
        }
        return exhibitionPlan;
    }

    public String getMonthPlanString(ExhibitManagement exhibitManagement, String month) {
        String[] exhibitNames = getExhibitNamesInMonth(exhibitManagement, month);
        if (exhibitNames == null) {
            return "Exhibit in Plan not found in Exhibits";
        }
        String exhibitionPlan = "\t";
        for (int i = 0; i < exhibitNames.length; i++) {
            exhibitionPlan += "Exhibit Hall " + i + "\t";
        }
        exhibitionPlan += "\n";
        exhibitionPlan += month + "\t";
        for (int i = 0; i < exhibitNames.length; i++) {
            exhibitionPlan += exhibitNames[i] + "\t";
        }
        return exhibitionPlan;
    }

    public String getMonthPlanString(ExhibitManagement exhibitManagement, Months month) {
        String[] exhibitNames = getExhibitNamesInMonth(exhibitManagement, month);
        if (exhibitNames == null) {
            return "Exhibit in Plan not found in Exhibits";
        }
        String exhibitionPlan = "\t";
        for (int i = 0; i < exhibitNames.length; i++) {
            exhibitionPlan += "Exhibit Hall " + i + "\t";
        }
        exhibitionPlan += "\n";
        exhibitionPlan += month + "\t";
        for (int i = 0; i < exhibitNames.length; i++) {
            exhibitionPlan += exhibitNames[i] + "\t";
        }
        return exhibitionPlan;
    }

    public String getHallPlanstring(ExhibitManagement exhibitManagement, int hallNo) {
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

    public int getNumberOfHalls() {
        return this.exhibitionPlan[0].length;
    }

}
