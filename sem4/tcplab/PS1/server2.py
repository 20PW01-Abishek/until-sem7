import socket
s=socket.socket()
ip=socket.gethostname()
port=12345
s.bind((ip,port))
s.listen(5)

while True:
    c,addr=s.accept()
    client_msg=c.recv(1024).decode()
    print("Message from client: ",client_msg)
    c.send(bytes(client_msg[::-1],'utf-8'))
c.close()