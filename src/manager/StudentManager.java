/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manager;

import java.util.ArrayList;
import java.util.TreeSet;
import models.Student;
import utilities.Inputter;

/**
 *
 * @author Administrator
 */
public class StudentManager extends TreeSet<Student> {

    public static boolean flag = true;

    /**
     * Displays the information of all students in the program.
     */
    public void display() {
        int count = 1;
        System.out.println("|No. |Student id|Student Name        |Major|Email                         |Phone     |Passport  |Address        |");
        for (Student s : this) {
            String no = String.format("|%4s", count);
            System.out.print(no);
            s.display();
            count++;
        }
    }

    /**
     * Finds a student in the program by their ID.
     *
     * @param id The ID of the student to find.
     * @return The found student object, or null if no student with the given ID
     * is found.
     */
    public Student find(String id) {
        for (Student s : this) {
            if (s.getId().equals(id)) {
                return s;
            }
        }
        return null;
    }

    /**
     * Adds a new student to the program. Prompts the user to enter the
     * student's information, including ID, name, major, email, phone, passport,
     * and address. Validates the input based on specific criteria. Only adds
     * the student if the ID is unique.
     */
    public void add() {
        flag = true;
        String id = null;
        while (flag) {
            id = Inputter.getString("Enter student id: ", "This field cannot be empty!", "^(SE|SB|GD|MC)\\d{6}$");
            if (find(id) == null) {
                break;
            } else {
                System.out.println("Id must be unique!");
            }
        }
        String name = Inputter.getString("Enter student name: ", "This field cannot be empty!");
        String major = Inputter.getString("Enter student major: ", "This field contain values: SE, SB, GD, MC!", "^(SE|SB|GD|MC)$");
        String email = Inputter.getString("Enter studetn email: ", "Must contain \"@fpt.edu.vn\"", ".*(@fpt\\.edu\\.vn)$");
        String phone = Inputter.getString("Enter student phone: ", "This field cannot be empty!");
        String passport = Inputter.getString("Enter student passport: ", "This field cannot be empty!");
        String address = Inputter.getString("Enter student address: ", "This field cannot be empty!");
        this.add(new Student(id, name, major, email, phone, passport, address));
    }

    /**
     * Updates the information of a student in the program. Prompts the user to
     * enter the student's ID to identify the student to be updated. If the
     * student with the given ID is found, prompts the user to enter the updated
     * information including name, major, email, phone, passport, and address.
     * Performs input validation based on specific criteria. Updates the
     * student's information if the ID exists.
     */
    public void update() {
        String id = Inputter.getString("Enter student id: ", "Invalid [SE|SB|GD|MCxxxxxx]!", "^(SE|SB|GD|MC)\\d{6}$");
        if (find(id) == null) {
            System.out.println("This student does not exist.");
        } else {
            Student s = find(id);
            String name = Inputter.getString("Enter student name: ", "This field cannot be empty!");
            String major = Inputter.getString("Enter student major: ", "This field contain values: SE, SB, GD, MC!", "^(SE|SB|GD|MC)$");
            String email = Inputter.getString("Enter studetn email: ", "Must contain \"@fpt.edu.vn\"", ".*(@fpt\\.edu\\.vn)$");
            String phone = Inputter.getString("Enter student phone: ", "This field cannot be empty!");
            String passport = Inputter.getString("Enter student passport: ", "This field cannot be empty!");
            String address = Inputter.getString("Enter student address: ", "This field cannot be empty!");

            s.setAddress(address);
            s.setEmail(email);
            s.setName(name);
            s.setMajor(major);
            s.setPassport(passport);
            s.setPhone(phone);
            System.out.println("Update successfully.");
        }
    }

    /**
     * Converts the program's student data to an ArrayList of strings. Each
     * string in the ArrayList represents a student's information. The student
     * information is obtained by calling the `toString()` method of each
     * student object.
     *
     * @return An ArrayList of strings representing the program's student data.
     */
    public ArrayList<String> toArrayList() {
        ArrayList<String> dta = new ArrayList<>();
        for (Student s : this) {
            dta.add(s.toString());
        }
        return dta;
    }
}
