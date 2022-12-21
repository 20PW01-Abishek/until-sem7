str1 = "EVAPORATE"
str2 = ['E','_','_','_','_','_','_','_','E']
print("E_______E")
check = []
while '_' in str2:
    ch = input("Enter guess: ")
    ch = ch.capitalize()
    if ch in str1:
        if i in range (len(str1)):
            
            str2[str1.index(ch)]=ch
            print (str2)
    else:
        print ("Invalid guess")