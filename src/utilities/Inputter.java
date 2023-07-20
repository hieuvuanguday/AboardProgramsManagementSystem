/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilities;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Administrator
 */
public class Inputter {

    public static Scanner sc = new Scanner(System.in);
    public static boolean flag = true;

    /**
     * Prompts the user to enter a string value based on the provided input
     * message. Validates the input against the specified format and displays an
     * error message if the input does not match the format. Returns the entered
     * string if it matches the format.
     *
     * @param iMsg The input message displayed to the user.
     * @param oMsg The error message displayed if the input does not match the
     * format.
     * @param format The regular expression format used to validate the input.
     * @return The entered string if it matches the format.
     */
    public static String getString(String iMsg, String oMsg, String format) {
        flag = true;
        String str = "";
        while (flag) {
            System.out.print(iMsg);
            str = sc.nextLine();
            if (str.matches(format)) {
                flag = false;
            } else {
                System.out.println(oMsg);
            }
        }
        return str;
    }

    /**
     * Prompts the user to enter a non-empty string value based on the provided
     * input message. Displays an error message if the entered string is empty
     * or contains only whitespace characters. Returns the entered string if it
     * is non-empty.
     *
     * @param iMsg The input message displayed to the user.
     * @param oMsg The error message displayed if the entered string is empty or
     * contains only whitespace characters.
     * @return The entered string if it is non-empty.
     */
    public static String getString(String iMsg, String oMsg) {
        flag = true;
        String str = "";
        while (flag) {
            System.out.print(iMsg);
            str = sc.nextLine();
            if (!str.trim().isEmpty()) {
                flag = false;
            } else {
                System.out.println(oMsg);
            }
        }
        return str;
    }

    public static Date getDate(String inputMsg) {
        flag = true;
        Date outputDate = null;
        while (flag) {
            try {
                System.out.print(inputMsg);
                String inputStr = sc.nextLine();
                DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                formatter.setLenient(false);
                outputDate = formatter.parse(inputStr);
                flag = false;
            } catch (ParseException e) {
                System.out.println("Invalid date: (dd/MM/yyyy)");
            }
        }
        return outputDate;
    }
}
