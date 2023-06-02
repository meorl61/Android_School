package com.example.changepage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class TabActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab)

        init() // 初始化
    }

    private fun init() {
        val tab_layout = findViewById<TabLayout>(R.id.tab_layout)
        val tab_pager = findViewById<ViewPager2>(R.id.tab_pager)

        // 設定ViewPager2 資料適配器
        tab_pager.adapter = MyPagerAdapter(this)

        // 連結tab_layout 與tab_pager
        TabLayoutMediator(tab_layout, tab_pager) { tab, position ->
            val s = "第" + position + "頁"
            tab.text = s // 設定tab 標題字串
        }.attach()
    }

    // inner class(內部類別) 能使用外部類別私有成員
    // 資料適配器
    inner class MyPagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
        // 有多少項資料
        override fun getItemCount(): Int {
            return 2 // 有2頁
        }

        // 產生片段畫面
        override fun createFragment(position: Int): Fragment {
// 建立片段
            lateinit var f: Fragment
            when (position) {
                0 -> {
                    f = TabFragment1()
                }

                1 -> {
                    f = TabFragment2()
                }
            }
            return f
        }
    } // MyPagerAdapter
} // Activity



