/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlers;

import java.text.ParseException;
import java.util.ArrayList;
import manager.ProgramManager;
import manager.StudentManager;
import models.Program;
import models.Student;
import utilities.DateModifier;
import utilities.Loader;
import utilities.Menu;

/**
 *
 * @author Administrator
 */
public class MainControler {

    private final Menu menu;

    /**
     * Constructs a new MainControler object. Initializes the main menu with
     * options for managing aboard programs, managing students, registering a
     * program for a student, generating reports, and quitting the program.
     */
    public MainControler() {
        menu = new Menu("Aboard program management system.");
        menu.addOption("Manage aboard programs");
        menu.addOption("Manage Student");
        menu.addOption("Register a program for a student");
        menu.addOption("Report");
        menu.addOption("Quit");
    }

    /**
     * Handles the main control flow of the program. Displays the main menu
     * options and executes the corresponding actions based on user input.
     *
     * @param sm The StudentManager object for managing students.
     * @param pm The ProgramManager object for managing aboard programs.
     */
    public void main(StudentManager sm, ProgramManager pm) {
        while (true) {
            menu.printMenu();
            int choice = menu.getChoice();
            switch (choice) {
                case 1:
                    ProgramControler pc = new ProgramControler();
                    pm = pc.main(pm);
                    break;
                case 2:
                    StudentControler sc = new StudentControler();
                    sm = sc.main(sm);
                    break;
                case 3:
                    ReportControler rc = new ReportControler();
                    rc.main(sm, pm, choice);
                    break;
                case 4:
                    ReportControler rc1 = new ReportControler();
                    rc1.main(sm, pm, choice);
                    break;
                case 5:
                    return;
            }
        }
    }

    /**
     * Loads student data from a file and creates a StudentManager object.
     *
     * @param filepath The path to the file containing student data.
     * @return The StudentManager object populated with the loaded student data.
     */
    public static StudentManager loadStudentData(String filepath) {
        StudentManager sm = new StudentManager();
        ArrayList<String> data = Loader.readFromFile(filepath);
        for (String line : data) {
            if (line == null || line.isEmpty()) {
                continue;
            }
            String[] lineSplit = line.split(",");
            sm.add(new Student(lineSplit[0], lineSplit[1], lineSplit[2], lineSplit[3], lineSplit[4], lineSplit[5], lineSplit[6]));
        }
        return sm;
    }

    /**
     * Loads program data from a file and creates a ProgramManager object.
     *
     * @param filepath The path to the file containing program data.
     * @return The ProgramManager object populated with the loaded program data.
     * @throws ParseException If there is an error parsing the dates in the
     * program data.
     */
    public static ProgramManager loadProgramData(String filepath) throws ParseException {
        ProgramManager pm = new ProgramManager();
        ArrayList<String> data = Loader.readFromFile(filepath);
        for (String line : data) {
            if (line == null || line.isEmpty()) {
                continue;
            }
            String[] lineSplit = line.split(",");
            pm.add(new Program(lineSplit[0], lineSplit[1], lineSplit[2],
                    DateModifier.toDate(lineSplit[3], null),
                    DateModifier.toDate(lineSplit[4], null),
                    Integer.parseInt(lineSplit[5]),
                    lineSplit[6],
                    Double.parseDouble(lineSplit[7]),
                    lineSplit[8]));
        }
        return pm;
    }
}
