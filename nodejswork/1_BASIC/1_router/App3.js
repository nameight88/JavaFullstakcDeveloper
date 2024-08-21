//App3.js

const express = require("express")

const app = express();
const port = 3000;

app.listen(port,()=>{
    console.log("서버 실행")
});

const customerRoute = require('./router/customer')//js생략
const productRoute = require("./router/product")
app.use("/customer",customerRoute);
app.use("/product",productRoute);