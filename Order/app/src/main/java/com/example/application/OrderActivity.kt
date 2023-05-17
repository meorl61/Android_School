package com.example.application

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class OrderActivity : AppCompatActivity() {
    private var 訂購項目: String = ""
    private var 數量: Int = 0
    private var 單價: Int = 0
    private var 小計: Int = 0
    var 產品編號: Int = 0

    //設定Layout 變數
    private var tv_項目: TextView? = null
    private var tv_單價: TextView? = null
    private var tv_數量: TextView? = null
    private var tv_小計: TextView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)
        val bundle = intent.getBundleExtra("下訂")

        初值設定()

        訂購項目 = bundle?.getString("品名")!!
        產品編號 = bundle?.getInt("產品編號")!!
        單價 = bundle?.getInt("單價")!!
        數量 = bundle?.getInt("數量")!!
        小計 = bundle?.getInt("小計")!!
        tv_項目?.setText(訂購項目)
        tv_單價?.setText("" + 單價)
        tv_數量?.setText("" + 數量)
        tv_小計?.setText("" + 小計)

    }

    private fun 初值設定() {
        tv_項目 = findViewById(R.id.tv_訂購項目)
        tv_單價 = findViewById(R.id.tv_項目單價)
        tv_小計 = findViewById(R.id.tv_小計金額)
        tv_數量 = findViewById(R.id.tv_購買數量)
    }

    fun btn_加數量(view: View) {
        數量++
        顯示小計()
    }

    fun btn_減數量(view: View) {
        if (數量 > 0) {
            數量--
            顯示小計()
        }
    }

    private fun 顯示小計() {
        小計 = 單價 * 數量
        tv_數量?.setText("" + 數量)
        tv_小計?.setText("" + 小計)
    }

    fun btn_計算送出(view: View) {

        var bundle = Bundle().apply {
            putInt("產品編號", 產品編號)
            putInt("數量", 數量)
            putInt("小計", 小計)
        }

        setResult(Activity.RESULT_OK, Intent().putExtras(bundle));
        finish();
    }
}