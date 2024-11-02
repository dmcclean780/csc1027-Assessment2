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
                manageArtifacts();
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

    private static void manageArtifacts() {
        System.out.println();
        SubMenu menu = new SubMenu("Artifact");
        while (true) {
            int choice = menu.getUserChoice();
            boolean quit = processArtifactMenuChoice(choice);
            if (quit) {
                break;
            }

        }
    }

    private static boolean processArtifactMenuChoice(int choice) {
        boolean quit = false;
        Menu artifactMenu = artifactsMenu();
        System.out.println();
        switch (choice) {
            case 1:
                addArtifact();
                break;
            case 2:
                while (true) {
                    System.out.print("View ");
                    int artifactChoice = artifactMenu.getUserChoice();
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
                    boolean quitViewing = updateArtifact(artifactChoice);
                    artifactMenu=artifactsMenu();
                    if (quitViewing) {
                        break;
                    }

                }
                break;
            case 4:
                deleteArtifact();
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
        while (true) {
            try {
                int engagementTime = input.nextInt();
                Artifact art = new Artifact(name, type, engagementTime);
                artifacts.add(art);
                System.out.println();
                break;
            } catch (InputMismatchException e) {
                input.nextLine();
                System.out.println("Please enter an Integer");
            } catch (TimeIsNegativeException e) {
                input.nextLine();
                System.out.println("Time must be Positive");
            }
        }
        input.nextLine();
    }

    private static boolean viewArtifact(int choice) {
       
        if (choice - 1 == artifacts.size()) {
            return true;
        }
        System.out.println(artifacts.get(choice - 1));
        System.out.println();
        return false;
    }

    private static boolean updateArtifact(int choice) {
        if (choice - 1 == artifacts.size()) {
            return true;
        }
        Artifact a = artifacts.get(choice - 1);
        System.out.println("Enter new data or press RETURN to leave unchanged");
        System.out.print("Enter Artifact Name:");
        String name = input.nextLine();
        if(name!=""){
            a.setName(name);
        }
        System.out.print("Enter Artifact Type:");
        String type = input.nextLine();
        if(type!=""){
            a.setType(type);
        }
        while (true) {
            try {
                System.out.print("Enter Artifact Expected Engagement Time:");
                String engagementTimeString = input.nextLine();
                if(engagementTimeString!=""){
                    int engagementTime=Integer.parseInt(engagementTimeString);
                    a.setEngagementTime(engagementTime);
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Please enter an Integer");
            } catch (NumberFormatException e) {
                System.out.println("Please enter an Integer");
            } catch (TimeIsNegativeException e){
                System.out.println("Enter a Positive Time");
            }
        }
        return false;
    }

    private static void deleteArtifact() {
        System.out.println("delete Artifact");
    }

    private static void manageExhibits() {
        System.out.println("Manage Exhibits");
    }

    private static void manageAnnualPlan() {
        System.out.println("Manage Annual plan");
    }

    private static Menu artifactsMenu() {
        String[] artifactNames = artifactsToArray(true);
        String[] quit = { "Quit" };
        String[] artifactOptions = concat(artifactNames, quit);
        Menu artifactMenu = new Menu("Artifacts", artifactOptions);
        return artifactMenu;
    }

    private static Artifact[] artifactsToArray() {
        Artifact[] artifactArray = new Artifact[artifacts.size()];
        for (int i = 0; i < artifactArray.length; i++) {
            artifactArray[i] = artifacts.get(i);
        }
        return artifactArray;
    }

    private static String[] artifactsToArray(boolean ofNames) {
        String[] artifactArray = new String[artifacts.size()];
        for (int i = 0; i < artifactArray.length; i++) {
            artifactArray[i] = artifacts.get(i).getName();
        }
        return artifactArray;
    }

    private static String[] concat(String[] a, String[] b) {
        String[] c = new String[a.length + b.length];
        for (int i = 0; i < a.length; i++) {
            c[i] = a[i];
        }
        for (int i = a.length; i < b.length + a.length; i++) {
            c[i] = b[i - a.length];
        }
        return c;
    }
}
