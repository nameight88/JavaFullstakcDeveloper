const mongoose = require("mongoose")


const { Schema } = mongoose;

const empSchema = new Schema({
    empno : {
        type : Number,
        required : true,
        unique : true
    },
    ename : {
        type : String,
        required : true,
    },
    job : {
        type:String
    },
    sal : {type : Number}
});

/*
 스키마 타입
    Number / String / Date / Boolean
    ObjectId: 객체 아이디값
    Buffer : 파일을 담을 수 있다.
    Array : 여러개를 담을 수 있다.
*/

const Emp = mongoose.model("Emp",empSchema)

module.exports = Emp;