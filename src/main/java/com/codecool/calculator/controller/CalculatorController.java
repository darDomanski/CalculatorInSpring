package com.codecool.calculator.controller;

import com.codecool.calculator.service.Abacus;
import com.codecool.calculator.view.TemplateRenderer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.script.ScriptException;

@Controller
@RequestMapping("calculator")
public class CalculatorController {

    @Autowired
    private TemplateRenderer templateRenderer;
    @Autowired
    private Abacus abacus;

    @RequestMapping(method = RequestMethod.GET)
    public String doGet(Model model) {
        templateRenderer.addAtributesToTemplate(model, 0);
        return "calculator";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String doPost(
            @RequestParam("first_number") String firstNum,
            @RequestParam("second_number") String secondNum,
            @RequestParam("operator") String operator,
            Model model)
            throws ScriptException {
        double firstNumber = Double.valueOf(firstNum);
        double secondNumber = Double.valueOf(secondNum);

        double result = abacus.count(firstNumber, secondNumber, operator);

        templateRenderer.addAtributesToTemplate(model, result);

        return "calculator";
    }
}
