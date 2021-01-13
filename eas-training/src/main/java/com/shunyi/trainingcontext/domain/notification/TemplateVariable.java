package com.shunyi.trainingcontext.domain.notification;

/**
 * @author zhang
 * @create 2021-01-11 16:15
 */
public class TemplateVariable {
    private final String name;
    private final String value;

    public TemplateVariable(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public static TemplateVariable with(String name, String value) {
        return new TemplateVariable(name, value);
    }

    public String name() {
        return name;
    }

    public String value() {
        return value;
    }
}