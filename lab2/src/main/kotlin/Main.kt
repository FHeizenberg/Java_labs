
import java.nio.file.Files
import java.nio.file.Paths
/**
 * @author Novikov "iVanFromJapan" Ivan
 * @version 1.🤡         */
fun main() {
    val exmpl = Lab2()

    var n: Int = -1
    while (n!=0){

        println("---------------------------------------")
        println("Выберите задание")
        n= readln().toInt()
        /**
         * @see Lab2
         */
        when (n){
            1 -> {
                println("Выберите ввод: 1 - из файла, 2 - из консоли (иное - из консоли)")
                val a = readln().toInt()
                if (a == 1) {
                    val path = "src/main/resources/aboba1.txt"
                    val encoded = Files.readAllLines(Paths.get(path))
                    exmpl.ex1(encoded[0].toDouble(), encoded[1].toDouble())
                } else {
                    val x: Double = readln().toDouble()
                    val y: Double = readln().toDouble()
                    exmpl.ex1(x,y)
                }
                }
            2 -> {
                println("Выберите ввод: 1 - из файла, 2 - из консоли (иное - из консоли)")
                val a = readln().toInt()
                if (a == 1) {
                    val path = "src/main/resources/aboba2.txt"
                    val encoded = Files.readAllLines(Paths.get(path))

                    exmpl.ex2(encoded[0].toDouble(), encoded[1].toDouble())
                } else {
                    val x: Double = readln().toDouble()
                    val y: Double = readln().toDouble()
                    exmpl.ex2(x,y)
                }
            }
            3 ->{
                println("Выберите ввод: 1 - из файла, 2 - из консоли (иное - из консоли)")
                val a = readln().toInt()
                if (a == 1) {
                    val path = "src/main/resources/aboba3.txt"
                    val encoded = Files.readAllLines(Paths.get(path))

                    exmpl.ex3(encoded[0].toInt())
                } else {
                    val x: Int = readln().toInt()
                    exmpl.ex3(x)
                }
            }
            4 ->{
                println("Выберите ввод: 1 - из файла, 2 - из консоли (иное - из консоли)")
                val a = readln().toInt()
                if (a == 1) {
                    val path = "src/main/resources/aboba4.txt"
                    val encoded = Files.readAllLines(Paths.get(path))
                    exmpl.ex4(encoded[0].toDouble())
                } else {
                    val x: Double = readln().toDouble()
                    exmpl.ex4(x)
                }
            }
            5 -> {
                println("Выберите ввод: 1 - из файла, 2 - из консоли (иное - из консоли)")
                val a = readln().toInt()
                if (a == 1) {
                    val path = "src/main/resources/aboba5.txt"
                    val encoded = Files.readAllLines(Paths.get(path))
                    exmpl.ex5(encoded[0].toDouble(),encoded[1].toDouble(),encoded[2].toDouble())
                } else {
                    val rad: Double = readln().toDouble()
                    val diam: Double = readln().toDouble()
                    val len: Double = readln().toDouble()
                    exmpl.ex5(rad, diam, len)
                }
            }
            6 ->{
                println("Выберите ввод: 1 - из файла, 2 - из консоли (иное - из консоли)")
                val a = readln().toInt()
                if (a == 1) {
                    val path = "src/main/resources/aboba6.txt"
                    val encoded = Files.readAllLines(Paths.get(path))
                    exmpl.ex6(encoded[0], encoded[1])
                } else {
                    val str1: String = readln()
                    val str2: String = readln()
                    exmpl.ex6(str1,str2)
                }
            }
            7 -> {
                println("Выберите ввод: 1 - из файла, 2 - из консоли (иное - из консоли)")
                val a = readln().toInt()
                if (a == 1) {
                    val path = "src/main/resources/aboba7.txt"
                    val encoded = Files.readAllLines(Paths.get(path))

                    exmpl.ex7(encoded[0].toInt())
                } else {
                    val x: Int = readln().toInt()
                    exmpl.ex7(x)
                }
            }
            8 -> {
                println("Выберите ввод: 1 - из файла, 2 - из консоли (иное - из консоли)")
                val a = readln().toInt()
                if (a == 1) {
                    val path = "src/main/resources/aboba8.txt"
                    val encoded = Files.readAllLines(Paths.get(path))

                    exmpl.ex8(encoded[0].toInt())
                } else {
                    val x: Int = readln().toInt()
                    exmpl.ex8(x)
                }
            }
            else -> println("CrItIcAl ErRoR")
        }
    }
}
