package com.shunyi.trainingcontext.domain.notification;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * @author zhang
 * @create 2021-01-08 18:03
 */
public class VariableContext {
    private Map<String, Object> variables = new HashMap<>();

    public void put(String variableName, Object dataHolder) {
        variables.putIfAbsent(variableName.toLowerCase(), dataHolder);
    }

    public <T> T get(String vriableName) {
        return (T) variables.get(vriableName);
    }
}