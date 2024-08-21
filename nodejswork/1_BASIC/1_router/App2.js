//App2.js

const express = require("express");
const app = express();
const port = 3000;

app.listen(port
    , () => {
        console.log("서버실행");
    }
);

app.route("/").get(function(req,res){
    res.send("노드 헬로우 성공22")
});

//위의 방식과 동일한 방식이다. 
//app.route("/").get((req,res)=>{
// res.senc("노드 헬로우 성공")
//});

app.route('/member')
    .get(function(req,res){
        res.send("고객정보조회");
    })
    .post(function(req,res){
        res.send("고객정보입력");
    })
    .put(function(req,res){
        res.send("고객정보수정");
    })
    .delete(function(req,res){
        res.send("고객정보삭제");
    });
//각각의 신호에 맞춰서도 만들어 줄 수 있다.

