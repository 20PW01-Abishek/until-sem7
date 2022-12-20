import socket

sender = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
sender.settimeout(2)

dest = (socket.gethostname(), 12345)

sn = 0
i=0
canSend = True
frames = ['0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1']
print(frames)
while True:
    if canSend:
        data = frames[0]
        sender.sendto(data.encode(), dest);
        sn^=1
        canSend = False
    
    try:
        ack, recvAddr = sender.recvfrom(1024);
        frames.pop(0);
        
    except socket.timeout as e:
        print(e)
        sender.sendto(data.encode(), dest);
        