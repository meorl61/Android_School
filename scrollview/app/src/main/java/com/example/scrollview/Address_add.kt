package com.example.scrollview
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText



class Address_add : AppCompatActivity() {
    val phoneBook = PhoneBook()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_address_add)

        phoneBook.loadPhoneBook()
    }


    fun btn_save(view: View) {
        var cus :Customer? = null
        var et_name = findViewById<EditText>(R.id.et_name)
        var et_sex = findViewById<EditText>(R.id.et_sex)
        var et_ldate = findViewById<EditText>(R.id.et_ldate)
        var et_kdate = findViewById<EditText>(R.id.et_kdate)
        var et_time = findViewById<EditText>(R.id.et_time)
        var et_tel = findViewById<EditText>(R.id.et_tel)
        var et_memo = findViewById<EditText>(R.id.et_memo)
        var name = et_name.text.toString()
        var sex = et_sex.text.toString()
        var ldate = et_ldate.text.toString()
        var kdate = et_kdate.text.toString()
        var time = et_time.text.toString()
        var tel = et_tel.text.toString()
        var memo = et_memo.text.toString()



        // 添加通訊人
        phoneBook.addContact(name,sex,ldate,kdate,time,tel,memo)
        phoneBook.savePhoneBook()

        var intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
        finish()
    }



}