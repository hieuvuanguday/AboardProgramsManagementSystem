/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.util.Date;
import utilities.DateModifier;

/**
 *
 * @author Administrator
 */
public class Program implements Comparable<Program> {

    private String id;
    private String name;
    private String time;
    private Date beginDate;
    private Date endDate;
    private int days;
    private String location;
    private double cost;
    private String content;

    /**
     * Constructs a new Program object with the provided details.
     *
     * @param id The ID of the program.
     * @param name The name of the program.
     * @param time The time of the program.
     * @param beginDate The start date of the program.
     * @param endDate The end date of the program.
     * @param days The number of days the program lasts.
     * @param location The location of the program.
     * @param cost The cost of the program.
     * @param content The content or description of the program.
     */
    public Program(String id, String name, String time, Date beginDate, Date endDate, int days, String location, double cost, String content) {
        this.id = id;
        this.name = name;
        this.time = time;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.days = days;
        this.location = location;
        this.cost = cost;
        this.content = content;
    }

    /**
     * Retrieves the ID of the program.
     *
     * @return The ID of the program.
     */
    public String getId() {
        return id;
    }

    /**
     * Retrieves the name of the program.
     *
     * @return The name of the program.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the program.
     *
     * @param name The new name of the program.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retrieves the time of the program.
     *
     * @return The time of the program.
     */
    public String getTime() {
        return time;
    }

    /**
     * Sets the time of the program.
     *
     * @param time The new time of the program.
     */
    public void setTime(String time) {
        this.time = time;
    }

    /**
     * Retrieves the beginDate of the program.
     *
     * @return The beginDate of the program.
     */
    public Date getBeginDate() {
        return beginDate;
    }

    /**
     * Sets the beginDate of the program.
     *
     * @param beginDate The new beginDate of the program.
     */
    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    /**
     * Retrieves the endDate of the program.
     *
     * @return The endDate of the program.
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * Sets the endDate of the program.
     *
     * @param endDate The new endDate of the program.
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * Retrieves the location of the program.
     *
     * @return The location of the program.
     */
    public String getLocation() {
        return location;
    }

    /**
     * Sets the location of the program.
     *
     * @param location The new location of the program.
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * Retrieves the cost of the program.
     *
     * @return The cost of the program.
     */
    public double getCost() {
        return cost;
    }

    /**
     * Sets the cost of the program.
     *
     * @param cost The new cost of the program.
     */
    public void setCost(double cost) {
        this.cost = cost;
    }

    /**
     * Retrieves the days of the program.
     *
     * @return The days of the program.
     */
    public int getDays() {
        return days;
    }

    /**
     * Sets the days of the program.
     *
     * @param days The new days of the program.
     */
    public void setDays(int days) {
        this.days = days;
    }

    /**
     * Retrieves the content of the program.
     *
     * @return The content of the program.
     */
    public String getContent() {
        return content;
    }

    /**
     * Sets the content of the program.
     *
     * @param content The new content of the program.
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * Returns a string representation of the program object. The string
     * contains the values of the program's ID, name, time, begin date, end
     * date, number of days, location, cost, and content, separated by commas.
     * The begin and end dates are formatted using the default date format.
     *
     * @return A string representation of the program object.
     */
    @Override
    public String toString() {
        String ret = String.format("%s,%s,%s,%s,%s,%d,%s,%f,%s",
                id, name, time, DateModifier.toDateString(beginDate, null),
                DateModifier.toDateString(endDate, null), days, location, cost, content);
        return ret;
    }

    /**
     * Displays the program's information in a formatted table-like format. The
     * information displayed includes the program's ID, name, time, begin date,
     * end date, number of days, location, and cost. The information is printed
     * to the console.
     */
    public void display() {
//      |Program id|    Program name    |Time      |Begin Date| End Date |     Days     |Location                           |Cost    |
//      |%-10s|%-20s|%-10s|%10s|%10s|%14s|%-35s|%6.2f|                 |     Days     |
        String line = String.format("|%-10s|%-20s|%-10s|%10s|%10s|%-14d|%-35s|%6.2f$|",
                id, name, time, DateModifier.toDateString(beginDate, null),
                DateModifier.toDateString(endDate, null), days, location, cost);
        System.out.println(line);
    }

    /**
     * Compares this program object with the specified program object based on
     * their IDs.
     *
     * @param o The program object to compare.
     * @return A negative integer, zero, or a positive integer as this program's
     * ID is less than, equal to, or greater than the specified program's ID.
     */
    @Override
    public int compareTo(Program o) {
        return this.id.compareTo(o.id);
    }
}
