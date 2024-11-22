package part01;

import java.util.ArrayList;
import java.util.Scanner;

public class QUBMuseum {
    private  ArtifactManagement artifactManagement ;
    private  ExhibitManagement exhibitManagement ;
    private  ExhibitionPlan exhibitionPlan;

    private static Scanner input = new Scanner(System.in);

    private String generalMenuTitle;
    private static final String[] generalMenuOptions = { "Manage Artifacts", "Manage Exhibits", "Mangage Annual Plan",
            "Quit" };

    public static void main(String[] args) {
        QUBMuseum museum = new QUBMuseum();
        museum.generalMenuTitle="QUB Museum";
        museum.popArtifacts();
        museum.popExhibits();
        museum.popPlan();
        museum.runMuseumApplication();
    }

    private void runMuseumApplication(){
        Menu generalMenu = new Menu(generalMenuTitle, generalMenuOptions);
        while (true) {
            int choice = generalMenu.getUserChoice();
            boolean quit = processGeneralMenuChoice(choice);
            if (quit) {
                break;
            }

        }
        System.out.println("All done - Goodbye!");
    }

    private  boolean processGeneralMenuChoice(int choice) {
        boolean quit = false;
        switch (choice) {
            case 1:
                manageArtifacts();
                break;
            case 2:
                manageExhibits();
                break;
            case 3:
                exhibitionPlan = manageAnnualPlan();
                break;
            case 4:

                quit = true;
        }
        return quit;
    }

    public  void manageArtifacts() {
        System.out.println("Manage Artifacts");
        SubMenu menu = new SubMenu("Artifact");
        while (true) {
            int choice = menu.getUserChoice();
            boolean quit = processArtifactMenuChoice(choice);
            if (quit) {
                break;
            }

        }
    }

    private  boolean processArtifactMenuChoice(int choice) {
        boolean quit = false;
        artifactManagement.refreshArtifactArray();
        Menu artifactMenu = artifactManagement.getArtifactMenu();
        System.out.println();
        switch (choice) {
            case 1:
                addArtifact();
                break;
            case 2:
                while (true) {
                    System.out.print("View ");
                    int artifactChoice = artifactMenu.getUserChoice();
                    if (artifactChoice - 1 == artifactManagement.getArtifactArrayLength()) {
                        searchArtifacts();
                        artifactMenu = artifactManagement.getArtifactMenu();
                        continue;
                    }
                    if (artifactChoice - 2 == artifactManagement.getArtifactArrayLength()) {
                        artifactManagement.refreshArtifactArray();
                        artifactMenu = artifactManagement.getArtifactMenu();
                        continue;
                    }

                    boolean quitViewing = viewArtifact(artifactChoice);
                    if (quitViewing) {
                        break;
                    }

                }
                break;
            case 3:
                while (true) {
                    System.out.print("Update ");
                    int artifactChoice = artifactMenu.getUserChoice();
                    if (artifactChoice - 1 == artifactManagement.getArtifactArrayLength()) {
                        searchArtifacts();
                        artifactMenu = artifactManagement.getArtifactMenu();
                        continue;
                    }
                    if (artifactChoice - 2 == artifactManagement.getArtifactArrayLength()) {
                        artifactManagement.refreshArtifactArray();
                        artifactMenu = artifactManagement.getArtifactMenu();
                        continue;
                    }
                    boolean quitUpdating = updateArtifact(artifactChoice);
                    artifactManagement.refreshArtifactArray();
                    artifactMenu = artifactManagement.getArtifactMenu();
                    if (quitUpdating) {
                        break;
                    }
                }
                break;
            case 4:
                while (true) {
                    System.out.print("Delete ");
                    int artifactChoice = artifactMenu.getUserChoice();
                    if (artifactChoice - 1 == artifactManagement.getArtifactArrayLength()) {
                        searchArtifacts();
                        artifactMenu = artifactManagement.getArtifactMenu();
                        continue;
                    }
                    if (artifactChoice - 2 == artifactManagement.getArtifactArrayLength()) {
                        artifactManagement.refreshArtifactArray();
                        artifactMenu = artifactManagement.getArtifactMenu();
                        continue;
                    }
                    boolean quitDeleting = deleteArtifact(artifactChoice);
                    artifactManagement.refreshArtifactArray();
                    artifactMenu = artifactManagement.getArtifactMenu();
                    if (quitDeleting) {
                        break;
                    }

                }
                break;
            case 5:
                quit = true;
        }
        return quit;
    }

