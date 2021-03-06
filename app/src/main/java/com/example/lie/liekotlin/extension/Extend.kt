package com.example.lie.liekotlin.extension

/**
 * Created by lie on 2017/5/22.
 * 多态情况下的扩展
 */
class Extend {
    /**
     * 扩展是静态解析的
     * 扩展不能真正的修改他们所扩展的类。通过定义一个扩展，你并没有在一个类中插入新成员，
     * 仅仅是可以通过该类型的变量用点表达式去调用这个新函数。
     *
     * 再次说下，记住这种格式：  被扩展的类型.fun()
     * 想强调的是扩展函数是静态分发的，即他们不是根据接收者类型的虚方法。
     * 这意味着调用的扩展函数是由函数调用所在的表达式的类型来决定的，
     * 而不是由表达式运行时求值结果决定的
     */

    open class C

    class D: C()

    fun C.foo() = "c" //对C类型扩展了方法

    fun D.foo() = "d" //对D类型扩展了方法

    fun printFoo(c: C) {
        /**
         * 扩展方法只取决于参数c的声明类型,而c的类型是C类
         * 要记住"静态解析"，扩展这玩意不是继承
         */
        println(c.foo())
    }

    fun test(){
        /**
         * 这个例子会输出 "c"，因为调用的扩展函数只取决于 参数 c 的声明类型，该类型是 C 类。
         */
        printFoo(D())
    }
}