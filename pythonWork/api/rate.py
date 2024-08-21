import requests
import json
import pandas as pd
from bs4 import BeautifulSoup as bs

# apikey = 'ZJIQQTSE2AILTXKXEFQL'
# url = 'https://ecos.bok.or.kr/api/StatisticSearch/' + apikey \
#         + '/json/kr/1/100/121Y002/M/202201/202302'
# response = requests.get(url)
# result = response.json()
# list_total_count=(int)(result['StatisticSearch']['list_total_count'])
# list_count=(int)(list_total_count/100) + 1


# rows=[]
# for i in range(0,list_count):
#     start = str(i * 100 + 1)
#     end = str((i + 1) * 100)
    
#     url = 'https://ecos.bok.or.kr/api/StatisticSearch/' + apikey + '/json/kr/' \
#             + start + '/' + end + '/121Y002/M/202201/202302'
#     response = requests.get(url)
#     result = response.json()
#     rows = rows + result['StatisticSearch']['row']
    
# df=pd.DataFrame(rows)
# print(df)