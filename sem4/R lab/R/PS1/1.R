library(lpSolve)
f.obj <- c(750,1000)
f.con <- matrix(c(1, 1,
			1, 2,
			4, 3
			),nrow = 3, byRow= TRUE)

f.dir <- c( "<="
		"<="
		"<=")

f.rhs <- c( 10000,
		15000,
		25000)

lp("max",f.obj,f.con,f.dir,f.rhs)

lp("max",f.obj,f.con,f.dir,f.rhs)$solution
