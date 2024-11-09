package part01;

import java.util.ArrayList;
import java.util.Scanner;

public class QUBMuseum {
    private static ArtifactManagement artifactManagement = new ArtifactManagement();
    private static ExhibitManagement exhibitManagement = new ExhibitManagement();
    private static Scanner input = new Scanner(System.in);

    private static final String generalMenuTitle = "QUB Museum";
    private static final String[] generalMenuOptions = { "Manage Artifacts", "Manage Exhibits", "Mangage Annual Plan",
            "Quit" };

    public static void main(String[] args) {
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

    private static boolean processGeneralMenuChoice(int choice) {
        boolean quit = false;
        switch (choice) {
            case 1:
                manageArtifacts(artifactManagement, exhibitManagement);
                break;
            case 2:
                manageExhibits(exhibitManagement, artifactManagement);
                break;
            case 3:
                manageAnnualPlan();
                break;
            case 4:

                quit = true;
        }
        return quit;
    }

    public static void manageArtifacts(ArtifactManagement artifactManagement, ExhibitManagement exhibitManagement) {
        System.out.println("Manage Artifacts");
        SubMenu menu = new SubMenu("Artifact");
        while (true) {
            int choice = menu.getUserChoice();
            boolean quit = processArtifactMenuChoice(choice, artifactManagement, exhibitManagement);
            if (quit) {
                break;
            }

        }
    }

    private static boolean processArtifactMenuChoice(int choice, ArtifactManagement artifactManagement,
            ExhibitManagement exhibitManagement) {
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

                    boolean quitViewing = viewArtifact(artifactChoice, artifactManagement);
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
                    boolean quitUpdating = updateArtifact(artifactChoice, artifactManagement);
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
                    boolean quitDeleting = deleteArtifact(artifactChoice, artifactManagement,
                            exhibitManagement);
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

    private static void addArtifact() {
        System.out.println("Add Artifact");
        System.out.print("Enter Artifact Name:");
        String name = input.nextLine();
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

    private static boolean viewArtifact(int choice, ArtifactManagement artifactManagement) {

        if (choice - 3 == artifactManagement.getArtifactArrayLength()) {
            return true;
        }

        System.out.println(artifactManagement.getArtifactString(choice - 1));
        System.out.println();
        return false;
    }

    private static boolean updateArtifact(int choice, ArtifactManagement artifactManagement) {
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

    private static boolean deleteArtifact(int choice, ArtifactManagement artifactManagement,
            ExhibitManagement exhibitManagement) {
        if (choice - 3 == artifactManagement.getArtifactArrayLength()) {
            return true;
        }
        int id = artifactManagement.getArtifactID(choice - 1);
        exhibitManagement.removeArtifactsWithID(id);
        artifactManagement.removeArtifact(choice - 1);
        return false;
    }

    public static void manageExhibits(ExhibitManagement exhibitManagement, ArtifactManagement artifactManagement) {
        System.out.println("Manage Exhibits");
        SubMenu menu = new SubMenu("Exhibit");
        while (true) {
            int choice = menu.getUserChoice();
            boolean quit = processExhibitMenuChoice(choice, exhibitManagement, artifactManagement);
            if (quit) {
                break;
            }

        }
    }

    private static boolean processExhibitMenuChoice(int choice, ExhibitManagement exhibitManagement,
            ArtifactManagement artifactManagement) {
        boolean quit = false;
        exhibitManagement.refreshExhibitArray();
        Menu exhibitMenu = exhibitManagement.getExhibitMenu();
        System.out.println();
        switch (choice) {
            case 1:
                addExhibit(exhibitManagement, artifactManagement);
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
                    boolean quitViewing = viewExhibit(exhibitChoice, artifactManagement, exhibitManagement);
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
                    boolean quitUpdating = updateExhibit(exhibitChoice, artifactManagement, exhibitManagement);
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
                    boolean quitDeleting = deleteExhibit(exhibitChoice, exhibitManagement);
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

    private static void addExhibit(ExhibitManagement exhibitManagement, ArtifactManagement artifactManagement) {
        System.out.println("Add Exhibit");
        System.out.print("Enter Exhibit Name:");
        String name = input.nextLine();

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
            if (!Utils.contains(artifactManagement.getArtifactArray()[artifactChoice - 1].getId(), exhibitArtifacts)) {
                exhibitArtifacts.add(artifactManagement.getArtifactArray()[artifactChoice - 1].getId());
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

    private static boolean viewExhibit(int choice, ArtifactManagement artifactManagement,
            ExhibitManagement exhibitManagement) {

        if (choice - 3 == exhibitManagement.getExhibitArrayLength()) {
            return true;
        }
        System.out.println(exhibitManagement.getExhibitString(choice - 1, artifactManagement));
        System.out.println();
        return false;
    }

    private static boolean updateExhibit(int choice, ArtifactManagement artifactManagement,
            ExhibitManagement exhibitManagement) {
        if (choice - 3 == exhibitManagement.getExhibitArrayLength()) {
            return true;
        }

        System.out.println("Update Exhibit");
        System.out.println("Enter new data or press RETURN to leave unchanged");

        System.out.print("Enter Exhibit Name:");
        String name = input.nextLine();

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

    private static void addExhibitArtifact(int choice, String name) {
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
            if (!Utils.contains(artifactManagement.getArtifactArray()[artifactChoice - 1].getId(), exhibitArtifacts)) {
                exhibitArtifacts.add(artifactManagement.getArtifactArray()[artifactChoice - 1].getId());
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

    private static void removeExhibitArtifacts(int choice, String name) {
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

    private static void updateExhibitArtifacts(int choice, String name) {
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
                if (!Utils.contains(artifactManagement.getArtifactArray()[newArtifactChoice - 1].getId(),
                        exhibitArtifacts)) {
                    exhibitArtifacts.remove(artifactChoice-1);
                    exhibitArtifacts.add(artifactChoice-1, artifactManagement.getArtifactArray()[newArtifactChoice - 1].getId());
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

    private static boolean deleteExhibit(int choice, ExhibitManagement exhibitManagement) {
        if (choice - 3 == exhibitManagement.getExhibitArrayLength()) {
            return true;
        }
        exhibitManagement.removeExhibit(choice - 1);
        return false;
    }

    private static void manageAnnualPlan() {
        System.out.println("Manage Annual plan");
    }

    private static void searchArtifacts() {
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

    private static void searchExhibits() {
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

}
