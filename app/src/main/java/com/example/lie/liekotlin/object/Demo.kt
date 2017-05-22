package com.example.lie.liekotlin.`object`

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.BaseAdapter
import android.widget.ListView
import org.jetbrains.anko.windowManager

/**
 * Created by lie on 2017/5/22.
 * 本类讲 类似于java的匿名内部类
 * Kotlin用了2个东西来表达匿名内部类的作用：
 *  1）对象表达式
 *  2）对象声明
 *
 *  此外，还将介绍 对象伴生（类似静态，但不是静态）
 */
class Demo {
    /**
     * 对象表达式
     */
    fun demo1(view : View , listView : ListView){
        view.setOnClickListener { object: View.OnClickListener {
            override fun onClick(v: View?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
         }
        }

        listView.adapter = object : BaseAdapter() {
            override fun getItem(position: Int): Any {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun getItemId(position: Int): Long {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun getCount(): Int {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        }

    }

    /**
     * 这称为对象声明。并且它总是在 object 关键字后跟一个名称 其实可以理解成单例模式
     */
    object DefaultListener : View.OnClickListener {
        override fun onClick(v: View?) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

    }

    /**
     * 我们调用对象声明，直接用其名称就可以了
     */
    fun test(view: View){
        DefaultListener.onClick(view)
    }

    /**
     * 伴生对象 （某种程度上可以理解成java里的静态）
     * 但它又不是静态，因为它是有实例的(即使伴生对象的成员看起来像其他语言的静态成员，在运行时他们 仍然是真实对象的实例成员)
     * 伴生对象只允许有一个，并且名字可以省略（既然只有一个，名字就无所谓拉）
     *
     * 初始化区别：
     *  1）对象表达式是在使用他们的地方立即执行（及初始化）的
     *  2）对象声明是在第一次被访问到时延迟初始化的
     *  3）伴生对象的初始化是在相应的类被加载（解析）时，与 Java 静态初始化器的语义相匹配
     */
    class MyClass {
        companion object Factory {
            fun create(): MyClass = MyClass()
        }

    }
    /**
     * 我们要调用 伴生对象 的 成员，只可以通过类来调用（理解成java里的static成员）
     */
    fun test2(){
        var myClass1 = MyClass.create() //直接用类名调用

        val x = MyClass.Factory //x是Factory类型，当伴生对象无名字，则可以直接用MyClass.companion
//        print(x)

    }

}