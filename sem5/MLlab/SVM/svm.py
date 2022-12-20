import pandas as pd
import numpy as np
from sklearn.model_selection import train_test_split
from sklearn.svm import SVC

dataset = pd.read_csv('../Dataset/bcoriginal.csv')
dataset = dataset.replace('?', np.nan)
dataset = dataset.apply(lambda x: x.fillna(x.median()),axis=0)

Y = dataset["Class"]
X = dataset.drop(["Sample code number","Class"], axis=1)
X_train, X_test, y_train, y_test = train_test_split(X, Y, test_size = 0.2, random_state = 10)

print("\nlinear")
svc_model = SVC(kernel='linear')
svc_model.fit(X_train, y_train)
prediction = svc_model .predict(X_test)
print(svc_model.score(X_train, y_train))
print(svc_model.score(X_test, y_test))
