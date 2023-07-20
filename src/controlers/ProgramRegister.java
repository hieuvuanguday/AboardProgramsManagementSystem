/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlers;

import java.util.ArrayList;
import java.util.Date;
import manager.ProgramManager;
import manager.StudentManager;
import models.Program;
import models.Student;
import utilities.DateModifier;
import utilities.Inputter;
import utilities.Loader;

/**
 *
 * @author Administrator
 */
public class ProgramRegister {

    public static boolean flag = true;

    /**
     * Registers a student for a program.
     *
     * @param pm The ProgramManager instance.
     * @param sm The StudentManager instance.
     * @return The path of the created registration form.
     */
    public static String register(ProgramManager pm, StudentManager sm) {
        flag = true;
        Program p = null;
        Student s = null;
        String pId;
        while (flag) {
            pId = Inputter.getString("Enter program id: ", "This field cannot be empty.");
            if ((p = pm.find(pId)) == null) {
                System.out.println("The program does not exist.");
                continue;
            }
            flag = false;
        }
        flag = true;
        String sId;
        while (flag) {
            sId = Inputter.getString("Enter student id: ", "This field cannot be empty!", "^(SE|SB|GD|MC)\\d{6}$");
            if ((s = sm.find(sId)) == null) {
                System.out.println("The student does not exist.");
                continue;
            }
            flag = false;
        }
        flag = true;
        Date regisDate = null;
        while (flag) {
            regisDate = Inputter.getDate("Enter registration date: ");
            if (DateModifier.inRange(p.getBeginDate(), p.getEndDate(), regisDate)) {
                flag = false;
            } else {
                System.out.println("Registration date is invalid.");
            }
        }
        String parentPhone = Inputter.getString("Enter parent phone: ", "This field cannot be empty.");
        String parentEmail = Inputter.getString("Enter parent email: ", "This field cannot be empty.");
        String path = initFileName(s, p);
        createForm(path, s, p, regisDate, parentPhone, parentEmail);
        return path;
    }

    /**
     * Creates a registration form for a student in a program.
     *
     * @param path The path of the registration form file.
     * @param s The Student object.
     * @param p The Program object.
     * @param regisDate The registration date.
     * @param parentPhone The phone number of the parent.
     * @param parentEmail The email address of the parent.
     */
    private static void createForm(String path, Student s, Program p, Date regisDate, String parentPhone, String parentEmail) {
        path = "data/registrationform/" + path;
        ArrayList<String> dta = new ArrayList<>();
        dta.add("                                             Aboard Program Registration Form");
        dta.add("Information of student: ");
        dta.add(String.format("Student id: %-13s Student name: %s", s.getId(), s.getName()));
        dta.add(String.format("Major: %-18s Email: %s    Phone: %s    Passport: %s", s.getMajor(), s.getEmail(),
                s.getPhone(), s.getPassport()));
        dta.add(String.format("Address: %-16s Email of the parent: %s    Phone of the parents: %s",
                s.getAddress(), parentPhone, parentEmail));
        dta.add("Information of the aboard program:");
        dta.add(String.format("Program id: %-13s Program name: %s", p.getId(), p.getName()));
        dta.add(String.format("Time: %-19s Days: %d    Location: %s    Cost: %.2f$", p.getTime(), p.getDays(), p.getLocation(), p.getCost()));
        dta.add("Information of the registration:");
        dta.add(String.format("Registration date:        %s", DateModifier.toDateString(regisDate, null)));
        Loader.writeToFile(path, dta);
    }

    /**
     * Initializes the filename for the registration form based on the student
     * and program.
     *
     * @param s The Student object.
     * @param p The Program object.
     * @return The filename for the registration form.
     */
    private static String initFileName(Student s, Program p) {
        String filename = ".txt";
        filename = s.getId() + "_" + p.getId() + filename;
        return filename;
    }
}
