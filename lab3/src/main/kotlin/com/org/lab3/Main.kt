package com.org.lab3

import org.apache.logging.log4j.LogManager
import java.nio.file.Files
import java.nio.file.Paths
import org.apache.logging.log4j.Logger


val logger: Logger = LogManager.getLogger("MyLogger")

/**
 * @author Novikov "iVanFromJapan" Ivan
 * @version 1.🤡         */
fun main() {
    val exmpl = Lab3()
    var n: Int = -1
    while (n != 0) {

        println("---------------------------------------")
        println("Выберите задание")
        n = readln().toInt()
        /**
         * @see Lab3
         */
        try {
            processInput(n, exmpl)
        } catch (e: Exception) {
            logger.fatal("Something went wrong\n${e.javaClass.name}\n${e.message}")
        }
    }
}

private fun processInput(n: Int, exmpl: Lab3) {

    when (n) {
        1 -> {
            logger.debug("Выбрано задание 1")
            println("Выберите ввод: 1 - из файла, 2 - из консоли (иное - из консоли)")
            val a = readln().toInt()
            case1(a, exmpl)
        }

        2 -> {
            logger.debug("Выбрано задание 2")
            println("Выберите ввод: 1 - из файла, 2 - из консоли (иное - из консоли)")
            val a = readln().toInt()
            case2(a, exmpl)
        }

        3 -> {
            logger.debug("Выбрано задание 3")
            println("Выберите ввод: 1 - из файла, 2 - из консоли (иное - из консоли)")
            val a = readln().toInt()
            case3(a, exmpl)
        }

        4 -> {
            logger.debug("Выбрано задание 4")
            println("Выберите ввод: 1 - из файла, 2 - из консоли (иное - из консоли)")
            val a = readln().toInt()
            case4(a, exmpl)
        }

        5 -> {
            logger.debug("Выбрано задание 5")
            println("Выберите ввод: 1 - из файла, 2 - из консоли (иное - из консоли)")
            val a = readln().toInt()
            case5(a, exmpl)
        }

        6 -> {
            logger.debug("Выбрано задание 6")
            println("Выберите ввод: 1 - из файла, 2 - из консоли (иное - из консоли)")
            val a = readln().toInt()
            case6(a, exmpl)
        }

        7 -> {
            logger.info("Выбрано задание 7")
            println("Выберите ввод: 1 - из файла, 2 - из консоли (иное - из консоли)")
            val a = readln().toInt()
            case7(a, exmpl)
        }

        8 -> {
            logger.debug("Выбрано задание 8")
            println("Выберите ввод: 1 - из файла, 2 - из консоли (иное - из консоли)")
            val a = readln().toInt()
            case8(a, exmpl)
        }

        else -> println("CrItIcAl ErRoR")
    }
}

private fun case8(a: Int, exmpl: Lab3) {
    if (a == 1) {
        val path = "src/main/resources/aboba7.txt"
        val encoded = Files.readAllLines(Paths.get(path))
        exmpl.ex8(encoded[0].toInt())
    } else {
        val x: Int = readln().toInt()
        exmpl.ex8(x)
    }
}

private fun case7(a: Int, exmpl: Lab3) {
    if (a == 1) {
        val path = "src/main/resources/aboba7.txt"
        val encoded = Files.readAllLines(Paths.get(path))
        exmpl.ex7(encoded[0].toInt())
    } else {
        val x: Int = readln().toInt()
        exmpl.ex7(x)
    }
}

private fun case6(a: Int, exmpl: Lab3) {
    if (a == 1) {
        val path = "src/main/resources/aboba6.txt"
        val encoded = Files.readAllLines(Paths.get(path))
        exmpl.ex6(encoded[0], encoded[1])
    } else {
        val str1: String = readln()
        val str2: String = readln()
        exmpl.ex6(str1, str2)
    }
}

private fun case5(a: Int, exmpl: Lab3) {
    if (a == 1) {
        val path = "src/main/resources/aboba5.txt"
        val encoded = Files.readAllLines(Paths.get(path))
        exmpl.ex5(encoded[0].toDouble(), encoded[1].toDouble(), encoded[2].toDouble())
    } else {
        val rad: Double = readln().toDouble()
        val diam: Double = readln().toDouble()
        val len: Double = readln().toDouble()
        exmpl.ex5(rad, diam, len)
    }
}

private fun case4(a: Int, exmpl: Lab3) {
    if (a == 1) {
        val path = "src/main/resources/aboba4.txt"
        val encoded = Files.readAllLines(Paths.get(path))
        exmpl.ex4(encoded[0].toDouble())
    } else {
        val x: Double = readln().toDouble()
        exmpl.ex4(x)
    }
}

private fun case3(a: Int, exmpl: Lab3) {
    if (a == 1) {
        val path = "src/main/resources/aboba3.txt"
        val encoded = Files.readAllLines(Paths.get(path))

        exmpl.ex3(encoded[0].toInt())
    } else {
        val x: Int = readln().toInt()
        exmpl.ex3(x)
    }
}

private fun case2(a: Int, exmpl: Lab3) {
    if (a == 1) {
        val path = "src/main/resources/aboba2.txt"
        val encoded = Files.readAllLines(Paths.get(path))

        exmpl.ex2(encoded[0].toDouble(), encoded[1].toDouble())
    } else {
        val x: Double = readln().toDouble()
        val y: Double = readln().toDouble()
        exmpl.ex2(x, y)
    }
}

private fun case1(a: Int, exmpl: Lab3) {
    if (a == 1) {
        val path = "src/main/resources/aboba1.txt"
        val encoded = Files.readAllLines(Paths.get(path))
        exmpl.ex1(encoded[0].toDouble(), encoded[1].toDouble())
    } else {
        val x: Double = readln().toDouble()
        val y: Double = readln().toDouble()
        exmpl.ex1(x, y)
    }
}
