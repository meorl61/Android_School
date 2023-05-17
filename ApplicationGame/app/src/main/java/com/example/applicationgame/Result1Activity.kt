package com.example.applicationgame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View

class Result1Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result1)
    }

    fun clickHornets(view: View) {
        var 圖片id: Int
        var 圖片名稱: String
        圖片id = R.drawable.hornets
        圖片名稱 = "黃蜂隊"
        val r1 = Result1(圖片id,圖片名稱) //建立物件 簡化 new
        Log.d("@@@ 寄圖片黃蜂結果",r1.toString())

        //寄放資料
        val intent = getIntent()
        intent.putExtra(KEY_r1,r1)

        //設定結果狀態
        //RESULT_OK 結果順利
        //RESULT_CANCELED 因故取消
        setResult(RESULT_OK,intent)
        finish()
    }

    fun clickRockets(view: View) {
        var 圖片id: Int
        var 圖片名稱: String
        圖片id = R.drawable.rockets
        圖片名稱 = "火箭隊"
        val r1 = Result1(圖片id,圖片名稱) //建立物件 簡化 new
        Log.d("@@@ 寄圖片火箭結果",r1.toString())

        //寄放資料
        val intent = getIntent()
        intent.putExtra(KEY_r1,r1)

        //設定結果狀態
        //RESULT_OK 結果順利
        //RESULT_CANCELED 因故取消
        setResult(RESULT_OK,intent)
        finish()
    }


}