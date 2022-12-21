#3
def fun(u,v):
    d1=d2=0
    p=0
    for i in range (len(u)):
        d1+=int(u[i])**2
        d2+=int(v[i])**2
        p+=int(u[i])*int(v[i])
    d1 = float(d1**(1/2))
    d2 = float(d2**(1/2))
    
    return x
u = input("Enter coordinates of p1(comma separated):  ")
v = input("Enter coordinates of p2 (comma separated):  ")
u=tuple(u.split(","))
v=tuple(v.split(","))
