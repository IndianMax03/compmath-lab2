package com.manu.solving.equations;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.manu.functions.equations.Function;

public class SimpleIterationMethod implements EquationMethod {

    private final int MAX_ITERATION = 100000000;

    @Override
    public ObjectNode solve(double a, double b, double eps, Function function) {
        ObjectNode node = new ObjectMapper().createObjectNode();
        int iterations = 0;
        double answer;

        double xZero;

        int condition = checkConvergenceCondition(a, b, function);
        if (condition == 1) {
            xZero = a;
        } else if (condition == 0) {
            xZero = b;
        } else {
            node.put("error", "Для метода простой итерации не выполняется достаточное условие сходимости. Попробуйте изменить интервал.");
            return node;
        }

        double xCur = 0;

        do {
            if (iterations != 0) {
                xZero = xCur;
            }
            xCur = function.phy(xZero);
            answer = xCur;
            iterations++;
            if (iterations == MAX_ITERATION) {
                node.put("error", "Метод простой итерации не справился за " + MAX_ITERATION + " итераций.");
                return node;
            }
        } while (Math.abs(xCur - xZero) > eps);

        if (Double.isNaN(answer) || Double.isNaN(function.func(answer))) {
            node.put("error", "Метод простой итерации разошелся на " + iterations + " итерации. Попробуйте изменить приближение epsilon.");
            return node;
        }

        node.put("x", answer);
        node.put("f(x)", function.func(answer));
        node.put("iterations", iterations);

        return node;
    }

    private int checkConvergenceCondition(double a, double b, Function function) {
        if (Math.abs(function.firstPhyDerivative(a)) < 1) {
            return 1;
        } else if (Math.abs(function.firstPhyDerivative(b)) < 1) {
            return 0;
        } else {
            return -1;
        }
    }

}
