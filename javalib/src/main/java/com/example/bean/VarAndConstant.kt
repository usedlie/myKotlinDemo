package com.example.lie.liekotlin.base

/**
 * Created by lie on 2017/5/18.
 * 测试kotlin基础语法 : 变量和常量
 */
class VarAndConstant {

    fun main(args: Array<String>) {
        println("Hello World!")
        varAndConstant()
        nullableTest()
        nullableTest2("nullTest")
    }

    /**
     * 变量 var
     * 常量 val
     */
    fun varAndConstant(){
        //使用val关键字声明一个常量（只读），声明常量时必须初始化
        val a: Int = 1 //显式指定常量的类型
        val b = 2  //自动推断类型
        val c: Int //声明一个不初始化的常量，必须显式指定类型
        //    b = 3  //常量值不可修改，这句代码会报错

        //a = 3  //不可以修改常量的值，此句代码会报错

        //使用var关键字声明一个变量，变量的值可以修改
        var year: Int = 2016 //显式指定变量的类型
        var month = 5 //自动推断变量类型
        var day: Int //声明一个不初始化的变量，必须显式指定类型
        month = 6 //变量值可以被修改

    }

    /**
     * 可空类型
     *  在变量类型后面加上问号，代表该变量是可空变量
     *  这个是很重要的设定 一定要好好感受
     *  和swift的设定是一样的
     */
    fun nullableTest() {
        //
        var name: String? = "zhangsan"
        name = null //可以将null赋值给name变量
        var person: String = "tom"
//    person = null  //这句代码会报错，不可以将null赋值给一个不可空变量
    }


    /**
     * 函数返回值为Int?，表示返回值可为空
     * 当参数为空或者为""时，则返回null，否则使用Java中的字符串转整型的方法
     * 这里也体现了kotlin代码和Java代码无缝集成
     *
     * 同样注意，这里传参有个？，表示可为null，否则是不接受null作为参数的
     */
    fun nullableTest2(s: String?): Int? {
        if(s == null || s == "")
            return null
        return Integer.parseInt(s) //能到这里，则肯定s不为null
    }


    /**
     * 当函数参数为字符串类型时，就返回字符串的长度，否则返回空
     * 注意 is 作为关键字
     */
    fun getStringLength(n: Any): Int? {
        if(n is String)
            return n.length //这里会自动将n转化为字符串类型
//        return null
        if (n !is String) //还可以这么写
            return  null
        return null
    }

}