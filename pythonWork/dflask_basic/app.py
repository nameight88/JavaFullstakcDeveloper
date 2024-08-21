#app.py

from flask import Flask

app = Flask(__name__)

@app.route('/')#스프링에서의 컨트롤러와 비슷한 기능
def hello_world():
    return "Hello~~~ world"