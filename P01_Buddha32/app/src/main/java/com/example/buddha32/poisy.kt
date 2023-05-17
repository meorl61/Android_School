package com.example.buddha32

import java.io.Serializable

class poisy :Serializable{
    var 籤號=0
    var 卦爻=""
    var 卦名=""
    var 吉凶=""
    var 卦詞=""
    var 卦義=""
    constructor(){
        var 籤號=0
        var 卦爻=""
        var 卦名=""
        var 吉凶=""
        var 卦詞=""
        var 卦義=""
    }
    constructor(籤號: Int, 卦爻: String, 卦名: String, 吉凶: String, 卦詞: String, 卦義: String) {
        this.籤號 = 籤號
        this.卦爻 = 卦爻
        this.卦名 = 卦名
        this.吉凶 = 吉凶
        this.卦詞 = 卦詞
        this.卦義 = 卦義
    }
}