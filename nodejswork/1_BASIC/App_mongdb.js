const express = require('express');

const app = express();

app.listen(3000,()=>{
    console.log("서버 구동");

});

const mongodb = require("./3_mongodb");
mongodb.connect();

const Emp = require("./3_mongodb/schemas/emp");

// 전체검색

app.get("/emp",async(req,res)=>{
    const employees = await Emp.find();
    console.log(employees);
    res.send(employees);
});

// 입력

app.get('/empInsert',async (req,res) => {
    const emp1 = await Emp.create({
        empno :1111,
        ename : "박길동",
        job :"개발",
        sal : 4000
    });
    console.log(emp1);
});


//

app.get("/empInsert2",async(req,res)=>{
    const emp1 = await Emp.create([
        {
            empno :1113,
            ename : "최길동",
            job :"IT",
            sal : 5000
        },
        {
            empno :1114,
            ename : "김길동",
            job :"개발",
            sal : 6000
        }
    ]);
    console.log(emp1);
})


//검색

app.get("/empTest",async(req,res)=>{
    //전체검색
    //const employees = await Emp.find();
   
    //월급 5000이상
    //const employees = await Emp.find({sal:{$gte:5000}});
    
    //월급이 5000이상 이름이 김길동인 사람
    //const employees = await Emp.find({
    //    sal : {$gte:5000},
    //    ename : "김길동"
    //})

    // 이름이 '길동'이 포함된 문서를 검색
    //const employees = await Emp.find({ename:/길동/});

    const employees = await Emp.find({ename:/길동/},'ename sal'); 
    //길동을 포함하는 문서를 검색하는데 이름과 월급만 나오게 출력
    console.log(employees);
    res.send(employees);
    // / / 슬래시 안에 내가 원하는 키워드를 넣으면 포함된 문서를 검색할 수 있다.
})

//async을 이용 하는 이유는 데이터베이스에서 값을 가져오는데 시간이 필요한데
//await을 사용하기 위해서
// 수정

app.get("/empUdate1",async(req,res)=>{
    const emp1 = await Emp.updateOne({empno:1113},{job:'개발'});
    console.log(emp1);
});
//조건이 앞으로 와야하고 뒤에 적용대상을 적어줘야한다.

app.get("/empUdate2",async(req,res)=>{
    const emp1 = await Emp.updateMany({sal : {$gte : 5000}},{job:"디자인"});
    console.log(emp1);
});


//삭제

app.get("/empDelete1",async(req,res)=>{
    const emp2 = await Emp.deleteOne({empno:1113});
});

app.get("/empDelete2",async(req,res)=>{
    const emp2 = await Emp.deleteMany({sal : {$gte : 6000}})
});