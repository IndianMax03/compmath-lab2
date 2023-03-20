const baseball = document.getElementById("baseball");
const tennis = document.getElementById("tennis");
const a = document.getElementById("aLabel");
const b = document.getElementById("bLabel");
const x = document.getElementById("xLabel");
const eps = document.getElementById("epsLabel");

const aLessThanB = document.getElementById("aLessThanB");
const epsHigherThanZero = document.getElementById("epsHigherThanZero");
const xBetweenAB = document.getElementById("xBetweenAB");

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

katex.render("a:",
    a
)

katex.render("b:",
    b
)

katex.render("x_0:",
    x
)

katex.render("\\epsilon:",
    eps
)

katex.render("a < b",
    aLessThanB
)

katex.render("a \\leq x_0 \\leq b",
    xBetweenAB
)

katex.render("\\epsilon \\geq 0",
    epsHigherThanZero
)
