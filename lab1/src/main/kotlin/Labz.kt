class Labz {
    /**
     * @author Novikov "iVanFromJapan" Ivan
     * @version 1.?        */


    /**Задание 1
     * Программа, в которой перебираются числа от 1 до 500 и выводятся на экран. Если
     * число делится на 5, то вместо него выводится слово fizz, если на 7, то buzz. Если число
     * делится на 5 и на 7, то выводить слово fizzbuzz.
     */
    fun ex1(){
        println("Задание 1")
        val str = "fizz"
        val str1 = "buzz"
        val str3 = "fizzbuzz"
        for (i in 0..500) {
            if (i % 5 == 0 && i % 7 == 0) {
                print("$str3 ")
            } else {
                if (i % 5 == 0) {
                    print("$str1 ")
                } else {
                    if (i % 7 == 0) {
                        print("$str ")
                    } else {
                        print("$i ")
                    }
                }
            }
        }
    }
    /**Задание 2
     * Программа, в которой все переданные во входную строку аргументы выводятся
    на экран в обратной порядке. */
    fun ex2(){
        println("Задание 2")
        println("Строка наоборот")
        val str: String = readln()
        for (i in str.length - 1 downTo 0) {
            print(str[i])
        }
        println()
    }
    /**Задание 3
     * Создайте программу, вычисляющую числа Фибоначчи. Числа Фибоначчи –
     * последовательность чисел, в котором каждое следующее число равно сумме двух
     * предыдущих. Начало этой последовательности – числа 1, 1, 2, 3, 5, 8, 13…
     */
    fun ex3(){
        println("Задание 3")
        println("Числа Фибоначчи")
        val n = 13
        val arr = IntArray(n)
        arr[0] = 0
        arr[1] = 1
        for (i in 2 until n) {
            arr[i] = arr[i - 1] + arr[i - 2]
            print(arr[i].toString() + " ")
        }
        println()
    }
    /**Задание 4
     * Создайте программу, вычисляющую факториал целого числа.
     */
    fun ex4(){
        println("Задание 4")
        println("Факториал числа")
        val a: Int = readln().toInt()
        var res = 1
        for (i in 1..a) {
            res *= i
        }
        println("Факториал числа = $res")
    }
    /**
    Функция, рассчитывающая НОД по методу Евклида
    * @param a - первое число
    * @param b - второе число
    * @return возврящает НОД двух чисел
     */
    private fun nodFound(a: Int, b: Int): Int {
        var a1 = a
        var b1 = b
        while (b1!=0){
            val temp = b1
            b1 = a1 % b1
            a1 = temp
        }

        return a1
    }

    /** Индивидуальное задание
     *  Вариант №7 Ввести с консоли 3 целых числа. На консоль вывести: Наибольший общий
     *  делитель этих чисел.
    */
    fun ex5(){
        println("Задание 5")
        println("НОД чисел")
        val a = readln()
        val list = a.split(" ")

        var res = nodFound(list[0].toInt(), list[1].toInt())
        res = nodFound(res, list[2].toInt())
        println("НОД чисел = $res")
    }
}