package com.example.scrollview

import java.io.Serializable

class Customer: Serializable {
    //private val serialVersionUID = 1L // L 即 logn 長整數

    var name = ""
    var sex = ""
    var ldate = ""
    var kdate = ""
    var time = ""
    var tel = ""
    var memo = ""

    constructor(
        name: String,
        sex: String,
        ldate: String,
        kdate: String,
        time: String,
        tel: String,
        memo: String
    ) {
        this.name = name
        this.sex = sex
        this.ldate = ldate
        this.kdate = kdate
        this.time = time
        this.tel = tel
        this.memo = memo
    }

    override fun toString(): String {
        return "customer(serialVersionUID=$serialVersionUID, name='$name', sex='$sex', ldate='$ldate', kdate='$kdate', time='$time', tel='$tel', memo='$memo')"
    }

}