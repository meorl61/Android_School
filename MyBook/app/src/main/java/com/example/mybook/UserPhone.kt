package com.example.mybook

import android.text.Editable

class UserPhone {
    var name ="未命名"
    var eng = -1
    var math = -1

    constructor(name: String, eng: Int, math: Int) {
        this.name = name
        this.eng = eng
        this.math = math
    }

    override fun toString(): String {
        return "Result2(name='$name', eng=$eng, math=$math)"
    }

}