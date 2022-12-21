a = set()
b = set()
l1 = int(input("length of set 1: "))
for i in range (l1):
   e= int(input("Enter element of l1: "))
   a.add(e)
l2 = int(input("length of set 2: "))
for i in range (l2):
   e= int(input("Enter element of l2: "))
   b.add(e)
if a==b:
    print("Equal")
else:
    b1 = {x for x in b if x not in a}
    b2 = {x for x in a if x not in b}
    print("B1: ",b1)
    print("B2: ",b2)