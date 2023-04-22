package com.org.lab3

import kotlin.math.*


class Lab3 {

    /**
     * @author Novikov "iVanFromJapan" Ivan
     * @version 1.🤨¯\_(ツ)_/¯🤨        */
    /**Задание 1
     * Вычислить значения выражения по формуле
     * @param x - первое число
     * @param y - второе число
     */
    fun ex1(x: Double, y: Double) {
        val z = (8 * ((1 - tan(x)).pow(1.0 / tan(y)))) + cos(x - y)
        println(z)
        logger.info("Задание 1 выполнено. Результат работы $z")
    }

    /**Задание 2
     * Даны два действительных числа x и у. Вычислить их сумму, разность, произведение и
     * частное.
     * @param x - первое число
     * @param y - второе число
     */
    fun ex2(x: Double, y: Double) {
        val summ = x + y
        val multip = x * y
        val substr = x - y
        val divis = x / y
        println("Сумма чисел равна $summ")
        println("Произведение чисел равно $multip")
        println("Разность чисел равна $substr")
        println("Частное чисел равно $divis")
        logger.info("Задание 2 выполнено. Результат работы $summ $multip $substr $divis")
    }

    /**Задание 3
     * Дано трехзначное число N. Проверить, будет ли сумма его цифр четным числом.
     * @param x - число для проверки
     */
    fun ex3(x: Int) {
        var x1 = x
        var a = 0
        if (x < 100) {
            logger.error("Задание 3,  ошибка. Вы ввели не трехзначное число")
            return error("Вы ввели не трехзначное число!!!")

        }
        while (x1 > 0) {
            a += x % 10
            x1 /= 10
        }
        if (a % 2 == 0) {
            println("da")
            logger.info("Задание 3 выполнено. Результат работы: da")
        } else {
            println("net")
            logger.info("Задание 3 выполнено. Результат работы: net")
        }
    }

    /**Задание 4
     * Дано число x. Напечатать в порядке возрастания числа: sin x, cos x, ln x. Если при
     * каком-либо x некоторые из выражений не имеют смысла, вывести сообщение об этом и
     * сравнивать значения только тех, которые имеют смысл.
     * @param x - число для рассчета значений
     */
    fun ex4(x: Double) {

        val sn = sin(x)
        val cs = cos(x)
        val lnn = ln(x)
        val res = mutableListOf<Double>()
        if (lnn.isNaN()) {
            println("Натуральный логарифм не существует при таком Х")
            res.add(sn)
            res.add(cs)
        } else {
            res.add(sn)
            res.add(cs)
            res.add(lnn)
        }
        res.sort()
        println(res)
        logger.info("Задание 4 выполнено. Результат работы: $res")
    }

    /**Задание 5
     * Пусть элементами круга являются радиус (первый элемент), диаметр (второй элемент) и
     * длина окружности (третий элемент). Составить программу, которая по номеру элемента
     * запрашивала бы его соответствующее значение и вычисляла бы площадь круга.
     * @param rad - радиус круга
     * @param diam - диаметр круга
     * @param len - длинна окружности
     */
    fun ex5(rad: Double, diam: Double, len: Double) {
        println("1 - Через радиус")
        println("2 - Через диаметр")
        println("3 - Через длину окружности")
        val a = readln().toInt()
        var res = 0.0

        when (a) {
            1 -> {
                res = PI * rad.pow(2)
                println(res)

            }

            2 -> {
                res = 0.25 * PI * diam.pow(2)
                println(res)
            }

            3 -> {
                res = (len.pow(2)) / (4 * PI)
                println(res)
            }

            else -> println("CrItIcAl ErRoR")
        }
        logger.info("Задание 5 выполнено. Результат работы: $res")
    }

    /**Задание 6
     * Даны натуральные числа n, k. Проверить, есть ли в записи числа nk цифра m.
     * @param str1 - первое число в строковом формате
     * @param str2 - второе число в строковом формате
     */
    fun ex6(str1: String, str2: String) {
        var str = str1
        println("Введите цифру для поиска в строке")
        val a = readln().toCharArray()
        var res: Boolean = false
        str += str2
        for (char in str.toCharArray()) {
            if (char == a[0]) {
                res = true
            }
        }
        if (res) {
            logger.info("Задание 6 выполнено. Результат работы: Число содержится в $str")
            println("Число содержится в $str")
        } else {
            logger.info("Задание 6 выполнено. Результат работы: Число НЕ содержится в $str")
            println("Число НЕ содержится в $str")
        }
    }

    /**Задание 7
     * Дано натуральное число N. Вычислить:
     * @param n - число для рассчета значений
     */
    fun ex7(n: Int) {
        var sn = 0.0
        var sum = 0.0
        for (i in 1..n) {
            sn += sin(i.toDouble())
            sum += 1 / sn
        }
        logger.info("Задание 7 выполнено. Результат работы: $sum")
        println(sum)
    }

    /**Задание 8
     * Дано натуральное число S. Дана последовательность 5, 9, 13, 17,... Сколько слагаемых
     * следует взять, чтобы получить сумму, равную либо превышающую S? Результат вывести
     * на экран.
     * @param n - число для рассчета значений
     */
    fun ex8(n: Int) {
        var a = 5
        var k = 0
        while (a < n) {
            a += 4
            k++
        }
        logger.info("Задание 8 выполнено. Результат работы: $k")
        println(k)
    }
}