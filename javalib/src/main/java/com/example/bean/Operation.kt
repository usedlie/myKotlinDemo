package com.example.lie.liekotlin.base

/**
 * Created by lie on 2017/5/18.
 * 测试kotlin基础语法 : 操作符
 */
class Operation {


     fun main(args: Array<String>) {
        println("hello world   +++++++++++++111")
        c()
        max(2,3)
        testFor()
        testWhile()
    }


    /**
     *  $ 字符串模板
     *  注意，无法用 + 用来拼接字符串了
     *  但这种写法是优雅一点的，不用产生很多个""
     */
    fun c(){
        print(" bean是 ：——— ${ VarAndConstant() } ")
    }


    /**
     * 条件表达式
     * 简略写法
     */
    fun max(a: Int, b: Int) = if (a >b) a else b


    /**
     * for循环的测试代码
     */
    fun testFor() {
        val arr = arrayOf(1, 3, 4, 5, 6)
        for(i in arr.indices) { //通过索引循环
            println(arr[i])
        }
        for(num in arr) { //直接使用数组中的对象循环
            println(num)
        }

        for (i in 1..10){
            print(i)
        }
    }

    /**
     * while循环的测试代码
     */
    fun testWhile() {
        var i = 0
        while(i < 10) {
            print(" " + i)
            i++
        }
    }




}