    private  void addArtifact() {
        System.out.println("Add Artifact");

        String name;
        while (true) {
            System.out.print("Enter Exhibit Name:");
            name = input.nextLine();
            if (name.length() < 40) {
                break;
            }
            System.out.println("Name must be less than 40 Characters");
        }

        System.out.print("Enter Artifact Type:");
        String type = input.nextLine();
        System.out.print("Enter Artifact Expected Engagement Time:");
        int engagementTime;
        while (true) {
            try {
                engagementTime = input.nextInt();
                boolean valid = artifactManagement.addArtifact(name, type, engagementTime);
                if (!valid) {
                    System.out.println("Bad Data");
                    continue;
                }
                break;
            } catch (Exception e) {
                input.nextLine();
                System.out.println("Please enter an Integer");
            }
        }

        System.out.println();
        input.nextLine();
    }

    private  boolean viewArtifact(int choice) {

        if (choice - 3 == artifactManagement.getArtifactArrayLength()) {
            return true;
        }

        System.out.println(artifactManagement.getArtifactString(choice - 1));
        System.out.println();
        return false;
    }

    private  boolean updateArtifact(int choice) {
        if (choice - 3 == artifactManagement.getArtifactArrayLength()) {
            return true;
        }

        System.out.println("Enter new data or press RETURN to leave unchanged");
        System.out.print("Enter Artifact Name:");
        String name = input.nextLine();

        System.out.print("Enter Artifact Type:");
        String type = input.nextLine();

        while (true) {

            System.out.print("Enter Artifact Expected Engagement Time:");
            String engagementTimeString = input.nextLine();
            boolean valid = artifactManagement.updateArtifact(choice - 1, name, type, engagementTimeString);
            if (!valid) {
                continue;
            }
            break;
        }
        return false;
    }

    private  boolean deleteArtifact(int choice) {
        if (choice - 3 == artifactManagement.getArtifactArrayLength()) {
            return true;
        }
        int id = artifactManagement.getArtifactID(choice - 1);
        exhibitManagement.removeArtifactsWithID(id);
        artifactManagement.removeArtifact(choice - 1);
        return false;
    }

    public  void manageExhibits() {
        System.out.println("Manage Exhibits");
        SubMenu menu = new SubMenu("Exhibit");
        while (true) {
            int choice = menu.getUserChoice();
            boolean quit = processExhibitMenuChoice(choice);
            if (quit) {
                break;
            }

        }
    }

    private  boolean processExhibitMenuChoice(int choice) {
        boolean quit = false;
        exhibitManagement.refreshExhibitArray();
        Menu exhibitMenu = exhibitManagement.getExhibitMenu();
        System.out.println();
        switch (choice) {
            case 1:
                addExhibit();
                break;
            case 2:
                while (true) {
                    System.out.print("View ");
                    int exhibitChoice = exhibitMenu.getUserChoice();
                    if (exhibitChoice - 1 == exhibitManagement.getExhibitArrayLength()) {
                        searchExhibits();
                        exhibitMenu = exhibitManagement.getExhibitMenu();
                        continue;
                    }
                    if (exhibitChoice - 2 == exhibitManagement.getExhibitArrayLength()) {
                        exhibitManagement.refreshExhibitArray();
                        exhibitMenu = exhibitManagement.getExhibitMenu();
                        continue;
                    }
                    boolean quitViewing = viewExhibit(exhibitChoice);
                    if (quitViewing) {
                        break;
                    }

                }
                break;
            case 3:
                while (true) {
                    System.out.print("Update ");
                    int exhibitChoice = exhibitMenu.getUserChoice();
                    if (exhibitChoice - 1 == exhibitManagement.getExhibitArrayLength()) {
                        searchExhibits();
                        exhibitMenu = exhibitManagement.getExhibitMenu();
                        continue;
                    }
                    if (exhibitChoice - 2 == exhibitManagement.getExhibitArrayLength()) {
                        exhibitManagement.refreshExhibitArray();
                        exhibitMenu = exhibitManagement.getExhibitMenu();
                        continue;
                    }
                    boolean quitUpdating = updateExhibit(exhibitChoice);
                    exhibitManagement.refreshExhibitArray();
                    exhibitMenu = exhibitManagement.getExhibitMenu();
                    if (quitUpdating) {
                        break;
                    }
                }
                break;
            case 4:
                while (true) {
                    System.out.print("Delete ");
                    int exhibitChoice = exhibitMenu.getUserChoice();
                    if (exhibitChoice - 1 == exhibitManagement.getExhibitArrayLength()) {
                        searchExhibits();
                        exhibitMenu = exhibitManagement.getExhibitMenu();
                        continue;
                    }
                    if (exhibitChoice - 2 == exhibitManagement.getExhibitArrayLength()) {
                        exhibitManagement.refreshExhibitArray();
                        exhibitMenu = exhibitManagement.getExhibitMenu();
                        continue;
                    }
                    boolean quitDeleting = deleteExhibit(exhibitChoice);
                    exhibitManagement.refreshExhibitArray();
                    exhibitMenu = exhibitManagement.getExhibitMenu();
                    if (quitDeleting) {
                        break;
                    }
                }
                break;
            case 5:
                quit = true;
        }
        return quit;
    }

