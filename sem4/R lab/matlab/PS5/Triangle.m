function Area = Triangle(a,b,c)
    s=(a+b+c)/2;
    Area=sqrt(s*(s-a)*(s-b)*(s-c));
end

