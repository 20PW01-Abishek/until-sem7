import pandas as pd
df = pd.read_csv('Iris.csv')

print(df.shape)
print("\n-------------------------------------------------------------------------------\n")
print(df['SepalLengthCm'].describe())
print(df['SepalWidthCm'].describe())
print(df['PetalLengthCm'].describe())
print(df['PetalWidthCm'].describe())


print("\n-------------------------------------------------------------------------------\n")
print('Mode')
print(df['SepalLengthCm'].mode())
print(df['SepalWidthCm'].mode())
print(df['PetalLengthCm'].mode())
print(df['PetalWidthCm'].mode())

print("\n-------------------------------------------------------------------------------\n")
print('Kurosis')
print(df['SepalLengthCm'].kurtosis(skipna=True))
print(df['SepalWidthCm'].kurtosis(skipna=True))
print(df['PetalLengthCm'].kurtosis(skipna=True))
print(df['PetalWidthCm'].kurtosis(skipna=True))

print("\n-------------------------------------------------------------------------------\n")
print('Skewness')
print(df['SepalLengthCm'].skew(skipna=True))
print(df['SepalWidthCm'].skew(skipna=True))
print(df['PetalLengthCm'].skew(skipna=True))
print(df['PetalWidthCm'].skew(skipna=True))

#or
print(df)
print(df.describe())
print("Co-variance")
print(df.cov())
print('Coeff of co-relation')
print(df.corr(method="pearson"))
print(df.corr(method="kendall"))
print(df.corr(method="spearman"))
df.plot()