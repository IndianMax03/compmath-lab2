package com.manu.validators.equations;

import com.manu.functions.equations.Function;
import com.manu.functions.equations.Logarithm;
import com.manu.functions.equations.Polynom;
import com.manu.functions.equations.Sinus;
import com.manu.requestdata.EquationData;
import com.manu.solving.equations.ChordMethod;
import com.manu.solving.equations.EquationMethod;
import com.manu.solving.equations.SecandMethod;
import com.manu.solving.equations.SimpleIterationMethod;

import java.util.HashMap;

public class EquationsValidator {

    private static final HashMap<String, Function> functions = new HashMap<>();
    private static final HashMap<String, EquationMethod> methods = new HashMap<>();

    static {
        functions.put("polynomial", new Polynom());
        functions.put("sinus", new Sinus());
        functions.put("logarithm", new Logarithm());

        methods.put("chord", new ChordMethod());
        methods.put("secand", new SecandMethod());
        methods.put("simpleIteration", new SimpleIterationMethod());
    }

    public static boolean validateData(EquationData data) {
        try {
            double a = Double.parseDouble(data.getA().replaceAll(",", "."));
            double b = Double.parseDouble(data.getB().replaceAll(",", "."));
            double eps = Double.parseDouble(data.getEps().replaceAll(",", "."));
            if (!(a < b) || eps < 0 || !(functions.containsKey(data.getGraphic()) || !(methods.containsKey(data.getMethod())))) {
                return false;
            }

        } catch (NumberFormatException ex) {
            return false;
        }
        return true;
    }

    public static Function getFunction(String functionName) {
        return functions.get(functionName);
    }

    public static EquationMethod getMethod(String methodName) {
        return methods.get(methodName);
    }

}
