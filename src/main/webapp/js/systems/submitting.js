const submitButton = document.getElementById("submitButton");
const notificationButton = document.getElementById("notificationButton");
const submitHelper = document.getElementById("submitHelper");


submitButton.addEventListener("click", (evt) => {

    evt.preventDefault();

    let aStr = $('#a').val().replaceAll(" ", "");
    let bStr = $('#b').val().replaceAll(" ", "");
    let xStr = $('#x').val().replaceAll(" ", "");
    let epsStr = $('#eps').val().replaceAll(" ", "");

    let baseballSystem = document.getElementById("baseballSystem").checked;
    let tennisSystem = document.getElementById("tennisSystem").checked;
    let selectedMethod = document.querySelector("#method").value;

    let a = aStr !== "" ? Number(aStr.replaceAll(",", ".")) : NaN;
    let b = bStr !== "" ? Number(bStr.replaceAll(",", ".")) : NaN;
    let x = xStr !== "" ? Number(xStr.replaceAll(",", ".")) : NaN;
    let eps = epsStr !== "" ? Number(epsStr.replaceAll(",", ".")) : NaN;

    let isValid = true;

    if (isNaN(a) || isNaN(b) || isNaN(x) || isNaN(eps)) {
        isValid = false;
        console.log(a, b, eps);
    }

    if (isValid) {
        if (!(a < b) || x > b || x < a || eps < 0) {
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
        a: aStr.replaceAll(",", "."),
        b: bStr.replaceAll(",", "."),
        x: xStr.replaceAll(",", "."),
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
            answerToUser.value = result;
            // if (result.error !== undefined) {
            //     answerToUser.value = result.error;
            // } else {
            //     if (result.x === undefined || result['f(x)'] === undefined || result.iterations === undefined) {
            //         answerToUser.value = "Сервер ответил неожиданными данными..."
            //         return;
            //     }
            //     answerToUser.value = `x = ${result.x}\nf(x) = ${result['f(x)']}\niterations = ${result.iterations}`;
            // }
        },
        error: function (xhr, status, error) {
            answerToUser.innerText = "Упс! Ошибочка. " + error;
        }
    })

});

notificationButton.addEventListener("click", () => {
    submitHelper.style.display = "none";
})
