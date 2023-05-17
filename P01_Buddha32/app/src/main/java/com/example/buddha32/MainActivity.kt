package com.example.buddha32

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View

val 籤筒 = mutableMapOf<String,poisy>()

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        poisydata()

       // aa.poisydata()

    }

    fun go_get(view: View) {


        //Log.d("a長度:",aa.size.toString())

        var 抽籤=""
        for(i in 0..4 )
        {
            抽籤+=搖卦(i)
        }

        var 內容=籤筒[抽籤]
        Log.d("內容",內容.toString())
        Log.d("卦名",內容?.卦名.toString())
        Log.d("籤號",內容?.籤號.toString())
        var intent = Intent (this,ShowActivity2::class.java)
        //intent.putExtra("抽的爻",內容)
        val bundle= Bundle().apply {
            putInt("籤號", 內容?.籤號 ?: 0)
            putString("卦名",內容?.卦名)
            putString("卦爻",內容?.卦爻)
            putString("吉凶",內容?.吉凶)
            putString("卦詞",內容?.卦詞)
            putString("卦義",內容?.卦義)
        }
        intent.putExtra("buddha32",bundle)
        startActivity(intent)
        finish()
    }

    fun 搖卦(num:Int):String {
        var geta="○"
        var i=(0 .. 1).random()
        if(i==1)
        {
            geta="金木水火土".substring(num..num)
        }
        return geta
    }

    fun poisydata() {
        var aa=put32()
        var 籤詩32=aa.籤詩32
        var 籤詩=poisy()
        Log.d("籤詩32size",籤詩32.size.toString())
        for( i in 0 .. 籤詩32.size-1){
            籤詩=poisy()
            籤詩.籤號 = 籤詩32[i][0].toInt()
            籤詩.卦名 = 籤詩32[i][1]
            籤詩.吉凶 = 籤詩32[i][2]
            籤詩.卦爻 = 籤詩32[i][3]
            籤詩.卦詞 = 籤詩32[i][4]
            籤詩.卦義 = 籤詩32[i][5]

            籤筒.put(籤詩.卦爻,籤詩)
        }
        /*
        for (key in 籤筒.keys) {
            Log.d("籤筒log","Key = "+key +", "+"Value = "+籤筒[key]?.卦名.toString())
        }
*/


    }


}