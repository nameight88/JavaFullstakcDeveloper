# apps / crud /dbconn.py

#참고) 자바에서의 views 파일이 파이썬에서의 views는 templates파일하고 똑같다
import pymysql

class Dateabase():
    def __init__(self):
        #맴버 변수 선언
        self.db = pymysql.connect(
            host='localhost',
            user='scott',
            password='tiger',
            database='basic',
            charset='utf8'
        )
        self.cursor = self.db.cursor(pymysql.cursors.DictCursor)
    def executeOne(self,query,args={}):
        self.cursor.execute(query,args)
        row = self.cursor.fetchone()
        return row

    def executeAll(self,query,args={}):
        self.cursor.execute(query, args)
        rows = self.cursor.fetchall()
        return rows

    def execute(self,query,args={}):
        self.cursor.execute(query,args)

    def commit(self):
        self.db.commit()