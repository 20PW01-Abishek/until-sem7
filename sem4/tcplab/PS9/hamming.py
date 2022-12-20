import math

dataBits=input("enter the data bits:")
dataBits=list(reversed(dataBits))
print(f"the data to be encoded is {dataBits}")

rBits=list()
r=0

while ((len(dataBits)+r+1)>(pow(2,r))):
    rBits.append(str(2**r))
    r+=1
  
hamming=list()

print(f"The redundant bits are {rBits}")

def parity_check(p):
    tot=0
    i=p-1
    while(i<len(int_hamming)):
        tot+=sum(int_hamming[(i):i+p])
        i+=(p+p)
    
    return tot%2

def print_hamming_code(h_code):
    print("The hamming code generated is:")
    for i in h_code:
        print(i,end='') 
 
k=0 
for i in range(0,len(dataBits)+r):
    if str(i+1) in rBits:
        hamming.append('0')
    else:
        hamming.append(str(dataBits[k]))
        k+=1

int_hamming=list()
for i in hamming:
    int_hamming.append(int(i))

str_hamming=list(reversed(hamming))
str_hamming="".join(str_hamming)
print(f"the hamming code [with all 0s in the redundant bits] is:{str_hamming}")

for i in rBits:
    int_hamming[int(i)-1]=parity_check(int(i))

int_hamming=list(reversed(int_hamming))
print_hamming_code(int_hamming)


#--------------------------------------------
recv=input("enter the recieved errored bits:")
dataBits=list((dataBits))

r=int(math.log(len(recv)+1,(2)))
print(r)

while r:
    corr=list()
    tot=0
    while(i<len(recv)):
        tot+=sum(int_hamming[(i):i+r])
        i+=(r+r)
        tot%2
    r-=1