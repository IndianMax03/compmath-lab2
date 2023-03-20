package com.manu.functions.equations;

public class Sinus extends Function {

    @Override
    public double func(double x) {
        return Math.sin(x);
    }

    @Override
    public double firstDerivative(double x) {
        return Math.cos(x);
    }

    @Override
    public double secondDerivative(double x) {
        return -Math.sin(x);
    }

}
