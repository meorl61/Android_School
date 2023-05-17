package com.example.applicationgame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import java.util.Objects

class Result2Activity : AppCompatActivity() {
    var ed_name: EditText? = null
    var ed_eng: EditText? = null
    var ed_math: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result2)
        設定初值()
    }

    private fun 設定初值() {
        ed_name = findViewById(R.id.ed_name)
        ed_eng = findViewById(R.id.ed_eng)
        ed_math = findViewById(R.id.ed_math)
    }

    fun btn_ok(view: View) {
        //.text 簡化寫法 getText()
        var n = ed_name?.text.toString()
        //var m = ed_math?.text.toString().toInt()
        //var e = ed_eng?.text.toString().toInt()
        var m = ed_math?.text.toString().toIntOrNull()?:-1
        var e = ed_eng?.text.toString().toIntOrNull()?:-1

        var r2 = Result2(n, e, m) //建立物件 簡化 new
        Log.d("@@@寄結果", r2.toString())

        //寄放資料
        val intent = getIntent()
        intent.putExtra(KEY_r2, r2)

        setResult(RESULT_OK, intent)
        finish()
    }
}