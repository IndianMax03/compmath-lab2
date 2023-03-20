package com.manu.functions.equations;

public class Polynom extends Function {

    @Override
    public double func(double x) {
        return -2.8 * x * x * x - 3.48 * x * x + 10.23 * x + 9.35;
    }

    @Override
    public double firstDerivative(double x) {
        return -8.4 * x * x - 6.96 * x + 10.23;
    }

    @Override
    public double secondDerivative(double x) {
        return -16.8 * x - 6.96;
    }

}
