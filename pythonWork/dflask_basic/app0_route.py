#app0_route.py
from flask import Flask

app = Flask(__name__)

@app.route('/')#스프링에서의 컨트롤러와 비슷한 기능
@app.route("/index")
def hello_world():
    return "Hello~~~ world 22222"

@app.route("/users/<username>")
def get_user(username):
    return username+"님이 입장하셨습니다."


@app.route("/posts/<int:post_id>")
def get_post(post_id):
    return str(post_id) + "번 글을 확인"
#문자열과 숫자형 자료형이 나와서 리턴을 할때
#자료형을 변환을 해주어야한다.