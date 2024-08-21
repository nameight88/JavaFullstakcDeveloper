//[1] 실행구동 확인
console.log('hello')

//[2] 웹구동확인
let http = require('http');

function onRequest(request,response){
   response.writeHead(200,{"Content-Type":"text/plain"});

   response.write("Hello~ World!!");

   response.end();

}

http.createServer(onRequest).listen(8888);