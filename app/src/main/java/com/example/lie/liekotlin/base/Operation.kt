package com.example.lie.liekotlin.base

import android.util.Log
import java.io.File

/**
 * Created by lie on 2017/5/18.
 * 测试kotlin基础语法 : 操作符
 */
class Operation {

    fun main(args: Array<String>) {
        println("Hello World!")
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

        for (i in 1..100) { print(i) }  // 闭区间，包括100
        for (i in 1 until  100) { print(i) }  // 开区间，不包括100
    }

    /**
     * while循环的测试代码
     */
    fun testWhile() {
        var i = 0;
        while(i < 10) {
            print(" " + i)
            i++
        }
    }

    /**
     * when 相当于 switch
     */
    fun testCase(obj: Any) {
        when(obj) {
            is String -> {
                print("this is string")
            }
            is Int -> {
                print("this is integer")
            }

            1          -> "One"
            "Hello"    -> "Greeting"
            is Long    -> "Long"
            !is String -> "Not a string"

            else -> {
                print("unkown value")
            }
        }
    }

    /**
     * 倒序输出，downTo 关键字
     */
    fun testForBack(){
        for (i in 4 downTo 1){
            print(i) //倒叙遍历
        }
        // print “4321”
    }

    /**
     * 指定步骤，不用每一次都执行（比如step 2 其实可以理解成 i+2这样）
     */
    fun testForStep(){
        for (i in 1..4 step 2)
            print(i) // prints "13"
        for (i in 4 downTo 1 step 2)
            print(i) // prints "42"
    }


    /**
     * 原汁原味
     *  """ 则可以原汁原味输出字符串内容，不需要转义
     */
    fun testPrint(){
        var str1 = """
            one
            two
                """
        //等价于
        var str2 = "one\ntwo"
        var str3 =  "one" +"\n"+"two"
    }

    /**
     * if else ，这么简单的东西，都写进来
     * 肯定是有花样——没错，咱们来搞搞简化版
     */
    fun testShorthandIf(){

        val files = File("Test").listFiles()
        /**
         * 这个 ？ 非常，非常的重要，我们也很容易理解啊，三元就是有？ 的
         * 但你要知道，这里边是解决了非空的判断的，6不6
         * 这里实际上，是 if not null 的简化
         */
        println(files?.size)
        //If not null and else 的简化 ，注意，和3元的写法还是有点小区别的
        println(files?.size ?: "empty")


        val data = mapOf("email" to "1@qq.com")
        val email = data["email"] ?: throw IllegalStateException("Email is missing!")

        /**
         * let 写法
         * 其实全称应该是 if  let
         * let包裹的里面，全是 data["email"]不为null 情况，类似于我们以前写
         *  if(xx!=null){
         *     这里写的东西
         *  }
         *
         *  你可能吐槽那为何这么设计，莫慌，先记下来，以后会感受到的，代码结构会优雅不少
         */
        data["email"]?.let {
            // execute this block if not null

        }

    }

    /**
     * 接下来，我们来感受 直接 变量接受 方法的写法
     */
    fun testResult(){
        /**
         * try catch
         */
        val resultTry = try {
            print("")
        } catch (e: ArithmeticException) {
            throw IllegalStateException(e)
        }
        print(resultTry) // 这里可以直接搞到resultTry ，非常实用，假设catch里面并不是throw的话


        /**
         * if
         */
        var param = 2
        val resultIf = if (param == 1) {
            "one"
        } else if (param == 2) {
            "two"
        } else {
            "three"
        }
        print(resultIf)

    }

    /**
     * 接下来介绍 with 关键字
     * 作用是： 用一个实例，调用多个方法
     */
    class Turtle {
        fun penDown() = { print("penDown") }
        fun penUp() = { print("penUp") }
        fun turn(degrees: Double) = { print("变换角度 $degrees") }
        fun forward(pixels: Double) = { print("向前移动 $pixels 个像素点") }
    }

    /**
     * 如我们所见，在with包裹住的范围里，直接就可以调用该实例的方法
     */
    fun testWith(){
        val myTurtle = Turtle()
        with(myTurtle) { //draw a 100 pix square
            penDown()
            for(i in 1..4) {
                forward(100.0)
                turn(90.0)
            }
            penUp()
        }

    }


    /**
     *  == 和 ===
     */
    fun testEqual(){

        val a: Int = 10000
        print(a === a) // Prints 'true'
        print(a == a) // Prints 'true'

        val boxedA: Int? = a
        val anotherBoxedA: Int? = a
        print(boxedA === anotherBoxedA) // !!!Prints 'false'!!!
        print(boxedA == anotherBoxedA) // Prints 'true'

    }

    /**
     * 跳出循环的标记 标记自己定
     * 没记错的，其实java也支持这种注解
     *
     * 同样的，return@loop 也可以指定 return的位置
     */
    fun breakFor(){
        loop@ for (i in 1..10) {
            for (j in 1..10) {
                if (j > 3) break@loop
                Log.w("","标记在外环的j: $j")
            }
        }

        print("--------------------")

         for (i in 1..10) {
             abc@for (j in 1..10) {
                if (j > 3) break@abc
                 Log.w("","标记在内环的j: $j")
            }
        }
    }



}