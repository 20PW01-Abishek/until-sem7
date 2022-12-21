print("Prime numbers from 1 to 50 are : ")
for i in range(2,50):
    flag=0
    for j in range(2,i+1):
        if(i%j==0):
            flag+=1
    if(flag==1):
        print(i,end=",")
print("\b ")