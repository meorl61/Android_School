package com.example.webviewtest01_order

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView

const val 圖片KEY = 1
const val 學生資料KEY = 2

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun btn_pic(view: View) {
        var intent = Intent(this,picpage::class.java)
        startActivityForResult(intent,圖片KEY)
    }
    fun btn_stddata(view: View) {
        var intent = Intent(this,stdpage::class.java)
        startActivityForResult(intent,學生資料KEY)
    }

    override fun onActivityResult(回傳KEY: Int, 回傳結果: Int, 回傳data: Intent?) {
        super.onActivityResult(回傳KEY, 回傳結果, 回傳data)
        when (回傳KEY){
            圖片KEY ->{
                if(回傳結果== RESULT_OK){
                    var r1 = 回傳data?.getSerializableExtra("圖片資料") as pic_model
                    var ib_img:ImageView = findViewById(R.id.iv_btn)
                    ib_img.setImageResource(r1.圖片id)
                }
            }
            學生資料KEY ->{
                if(回傳結果== RESULT_OK){
                    var r1 = 回傳data?.getSerializableExtra("學生資料") as std_model
                    var tv_name:TextView=findViewById(R.id.tv_name)
                    var tv_eng:TextView=findViewById(R.id.tv_eng)
                    var tv_math:TextView=findViewById(R.id.tv_math)
                    tv_name.setText("學生姓名："+r1.學生姓名)
                    tv_eng.setText("英文成績："+r1.英文成績)
                    tv_math.setText("數學成績："+r1.數學成績)

                }
            }
        }

    }
}