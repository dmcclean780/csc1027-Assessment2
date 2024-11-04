package part01;

import java.util.ArrayList;
import java.util.Scanner;

public class ExhibitManagement {

    private static Scanner input = new Scanner(System.in);

    public static void manageExhibits(ArrayList<Exhibit> exhibits, ArrayList<Artifact> artifacts) {
        System.out.println("Manage Exhibits");
        SubMenu menu = new SubMenu("Exhibit");
        while (true) {
            int choice = menu.getUserChoice();
            boolean quit = processExhibitMenuChoice(choice, exhibits, artifacts);
            if (quit) {
                break;
            }

        }
    }

    private static boolean processExhibitMenuChoice(int choice, ArrayList<Exhibit> exhibits,
            ArrayList<Artifact> artifacts) {
        boolean quit = false;
        Exhibit[] exhibitArray = exhibitsToArray(exhibits);
        exhibitArray = sort(exhibitArray);
        Menu exhibitMenu = exhibitsMenu(exhibitArray);
        System.out.println();
        switch (choice) {
            case 1:
                addExhibit(exhibits, artifacts);
                break;
            case 2:
                while (true) {
                    System.out.print("View ");
                    int exhibitChoice = exhibitMenu.getUserChoice();
                    boolean quitViewing = viewExhibit(exhibitChoice, exhibits, artifacts);
                    if (quitViewing) {
                        break;
                    }

                }
                break;
            case 3:
                while (true) {
                    System.out.print("Update ");
                    int exhibitChoice = exhibitMenu.getUserChoice();
                    boolean quitUpdating = updateExhibit(exhibitChoice, exhibits);
                    exhibitArray = exhibitsToArray(exhibits);
                    exhibitArray = sort(exhibitArray);
                    exhibitMenu = exhibitsMenu(exhibitArray);
                    if (quitUpdating) {
                        break;
                    }

                }
                break;
            case 4:
                while (true) {
                    System.out.print("Delete ");
                    int exhibitChoice = exhibitMenu.getUserChoice();
                    boolean quitDeleting = deleteExhibit(exhibitChoice, exhibits);
                    exhibitArray = exhibitsToArray(exhibits);
                    exhibitArray = sort(exhibitArray);
                    exhibitMenu = exhibitsMenu(exhibitArray);
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

    private static void addExhibit(ArrayList<Exhibit> exhibits, ArrayList<Artifact> artifacts) {
        System.out.println("Add Exhibit");
        System.out.print("Enter Exhibit Name:");
        String name = input.nextLine();

        System.out.print("Select What Artifacts to Include:");
        Artifact[] artifactArray = ArtifactManagement.artifactsToArray(artifacts);
        artifactArray = ArtifactManagement.sort(artifactArray);
        Menu artifactMenu = ArtifactManagement.artifactsMenu(artifactArray);

        ArrayList<Integer> exhibitArtifacts = new ArrayList<Integer>();
        while (true) {
            int artifactChoice = artifactMenu.getUserChoice();
            boolean quitAdding = artifactChoice - 1 == artifacts.size();
            if (quitAdding) {
                break;
            }
            if(!Utils.contains(artifactArray[artifactChoice - 1].getId(), exhibitArtifacts)){
                exhibitArtifacts.add(artifactArray[artifactChoice - 1].getId());
            }
            else{
                System.out.println("Artifact Already in Exhibit");
            }
            

        }

        ArrayList<String> exhibitRoute = new ArrayList<String>();
        System.out.println("Enter text for the sign on the route at each artifact");
        for (int i = 0; i < exhibitArtifacts.size(); i++) {
            System.out.print("Artifact " + (i+1) + ": ");
            String sign = input.nextLine();
            exhibitRoute.add(sign);
        }
        try {
            System.out.println(name);
            Exhibit exhibit = new Exhibit(name, exhibitArtifacts, exhibitRoute);
            exhibits.add(exhibit);
            System.out.println();
        } catch (Exception e) {
            System.out.println("Bad Data");
        }

    }

    private static boolean viewExhibit(int choice, ArrayList<Exhibit> exhibits, ArrayList<Artifact> artifacts) {

        if (choice - 1 == exhibits.size()) {
            return true;
        }
        Exhibit exhibit = exhibits.get(choice-1);

        Artifact[] artifactArray=exhibit.getArtifacts(artifacts);

        ArrayList<String> route = exhibit.getRoute();
        String[] routeArray = routeToArray(route);

        String exhibitString = exhibit.toString() + "\nArtifacts for the Exhibit\n"  ;
        for(int i=0; i<artifactArray.length; i++){
            exhibitString+=artifactArray[i].getName()+"\n";
        }
        exhibitString+="\nRoute:\nSteps:\tSigns\n";
        for(int i=0; i<artifactArray.length; i++){
            exhibitString+= (i+1)+". "+artifactArray[i].getName()+"\t"+routeArray[i]+"\n";
        }
        System.out.println(exhibitString);
        System.out.println();
        return false;
    }

    private static boolean updateExhibit(int choice, ArrayList<Exhibit> exhibits) {
        if (choice - 1 == exhibits.size()) {
            return true;
        }

        return false;
    }

    private static boolean deleteExhibit(int choice, ArrayList<Exhibit> exhibits) {
        if (choice - 1 == exhibits.size()) {
            return true;
        }
        exhibits.remove(choice - 1);
        return false;
    }

    private static Menu exhibitsMenu(Exhibit[] exhibitArray) {
        String[] exhibitNames = exhibitArrayToNameArray(exhibitArray);
        String[] quit = { "Quit" };
        String[] exhibitOptions = Utils.concat(exhibitNames, quit);
        Menu artifactMenu = new Menu("Artifacts", exhibitOptions);
        return artifactMenu;
    }

    private static Exhibit[] exhibitsToArray(ArrayList<Exhibit> exhibits) {
        Exhibit[] exhibitArray = new Exhibit[exhibits.size()];
        for (int i = 0; i < exhibitArray.length; i++) {
            exhibitArray[i] = exhibits.get(i);
        }
        return exhibitArray;
    }

    private static String[] exhibitArrayToNameArray(Exhibit[] exhibitArray) {
        String[] nameArray = new String[exhibitArray.length];
        for (int i = 0; i < exhibitArray.length; i++) {
            nameArray[i] = exhibitArray[i].getName();
        }
        return nameArray;
    }

    private static Exhibit[] sort(Exhibit[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j].getName().compareTo(array[j + 1].getName()) > 0) {
                    Exhibit temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }

    private static String[] routeToArray(ArrayList<String> route){
        String[] routeArray = new String[route.size()];
        for (int i = 0; i < routeArray.length; i++) {
            routeArray[i] = route.get(i);
        }
        return routeArray;
    }
}
