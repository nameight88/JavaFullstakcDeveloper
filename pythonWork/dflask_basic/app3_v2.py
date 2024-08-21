#app3_v2.py
from flask import Blueprint


app = Blueprint("v2",__name__,url_prefix="/v2")

@app.route('/users')
def users():
    return "여기는 v2/users 입니다."