    private  void addExhibit() {
        System.out.println("Add Exhibit");

        String name;
        while (true) {
            System.out.print("Enter Exhibit Name:");
            name = input.nextLine();
            if (name.length() < 40) {
                break;
            }
            System.out.println("Name must be less than 40 Characters");
        }

        System.out.print("Select What Artifacts to Include in the Order They Are in the Exhibit:");
        artifactManagement.refreshArtifactArray();
        Menu artifactMenu = artifactManagement.getArtifactMenu();

        ArrayList<Integer> exhibitArtifacts = new ArrayList<Integer>();
        while (true) {
            int artifactChoice = artifactMenu.getUserChoice();
            if (artifactChoice - 1 == artifactManagement.getArtifactArrayLength()) {
                searchArtifacts();
                artifactMenu = artifactManagement.getArtifactMenu();
                continue;
            }
            if (artifactChoice - 2 == artifactManagement.getArtifactArrayLength()) {
                artifactManagement.refreshArtifactArray();
                artifactMenu = artifactManagement.getArtifactMenu();
                continue;
            }
            if (artifactChoice - 3 == artifactManagement.getArtifactArrayLength()) {
                break;
            }
            if (!Utils.contains(artifactManagement.getArtifactID(artifactChoice - 1), exhibitArtifacts)) {
                exhibitArtifacts.add(artifactManagement.getArtifactArray()[artifactChoice - 1].getID());
            } else {
                System.out.println("Artifact Already in Exhibit");
            }

        }

        ArrayList<String> exhibitRoute = new ArrayList<String>();
        System.out.println("Enter text for the sign on the route at each artifact");
        for (int i = 0; i < exhibitArtifacts.size(); i++) {
            System.out.print("Artifact " + (i + 1) + ": ");
            String sign = input.nextLine();
            exhibitRoute.add(sign);
        }

        boolean valid = exhibitManagement.addExhibit(name, exhibitArtifacts, exhibitRoute);
        if (!valid) {
            System.out.println("Bad Data");
        }
        System.out.println();

    }

    private  boolean viewExhibit(int choice) {

        if (choice - 3 == exhibitManagement.getExhibitArrayLength()) {
            return true;
        }
        System.out.println(exhibitManagement.getExhibitString(choice - 1, artifactManagement));
        System.out.println();
        return false;
    }

    private boolean updateExhibit(int choice) {
        if (choice - 3 == exhibitManagement.getExhibitArrayLength()) {
            return true;
        }

        System.out.println("Update Exhibit");
        System.out.println("Enter new data or press RETURN to leave unchanged");

        String name;
        while (true) {
            System.out.print("Enter Exhibit Name:");
            name = input.nextLine();
            if (name.length() < 40) {
                break;
            }
            System.out.println("Name must be less than 40 Characters");
        }
        String[] artifactModifications = { "Add", "Remove", "Update", "End" };
        Menu artifactActionMenu = new Menu("Change Exhibit Artifacts", artifactModifications);
        while (true) {
            int artifactAction = artifactActionMenu.getUserChoice();
            if (artifactAction == 4) {
                break;
            }
            if (artifactAction == 3) {
                updateExhibitArtifacts(choice, name);
            }
            if (artifactAction == 2) {
                removeExhibitArtifacts(choice, name);
            }
            if (artifactAction == 1) {
                addExhibitArtifact(choice, name);
            }
        }

        return false;
    }

