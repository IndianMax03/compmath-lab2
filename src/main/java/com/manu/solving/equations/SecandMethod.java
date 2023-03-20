package com.manu.solving.equations;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.manu.functions.equations.Function;

public class SecandMethod implements EquationMethod {

    private final int MAX_ITERATION = 100000000;

    @Override
    public ObjectNode solve(double a, double b, double eps, Function function) {
        ObjectNode node = new ObjectMapper().createObjectNode();

        int iterations = 1;

        double xZero;

        if (function.func(a) * function.secondDerivative(a) > 0) {
            xZero = a;
        } else if (function.func(b) * function.secondDerivative(b) > 0) {
            xZero = b;
        } else {
            xZero = a + 0.001;
        }

        double xOne = xZero - function.func(xZero) / function.firstDerivative(xZero);

        double answer;
        double xNext = 0;

        do {
            if (iterations != 1) {
                xZero = xOne;
                xOne = xNext;
            }
            xNext = xOne - (xOne - xZero) / (function.func(xOne) - function.func(xZero)) * function.func(xOne);
            iterations++;
            if (iterations == MAX_ITERATION) {
                node.put("error", "Метод секущих не справился за " + MAX_ITERATION + " итераций");
                return node;
            }
            answer = xNext;
        } while (Math.abs(xNext - xOne) > eps || Math.abs(function.func(xNext)) > eps);

        if (Double.isNaN(answer) || Double.isNaN(function.func(answer))) {
            node.put("error", "Метод секущих разошелся на " + iterations + " итерации. Попробуйте изменить приближение epsilon.");
            return node;
        }
        node.put("x", answer);
        node.put("f(x)", function.func(answer));
        node.put("iterations", iterations);

        return node;
    }
}
