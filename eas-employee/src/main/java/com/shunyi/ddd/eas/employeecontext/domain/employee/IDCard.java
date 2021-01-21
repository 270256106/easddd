package com.shunyi.ddd.eas.employeecontext.domain.employee;

import com.shunyi.ddd.eas.employeecontext.utils.IDCardValidator;

/**
 * @author zhang
 * @create 2021-01-05 13:03
 */
public class IDCard {
    private String number;

    private static final int LENGTH_OF_ID_CARD = 18;

    public IDCard(String number) {
        IDCardValidator idCardValidator = new IDCardValidator(number);
        idCardValidator.validate();
        this.number = number;
    }

    public String number() {
        return this.number;
    }

    public boolean isMale() {
        return getGenderCode() % 2 == 1;
    }

    public boolean ifFemale() {
        return getGenderCode() % 2 == 0;
    }

    private int getGenderCode() {
        char genderFlag = number.charAt(LENGTH_OF_ID_CARD - 2);
        return Character.getNumericValue(genderFlag);
    }


}