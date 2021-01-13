package com.shunyi.trainingcontext.domain.course;

import com.shunyi.ddd.core.domain.AbstractIdentity;

import java.util.UUID;

/**
 * @author zhang
 * @create 2021-01-11 16:28
 */
public class CourseId extends AbstractIdentity<String> {
    private String value;

    public CourseId(String value) {
        super(value);
    }

    public static CourseId from(String value) {
        return new CourseId(value);
    }

    public static CourseId next() {
        return new CourseId(UUID.randomUUID().toString());
    }
}