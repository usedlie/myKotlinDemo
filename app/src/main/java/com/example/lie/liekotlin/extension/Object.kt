package com.example.lie.liekotlin.extension

/**
 * Created by lie on 2017/5/22.
 * 伴生对象的扩展
 */
class Object {
    companion object { }  // 将被称为 "Companion"


}

class MyClass {

    fun Object.Companion.printSth(){
        print("sth")
    }

    fun test(){
        //就像伴生对象的其他普通成员，只需用类名作为限定符去调用他们
        Object.Companion.printSth()
    }

}