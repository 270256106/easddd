package com.shunyi.ddd.eas.employeecontext.domain;


import com.shunyi.ddd.eas.employeecontext.domain.employee.Phone;
import com.shunyi.ddd.eas.employeecontext.domain.exceptions.InvalidPhoneNumberException;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class PhoneTest {
    @Test
    public void should_throw_InvalidPhoneNumberException_give_wrong_phone_number() {
        assertThatThrownBy(() -> new Phone("11111111111"))
                .isInstanceOf(InvalidPhoneNumberException.class)
                .hasMessageContaining("invalid phone number");
    }

    @Test
    public void should_set_number_given_correct_phone_number() {
        String phoneNumber = "18511790919";
        Phone phone = new Phone(phoneNumber);

        assertThat(phone.number()).isEqualTo(phoneNumber);
    }

}