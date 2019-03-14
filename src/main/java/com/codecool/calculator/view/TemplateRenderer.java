package com.codecool.calculator.view;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

@Component
public class TemplateRenderer {
    public void addAtributesToTemplate(Model model, double result) {
        model.addAttribute("result", result);
    }
}
