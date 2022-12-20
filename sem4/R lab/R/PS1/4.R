library(lpSolve)
f.obj <- c(3,4)
f.con <- matrix(c(4, 2,
                  2, 5), nrow = 2, byrow = TRUE)
f.dir <- c("<=",
           "<=")
f.rhs <- c(80,
           180)
lp("max", f.obj, f.con, f.dir, f.rhs)
lp("max", f.obj, f.con, f.dir, f.rhs)$solution