import socket
server = socket.socket()
port=12346
server.bind((socket.gethostname(),port))
server.listen(5)

while True:
    client,addr=server.accept()
    print(client.recv(1024).decode())
    client.close()
    break
    