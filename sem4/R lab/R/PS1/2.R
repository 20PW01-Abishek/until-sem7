library(lpSolve)
f.obj <- c(600, 500)
f.con <- matrix(c(5, 2,
                  1, 6,
			3, 3
                  ), nrow = 3, byrow = TRUE)

f.dir <- c(">=",
           ">=",
	     ">=")

f.rhs <- c(24,
           18,
	     24)

lp("min", f.obj, f.con, f.dir, f.rhs)

lp("min", f.obj, f.con, f.dir, f.rhs)$solution