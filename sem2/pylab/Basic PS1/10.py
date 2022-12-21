l=[1,2,2,1]
for i in range (len(l)):
    if i>0:
        if l[i]==l[i-1]:
            print(True)
            break
else:
    print(False)
