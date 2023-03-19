const canvas = document.getElementById('graph');
const buttons = document.querySelectorAll('input[name="system"]');

let chart;

setBaseballChart(true);

buttons.forEach(button => {
    button.addEventListener('change', () => {
        console.log(button);
        if (button.id === "baseballSystem") {
            setBaseballChart();
        }
        if (button.id === "tennisSystem") {
            setTennisChart();
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

function generateCirclePoints(centerX, centerY, radius, pointCount) {
    const circumference = 2 * Math.PI * radius;
    const points = [];
    const angleStep = 2 * Math.PI / pointCount;
    for (let i = 0; i <= pointCount; i++) {
        const angle = i * angleStep;
        const x = centerX + radius * Math.cos(angle);
        const y = centerY + radius * Math.sin(angle);
        points.push({x: x, y: y});
    }
    return points;
}


function circleFunc(x) {
    return Math.sqrt(25 - x * x);
}

function baseballFunc(x) {
    return Math.log(x);
}

function hyberFunc(x) {
    return 6 / x;
}

function setBaseballChart(first = false) {
    const data = {
        datasets: [
            {
                label: "Кружочек",
                data: generateCirclePoints(0, 0, 5, 54),
                fill: false,
                borderColor: "rgb(75, 192, 192)",
                tension: 0.4,
            },
            {
                label: "Логушка",
                data: generatePoints(x => baseballFunc(x), 0.004, 6, 0.15),
                fill: false,
                borderColor: "rgb(140, 40, 150)",
                tension: 0.4,
            }
        ]
    };
    let options = {
        aspectRatio: 1,
        maintainAspectRatio: true,
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
                },
                suggestedMin: -5,
                suggestedMax: 5
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
                },
                suggestedMin: -5,
                suggestedMax: 5
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

function setTennisChart() {
    const data = {
        datasets: [
            {
                label: "Кружочек",
                data: generateCirclePoints(0, 0, 5, 54),
                fill: false,
                borderColor: "rgb(75, 192, 192)",
                tension: 0.4,
            },
            {
                label: "Гипушка",
                data: generatePoints(x => hyberFunc(x), -5.999, -1, 0.15),
                fill: false,
                borderColor: "rgb(140, 40, 150)",
                tension: 0.4,
            },
            {
                label: "",
                data: generatePoints(x => hyberFunc(x), 1, 6, 0.15),
                fill: false,
                borderColor: "rgb(140, 40, 150)",
                tension: 0.4,
            }
        ]
    };
    let options = {
        aspectRatio: 1,
        maintainAspectRatio: true,
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
                },
                suggestedMin: -5,
                suggestedMax: 5
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
                },
                suggestedMin: -5,
                suggestedMax: 5
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
