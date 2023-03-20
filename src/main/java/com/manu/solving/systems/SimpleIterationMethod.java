package com.manu.solving.systems;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.manu.functions.systems.System;

public class SimpleIterationMethod implements SystemMethod {

    private final int MAX_ITERATION = 100000000;

    @Override
    public ObjectNode solve(double x, double y, double eps, System system) {
        ObjectNode node = new ObjectMapper().createObjectNode();
        int iterations = 0;
        double answerX;
        double answerY;

        double xPrev = x;
        double yPrev = y;

        double xI = 0;
        double yI = 0;

        do {
            if (iterations != 0) {
                xPrev = xI;
                yPrev = yI;
            }
            xI = system.x(xPrev, yPrev);
            yI = system.y(xPrev, yPrev);
            iterations++;
            answerX = xI;
            answerY = yI;

            if (iterations == MAX_ITERATION) {
                node.put("error", "Метод простой итерации не справился за " + MAX_ITERATION + " итераций.");
                return node;
            }
        } while (Math.max(Math.abs(xI - xPrev), Math.abs(yI - yPrev)) > eps);

        if (Double.isNaN(answerX) || Double.isNaN(answerY)) {
            node.put("error", "Метод простой итерации разошелся на " + iterations + " итерации. Попробуйте изменить приближение epsilon.");
            return node;
        }

        node.put("answerX", answerX);
        node.put("answerY", answerY);
        node.put("approximationX", Math.abs(xI - xPrev));
        node.put("approximationY", Math.abs(yI - yPrev));
        node.put("iterations", iterations);

        return node;
    }
}
