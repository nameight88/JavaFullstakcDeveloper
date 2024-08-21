// App1.js

const express = require("express");
const app = express();
const port = 3000;

app.listen(port
    , () => {
        console.log("서버실행");
    }
);

// 요청(request)가 들어오면 지정된 함수를 호출(콜백함수)
//req/res인자를 줄여서 쓴다.
app.get("/", (req, res) => {
    res.send("노드 헬로우 성공");
});

app.get("/func1", (req, res) => {
    res.send("헬로우 1");
});

app.get("/func2", (req, res) => {
    res.send("헬로우 2");
});

// 콜백함수 다음에 미들웨어 함수 추가
//인자에서 2번째로 받는 함수를 콜백함수 3번째를 받는 함수를 미들웨어함수
app.get('/func3', (req, res, next) => {
    console.log("첫번째 호출 확인")
    next();
},
    function (req, res) {
        res.send("두번째 호출 확인")
    }
);


//콜백함수를 배열로 라우터처리도 가능하다.
const method1 = function(req,res,next){
    console.log("첫번째 호출 확인 1");
    next();
};

const method2 = function(req,res){
    res.send("두번째 호출 2 확인")
};

app.get("/func4",[method1, method2]);
