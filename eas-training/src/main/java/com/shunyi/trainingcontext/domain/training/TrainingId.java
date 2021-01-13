package com.shunyi.trainingcontext.domain.training;

import com.shunyi.ddd.core.domain.Identity;

import java.util.Objects;
import java.util.UUID;

/**
 * @author zhang
 * @create 2021-01-11 16:27
 */
public class TrainingId implements Identity {
    private String value;

    public TrainingId(String value) {
        this.value = value;
    }

    public static TrainingId from(String value) {
        return new TrainingId(value);
    }

    public static TrainingId next() {
        return new TrainingId(UUID.randomUUID().toString());
    }

    @Override
    public String value() {
        return this.value;
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
        TrainingId that = (TrainingId) obj;
        return value.equals(that.value);
    }

    @Override
    public String toString() {
        return value;
    }
}