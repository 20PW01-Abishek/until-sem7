str = """1 Write a program concerns the problem of making an index for a book. A related problem is
2 making a concordance for a document. A concordance lists every word that occurs in the
3 document, and for each word it gives the line number of every line in the document where
4 the word occurs. Input the document as a multi-line string with each line starting with line
5 numbers."""

l = list(str.splitlines())
print(l)
for i in range (len(l)):
    for x in list (l[i].split()):
        print(x,":",l[i][0])