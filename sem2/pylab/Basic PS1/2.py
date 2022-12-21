#2
website=[]
suffix=[]
n=int(input("Enter the no. of elements : "))
for i in range(n):
    ele=input("Enter website name : ")
    website.append(ele)
    if ".com" in ele:
        suffix.append("com")
    if ".org" in ele:
        suffix.append("org")
    if ".net" in ele:
        suffix.append("net")
    if ".in" in ele:
        suffix.append("in")
print("Suffix of the websites are :",suffix)
