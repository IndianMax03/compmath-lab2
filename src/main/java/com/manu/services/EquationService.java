package com.manu.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.manu.requestdata.EquationData;
import com.manu.validators.equations.EquationsValidator;

public class EquationService {

    public ObjectNode analyze(EquationData data) {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode node = mapper.createObjectNode();

        if (!EquationsValidator.validateData(data)) {
            node.put("error", "Сервер получил невалидные данные. Убедитесь в том, что вы отправляли числа и не меняли названия функций и методов их решения.");
            return node;
        }
        if (!data.setValidData()) {
            node.put("error", "Сервер не может корректно обработать переданные данные.");
            return node;
        }
        if (!data.checkLog()) {
            node.put("error", "В функцию логарифма не стоит передавать интервал, который может включать значения меньшие или равные нулю.");
            return node;
        }
        if (!data.analyzeInterval()) {
            node.put("error", "Не выполнено достаточное условие единственности корня на отрезке! Измените значения a и b.");
            return node;
        }

        return data.solveEquation();
    }

}
