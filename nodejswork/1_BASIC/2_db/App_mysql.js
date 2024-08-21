// 2_db /App_mysql.js

const express = require('express');
const app = express();
const port = 3000;

app.listen(port,()=>{
    console.log("서버시작")
});


const mysql = require("./mysql"); //기본 값이 index.js 실행

//데이터 검색
app.get("/api/employee",async(req,res)=> {
    const employees = await mysql.query("employeeList");
    console.log(employees);
    res.send(employees);

});

//부서번호 검색
app.get("/api/dept",async(req,res)=> {
    const dept = await mysql.query("deptList");
    console.log(dept);
    res.send(dept);

});


//데이터 입력
app.use(express.json({limit : '50mb'}));
app.post("/api/employee/insert",async(req,res)=>{
    console.log("입력");
    console.log(req.body);

    const result = await mysql.query("employeeeInsert",req.body.param);
    res.send(result)
});

//부서 입력
app.use(express.json({limit:'50mb'}));
app.post("/api/dept/insert",async(req,res)=>{
    console.log("부서번호 입력")
    console.log(req.body);

    const result = await mysql.query("deptInsert",req.body.param);
    res.send(result)
})

//데이터 수정
app.put("/api/employee/update",async(req,res)=>{
    console.log("수정")
    console.log(req.body)
    const result = await mysql.query("employeeUpdate",req.body.param);
    res.send(result)
});

app.put("/api/dept/update",async(req,res)=>{
    console.log("수정")
    console.log(req.body)
    const result = await mysql.query("deptUpdate",req.body.param);
    res.send(result)
});

//데이터 삭제
app.delete("/api/employee/delete/:id",async(req,res)=>{
    console.log("삭제");
    const { id } = req.params;
    const result = await mysql.query("employeeDelete",id);
    res.send(result);
});