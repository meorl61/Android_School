package com.example.webviewtest01_order

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class picpage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_picpage)
    }

    fun btn_change(view: View?) {
        var id = view?.id
        var 圖片drawableID: Int=0
        var 圖片名稱: String =""
        when (id) {
            R.id.btn_horn -> {
                圖片drawableID = R.drawable.hornets
                圖片名稱 = "黃蜂隊"
            }

            R.id.btn_rock -> {
                圖片drawableID = R.drawable.rockets
                圖片名稱 = "火箭隊"
            }
        }

        var 傳送data = pic_model(圖片drawableID, 圖片名稱)
        var intent = getIntent()
        intent.putExtra("圖片資料",傳送data)
        setResult(RESULT_OK,intent)
        finish()
    }
}