package com.manu.functions.equations;

import com.manu.requestdata.EquationData;

public abstract class Function {

    protected static double lambda;

    public abstract double func(double x);

    public abstract double firstDerivative(double x);

    public abstract double secondDerivative(double x);

    public double phy(double x) {
        return x + lambda * func(x);
    }

    public double firstPhyDerivative(double x) {
        return 1 + lambda * firstDerivative(x);
    }

    public void setLambdaParam(double a, double b) {
        int DOTS_COUNT = EquationData.getDOTS_COUNT();

        double delta = (b - a) / DOTS_COUNT;
        double current = a;

        double maxValue = Math.abs(firstDerivative(current));
        current += delta;

        while (current <= b) {
            if (Math.abs(firstDerivative(current)) > maxValue) {
                maxValue = Math.abs(firstDerivative(current));
            }
            current += delta;
        }

        lambda = -1 / maxValue;
    }

}
