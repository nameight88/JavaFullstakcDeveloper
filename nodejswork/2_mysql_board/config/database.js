// config / database.js

//const mysql = require("mysql") //mysql이라는 함수를 호출해서 변수에 저장
//const sql = require("./sql") 있다가 에제에서 exports 사용해서 모듈화 해보기



//exports로 꼭 사용을 해야한다.
module.exports = {
    host : 'localhost',
    user : "scott",
    password : "tiger",
    database : "basic"
}


