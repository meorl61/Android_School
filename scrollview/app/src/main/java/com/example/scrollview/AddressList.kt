package com.example.scrollview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast


class AddressList : AppCompatActivity() {

    val phoneBook = PhoneBook()

    //private var cus: Customer? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_address)

        // 加載通訊錄
        phoneBook.loadPhoneBook()
    }


    fun btn_view(view: View) {

// 獲取通訊人列表
        val contacts = phoneBook.getContacts()

        Log.d("**data**",contacts.toString())

        var newuser : Customer?= Customer("name","sex","ldate","kdate","time","tel","memo")
        //畫面佈局載入器
        var li: LayoutInflater = LayoutInflater.from(this)

        //載入 R.layout
        var v:View = li.inflate(R.layout.addresslist,null,false)
        var ll: LinearLayout = findViewById(R.id.lt_s1)
        ll.removeAllViews()
        ll.addView(v)

        //讀檔
        var tv_name: TextView = v.findViewById(R.id.tv_name)
        var tv_sex: TextView = v.findViewById(R.id.tv_sex)
        var tv_ldate: TextView = v.findViewById(R.id.tv_ldate)
        var tv_kdate: TextView = v.findViewById(R.id.tv_kdate)
        var tv_time: TextView = v.findViewById(R.id.tv_time)
        var tv_tel: TextView = v.findViewById(R.id.tv_tel)
        var tv_memo: TextView = v.findViewById(R.id.tv_memo)

        //.text 簡化.setText()
        tv_name.text = newuser?.name.toString()
        tv_sex.text = newuser?.sex.toString()
        tv_ldate.text = newuser?.ldate.toString()
        tv_kdate.text = newuser?.kdate.toString()
        tv_time.text = newuser?.time.toString()
        tv_tel.text = newuser?.tel.toString()
        tv_memo.text = newuser?.memo.toString()

    }

    fun btn_del(view: View) {
        // 獲取通訊人
        val johnPhone = phoneBook.getContact("John")
        val janePhone = phoneBook.getContact("Jane")

// 刪除通訊人
        phoneBook.removeContact("John")
        // 保存通訊錄
        phoneBook.savePhoneBook()
    }
    fun btn_edit(view: View) {
        // 獲取通訊人
        val johnPhone = phoneBook.getContact("John")

        // 刪除通訊人
        phoneBook.removeContact("John")
        // 添加通訊人
        phoneBook.addContact(johnPhone?.name.toString(),johnPhone?.sex.toString(),johnPhone?.ldate.toString(),johnPhone?.kdate.toString(),johnPhone?.time.toString(),johnPhone?.tel.toString(),johnPhone?.memo.toString())
        phoneBook.savePhoneBook()
    }
    fun btn_add(view: View) {

        //畫面佈局載入器
        var li: LayoutInflater = LayoutInflater.from(this)

        //載入 R.layout
        var v:View = li.inflate(R.layout.addressedit,null,false)
        var ll: LinearLayout = findViewById(R.id.lt_s1)
        ll.removeAllViews()
        ll.addView(v)
    }

    fun btn_save(view: View) {
// 顯示短訊息
        Toast.makeText(this, "資料新增完成", Toast.LENGTH_SHORT).show()
        /*
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

         */
    }
}