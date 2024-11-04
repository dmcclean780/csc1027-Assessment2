package part01;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ArtifactManagement {
    private static Scanner input = new Scanner(System.in);

    public static void manageArtifacts(ArrayList<Artifact> artifacts) {
        System.out.println();
        SubMenu menu = new SubMenu("Artifact");
        while (true) {
            int choice = menu.getUserChoice();
            boolean quit = processArtifactMenuChoice(choice, artifacts);
            if (quit) {
                break;
            }

        }
    }

    private static boolean processArtifactMenuChoice(int choice, ArrayList<Artifact> artifacts) {
        boolean quit = false;
        Artifact[] artifactArray = artifactsToArray(artifacts);
        artifactArray = sort(artifactArray);
        Menu artifactMenu = artifactsMenu(artifactArray);
        System.out.println();
        switch (choice) {
            case 1:
                addArtifact(artifacts);
                break;
            case 2:
                while (true) {
                    System.out.print("View ");
                    int artifactChoice = artifactMenu.getUserChoice();
                    boolean quitViewing = viewArtifact(artifactChoice, artifactArray);
                    if (quitViewing) {
                        break;
                    }

                }
                break;
            case 3:
                while (true) {
                    System.out.print("Update ");
                    int artifactChoice = artifactMenu.getUserChoice();
                    boolean quitViewing = updateArtifact(artifactChoice, artifactArray, artifacts);
                    artifactArray = artifactsToArray(artifacts);
                    artifactArray = sort(artifactArray);
                    artifactMenu = artifactsMenu(artifactArray);
                    if (quitViewing) {
                        break;
                    }

                }
                break;
            case 4:
                while (true) {
                    System.out.print("Update ");
                    int artifactChoice = artifactMenu.getUserChoice();
                    boolean quitViewing = deleteArtifact(artifactChoice, artifactArray, artifacts);
                    artifactArray = artifactsToArray(artifacts);
                    artifactArray = sort(artifactArray);
                    artifactMenu = artifactsMenu(artifactArray);
                    if (quitViewing) {
                        break;
                    }

                }
                break;
            case 5:
                quit = true;
        }
        return quit;
    }

    private static void addArtifact(ArrayList<Artifact> artifacts) {
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

    private static boolean viewArtifact(int choice, Artifact[] artifactArray) {

        if (choice - 1 == artifactArray.length) {
            return true;
        }
        System.out.println(artifactArray[choice-1]);
        System.out.println();
        return false;
    }

    private static boolean updateArtifact(int choice, Artifact[] artifactArray, ArrayList<Artifact> artifacts) {
        if (choice - 1 == artifactArray.length) {
            return true;
        }
        Artifact a = artifactArray[choice - 1];
        System.out.println("Enter new data or press RETURN to leave unchanged");
        System.out.print("Enter Artifact Name:");
        String name = input.nextLine();
        if (name != "") {
            a.setName(name);
        }
        System.out.print("Enter Artifact Type:");
        String type = input.nextLine();
        if (type != "") {
            a.setType(type);
        }
        while (true) {
            try {
                System.out.print("Enter Artifact Expected Engagement Time:");
                String engagementTimeString = input.nextLine();
                if (engagementTimeString != "") {
                    int engagementTime = Integer.parseInt(engagementTimeString);
                    a.setEngagementTime(engagementTime);
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Please enter an Integer");
            } catch (NumberFormatException e) {
                System.out.println("Please enter an Integer");
            } catch (TimeIsNegativeException e) {
                System.out.println("Enter a Positive Time");
            }
        }
        return false;
    }

    private static boolean deleteArtifact(int choice, Artifact[] artifactArray, ArrayList<Artifact> artifacts) {
        if (choice - 1 == artifactArray.length) {
            return true;
        }
        Artifact a = artifactArray[choice-1];
        artifacts.remove(a);
        return false;
    }

    private static Menu artifactsMenu(Artifact[] artifactArray) {
        String[] artifactNames = artifactArrayToNameArray(artifactArray);
        String[] quit = { "Quit" };
        String[] artifactOptions = Utils.concat(artifactNames, quit);
        Menu artifactMenu = new Menu("Artifacts", artifactOptions);
        return artifactMenu;
    }

    private static Artifact[] artifactsToArray(ArrayList<Artifact> artifacts) {
        Artifact[] artifactArray = new Artifact[artifacts.size()];
        for (int i = 0; i < artifactArray.length; i++) {
            artifactArray[i] = artifacts.get(i);
        }
        return artifactArray;
    }

    private static String[] artifactArrayToNameArray(Artifact[] artifactArray) {
        String[] nameArray = new String[artifactArray.length];
        for (int i = 0; i < artifactArray.length; i++) {
            nameArray[i] = artifactArray[i].getName();
        }
        return nameArray;
    }

    private static Artifact[] sort(Artifact[] array){
        for(int i=0; i<array.length; i++){
            for(int j=0; j<array.length-1; j++){
                if( array[j].getName().compareTo(array[j+1].getName()) > 0){
                    Artifact temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
        return array;
    }
}
