print("\nEnter the string in first line. \nEnter index location and a character separated by a space in second line.")
s=input()
c=input()
i=int(c[0])

s=s[:i]+c[2]+s[i+1:]
print(s)