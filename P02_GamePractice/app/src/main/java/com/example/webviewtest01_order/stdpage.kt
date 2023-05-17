package com.example.webviewtest01_order

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView

class stdpage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stdpage)
    }

    fun btn_changedata(view: View) {
        var etname:EditText? =findViewById(R.id.et_name)
        var eteng:EditText?=findViewById(R.id.et_eng)
        var etmath:EditText?=findViewById(R.id.et_math)
        var tv_msg:TextView=findViewById(R.id.tv_errmsg)
        tv_msg.setText("")
        var name=etname?.text.toString()
        var eng=eteng?.text.toString().toIntOrNull()?:0
        var math=etmath?.text.toString().toIntOrNull()?:0
        if (name=="") {
            tv_msg.setText("請輸入學生姓名!")
        }
        if (eng<0 ||eng>100)
        {tv_msg.setText("英文成績錯誤, 請重新輸入!")}
        if (math<0 ||math>100)
        {tv_msg.setText("數學成績錯誤, 請重新輸入!")}
        if(tv_msg.text.toString()=="")
        {
        var 傳送stddata=std_model(name,eng,math)
        //寄放資料
        var intent = getIntent()
        intent.putExtra("學生資料",傳送stddata)

        setResult(RESULT_OK,intent)
        finish()
        }
    }
}