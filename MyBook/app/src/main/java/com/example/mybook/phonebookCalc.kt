package com.example.mybook

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.io.File
import java.io.FileNotFoundException
import java.io.IOException
import java.io.ObjectInputStream
import java.io.ObjectOutputStream

class phonebookCalc : AppCompatActivity() {
    // 儲存使用者資料檔案
    private val fileName = "user_data.ser"
    var stArrayList = mutableListOf<UserPhone>()
    fun savedata() {
        try {
            val fos = openFileOutput(fileName, Context.MODE_PRIVATE)
            val oos = ObjectOutputStream(fos)
            Log.d("@@開始存檔",stArrayList.toString())
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
    }

    fun readUserData(): MutableList<UserPhone>? {
        val file = File(fileName)
        if (file.exists()) {

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
        }
        else
        {
            //file.createNewFile()
        }
        return null
    }




}