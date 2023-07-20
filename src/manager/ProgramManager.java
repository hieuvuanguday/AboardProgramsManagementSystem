/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manager;

import java.util.ArrayList;
import java.util.Date;
import java.util.TreeSet;
import models.Program;
import utilities.Inputter;

/**
 *
 * @author Administrator
 */
public class ProgramManager extends TreeSet<Program> {

    /**
     * Displays the programs information in a formatted table. The table
     * includes columns for program ID, program name, time, begin date, end
     * date, days, location, and cost. The table is printed to the console.
     */
    public void display() {
        int count = 1;
        System.out.println("|No. |Program id|    Program name    |Time      |Begin Date| End Date |     Days     |Location                           |Cost    |");
        for (Program p : this) {
            String no = String.format("|%4s", count);
            System.out.print(no);
            p.display();
            count++;
        }
    }

    /**
     * Finds a program with the specified ID.
     *
     * @param id The ID of the program to find.
     * @return The Program object with the specified ID, or null if not found.
     */
    public Program find(String id) {
        for (Program p : this) {
            if (p.getId().equals(id)) {
                return p;
            }
        }
        return null;
    }

    /**
     * Adds a new program to the collection.
     *
     * Prompts the user to enter the program details such as id, name, time,
     * begin date, end date, program length, location, cost, and content.
     * Validates the input according to the specified rules. If the program id
     * is not unique, it prompts the user to enter a different id.
     *
     * Once all the details are entered correctly, a new Program object is
     * created and added to the collection.
     */
    public void add() {
        String id;
        while (true) {
            id = Inputter.getString("Enter program id: ", "This field cannot be empty!");
            if (find(id) == null) {
                break;
            } else {
                System.out.println("Id must be unique!");
            }
        }
        String name = Inputter.getString("Enter program name: ", "This field cannot be empty!");
        String time = Inputter.getString("Enter progam time: ", "January, March, May, July, September, November!", "([jJ]anuary)|([mM]arch)|([mM]ay)|([jJ]uly)|([sS]eptember)|([nN]ovember)");
        Date beginDate = Inputter.getDate("Enter begin date: ");
        Date endDate = Inputter.getDate("Enter end date: ");
        int days = Integer.parseInt(Inputter.getString("Enter program length: ", "Enter 30 to 40 days!", "^(3[0-9]|40)$"));
        String location = Inputter.getString("Enter program location: ", "This field cannot be empty!");
        double cost = Double.parseDouble(Inputter.getString("Enter program cost: ", "This field must be a real number!", "\\d+(\\.\\d+)?"));
        String content = Inputter.getString("Enter program content: ", "This feild cannot be empty!");
        this.add(new Program(id, name, time, beginDate, endDate, days, location, cost, content));
    }

    /**
     * Updates an existing program in the collection.
     *
     * Prompts the user to enter the program id and validates its existence in
     * the collection. If the program doesn't exist, it displays an error
     * message.
     *
     * If the program exists, it prompts the user to enter the updated program
     * details such as name, time, begin date, end date, program length,
     * location, cost, and content. Validates the input according to the
     * specified rules.
     *
     * Once all the details are entered correctly, the corresponding Program
     * object in the collection is updated with the new values.
     *
     * Displays a success message after updating the program.
     */
    public void update() {
        String id = Inputter.getString("Enter program id: ", "This field cannot be empty!");
        if (find(id) == null) {
            System.out.println("This program does not exist.");
        } else {
            Program p = find(id);
            String name = Inputter.getString("Enter program name: ", "This field cannot be empty!");
            String time = Inputter.getString("Enter progam time: ", "January, March, May, July, September, November!", "([jJ]anuary)|([mM]arch)|([mM]ay)|([jJ]uly)|([sS]eptember)|([nN]ovember)");
            Date beginDate = Inputter.getDate("Enter begin date: ");
            Date endDate = Inputter.getDate("Enter end date: ");
            int days = Integer.parseInt(Inputter.getString("Enter program length: ", "Enter 30 to 40 days!", "^(3[0-9]|40)$"));
            String location = Inputter.getString("Enter program location: ", "This field cannot be empty!");
            double cost = Double.parseDouble(Inputter.getString("Enter program cost: ", "This field must be a real number!", "\\d+(\\.\\d+)?"));
            String content = Inputter.getString("Enter program content: ", "This feild cannot be empty!");

            p.setName(name);
            p.setTime(time);
            p.setBeginDate(beginDate);
            p.setEndDate(endDate);
            p.setDays(days);
            p.setLocation(location);
            p.setCost(cost);
            p.setContent(content);
            System.out.println("Update successfully.");
        }
    }

    /**
     * Searches for a program in the collection based on the provided program
     * id.
     *
     * Prompts the user to enter the program id and validates its existence in
     * the collection. If the program doesn't exist, it displays an error
     * message.
     *
     * If the program exists, it displays the details of the program using the
     * display() method.
     */
    public void search() {
        String id = Inputter.getString("Enter program id: ", "This field cannot be empty.");
        if (find(id) == null) {
            System.out.println("This program does not exist.");
        } else {
            Program p = find(id);
            p.display();
        }
    }

    /**
     * Converts the collection of programs to an ArrayList of strings.
     *
     * Iterates through each program in the collection and calls the toString()
     * method on each program to retrieve its string representation. The string
     * representation of each program is then added to the ArrayList.
     *
     * @return ArrayList of strings representing the programs in the collection.
     */
    public ArrayList<String> toArrayList() {
        ArrayList<String> dta = new ArrayList<>();
        for (Program s : this) {
            dta.add(s.toString());
        }
        return dta;
    }
}
