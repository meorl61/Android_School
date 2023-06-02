package com.example.mybook

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.io.File
import java.io.FileNotFoundException
import java.io.IOException
import java.io.ObjectInputStream
import java.io.ObjectOutputStream

class PhoneBookMainActivity : AppCompatActivity() {
    val context = this
    var listView: ListView? = null
    var myListAdapter: MyListAdapter? = null

    private val fileName = "user_data.ser"

    // 學生陣列: arrayListOf() 快速建立ArrayList資料
    var stArrayList = mutableListOf<UserPhone>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        初始化ListView()
    }

    private fun 初始化ListView() {
        loaddata()
// 資料適配器
        myListAdapter = MyListAdapter()
// 尋找ListView
        listView = findViewById<ListView>(R.id.listview)
// 設定ListView 資料適配器
        listView?.adapter = myListAdapter
// 設定資料0筆時要顯示哪個View (通常用TextView顯示目前沒有資料)
        listView?.emptyView = findViewById<TextView>(R.id.empty)
// 設定(監聽器) 點選項目OnItemClick 要執行的程式
        listView?.setOnItemClickListener { parent, view, position, id ->
            val r2 = listView?.adapter?.getItem(position)

            val s = "position2=" + position + " " + r2.toString()
            Log.d("@@@", s)

        }

        listView?.setOnItemClickListener { parent, view, position, id ->
            val item = parent.getItemAtPosition(position)
            Log.d("@@@itemclick", item.toString())
            // 在這裡執行相應的操作，例如更新列表中的項目
        }
    }

    fun loaddata() {
        val userData = readUserData()
        if (userData != null) {
            stArrayList = userData
            Log.d("@@有資料", stArrayList.toString())
            // 顯示使用者資料
        } else {
            stArrayList = mutableListOf<UserPhone>()
            Log.d("@@無資料", stArrayList.toString())
            // 檔案不存在，顯示錯誤訊息
        }

    }

    fun click_add(view: View) {
// 圖片陣列新增p04 圖片id
        myListAdapter?.drawableArrayList?.add(R.drawable.p04)
// 學生陣列新增Mary

        var name = findViewById<EditText>(R.id.et_name)
        var eng = findViewById<EditText>(R.id.et_eng)
        var math = findViewById<EditText>(R.id.et_math)
        var btn = findViewById<Button>(R.id.btn_main)
        var editid = findViewById<TextView>(R.id.editid)
        var nametext = name.text
        var engtext = eng.text
        var mathtext = math.text
        var btntext = btn.text
        var editidtext = editid.text.toString().toIntOrNull() ?: -1
        val r2 = UserPhone(
            nametext.toString(),
            engtext.toString().toIntOrNull() ?: 0,
            mathtext.toString().toIntOrNull() ?: 0
        )
        //val r2=UserPhone("aaa",22,33)
        //myListAdapter?.stArrayList?.add(r2)
        if (btntext == "修改") {
            if (editidtext >= 0) {
                stArrayList[editidtext] = r2
                btn.setText("新增")
                Log.d("修改完寫入資料", stArrayList.toString())
                savedata()
            }
        } else {
            btn.setText("新增")
            stArrayList?.add(0, r2)

            Log.d("新增完寫入資料", stArrayList.toString())
            savedata()
        }
        name.setText("")
        eng.setText("")
        math.setText("")
        editid.setText("")
// 資料有異動，通知ListView 畫面需更新
        myListAdapter?.notifyDataSetChanged()
// 顯示短訊息
        Toast.makeText(context, "資料新增完成", Toast.LENGTH_SHORT).show()
        val imm = context?.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager?
        imm?.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0)

    }


    // inner 內部類別可使用外部類別資料，包含private 資料
    inner class MyListAdapter : BaseAdapter() { // 繼承BaseAdapter

        //var phoneMap: HashMap<String,UserPhone> = hashMapOf<String,UserPhone>()

        // 圖片陣列: arrayListOf() 快速建立ArrayList資料
        val drawableArrayList = arrayListOf<Int>(
            R.drawable.p01,
            R.drawable.p02,
            R.drawable.p03,
        )

        // 資料數量(由ListView 呼叫也稱為Callback 函式)
        override fun getCount(): Int {
            return stArrayList.size // 陣列大小即資料數量
        }

        // 取得某項目資料(學生) (由ListView 呼叫也稱為Callback 函式)
        override fun getItem(position: Int): Any {
            val r2 = stArrayList.get(position)
            return r2
        }

        // 取得某項目編號(由ListView 呼叫也稱為Callback 函式)
        override fun getItemId(position: Int): Long {
            val itemId = position + 0L
            return itemId
        }

        // 取得某項目用的Layout (由ListView 呼叫也稱為Callback 函式)
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
// 載入Layout
            val itemLayout = context.layoutInflater.inflate(R.layout.item_layout, null)
// 尋找Layout 裡面View
            val iv_image = itemLayout.findViewById<ImageView>(R.id.iv_item_image)
            val tv_item_n = itemLayout.findViewById<TextView>(R.id.tv_item_n)
            val tv_item_e = itemLayout.findViewById<TextView>(R.id.tv_item_e)
            val tv_item_m = itemLayout.findViewById<TextView>(R.id.tv_item_m)

            val bt_edit = itemLayout.findViewById<Button>(R.id.btn_edit)
            val bt_del = itemLayout.findViewById<Button>(R.id.btn_del)

            bt_edit.setOnClickListener {

                var name = findViewById<EditText>(R.id.et_name)
                var eng = findViewById<EditText>(R.id.et_eng)
                var math = findViewById<EditText>(R.id.et_math)
                var btn = findViewById<Button>(R.id.btn_main)
                var editid = findViewById<TextView>(R.id.editid)
                val r2 = stArrayList.get(position)

                editid.setText(position.toString())
                name.setText(r2.name)
                eng.setText(r2.eng.toString())
                math.setText(r2.math.toString())
                btn.setText("修改")
                Log.d("修改按下了position", position.toString())
                // 資料有異動，通知ListView 畫面需更新

                myListAdapter?.notifyDataSetChanged()
            }

            bt_del.setOnClickListener {
                Log.d("刪除按下了position", position.toString())
                Log.d("name", stArrayList[position].name.toString())
                AlertDialog.Builder(context)
                    .setTitle("是否確定刪除")
                    .setNeutralButton("是") { dialog, which ->
                        stArrayList.removeAt(position)
                        myListAdapter?.notifyDataSetChanged()
                        Log.d("刪除完寫入資料", stArrayList.toString())
                        savedata()
                    }
                    .setPositiveButton("否") { dialog, which ->
                    }.show()

                // 資料有異動，通知ListView 畫面需更新

            }
            // 顯示資訊
            val drawableId = drawableArrayList.get(position)

            val r2 = stArrayList.get(position)
            iv_image.setImageResource(drawableId)
            tv_item_n.setText(r2.name)
            tv_item_e.setText(r2.eng.toString())
            tv_item_m.setText(r2.math.toString())


            return itemLayout
        }
    }


    fun savedata() {
        try {
            val fos = openFileOutput(fileName, Context.MODE_PRIVATE)
            val oos = ObjectOutputStream(fos)
            Log.d("@@開始存檔", stArrayList.toString())
            oos.writeObject(stArrayList)
            oos.close()
            fos.close()
            Log.d("@@@", "存檔成功")
// 顯示訊息存檔成功
// 訊息停留時間
// LENGTH_SHORT 短
// LENGTH_LONG 長
            Toast.makeText(this, "存檔成功", Toast.LENGTH_SHORT).show()
        } catch (e: FileNotFoundException) {
            Log.d("@@@ 檔案找不到", e.toString())
        } catch (e: IOException) {
            Log.d("@@@ 輸出發生問題", e.toString())
        }

        val file = File(context.filesDir, fileName)
        if (file.exists()) {
            Log.d("@@a有檔案", "檔案存在")
        } else {
            Log.d("@@a無檔案", "檔案不存在")
        }


    }

    fun readUserData(): MutableList<UserPhone>? {
        //val file = File(fileName)
        val file = File(context.filesDir, fileName)
        if (file.exists()) {
            Log.d("@@有檔案", "檔案存在")
            try {
                val fis = openFileInput(fileName)
                val ois = ObjectInputStream(fis)
                stArrayList = ois.readObject() as MutableList<UserPhone> // as Student? 轉型
                ois.close()
                fis.close()

                Log.d("@@@", "讀檔成功" + stArrayList.toString())
                // 顯示訊息存檔成功
                // 訊息停留時間LENGTH_SHORT 短LENGTH_LONG 長
                Toast.makeText(this, "讀檔成功", Toast.LENGTH_SHORT).show()
                return stArrayList
            } catch (e: FileNotFoundException) {
                Log.d("@@@ 檔案找不到", e.toString())
            } catch (e: IOException) {
                Log.d("@@@ 輸出發生問題", e.toString())
            }
        } else {
            Log.d("@@無檔案", "檔案不存在")
            //file.createNewFile()
        }
        return null
    }
}