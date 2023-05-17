package com.example.applicationgame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView

class score : AppCompatActivity() {
    private var score = 0
    private var tv_score: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score)
        初值設定()
    }

    private fun 初值設定() {
        score=0
        tv_score = findViewById(R.id.tv_score)
    }

    fun 顯示得分(){
        var s = ""+score
        Log.d("log顯示得分:",s)
        tv_score?.setText(s)
    }

    fun clickAdd(view: View?) { //3個按鈕都執行相同方法, view 代表目前被按下的 Button
        var id=view?.getId()
        /*
        if(id==R.id.btn3){}
        else if(id==R.id.btn2){}
         */
        when(id){//透過id 來判斷是哪個按鈕被按下
            R.id.btn3 -> {
                score+=3
                顯示得分()
            }

            R.id.btn2 -> {
                score+=2
                顯示得分()
            }

            R.id.btn1 -> {
                score+=1
                顯示得分()
            }
        }

    }
}