$('#dataFile').on('change', function handleFileSelect(event) {

    let file = event.target.files[0];
    let reader = new FileReader();
    reader.onload = function (e) {

        const data = JSON.parse(e.target.result);
        let xElement = $('#x');
        let yElement = $('#y');
        let epsElement = $('#eps');

        let xStr = data.x.toString().replaceAll(" ", "");
        let yStr = data.y.toString().replaceAll(" ", "");
        let epsStr = data.eps.toString().replaceAll(" ", "");

        let x = xStr !== "" ? Number(xStr.replaceAll(",", ".")) : NaN;
        let y = yStr !== "" ? Number(yStr.replaceAll(",", ".")) : NaN;
        let eps = epsStr !== "" ? Number(epsStr.replaceAll(",", ".")) : NaN;

        if (!isNaN(x)) {
            xElement.val(x);
        }

        if (!isNaN(y)) {
            yElement.val(y);
        }

        if (!isNaN(eps)) {
            epsElement.val(eps);
        }

        $('#dataFile').off('change', handleFileSelect);
        $('#dataFile').val('');
        $('#dataFile').on('change', handleFileSelect);
    };
    reader.readAsText(file);
});