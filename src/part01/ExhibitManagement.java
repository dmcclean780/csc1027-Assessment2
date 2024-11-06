package part01;

import java.util.ArrayList;
import java.util.Scanner;

public class ExhibitManagement {

    private static Scanner input = new Scanner(System.in);
    private ArrayList<Exhibit> exhibits;

    public ExhibitManagement() {
        this.exhibits = new ArrayList<Exhibit>();
    }

    public ArrayList<Exhibit> getExhibits() {
        return this.exhibits;
    }

    public void manageExhibits(ArtifactManagement artifactManagement, ArrayList<Artifact> artifacts) {
        System.out.println("Manage Exhibits");
        SubMenu menu = new SubMenu("Exhibit");
        while (true) {
            int choice = menu.getUserChoice();
            boolean quit = processExhibitMenuChoice(choice, artifacts, artifactManagement);
            if (quit) {
                break;
            }

        }
    }

    private boolean processExhibitMenuChoice(int choice, ArrayList<Artifact> artifacts,
            ArtifactManagement artifactManagement) {
        boolean quit = false;
        Exhibit[] exhibitArray = exhibitsToArray();
        exhibitArray = sort(exhibitArray);
        Menu exhibitMenu = exhibitsMenu(exhibitArray);
        System.out.println();
        switch (choice) {
            case 1:
                addExhibit(artifacts, artifactManagement);
                break;
            case 2:
                while (true) {
                    System.out.print("View ");
                    int exhibitChoice = exhibitMenu.getUserChoice();
                    if (exhibitChoice - 1 == exhibitArray.length) {
                        exhibitArray = searchExhibits(exhibitArray);
                        exhibitArray = sort(exhibitArray);
                        exhibitMenu = exhibitsMenu(exhibitArray);
                        continue;
                    }
                    if (exhibitChoice - 2 == exhibitArray.length) {
                        exhibitArray = exhibitsToArray(exhibits);
                        exhibitArray = sort(exhibitArray);
                        exhibitMenu = exhibitsMenu(exhibitArray);
                        continue;
                    }
                    boolean quitViewing = viewExhibit(exhibitChoice, artifacts);
                    if (quitViewing) {
                        break;
                    }

                }
                break;
            case 3:
                while (true) {
                    System.out.print("Update ");
                    int exhibitChoice = exhibitMenu.getUserChoice();
                    if (exhibitChoice - 1 == exhibitArray.length) {
                        exhibitArray = searchExhibits(exhibitArray);
                        exhibitArray = sort(exhibitArray);
                        exhibitMenu = exhibitsMenu(exhibitArray);
                        continue;
                    }
                    if (exhibitChoice - 2 == exhibitArray.length) {
                        exhibitArray = exhibitsToArray(exhibits);
                        exhibitArray = sort(exhibitArray);
                        exhibitMenu = exhibitsMenu(exhibitArray);
                        continue;
                    }
                    boolean quitUpdating = updateExhibit(exhibitChoice, artifacts, artifactManagement);
                    exhibitArray = exhibitsToArray();
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
                    if (exhibitChoice - 1 == exhibitArray.length) {
                        exhibitArray = searchExhibits(exhibitArray);
                        exhibitArray = sort(exhibitArray);
                        exhibitMenu = exhibitsMenu(exhibitArray);
                        continue;
                    }
                    if (exhibitChoice - 2 == exhibitArray.length) {
                        exhibitArray = exhibitsToArray();
                        exhibitArray = sort(exhibitArray);
                        exhibitMenu = exhibitsMenu(exhibitArray);
                        continue;
                    }
                    boolean quitDeleting = deleteExhibit(exhibitChoice);
                    exhibitArray = exhibitsToArray();
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

    private void addExhibit(ArrayList<Artifact> artifacts, ArtifactManagement artifactManagement) {
        System.out.println("Add Exhibit");
        System.out.print("Enter Exhibit Name:");
        String name = input.nextLine();

        System.out.print("Select What Artifacts to Include in the Order They Are in the Exhibit:");
        Artifact[] artifactArray = artifactManagement.artifactsToArray(artifacts);
        artifactArray = artifactManagement.sort(artifactArray);
        Menu artifactMenu = artifactManagement.artifactsMenu(artifactArray);

        ArrayList<Integer> exhibitArtifacts = new ArrayList<Integer>();
        while (true) {
            int artifactChoice = artifactMenu.getUserChoice();
            if (artifactChoice - 3 == artifactArray.length) {
                break;
            }
            if (artifactChoice - 1 == artifactArray.length) {
                artifactArray = artifactManagement.searchArtifacts(artifactArray);
                artifactArray = artifactManagement.sort(artifactArray);
                artifactMenu = artifactManagement.artifactsMenu(artifactArray);
                continue;
            }
            if (artifactChoice - 2 == artifactArray.length) {
                artifactArray = artifactManagement.artifactsToArray(artifacts);
                artifactArray = artifactManagement.sort(artifactArray);
                artifactMenu = artifactManagement.artifactsMenu(artifactArray);
                continue;
            }
            if (!Utils.contains(artifactArray[artifactChoice - 1].getId(), exhibitArtifacts)) {
                exhibitArtifacts.add(artifactArray[artifactChoice - 1].getId());
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
        try {
            System.out.println(name);
            Exhibit exhibit = new Exhibit(name, exhibitArtifacts, exhibitRoute);
            this.exhibits.add(exhibit);
            System.out.println();
        } catch (Exception e) {
            System.out.println("Bad Data");
        }

    }

    private boolean viewExhibit(int choice, ArrayList<Artifact> artifacts) {

        if (choice - 3 == this.exhibits.size()) {
            return true;
        }
        Exhibit exhibit = this.exhibits.get(choice - 1);

        Artifact[] artifactArray = exhibit.getArtifacts(artifacts);

        ArrayList<String> route = exhibit.getRoute();
        String[] routeArray = routeToArray(route);

        String exhibitString = exhibit.toString() + "\nArtifacts for the Exhibit\n";
        for (int i = 0; i < artifactArray.length; i++) {
            exhibitString += artifactArray[i].getName() + "\n";
        }
        exhibitString += "\nRoute:\nSteps:\tSigns\n";
        for (int i = 0; i < artifactArray.length; i++) {
            exhibitString += (i + 1) + ". " + artifactArray[i].getName() + "\t" + routeArray[i] + "\n";
        }
        System.out.println(exhibitString);
        System.out.println();
        return false;
    }

    private boolean updateExhibit(int choice, ArrayList<Artifact> artifacts, ArtifactManagement artifactManagement) {
        if (choice - 3 == this.exhibits.size()) {
            return true;
        }

        Exhibit exhibit = exhibits.get(choice - 1);
        System.out.println("Update Exhibit");
        System.out.println("Enter new data or press RETURN to leave unchanged");

        System.out.print("Enter Exhibit Name:");
        String name = input.nextLine();
        if (name != "") {
            exhibit.setName(name);
        }

        ArrayList<String> route = exhibit.getRoute();

        while (true) {
            Artifact[] artifactArray = exhibit.getArtifacts(artifacts);
            String[] artifactNames = new String[artifactArray.length + 1];
            for (int i = 0; i < artifactArray.length; i++) {
                artifactNames[i] = artifactArray[i].getName();
            }
            artifactNames[artifactArray.length] = "Quit";
            Menu artifactMenu = new Menu("Artifact To Change", artifactNames);
            int artifactChoice = artifactMenu.getUserChoice();
            if (artifactChoice - 1 == artifactArray.length) {
                break;
            }
            while (true) {
                System.out.print("Select new Artifact");
                Artifact[] allArtifactArray = artifactManagement.artifactsToArray(artifacts);
                allArtifactArray = artifactManagement.sort(allArtifactArray);
                Menu allArtifactMenu = artifactManagement.artifactsMenu(allArtifactArray);
                ArrayList<Integer> exhibitArtifacts = exhibit.getArtifactsID();
                int newArtifactChoice = allArtifactMenu.getUserChoice();
                if (newArtifactChoice - 3 == allArtifactArray.length) {
                    break;
                }
                if (newArtifactChoice - 1 == allArtifactArray.length) {
                    allArtifactArray = artifactManagement.searchArtifacts(allArtifactArray);
                    allArtifactArray = artifactManagement.sort(allArtifactArray);
                    allArtifactMenu = artifactManagement.artifactsMenu(allArtifactArray);
                    continue;
                }
                if (newArtifactChoice - 2 == allArtifactArray.length) {
                    allArtifactArray = artifactManagement.artifactsToArray(artifacts);
                    allArtifactArray = artifactManagement.sort(allArtifactArray);
                    allArtifactMenu = artifactManagement.artifactsMenu(allArtifactArray);
                    continue;
                }
                if (!Utils.contains(allArtifactArray[newArtifactChoice - 1].getId(), exhibitArtifacts)) {
                    exhibitArtifacts.remove(artifactChoice - 1);
                    exhibitArtifacts.add(artifactChoice - 1, allArtifactArray[newArtifactChoice - 1].getId());
                    break;
                } else {
                    System.out.println("Artifact Already in Exhibit");
                }
            }
            System.out.print("Enter new Sign: ");
            String sign = input.nextLine();
            route.add(artifactChoice - 1, sign);
        }

        return false;
    }

    private boolean deleteExhibit(int choice) {
        if (choice - 3 == this.exhibits.size()) {
            return true;
        }
        this.exhibits.remove(choice - 1);
        return false;
    }

    public Menu exhibitsMenu(Exhibit[] exhibitArray) {
        String[] exhibitNames = exhibitArrayToNameArray(exhibitArray);
        String[] quit = { "Search", "Clear", "Quit" };
        String[] exhibitOptions = Utils.concat(exhibitNames, quit);
        Menu artifactMenu = new Menu("Artifacts", exhibitOptions);
        return artifactMenu;
    }



    public Exhibit[] exhibitsToArray() {
        Exhibit[] exhibitArray = new Exhibit[this.exhibits.size()];
        for (int i = 0; i < exhibitArray.length; i++) {
            exhibitArray[i] = this.exhibits.get(i);
        }
        return exhibitArray;
    }

    public Exhibit[] exhibitsToArray(ArrayList<Exhibit> exhibits) {
        Exhibit[] exhibitArray = new Exhibit[exhibits.size()];
        for (int i = 0; i < exhibitArray.length; i++) {
            exhibitArray[i] = exhibits.get(i);
        }
        return exhibitArray;
    }

    public String[] exhibitArrayToNameArray(Exhibit[] exhibitArray) {
        String[] nameArray = new String[exhibitArray.length];
        for (int i = 0; i < exhibitArray.length; i++) {
            nameArray[i] = exhibitArray[i].getName();
        }
        return nameArray;
    }

    public Exhibit[] sort(Exhibit[] array) {
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

    public String[] routeToArray(ArrayList<String> route) {
        String[] routeArray = new String[route.size()];
        for (int i = 0; i < routeArray.length; i++) {
            routeArray[i] = route.get(i);
        }
        return routeArray;
    }

    public Exhibit[] searchExhibits(Exhibit[] exhibitArray) {
        String[] searchCriteriaOptions = { "ID", "Name", "Cancel" };
        Menu searchCriteria = new Menu("Select Search Criteria", searchCriteriaOptions);
        int criteriaChoice = searchCriteria.getUserChoice();
        ArrayList<Exhibit> searchResults = new ArrayList<Exhibit>();
        switch (criteriaChoice) {
            case 1:
                while (true) {
                    System.out.print("Enter ID to search for: ");
                    try {
                        int id = input.nextInt();
                        for (int i = 0; i < exhibitArray.length; i++) {
                            if (exhibitArray[i].getId() == id) {
                                Exhibit[] newExhibitArray = { exhibitArray[i] };
                                exhibitArray = newExhibitArray;
                            }
                        }
                        break;
                    } catch (Exception e) {
                        input.nextLine();
                        System.out.println("Please enter an Integer");
                    }
                }
                break;

            case 2:
                System.out.print("Enter Name to search for: ");
                String name = input.nextLine();
                for (int i = 0; i < exhibitArray.length; i++) {
                    String exhibitName = exhibitArray[i].getName();
                    if (exhibitName.equals(name)) {
                        searchResults.add(exhibitArray[i]);
                    }
                }
                if (searchResults.size() == 0) {
                    System.out.println("No matching results");
                } else {
                    exhibitArray = exhibitsToArray(searchResults);
                }
                break;
        }

        return exhibitArray;
    }
}
