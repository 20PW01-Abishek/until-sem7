s=input("Enter a string :")
flag=0
for i in range (97,122+1):
    if chr(i) in s:
        flag+=1
if flag==26:
    print("Given string is pangram")        
else:
    print("Given string is not pangram")