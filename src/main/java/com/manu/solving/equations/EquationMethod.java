package com.manu.solving.equations;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.manu.functions.equations.Function;
import com.manu.requestdata.EquationData;

public interface EquationMethod {

    public ObjectNode solve(double a, double b, double eps, Function function);

}
