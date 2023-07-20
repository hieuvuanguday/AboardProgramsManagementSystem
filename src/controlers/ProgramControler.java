/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlers;

import manager.ProgramManager;
import utilities.Menu;

/**
 *
 * @author Administrator
 */
public class ProgramControler {

    private final Menu menu;

    /**
     * Constructs a ProgramControler object. Initializes the menu options for
     * managing aboard programs.
     */
    public ProgramControler() {
        menu = new Menu("Manage aboard programs.");
        menu.addOption("Display all aboard programs");
        menu.addOption("Add a new aboard programs");
        menu.addOption("Edit information of a program by id");
        menu.addOption("Search and display a program by id");
        menu.addOption("Back to main menu");
    }

    /**
     * Executes the main functionality for managing aboard programs based on
     * user input. Prints the menu options and performs the corresponding action
     * based on the user's choice.
     *
     * @param pm The ProgramManager object to perform the operations on.
     * @return The updated ProgramManager object.
     */
    public ProgramManager main(ProgramManager pm) {
        menu.printMenu();
        int choice = menu.getChoice();
        switch (choice) {
            case 1:
                pm.display();
                break;
            case 2:
                pm.add();
                break;
            case 3:
                pm.update();
                break;
            case 4:
                pm.search();
                break;
        }
        return pm;
    }
}
