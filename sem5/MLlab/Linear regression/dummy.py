import pandas as pd
import numpy as np
import matplotlib.pyplot as plt

df=pd.read_csv(r'Iris.csv')
#x=df['SepalLengthCm']
x=[1,2,3,4,5,6]
x=np.array(x)
X=[]
for i in range(len(x)):
    X.append([1,x[i],x[i]**2])
xt=np.transpose(X)
#y=df['SepalWidthCm']
y=[1,4,9,16,25,96]
XtX=xt.dot(X) 
XtXi=np.linalg.inv(XtX)
XtY=xt.dot(y)
ans=XtXi.dot(XtY)
print(ans)
plt.scatter(x,y)

ycap = []
for i in x:
    ycap.append(ans[0]+ans[1]*i+ans[2]*i**2)
plt.plot(x,ycap)