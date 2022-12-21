syms y(x)
Dy=diff(y);
DDy=diff(y,x,2);
ode = diff(y,x,3) == y - x*diff(y) + 4*diff(y,x,2);
ysol(x) = dsolve(ode);
cond1 = y(2) == 1;
cond2 = Dy(2) == 1/2;
cond3 = DDy(2) == 0;
cond=[cond1,cond2,cond3];
ysol(x) = dsolve(ode,cond);
disp(ysol(x))