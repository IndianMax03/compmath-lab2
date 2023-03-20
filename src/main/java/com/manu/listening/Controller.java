package com.manu.listening;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.manu.requestdata.EquationData;
import com.manu.requestdata.SystemData;
import com.manu.services.EquationService;
import com.manu.services.SystemService;
import org.springframework.web.bind.annotation.*;

@org.springframework.stereotype.Controller
public class Controller {

    EquationService equationService = new EquationService();
    SystemService systemService = new SystemService();

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
    public ObjectNode solveEquation(@RequestBody EquationData equationData) {
        return equationService.analyze(equationData);
    }

    @PostMapping("equations/solveNonLinearSystem")
    @ResponseBody
    public ObjectNode solveSystem(@RequestBody SystemData systemData) {
        return systemService.analyze(systemData);
    }

}
