package com.example.lie.liekotlin.classTest

/**
 * Created by lie on 2017/5/22.
 * 测试外部类 内部类
 */
open class Outter {
    private val a = 1
    protected open val b = 2
    internal val c = 3
    val d = 4  // 默认 public

    protected class Nested {
        public val e: Int = 5
    }
}

class Subclass : Outter() {
    // a 不可见
    // b、c、d 可见
    // Nested 和 e 可见

    override val b = 5   // “b”为 protected
}

/**
 * 注意 对于Java用户：Kotlin 中外部类不能访问内部类的 private 成员。
 * 这个和java不一样了！！
 */
class Unrelated(o: Outter) {
    // o.a、o.b 不可见
    // o.c 和 o.d 可见（相同模块）
    // Outer.Nested 不可见，Nested::e 也不可见
}