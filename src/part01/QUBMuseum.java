package part01;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class QUBMuseum {
    private static ArrayList<Artifact> artifacts = new ArrayList<Artifact>();
    private static ArrayList<Exhibit> exhibits;
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
                ArtifactManagement.manageArtifacts(artifacts);
                break;
            case 2:
                manageExhibits();
                break;
            case 3:
                manageAnnualPlan();
                break;
            case 4:

                quit = true;
        }
        return quit;
    }

    

    private static void manageExhibits() {
        System.out.println("Manage Exhibits");
        // SubMenu menu = new SubMenu("Exhibit");
        // while (true) {
        //     int choice = menu.getUserChoice();
        //     boolean quit = processExhibitMenuChoice(choice);
        //     if (quit) {
        //         break;
        //     }

        // }
    }

    // private static boolean processExhibitMenuChoice(int choice) {
    //     boolean quit = false;
    //     Menu exhibitMenu = exhibitsMenu();
    //     System.out.println();
    //     switch (choice) {
    //         case 1:
    //             addExhibit();
    //             break;
    //         case 2:
    //             while (true) {
    //                 System.out.print("View ");
    //                 int exhibitChoice = exhibitMenu.getUserChoice();
    //                 boolean quitViewing = viewExhibit(exhibitChoice);
    //                 if (quitViewing) {
    //                     break;
    //                 }

    //             }
    //             break;
    //         case 3:
    //             while (true) {
    //                 System.out.print("Update ");
    //                 int exhibitChoice = exhibitMenu.getUserChoice();
    //                 boolean quitUpdating = updateExhibit(exhibitChoice);
    //                 exhibitMenu = exhibitsMenu();
    //                 if (quitUpdating) {
    //                     break;
    //                 }

    //             }
    //             break;
    //         case 4:
    //             while (true) {
    //                 System.out.print("Delete ");
    //                 int exhibitChoice = exhibitMenu.getUserChoice();
    //                 boolean quitDeleting = deleteExhibit(exhibitChoice);
    //                 exhibitMenu = exhibitsMenu();
    //                 if (quitDeleting) {
    //                     break;
    //                 }

    //             }
    //             break;
    //         case 5:
    //             quit = true;
    //     }
    //     return quit;
    // }

    // private static void addExhibit() {
    //     System.out.println("Add Exhibit");
    //     System.out.print("Enter Exhibit Name:");
    //     String name = input.nextLine();
    //     System.out.print("Select What Artifacts to Include:");
    //     Menu artifactMenu = artifactsMenu();
    //     ArrayList<Integer> exhibitArtifacts = new ArrayList<Integer>();
    //     while (true) {
    //         int artifactChoice = artifactMenu.getUserChoice();
    //         exhibitArtifacts.add(artifactChoice);
    //         boolean quitAdding = artifactChoice - 1 == artifacts.size();
    //         if (quitAdding) {
    //             break;
    //         }
    //     }

    // }

    // private static boolean viewExhibit(int choice) {

    //     if (choice - 1 == exhibits.size()) {
    //         return true;
    //     }
    //     System.out.println(exhibits.get(choice - 1));
    //     System.out.println();
    //     return false;
    // }

    // private static boolean updateExhibit(int choice) {
    //     if (choice - 1 == artifacts.size()) {
    //         return true;
    //     }

    //     return false;
    // }

    // private static boolean deleteExhibit(int choice) {
    //     if (choice - 1 == artifacts.size()) {
    //         return true;
    //     }
    //     artifacts.remove(choice - 1);
    //     return false;
    // }

    // private static Menu exhibitsMenu() {
    //     String[] artifactNames = exhibitsToArray(true);
    //     String[] quit = { "Quit" };
    //     String[] artifactOptions = concat(artifactNames, quit);
    //     Menu artifactMenu = new Menu("Artifacts", artifactOptions);
    //     return artifactMenu;
    // }

    // private static String[] exhibitsToArray(boolean ofNames) {
    //     String[] exhibitArray = new String[exhibits.size()];
    //     for (int i = 0; i < exhibitArray.length; i++) {
    //         exhibitArray[i] = exhibits.get(i).getName();
    //     }
    //     return exhibitArray;
    // }

    private static void manageAnnualPlan() {
        System.out.println("Manage Annual plan");
    }

    
}
