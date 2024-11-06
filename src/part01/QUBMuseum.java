package part01;

public class QUBMuseum {
    private static ArtifactManagement artifactManagement = new ArtifactManagement();
    private static  ExhibitManagement exhibitManagement = new ExhibitManagement();

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
                artifactManagement.manageArtifacts(exhibitManagement.getExhibits());
                break;
            case 2:
                exhibitManagement.manageExhibits(artifactManagement, artifactManagement.getArtifacts());
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
