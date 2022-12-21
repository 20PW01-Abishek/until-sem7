oldword = input("Enter your sentence: ")
oldword = oldword.split(" ")
word2 = []
for i in oldword:
    if i not in word2:
        word2.append(i)
word2.sort()
print((' ').join(word2))
