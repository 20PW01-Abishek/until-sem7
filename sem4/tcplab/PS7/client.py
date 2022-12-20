'''import socket
client=socket.socket()
port=12345
client.connect((socket.gethostname(),port))
client.send("holoooww".encode())
client.close()
'''
def byte_stuffing(data):    
    data1=[]
    a=data.split()
    for i in a:
        if i=="ESC":
            data1.append("ESC")
        if i=="FLAG":
            data1.append("ESC")
        data1.append(i)
    data1=" ".join(data1)
    return data1

def toBinary(data):
    data1=[]
    a=data.split()
    for i in range(len(a)):
        if a[i]=="ESC":
            data1.append("10100011")
        elif a[i]=="FLAG":
            data1.append("01111110")
        else:
            data1.append(str(bin(ord(a[i]))))
    
    print(data1)
    data1=" ".join(data1)
    return data1
  
data=input("Enter the data to be sent: ")
data1=byte_stuffing(data)
data1=toBinary(data1)
print(data1)
