package com.example.changepage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun btn_page(view: View) {
        var intent = Intent(this,viewpage2::class.java)
        startActivity(intent)
        finish()
    }
    fun btn_tab(view: View) {
        var intent = Intent(this,TabActivity::class.java)
        startActivity(intent)
        finish()
    }
}