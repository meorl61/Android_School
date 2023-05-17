package com.example.usethesamebtn

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    var score=0
    var tv_score: TextView?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        設定初值()
    }

    private fun 設定初值() {
        score=0
        tv_score = findViewById(R.id.tv_score)
    }


    fun addbtn(view: View?) {
        var id= view?.id
        when(id){
            R.id.btn_3 ->{
                score +=3
                顯示得分()
            }
            R.id.btn_2 ->{
                score +=2
                顯示得分()
            }
            R.id.btn_1 ->{
                score +=1
                顯示得分()
            }
        }



    }

    private fun 顯示得分() {
        tv_score?.setText(score.toString())
    }
}