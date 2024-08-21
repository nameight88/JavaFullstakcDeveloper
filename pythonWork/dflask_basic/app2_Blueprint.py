#app2_Blueprint.py


'''
    Blueprint
        - 앱의 규모가 커질 때 앱을 분할 하여 관리
        - 공통 url을 묶어서 관리
        -
'''

from flask import Flask
from  app3_v1  import app as v1_app
from  app3_v2  import app as v2_app

app = Flask(__name__)
app.register_blueprint(v1_app)
app.register_blueprint(v2_app)

'''
[서버 실행]
flask --app app2_Blueprint run

[브라우저 확인]
http://127.0.0.1:5000/v1/users
http://127.0.0.1:5000/v2/users
'''
