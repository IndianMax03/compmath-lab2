package com.manu.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.manu.requestdata.SystemData;
import com.manu.validators.systems.SystemsValidator;

public class SystemService {

    public ObjectNode analyze(SystemData data) {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode node = mapper.createObjectNode();

        if (!SystemsValidator.validateData(data)) {
            node.put("error", "Сервер получил невалидные данные. Убедитесь в том, что вы отправляли числа и не меняли названия систем и методов их решения.");
            return node;
        }

        if (!data.setValidData()) {
            node.put("error", "Сервер не может корректно обработать переданные данные.");
            return node;
        }

        if (!data.analyzeApproximation()) {
            node.put("error", "Не выполнено достаточное условие сходимости. Попробуйте изменить приближение или погрешность.");
            return node;
        }

        return data.solveSystem();
    }

}
