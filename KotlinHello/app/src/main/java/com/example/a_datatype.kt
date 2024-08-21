package com.example

fun main(){
    //코틀린은 문장이 끝난고 나서 ; 를 붙히지 않아도 된다.
//    print("Hello World")

    // [1] 변수(var)와 상수(val)
    // 자료형 : 객체
    //       : Byte,Short,Int,Long,Float,Double
    
    var a : Int = 10 //[java] int a = 10; , Integer a = new Integer(10) JAVA 15이하
    
    var b : Int = 20
    
    var c = 30 // 자료형 생략 가능

    val d = 40 // 상수로도 자료형이 생략이 가능하다.

    c = 100

//    d = 100  d는 상수로 주소 값을 변경 불가능하게 선언을 했기 때문에
//    오류가 발생한다.

    val str = "안녕하세요"
    val str2 = """
       안녕
        하
        세
        요
        
    """.trimIndent()
    
    if (str == str2) print("동일")
    else println("둘이 같지 않음")


    val arr1 : Array<Int> = arrayOf(1,2,3,4,5)
//    println(arr1) 출력을 했을때의 배열의 모든 값이 아닌 주소값이 나온다.
    for (i in arr1){
        println(i)
    }//파이썬의 for문과 자바의 for을 합친 느낌?

    println(arr1[3])
}