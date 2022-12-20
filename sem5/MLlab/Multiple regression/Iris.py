import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
import math
df=pd.read_csv("D:\Z-drive\sem5\MLlab\Dataset\Iris.csv")
print(df.describe())

dfTrain=df.head(math.floor(len(df)*3/4))
dfTest=df.head(math.floor(len(df)/4))

X=[]
ind=['SepalLengthCm', 'SepalWidthCm',  'PetalLengthCm',  'PetalWidthCm']
for i in range(len(dfTrain)):
    temp=[1]
    for j in ind:
        temp.append(dfTrain[j][i])
    X.append(temp)
X=np.array(X)
Y=dfTrain['Species']
Y=np.array(Y)

XtXi=np.linalg.inv(np.transpose(X).dot(X))
print(XtXi)
XtY=(np.transpose(X)).dot(Y)
print(XtY)
W=XtXi.dot(XtY)
print(W)