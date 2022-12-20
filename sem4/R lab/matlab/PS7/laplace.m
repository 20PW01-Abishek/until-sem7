syms t
f=2*(heaviside(t-0)-heaviside(t-4))+(t-1)*(heaviside(t-4)-heaviside(t-6));
a=laplace(f);
subplot(2,1,1);
fplot(f);
subplot(2,1,2);
fplot(a);