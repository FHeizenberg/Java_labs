
fun main() {
    /**
     * @author Novikov "iVanFromJapan" Ivan
     * @version 1.?        */
    val exmpl = Labz()

    var a: Int = -1
    while (a!=0){
        println("---------------------------------------")
        println("Выберите задание")
        a= readln().toInt()
        /**
        * @see Labz
         */
        when (a){
            1 -> exmpl.ex1()
            2 -> exmpl.ex2()
            3 -> exmpl.ex3()
            4 -> exmpl.ex4()
            5 -> exmpl.ex5()
            else -> println("CrItIcAl ErRoR")
        }
    }
}