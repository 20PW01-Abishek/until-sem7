import socket
c = socket.socket()
port = 5000
ip = socket.gethostname()
c.connect((ip,port))

mtu=input('Enter MTU: ')
s=input('Enter size of packet: ')
x=list()
x.append(mtu)
x.append(s)
print(x)
c.send(str(x).encode())
c.close()