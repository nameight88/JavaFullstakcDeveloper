//Ex05_async+await.js

async function init(){
    const response = await fetch("https://jsonplaceholder.typicode.com/Users");
    const users = await response.json();
    
    console.log(users);
}

init();
