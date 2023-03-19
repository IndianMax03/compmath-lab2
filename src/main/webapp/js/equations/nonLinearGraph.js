const canvas = document.getElementById('graph');
const buttons = document.querySelectorAll('input[name="equation"]');

let chart;

setCompEquationChart(true);

buttons.forEach(button => {
    button.addEventListener('change', () => {
        console.log(button);
        if (button.id === "compEquation") {
            setCompEquationChart();
        }
        if (button.id === "sinusEquation") {
            setSinusEquationChart();
        }
        if (button.id === "logarithmEquation") {
            setLogarithmEquationChart();
        }
    })
})

function generatePoints(equation, start, stop, step) {
    let data = [];
    for (let x = start; x <= stop; x += step) {
        data.push({
            x: x,
            y: equation(x)
        })
    }

    return data;
}

function polynomialFunc(x) {
    return -2.8 * x * x * x - 3.48 * x * x + 10.23 * x + 9.35;
}

function setCompEquationChart(first = false) {
    const data = {
        datasets: [{
            label: "Полиномушка",
            data: generatePoints(x => polynomialFunc(x), -2.5, 2.5, 0.1),
            fill: false,
            borderColor: "rgb(75, 192, 192)",
            tension: 0.4,
        }]
    };
    context = canvas.getContext('2d');
    let options = {
        animation: {
            duration: 2000,
            easing: 'easeInBack'
        },
        scales: {
            x: {
                type: "linear",
                position: "bottom",
                title: {
                    display: true,
                    labelString: 'x',
                    fontColor: '#000001',
                    text: 'x',
                    axis: 'x',
                    font: {
                        weight: 'bold',
                        size: 14
                    }
                },
                grid: {
                    color: function (context) {
                        return context.tick.value === 0 ? 'black' : 'rgba(0, 0, 0, 0.1)';
                    }
                }
            },
            y: {
                type: "linear",
                position: "left",
                title: {
                    display: true,
                    labelString: 'y',
                    fontColor: '#000000',
                    text: 'y',
                    axis: 'y',
                    font: {
                        weight: 'bold',
                        size: 14
                    },
                },
                grid: {
                    color: function (context) {
                        return context.tick.value === 0 ? 'black' : 'rgba(0, 0, 0, 0.1)';
                    }
                }
            }
        }

    };

    if (!first) {
        chart.destroy();
    }
    chart = new Chart(canvas, {
        type: "line",
        data: data,
        options: options
    });
}

function setSinusEquationChart() {
    const data = {
        datasets: [{
            label: "Синусильда",
            data: generatePoints(x => Math.sin(x), -8, 10, 0.5),
            fill: false,
            borderColor: "rgb(75, 192, 192)",
            tension: 0.4,
        }]
    };

    let options = {
        animation: {
            duration: 2000,
            easing: 'easeInBack'
        },
        scales: {
            x: {
                type: "linear",
                position: "bottom",
                title: {
                    display: true,
                    labelString: 'x',
                    fontColor: '#000001',
                    text: 'x',
                    axis: 'x',
                    font: {
                        weight: 'bold',
                        size: 14
                    }
                },
                grid: {
                    color: function (context) {
                        return context.tick.value === 0 ? 'black' : 'rgba(0, 0, 0, 0.1)';
                    }
                }
            },
            y: {
                type: "linear",
                position: "left",
                title: {
                    display: true,
                    labelString: 'y',
                    fontColor: '#000000',
                    text: 'y',
                    axis: 'y',
                    font: {
                        weight: 'bold',
                        size: 14
                    },
                },
                grid: {
                    color: function (context) {
                        return context.tick.value === 0 ? 'black' : 'rgba(0, 0, 0, 0.1)';
                    }
                }
            }
        }
    };

    chart.destroy();
    chart = new Chart(canvas, {
        type: "line",
        data: data,
        options: options
    });
}

function setLogarithmEquationChart() {
    const data = {
        datasets: [{
            label: "Логушка",
            data: generatePoints(x => Math.log(x), 0.05, 4, 0.1),
            fill: false,
            borderColor: "rgb(75, 192, 192)",
            tension: 0.4,
        }]
    };

    let options = {
        animation: {
            duration: 2000,
            easing: 'easeInBack'
        },
        scales: {
            x: {
                type: "linear",
                position: "bottom",
                title: {
                    display: true,
                    labelString: 'x',
                    fontColor: '#000001',
                    text: 'x',
                    axis: 'x',
                    font: {
                        weight: 'bold',
                        size: 14
                    }
                },
                grid: {
                    color: function (context) {
                        return context.tick.value === 0 ? 'black' : 'rgba(0, 0, 0, 0.1)';
                    }
                }
            },
            y: {
                type: "linear",
                position: "left",
                title: {
                    display: true,
                    labelString: 'y',
                    fontColor: '#000000',
                    text: 'y',
                    axis: 'y',
                    font: {
                        weight: 'bold',
                        size: 14
                    },
                },
                grid: {
                    color: function (context) {
                        return context.tick.value === 0 ? 'black' : 'rgba(0, 0, 0, 0.1)';
                    }
                }
            }
        }
    };

    chart.destroy();
    chart = new Chart(canvas, {
        type: "line",
        data: data,
        options: options
    });
}

