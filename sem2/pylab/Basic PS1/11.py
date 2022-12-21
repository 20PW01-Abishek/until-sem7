num=input("Enter a number : ")
p=str(int(num)**2)
n=len(num)
l=len(p)

sum1=sum2=""
for i in range(0,len(p)):
    if i<l-n:
        sum1+=p[i]
    else:
        sum2+=p[i]

if int(sum1)+int(sum2)==int(num):
    print("It is a Keprekar number")
else:
    print("It is not a Keprekar number")
   

