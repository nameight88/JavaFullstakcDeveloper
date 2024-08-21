//연습

async function init(){
const response = await fetch("https://dummyjson.com/quotes")

    const quotes=users.quotes;
    
    const ransu = parseInt(Math.random()*30)

    console.log(quotes[ransu].quote)
}

init();
