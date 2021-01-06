package com.shunyi.ddd.eas.employeecontext.domain;

import com.shunyi.ddd.eas.employeecontext.domain.exceptions.InvalidPhoneNumberException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author zhang
 * @create 2021-01-05 10:42
 */
public class Phone {
    private String number;

    /**
     * 手机号验证正则
     */
    private final String format = "^[1][3,4,5,7,8][0-9]{9}$";

    public String number() {
        return this.number;
    }

    public Phone(String number) {
        this.number = number;
    }

    private void validate(String number) {
        Pattern pattern = Pattern.compile(format);
        Matcher matcher = pattern.matcher(number);
        if (!matcher.matches()) {
            throw new InvalidPhoneNumberException(String.format("%s is invalid phone number.", number));
        }

    }
}