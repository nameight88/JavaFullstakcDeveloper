#app_v1.py
from flask import Blueprint

#app = Blueprint() 
# 1번째 인자는 블루 프린트 앱 이름을 설정
# 2번째 인자는 보통 __name__ 으로 지정을 많이 해준다.
# 3번째 인자는 url을 구별하기 위한 경로

app = Blueprint("v1",__name__,url_prefix="/v1")

@app.route('/users')
def users():
    return "여기는 v1/users 입니다."