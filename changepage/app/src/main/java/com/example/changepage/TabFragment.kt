package com.example.changepage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

// 片段類別不能是內部類別(inner class)
class TabFragment1 : Fragment() {
    // 建立片段畫面
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
// inflater(畫面佈局載入器)
        return inflater.inflate(R.layout.tab_fragment1_layout, container, false)
    }
}

class TabFragment2 : Fragment() {
    // 建立片段畫面
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
// inflater(畫面佈局載入器)
        return inflater.inflate(R.layout.tab_fragment2_layout, container, false)
    }
}