package part01;

public class SubMenu extends Menu {

    private final String type;

    /**
     * Constructor
     * @param type - the item the sub menu is for - artifacts or exhibits
     */
    public SubMenu(String type){
        this.type=type;
        String menuTitle = "Manage "+type+"s";
        String[] menuOptions = {"Add ", "View ", "Update ", "Delete ", "Quit"};
        for (int i=0; i<menuOptions.length-1; i++){
            menuOptions[i]+=type;
        }
        super(menuTitle, menuOptions);
    }

    /**
     * 
     * @return the item the sub menu is for - artifacts or exhibits
     */
    public String getType() {
        return this.type;
    }


    
}
