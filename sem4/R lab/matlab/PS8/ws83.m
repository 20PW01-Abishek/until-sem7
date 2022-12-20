syms n x;
f=x^2;
l=3;

a0=2/l*(int(f,x,0,3));
an=2/l*(int(f*cos(n*pi*x/l),x,0,3));
bn=2/l*(int(f*sin(n*pi*x/l),x,0,3));
halfcos=[a0/2,subs(an*cos(n*pi*x/l),n,[1 2 3 4])]
halfsin=[subs(bn*sin(n*pi*x/l),n,[1 2 3 4 5])]