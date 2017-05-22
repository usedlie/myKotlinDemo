package com.example.lie.liekotlin.classTest.extend

import android.content.Context
import android.util.AttributeSet
import android.view.View

/**
 * Created by lie on 2017/5/22.
 */
class MyView :View{

    /**
     * 必须实现基类的构造（这点和原本java也是一样的）
     */
    constructor(ctx: Context) : super(ctx)

    constructor(ctx: Context, attrs: AttributeSet) : super(ctx, attrs)
}

/**
 * 或者在 主构造里，直接指定 基类的主构造
 */
class MyView2 (ctx: Context):View(ctx)