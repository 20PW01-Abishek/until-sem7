h=200;
for x=1:1:h
    for j=1:1:h-x
        fprintf(" ")
    end
    for k=1:1:2*x-1
        fprintf("*")
    end
    fprintf("\n")
end
for x=h-1:-1:1
    for j=1:1:h-x
        fprintf(" ")
    end
    for k=1:1:2*x-1
        fprintf("*")
    end
    fprintf("\n");
end