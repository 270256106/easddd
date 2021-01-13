package com.shunyi.ddd.core.domain;

import com.sun.org.apache.regexp.internal.RE;

import java.util.Objects;

/**
 * @author zhang
 * @create 2021-01-11 16:29
 */
public class AbstractIdentity<T> implements Identity<T> {
    private  T value;

    public AbstractIdentity(T value) {
        this.setId(value);
    }

    private void setId(T value) {
        if (value == null) {
            throw new IllegalArgumentException("The identity is required");
        }
        this.validateValue(value);
        this.value = value;
    }

    private void validateValue(T value) {
        //validate value of Identity need
    }

    @Override
    public T value() {
        return value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AbstractIdentity<?> that = (AbstractIdentity<?>) obj;
        return value.equals(that.value);

    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "[id=" + value + "]";
    }
}