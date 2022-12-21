import socket

server=socket.socket()
host=socket.gethostname()
port=12345
server.bind((host,port))
server.listen(2)

while True:
    client,addr=server.accept()
    str=client.recv(2048).decode()
    print(str)