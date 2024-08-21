//Ex04_fetch.js
//fetch를 이용을 하게되면 json을 못한다.
fetch("https://jsonplaceholder.typicode.com/Users")
.then((response)=>response.json())
.then(users => console.log(users))


console.log("다른 작업")