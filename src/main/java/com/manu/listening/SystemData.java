package com.manu.listening;

public class SystemData {

    private String a;

    private String b;

    private String x;

    private String eps;

    private String graphic;

    private String method;

    public SystemData() {
    }

    public SystemData(String a, String b, String x, String eps, String graphic, String method) {
        this.a = a;
        this.b = b;
        this.eps = eps;
        this.x = x;
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

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    @Override
    public String toString() {
        return "SystemData{" +
                "a='" + a + '\'' +
                ", b='" + b + '\'' +
                ", x='" + x + '\'' +
                ", eps='" + eps + '\'' +
                ", graphic='" + graphic + '\'' +
                ", method='" + method + '\'' +
                '}';
    }
}
