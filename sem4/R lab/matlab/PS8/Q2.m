syms x n k;
f=exp(-x);
l=pi;
a0=eval(1/l*(int(f,x,0,2*pi)));
an=1/l*(int(f*cos(n*pi*x/l),x,0,pi));
bn=1/l*(int(f*sin(n*pi*x/l),x,0,pi));
[a0/2,eval(subs(an*cos(n*pi*x/l)+bn*sin(n*pi*x/l),n,[1 2 3 4]))]