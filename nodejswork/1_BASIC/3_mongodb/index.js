// index.js

const mongoose = require("mongoose")

const connect = ()=>{

    const mongoose = require('mongoose');

    mongoose.connect(
      'mongodb://root:admin1234@127.0.0.1:27017',
      { dbName: 'test' },
      (error) => {
        if (error) {
          console.log("연결 실패", error);
        } else {
          console.log("연결 성공");
        }
      }
    );
    
}





module.exports= { connect }