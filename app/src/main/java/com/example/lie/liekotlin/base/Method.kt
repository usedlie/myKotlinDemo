package com.example.lie.liekotlin.base

import android.view.View
import android.widget.TextView

/**
 * Created by lie on 2017/5/18.
 * 测试kotlin基础语法 : 方法
 */
class Method {

    val listener = { view: View -> view is TextView } //这样就定义一个变量
    //再进一步，我们用闭包
    val listener2 : (View) -> Boolean = { view -> view is TextView }


    // todo 搞个call作为参数，取代interface
    // 声明一个callback
    var callback: (()->Unit)? = null
    // 想带参数
    var callback2: ((str: String)->Unit)? = null

    /**
     * 调用回调
     */
    fun testCallBack(){
        // 判断并使用
        callback?.invoke()
        // 判断并使用
        callback2?.invoke("123")
    }

    /**
     * 设置回调
     */
    fun setCallBack(){
        callback = {
            // do something
        }
        // 带参数的callback
        callback2 = {
            print(it)
        }
    }


    /**
     * 计算
     */
    fun sum (a: Int, b: Int): Int {
        return a +b
    }

    /**
     * 参数提供默认值
     * 这个很好用，当传来的参数是null的时候，就可以用上这些默认值了
     * 我们就不用写什么 if (a==null) a = 0 ,这样的代码
     */
    fun foo(a: Int = 0, b: String = "") {
        print("a: $a b: $b")
    }

    /**
     * 相当于
     * fun theAnswer(): Int {
     *  return 42
     * }
     */
    fun theAnswer() = 42


}