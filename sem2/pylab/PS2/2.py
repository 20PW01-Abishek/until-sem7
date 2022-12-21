#2
def distance(u,v):
    d=0;
    for i in range (len(u)):
        d+=(int(u[i])-int(v[i]))**2
    d=float(d**(1/2))
    return d;
u = input("Enter coordinates of p1(comma separated):  ")
v = input("Enter coordinates of p2 (comma separated):  ")
u=tuple(u.split(","))
v=tuple(v.split(","))
if len(u)==len(v):
    print("Distance between u and v is ",distance(u,v),"units")
else:
    print("Distance between u and v can't be determined")