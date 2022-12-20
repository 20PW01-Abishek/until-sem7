import socket
s = socket.socket()
port = 5000
ip = socket.gethostname()
s.bind((ip,port))
s.listen(1)
c,addr=s.accept()

def fragment (s,mtu):
    mtu=mtu-20
    while (mtu%8!=0):
        mtu=mtu-1
    s=s-mtu
    print(mtu)
    
while True:
    x=c.recv(1024).decode().split(',')
    print(x)
    s=int(x[0])
    mtu=int(x[1])
    #network=int(x[1])
    #mtu=list(map(int, x[2:]))
    fragment(s,mtu)
    s.close()