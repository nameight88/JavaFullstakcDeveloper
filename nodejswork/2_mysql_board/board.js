//board.js

const express = require("express")
const ejs = require("ejs")
const path = require("path")
const bodyParaser = require("body-parser")

const app = express();

app.set("port",process.env.PORT || 3000);
app.set("view engine","ejs");
app.use(bodyParaser.urlencoded({extended:true}));

app.listen(app.get("port"),()=>{
    console.log("Express 서버 구동 >> ",app.get("port"));
});


//데이터베이스 연동
const mysql = require("mysql");
const dbconfig = require("./config/database"); // .js를 붙혀도 되고 안해도 되고
const conn = mysql.createConnection(dbconfig);
//mysql 안에 함수 중에 createConnection에 내가 만들어준 데이터베이스 정보를 전송

//console.log("디비연동 성공", conn);

app.get("/",(req,res)=>{
    const sql = "SELECT BNUM, BTITLE, BNAME, " +
    "       BCONTENT, MID, BPW, " +
    "       date_format(INSERTDATE, '%Y-%m-%d') AS INSERTDATE, " +
    "       date_format(UPDATEDATE, '%Y-%m-%d') AS UPDATEDATE " +
    "FROM NODE_BOARD";


    conn.query(sql,function(err,result,fields){ // fields는 넣어도 되고 안해도 되고
        if (err) throw err; //에러가 발생시 실행하지 않고 예외처리
        console.log(result);

        //뷰페이지 렌더링
        // res.render("파일경로",{데이터명:전송할 데이터}) 키 벨류 형식
        res.render("board_index",{users : result})

    })
});

//글쓰기 입력화면

app.get("/create",(req,res)=>{
    //console.log("글쓰기화면");
    res.sendFile(path.join(__dirname,"public/board_write.html"));
    //파이썬 처럼 __함수__ 형식이 아닌 __함수 형식으로 사용을 해줘야한다.
});

// 글쓰기 저장
app.post("/insert",(req,res)=>{
    const btitle = req.body.btitle;
    const bname = req.body.bname;
    const mid = req.body.mid;
    const bpw = req.body.bpw;
    const bcontent = req.body.bcontent;

    const param = [ btitle,bname,mid,bpw,bcontent];
    //console.log("사용자 입력값: ",param);

    const sql = "INSERT INTO NODE_BOARD " +
    " (BTITLE, BNAME, BCONTENT, MID, BPW, INSERTDATE, UPDATEDATE) " +
    " VALUES (?, ?, ?, ?, ?, now(), now())";
    

    conn.query(sql,param,(err,result,fields)=>{
        if (err) throw err;
        console.log("입력성공",result);
        res.redirect('/');
    });
});


//수정화면

app.get("/edit/:bnum",(req,res)=>{ 
//이후에 번호가 들어오는걸 변수로 받아서 처리하게끔 설정
    const bnum = req.params.bnum;
    //console.log("수정할 글 번호 : ",bnum);
    const sql = "SELECT BNUM, BTITLE, BNAME, " +
    "       BCONTENT, MID, BPW, " +
    "       date_format(INSERTDATE, '%Y-%m-%d') AS INSERTDATE, " +
    "       date_format(UPDATEDATE, '%Y-%m-%d') AS UPDATEDATE " +
    " FROM NODE_BOARD"+
    " WHERE BNUM=? ";
    conn.query(sql,[bnum],(err,result,fileds)=>{
        if (err) throw err;
        console.log("글 번호에 의한 번호 조희",result);

        res.render("board_edit",{user: result});
        //변수명 지정은 마음대로 설정이 가능하다.
    } )
    //2번째 인자는 insert pram 배열 변수이므로 그거에 맞춰서 bum도 배열에 넣어준다.
})

//수정하기 액션을 받아오기
app.post("/update/:bnum",(req,res)=>{
    const bnum = req.params.bnum; //액션에서 넘어오는 글번호를 변수에 저장
    const btitle = req.body.btitle;
    const bname = req.body.bname;
    const mid = req.body.mid;
    const bpw = req.body.bpw;
    const bcontent = req.body.bcontent;
    const param = [btitle,bname,bcontent,mid,bpw,bnum]
    //console.log("내용확인 : ",param)
    const sql  = "UPDATE NODE_BOARD " +
    "SET BTITLE = ?, BNAME = ?, BCONTENT = ?, MID = ?, BPW = ?, UPDATEDATE = now() " +
    "WHERE BNUM = ?";


    conn.query(sql,param,(err,result,fields)=>{
        if (err) throw err;
        console.log("수정성공",result);
      res.redirect('/');
   });
});


app.get("/delete/:bnum",(req,res)=>{
   const bnum = req.params.bnum;

   const sql = "DELETE FROM NODE_BOARD "+
   " WHERE BNUM = ?";
   
   conn.query(sql, bnum,(err,result,fields)=>{
    if(err) throw err;
    console.log("삭제성공",result);
    res.redirect('/');
   })
});
