import requests
import json
import pandas as pd
from bs4 import BeautifulSoup as bs



"""
apikey='ZJIQQTSE2AILTXKXEFQL'

rows=[]
rows_a=[]
url = 'https://ecos.bok.or.kr/api/StatisticSearch/' + apikey + '/json/kr/1/10/802Y001/D/20220101/20240201/0001000'
#for i in range(0,list_count):
for i in range(0,1):
    response = requests.get(url)
    result = response.json()
    rows = rows + result['StatisticSearch']['row']
    
df=pd.DataFrame(rows)
print(df)

url = 'https://ecos.bok.or.kr/api/StatisticSearch/' + apikey + '/json/kr/1/10/901Y014/A/2022/2024/1020000'

for i in range(0,11):
        response = requests.get(url)
        result = response.json()
        rows = rows+result['StatisticSearch']["row"]
        print(rows)
"""