package com.example.lie.liekotlin.classTest.extend

/**
 * Created by lie on 2017/5/22.
 * 1）在 Kotlin 中所有类都有一个共同的超类 Any，这对于没有超类型声明的类是默认超类：
 * 2）注意必须声明成 open ，因为默认类都是final的——这是设计思想：要么为继承而设计，并提供文档说明，要么就禁止继承
 */
open class Base(p: Int){ // 从 Any 隐式继承，注意这个Any不是Object，你理解成比Object还高大上就行
    /**
     * 和类一样，方法也是要显示标注
     * 需要显式 标注可覆盖的成员（我们称之为开放）和覆盖后的成员：
     */
    open fun v() {}
    fun nv() {}
}