library(lpSolve)
f.obj <- c(68.8, 68)
f.con <- matrix(c(320, 240,
                  1, 0,
                  0, 1), nrow = 3, byrow = TRUE)

f.dir <- c(">=",
           "<=",
           "<=")

f.rhs <- c(2000,
           9,
           11)

lp("min", f.obj, f.con, f.dir, f.rhs)

lp("min", f.obj, f.con, f.dir, f.rhs)$solution