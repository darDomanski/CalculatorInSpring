package com.codecool.calculator.service;

import org.springframework.stereotype.Component;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

@Component
public class Abacus {
    public double count(Double firstNumber, Double secondNumber, String operator) throws ScriptException {
        String expression = firstNumber + operator + secondNumber;
        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("JavaScript");
        return (Double) engine.eval(expression);
    }
}
