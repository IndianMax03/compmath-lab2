const downloadButton = document.getElementById("downloadingButton");

downloadButton.addEventListener('click', () => {
    // Редактирование файла
    const newText = document.getElementById("foundedRoot").value;

    // Создание и скачивание файла
    const blob = new Blob([newText], {type: 'text/plain'});
    const url = window.URL.createObjectURL(blob);
    const a = document.createElement('a');
    a.href = url;
    a.download = 'root.txt';
    a.click();
    window.URL.revokeObjectURL(url);
})