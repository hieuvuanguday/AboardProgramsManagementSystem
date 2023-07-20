/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlers;

import manager.StudentManager;
import utilities.Menu;

/**
 *
 * @author Administrator
 */
public class StudentControler {

    private final Menu menu;

    /**
     * Initializes a new instance of the StudentController class.
     *
     * Constructs a new StudentController object and sets up the menu options
     * for managing students. The menu options include displaying all students,
     * adding a new student, editing student information by ID, and returning to
     * the main menu.
     */
    public StudentControler() {
        menu = new Menu("Manage Student.");
        menu.addOption("Display all students");
        menu.addOption("Add a new student");
        menu.addOption("Edit information of a student by id");
        menu.addOption("Back to main menu");
    }

    /**
     * Entry point for the student management functionality.
     *
     * Displays the menu options, prompts the user for their choice, and
     * performs the corresponding action. The available options include
     * displaying all students, adding a new student, and updating student
     * information.
     *
     * @param sm The existing StudentManager object.
     * @return The updated StudentManager object.
     */
    public StudentManager main(StudentManager sm) {
        menu.printMenu();
        int choice = menu.getChoice();
        switch (choice) {
            case 1:
                sm.display();
                break;
            case 2:
                sm.add();
                break;
            case 3:
                sm.update();
                break;
            default:
                break;
        }
        return sm;
    }
}
