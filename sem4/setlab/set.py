def multiplier(n,w,t):
    Simple=[3,4,3,7,5]
    Average=[4,5,4,10,7]
    Complex=[6,7,6,15,10]
    
    if w == 's':
        return Simple[t]*n
    elif w == 'c':
        return Complex[t]*n
    else:
        return  Average[t]*n
    
ufc=0
  
w=input("Enter complexity of extInp: s/a/c: ")
extInp=int(input("Enter no. of extInp: "))
ufc=ufc+multiplier(extInp,w,0)


w=input("Enter complexity of extOut: s/a/c: ")
extOut=int(input("Enter no. of extOut: "))
ufc=ufc+multiplier(extOut,w,1)


w=input("Enter complexity of extInqu: s/a/c: ")
extInqu=int(input("Enter no. of extInqu: "))
ufc=ufc+multiplier(extInqu,w,2)


w=input("Enter complexity of extFiles: s/a/c: ")
extFiles=int(input("Enter no. of extFiles: "))
ufc=ufc+multiplier(extFiles,w,3)


w=input("Enter complexity of intFiles: s/a/c: ")
intFiles=int(input("Enter no. of intFiles: "))
ufc=ufc+multiplier(intFiles,w,4)

print("ufc = ",ufc,"\n","Enter (0) for low (3) for avg (5) for essential for the following factors\n")
f=0
f+=int(input("F1 : Reliable backup and Recovery: "))
f+=int(input("F2 : Data Communications: "))
f+=int(input("F3 : Distributed functions: "))
f+=int(input("F4 : Performance: "))
f+=int(input("F5 : Heavily used configuration: "))
f+=int(input("F6 : Online Data entry: "))
f+=int(input("F7 : Operational Ease: "))
f+=int(input("F8 : Online Update: "))
f+=int(input("F9 : Complex interface: "))
f+=int(input("F10 : Complex processing: "))
f+=int(input("F11 : Reusability: "))
f+=int(input("F12 : Installation ease: "))
f+=int(input("F13 : Multiple Sites: "))
f+=int(input("F14 : Facilitate change: "))
       
TCF=0.65+0.01*f
print("\nTCF = ",TCF,"\n")

FP=TCF*ufc
print("FP = ",FP)
