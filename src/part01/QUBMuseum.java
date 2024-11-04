package part01;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class QUBMuseum {
    private static ArrayList<Artifact> artifacts = new ArrayList<Artifact>();
    private static ArrayList<Exhibit> exhibits= new ArrayList<Exhibit>();

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
                ExhibitManagement.manageExhibits(exhibits, artifacts);
                break;
            case 3:
                manageAnnualPlan();
                break;
            case 4:

                quit = true;
        }
        return quit;
    }

    

    

    private static void manageAnnualPlan() {
        System.out.println("Manage Annual plan");
    }

    
}
