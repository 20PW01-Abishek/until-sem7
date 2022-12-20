import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
from sklearn.model_selection import train_test_split
from sklearn.linear_model import LinearRegression

df = pd.read_csv('Iris.csv')

x=df['SepalLengthCm']
y=df['SepalWidthCm']
n=len(x)
X=[[]]
for i in range(1,n):
    t=[]
    t.append(1)
    t.append(x[i])
    t.append(x[i]**2)
    X.append(t)
    print(t)
# print(X)
Xt = np.transpose(X)
# print(Xt)

print(list(y))