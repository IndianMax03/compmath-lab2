const submitButton = document.getElementById("submitButton");
const notificationButton = document.getElementById("notificationButton");
const submitHelper = document.getElementById("submitHelper");


submitButton.addEventListener("click", (evt) => {

    evt.preventDefault();

    let xStr = $('#x').val().replaceAll(" ", "");
    let yStr = $('#y').val().replaceAll(" ", "");
    let epsStr = $('#eps').val().replaceAll(" ", "");

    let baseballSystem = document.getElementById("baseballSystem").checked;
    let tennisSystem = document.getElementById("tennisSystem").checked;
    let selectedMethod = document.querySelector("#method").value;

    let x = xStr !== "" ? Number(xStr.replaceAll(",", ".")) : NaN;
    let y = yStr !== "" ? Number(yStr.replaceAll(",", ".")) : NaN;
    let eps = epsStr !== "" ? Number(epsStr.replaceAll(",", ".")) : NaN;

    let isValid = true;

    if (isNaN(x) || isNaN(y) || isNaN(eps)) {
        isValid = false;
    }

    if (isValid) {
        if (eps < 0) {
            isValid = false;
        }
    }

    if (!isValid) {
        submitHelper.style.display = "block";
        return;
    } else {
        submitHelper.style.display = "none";
    }

    // console.log(a, b/*, x */, eps, isValid);

    // Отправка на сервер с учетом выбранного графика.

    let data = {
        x: xStr.replaceAll(",", "."),
        y: yStr.replaceAll(",", "."),
        eps: epsStr.replaceAll(",", "."),
        graphic: baseballSystem ? "baseball" : tennisSystem ? "tennis" : null,
        method: selectedMethod,
    };

    let answerToUser = document.getElementById("foundedRoot");

    $.ajax({
        type: "POST",
        url: "equations/solveNonLinearSystem",
        data: JSON.stringify(data),
        contentType: "application/json",
        dataType: "json",
        success: function (result) {
            // console.log(result);
            if (result.error !== undefined) {
                answerToUser.value = result.error;
            } else {
                if (
                    result.answerX === undefined ||
                    result.answerY === undefined ||
                    result.approximationX === undefined ||
                    result.approximationY === undefined ||
                    result.iterations === undefined
                ) {
                    answerToUser.value = "Сервер ответил неожиданными данными..."
                    return;
                }
                answerToUser.value = `(x; y):\n(${result.answerX}; ${result.answerY})\n(vX; vY):\n(${result.approximationX}; ${result.approximationY})\niterations = ${result.iterations}`;
            }
        },
        error: function (xhr, status, error) {
            answerToUser.innerText = "Упс! Ошибочка. " + error;
        }
    })

});

notificationButton.addEventListener("click", () => {
    submitHelper.style.display = "none";
})
