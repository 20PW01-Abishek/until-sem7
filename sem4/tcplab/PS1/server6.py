import socket
import pickle as p
s=socket.socket()
host=socket.gethostname()
port=12345
d={1:'2',2:'3',3:'4'}
s.bind((host,port))
s.listen(3)

c,a=s.accept()
obj=p.dumps(d)
c.send(obj)
   
c.close()
