package com.manu.functions.equations;

public class Logarithm extends Function {

    @Override
    public double func(double x) {
        if (x <= 0) {
            return Double.MIN_VALUE;
        }
        return Math.log(x);
    }

    @Override
    public double firstDerivative(double x) {
        return 1 / x;
    }

    @Override
    public double secondDerivative(double x) {
        return -1 / x / x;
    }

}
