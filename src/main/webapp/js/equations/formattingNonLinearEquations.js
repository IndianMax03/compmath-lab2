const fromCompPart = document.getElementById("fromCompPart");
const sinus = document.getElementById("sinus");
const log = document.getElementById("naturalLogarithm");
const a = document.getElementById("aLabel");
const b = document.getElementById("bLabel");
// const x = document.getElementById("xLabel");
const eps = document.getElementById("epsLabel");

const aLessThanB = document.getElementById("aLessThanB");
const xBetweenAB = document.getElementById("xBetweenAB");


katex.render(
    "y = -2.8x^3-3.48x^2+10.23x+9.35",
    fromCompPart
);

katex.render(
    "y = \\sin(x)",
    sinus
);

katex.render(
    "y = \\ln(x)",
    log
);

katex.render("a:",
    a
)

katex.render("b:",
    b
)

// katex.render("x_0:",
//     x
// )

katex.render("\\epsilon:",
    eps
)

katex.render("a < b",
    aLessThanB
)

// katex.render("a \\leq x_0 \\leq b",
//     xBetweenAB
// )
