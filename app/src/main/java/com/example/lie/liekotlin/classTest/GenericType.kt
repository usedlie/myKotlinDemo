package com.example.lie.liekotlin.classTest

/**
 * Created by lie on 2017/5/23.
 * 泛型
 */
class GenericType <T>(t: T) {

    var value = t
}

class Demo{

    fun test(){
        val g1: GenericType<Int> = GenericType<Int>(1)
        var g2 = GenericType(1) //我们确定1就是Int类型，则也可以省略，因为编译器知道我们说的是 GenericType<Int>。
    }
}