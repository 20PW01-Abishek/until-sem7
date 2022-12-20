import serial
import time
import pandas as pd
import csv 
from datetime import datetime

ser = serial.Serial("COM6",115200,timeout=1)
# time.sleep(2)
lst2 = []
tup = []
with open('DHT11.csv','a',encoding='UTF8',newline='') as f:
    w = csv.writer(f)
# anotherZList
    for i in range(1000):
        line=ser.readline().decode("utf-8")
        print(line)
        if(line !=''):
            tup = []
            tup.append(str(datetime.now().strftime("%d/%m/%Y %H:%M:%S")))
            tup.append(float(line))
            w.writerow(tup)


        

        # lst2.append(line)

# lst2 = [x.replace('\r\n','')for x in lst]

# lst2.remove('')
# print(lst2)

# header = ["DateAndTime","Recorded Temp"]
# with open('DHT11.csv','a',encoding='UTF8',newline='') as f:
#     w = csv.writer(f)
#     for i in  lst2:
#         tup=[]
        
#         tup.append(str(datetime.now().strftime("%d/%m/%Y %H:%M:%S")))
#         tup.append(float(i))
#         w.writerow(tup)
    

