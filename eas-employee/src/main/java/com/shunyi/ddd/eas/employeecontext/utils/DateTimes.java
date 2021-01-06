package com.shunyi.ddd.eas.employeecontext.utils;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * @author zhang
 * @create 2021-01-05 13:47
 */
public class DateTimes {

    public static boolean isValidFormat(String dateString, LocalDate minDate, LocalDate maxDate) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        try {
            LocalDate date = LocalDate.parse(dateString, dateFormatter);
            return date.isAfter(minDate) && (date.isBefore(maxDate) || date.equals(maxDate));
        } catch (DateTimeParseException e) {
            return false;
        }
    }
}