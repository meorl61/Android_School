package com.example.application

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    var tv_訂購明細: TextView? = null
    var 購買項目: MutableList<產品> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        設定菜單()
    }

    fun 設定菜單() {
        if (購買項目.size == 0) {
            購買項目.add(0, 產品("漢堡",60))
            購買項目.add(1, 產品("薯條",35))
            購買項目.add(2, 產品("可樂",25))
            購買項目.add(3, 產品("蛋塔",45))
        }
    }

    fun goto點餐畫面(產品編號: Int) {
        val ordermenu = Intent(this, OrderActivity::class.java)

        var bundle = Bundle().apply {
            putInt("產品編號", 產品編號)
            putString("品名", 購買項目[產品編號].品名)
            putInt("單價", 購買項目[產品編號].單價)
            putInt("數量", 購買項目[產品編號].數量)
            putInt("小計", 購買項目[產品編號].小計)
        }

        ordermenu.putExtra("下訂", bundle)
        startActivityForResult(ordermenu, 2)
    }

    fun btn_點漢堡(view: View) { goto點餐畫面(0) }
    fun btn_點薯條(view: View) { goto點餐畫面(1) }
    fun btn_可樂(view: View) { goto點餐畫面(2) }
    fun btn_點蛋塔(view: View) { goto點餐畫面(3) }

    public class 產品( var 品名: String = "",var 單價: Int = 0,var 數量: Int = 0,var 小計: Int = 0) {}

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        //獲得點餐結果, 寫入陣列
        super.onActivityResult(requestCode, resultCode, data)

        data?.extras?.let {
            if (requestCode == 2) {
                //var bundle= intent.getBundleExtra("回傳")
                var 產品編號: Int = it.getInt("產品編號")
                購買項目[產品編號].數量 = it.getInt("數量")
                購買項目[產品編號].小計 = it.getInt("小計")
                顯示訂購明細()
            }
        }
    }

    private fun 顯示訂購明細() {
        var 總計: Int = 0
        var 明細: String = ""

        for (i in 0..購買項目.size - 1) {
            if (購買項目[i].數量 > 0) {
                總計 += 購買項目[i].小計
                明細 +=  (if (明細 != "") "\n" else "")  + 購買項目[i].品名 + "($" + 購買項目[i].單價 + ")  X " + 購買項目[i].數量 + "  ...  $" + 購買項目[i].小計
            }
        }
        if (總計 > 0) {
            明細 += "\n\n合計金額: $" + 總計
        }
        tv_訂購明細 = findViewById(R.id.tv_訂購明細)
        tv_訂購明細?.setText(明細)
    }

}




