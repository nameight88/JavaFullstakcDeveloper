package com.example



/*
    코틀린의 장점 중 하나라고 말할 수 있는 게
    null 값의 처리
 */
fun main(){

    //[0] null 값을 허용
    val a : String = ""
    val b : String
    // lateinit : 변수만 선언하고 값을 나중에 들어오는 경우
    // lateinit val b : String

//    val c : string = null
    //초기 값을 처음부터 null 값 초기화에서 오류가 발생한다.

    //null 값을 초기화 허용을 해주는 변수로 선언을 해주어야한다.
    val c : String? = null
    // 자료형 선언을 하는 부분에서 ? 을 붙힘으로써 null값으로 초기화를 허용을 해준다.

    println(a)
//    println(b)
    //b를 사용해서 출력을 할려고 했을때 오류가 발생한다.
    println(c)

    b = "이제 값을 줘봤음"
    println(b)

    // b 변수에 새로운 변수를 초기화 후에 사용이 가능해졌다.

    // (2024.07.11기준)몇달전에는 val b : String 이렇게 빈값으로 설정을 해줬을 경우 에러가 났었다.

    var test : String
    test = "하이"
    // 경고문까지만 뜨고 에러가 뜨진 않는다.

//    lateinit val test  오류 발생
//    lateinit var test

    //[1] null 값에 대한 보증
    val msg : String? = "코틀린"
//    val str : String = msg

    /*
    이 패턴을 사용할 경우 오류가 발생한다.
    msg는 null값을 허용을 해주지만 str은 null 값을 허용을 해죽시 때문에 오류가 발생한다.
     */

    val str : String? = msg

    val str2 : String = msg!!
    // 이 방식으로도 null 값을 허용해주는 방법이 있다.

    println("add1 호출:" + add1(3,4))
    println("add2 호출:" + add2(5,8))
    println("add3"+ add3(5,5))
    println("add4"+add4(5,7))
}
/*
    int add1(int a, int y){
        return a+b
    }

    def add1(a,b):
    return a+b


 */

//[2]함수 생성

fun add1(x:Int,y:Int): Int {
    return x+y
}

fun add2(x:Int,y:Int) = x+y
// 리턴값이 간단할 경우 이렇게 메소드를 생성 할수 있다.

var add3 = {x:Int,y:Int -> x+y}
// JS es6 문법처럼 화살표 함수처럼 생성이 가능하다.

val add4 = {x:Int , y:Int -> x+y}
// val과 var 둘다 상관 오류가 발생하지 않는다?