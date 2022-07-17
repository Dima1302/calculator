package com.example.calculator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import service.CalculatorService;

@RestController
@RequestMapping("calculator")

public class CalculatorController {

    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping
    public String greetings() {
        return "Добро пожаловать в калькулятор";
    }

    @GetMapping("/plus")
    public String plus(@RequestParam(required = false) Integer a,
                       @RequestParam(required = false) Integer b) {
        if (a == null || b == null) {
            return "Какой то из параметров не передан";
        }
        return a + " + " + b + " = " + calculatorService.plus(a, b);
    }

    @GetMapping("/minus")
    public String minus(@RequestParam(required = false) Integer a,
                        @RequestParam(required = false) Integer b) {
        if (a == null || b == null) {
            return "Какой то из параметров не передан";
        }
        return a + " - " + b + " = " + calculatorService.minus(a, b);
    }

    @GetMapping("/multiply")
    public String multiply(@RequestParam(required = false) Integer a,
                           @RequestParam(required = false) Integer b) {
        if (a == null || b == null) {
            return "Какой то из параметров не передан";
        }
        return a + " * " + b + " = " + calculatorService.multiply(a, b);
    }

    @GetMapping("/divide")
    public String divide(@RequestParam(required = false) Integer a,
                         @RequestParam(required = false) Integer b) {
        if (a == null || b == null) {
            return "Какой то из параметров не передан";
        }
        if ((b == 0)) {
            return "Делить на ноль нельзя";
        }
        return a + " / " + b + " = " + calculatorService.divide(a, b);
    }


}
