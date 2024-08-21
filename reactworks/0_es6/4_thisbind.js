//4_thisbind.js

/*
기존의 자바스크립트에서 this는
   -기본적으로 함수가 호출 될 때마다 현재 함수를 보유한 객체가 this로 연결이 된다.
   - 함수를 보유한 객체가 없는 상환이면 this는 글로벌 변수를 뜻하게 된다.

*/

// [1]
const obj = {result : 0 }
// obj 라는 변수가 객체 result : 0 이라는 값을 저장한 상태로 초기화
obj.add = function(x,y){
    this.result = x + y;
}
//obj라는 변수에 add 라는 함수를 추가를 해주는데
//인자를 x,y 2개의 변수를 받고 그 인자 두개를 더해서 리턴을 해준다.
obj.add(2,3);
//obj에 추가된 add 라는 함수를 2,3 이라는 값을 넣어서 호출
console.log(obj);
console.log(obj.result);
console.log("1> ----------------------------------------------------");
/*

{ result: 5, add: [Function (anonymous)] }
5
객체가 가지고 있는 정보를 출력을 하고
obj가 갖고있는 result의 값이 5라는 결과가 나온다.
*/




const obj1 = {};
//obj1 이라는 변수인데 빈 객체를 가지고 있는 변수로 초기화
const add = function(x,y){
    this.result = x+y;
    //아무런 연관이 없어지게 되면서 글로벌 변수로 취급이 된다.
}
//변수 add 에 함수를 담아서 초기화를 해주는데 인자 2개를 받고 그 인자 2개를
// 더한 값을 리턴하는 함수를 add에 담아서 저장


//obj1와 add는 서로 연관이 없는데 bind 함수를 이용을 해서 둘의 연관을 만들어 낸다.
add.bind(obj1);

add(2,7); 
//add 라는 함수에 2와 7의 2개의 인자를 주고 호출
console.log(obj1);
//값을 출력을 했을때 obj1는 빈 객체를 가지고 있으므로 출력을 했을때
//여전히 빈값을 출력을 한다.
console.log(obj1.result);
//obj1는 빈 객체인데 안에 result의 값을 가지고 있는게 아니므로
//undefined값이 나온다.

//여기서 bind()로 묶어주지 않으면 result는 글로벌 변수로
//취급이 되서 출력을 하게 되면 다른 값이 나올 수도 있다.
console.log(result);
//add 라는 함수가 2개의 인자를 받은 값을 더해서 리턴이 하는데
// result 값이 나오는 이유는 이전에 출력을 했던 result의 변수에 담겨진 것이고
// bind로 obj1하고 result 가 묶여져서 글로벌 변수가 아닌 필드 변수로 사용되어졌다.
console.log("2> ----------------------------------------------------");



//[2] 중첩함수인 경우
const obj2 = {reuslt : 0 };
obj2.add = function(x,y){
    function inner () {
        this.result = x+y;
    }
    inner = inner.bind(this);
    inner();
    //bind 로 묶어주면 함수내에 있는 객체로 인식을 하게 되고
    //bind로 안묶어주게 되면 글로벌 변수로 취급이 된다.
    //
}
//inner 함수가 함수내에서 작동을 했을때의
//result 와 연관이 없기 때문에 undefind의 값이 나온것이다.
// inner = inner.bind(this)로 result 하고 연관이 생겨서 값을 찾을 수 있다.
obj2.add(2,3);
console.log(obj2);
console.log(obj2.result);
console.log("3> ----------------------------------------------------");
/*
const obj3 = { result1: 0 };
obj3.add = function(x, y) {
    const inner1 = () => {
        this.result1 = x + y;
    };
    inner1();
}
obj3.add(5, 3);
//여기도 함수에서와 같이 중첩함수에서도 에로우 함수는
// 기본적으로 this를 바인드를 해주기 때문에
// 값을 찾아 올 수 있다.

console.log(obj3);
console.log(obj3.result1);
console.log("4> ----------------------------------------------------");

 */



const obj3 = {reuslt1 : 0 };
obj3.add = function(x,y){
const inner1 = () => {this.result1=x+y};
inner1();
}
//여기도 함수에서와 같이 중첩함수에서도 에로우 함수는
// 기본적으로 this를 바인드를 해주기 때문에
// 값을 찾아 올 수 있다.
obj3.add(5,3);
console.log(obj3);
console.log(obj3.result1);
console.log("4> ----------------------------------------------------");



