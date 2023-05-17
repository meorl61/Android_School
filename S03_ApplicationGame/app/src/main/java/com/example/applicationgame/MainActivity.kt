package com.example.applicationgame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import java.io.Serializable

//常數 const 類似 Java 的 public static final
const val 請求編號_r1 = 1
const val 請求編號_r2 = 2
const val KEY_r1 = "KEY_Result1"
const val KEY_r2 = "KEY_Result2"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun btn1(view: View) {
        var intent = Intent(this, Result1Activity::class.java)
        startActivityForResult(intent, 請求編號_r1) //切換Activity 請求結果
    }
    fun btn2(view: View) {
        var intent = Intent(this,Result2Activity::class.java)
        startActivityForResult(intent, 請求編號_r2)
    }

    override fun onActivityResult(請求編號: Int, 結果狀態: Int, 意圖data: Intent?) {
        super.onActivityResult(請求編號, 結果狀態, 意圖data)
        when (請求編號){
            請求編號_r1 -> {
                if(結果狀態 == RESULT_OK){
                    var r1 = 意圖data?.getSerializableExtra(KEY_r1) as Result1 //轉型
                    Log.d("@@@ 收結果",r1.toString())

                    //顯示圖片 沒有使用 ImageView? 表示不會是 null
                    var iv: ImageView = findViewById(R.id.iv)
                    iv.setImageResource(r1.圖片id) // .圖片id 簡化 .get圖片id()
                }
            }
            請求編號_r2->{
                var r2 = 意圖data?.getSerializableExtra(KEY_r2) as Result2 //as 轉型
                Log.d("@@@ 收結果",r2.toString())

                //顯示文字
                var tv_name: TextView = findViewById(R.id.tv_name)
                var tv_eng: TextView = findViewById(R.id.tv_eng)
                var tv_math: TextView = findViewById(R.id.tv_math)

                //.text 簡化 .setText()
                tv_name.text = r2.name
                tv_eng.text = r2.eng.toString()
                tv_math.text = r2.math.toString()
            }
        }
    }



}