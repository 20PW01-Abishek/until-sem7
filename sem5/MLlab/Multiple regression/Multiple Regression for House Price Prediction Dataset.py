#!/usr/bin/env python
# coding: utf-8

# # Multiple Regression for House Price Prediction Dataset

# In[3]:


import numpy as np
import pandas as pd
import seaborn as sns
import matplotlib.pyplot as plt


# In[4]:


df=pd.read_csv('Z:\Z-drive\sem5\MLlab\Dataset\House.csv')


# In[5]:


df.describe()


# In[6]:


dfTrain=df.head(int(len(df)*2/3))
dfTest=df.tail(int(len(df)/3))


# In[7]:


dfTrain.corr()


# In[8]:


ind=['sqft_lot','floors','bedrooms','sqft_above','sqft_basement','condition']


# In[9]:


x=[]
for i in range(len(dfTrain)):
    temp=[]
    temp.append(1)
    for j in ind:
        temp.append(dfTrain[j][i])
    x.append(temp)
Y=dfTrain['price']
Y=np.array(Y)

X=np.array(x)
Xt=np.transpose(X)
XtX=Xt.dot(X)
XtXi=np.linalg.inv(XtX)
XtY=Xt.dot(Y)
W=XtXi.dot(XtY)


# In[10]:


for i in range(len(W)):
    print("w"+str(i)+" : "+str(W[i]))


# # Avg performance measures

# In[14]:


Ypred = []
for i in range(len(dfTrain)):
    Ypred.append(W[0]+W[1]*dfTrain['sqft_lot'][i]+W[2]*dfTrain['floors']+W[3]*dfTrain['bedrooms'])
Ypred


# In[16]:


Ypred = []
for i in range(len(dfTrain)):
    sum=W[0]
    for j in ind:
        sum+=W[i]*dfTrain[j+1][i]


# In[13]:


Ypred


# In[ ]:




