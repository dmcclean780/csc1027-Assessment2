package part01;

import java.util.ArrayList;
import java.util.Scanner;

public class ArtifactManagement {
    private static Scanner input = new Scanner(System.in);
    private ArrayList<Artifact> artifacts;

    public ArtifactManagement() {
        this.artifacts = new ArrayList<Artifact>();
    }

    public ArrayList<Artifact> getArtifacts() {
        return this.artifacts;
    }

    public void manageArtifacts(ArrayList<Exhibit> exhibits) {
        System.out.println("Manage Artifacts");
        SubMenu menu = new SubMenu("Artifact");
        while (true) {
            int choice = menu.getUserChoice();
            boolean quit = processArtifactMenuChoice(choice, exhibits);
            if (quit) {
                break;
            }

        }
    }

    private boolean processArtifactMenuChoice(int choice, ArrayList<Exhibit> exhibits) {
        boolean quit = false;
        Artifact[] artifactArray = artifactsToArray();
        artifactArray = sort(artifactArray);
        Menu artifactMenu = artifactsMenu(artifactArray);
        System.out.println();
        switch (choice) {
            case 1:
                addArtifact();
                break;
            case 2:
                while (true) {
                    System.out.print("View ");
                    int artifactChoice = artifactMenu.getUserChoice();
                    if (artifactChoice - 1 == artifactArray.length) {
                        artifactArray = searchArtifacts(artifactArray);
                        artifactArray = sort(artifactArray);
                        artifactMenu = artifactsMenu(artifactArray);
                        continue;
                    }
                    if (artifactChoice - 2 == artifactArray.length) {
                        artifactArray = artifactsToArray();
                        artifactArray = sort(artifactArray);
                        artifactMenu = artifactsMenu(artifactArray);
                        continue;
                    }

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
                    if (artifactChoice - 1 == artifactArray.length) {
                        artifactArray = searchArtifacts(artifactArray);
                        artifactArray = sort(artifactArray);
                        artifactMenu = artifactsMenu(artifactArray);
                        continue;
                    }
                    if (artifactChoice - 2 == artifactArray.length) {
                        artifactArray = artifactsToArray();
                        artifactArray = sort(artifactArray);
                        artifactMenu = artifactsMenu(artifactArray);
                        continue;
                    }
                    boolean quitUpdating = updateArtifact(artifactChoice, artifactArray);
                    artifactArray = artifactsToArray();
                    artifactArray = sort(artifactArray);
                    artifactMenu = artifactsMenu(artifactArray);
                    if (quitUpdating) {
                        break;
                    }

                }
                break;
            case 4:
                while (true) {
                    System.out.print("Delete ");
                    int artifactChoice = artifactMenu.getUserChoice();
                    if (artifactChoice - 1 == artifactArray.length) {
                        artifactArray = searchArtifacts(artifactArray);
                        artifactArray = sort(artifactArray);
                        artifactMenu = artifactsMenu(artifactArray);
                        continue;
                    }
                    if (artifactChoice - 2 == artifactArray.length) {
                        artifactArray = artifactsToArray();
                        artifactArray = sort(artifactArray);
                        artifactMenu = artifactsMenu(artifactArray);
                        continue;
                    }
                    boolean quitDeleting = deleteArtifact(artifactChoice, artifactArray, exhibits);
                    artifactArray = artifactsToArray();
                    artifactArray = sort(artifactArray);
                    artifactMenu = artifactsMenu(artifactArray);
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

    private void addArtifact() {
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
                this.artifacts.add(art);
                System.out.println();
                break;
            } catch (TimeIsNegativeException e) {
                input.nextLine();
                System.out.println("Time must be Positive");
            } catch (Exception e) {
                input.nextLine();
                System.out.println("Please enter an Integer");
            }
        }
        input.nextLine();
    }

    private boolean viewArtifact(int choice, Artifact[] artifactArray) {

        if (choice - 3 == artifactArray.length) {
            return true;
        }

        System.out.println(artifactArray[choice - 1]);
        System.out.println();
        return false;
    }

    private boolean updateArtifact(int choice, Artifact[] artifactArray) {
        if (choice - 3 == artifactArray.length) {
            return true;
        }
        Artifact artifact = artifactArray[choice - 1];
        System.out.println("Enter new data or press RETURN to leave unchanged");
        System.out.print("Enter Artifact Name:");
        String name = input.nextLine();
        if (name != "") {
            artifact.setName(name);
        }
        System.out.print("Enter Artifact Type:");
        String type = input.nextLine();
        if (type != "") {
            artifact.setType(type);
        }
        while (true) {
            try {
                System.out.print("Enter Artifact Expected Engagement Time:");
                String engagementTimeString = input.nextLine();
                if (engagementTimeString != "") {
                    int engagementTime = Integer.parseInt(engagementTimeString);
                    artifact.setEngagementTime(engagementTime);
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Please enter an Integer");
            } catch (TimeIsNegativeException e) {
                System.out.println("Enter a Positive Time");
            }
        }
        return false;
    }

    private boolean deleteArtifact(int choice, Artifact[] artifactArray, ArrayList<Exhibit> exhibits) {
        if (choice - 3 == artifactArray.length) {
            return true;
        }
        Artifact a = artifactArray[choice - 1];
        int id = a.getId();
        for (int i = 0; i < exhibits.size(); i++) {
            Exhibit exhibit = exhibits.get(i);
            int artifactIndex = exhibit.findArtifactIndex(id);
            if (artifactIndex != -1) {
                exhibit.removeArtifact(id);
                exhibit.removeSign(artifactIndex);
            }

        }
        artifacts.remove(a);
        return false;
    }

    public Menu artifactsMenu(Artifact[] artifactArray) {
        String[] artifactNames = artifactArrayToNameArray(artifactArray);
        String[] quit = { "Search", "Clear", "Quit" };
        String[] artifactOptions = Utils.concat(artifactNames, quit);
        Menu artifactMenu = new Menu("Artifacts", artifactOptions);
        return artifactMenu;
    }

    public Artifact[] artifactsToArray() {
        Artifact[] artifactArray = new Artifact[this.artifacts.size()];
        for (int i = 0; i < artifactArray.length; i++) {
            artifactArray[i] = artifacts.get(i);
        }
        return artifactArray;
    }

    public Artifact[] artifactsToArray(ArrayList<Artifact> artifacts) {
        Artifact[] artifactArray = new Artifact[artifacts.size()];
        for (int i = 0; i < artifactArray.length; i++) {
            artifactArray[i] = artifacts.get(i);
        }
        return artifactArray;
    }

    public String[] artifactArrayToNameArray(Artifact[] artifactArray) {
        String[] nameArray = new String[artifactArray.length];
        for (int i = 0; i < artifactArray.length; i++) {
            nameArray[i] = artifactArray[i].getName();
        }
        return nameArray;
    }

    public Artifact[] sort(Artifact[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j].getName().compareTo(array[j + 1].getName()) > 0) {
                    Artifact temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }

    public Artifact[] searchArtifacts(Artifact[] artifactArray) {
        String[] searchCriteriaOptions = { "ID", "Name", "Type", "Engagement Time", "Cancel" };
        Menu searchCriteria = new Menu("Select Search Criteria", searchCriteriaOptions);
        int criteriaChoice = searchCriteria.getUserChoice();
        ArrayList<Artifact> searchResults = new ArrayList<Artifact>();
        switch (criteriaChoice) {
            case 1:
                while (true) {
                    System.out.print("Enter ID to search for: ");
                    try {
                        int id = input.nextInt();
                        for (int i = 0; i < artifactArray.length; i++) {
                            if (artifactArray[i].getId() == id) {
                                Artifact[] newArtifactArray = { artifactArray[i] };
                                artifactArray = newArtifactArray;
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
                for (int i = 0; i < artifactArray.length; i++) {
                    String artifactName = artifactArray[i].getName();
                    if (artifactName.equals(name)) {
                        searchResults.add(artifactArray[i]);
                    }
                }
                if (searchResults.size() == 0) {
                    System.out.println("No matching results");
                } else {
                    artifactArray = artifactsToArray(searchResults);
                }
                break;

            case 3:
                System.out.print("Enter Type to search for: ");
                String type = input.nextLine();

                for (int i = 0; i < artifactArray.length; i++) {
                    if (artifactArray[i].getType().equals(type)) {
                        searchResults.add(artifactArray[i]);
                    }
                }
                if (searchResults.size() == 0) {
                    System.out.println("No matching results");
                } else {
                    artifactArray = artifactsToArray(searchResults);
                }
                break;

            case 4:
                while (true) {
                    System.out.print("Enter Type to search for: ");
                    try {
                        int engagementTime = input.nextInt();
                        for (int i = 0; i < artifactArray.length; i++) {
                            if (artifactArray[i].getEngagementTime() == engagementTime) {
                                searchResults.add(artifactArray[i]);
                            }
                        }
                        if (searchResults.size() == 0) {
                            System.out.println("No matching results");
                        } else {
                            artifactArray = artifactsToArray(searchResults);
                        }
                        break;
                    } catch (Exception e) {
                        input.nextLine();
                        System.out.println("Please enter an Integer");
                    }

                }
                break;
        }

        return artifactArray;
    }
}
