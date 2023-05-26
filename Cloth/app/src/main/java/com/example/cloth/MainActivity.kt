package com.example.cloth

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.cloth.R.id.import_button
import java.io.File
import java.io.FileInputStream
import java.io.InputStream
import jxl.Workbook
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {

    private lateinit var importButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        importButton = findViewById(R.id.import_button)
        importButton.setOnClickListener {
            var intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.type  = "application/vnd.ms-excel"
            startActivityForResult(intent,1)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == 1 && requestCode == RESULT_OK){
            val uri: Uri? = data?.data
            val filePath = uri?.path

            if(filePath != null){
                val file = File(filePath)
                val inputStream: InputStream = FileInputStream(file)
                val workbook = Workbook.getWorkbook(inputStream)
                val sheet = workbook.getSheet(0)

                val clothesMap = mutableMapOf<String, Clothes>()
                val gson = Gson()

                for (i in 1 until sheet.rows) {
                    val engName = sheet.getCell(0, i).contents
                    val sSize = sheet.getCell(1, i).contents
                    val mSize = sheet.getCell(2, i).contents
                    val lSize = sheet.getCell(3, i).contents

                    val clothes = Clothes(engName, sSize, mSize, lSize)
                    clothesMap[engName] = clothes
                }

                val chineseMap = mutableMapOf<String, String>()
                val chineseJson = resources.openRawResource(R.raw.chinese).bufferedReader().use { it.readText() }
                val chineseList = gson.fromJson<List<Chinese>>(chineseJson, object : TypeToken<List<Chinese>>() {}.type)

                for (chinese in chineseList) {
                    chineseMap[chinese.engName] = chinese.chtName
                }

                for ((engName, clothes) in clothesMap) {
                    val chtName = chineseMap[engName]
                    if (chtName != null) {
                        clothes.chtName = chtName
                    }
                }

                val clothesJson = gson.toJson(clothesMap)
                Toast.makeText(this, clothesJson, Toast.LENGTH_LONG).show()

            }
        }
    }

    data class Clothes(
        val engName:String,
        val sSize: String,
        val mSize: String,
        val lSize: String,
        val chtName: String=""
    )

    data class Chinese(
        val chtName:String,
        val engName:String
    )
}