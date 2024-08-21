//operator.js

//[1] 논리연산자 결합

const arr = ['one','tow'];

const first = arr[0];
const third = arr[2];

console.log(first); // one
//console.log(second);
console.log(third); //undefinde

console.log(first || "empty"); // one

console.log(third || "empty"); // empty

//[2] 삼항연산자 (truthy/flasy)

//const truthy = 0 
// true가 아닌 숫자 1을 넣었을 경우나 -1도 넣었을 경우 참이 나온다.
//0이 아닌 모든 숫자가 참으로 나온다.
// 빈문자열이 아닌 문자열도 참으로 나온다.
//var truthy = [];
// 빈 배열일 경우에도 참으로 나온다.
//파이썬에서는 빈 배열은 flase로 나온다.
//var truthy ={};
//비어있는 객체도 참으로 나온다.
//const result1 = truthy ? "참" : "거짓"; //true일 경우 '참' 아닐 경우 '거짓'
//console.log(result1);


//var flasy = false;
//var flasy = 0;
//var flasy = ''; // 빈 문자열
//var flasy = NaN; //걀측치 혹은 없는갑
//var flasy = undefinde;
var flasy =  null;



const result2 = flasy ? "참2" : "거짓2"; //true일 경우 '참' 아닐 경우 '거짓'
console.log(result2);


//[3] 요소 분해
var list = [100,200];
var [a,b=-2,c=-1] = list;


console.log(a);
console.log(b);
console.log(c);


[b,a] = [a,b];
console.log(a);
console.log(b);




//[4] 전개연산자

const objOne = {hana:1,dul:2,gitta:3};
const objTow= {sam:3,sa:4,giita:-1};
const old_combined = {
    hana: objOne.hana
    ,dul: objOne.dul
    ,sam : objTow.sam
    ,sa :objTow.sa,
    gita : objTow.gitta

}
console.log("에전방식",old_combined);

const new_combined = {...objOne, ...objTow}

console.log(new_combined);

// 객체 요소분해
var {gita,...others} = new_combined;
console.log(gita);
console.log(others);


//가볍게 정리
const obj = {name : "홍길동",age:22,dept:"IT"}
const obj2 = obj;
obj2.name= "이순신";
console.log(obj);
console.log(obj2);


const obj3 = {...obj, name:"세종대왕"}
console.log(obj);
console.log(obj3);

//같은 참조값을 사용을 하고 있기 때문에 변경이 name이 변경이 된다.