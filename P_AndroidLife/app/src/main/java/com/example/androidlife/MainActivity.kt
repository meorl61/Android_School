package com.example.androidlife

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TableLayout
import android.widget.TableRow

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val layout = findViewById<LinearLayout>(R.id.layout)

        //建立tablelayout
        val tableLayout = TableLayout(this)
        val tableRow = TableRow(this)


        val circle = CircleView(this)

        val colorList = mutableListOf<Int>()
        colorList.add(Color.RED)
        colorList.add(Color.BLUE)
        colorList.add(Color.GREEN)
        colorList.add(Color.YELLOW)
        colorList.add(Color.MAGENTA)
        circle.setColors(colorList)
        tableRow.addView(circle)
        tableLayout.addView(tableRow)
        tableLayout.addView(tableRow)
        tableLayout.addView(tableRow)
        tableLayout.addView(tableRow)

        layout.addView(circle)
    }

}