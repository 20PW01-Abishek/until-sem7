import pandas as pd
url='height.csv'
df = pd.read_csv(url)
print(df.sort_values(by='Height'))
print(df.boxplot(column='Height'))
print(df.describe())

q1=df.Height.quantile(0.25)
q3=df.Height.quantile(0.75)
IQR=q3-q1
lb=q1-1.5*IQR
ub=q3+1.5*IQR
print('\nq1: ',q1,'\nq3: ',q3,'\nIQR: ',IQR,'\nlb: ',lb,'\nub: ',ub)

flag = 0
for i in df['Height']:
    if (i<lb or i>ub) :
        print('Outlier: ',i)
        flag+=1
if flag == 0:
    print('\nNo outliers')