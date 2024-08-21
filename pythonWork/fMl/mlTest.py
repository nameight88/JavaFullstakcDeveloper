from flask import Flask, request, jsonify
import pandas as pd
import numpy as np
from sklearn.ensemble import RandomForestClassifier
from sklearn.preprocessing import StandardScaler

#app = Flask(__name__)

model = None
scaler = None
def train_model():
    global model,scaler
    data = pd.DataFrame({
        'GDP_Growth': np.random.normal(0.5, 0.2, 100),
            'Inflation_Rate': np.random.normal(2, 0.5, 100),
            'Interest_Rate': np.random.normal(3, 0.3, 100),
            'Unemployment_Rate': np.random.normal(4, 0.5, 100),
            'Target': np.random.randint(0, 2, 100)
    })

    X = data[['GDP_Growth','Inflation_Rate','Interest_Rate','Unemployment_Rate']]
    Y = data["Target"]

    scaler=StandardScaler()
    X_scale=scaler.fit_transform(X)

    model = RandomForestClassifier(n_estimators=100,random_state=42)
    model.fit(X_scale,Y)

train_model()

data = request.json
features = pd.DataFrame(data, index=[0])
scaled_features = scaler.transform(features)
prediction = model.predict(scaled_features)
probability = model.predict_proba(scaled_features)[0][1]