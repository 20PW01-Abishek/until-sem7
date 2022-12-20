#!/usr/bin/env python
# coding: utf-8

# In[2]:


import pandas as pd
import matplotlib.pyplot as plt
import seaborn as sns

url = 'https://github.com/dhyan6/data-science-projects/blob/main/kc_house_data.csv?raw=true' 
houses = pd.read_csv(url)
print(houses.head())
print(houses.info())


# In[3]:


correlations = houses.corr()
sns.heatmap(correlations, annot=True)


# In[4]:


plt.title('sqft vs price')
plt.xlabel('sqft')
plt.ylabel('price')
sns.scatterplot(x='sqft_living',y='price',data=houses)


# In[7]:


from sklearn.model_selection import train_test_split
x=houses[['sqft_living']]
y=houses['price']


# In[11]:


x_train, x_test, y_train, y_test = train_test_split(x,y)
from sklearn.linear_model import LinearRegression
lr = LinearRegression()
lr.fit(x_train, y_train)


# In[23]:


sns.scatterplot(x='sqft_living',y='price',data=houses)
plt.plot(x_train, lr.coef_*x_train + lr.intercept_, '-r', label='Intercept: '+str(lr.intercept_)+' \nSlope: '+str(lr.coef_))
plt.legend()

