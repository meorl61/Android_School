package com.example.runimage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import java.util.Random

class MainActivity : AppCompatActivity() {

    // lateinit 稍後會設定初值不會是空值
    lateinit var img_arraylist: ArrayList<Int>
    lateinit var btn_start: Button
    lateinit var btn_stop: Button
    lateinit var btn_clear: Button
    lateinit var tv_message: TextView
    lateinit var img: ImageView
    lateinit var handler: Handler // 任務管理員
    lateinit var task: MyTask // 任務

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init() //初始化
    }




    fun init() {
// 陣列圖片id
        img_arraylist = arrayListOf<Int>(
            R.drawable.b2_3s,
            R.drawable.b2_2s,
            R.drawable.b2_1s,
            R.drawable.b2_2s
        )
        img = findViewById(R.id.iv_img)
        img.setBackgroundResource(R.drawable.b2_2s) // 設定圖片
        tv_message = findViewById(R.id.tv_message)
        btn_start = findViewById(R.id.btn_start)
        //btn_stop = findViewById(R.id.btn_stop)
        //btn_clear = findViewById(R.id.btn_clear)
// 設定按鈕監聽器
        btn_start.setOnClickListener(StartOnClick())
       // btn_stop.setOnClickListener(StopOnClick())
      //  btn_clear.setOnClickListener(ClearOnClick())
// 建立任務管理員
        handler = Handler(Looper.getMainLooper())
// 建立任務
        task = MyTask()
    }
    // 任務
    inner class MyTask : Runnable { // Runnable 任務
        var count = 0 // 換圖次數
        var i = 0 // 第幾張圖
        var isDone = false // 任務是否完成
        override fun run() {
            if (isDone) { // 如果任務完成
                return // 結束方法
            }
            tv_message.text = "開始擲筊..."
            btn_start.isEnabled = false // start按鈕無作用(不可按)
// 顯示訊息
            //tv_message.text = "i=" + i.toString() + " count=" + count
// 顯示圖片
            val imgId = img_arraylist.get(i)
            img.setBackgroundResource(imgId)
// 若i 加1 後等於陣列大小
            if (++i == img_arraylist.size) {
                i = 0
            }
// 提交任務1000毫秒(1秒) 後執行
            handler.postDelayed(this, 200)
// 若count 加1 後大於9
            if(++count > 13) {
                isDone = true // 任務完成
                btn_start.isEnabled = true // start按鈕有作用(可按)

                val random = Random()
                val randomNumber = random.nextInt(3)
                when (randomNumber) {
                    1 ->{img.setBackgroundResource(R.drawable.p_1s)
                        tv_message.text = "聖杯"}
                    2 ->{img.setBackgroundResource(R.drawable.p_2s)
                        tv_message.text = "笑杯"}
                    else -> {img.setBackgroundResource(R.drawable.p_0s)
                        tv_message.text = "無杯"}
                }
                //task.reset()
            }
        }
        fun reset() {
            i = 0
            count = 0
            isDone = false
        }
    }
    // OnClick 監聽器

    inner class StartOnClick : View.OnClickListener {
        override fun onClick(v: View?) {
// 提交任務1000毫秒(1秒) 後執行
            handler.postDelayed(task, 200)
            task.reset()
        }
    }
    // OnClick 監聽器
    inner class StopOnClick : View.OnClickListener {
        override fun onClick(v: View?) {
            handler.removeCallbacks(task) // 移除任務
            btn_start.isEnabled = true // start按鈕有作用(可按)
        }
    }
    // OnClick 監聽器
    inner class ClearOnClick : View.OnClickListener {
        override fun onClick(v: View?) {
            tv_message.text = "請擲筊"
            img.setBackgroundResource(R.drawable.b2_2s)
            btn_start.isEnabled = true // start按鈕有作用(可按)
            task.reset()
        }
    }
}