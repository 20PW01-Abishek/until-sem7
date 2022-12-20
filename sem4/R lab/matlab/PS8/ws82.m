syms x n;

f=piecewise(0 < x < 2, 0, 2 < x < 4, 1);
L=pi;

a0=2/L*(int(f,0,2)+int(f,2,4));
an=2/L*(int(f*cos(n*pi*x/L),0,2)+int(f*cos(n*pi*x/L),2,4));
bn=2/L*(int(f*sin(n*pi*x/L),0,2)+int(f*sin(n*pi*x/L),2,4));

halfCos = [a0/2,(subs(an*cos(n*pi*x/L),n,[1 2 3 4]))];
halfSin = [0,(subs(bn*sin(n*pi*x/L),n,[1,2,3,4,5]))];

fplot(sum(halfCos(1,1)),[0 L])
hold on
fplot(sum(halfCos(1,1:2)),[0 L])
fplot(sum(halfCos(1,1:3)),[0 L])
fplot(sum(halfCos(1,1:4)),[0 L])
fplot(sum(halfCos(1,1:5)),[0 L])
fplot(f,[0 L])
hold off
title("Half cosine");

figure()

fplot(sum(halfSin(1,1)),[0 L])
hold on
fplot(sum(halfSin(1,1:2)),[0 L])
fplot(sum(halfSin(1,1:3)),[0 L])
fplot(sum(halfSin(1,1:4)),[0 L])
fplot(sum(halfSin(1,1:5)),[0 L])
fplot(f,[0 L])
hold off
title("Half sine");