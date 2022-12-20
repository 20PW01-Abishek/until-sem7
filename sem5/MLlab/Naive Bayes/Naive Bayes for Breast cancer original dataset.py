#!/usr/bin/env python
# coding: utf-8

# # Naive Bayes for Breast cancer original dataset

# In[20]:


import pandas as pd
import numpy as np
from sklearn.preprocessing import LabelEncoder
from sklearn.model_selection import train_test_split
from collections import Counter


# In[21]:


def getCols(df):
    l = LabelEncoder()
    l.fit(df['Class'])
    df['Class'] = l.transform(df['Class'])
    X = df.drop(['Sample code number', 'Class'], axis=1)
    Y = df['Class'].values
    return X,Y


# In[22]:


df = pd.read_csv("Z:/Z-drive/sem5/MLlab/Dataset/bcoriginal.csv")
print(df.describe())
X,Y=getCols(df)
X_train, X_test, Y_train, Y_test = train_test_split(X, Y, test_size=0.2, random_state=0)


# In[23]:


def prior_probability_count(Y):
    c1=c2=0
    for i in Y_train:
        if i==0:
            c1+=1
        else:
            c2+=2
    return c1,c2

c1,c2=prior_probability_count(Y_train)
print(c1," ",c2)


# In[26]:


def construct_cpt(X,Y):
    unique=list(set(X))
    cpt={}
    for i in unique:
        for j in range(len(X)):
            l=[0,0]
            if i==X[j]:
                l[Y[j]]+=1
            cpt[i]=l
    print(cpt)

ind=X_train.columns
construct_cpt(X_train[ind[0]], Y_train)
# for i in ind:
#     print("\nCPT for",i,":")
#     construct_cpt(X_train[i], Y_train)


# In[ ]:




