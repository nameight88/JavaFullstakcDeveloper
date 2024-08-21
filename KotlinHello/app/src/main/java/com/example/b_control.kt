package com.example

fun main(){
    //[0]if
    val a =10
    val b =10

    var max = if(a>b) a else b
    println("큰값: "+max)

    //[1] for
    for(i in 1 .. 10 ){
        print(i)
    }
    println()

    for(i in 1 downTo  10 step 2){
        print(i)
    }
    println()

    //[2] While
    var x = 10
    while(x>0){
        x-=1
        print(x)
    }
    println()

    //doWhile

    var y = 10
    do {
        y-=1
        print(y)
    }while (y>0)
    println()

    //[3] when 코틀린 만의 문법 Java Switch와 유사한 개념이라고 볼 수 있다.
    val z = 0
    when(z){
        1 -> println("1인경우")
        2,3 -> println("2 또는 3인 경우 ")// 2가지를 한번에 가능하다
        in 4..7 -> print("4부터 7인 경우")
        !in 5..20 -> println("5에서 20이 아닌경우")
        else -> println("그 외에 경우")
    }
}