    private void addExhibitArtifact(int choice, String name) {
        ArrayList<String> route = exhibitManagement.getExhibitRoute(choice - 1);
        ArrayList<Integer> exhibitArtifacts = exhibitManagement.getExhibitArtifacts(choice - 1);
        artifactManagement.refreshArtifactArray();
        Menu artifactMenu = artifactManagement.getArtifactMenu();
        while (true) {
            System.out.println("Select new Artifact");

            int artifactChoice = artifactMenu.getUserChoice();
            if (artifactChoice - 1 == artifactManagement.getArtifactArrayLength()) {
                searchArtifacts();
                artifactMenu = artifactManagement.getArtifactMenu();
                continue;
            }
            if (artifactChoice - 2 == artifactManagement.getArtifactArrayLength()) {
                artifactManagement.refreshArtifactArray();
                artifactMenu = artifactManagement.getArtifactMenu();
                continue;
            }
            if (artifactChoice - 3 == artifactManagement.getArtifactArrayLength()) {
                break;
            }
            if (!Utils.contains(artifactManagement.getArtifactID(artifactChoice - 1), exhibitArtifacts)) {
                exhibitArtifacts.add(artifactManagement.getArtifactID(artifactChoice - 1));
                break;
            } else {
                System.out.println("Artifact Already in Exhibit");
            }
        }
        System.out.print("Enter new Sign: ");
        String sign = input.nextLine();
        route.add(sign);
        boolean validData = exhibitManagement.updateExhibit(choice - 1, name, exhibitArtifacts, route);
        if (!validData) {
            System.out.println("Bad Data");
        }
    }

    private void removeExhibitArtifacts(int choice, String name) {
        ArrayList<String> route = exhibitManagement.getExhibitRoute(choice - 1);
        while (true) {
            Menu artifactMenu = exhibitManagement.getExhibitArtifactMenu(choice - 1, artifactManagement);
            int artifactCount = exhibitManagement.getArtifactNumber(choice - 1);
            int artifactChoice = artifactMenu.getUserChoice();
            if (artifactChoice - 1 == artifactCount) {
                break;
            }
            ArrayList<Integer> exhibitArtifacts = exhibitManagement.getExhibitArtifacts(choice - 1);
            exhibitArtifacts.remove(artifactChoice - 1);
            route.remove(artifactChoice - 1);
            boolean validData = exhibitManagement.updateExhibit(choice - 1, name, exhibitArtifacts, route);
            if (!validData) {
                System.out.println("Bad Data");
            }
        }

    }

    private void updateExhibitArtifacts(int choice, String name) {
        ArrayList<String> route = exhibitManagement.getExhibitRoute(choice - 1);
        while (true) {
            Menu artifactMenu = exhibitManagement.getExhibitArtifactMenu(choice - 1, artifactManagement);
            int artifactCount = exhibitManagement.getArtifactNumber(choice - 1);
            int artifactChoice = artifactMenu.getUserChoice();

            if (artifactChoice - 1 == artifactCount) {
                break;
            }
            ArrayList<Integer> exhibitArtifacts = exhibitManagement.getExhibitArtifacts(choice - 1);
            artifactManagement.refreshArtifactArray();
            Menu allArtifactMenu = artifactManagement.getArtifactMenu();
            while (true) {
                System.out.println("Select new Artifact");

                int newArtifactChoice = allArtifactMenu.getUserChoice();
                if (newArtifactChoice - 1 == artifactManagement.getArtifactArrayLength()) {
                    searchArtifacts();
                    allArtifactMenu = artifactManagement.getArtifactMenu();
                    continue;
                }
                if (newArtifactChoice - 2 == artifactManagement.getArtifactArrayLength()) {
                    artifactManagement.refreshArtifactArray();
                    allArtifactMenu = artifactManagement.getArtifactMenu();
                    continue;
                }
                if (newArtifactChoice - 3 == artifactManagement.getArtifactArrayLength()) {
                    break;
                }
                if (!Utils.contains(artifactManagement.getArtifactID(artifactChoice - 1), exhibitArtifacts)) {
                    exhibitArtifacts.remove(artifactChoice - 1);
                    exhibitArtifacts.add(artifactChoice - 1, artifactManagement.getArtifactID(artifactChoice - 1));
                    break;
                } else {
                    System.out.println("Artifact Already in Exhibit");
                }
            }
            System.out.print("Enter new Sign: ");
            String sign = input.nextLine();
            route.remove(artifactChoice - 1);
            route.add(artifactChoice - 1, sign);
            boolean validData = exhibitManagement.updateExhibit(choice - 1, name, exhibitArtifacts, route);
            if (!validData) {
                System.out.println("Bad Data");
            }
        }
    }

