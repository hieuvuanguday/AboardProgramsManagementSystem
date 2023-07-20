/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlers;

import manager.ProgramManager;
import manager.StudentManager;
import utilities.Loader;

/**
 *
 * @author Administrator
 */
public class Main {

    /**
     * The main entry point of the program. Loads student and program data from
     * files. Creates an instance of MainControler and executes the main
     * functionality. Updates the program and student data files with any
     * changes made.
     *
     * @param args The command-line arguments.
     */
    public static void main(String[] args) {
        StudentManager sm = MainControler.loadStudentData("data/students.dat");
        ProgramManager pm = null;
        try {
            pm = MainControler.loadProgramData("data/programs.dat");
        } catch (Exception e) {
        }
        MainControler mainCtrl = new MainControler();
        mainCtrl.main(sm, pm);
        Loader.writeToFile("data/programs.dat", pm.toArrayList());
        Loader.writeToFile("data/students.dat", sm.toArrayList());
    }
}
