list1 = [1,3,6,78,35,55]
list2 = [12,24,35,24,88,120,155]
list3 = []
for i in list1:
    for j in list2:
        if i == j:
            list3.append(i)
print(list3)