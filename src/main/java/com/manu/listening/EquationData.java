package com.manu.listening;

public class EquationData {

    private String a;

    private String b;

    private String eps;

    private String graphic;

    private String method;

    public EquationData() {
    }

    public EquationData(String a, String b, String eps, String graphic, String method) {
        this.a = a;
        this.b = b;
        this.eps = eps;
        this.graphic = graphic;
        this.method = method;
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
