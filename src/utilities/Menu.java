/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilities;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Administrator
 */
public class Menu {

    private final String title;
    private final ArrayList<String> options = new ArrayList<>();
    private final Scanner sc = new Scanner(System.in);

    /**
     * Constructs a new instance of the Menu class with the provided title.
     *
     * @param title The title of the menu.
     */
    public Menu(String title) {
        this.title = title;
    }

    /**
     * Adds a new option to the menu.
     *
     * @param newOption The new option to be added to the menu.
     */
    public void addOption(String newOption) {
        options.add(newOption);
    }

    /**
     * Prints the menu title followed by the list of options. Each option is
     * displayed with a corresponding number.
     */
    public void printMenu() {
        System.out.println(title);
        for (String s : options) {
            System.out.println(options.indexOf(s) + 1 + ". " + s);
        }
    }

    /**
     * Prompts the user to choose an option from the menu and returns the
     * selected choice.
     *
     * @return The selected choice as an integer.
     */
    public int getChoice() {
        boolean flag = true;
        int choice = 0;
        while (flag) {
            choice = Integer.parseInt(Inputter.getString("Choose your option: ", "Must be a positive number!", "\\d"));
            if (choice >= 1 && choice <= options.size()) {
                flag = false;
            } else {
                System.out.println("Choose 1 - " + options.size() + "!");
            }
        }
        return choice;
    }

    /**
     * Displays a menu with "Yes" and "No" options and prompts the user to make
     * a choice. Returns true if the user selects "Yes" and false if the user
     * selects "No".
     *
     * @param title The title of the menu.
     * @return true if the user selects "Yes", false if the user selects "No".
     */
    public static boolean getYesOrNo(String title) {
        Menu sub = new Menu(title);
        sub.addOption("Yes");
        sub.addOption("No");
        sub.printMenu();
        return sub.getChoice() == 1;
    }

    /**
     * Retrieves the option at the specified index in the menu.
     *
     * @param index The index of the desired option.
     * @return The option at the specified index.
     */
    public String getChoice(int index) {
        return options.get(index);
    }

    /**
     * Returns a string representation of the Menu object.
     *
     * @return A formatted string containing the title of the menu.
     */
    @Override
    public String toString() {
        String msg = String.format("[Menu] : %s", title);
        return msg;
    }
}
