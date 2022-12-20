import numpy as np   
import matplotlib.pyplot as plt
import pandas as pd

def res(df,x,f):
    count=0
    for i in range(3):
        for j in range(3):
            plt.figure()
            plt.scatter(f[count],df['price'])
            plt.title(x[count+2]+' vs Dependent (Price)')
            count+=1
    plt.show()
        

    Y=[]
    for i in df['price']:
        Y.append(int(i))
    X=[]
    for k in f:
        for i in k:
            X.append([1,i])

        Xt=np.transpose(X)

        # print("\nX Transpose X: ")
        XtX=np.dot(Xt,X)
        # print(XtX)

        # print("\nX Transpose X Inverse: ")
        XtXi=np.linalg.inv(XtX)
        # print(XtXi)
    
        # print("\nX Transpose Y:")
        XtY=np.dot(Xt,Y)
        # print(XtY)

        # print("\nB = XtXi*XtY matrix b0 b1:")
        B=np.dot(XtXi,XtY)
        # print(B)

        print("\nLinear equation of the model: ")
        if (B[0]<0):
            print("y="+str(B[1])+"x"+str(B[0]))
        else:
            print("y="+str(B[1])+"x+"+str(B[0]))
    return    
            
        
df = pd.read_csv('data.csv')

x=list(df.head(0))
f=[df['bedrooms'],df['bathrooms'],df['sqft_living'],df['sqft_lot'],df['floors'],df['waterfront'],df['view'],df['condition'],df['sqft_above'],df['sqft_basement']]

res(df,x,f)


# x = np.linspace(0,4600)
# y = B[1]*x+B[0]
# plt.plot(x, y, '-r')

# SSE=0
# SE=0
# for i in range(len(seed)):
#     SE+=seed[i]-(B[1]*soap[i]+B[0])
#     SSE+=(seed[i]-(B[1]*soap[i]+B[0]))**2 #Quantify the error
# print("Sum of errors: "+str(SE)+"\nSSE: "+str(SSE))

# Ybar = np.mean(Y)
# print("\nMean (Ybar): "+str(Ybar))

# S=0
# for i in seed:
#     S+=i-Ybar
# print("Sum of Yi-Ybar: "+str(S))

# SST=0
# for i in seed:
#     SST+=(i-Ybar)**2
# print("SST: "+str(SST))

# SSR=SST-SSE
# print("SSR: "+str(SSR))