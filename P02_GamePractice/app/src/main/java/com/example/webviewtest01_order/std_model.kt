package com.example.webviewtest01_order

import java.io.Serializable

class std_model:Serializable {
    var 學生姓名 = ""
    var 英文成績 = 0
    var 數學成績 = 0

    constructor(學生姓名: String, 英文成績: Int, 數學成績: Int) {
        this.學生姓名 = 學生姓名
        this.英文成績 = 英文成績
        this.數學成績 = 數學成績
    }
}