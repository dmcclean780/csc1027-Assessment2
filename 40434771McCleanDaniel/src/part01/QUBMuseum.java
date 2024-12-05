package part01;

import java.util.ArrayList;
import java.util.Scanner;

public class QUBMuseum {
    private ArtifactManagement artifactManagement; // Manages all direct interactions with artifacts from a museum
                                                   // object
    private ExhibitManagement exhibitManagement; // Manages all direct interactions with exhibits from a museum object
    private ExhibitionPlan exhibitionPlan; // Stores the annual plan for the museum

    private static Scanner input = new Scanner(System.in); // Input from the standerd input

    private String generalMenuTitle; // Museum Title/Name
    private static final String[] generalMenuOptions = { "Manage Artifacts", "Manage Exhibits", "Mangage Annual Plan",
            "Quit" }; // Options on the main museum menu

    /**
     * Creates a new muesuem object and populates all the attributes
     * Then calls the runMuseumApplication method to start the application
     * 
     * @param args
     */
    public static void main(String[] args) {
        QUBMuseum museum = new QUBMuseum();
        museum.generalMenuTitle = "QUB Museum";
        museum.popArtifacts();
        museum.popExhibits();
        museum.popPlan();
        museum.runMuseumApplication();
    }

    /**
     * Handles the general menu and getting user input from it
     */
    private void runMuseumApplication() {
        Menu generalMenu = new Menu(generalMenuTitle, generalMenuOptions);
        while (true) { // Continue until quit chosen
            int choice = generalMenu.getUserChoice();
            boolean quit = processGeneralMenuChoice(choice);
            if (quit) {
                break;
            }

        }
        System.out.println("All done - Goodbye!");
    }

