package com.example.lie.liekotlin.extension

/**
 * Created by lie on 2017/5/22.
 * 演示 扩展方法
 */
class Method {

    /**
     * 首先，看着 MutableList<Int> 这个玩意，这个玩意会返回一个类型（list）的，我们想对它搞点飞机
     * 所以在后面加了一个函数
     * 这个函数，很明显，实现了交换的功能
     *
     * 而里面的this，就是调用回 MutableList<Int> 或者说是 list类型的
     */
    fun MutableList<Int>.swap(index1: Int, index2: Int) {
        val tmp = this[index1] // “this”对应该列表
        this[index1] = this[index2]
        this[index2] = tmp
    }

    /**
     * 那我们现在试着使用这个 扩展以后的函数
     */
    fun testExtension(){
        val  testList = mutableListOf(1,2,3) //初始化一个list
        //然后我们用这个类型去调用 上面所写的扩展函数
        testList.swap(0,1) //实现下标0和下标1的元素的交换
        //就是这么简单，这么好用，以往我们实现这样的功能，一般是封装自己的util类
        //但现在直接就可以用，因为一般假如是自己封装的还好，但是假如你去一个老项目，会发现有非常多的util，命名又不一定合你口味
        //你还得额外记住util的名字，现在不用了，拓展，你直接就可以用
    }

    /**
     * 我们现在再试个同名的情况
     * 比如，我们知道list有一个add()的方法
     * 那我们作死，拓展的方法也叫做add(），并且要传的参数也完全一样
     */
    fun MutableList<Int>.add(e :Int){
        print(e)
    }

    fun testSameName(){
        val  testList = mutableListOf(1,2,3)
        testList.add(1) //则这里，输出的还是list自己的add方法，而不会变成print
        //这个也很好理解吧，还是要尊重正版
    }
}