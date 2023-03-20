const baseball = document.getElementById("baseball");
const tennis = document.getElementById("tennis");
const x = document.getElementById("xLabel");
const y = document.getElementById("yLabel");
const eps = document.getElementById("epsLabel");

const epsHigherThanZero = document.getElementById("epsHigherThanZero");

katex.render(
    "\\begin{cases}\n" +
    "    x^2 + y^2 = 25 \\\\\n" +
    "    y = \\ln(x)\n" +
    "\\end{cases}",
    baseball
);

katex.render(
    "\\begin{cases}\n" +
    "    x^2 + y^2 = 25 \\\\\n" +
    "    xy = 6\n" +
    "\\end{cases}",
    tennis
);

katex.render("x_0:",
    x
)

katex.render("y_0:",
    y
)

katex.render("\\epsilon:",
    eps
)

katex.render("\\epsilon \\geq 0",
    epsHigherThanZero
)
