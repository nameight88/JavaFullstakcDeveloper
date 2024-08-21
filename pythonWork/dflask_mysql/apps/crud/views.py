# apps/ crud / views.py

from flask import Blueprint,render_template


crud = Blueprint('crud',__name__
                 ,static_folder="static"
                 ,template_folder="templates")

@crud.route('/')
def index():
    return render_template("crud/index.html")
#templates 파일을 스스로 찾아가기 때문에 index.html을 따로 만들 필요가 없다.

@crud.route('/dbtest')
def dbtest():
    from apps.crud import dbconn
    db_class = dbconn.Dateabase()
    query = "SELECT empno,ename FROM emp"
    result = db_class.executeAll(query)
    #print(result)
    return render_template("crud/dbtest.html",resultData=result)