function y = oddeven(x)
y=rem(x,2);
if y==0
    disp('even')
else
    disp('odd')
end