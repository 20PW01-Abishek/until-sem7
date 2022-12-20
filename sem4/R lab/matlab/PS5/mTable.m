i=1;
j=1;
k=1;
stars=1;
spaces=4;
while i<=5
    while j<= spaces
        fprintf(' ');
        j=j+1;
    end
    while k<=stars
        fprintf('*');
        k=k+1;
    end
    if spaces>i
        spaces=spaces+1;
        stars=stars+2;
    end
    fprintf("\n")
    i=i+1; 
end