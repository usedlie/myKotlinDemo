package com.example.lie.liekotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.lie.liekotlin.base.Operation
import com.example.lie.liekotlin.bean.Artist
import com.example.lie.liekotlin.bean.Student
import com.example.lie.liekotlin.classTest.SingleTonDemo
import kotlinx.android.synthetic.main.activity_kot1.*
import kotlinx.coroutines.experimental.async
import org.jetbrains.anko.*
import org.jetbrains.anko.coroutines.experimental.Ref
import org.jetbrains.anko.coroutines.experimental.asReference
import org.jetbrains.anko.custom.async
import org.jetbrains.anko.sdk25.coroutines.onClick
import java.net.URL

/**
 * 本类主要尝试各种view
 * https://kotlinlang.org/docs/tutorials/android-plugin.html
 *
 * 然而已变成anko的尝试类
 * https://github.com/Kotlin/anko
 *
 */


class KotActivity1 : AppCompatActivity() ,AnkoLogger{

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

        //用anko来做的话，则更简单
        btn2.onClick {
            info { "click" }
            /**
             * doAsync 当中的代码运行在 Anko 配置的线程池当中，
             * 执行完之后还可以转入 uiThread 块来操作 UI，简单明了，还不容易出错
             */
            doAsync {
                val readText = URL("https://kotlinlang.org/docs/diagnostics/experimental-coroutines.html").readText()

//                val weather = Gson().fromJson(s,Weather::class.java) //假如需要解析的时候则这么搞

                warn { readText }
                uiThread {
                    toast(readText)
//                    longToast("久的吐司") //
                }
            }
        }

        btn3_dialog.onClick {
            /**
             * 搞搞dialog相关 ，安卓默认的样式
             */
            alert("没什么，就想弹个窗" ,"这里是标题") {
                yesButton { toast("ohYeah") }
                noButton { }
            }.show()

        }


        btn4_dialog.onClick {
            /**
             * 指定样式的dialog
             * 当然，假如要确定或者取消按钮则自己加
             */
//            alert(Appcompat, "Some text message").show()

            /**
             * 转圈圈
             */
            val dialog = progressDialog(message = "Please wait a bit…", title = "Fetching data")
            dialog.show()

            val countries = listOf("Russia", "USA", "Japan", "Australia")

            //这个我不知道怎么改，官网copy下来的例子，但编译有错误
//            selector("Where are you from?", countries) { i ->
//
//                toast("So you're living in ${countries[i]}, right?")
//            }

        }

        btn5_custom.onClick {
            /**
             * 自定义弹窗
             */
            alert {
                customView {
                    /**
                     * customView {}里包裹住的就是你要自定义的view
                     * 而且是一个rootView，不支持写2个rootView
                     */
                    verticalLayout {
                        textView().text = "123"
                        editText()
                        button().text = "看不出是按钮吧"
                    }

                }
            }.show()
        }

    }

    /**
     * 这里大概讲讲intent
     */
    fun testIntent(){
        /**
         * 指定activity
         * 携带参数
         * 指定启动的flag
         */
        //        startActivity(intentFor<"指定的activity">( "id" to 5) .singleTop())

//        startActivityForResult(intentFor<>())
    }


    fun loadAndShowData() {
        // Ref<T> uses the WeakReference under the hood
        val ref: Ref<KotActivity1> = this.asReference()
        /**
         * 别说了，我也不知道这个UI是什么
         * 我关注点在于，用这种方法可以很方便的拿到弱引用： this.asReference()
         */
        async (kotlinx.coroutines.experimental.android.UI) {
            // Use ref() instead of this@MyActivity
            ref().testIntent()

        }

    }

}
