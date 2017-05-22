package com.example.lie.liekotlin.extension

import com.example.lie.liekotlin.bean.Person

/**
 * Created by lie on 2017/5/22.
 */
class Property {
    /**
     * 属性也可以拓展。。格式和拓展方法相似
     *
     * 注意：由于扩展没有实际的将成员插入类中，因此对扩展属性来说 幕后字段是无效的
     * 这就是为什么扩展属性不能有 初始化器。他们的行为只能由显式提供的 getters/setters 定义。
     */
    val <T> List<T>.lastIndex: Int
        get() = size - 1

//    val Person.name = 1 // 错误：扩展属性不能有初始化器
}