/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author Administrator
 */
public class Student implements Comparable<Student> {

    private String id;
    private String name;
    private String major;
    private String email;
    private String phone;
    private String address;
    private String passport;

    /**
     * Constructs a new Student object with the provided details.
     *
     * @param id The ID of the student.
     * @param name The name of the student.
     * @param major The major of the student.
     * @param email The email address of the student.
     * @param phone The phone number of the student.
     * @param passport The passport number of the student.
     * @param address The address of the student.
     */
    public Student(String id, String name, String major, String email, String phone, String passport, String address) {
        this.id = id;
        this.name = name;
        this.major = major;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.passport = passport;
    }

    /**
     * Retrieves the ID of the student.
     *
     * @return The ID of the student.
     */
    public String getId() {
        return id;
    }

    /**
     * Retrieves the name of the student.
     *
     * @return The name of the student.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the student.
     *
     * @param name The new name of the student.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retrieves the major of the student.
     *
     * @return The major of the student.
     */
    public String getMajor() {
        return major;
    }

    /**
     * Sets the major of the student.
     *
     * @param major The new major of the student.
     */
    public void setMajor(String major) {
        this.major = major;
    }

    /**
     * Retrieves the email of the student.
     *
     * @return The email of the student.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email of the student.
     *
     * @param email The new email of the student.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Retrieves the phone of the student.
     *
     * @return The phone of the student.
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Sets the phone of the student.
     *
     * @param phone The new phone of the student.
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Retrieves the address of the student.
     *
     * @return The address of the student.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the address of the student.
     *
     * @param address The new address of the student.
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Retrieves the passport of the student.
     *
     * @return The passport of the student.
     */
    public String getPassport() {
        return passport;
    }

    /**
     * Sets the passport of the student.
     *
     * @param passport The new passport of the student.
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * Displays the student's information in a formatted table-like format. The
     * information displayed includes the student's ID, name, major, email,
     * phone number, passport number, and address. The information is printed to
     * the console.
     */
    public void display() {
//        |Student id|Student Name        |Major|Email                         |Phone     |Passport  |Address        |
//        |%-10s|%-20s|%5s|%30s|%10s|%-10s|%-15s|
        String line = String.format("|%-10s|%-20s|%5s|%30s|%10s|%-10s|%-15s|",
                id, name, major, email, phone, passport, address);
        System.out.println(line);
    }

    /**
     * Compares this student object with the specified student object based on
     * their IDs.
     *
     * @param o The student object to compare.
     * @return A negative integer, zero, or a positive integer as this student's
     * ID is less than, equal to, or greater than the specified student's ID.
     */
    @Override
    public int compareTo(Student o) {
        return this.id.compareTo(o.id);
    }

    /**
     * Returns a string representation of the student object. The string
     * contains the values of the student's ID, name, major, email, phone
     * number, passport number, and address, separated by commas.
     *
     * @return A string representation of the student object.
     */
    @Override
    public String toString() {
        String ret = String.format("%s,%s,%s,%s,%s,%s,%s",
                id, name, major, email, phone, passport, address);
        return ret;
    }
}
