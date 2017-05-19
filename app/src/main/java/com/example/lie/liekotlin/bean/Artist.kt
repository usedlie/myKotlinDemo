package com.example.lie.liekotlin.bean

/**
 * Created by lie on 2017/5/18.
 * 这样就完成bean类了，保存的是属性，而非字段，前者自动包括get和set
 *
 * 由此延伸——getters与setters都会自动映射到属性上
 * 这点很方便很屌
 *  所以我们在activity里，给view赋值时，是这样的： tv1.text = "1"，而不是tv1.setText("1")
 */
data class Artist (
  var id: Long,
   var name: String,
   var url: String,
   var mbid: String)