syms n x;
L=1;
a0=1/L*(int(1,x,-1,0)+int(x,x,0,1));
an=1/L*(int(1*cos(n*pi*x/L),-1,0)+int(x*cos(n*pi*x/L),0,1));
bn=1/L*(int(1*sin(n*pi*x/L),-1,0)+int(x*sin(n*pi*x/L),0,1));
exp=[a0/2,subs(an*cos(n*x*pi/L)+bn*sin(n*x*pi/L),n,[1 2 3 4])];
fplot(sum(exp),[-1 1]); %fourier plot
f=1*(heaviside(x+1)-heaviside(x))+x*(heaviside(x)-heaviside(x-1));
% fplot(sum(exp(1)),[-1 1],'red'); %fourier  plot
% hold on;
% fplot(sum(exp(1:2)),[-1 1],'red'); %fourier  plot
% hold on;
% fplot(sum(exp(1:3)),[-1 1],'green'); %fourier  plot
% hold on;
% fplot(sum(exp(1:4)),[-1 1],'yellow'); %fourier  plot
% hold on;
fplot(sum(exp(1:5)),[-1 1],'black'); %fourier  plot
hold on;
fplot(f); %graph plot