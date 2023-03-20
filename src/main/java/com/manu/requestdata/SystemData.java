package com.manu.requestdata;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.manu.functions.systems.System;
import com.manu.solving.systems.SystemMethod;
import com.manu.validators.systems.SystemsValidator;

public class SystemData {

    private String x;

    private String y;

    private String eps;

    private String graphic;

    private String method;

    private double validX;

    private double validY;

    private double validEps;

    private System system;

    private SystemMethod systemMethod;

    public SystemData() {
    }

    public SystemData(String x, String y, String eps, String graphic, String method) {
        this.x = x;
        this.y = y;
        this.eps = eps;
        this.graphic = graphic;
        this.method = method;
    }

    public boolean setValidData() {
        try {
            this.validX = Double.parseDouble(this.x.replaceAll(",", "."));
            this.validY = Double.parseDouble(this.y.replaceAll(",", "."));
            this.validEps = Double.parseDouble(this.eps.replaceAll(",", "."));

            this.system = SystemsValidator.getSystem(this.graphic);
            this.systemMethod = SystemsValidator.getMethod(this.method);

            if (this.system == null || this.systemMethod == null) {
                throw new NumberFormatException();
            }

        } catch (NumberFormatException exception) {
            return false;
        }
        return true;
    }

    public boolean analyzeApproximation() {
        double firstSum = Math.abs(system.partialDerivativePhyxByX(validX, validY)) + Math.abs(system.partialDerivativePhyxByY(validX, validY));
        double secondSum = Math.abs(system.partialDerivativePhyyByX(validX, validY)) + Math.log(system.partialDerivativePhyyByY(validX, validY));
        return !(firstSum >= 1) && !(secondSum >= 1);
    }

    public ObjectNode solveSystem() {
        return systemMethod.solve(this.validX, this.validY, this.validEps, this.system);
    }

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public String getY() {
        return y;
    }

    public void setY(String y) {
        this.y = y;
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

    public double getValidX() {
        return validX;
    }

    public double getValidY() {
        return validY;
    }

    public double getValidEps() {
        return validEps;
    }

    public System getSystem() {
        return system;
    }

    public SystemMethod getSystemMethod() {
        return systemMethod;
    }

    @Override
    public String toString() {
        return "SystemData{" +
                "x='" + x + '\'' +
                ", y='" + y + '\'' +
                ", eps='" + eps + '\'' +
                ", graphic='" + graphic + '\'' +
                ", method='" + method + '\'' +
                '}';
    }

}
