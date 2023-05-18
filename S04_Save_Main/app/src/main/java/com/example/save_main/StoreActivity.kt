package com.example.save_main

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import java.io.FileNotFoundException
import java.io.IOException
import java.io.ObjectInputStream
import java.io.ObjectOutputStream

class StoreActivity : AppCompatActivity() {

    private val filename = "st.ser"
    private var st: Student? =null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private fun 建立學生物件(){
        val tv_name = findViewById<EditText>(R.id.et_name)
        val tv_eng = findViewById<EditText>(R.id.et_eng)
        val tv_math = findViewById<EditText>(R.id.et_math)
        var gname = tv_name.text.toString()
        var geng = tv_eng.text.toString().toIntOrNull()?:-1
        var gmath = tv_math.text.toString().toIntOrNull()?:-1
        st = Student(gname,geng,gmath)
        Log.d("@@@",st.toString())
    }
    private fun 存檔() {
        try{
            val fos = openFileOutput( filename, Context.MODE_PRIVATE)
            val oos = ObjectOutputStream(fos)
            oos.writeObject(st)
            oos.close()
            fos.close()

            //Toast浮動訊息
            //訊息停留時間 LENGTH_SHORT 短 LENGTH_LONG長
            Toast.makeText(this,"存檔成功",Toast.LENGTH_SHORT).show()
        } catch (e: FileNotFoundException){
            Log.d("@@@檔案找不到",e.toString())
        } catch (e:IOException){
            Log.d("@@@輸出發生問題",e.toString())
        }
    }
    private fun 讀檔() {
        try{
            val fis = openFileInput(filename)
            val ois = ObjectInputStream(fis)
            st=ois.readObject() as Student? //as Student? 轉型
            ois.close()
            fis.close()
            Toast.makeText(this,"讀檔成功",Toast.LENGTH_SHORT).show()
            Log.d("@@@檔案內容",st.toString())
        } catch (e: FileNotFoundException){
            Log.d("@@@檔案找不到",e.toString())
        } catch (e:IOException){
            Log.d("@@@輸出發生問題",e.toString())
        }
    }
    private fun 顯示(){
        val tv_name = findViewById<EditText>(R.id.et_name)
        val tv_eng = findViewById<EditText>(R.id.et_eng)
        val tv_math = findViewById<EditText>(R.id.et_math)
        tv_name.setText(""+st?.name)
        tv_eng.setText(""+st?.eng)
        tv_math.setText(""+st?.math)
    }
    fun click_save(view: View) {
        建立學生物件()
        var err=0
        if( st?.name.toString() =="")
        {err=1
            Toast.makeText(this,"請輸入姓名", Toast.LENGTH_SHORT).show()
        }
        if( st?.eng.toString().toIntOrNull()?:-1 >100 || st?.eng.toString().toIntOrNull()?:-1<0)
        {err=1
            Toast.makeText(this,"英文分數錯誤,請重新輸入", Toast.LENGTH_SHORT).show()
        }
        if( st?.math.toString().toIntOrNull()?:-1 >100 || st?.math.toString().toIntOrNull()?:-1<0)
        {err=1
            Toast.makeText(this,"數學分數錯誤,請重新輸入", Toast.LENGTH_SHORT).show()
        }
        if(err==0)
        {
        存檔()}
    }

    fun click_load(view: View) {
        讀檔()
        顯示()
    }
    fun click_clear(view: View) {
        val tv_name = findViewById<EditText>(R.id.et_name)
        val tv_eng = findViewById<EditText>(R.id.et_eng)
        val tv_math = findViewById<EditText>(R.id.et_math)
        tv_name.setText("")
        tv_eng.setText("")
        tv_math.setText("")
    }
}