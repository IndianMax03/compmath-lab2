package com.manu.functions.systems;

public abstract class System {

    public abstract double x(double x, double y);

    public abstract double y(double x, double y);

    public abstract double partialDerivativePhyxByX(double x, double y);

    public abstract double partialDerivativePhyxByY(double x, double y);

    public abstract double partialDerivativePhyyByX(double x, double y);

    public abstract double partialDerivativePhyyByY(double x, double y);

}
