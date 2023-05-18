package com.example.save_main

import java.io.Serializable

class Student:Serializable {

    private val serialVersionUID =1L

    var name = "未命名"
    var eng = -1
    var math =-1

    constructor(name: String, eng: Int, math: Int) {
        this.name = name
        this.eng = eng
        this.math = math
    }

    override fun toString(): String {
        return "Student(serialVersionUID=$serialVersionUID, name='$name', eng=$eng, math=$math)"
    }

}