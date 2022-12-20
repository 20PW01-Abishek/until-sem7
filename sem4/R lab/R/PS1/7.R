library(lpSolve)
f.obj <- c(3,8,2,-1)
f.con <- matrix(c(0, 0, 1,  0,
                  0, 3, -1, -1, 
			3, 4, 0 , 0, 
			3, 5, 0 , 0), nrow = 4, byrow = TRUE)
f.dir <- c("<=",
           "=",
	     "<=",
	     "<=")
f.rhs <- c(	5,
           	0,
		18,
		21)
lp("max", f.obj, f.con, f.dir, f.rhs)
lp("max", f.obj, f.con, f.dir, f.rhs)$solution