    /**
     * Calls a method based on what option from the general menu
     * was chosen
     * 
     * @param choice from general menu
     * @return
     */
    private boolean processGeneralMenuChoice(int choice) {
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

    /**
     * Handles getting input on the Artifact Sub menu
     */
    public void manageArtifacts() {
        System.out.println("Manage Artifacts");
        SubMenu menu = new SubMenu("Artifact");
        while (true) { // Continue until quit chosen
            int choice = menu.getUserChoice();
            boolean quit = processArtifactMenuChoice(choice);
            if (quit) {
                break;
            }

        }
    }

    /**
     * Calls a method based on what option from the artifact SubMenu
     * was chosen
     * 
     * @param choice from artifact SubMenu
     * @return was quit chosen
     */
    private boolean processArtifactMenuChoice(int choice) {
        boolean quit = false;
        artifactManagement.refreshArtifactArray();
        Menu artifactMenu = artifactManagement.getArtifactMenu();
        System.out.println();
        switch (choice) {
            case 1: // Add Artifact
                addArtifact();
                break;
            case 2: // View Artifact
                while (true) { // Continue until quit chosen
                    System.out.print("View ");
                    int artifactChoice = artifactMenu.getUserChoice();
                    // This controls searching and regenerating
                    // the artifacts menu afterwards
                    if (artifactChoice - 1 == artifactManagement.getArtifactArrayLength()) {
                        searchArtifacts();
                        artifactMenu = artifactManagement.getArtifactMenu();
                        continue;
                    }
                    // This controls clearing a search by refreshing ArtifactArray
                    // and the regenerating the artifacts menu
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
            case 3: // Update Artifact
                while (true) { // Continue until quit chosen
                    System.out.print("Update ");
                    int artifactChoice = artifactMenu.getUserChoice();
                    // This controls searching and regenerating
                    // the artifacts menu afterwards
                    if (artifactChoice - 1 == artifactManagement.getArtifactArrayLength()) {
                        searchArtifacts();
                        artifactMenu = artifactManagement.getArtifactMenu();
                        continue;
                    }
                    // This controls clearing a search by refreshing ArtifactArray
                    // and the regenerating the artifacts menu
                    if (artifactChoice - 2 == artifactManagement.getArtifactArrayLength()) {
                        artifactManagement.refreshArtifactArray();
                        artifactMenu = artifactManagement.getArtifactMenu();
                        continue;
                    }
                    boolean quitUpdating = updateArtifact(artifactChoice);
                    artifactManagement.refreshArtifactArray(); // Must be refreshed after update as name may have
                                                               // changed
                    artifactMenu = artifactManagement.getArtifactMenu();
                    if (quitUpdating) {
                        break;
                    }
                }
                break;
            case 4: // Delete Artifact
                while (true) { // Continue until quit chosen
                    System.out.print("Delete ");
                    int artifactChoice = artifactMenu.getUserChoice();
                    // This controls searching and regenerating
                    // the artifacts menu afterwards
                    if (artifactChoice - 1 == artifactManagement.getArtifactArrayLength()) {
                        searchArtifacts();
                        artifactMenu = artifactManagement.getArtifactMenu();
                        continue;
                    }
                    // This controls clearing a search by refreshing ArtifactArray
                    // and the regenerating the artifacts menu
                    if (artifactChoice - 2 == artifactManagement.getArtifactArrayLength()) {
                        artifactManagement.refreshArtifactArray();
                        artifactMenu = artifactManagement.getArtifactMenu();
                        continue;
                    }
                    boolean quitDeleting = deleteArtifact(artifactChoice);
                    artifactManagement.refreshArtifactArray(); // Must be refreshed after delete as artifacts have
                                                               // changed
                    artifactMenu = artifactManagement.getArtifactMenu();
                    if (quitDeleting) {
                        break;
                    }

                }
                break;
            case 5: // Quit Artifact Management
                quit = true;
        }
        return quit;
    }

    /**
     * Controls getting input from user
     * to call artifactManagement.AddArtifact
     */
    private void addArtifact() {
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
        while (true) { // Keep asking for input until valid input is recieved
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

    /**
     * View the artifact selected
     * 
     * @param choice artifact chosen
     * @return was the choice Quit
     */
    private boolean viewArtifact(int choice) {

        // Checks if the User chose quit
        if (choice - 3 == artifactManagement.getArtifactArrayLength()) {
            return true;
        }

        System.out.println(artifactManagement.getArtifactString(choice - 1));
        System.out.println();
        return false;
    }

    /**
     * Controls recieving user input to call
     * artifactManagement.updateArtifact
     * 
     * @param choice artifact to update
     * @return user chose to quit?
     */
    private boolean updateArtifact(int choice) {
        // Checks if the User chose quit
        if (choice - 3 == artifactManagement.getArtifactArrayLength()) {
            return true;
        }

        System.out.println("Enter new data or press RETURN to leave unchanged");
        System.out.print("Enter Artifact Name:");
        String name = input.nextLine();

        System.out.print("Enter Artifact Type:");
        String type = input.nextLine();

        while (true) { // Keep asking for input until a valid update is made

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

    /**
     * Removes artifact from artifactManagement and all referemces
     * to it from exhibitManagement
     * 
     * @param choice artifact to remove
     * @return user chose to quit?
     */
    private boolean deleteArtifact(int choice) {
        // Checks if the User chose quit
        if (choice - 3 == artifactManagement.getArtifactArrayLength()) {
            return true;
        }
        int id;
        try {
            id = artifactManagement.getArtifactID(choice - 1);
            exhibitManagement.removeArtifactsWithID(id);
            artifactManagement.removeArtifact(id);
        } catch (Exception e) {
            System.out.println("Artifact Choice Out Of Range");
        }
        return false;
    }

    /**
     * Controls getting user input on the
     * Exhibit Management Sub Menu
     */
    public void manageExhibits() {
        System.out.println("Manage Exhibits");
        SubMenu menu = new SubMenu("Exhibit");
        while (true) { // Continue until quit chosen
            int choice = menu.getUserChoice();
            boolean quit = processExhibitMenuChoice(choice);
            if (quit) {
                break;
            }

        }
    }

    /**
     * Decides what method to call based upon the choice from the
     * Exhibit Management Sub Menu
     * 
     * @param choice chosen method
     * @return was quit chosen
     */
    private boolean processExhibitMenuChoice(int choice) {
        boolean quit = false;
        exhibitManagement.refreshExhibitArray();
        Menu exhibitMenu = exhibitManagement.getExhibitMenu();
        System.out.println();
        switch (choice) {
            case 1: // Add new exhibit
                addExhibit();
                break;
            case 2: // View exhibit
                while (true) { // Continue until quit chosen
                    System.out.print("View ");
                    int exhibitChoice = exhibitMenu.getUserChoice();
                    // Searches Exhibit and updates Menu
                    if (exhibitChoice - 1 == exhibitManagement.getExhibitArrayLength()) {
                        searchExhibits();
                        exhibitMenu = exhibitManagement.getExhibitMenu();
                        continue;
                    }
                    // Clears a Search and updates Menu
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
            case 3: // Update exhibit
                while (true) { // Continue until quit chosen
                    System.out.print("Update ");
                    int exhibitChoice = exhibitMenu.getUserChoice();
                    // Searches Exhibit and updates Menu
                    if (exhibitChoice - 1 == exhibitManagement.getExhibitArrayLength()) {
                        searchExhibits();
                        exhibitMenu = exhibitManagement.getExhibitMenu();
                        continue;
                    }
                    // Clears a Search and updates Menu
                    if (exhibitChoice - 2 == exhibitManagement.getExhibitArrayLength()) {
                        exhibitManagement.refreshExhibitArray();
                        exhibitMenu = exhibitManagement.getExhibitMenu();
                        continue;
                    }
                    boolean quitUpdating = updateExhibit(exhibitChoice);
                    exhibitManagement.refreshExhibitArray(); // Refresh after update as exhibits has changed
                    exhibitMenu = exhibitManagement.getExhibitMenu();
                    if (quitUpdating) {
                        break;
                    }
                }
                break;
            case 4:
                while (true) { // Continue until quit chosen
                    System.out.print("Delete ");
                    int exhibitChoice = exhibitMenu.getUserChoice();
                    // Searches Exhibit and updates Menu
                    if (exhibitChoice - 1 == exhibitManagement.getExhibitArrayLength()) {
                        searchExhibits();
                        exhibitMenu = exhibitManagement.getExhibitMenu();
                        continue;
                    }
                    // Clears a Search and updates Menu
                    if (exhibitChoice - 2 == exhibitManagement.getExhibitArrayLength()) {
                        exhibitManagement.refreshExhibitArray();
                        exhibitMenu = exhibitManagement.getExhibitMenu();
                        continue;
                    }
                    boolean quitDeleting = deleteExhibit(exhibitChoice);
                    exhibitManagement.refreshExhibitArray(); // Refresh after delete as exhibits has changed
                    exhibitMenu = exhibitManagement.getExhibitMenu();
                    if (quitDeleting) {
                        break;
                    }
                }
                break;
            case 5: // Quit Exhibit Management
                quit = true;
        }
        return quit;
    }

    /**
     * Controls taking user Input to call
     * exhibitManagement.addExhibit
     */
    private void addExhibit() {
        System.out.println("Add Exhibit");

        String name;
        while (true) { // Continue until Valid name
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
        while (true) { // Continue until quit
            int artifactChoice = artifactMenu.getUserChoice();
            // Search artifacts
            if (artifactChoice - 1 == artifactManagement.getArtifactArrayLength()) {
                searchArtifacts();
                artifactMenu = artifactManagement.getArtifactMenu();
                continue;
            }
            // Clear a Search
            if (artifactChoice - 2 == artifactManagement.getArtifactArrayLength()) {
                artifactManagement.refreshArtifactArray();
                artifactMenu = artifactManagement.getArtifactMenu();
                continue;
            }
            // Quit adding artifacts
            if (artifactChoice - 3 == artifactManagement.getArtifactArrayLength()) {
                break;
            }
            try {
                // Check if artifact is already included
                if (!Utils.contains(artifactManagement.getArtifactID(artifactChoice - 1), exhibitArtifacts)) {
                    exhibitArtifacts.add(artifactManagement.getArtifactArray()[artifactChoice - 1].getID()); // Add ID
                                                                                                             // if not
                } else {
                    System.out.println("Artifact Already in Exhibit");
                }
            } catch (Exception e) {
                System.out.println("Artifact Choice Out Of Range");
            }

        }

        // Enter Signs for Route
        ArrayList<String> exhibitRoute = new ArrayList<String>();
        System.out.println("Enter text for the sign on the route at each artifact");
        for (int i = 0; i < exhibitArtifacts.size(); i++) {
            System.out.print("Artifact " + (i + 1) + ": ");
            String sign = input.nextLine();
            exhibitRoute.add(sign);
        }

        boolean valid = exhibitManagement.addExhibit(name, exhibitArtifacts, exhibitRoute);
        if (!valid) { // If erroneus input was somehow entered
            System.out.println("Bad Data");
        }
        System.out.println();

    }

    /**
     * View an exhibit
     * 
     * @param choice exhibit to view
     * @return was choice to quit
     */
    private boolean viewExhibit(int choice) {
        // Check if quit was chosen
        if (choice - 3 == exhibitManagement.getExhibitArrayLength()) {
            return true;
        }
        System.out.println(exhibitManagement.getExhibitString(choice - 1, artifactManagement));
        System.out.println();
        return false;
    }

    /**
     * Update an exhibit
     * 
     * @param choice exhibit to update
     * @return was choice to quit
     */
    private boolean updateExhibit(int choice) {
        // Check if quit was chosen
        if (choice - 3 == exhibitManagement.getExhibitArrayLength()) {
            return true;
        }

        System.out.println("Update Exhibit");
        System.out.println("Enter new data or press RETURN to leave unchanged");

        String name;
        while (true) { // Ask until valid name is entered
            input.nextLine();
            System.out.print("Enter Exhibit Name:");
            name = input.nextLine();
            if (name.length() < 40) {
                break;
            }
            System.out.println("Name must be less than 40 Characters");
        }
        String[] artifactModifications = { "Add", "Remove", "Update", "End" };
        Menu artifactActionMenu = new Menu("Change Exhibit Artifacts", artifactModifications);
        while (true) { // continue until quit
            int artifactAction = artifactActionMenu.getUserChoice();
            if (artifactAction == 4) { // Quit
                break;
            }
            if (artifactAction == 3) { // Modify an existing artifact
                updateExhibitArtifacts(choice, name);
            }
            if (artifactAction == 2) { // remove existing artifact
                removeExhibitArtifacts(choice, name);
            }
            if (artifactAction == 1) { // add a new artifact to the end
                addExhibitArtifact(choice, name);
            }
        }

        return false;
    }

    /**
     * Add a new artifact to the end of an exhibit
     * 
     * @param choice exhibit to add to
     * @param name   new name of exhibit
     */
    private void addExhibitArtifact(int choice, String name) {

        // get current route and artifacts
        ArrayList<String> route = exhibitManagement.getExhibitRoute(choice - 1);
        ArrayList<Integer> exhibitArtifacts = exhibitManagement.getExhibitArtifacts(choice - 1);

        // Get Menu of all artifacts
        artifactManagement.refreshArtifactArray();
        Menu artifactMenu = artifactManagement.getArtifactMenu();
        boolean changed = false;

        while (true) { // continue until quit or valid artifact
            System.out.println("Select new Artifact");

            int artifactChoice = artifactMenu.getUserChoice();
            // Search Artifacts
            if (artifactChoice - 1 == artifactManagement.getArtifactArrayLength()) {
                searchArtifacts();
                artifactMenu = artifactManagement.getArtifactMenu();
                continue;
            }
            // Clear Search
            if (artifactChoice - 2 == artifactManagement.getArtifactArrayLength()) {
                artifactManagement.refreshArtifactArray();
                artifactMenu = artifactManagement.getArtifactMenu();
                continue;
            }
            // Quit
            if (artifactChoice - 3 == artifactManagement.getArtifactArrayLength()) {
                break;
            }
            try {
                // Check if artifact is already in exhibit
                if (!Utils.contains(artifactManagement.getArtifactID(artifactChoice - 1), exhibitArtifacts)) {
                    exhibitArtifacts.add(artifactManagement.getArtifactArray()[artifactChoice - 1].getID());
                    changed = true;
                    break;
                } else {
                    System.out.println("Artifact Already in Exhibit");
                }
            } catch (Exception e) {
                System.out.println("Artifact Choice Out Of Range");
            }
        }
        if (changed) { // If new Artifact Added, Enter Sign
            System.out.print("Enter new Sign: ");
            String sign = input.nextLine();
            route.add(sign);
        }
        boolean validData = exhibitManagement.updateExhibit(choice - 1, name, exhibitArtifacts, route); // Update the
                                                                                                        // exhibit
        if (!validData) {
            System.out.println("Bad Data");
        }
    }

    /**
     * Remove Artifacts from an exhibit
     * 
     * @param choice exhibit to update
     * @param name   new exhibit name
     */
    private void removeExhibitArtifacts(int choice, String name) {

        while (true) { // Continue until Quit

            // Get exhibit artifacts and Route
            ArrayList<Integer> exhibitArtifacts = exhibitManagement.getExhibitArtifacts(choice - 1);
            ArrayList<String> route = exhibitManagement.getExhibitRoute(choice - 1);

            // Create Menu of exhibit Artifacts
            Menu artifactMenu = exhibitManagement.getExhibitArtifactMenu(choice - 1, artifactManagement);
            int artifactCount = exhibitManagement.getArtifactNumber(choice - 1);

            int artifactChoice = artifactMenu.getUserChoice();

            // Check if Quit was chosen
            if (artifactChoice - 1 == artifactCount) {
                break;
            }

            // Remove Chosen Artifact and its route
            exhibitArtifacts.remove(artifactChoice - 1);
            route.remove(artifactChoice - 1);

            boolean validData = exhibitManagement.updateExhibit(choice - 1, name, exhibitArtifacts, route);
            if (!validData) {
                System.out.println("Bad Data");
            }
        }

    }

    /**
     * Update exiting exhibit artifacts
     * 
     * @param choice // exhibit to update
     * @param name   // new exhibit name
     */
    private void updateExhibitArtifacts(int choice, String name) {

        while (true) { // Continue until Quit

            // Get Exhibit Artifacts and Route
            ArrayList<Integer> exhibitArtifacts = exhibitManagement.getExhibitArtifacts(choice - 1);
            ArrayList<String> route = exhibitManagement.getExhibitRoute(choice - 1);

            // Get Menu of exicting artifacts
            Menu artifactMenu = exhibitManagement.getExhibitArtifactMenu(choice - 1, artifactManagement);
            int artifactCount = exhibitManagement.getArtifactNumber(choice - 1);

            int artifactChoice = artifactMenu.getUserChoice(); // Select artifact to change

            // Check if Quit was Chosen
            if (artifactChoice - 1 == artifactCount) {
                break;
            }
            // Get Menu of all artifacts
            artifactManagement.refreshArtifactArray();
            Menu allArtifactMenu = artifactManagement.getArtifactMenu();

            boolean changed = false;
            while (true) { // Continue unitl Valid artifact or Quit

                System.out.println("Select new Artifact");
                int newArtifactChoice = allArtifactMenu.getUserChoice();

                // Search all artifacts
                if (newArtifactChoice - 1 == artifactManagement.getArtifactArrayLength()) {
                    searchArtifacts();
                    allArtifactMenu = artifactManagement.getArtifactMenu();
                    continue;
                }
                // Clear search
                if (newArtifactChoice - 2 == artifactManagement.getArtifactArrayLength()) {
                    artifactManagement.refreshArtifactArray();
                    allArtifactMenu = artifactManagement.getArtifactMenu();
                    continue;
                }
                // Check if Quit
                if (newArtifactChoice - 3 == artifactManagement.getArtifactArrayLength()) {
                    break;
                }
                try {
                    // Check if artifact already in exhibit
                    if (!Utils.contains(artifactManagement.getArtifactID(newArtifactChoice - 1), exhibitArtifacts)) {
                        // Replace old artifact with new one
                        exhibitArtifacts.remove(artifactChoice - 1);
                        exhibitArtifacts.add(artifactChoice - 1,
                                artifactManagement.getArtifactArray()[newArtifactChoice - 1].getID());
                        changed = true;
                        break;
                    } else {
                        System.out.println("Artifact Already in Exhibit");
                    }
                } catch (Exception e) {
                    System.out.println("Artifact Choice Out Of Range");
                }
            }

            // Enter Sign for the new Artifact
            if (changed) {
                System.out.print("Enter new Sign: ");
                String sign = input.nextLine();
                route.remove(artifactChoice - 1);
                route.add(artifactChoice - 1, sign);
            }

            boolean validData = exhibitManagement.updateExhibit(choice - 1, name, exhibitArtifacts, route);
            if (!validData) {
                System.out.println("Bad Data");
            }
        }
    }

    /**
     * Delete an exhibit from exhibits
     * 
     * @param choice chosen exhibit
     * @return was quit chosen
     */
    private boolean deleteExhibit(int choice) {
        // Check if Quit was chosen
        if (choice - 3 == exhibitManagement.getExhibitArrayLength()) {
            return true;
        }
        int exhibitID = exhibitManagement.getExhibitID(choice - 1);
        exhibitManagement.removeExhibit(exhibitID);
        return false;
    }

    /**
     * Control taking input on Annual Plan Management Menu
     * and selecting appropriate method
     * 
     * @return updated exhibition plan
     */
    private ExhibitionPlan manageAnnualPlan() {
        // Create Annual Plan Mangement menu
        String[] annualPlanOptions = { "Create", "View", "Update", "Quit" };
        Menu annualPlanMenu = new Menu("Manage Annual Plan", annualPlanOptions);

        boolean quit = false;
        while (!quit) { // Continue until Quit is chosen
            int choice = annualPlanMenu.getUserChoice();
            switch (choice) {
                case 1: // Create New Annual Plan
                    ExhibitionPlan createdExhibitionPlan = createAnnualPlan();
                    if (createdExhibitionPlan != null) {
                        exhibitionPlan = createdExhibitionPlan;
                    }
                    break;
                case 2: // View Existing Plan
                    viewAnnualPlan();
                    break;
                case 3: // Update Existing Plan
                    ExhibitionPlan updatedExhibitionPlan = updateAnnualPlan();
                    if (updatedExhibitionPlan != null) {
                        exhibitionPlan = updatedExhibitionPlan;
                    }
                    break;
                case 4: // Quit
                    quit = true;
                    break;
                default:
                    break;
            }
        }
        return exhibitionPlan;
    }

    /**
     * Create a new Annual Plan
     * 
     * @return new Annual Plan
     */
    public ExhibitionPlan createAnnualPlan() {
        int noOfHalls;
        int[][] exhibitionExhibits;
        while (true) { // Continue until valid input
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
        while (true) { // Continue until valid plan created

            // Get Menu of all exhibits
            exhibitManagement.refreshExhibitArray();
            Menu exhibitMenu = exhibitManagement.getExhibitMenu();

            // Select Exhibit for every month
            for (int i = 0; i < exhibitionExhibits.length; i++) {
                System.out.println("Select Exhibits for " + Months.get(i));
                // Select Exhibit for every hall in this month
                for (int j = 0; j < exhibitionExhibits[i].length; j++) {

                    int exhibitChoice = exhibitMenu.getUserChoice();
                    // Search exhibits
                    if (exhibitChoice - 1 == exhibitManagement.getExhibitArrayLength()) {
                        searchExhibits();
                        exhibitMenu = exhibitManagement.getExhibitMenu();
                        j--;
                        continue;
                    }
                    // Clear search
                    if (exhibitChoice - 2 == exhibitManagement.getExhibitArrayLength()) {
                        exhibitManagement.refreshExhibitArray();
                        exhibitMenu = exhibitManagement.getExhibitMenu();
                        j--;
                        continue;
                    }
                    // Quit so no exhibit in this slot
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

    /**
     * View existing annual plan
     */
    private void viewAnnualPlan() {

        // Create View Options Menu
        String[] viewOptions = { "Entire Plan", "Choose Month", "Choose Hall", "Quit" };
        Menu viewMenu = new Menu("Select what to View", viewOptions);
        boolean quit = false;

        // Continue until Quit
        while (!quit) {
            int choice = viewMenu.getUserChoice();
            switch (choice) {
                case 1: // View Entire Plan
                    System.out.println(exhibitionPlan.getPlanString(exhibitManagement));
                    break;

                case 2: // View a single month accross all halls

                    // Create Menu of all months
                    Menu monthMenu = new Menu("Choose a month to view", Months.toArray());
                    int month = monthMenu.getUserChoice() - 1;

                    System.out.println(exhibitionPlan.getMonthPlanString(exhibitManagement, month));
                    break;
                case 3: // View a single hall accross all months

                    // Create Menu of all halls
                    String[] hallOptions = new String[exhibitionPlan.getNumberOfHalls() + 1];
                    for (int i = 0; i < hallOptions.length - 1; i++) {
                        hallOptions[i] = "Exhibit Hall " + i;
                    }
                    hallOptions[hallOptions.length - 1] = "Quit"; // Needs Quit if a plan was created with no halls
                    Menu hallMenu = new Menu("Choose Exhibit Hall", hallOptions);

                    int hall = hallMenu.getUserChoice();
                    if (hall == hallOptions.length) {
                        break;
                    }
                    System.out.println(exhibitionPlan.getHallPlanString(exhibitManagement, hall));
                    break;
                case 4: // Quit Viewing
                    quit = true;
                    break;
                default:
                    break;
            }
        }

    }

    /**
     * Update the annual plan
     * 
     * @return updated plan
     */
    private ExhibitionPlan updateAnnualPlan() {

        // Create Update options menu
        String[] updateOptions = { "Individual Exhibit", "Entire Month", "Entire Hall", "Quit" };
        Menu updateMenu = new Menu("Select Update to Do", updateOptions);

        boolean quit = false;
        // Create Menu of all exhibits
        exhibitManagement.refreshExhibitArray();
        Menu exhibitMenu = exhibitManagement.getExhibitMenu();

        // Create menu of all months
        Menu monthMenu = new Menu("Choose a month to view", Months.toArray());
        int month; // Chosen month

        // Create Menu of all halls
        String[] hallOptions = new String[exhibitionPlan.getNumberOfHalls()];
        for (int i = 0; i < hallOptions.length; i++) {
            hallOptions[i] = "Exhibit Hall " + (i + 1);
        }
        Menu hallMenu = new Menu("Choose Exhibit Hall", hallOptions);
        int hall; // Chosen Hall

        while (!quit) { // Continue until Quit
            int choice = updateMenu.getUserChoice();
            switch (choice) {
                case 1: // Update a spefic exhibit
                    month = monthMenu.getUserChoice() - 1;
                    hall = hallMenu.getUserChoice();
                    exhibitionPlan = changeExhibit(exhibitMenu, month, hall);
                    break;
                case 2: // Update an entire month
                    month = monthMenu.getUserChoice() - 1;
                    exhibitionPlan = changeMonth(exhibitMenu, month);
                    break;
                case 3: // Update an entire hall
                    hall = hallMenu.getUserChoice();
                    exhibitionPlan = changeHall(exhibitMenu, hall);
                    break;
                case 4: // Quit updating
                    quit = true;
                    break;
                default:
                    break;
            }
        }
        return exhibitionPlan;
    }

    /**
     * Change a specific exhibit inn the plan
     * 
     * @param exhibitMenu menu of all exhibits
     * @param month       chosen month
     * @param hall        chosen hall
     * @return updated plan
     */
    private ExhibitionPlan changeExhibit(Menu exhibitMenu, int month, int hall) {

        while (true) { // Continue until Quit or valid update
            int exhibitChoice = exhibitMenu.getUserChoice();
            // Search exhibits
            if (exhibitChoice - 1 == exhibitManagement.getExhibitArrayLength()) {
                searchExhibits();
                exhibitMenu = exhibitManagement.getExhibitMenu();
                continue;
            }
            // Clear search
            if (exhibitChoice - 2 == exhibitManagement.getExhibitArrayLength()) {
                exhibitManagement.refreshExhibitArray();
                exhibitMenu = exhibitManagement.getExhibitMenu();
                continue;
            }
            // Quit
            if (exhibitChoice - 3 == exhibitManagement.getExhibitArrayLength()) {
                break;
            } else {
                try {
                    // Update Exhibit in plan if no artifacts are shared
                    exhibitionPlan.addExhibit(exhibitManagement.getExhibitID(exhibitChoice - 1), month, hall,
                            exhibitManagement);
                    break;
                } catch (Exception e) {
                    System.out.println("Exhibts Share Artifacts");
                }

            }
        }
        return exhibitionPlan;
    }

    /**
     * Change the exhibits in an entire month of the plan
     * 
     * @param exhibitMenu all exhibits menu
     * @param month       chosen month
     * @return updated plan
     */
    private ExhibitionPlan changeMonth(Menu exhibitMenu, int month) {
        for (int i = 0; i < exhibitionPlan.getNumberOfHalls(); i++) { // for every hall
            int exhibitChoice = exhibitMenu.getUserChoice();
            // Search exhibits
            if (exhibitChoice - 1 == exhibitManagement.getExhibitArrayLength()) {
                searchExhibits();
                exhibitMenu = exhibitManagement.getExhibitMenu();
                i--;
                continue;
            }
            // clear search
            if (exhibitChoice - 2 == exhibitManagement.getExhibitArrayLength()) {
                exhibitManagement.refreshExhibitArray();
                exhibitMenu = exhibitManagement.getExhibitMenu();
                i--;
                continue;
            }
            // Quit
            if (exhibitChoice - 3 == exhibitManagement.getExhibitArrayLength()) {
                break;
            } else {
                try {
                    // Update exhibit
                    exhibitionPlan.addExhibit(exhibitManagement.getExhibitID(exhibitChoice - 1), month, i + 1,
                            exhibitManagement);
                } catch (Exception e) {
                    // Try again
                    System.out.println("Exhibits Share Artifacts");
                    i--;
                }

            }
        }
        return exhibitionPlan;
    }

    /**
     * Update exhibits in an entire hall
     * 
     * @param exhibitMenu all exhibits menu
     * @param hall        chosen hall
     * @return updated annual plan
     */
    private ExhibitionPlan changeHall(Menu exhibitMenu, int hall) {
        // For every month
        for (int i = 0; i < Months.values().length; i++) {
            int exhibitChoice = exhibitMenu.getUserChoice();
            // Search exhibits
            if (exhibitChoice - 1 == exhibitManagement.getExhibitArrayLength()) {
                searchExhibits();
                exhibitMenu = exhibitManagement.getExhibitMenu();
                i--;
                continue;
            }
            // clear search
            if (exhibitChoice - 2 == exhibitManagement.getExhibitArrayLength()) {
                exhibitManagement.refreshExhibitArray();
                exhibitMenu = exhibitManagement.getExhibitMenu();
                i--;
                continue;
            }
            // Quit
            if (exhibitChoice - 3 == exhibitManagement.getExhibitArrayLength()) {
                break;
            } else {
                try {
                    // Update plan
                    exhibitionPlan.addExhibit(exhibitManagement.getExhibitID(exhibitChoice - 1), i, hall,
                            exhibitManagement);
                } catch (Exception e) {
                    // failed, Try again
                    System.out.println("Exhibits Share Artifacts");
                    i--;
                }

            }
        }
        return exhibitionPlan;
    }

    /**
     * Get criteria to search artifacts
     */
    private void searchArtifacts() {
        // Create search criteria menu
        String[] searchCriteriaOptions = { "ID", "Name", "Type", "Engagement Time", "Cancel" };
        Menu searchCriteria = new Menu("Select Search Criteria", searchCriteriaOptions);

        int criteriaChoice = searchCriteria.getUserChoice();
        String searchValue = "";

        switch (criteriaChoice) {
            case 1: // Get ID to search
                while (true) { // Continue to valid ID
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

            case 2: // Get Name to search
                System.out.print("Enter Name to search for: ");
                searchValue = input.nextLine();
                break;
            case 3: // Get Type to search
                System.out.print("Enter Type to search for: ");
                searchValue = input.nextLine();
                break;
            case 4: // get time to seacrh
                while (true) { // Continue until valid time
                    System.out.print("Enter Engagement Time to search for: ");
                    try {
                        int time = input.nextInt();
                        if (time < 0) {
                            new Exception();
                        }
                        searchValue = String.valueOf(time);
                        Integer.valueOf(searchValue);
                        break;
                    } catch (Exception e) {
                        input.nextLine();
                        System.out.println("Please enter an Integer");
                    }
                }
                break;
        }
        boolean searchStatus = artifactManagement.searchArtifacts(criteriaChoice, searchValue);
        if (!searchStatus) {
            System.out.println("No matching Artifacts");
        }
    }

    /**
     * Get Criteria to search exhibits
     */
    private void searchExhibits() {
        // Create Search criteria menu
        String[] searchCriteriaOptions = { "ID", "Name", "Cancel" };
        Menu searchCriteria = new Menu("Select Search Criteria", searchCriteriaOptions);

        int criteriaChoice = searchCriteria.getUserChoice();
        String searchValue = "";
        switch (criteriaChoice) {
            case 1: // Get ID to search
                while (true) { // Continue to valid ID
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

            case 2: // Get Name to Search
                System.out.print("Enter Name to search for: ");
                searchValue = input.nextLine();
                break;
        }
        boolean searchStatus = exhibitManagement.searchExhibits(criteriaChoice, searchValue);
        if (!searchStatus) {
            System.out.println("No matching Exhibits");
        }
    }

    /**
     * populate artifactManagement with the default artifacts
     */
    private void popArtifacts() {
        try {
            this.artifactManagement = new ArtifactManagement(DefaultData.populateArtifacts());
        } catch (Exception e) {
            System.err.println("null in artifacts");
        }
    }

    /**
     * populate exhibitManagement with the default exhibits
     */
    private void popExhibits() {
        try {
            this.exhibitManagement = new ExhibitManagement(DefaultData.populateExhibits());
        } catch (Exception e) {
            System.err.println("null in artifacts");
        }
    }

    /**
     * Populate exhibitionPlan with the default exhibits
     */
    private void popPlan() {
        try {
            this.exhibitionPlan = new ExhibitionPlan(DefaultData.populateExhibitionPlan(), exhibitManagement);
        } catch (Exception e) {
            System.out.println("Bad Data");
        }
    }

}