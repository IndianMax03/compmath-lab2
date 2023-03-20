package com.manu.requestdata;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.manu.functions.equations.Function;
import com.manu.functions.equations.Logarithm;
import com.manu.solving.equations.EquationMethod;
import com.manu.validators.equations.EquationsValidator;

public class EquationData {

    private String a;

    private String b;

    private String eps;

    private String graphic;

    private String method;

    private double validA;

    private double validB;

    private double validEps;

    private Function function;

    private EquationMethod equationMethod;

    private static final int DOTS_COUNT = 50;

    public EquationData() {
    }

    public EquationData(String a, String b, String eps, String graphic, String method) {
        this.a = a;
        this.b = b;
        this.eps = eps;
        this.graphic = graphic;
        this.method = method;
    }

    public boolean setValidData() {
        try {
            this.validA = Double.parseDouble(this.a.replaceAll(",", "."));
            this.validB = Double.parseDouble(this.b.replaceAll(",", "."));
            this.validEps = Double.parseDouble(this.eps.replaceAll(",", "."));
            this.function = EquationsValidator.getFunction(this.graphic);
            this.equationMethod = EquationsValidator.getMethod(this.method);

            if (this.function == null || this.equationMethod == null) {
                throw new NumberFormatException();
            } else {
                function.setLambdaParam(validA, validB);
            }

        } catch (NumberFormatException exception) {
            return false;
        }

        return true;
    }

    public boolean checkLog() {
        if (Logarithm.class == function.getClass()) {
            return !(validA <= 0) && !(validB <= 0);
        }
        return true;
    }

    public boolean analyzeInterval() {
        if (function.func(validA) * function.func(validB) > 0) {
            return false;
        }
        double delta = (validB - validA) / DOTS_COUNT;
        double current = validA;
        double stop = validB;
        boolean flag = function.firstDerivative(current) > 0;
        current += delta;

        while (current <= stop) {
            if ((function.firstDerivative(current) > 0) != flag) {
                return false;
            }
            current += delta;
        }
        return true;
    }

    public ObjectNode solveEquation() {
        return equationMethod.solve(this.validA, this.validB, this.validEps, this.function);
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public String getEps() {
        return eps;
    }

    public void setEps(String eps) {
        this.eps = eps;
    }

    public String getGraphic() {
        return graphic;
    }

    public void setGraphic(String graphic) {
        this.graphic = graphic;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public double getValidA() {
        return validA;
    }

    public double getValidB() {
        return validB;
    }

    public double getValidEps() {
        return validEps;
    }

    public Function getFunction() {
        return function;
    }

    public EquationMethod getEquationMethod() {
        return equationMethod;
    }

    public static int getDOTS_COUNT() {
        return DOTS_COUNT;
    }

    @Override
    public String toString() {
        return "EquationData{" +
                "a='" + a + '\'' +
                ", b='" + b + '\'' +
                ", eps='" + eps + '\'' +
                ", graphic='" + graphic + '\'' +
                ", method='" + method + '\'' +
                '}';
    }
}