    private boolean deleteExhibit(int choice) {
        if (choice - 3 == exhibitManagement.getExhibitArrayLength()) {
            return true;
        }
        exhibitManagement.removeExhibit(choice - 1);
        return false;
    }

    private ExhibitionPlan manageAnnualPlan() {
        String[] annualPlanOptions = { "Create", "View", "Update", "Quit" };
        Menu annualPlanMenu = new Menu("Manage Annual Plan", annualPlanOptions);
        boolean quit = false;
        while (!quit) {
            int choice = annualPlanMenu.getUserChoice();
            switch (choice) {
                case 1:
                    exhibitionPlan = createAnnualPlan();
                    break;
                case 2:
                    viewAnnualPlan();
                    break;
                case 3:
                    exhibitionPlan = updateAnnualPlan();
                    break;
                case 4:
                    quit = true;
                    break;
                default:
                    break;
            }
        }
        return exhibitionPlan;
    }

    public  ExhibitionPlan createAnnualPlan() {
        int noOfHalls;
        int[][] exhibitionExhibits;
        while (true) {
            System.out.print("Enter the number of halls: ");
            try {
                noOfHalls = input.nextInt();
                break;
            } catch (Exception e) {
                input.nextLine();
                System.out.println("Invalid Input, Try Again");
            }
        }
        exhibitionExhibits = new int[12][noOfHalls];
        while (true) {

            exhibitManagement.refreshExhibitArray();
            Menu exhibitMenu = exhibitManagement.getExhibitMenu();
            for (int i = 0; i < exhibitionExhibits.length; i++) {
                System.out.println("Select Exhibits for " + Months.get(i));
                for (int j = 0; j < exhibitionExhibits[i].length; j++) {
                    int exhibitChoice = exhibitMenu.getUserChoice();
                    if (exhibitChoice - 1 == exhibitManagement.getExhibitArrayLength()) {
                        searchExhibits();
                        exhibitMenu = exhibitManagement.getExhibitMenu();
                        j--;
                        continue;
                    }
                    if (exhibitChoice - 2 == exhibitManagement.getExhibitArrayLength()) {
                        exhibitManagement.refreshExhibitArray();
                        exhibitMenu = exhibitManagement.getExhibitMenu();
                        j--;
                        continue;
                    }
                    if (exhibitChoice - 3 == exhibitManagement.getExhibitArrayLength()) {
                        exhibitionExhibits[i][j] = -1;
                    } else {
                        exhibitionExhibits[i][j] = exhibitManagement.getExhibitID(exhibitChoice - 1);
                    }
                }
            }
            try {
                return exhibitionPlan = new ExhibitionPlan(exhibitionExhibits, exhibitManagement);
            } catch (Exception e) {

                System.out.println("Exhibits that Share Artifacts in the same Month, try again");
                System.out.println();
            }
        }

    }

