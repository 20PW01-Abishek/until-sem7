def padlock(s,f,k):
    c=0
    for i in s:
        l=[]
        for j in f:
            n=ord(j)-96
            m=ord(i)-96
            l.append(min(abs(m-n),abs(26-m+n)))
        c+=min(l)
    print("Case #"+str(k)+": "+str(c))

n=int(input())
for i in range(n):
    s=input()
    f=input()
    padlock(s,f,i+1)