/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Administrator
 */
public class DateModifier {

    /**
     * Converts the provided Date object to a string representation using the
     * specified format.
     *
     * @param date The Date object to be converted.
     * @param format The format string specifying the desired date format. If
     * null, the default format "dd/MM/yyyy" is used.
     * @return A string representation of the Date object in the specified
     * format.
     */
    public static String toDateString(Date date, String format) {
        if (format == null) {
            format = "dd/MM/yyyy";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    /**
     * Converts the provided string representation of a date to a Date object
     * using the specified format.
     *
     * @param date The string representation of the date.
     * @param format The format string specifying the format of the date. If
     * null, the default format "dd/MM/yyyy" is used.
     * @return A Date object representing the parsed date.
     * @throws ParseException If the provided date string cannot be parsed
     * according to the specified format.
     */
    public static Date toDate(String date, String format) throws ParseException {
        if (format == null) {
            format = "dd/MM/yyyy";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date ret = sdf.parse(date);
        return ret;
    }

    /**
     * Checks if the provided current date falls within the specified start and
     * end dates, inclusively.
     *
     * @param start The start date of the range. If null, the range is
     * considered unbounded at the lower end.
     * @param end The end date of the range. If null, the range is considered
     * unbounded at the upper end.
     * @param current The current date to be checked.
     * @return True if the current date is within the range, false otherwise.
     */
    public static boolean inRange(Date start, Date end, Date current) {
        if (end == null) {
            return start.equals(current) || start.before(current);
        } else if (start == null) {
            return end.equals(current) || end.after(current);
        } else {
            boolean afterStart = start.equals(current) || start.before(current);
            boolean beforeEnd = end.equals(current) || end.after(current);
            return afterStart && beforeEnd;
        }
    }
}