    private void viewAnnualPlan() {
        String[] viewOptions = { "Entire Plan", "Choose Month", "Choose Hall", "Quit" };
        Menu viewMenu = new Menu("Select what to View", viewOptions);
        boolean quit = false;
        while (!quit) {
            int choice = viewMenu.getUserChoice();
            switch (choice) {
                case 1:
                    System.out.println(exhibitionPlan.getPlanString(exhibitManagement));
                    break;
                case 2:
                    Menu monthMenu = new Menu("Choose a month to view", Months.toArray());
                    int month = monthMenu.getUserChoice() - 1;
                    System.out.println(exhibitionPlan.getMonthPlanString(exhibitManagement, month));
                    break;
                case 3:
                    String[] hallOptions = new String[exhibitionPlan.getNumberOfHalls()];
                    for (int i = 0; i < hallOptions.length; i++) {
                        hallOptions[i] = "Exhibit Hall " + i;
                    }
                    Menu hallMenu = new Menu("Choose Exhibit Hall", hallOptions);
                    int hall = hallMenu.getUserChoice();
                    System.out.println(exhibitionPlan.getHallPlanString(exhibitManagement, hall));
                    break;
                case 4:
                    quit = true;
                    break;
                default:
                    break;
            }
        }

    }

    private ExhibitionPlan updateAnnualPlan() {
        String[] updateOptions = { "Individual Exhibit", "Entire Month", "Entire Hall", "Quit" };
        Menu updateMenu = new Menu("Select Update to Do", updateOptions);
        boolean quit = false;
        exhibitManagement.refreshExhibitArray();
        Menu exhibitMenu = exhibitManagement.getExhibitMenu();
        Menu monthMenu = new Menu("Choose a month to view", Months.toArray());
        int month;
        String[] hallOptions = new String[exhibitionPlan.getNumberOfHalls()];
        for (int i = 0; i < hallOptions.length; i++) {
            hallOptions[i] = "Exhibit Hall " + (i + 1);
        }
        Menu hallMenu = new Menu("Choose Exhibit Hall", hallOptions);
        int hall;
        while (!quit) {
            int choice = updateMenu.getUserChoice();
            switch (choice) {
                case 1:
                    month = monthMenu.getUserChoice() - 1;
                    hall = hallMenu.getUserChoice();
                    exhibitionPlan = changeExhibit(exhibitMenu, month, hall);
                    break;
                case 2:
                    month = monthMenu.getUserChoice() - 1;
                    exhibitionPlan = changeMonth(exhibitMenu, month);
                    break;
                case 3:
                    hall = hallMenu.getUserChoice();
                    exhibitionPlan = changeHall(exhibitMenu, hall);
                    break;
                case 4:
                    quit = true;
                    break;
                default:
                    break;
            }
        }
        return exhibitionPlan;
    }

    private  ExhibitionPlan changeExhibit(Menu exhibitMenu, int month, int hall){
        while (true) {
            int exhibitChoice = exhibitMenu.getUserChoice();
            if (exhibitChoice - 1 == exhibitManagement.getExhibitArrayLength()) {
                searchExhibits();
                exhibitMenu = exhibitManagement.getExhibitMenu();
                continue;
            }
            if (exhibitChoice - 2 == exhibitManagement.getExhibitArrayLength()) {
                exhibitManagement.refreshExhibitArray();
                exhibitMenu = exhibitManagement.getExhibitMenu();
                continue;
            }
            if (exhibitChoice - 3 == exhibitManagement.getExhibitArrayLength()) {
                break;
            } else {
                try{
                    exhibitionPlan.addExhibit(exhibitManagement.getExhibitID(exhibitChoice - 1), month, hall, exhibitManagement);
                    break;
                } catch (Exception e){
                    System.out.println("Exhibts Share Artifacts");
                }
                
            }
        }
        return exhibitionPlan;
    }

    private  ExhibitionPlan changeMonth(Menu exhibitMenu, int month){
        for (int i = 0; i < exhibitionPlan.getNumberOfHalls(); i++) {
            int exhibitChoice = exhibitMenu.getUserChoice();
            if (exhibitChoice - 1 == exhibitManagement.getExhibitArrayLength()) {
                searchExhibits();
                exhibitMenu = exhibitManagement.getExhibitMenu();
                i--;
                continue;
            }
            if (exhibitChoice - 2 == exhibitManagement.getExhibitArrayLength()) {
                exhibitManagement.refreshExhibitArray();
                exhibitMenu = exhibitManagement.getExhibitMenu();
                i--;
                continue;
            }
            if (exhibitChoice - 3 == exhibitManagement.getExhibitArrayLength()) {
                break;
            } else {
                try{
                    exhibitionPlan.addExhibit(exhibitManagement.getExhibitID(exhibitChoice - 1), month, i + 1, exhibitManagement);
                } catch (Exception e){
                    System.out.println("Exhibits Share Artifacts");
                    i--;
                }
                

            }
        }
        return exhibitionPlan;
    }

