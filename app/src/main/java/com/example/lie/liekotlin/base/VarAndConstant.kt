package com.example.lie.liekotlin.base

/**
 * Created by lie on 2017/5/18.
 * 测试kotlin基础语法 : 变量和常量
 */

const val CONSTANT : String = "constant" //常量可加const关键字，并放在顶层

class VarAndConstant {

    fun main(args: Array<String>) {
        println("Hello World!")
        varAndConstant()
        nullableTest()
        nullableTest2(null)
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

        /**
         * 附带一个as转型
         * 可能会经常出现 ClassCastException
         * ，现在可以使as?安全转型，当转型不成功的时候，它会返回 null。
         */
    }


    /**
     * 当函数参数为字符串类型时，就返回字符串的长度，否则返回空
     * 注意 is 作为关键字
     */
    fun getStringLength(n: Any): Int? {
        if(n is String)
            return n.length //这里会自动将n转化为字符串类型 ，但切记，出了这个if的范围，n就变回Any类型了
//        return null
        if (n !is String) //还可以这么写
            return  null
        return null
    }

    /**
     * 懒属性
     * 如果和swift没区别的话，这个懒属性，有点懒加载的意思
     * 就是这个变量 p ，假如没调用它的话，它是不会初始化的，只有用了它，才会被初始化
     * 但 swift里，一旦lazy变量被初始化了，则值是不可更改的
     *
     * 我们看到这里 p 用了 val 修饰，代表其实是常量了
     * 我试着（你们也可以试试）改成var，则报错，提示需要改一些东西，这里我没改了，不知道lazy支不支持var
     */
    fun lazy(){
        val p: String by lazy {
            // compute the string
            "i am lazy fish"
        }
    }


    /**
     * 扩展方法 Extension Functions
     * 扩展的概念，简单来讲类似于继承，但是不是继承（没有父类、子类的关系），所以没有重写的概念
     * 可以理解成盗版再打补丁 （开挂）
     *
     * 这个非常实用，用处很多；swift里面经常用extension
     */
    fun String.countStringLength() {
        print(this.length) //打印出字符串的长度
    }
    //调用这个扩展方法
    fun testExtensionFunction(){
        "123456".countStringLength()
    }

    /**
     * 类型转换
     */
    fun testConversion(){

        val b: Byte = 1 // OK, literals are checked statically
//        val i: Int = b //b 已经是 byte型了，无法复制给作为Int类型的 i
        val i: Int = b.toInt() // OK

        /**
             类似的转换还有：
             toByte(): Byte
             toShort(): Short
             toInt(): Int
             toLong(): Long
             toFloat(): Float
             toDouble(): Double
             toChar(): Char
         */

    }

    /**
     *  $关键字
     *  尤其要注意这里的输出结果
     *   $ 会拿最近的一个变量的值
     *   ${} 则是拿{}里的
     */
    fun testLiterals(){
        val s = "abc"
        val str = "$s.length is ${s.length}" // evaluates to "abc.length is 3"
        //问题来了，那老子要打印 $ 这个字符怎么办
        print("$9.9") //跟着数字没问题
//        print("$a9.9") //跟着字母就不行了
        print("${'$'}a9.99")//官方方案
    }

}