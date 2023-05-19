package com.example.androidlife

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.View

class CircleView (context: Context) : View(context) {

    //private var color = Color.BLACK
    //private var colors = arrayOf(Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW, Color.MAGENTA)
    private var colors = mutableListOf<Int>()
    private var radius = 0f

    fun setColors(colors:MutableList<Int>){
        this.colors = colors
    }

   // fun setColor(color: Int) {
   //     this.color = color
   // }

    fun setRadius(radius: Float) {
        this.radius = radius
    }


    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        //val colors = arrayOf(Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW, Color.MAGENTA)
        val radius = 50f //直徑
        val centerX = width / 2f
        val centerY = height / 2f
        val strokeWidth = 3f   //線的粗細
        val circlebetweenspace = 10   //圓的間隔
        for (i in colors.indices) {
            val paint = Paint() //新增一個畫筆
            paint.color = colors[i]  //顏色
            paint.style = Paint.Style.STROKE  //描邊  FILL 實心
            paint.strokeWidth= strokeWidth  //線粗細
            //strokeCap  線兩端樣式, butt 不出頭 , round 凸圓頭, square 凸方頭
            //strojkJoin 拐角樣式, path中，二線的連接處　miter銳角, bevel 平角, rould 圓角
            paint.isAntiAlias = true  //是否抗锯齿，边缘是否更圆滑

            canvas.drawCircle(centerX, centerY , radius + i *(strokeWidth+circlebetweenspace), paint)
        }
    }


}