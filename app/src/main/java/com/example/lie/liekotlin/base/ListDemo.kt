package com.example.lie.liekotlin.base

/**
 * Created by lie on 2017/5/19.
 * 集合类
 */
class ListDemo {
    /**
     * list过滤器
     */
    fun filterList(list : ArrayList<Int>){

        var positives = list.filter { x -> x > 0 }
        //还可以再简短一点
        //关于it的用法，就是当只有一个参数的时候，替代那个参数的，不理解先不用也行，多看看就体会到了
        positives = list.filter { it >0 }
        print(positives)
    }

    /**
     * 遍历map(本来这里好像要写到
     * @see Operation 里的，不过想想集合相关的就丢本类吧
     */
    fun forMap(map : HashMap<String ,Int>){
        //这里的k 和v 的参数名字随你定，你要改成a 和b也行
        //但总之，就是很方便，再也不用记那么多东西，核心就一个 for in
        for ((k, v) in map) {
            println("$k -> $v")
        }


    }

    /**
     * 初始化集合
     */
    fun initList(){
        val list = listOf("a", "b", "c" )
        val map = mapOf("a" to 1, "b" to 2, "c" to 3)

        print(list) //List<String> ,假如里面掺了不同类型的，则list的类型就是 List<Any>
        print(map) // Map<String,Int>

        println(map["key"])
    }


    /**
     * 这个我没测过，目测是移位？
     */
    fun arrayOfMinusOnes(size: Int): IntArray {
        return IntArray(size).apply { fill(-1) }
    }

}
