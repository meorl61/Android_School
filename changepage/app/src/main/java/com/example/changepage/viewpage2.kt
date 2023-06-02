package com.example.changepage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2

// 全域變數(寫在類別外面，任何程式都可取用)
const val POSITION_KEY = "POSITION_KEY"
// 資料類別
data class Q(
    val number: Int,
    val question: String,
    val op_a: String,
    val op_b: String,
    val op_c: String
)
// ArrayList 陣列
val qArrayList = arrayListOf<Q>(
    Q(1, "1+1=?", "1", "2", "3"),
    Q(2, "1+2=?", "1", "2", "3"),
    Q(3, "2-1=?", "1", "2", "3"),
)

class viewpage2 : AppCompatActivity() {

    // lateinit 稍後會設定初值，確認未來不會是空值
    private lateinit var viewPager: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_viewpage2)

        viewPager = findViewById<ViewPager2>(R.id.pager)
        viewPager.adapter = MyPagerAdapter(this) // 設定ViewPager2 資料適配器
    }
    // 資料適配器
    class MyPagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
        // 有多少項資料
        override fun getItemCount(): Int {
            return qArrayList.size
        }
        // 產生片段畫面
        override fun createFragment(position: Int): Fragment {
// 建立片段
            val qf = QuestionFragment()
// 寄放資料
            qf.arguments = Bundle().apply {
// 放整數資料目前位置
                putInt(POSITION_KEY, position)
            }
            return qf
        }//Freaqment
        } // MyPagerAdapter
    } // Activity
    // 片段類別不能是Activity 內部類別(inner class)
    class QuestionFragment : Fragment() {
        // 建立片段畫面
        override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
// inflater(畫面佈局載入器)
            return inflater.inflate(R.layout.question_layout, container, false)
        }
        // 建立片段畫面之後
        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
// 若有寄放資料
            arguments?.takeIf { it.containsKey(POSITION_KEY) }?.apply {
                val tv_number = view.findViewById<TextView>(R.id.tv_number)
                val tv_question = view.findViewById<TextView>(R.id.tv_question)
                val tv_op_a = view.findViewById<TextView>(R.id.tv_op_a)
                val tv_op_b = view.findViewById<TextView>(R.id.tv_op_b)
                val tv_op_c = view.findViewById<TextView>(R.id.tv_op_c)
// 取得寄放整數資料目前位置
                val position = getInt(POSITION_KEY)
// 從陣列取得題目資訊
                val q = qArrayList.get(position)
// 設定要顯示的文字內容
                tv_number.text = q.number.toString()
                tv_question.text = q.question
                tv_op_a.text = q.op_a
                tv_op_b.text = q.op_b
                tv_op_c.text = q.op_c
            }
        }
    } // Fragment