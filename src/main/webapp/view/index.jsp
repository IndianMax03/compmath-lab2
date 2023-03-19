<%--
  Created by Manu aka Maxim.
  Date: 17.03.2023
  Time: 23:03
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>cm2</title>
    <link rel="stylesheet" href="<c:url value="/webjars/bulma/0.9.4/css/bulma.min.css" />">
</head>
<body>
<section class="section">
    <div class="box has-text-centered is-size-2">
        Лабораторная работа по Вычислительной Математике №2
    </div>
</section>
<section class="section has-text-centered">
    <div class="box has-text-centered">
        <div class="is-size-3">Выберите одну из предложенных реализаций программной части работы:</div>
        <div class="is-size-5">
            <div class="py-6">
                <form method="post" action="nonlinear">
                    <button type="submit" class="button is-text is-large is-light">Решение нелинейных уравнений</button>
                </form>
            </div>
            <div class="pb-6">
                <form method="post" action="nonlinearsystem">
                    <button type="submit" class="button is-text is-large is-light">Решение систем нелинейных уравнений
                    </button>
                </form>
            </div>
        </div>
    </div>
</section>
</body>
</html>
