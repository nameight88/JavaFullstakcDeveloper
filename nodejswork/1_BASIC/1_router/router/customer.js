// router/customer.js

const express = require('express');
const router = express.Router();

router.get('/',function(req,res){
    res.send("고객정보 조회 /customer 라우터")
});


router.post('/insert',function(req,res){
    res.send("고객정보 입력 /customer/insert 라우터")
});

router. put('/update',function(req,res){
    res.send("고객정보 수정 /customer/update 라우터")
});

router.delete('/delete',function(req,res){
    res.send("고객정보 삭제 /customer/delete 라우터")
});

module.exports = router; //외부에서 사용이 가능하게 끔 설정