from bs4 import BeautifulSoup # 웹 스크래핑(크롤링)에 필요한 라이브러리
import pandas as pd # 데이터 전처리 및 시각화에 필요한 라이브러리
import requests # url을 얻어올때 필요한 라이브러리
import numpy # 통계적 계산에 추가적으로 필요한 라이브러리
import FinanceDataReader as fdr #주식 정보 조회에 필요한 라이브러리

#네이버 금융 사이트 크롤링
# data = requests.get("https://finance.naver.com/sise/")
# #print(url)
# soup = BeautifulSoup(data.text,'html.parser')
# #print(soup)

#FinanceDataReader 을 이용한 주식 데이터 정보 조회

df_krx = fdr.StockListing('KRX')
df_krx.head()