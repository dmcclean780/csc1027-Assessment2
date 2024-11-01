package part01;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.function.Function;

public class QUBMuseum {
    private static ArrayList<Artifact> artifacts = new ArrayList<Artifact>();
    private static ArrayList<Exhibit> exhibits;
    private static Scanner input = new Scanner(System.in);

    private static final String generalMenuTitle = "QUB Museum";
    private static final String[] generalMenuOptions = {"Manage Artifacts", "Manage Exhibits", "Mangage Annual Plan", "Quit"};

    public static void main(String[] args){
        Menu generalMenu = new Menu(generalMenuTitle, generalMenuOptions);
        useMenu(generalMenu, QUBMuseum::processGeneralMenuChoice);
        System.out.println("All done - Goodbye!");
    }

    private static void useMenu(Menu menu, Function<Integer, Boolean> choiceFunction){
        while(true){
            int choice = menu.getUserChoice();
            boolean quit = choiceFunction.apply(choice);
            if(quit){
                break;
            }

        }
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
		SubMenu menu = new SubMenu("Artifact");
        useMenu(menu, QUBMuseum::processArtifactMenuChoice);
        //System.out.println("Manage Artifacts");
	}

    private static boolean processArtifactMenuChoice(int choice) {
		boolean quit = false;
		switch (choice) {
            case 1:
                addArtifact();
                break;
            case 2:
                viewArtifact();
                break;
            case 3:
                updateArtifact();
                break;
            case 4:
                deleteArtifact();
                break;
            case 5:
                quit=true;
        }
		return quit;
	}

    private static void addArtifact(){
        System.out.println();
        System.out.println("Add Artifact");
        System.out.print("Enter Artifact Name:");
        String name = input.nextLine();
        System.out.print("Enter Artifact Type:");
        String type = input.nextLine();
        System.out.print("Enter Artifact Expected Engagement Time:");
        while(true){
            try{
                int engagementTime = input.nextInt();
                Artifact art = new Artifact(name, type, engagementTime);
                artifacts.add(art);
                System.out.println();
                break;
            }catch(InputMismatchException e){
                input.nextLine();
                System.out.println("Please enter an Integer");
            }catch(TimeIsNegativeException e){
                input.nextLine();
                System.out.println("Time must be Positive");
            }
        }
    }
    private static void viewArtifact(){
        System.out.println("view Artifact");
    }
    private static void updateArtifact(){
        System.out.println("update Artifact");
    }
    private static void deleteArtifact(){
        System.out.println("delete Artifact");
    }

	private static void manageExhibits() {
		System.out.println("Manage Exhibits");
	}

	private static void manageAnnualPlan() {
		System.out.println("Manage Annual plan");
	}
}
