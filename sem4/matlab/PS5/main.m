age=25;
sum=5000;
while(sum<=10^6)
    sum=sum+(9*sum/100)+5000;
    age=age+1;
end
disp(age-25);