package com.manu.listening;

import org.springframework.web.bind.annotation.*;

@org.springframework.stereotype.Controller
public class Controller {

    @GetMapping("/")
    public String homePage() {
        return "index";
    }

    @PostMapping("nonlinear")
    public String firstTask() {
        return "nonlinear";
    }

    @PostMapping("nonlinearsystem")
    public String secondTask() {
        return "nonlinearsystem";
    }

    @PostMapping("equations/solveNonLinear")
    @ResponseBody
    public String solveEquation(@RequestBody EquationData equationData) {
        return "Сервер получил данные: " + equationData.toString();
    }

    @PostMapping("equations/solveNonLinearSystem")
    @ResponseBody
    public String solveSystem(@RequestBody SystemData systemData) {
        return "Сервер получил данные: " + systemData.toString();
    }

}
