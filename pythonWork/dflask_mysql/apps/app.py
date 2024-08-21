# apps/ app.py
from flask import Flask


def create_app():
    app = Flask(__name__)
    #파이썬은 메소드내에서 import가 가능하지만 권장하진 않는다.
    from apps.crud import views as crud_views

    app.register_blueprint(crud_views.crud,url_prefix="/crud")

    return app