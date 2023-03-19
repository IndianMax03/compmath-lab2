$('#dataFile').on('change', function handleFileSelect(event) {

    let file = event.target.files[0];
    let reader = new FileReader();
    reader.onload = function (e) {

        const data = JSON.parse(e.target.result);
        let aElement = $('#a');
        let bElement = $('#b');
        let epsElement = $('#eps');

        let aStr = data.a.toString().replaceAll(" ", "");
        let bStr = data.b.toString().replaceAll(" ", "");
        let epsStr = data.eps.toString().replaceAll(" ", "");

        let a = aStr !== "" ? Number(aStr.replaceAll(",", ".")) : NaN;
        let b = bStr !== "" ? Number(bStr.replaceAll(",", ".")) : NaN;
        let eps = epsStr !== "" ? Number(epsStr.replaceAll(",", ".")) : NaN;

        if (!isNaN(a)) {
            aElement.val(a);
        }

        if (!isNaN(b)) {
            bElement.val(b);
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