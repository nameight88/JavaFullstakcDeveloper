// 2_db /index.js


const mysql = require("mysql");
const sql = require("./sql.js");

//데이터베이스 연동
const pool = mysql.createPool(
    {
        host:'localhost',
        prot:3306,
        user:"scott",
        password:"tiger",
        database:'basic',
        connectionLimit:10
    }
);



//쿼리를 실행하고 결과를 반영하는 함수

const query = async(alias,value)=>{
    return new Promise( (resolve,reject) => { 
        pool.query(sql[alias],value,(error,result)=>{
        if(error){
            console.log('error')
            reject(error)
        }else{
            resolve(result)
        }
    })} );
       
};
//
module.exports = { query };