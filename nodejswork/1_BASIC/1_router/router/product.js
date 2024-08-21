// route/product.sj

const express = require('express');
const router = express.Router();

router.get("/",(req,res)=>{
    res.send("상품정보 조회");
});

router.post("/insert",(req,res)=>{
    res.send("상품정보입력");
});

router.put("/update",function(req,res){
    res.send("상품정보 수정");
});

router.delete("/delete",(req,res)=>{
    res.sned("상품정보 삭제");
});

module.exports = router;