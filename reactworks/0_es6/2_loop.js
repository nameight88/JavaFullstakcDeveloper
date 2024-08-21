// 2_loop.js

//[0] 기존 자바스크립트
/*
const queryString = "kind=it&title=pyton&cnt=3"; //&을 기준으로 나눈다.
const chunk = queryString.split("&"); 
const result = {};
for (let i = 0 ; i< chunk.length;i+=1){
    const parts = chunk[i].split("=");//=을 기준으로 나눈다.
    result[parts[0]] = parts[1];
}
console.log(result);
*/
//[1] forEach
/*
const queryString = "kind=it&title=pyton&cnt=3"; //&을 기준으로 나눈다.
const chunks = queryString.split("&"); 
const result = {};

chunks.forEach((chunk)=>{
    const [key,value]= chunk.split("=");
    result[key]=value;
});

console.log(result);
*/


//[2] map을 이용
// forEach 와 map을 헷갈릴수 있다.
// forEach는 단순히 반복문 만을 돌리는것이지만 map은 리턴값이 있다.

const queryString = "kind=it&title=pyton&cnt=3"; //&을 기준으로 나눈다.
const chunks = queryString.split("&"); 
const result = chunks.map((chunk)=>{
    const [key,value] = chunk.split("=");
    return {key,value};
});

console.log(result);
// forEach 와 map의 사용 차이는 리턴값 유무
// 리턴값이 필요하면 map을 이용 필요 없는 경우에는 forEach를 이용하는 것이 좋다.
//기존에 방법과 forEach문을 이용을 했을때 출력의 차이는 조금 있지만 상관없을거 같다.

