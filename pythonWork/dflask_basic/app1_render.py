#app1_render.py

from flask import Flask,render_template
#import flask
app = Flask(__name__,static_folder="static",template_folder='templates')

@app.route('/hello')
def hello():
    return render_template('hello.html')

# http://127.0.0.1:5000/hello


@app.route("/hello_jinja/<nickname>")
def hello_jinja(nickname):
    return render_template('hello_jinja.html', name=nickname)
#http://127.0.0.1:5000/hello_jinja/홍길동
#http://127.0.0.1:5000/hello_jinja/홍길자