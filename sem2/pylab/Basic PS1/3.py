a=int(input("Enter value of a :"))
sum=0
for i in range(0,4):
    for j in range(0,i+1):
        e=a*10**j
        sum+=e
print("a+aa+aaa+aaaa = ",sum)