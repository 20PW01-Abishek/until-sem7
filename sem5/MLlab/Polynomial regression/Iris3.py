import pandas as pd
import numpy as np

data = pd.read_csv('Iris.csv')

x = data["SepalLengthCm"]
y = data["SepalWidthCm"]

n = len(x)
x2 = [i*i for i in x]

Xt = np.array([[1 for i in range(0,n)],x,x2])
X = Xt.transpose()

XtX = np.dot(Xt,X)

mat = np.array(XtX)
inver = np.linalg.inv(mat)

XtY = np.dot(Xt,y)

B = np.dot(inver,XtY)
b0 = B[0]
b1 = B[1]
b2 = B[2]

print(B)

ycap = []
for i in x:
    ycap.append(b0+b1*i+b2*i*i)

j=0
SSE=0
for i in y:
    SSE = SSE + (i-ycap[j])*(i-ycap[j])
    j = j+1
print('SSE : ',SSE)

ybar = np.mean(y)
SST=0
for i in y:
    SST = SST + (i-ybar)*(i-ybar)
print('SST : ',SST)

SSR=0
for i in ycap:
    SSR = SSR + (i-ybar)*(i-ybar)
print('SSR : ',SSR)

print('Coefficient of determination : ',SSR/SST)