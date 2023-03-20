package com.manu.functions.systems;

public class Tennis extends System {


    @Override
    public double x(double x, double y) {
        return y / Math.abs(y) * Math.sqrt(25 - y * y);
    }

    @Override
    public double y(double x, double y) {
        return 6 / x;
    }

    @Override
    public double partialDerivativePhyxByX(double x, double y) {
        return 0;
    }

    @Override
    public double partialDerivativePhyxByY(double x, double y) {
        return -y / (Math.sqrt(25 - y * y));
    }

    @Override
    public double partialDerivativePhyyByX(double x, double y) {
        return -6 / x / x;
    }

    @Override
    public double partialDerivativePhyyByY(double x, double y) {
        return 0;
    }
}
