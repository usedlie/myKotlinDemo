package com.example.lie.liekotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.lie.liekotlin.base.Operation
import com.example.lie.liekotlin.bean.Student
import com.example.lie.liekotlin.classTest.SingleTonDemo
import kotlinx.android.synthetic.main.activity_kot1.*

/**
 * 本类主要尝试各种view
 * https://kotlinlang.org/docs/tutorials/android-plugin.html
 */
class KotActivity1 : AppCompatActivity() {

    //没有为啥，要拿类就是得这么麻烦（::class.java）
    var TAG : String = KotActivity1::class.java.simpleName

    var mOperation: Operation? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kot1)
        initData()
        initUI()
    }


    private fun initData() {
        mOperation =  Operation()
    }

    /**
     *  Instead of findView(R.id.textView) as TextView
     *  我们不需要再findView了，注意import kotlinx.android.synthetic.main.activity_kot1.*
     */
    fun initUI(){
        tv1.text = "1"
        btn1.setOnClickListener {
            Log.w(TAG,"2")
            //在内部类时，我们不写 类名.this ，而是 this@类名
            Toast.makeText(this@KotActivity1 ,"1",Toast.LENGTH_SHORT ).show()
            Log.w(TAG,"测试单例： singleTon: ${SingleTonDemo.name} ${SingleTonDemo.foo()}") //额我打印不出来实例，不过直接调用其成员是没问题的

            Log.w(TAG,"子类student: ${Student(1,"白","李")}")

            Log.w(TAG,"${mOperation?.breakFor()}")
        }

    }

}
