//3_function.js

//[0] function 명령어

function func1 (first,second){
    return first+ second;
}

console.log(func1(1,2));


// [1] function literal (함수변수)
const func2 = function(first,second){
    return first+second;
}

console.log(func2(2,4));

// [2] arrow function
const func3 = (first,second) => {
    return first+second;
}

console.log(func3(4,4));


const func4 = (first,second)=> first+second;
// func3와 같은 방식이지만 한가지만 리턴을 해도 상관이 없는 코드면
// 이렇게해서 축약을 할 수 있다.
console.log(func4(5,5))


class MyClass {
    value =10;
    constructor(){
        
        const func1_add = function(f,s){
            return this.value +f+s;
        }.bind(this);
        console.log("확인",func1_add(10,20));
        //이렇게 했을 경우에 에러가 발생을 한다.
        //this.value를 했을때의 값을 찾아주지 못한다.
        //bind()로 필드 변수로 선언이 된 value를 찾아 갈 수 있게 해줘야한다.
        
       const func2_add = (f,s)=>this.value + f+ s;
       console.log("확인2",func2_add(10,20));
       //단순히 함수를 표현하는 방식이 에로우 방식으로 달라진거 하나뿐인데
       // 오류가 발생을 하는것이 사라졌다.
       // 이렇게 차이가 나는 것은 에로우 함수는 바인딩을 하기 때문에 위에서 필드
       //변수로 선언이 된 value를 가져 올 수 있지만 기존의 방식은
       // 바인딩을 안해줬기때문에 안된다.
    }
        
}

const my = new MyClass();