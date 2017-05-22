package com.example.lie.liekotlin.classTest

import android.util.Log

/**
 * Created by lie on 2017/5/22.
 *
 * 注意 Kotlin 并没有 new 关键字。
 *
 * 主要演示构造器：
 *  在 Kotlin 中的一个类可以有 一个 主构造函数和 一个或多个 次构造函数
 *  1）主 构造函数是类头的一部分：它跟在类名（和可选的类型参数）后；
 *  2）主构造函数不能包含任何的代码，初始化的代码可以放 到以 init 关键字作为前缀的初始化块（initializer blocks）
 *
 *  1)类也可以声明前缀有 constructor** 的次构造函数**：
 *  2)如果类有一个主构造函数，每个次构造函数需要委托给主构造函数，
 *      可以直接委托或者通过别的次构造函数间接委托。委托到同一个类的另一个构造函数 用 this 关键字即可：
 *
 *
 *
 */
class ConstructorDemo constructor(firstName: String){


    val TAG = ConstructorDemo::class.java.simpleName


    /**
     * 主构造的参数可以在初始化块中使用。
     */
    val customerKey = firstName.toUpperCase()


    /**
     * 这玩意，就相当于以前：
     *  public ConstructorDemo(){
     *      init();
     *  }
     *  在 主 构造器创建实例后，初始化你想要的东西
     */
    init {
        Log.i(TAG,"Customer initialized with value $firstName")
    }

    /**
     * 次构造一号
     * 目测需要调一下主构造器才行（用this关键字）
     */
    constructor(name: String, constructorDemo: ConstructorDemo) : this(name){

    }

    /**
     * 次构造二号
     * 或者调用其他次构造也行（反正总有一个次构造会调用 主构造）
     */
    constructor(name: String,age : Int ,constructorDemo: ConstructorDemo) : this(name, constructorDemo){
        ConstructorDemo2("测试2",12)
    }


}

class ConstructorDemo2{
    /**
     * 次构造3号
     * 假如没声明主构造，则可以直接创建次构造而不经主构造
     */
    constructor(name: String, age: Int) {

    }
}

/**
 * 如果一个非抽象类没有声明任何（主或次）构造函数，它会有一个生成的 不带参数的主构造函数。
 * 如果你不希望你的类 有一个公有构造函数，你需要声明一个带有非默认可见性的空的主构造函数
 */
class DontCreateMe private constructor ()


/**
 * 注意：在 JVM 上，如果主构造函数的所有的参数都有默认值，
 * 编译器会生成 一个额外的无参构造函数，它将使用默认值。
 * 这使得 Kotlin 更易于使用像 Jackson 或者 JPA 这样的通过无参构造函数创建类的实例的库。
 */
class Customer(val customerName: String = "")