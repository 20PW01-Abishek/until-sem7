library(lpSolve)
f.obj<-c(2,3)
f.con<-matrix(c(2,3,2,6),nrow=2,byrow=TRUE)
f.dir<-c("<=","<=")
f.rhs<-c(8,18)

opt=lp("max",f.obj,f.con,f.dir,f.rhs,compute.sens=TRUE)
optVal=opt$objVal
d=opt$duals
print("Duals: ")
cat("Raw material 1: ",d[1],"\n")
cat("Raw material 2: ",d[2],"\n")

from = opt$duals.from
to=opt$duals.to
print("Feasibility range: ")
cat("Raw material 1: ",from[1]," to ",to[1],"\n")
cat("Raw material 2: ",from[2]," to ",to[2],"\n")
d[1]=d[1]-0.30

if(f.rhs[1]+4 >= from[1] && f.rhs[1]+4 <= to[1]){
	newopt=optVal+(d[1]*4)
	if(newopt>optVal) {
		print("Recommended")
	}
	else {
		print("Not recommended")
	}
}

cat ("The most of the company should pay per unit of M2 is ",d[2])
optRev = optVal + 5*d[2]
cat("If M2 availability is increased by 5 units,optimum revenue is increased to",optRev)

