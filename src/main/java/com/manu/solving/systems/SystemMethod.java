package com.manu.solving.systems;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.manu.functions.systems.System;

public interface SystemMethod {

    public ObjectNode solve(double x, double y, double eps, System system);

}
