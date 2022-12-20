from socket import *
serverPort=12347
serverSocket = socket(AF_INET, SOCK_STREAM)
serverSocket.bind((&#39;&#39;, serverPort))
serverSocket.listen(1)
print (&#39;the web server is up on port:&#39;, serverPort)
while True:
    print (&#39;Ready to serve...&#39;)
    connectionSocket, addr =serverSocket.accept()
    try:
        message =connectionSocket.recv(1024)  #Fill in start #Fill in end
        filename = message.split()[1]
        f = open(filename[1:])
        outputdata =f.read() #Fill in start #Fill in end
        print (outputdata)
        connectionSocket.send(&#39;\nHTTP/1.1 200 OK\n\n&#39;.encode())
        for i in range(0, len(outputdata)):
            connectionSocket.send(outputdata[i].encode())
            connectionSocket.send(&quot;\r\n&quot;.encode())
        connectionSocket.close()
    except IOError:
        connectionSocket.send(&quot;\nHTTP/1.1 404 Not Found\n\n&quot;.encode())
        connectionSocket.close()
serverSocket.close()