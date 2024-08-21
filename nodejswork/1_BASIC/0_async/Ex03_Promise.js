// Ex03_Promise.js

/*
    Promise 객체가 생성되면 대기 상태가 된다.
        - resolve() 함수가 실행되면 이행으로 변경
        - reject() 함수가 실행되면 거절로 변경

*/

const likeCoffee = true;

const coffee =() => {
    return new Promise((resolve,reject)=>{
        if(likeCoffee)resolve("커피를 주문한다");
        else reject('주문하지 않는다.')

    });
    //결론을 내기전에 대기상태로 바뀌게 된다.
}

function order (message) {
    console.log(message);

    return new Promise((resolve, reject)=> {
        setTimeout(()=>{
            console.log("커피를 포장한다");
        },2000);
    });
}

coffee().then((result)=> order(result));

console.log("다른작업");