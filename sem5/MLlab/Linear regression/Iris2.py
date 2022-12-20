import pandas as pd
import seaborn as sns
df = pd.read_csv('Iris.csv')

sns.catplot(x='Species',y='SepalLengthCm',data=df,kind='box')
sns.catplot(x='Species',y='SepalWidthCm',data=df,kind='box')
sns.catplot(x='Species',y='PetalLengthCm',data=df,kind='box')
sns.catplot(x='Species',y='PetalWidthCm',data=df,kind='box')

def f (Colname,Species):
    if Species=='Iris-setosa':
        arr = [Colname][:50]
    elif Species == 'Iris-virginica':
        arr = [Colname][50:100]
    elif Species


print(df.shape)
for column in df.columns[1:-1]:
    for specy in df["Species"].unique():
        Specy_type=df[df["Species"]==specy]
        Selected_column=Specy_type[column]
        avg = Selected_column.mean()
        std = Selected_column.std()
        upper_lmt = avg + (3 * std) 
        lower_lmt= avg - (3 * std)
        outliers=Selected_column[((Selected_column > upper_lmt) | (Selected_column< lower_lmt))].index # picking outliers' indeces
        df.drop(index=outliers, inplace=True) # dropping outliers
        print(column,specy,outliers)

 
# q1=df.SepalLengthCm.quantile(0.25)
# q3=df.SepalLengthCm.quantile(0.75)
# IQR=q3-q1
# lb=q1-1.5*IQR
# ub=q3+1.5*IQR
    
# print('\nq1: ',q1,'\nq3: ',q3,'\nIQR: ',IQR,'\nlb: ',lb,'\nub: ',ub)
# flag = 0
# for i in df['SepalLengthCm']:
#     if (i<lb or i>ub) :
#         print('Outlier: ',i)
#         flag+=1
# if flag == 0:
#     print('\nNo outliers for SepalLengthCm')
    
# q1=df.SepalWidthCm.quantile(0.25)
# q3=df.SepalWidthCm.quantile(0.75)
# IQR=q3-q1
# lb=q1-1.5*IQR
# ub=q3+1.5*IQR
    
# print('\nq1: ',q1,'\nq3: ',q3,'\nIQR: ',IQR,'\nlb: ',lb,'\nub: ',ub)
# flag = 0
# for i in df['SepalWidthCm']:
#     if (i<lb or i>ub) :
#         print('Outlier: ',i)
#         flag+=1
# if flag == 0:
#     print('\nNo outliers for SepalWidthCm')
    
# q1=df.PetalLengthCm.quantile(0.25)
# q3=df.PetalLengthCm.quantile(0.75)
# IQR=q3-q1
# lb=q1-1.5*IQR
# ub=q3+1.5*IQR
    
# print('\nq1: ',q1,'\nq3: ',q3,'\nIQR: ',IQR,'\nlb: ',lb,'\nub: ',ub)
# flag = 0
# for i in df['PetalLengthCm']:
#     if (i<lb or i>ub) :
#         print('Outlier: ',i)
#         flag+=1
# if flag == 0:
#     print('\nNo outliers for PetalLengthCm')
    
# q1=df.PetalWidthCm.quantile(0.25)
# q3=df.PetalWidthCm.quantile(0.75)
# IQR=q3-q1
# lb=q1-1.5*IQR
# ub=q3+1.5*IQR
    
# print('\nq1: ',q1,'\nq3: ',q3,'\nIQR: ',IQR,'\nlb: ',lb,'\nub: ',ub)
# flag = 0
# for i in df['PetalWidthCm']:
#     if (i<lb or i>ub) :
#         print('Outlier: ',i)
#         flag+=1
# if flag == 0:
#     print('\nNo outliers for PetalWidthCm')