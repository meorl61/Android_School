package com.example.webviewtest01_order

import java.io.Serializable

class pic_model : Serializable{
    var 圖片id = 0
    var 圖片名稱 = ""

    constructor(圖片id: Int, 圖片名稱: String) {
        this.圖片id = 圖片id
        this.圖片名稱 = 圖片名稱
    }


}