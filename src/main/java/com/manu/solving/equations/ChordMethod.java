package com.manu.solving.equations;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.manu.functions.equations.Function;

public class ChordMethod implements EquationMethod {
    private final int MAX_ITERATION = 1000000;

    @Override
    public ObjectNode solve(double a, double b, double eps, Function function) {
        ObjectNode node = new ObjectMapper().createObjectNode();

        int iterations = 0;
        double preX;
        double futX;
        double answer;

        do {

            preX = calculateX(a, b, function);
            if (a * preX < 0) {
                b = preX;
            } else {
                a = preX;
            }
            futX = calculateX(a, b, function);
            preX = futX;
            answer = futX;
            iterations++;
            if (iterations == MAX_ITERATION) {
                node.put("error", "Метод хорд не справился за " + MAX_ITERATION + " итераций.");
                return node;
            }

        } while (Math.abs(futX - preX) > eps || Math.abs(a - b) > eps || Math.abs(function.func(futX)) > eps);

        if (Double.isNaN(answer) || Double.isNaN(function.func(answer))) {
            node.put("error", "Метод хорд разошелся на " + iterations + " итерации. Попробуйте изменить приближение epsilon.");
            return node;
        }

        node.put("x", answer);
        node.put("f(x)", function.func(answer));
        node.put("iterations", iterations);

        return node;
    }

    private double calculateX(double a, double b, Function function) {
        return (a * function.func(b) - b * function.func(a)) / (function.func(b) - function.func(a));
    }

}
