<%--
  Created by Manu aka Maxim.
  Date: 18.03.2023
  Time: 0:56
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="<c:url value="/webjars/bulma/0.9.4/css/bulma.min.css" />">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/KaTeX/0.7.1/katex.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/KaTeX/0.7.1/katex.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>

<section class="section">
    <div class="columns is-vcentered">
        <div class="column is-6">
            <div class="box is-square is-5 is-fullheight">

                <span class="is-size-4">Выберите систему нелинейных уравнений:</span>
                <div class="control">
                    <div class="py-6">
                        <label class="radio">
                            <input type="radio" id="baseballSystem" name="system" checked>
                            <span id="baseball" class="ml-5"></span>
                        </label>
                    </div>

                    <div class="pb-6">
                        <label class="radio">
                            <input type="radio" id="tennisSystem" name="system">
                            <span id="tennis" class="ml-5"></span>
                        </label>
                    </div>

                </div>

            </div>
        </div>

        <div class="column is-offset-1 is-4">
            <div class="box is-square is-5">
                <canvas id="graph"></canvas>
            </div>
        </div>

    </div>
</section>

<section class="section">
    <div class="columns is-vcentered">
        <div class="column is-5">
            <div class="columns is-multiline is-fullheight">
                <div class="column is-5 is-offset-2">
                    <div class="box is-square is-fullheight">
                        <span class="is-size-5">Введите данные:</span>
                        <div class="field">
                            <label class="label"><span id="aLabel"></span></label>
                            <div class="control">
                                <input id="a" class="input" type="text">
                            </div>
                        </div>
                        <div class="field">
                            <label class="label"><span id="bLabel"></span></label>
                            <div class="control">
                                <input id="b" class="input" type="text">
                            </div>
                        </div>
                        <div class="field">
                            <label class="label"><span id="xLabel"></span></label>
                            <div class="control">
                                <input id="x" class="input" type="text">
                            </div>
                        </div>
                        <div class="field">
                            <label class="label"><span id="epsLabel"></span></label>
                            <div class="control">
                                <input id="eps" class="input" type="text">
                            </div>
                        </div>

                    </div>

                    <div class="box has-text-centered">
                        <span class="is-size-6">Или загрузите JSON:</span>
                        <div class="file is-info is-small is-centered">
                            <label class="file-label">
                                <input id="dataFile" class="file-input" type="file" name="userData" multiple>
                                <span class="file-cta">
                                    <span class="file-label">Выбрать файл…</span>
                                </span>
                            </label>
                        </div>
                    </div>

                </div>
            </div>
        </div>
        <div class="column is-4 has-text-centered">
            <div class="box is-square is-fullheight">
                <div>
                    <div>
                        <span class="is-size-5">Выберите метод решения:</span>
                    </div>
                    <div class="select is-info my-6">
                        <select id="method">
                            <option id="simpleIteration" value="simpleIteration">Простой итерации</option>
                        </select>
                    </div>
                </div>
                <div class="mb-6">
                    <button id="submitButton" class="button is-info is-medium is-light">Найти корень!</button>
                </div>
            </div>
            <div id="submitHelper" class="notification is-danger has-text-left"
                 style="display: none; position: absolute">
                <button id="notificationButton" class="delete"></button>
                Произошла ошибка ввода данных. Убедитесь, что:
                <br>
                1. <span id="allIsNum">Данные - это числа</span>
                <br>
                2. <span id="aLessThanB"></span>
                <br>
                3. <span id="xBetweenAB"></span>
            </div>
        </div>

        <div class="column is-3 has-text-centered">
            <div class="box is-square is-fullheight">
                <div>
                    <span class="is-size-5">Найденный корень:</span>
                </div>
                <div>
                    <textarea id="foundedRoot" class="textarea my-6" rows="4" cols="40" readonly>Здесь будет найденный корень</textarea>
                </div>
                <div>
                    <a id="downloadingButton" download class="button is-info">Скачать файл</a>
                </div>
            </div>
        </div>
    </div>
</section>

<script src="<c:url value="/js/systems/formattingNonLinearSystems.js"/>"></script>
<script src="<c:url value="/js/systems/nonLinearSystemGraphic.js"/>"></script>
<script src="<c:url value="/js/systems/submitting.js"/>"></script>
<script src="<c:url value="/js/downloading.js"/>"></script>
<script src="<c:url value="/js/systems/uploading.js"/>"></script>

</body>
</html>
