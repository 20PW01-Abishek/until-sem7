l=[1,2,2]
t=0
for i in range (len(l)):
    if i>0:
        if l[i]==2 and l[i-1]==2:
            print(True)
            break
