package com.example.lie.liekotlin.classTest.extend

/**
 * Created by lie on 2017/5/22.
 */
class Derived(d :Int) : Base(d){

    /**
     * 子类中不允许定义相同签名的函数
     */
//    fun nv() {} //nv()已被父类定义了
//    override fun nv() {} //nv()已被父类定义了，就算加override也救不了

    /**
     * 而v就算父类有 标志为open
     * 子类也必须显示 加上override标志
     *
     * 标记为 override 的成员本身是开放的，
     * 也就是说，它可以在子类中覆盖。
     * 如果你想禁止再次覆盖，使用 final 关键字：
     */
    final override fun v() {}
}