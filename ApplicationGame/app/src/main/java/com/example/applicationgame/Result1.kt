package com.example.applicationgame

import java.io.Serializable

class Result1: Serializable {
    var 圖片id = 0
    var 圖片名稱=""

    constructor(圖片id: Int, 圖片名稱: String) {
        this.圖片id = 圖片id
        this.圖片名稱 = 圖片名稱
    }

    override fun toString(): String {
        return "Result1(圖片id=$圖片id, 圖片名稱='$圖片名稱')"
    }

}