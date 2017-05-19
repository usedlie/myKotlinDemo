package com.example.lie.liekotlin.classTest

/**
 * Created by lie on 2017/5/19.
 * 单例测试
 *  注意，创建单例类的时候，直接 声明成 object 就是单例了
 *  用的时候，直接 SingleTonDemo.name ，或者 SingleTonDemo.foo() 即可
 *
 */
object SingleTonDemo {

    val name = "Name"
    fun foo() = { print("foo")}
}