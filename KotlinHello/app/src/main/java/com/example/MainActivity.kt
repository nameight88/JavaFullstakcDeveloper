package com.example

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    //코틀린의 상속 받는 방법 : 을 사용해서 상속을 받는다.


    //override 어노테이션이 왼쪽 끝에 붙어서 표시를 해준다.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        // activity_main.xml에 화면에 설정을 해준다.
        //화면을 지정을 해주눈 메소드 R.은 리소스의 약자
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        // 화면 요소를 변수랑 지정
        /*
            var : 값이 변하는 변수를 저장하는 자료형 타입
            
            val : 값이 변하지 않는 상수를 저장하는 자료형 타입
            
            JS에서의 const와 JAVA final과 유사한 타입
         */
        val btn = findViewById<Button>(R.id.button);
        // 자료형 제너릭을 사용을 해주어야한다.
        val tx = findViewById<TextView>(R.id.textView);

        // 리스너와 같은 메소드를 이용을 해주어야한다.
        // 버튼 이벤트
        btn.setOnClickListener{
            tx.text = "버튼 클릭";
        }
    }
}