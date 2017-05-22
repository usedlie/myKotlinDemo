package com.example.lie.liekotlin.classTest.extend

/**
 * Created by lie on 2017/5/22.
 * 多继承，假设同时继承几个，为了表示采用从哪个超类型继承的实现，我们使用由尖括号中超类型名限定的 super
 */
class MultiExtend : Father(),Mother{

    /**
     * 编译器提醒，必须重写 open fun f()
     * 我们用 super<> 来指定，重写哪个
     */
    override fun f() {
        super<Father>.f()
        super<Mother>.f() //接口的这个不重写目测也不会报错
    }
}


open class Father {
    open fun f() { print("Father") }
    fun a() { print("father") }
}

/**
 * 接口成员默认就是“open”的
 */
interface Mother {
    fun f() { print("Mother") }
    fun b() { print("mother") }
}