    private  ExhibitionPlan changeHall(Menu exhibitMenu, int hall){
        for (int i = 0; i < Months.values().length; i++) {
            int exhibitChoice = exhibitMenu.getUserChoice();
            if (exhibitChoice - 1 == exhibitManagement.getExhibitArrayLength()) {
                searchExhibits();
                exhibitMenu = exhibitManagement.getExhibitMenu();
                i--;
                continue;
            }
            if (exhibitChoice - 2 == exhibitManagement.getExhibitArrayLength()) {
                exhibitManagement.refreshExhibitArray();
                exhibitMenu = exhibitManagement.getExhibitMenu();
                i--;
                continue;
            }
            if (exhibitChoice - 3 == exhibitManagement.getExhibitArrayLength()) {
                break;
            } else {
                try{
                    exhibitionPlan.addExhibit(exhibitManagement.getExhibitID(exhibitChoice - 1), i, hall, exhibitManagement);
                } catch (Exception e){
                    System.out.println("Exhibits Share Artifacts");
                    i--;
                }
               
            }
        }
        return exhibitionPlan;
    }

    private  void searchArtifacts() {
        String[] searchCriteriaOptions = { "ID", "Name", "Type", "Engagement Time", "Cancel" };
        Menu searchCriteria = new Menu("Select Search Criteria", searchCriteriaOptions);
        int criteriaChoice = searchCriteria.getUserChoice();
        String searchValue = "";
        switch (criteriaChoice) {
            case 1:
                while (true) {
                    System.out.print("Enter ID to search for: ");
                    try {
                        int id = input.nextInt();
                        searchValue = String.valueOf(id);
                        break;
                    } catch (Exception e) {
                        input.nextLine();
                        System.out.println("Please enter an Integer");
                    }
                }
                break;

            case 2:
                System.out.print("Enter Name to search for: ");
                searchValue = input.nextLine();
                break;
            case 3:
                System.out.print("Enter Type to search for: ");
                searchValue = input.nextLine();
                break;
            case 4:
                System.out.print("Enter Engagement Time to search for: ");
                try {
                    int time = input.nextInt();
                    if (time < 0) {
                        new Exception();
                    }
                    searchValue = String.valueOf(time);
                    break;
                } catch (Exception e) {
                    input.nextLine();
                    System.out.println("Please enter an Integer");
                }
                break;
        }
        boolean searchStatus = artifactManagement.searchArtifacts(criteriaChoice, searchValue);
        if (!searchStatus) {
            System.out.println("No matching Artifacts");
        }
    }

    private  void searchExhibits() {
        String[] searchCriteriaOptions = { "ID", "Name", "Cancel" };
        Menu searchCriteria = new Menu("Select Search Criteria", searchCriteriaOptions);
        int criteriaChoice = searchCriteria.getUserChoice();
        String searchValue = "";
        switch (criteriaChoice) {
            case 1:
                while (true) {
                    System.out.print("Enter ID to search for: ");
                    try {
                        int id = input.nextInt();
                        searchValue = String.valueOf(id);
                        break;
                    } catch (Exception e) {
                        input.nextLine();
                        System.out.println("Please enter an Integer");
                    }
                }
                break;

            case 2:
                System.out.print("Enter Name to search for: ");
                searchValue = input.nextLine();
                break;
        }
        boolean searchStatus = exhibitManagement.searchExhibits(criteriaChoice, searchValue);
        if (!searchStatus) {
            System.out.println("No matching Exhibits");
        }
    }

    private  void popArtifacts() {
        this.artifactManagement= new ArtifactManagement(DefaultData.populateArtifacts());
    }

    private  void popExhibits() {
       this.exhibitManagement= new ExhibitManagement(DefaultData.populateExhibits());
    }

    private  void popPlan() {
        try {
            this.exhibitionPlan = new ExhibitionPlan(DefaultData.populateExhibitionPlan(), exhibitManagement);
        } catch (Exception e) {
            System.out.println("Bad Data");
        }
    }

}