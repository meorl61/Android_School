package com.example.scrollview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import java.io.FileNotFoundException
import java.io.IOException
import java.io.ObjectInputStream

class AddressList : AppCompatActivity() {

    val phoneBook = PhoneBook()

    private var cus: Customer? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_address)

        // 加載通訊錄
        phoneBook.loadPhoneBook()
    }


    fun btn_view(view: View) {





// 獲取通訊人列表
        val contacts = phoneBook.getContacts()


        /*
        var newuser = customer("name","sex","ldate","kdate","time","tel","memo")
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
        tv_name.text = newuser.name
        tv_sex.text = newuser.sex
        tv_ldate.text = newuser.ldate
        tv_kdate.text = newuser.kdate
        tv_time.text = newuser.time
        tv_tel.text = newuser.tel
        tv_memo.text = newuser.memo*/
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
        phoneBook.addContact(johnPhone?.name.toString(),johnPhone?.name.toString(),johnPhone?.name.toString(),johnPhone?.name.toString(),johnPhone?.memo.toString())
        phoneBook.savePhoneBook()
    }
    fun btn_add(view: View) {


        //畫面佈局載入器
        var intent = Intent(this,Address_add::class.java)
        startActivity(intent)
        finish()
    }
}