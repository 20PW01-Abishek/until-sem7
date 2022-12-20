import socket 
receiver = socket.socket(socket.AF_INET, socket.SOCK_DGRAM);
receiver.bind((socket.gethostname(), 12345))
data, addr = receiver.recvfrom(1024);