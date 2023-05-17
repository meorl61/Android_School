package com.example.buddha32

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView


class ShowActivity2 : AppCompatActivity() {
    var tv_ki:TextView? = null
    var tv_ko:TextView? =null
    var tv_kg:TextView? = null
    var tv_ks:TextView? = null
    var tv_ke:TextView? =null
    var tv_km:TextView? =null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show2)
        設定初值()
    }

    private fun 設定初值() {
        tv_ki=findViewById(R.id.tv_ki)
        tv_km=findViewById(R.id.tv_km)
        tv_kg=findViewById(R.id.tv_kg)
        tv_ko=findViewById(R.id.tv_ko)
        tv_ks=findViewById(R.id.tv_ks)
        tv_ke=findViewById(R.id.tv_ke)

        var 取得內容 = intent.getBundleExtra("buddha32")
        val 籤號=取得內容?.getInt("籤號")
        var 卦爻=取得內容?.getString("卦爻")
        var 卦名=取得內容?.getString("卦名")
        var 吉凶=取得內容?.getString("吉凶")
        var 卦詞=取得內容?.getString("卦詞")
        var 卦義=取得內容?.getString("卦義")

        tv_ki?.setText("第" +籤號 +"籤")
        tv_km?.setText(卦名)
        tv_kg?.setText(吉凶+"籤")
        tv_ko?.setText(卦爻)
        tv_ks?.setText(卦詞)
        tv_ke?.setText(卦義)
    }

    fun btn_bak(view: View) {
        var intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}