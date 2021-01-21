package com.shunyi.ddd.eas.employeecontext.domain.employee;

import com.google.common.base.Strings;
import com.shunyi.ddd.eas.employeecontext.domain.exceptions.InvalidEmployeeIdException;
import com.shunyi.ddd.eas.employeecontext.utils.DateTimes;

import java.time.LocalDate;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author zhang
 * @create 2021-01-05 15:31
 */
public class EmployeeId {

    private final String id;
    private final String format = "^([0-9]{4})$";

    public EmployeeId(String id) {
        validate(id);
        this.id = id;
    }

    public static EmployeeId form(String id) {
        return new EmployeeId(id);
    }

    private void validate(String id) {
        validateNullOrEmpty(id);
        validateLength(id);
        validateOnBoardingDate(id);
        validateSequenceCode(id);
    }

    private void validateSequenceCode(String id) {
        String sequenceCode = id.substring(8);
        Pattern pattern = Pattern.compile(format);
        Matcher matcher = pattern.matcher(sequenceCode);
        if (!matcher.matches()) {
            throw new InvalidEmployeeIdException("Sequence code of employee id is invalid.");
        }
    }

    private void validateOnBoardingDate(String id) {
        String onBoardingDate = id.substring(0, 8);
        LocalDate minDate = LocalDate.of(1989, 12, 31);
        LocalDate maxDate = LocalDate.now();
        if (!DateTimes.isValidFormat(onBoardingDate, minDate, maxDate)) {
            throw new InvalidEmployeeIdException("On boarding date of employee id is invalid.");
        }
    }

    private void validateLength(String id) {
        if (id.length() != 12) {
            throw new InvalidEmployeeIdException("The length of employee id should be 12.");
        }
    }

    private void validateNullOrEmpty(String id) {
        if (Strings.isNullOrEmpty(id)) {
            throw new InvalidEmployeeIdException("Employee id should not be null or empty.");
        }
    }

    public String sequenceNo() {
        return id.substring(id.length() - 4);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        EmployeeId that = (EmployeeId) obj;
        return id.equals(that.id);
    }

    @Override
    public String toString() {
        return String.format("Employee Id is %s", id);
    }
}