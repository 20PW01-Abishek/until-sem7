function f = primeChecker(n)
    i=2;
    flag=0;
    while i<=sqrt(n)
        if rem(n,i)==0
            flag=1;
            break
        end
        i=i+1;
    end
    if flag == 0
        disp('prime')
    else
        disp('not prime')
    end
end

