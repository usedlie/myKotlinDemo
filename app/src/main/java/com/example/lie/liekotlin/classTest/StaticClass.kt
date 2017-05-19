package com.example.lie.liekotlin.classTest

/**
 * Created by lie on 2017/5/19.
 * 静态方法
 */
class StaticClass {
    /**
     * kotlin并没有static关键字
     * 而是用了companion object
     * 包裹住的，都可以看作是静态方法
     */
    companion object  {
        fun create(): StaticClass = StaticClass()
        fun print(){
            print("调用静态方法打印")
            //这里自然无法调用 非静态方法 test()
        }
    }

    fun test(){
        StaticClass.create()
        StaticClass.print()
    }
}