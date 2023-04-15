import java.util.*

object HoneybeesSimulation {
    /**
     * @author Novikov "iVanFromJapan" Ivan
     * @version 1.🤨¯\_(ツ)_/¯🤨        */

    /** Поле количества пчел   */
    private const val NUM_BEES = 3
    /** Поле размера порции меда   */
    private const val HONEY_PORTION_SIZE = 1
    /** Поле скрости потребления меда   */
    private const val HONEY_CONSUMPTION_RATE = 3
    /** Поле максимальной задержки пчелы   */
    private const val MAX_DELAY_TIME = 500
    /** Поле текущего количества меда   */
    private var honeyPot = 0
    @JvmStatic
    fun main(args: Array<String>) {
        val bees = arrayOfNulls<Thread>(NUM_BEES)

        for (i in 0 until NUM_BEES) {
            bees[i] = Thread(Bee(i))
        }

        for (bee in bees) {
            bee!!.start()
        }

        while (true) {
            try {
                Thread.sleep(500)
                consumeHoney()
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
        }
    }

    /**
     * метод для потребления меда Винни-Пухом
     */
    private fun consumeHoney() {
        synchronized(HoneybeesSimulation::class.java) {
            if (honeyPot >= HONEY_CONSUMPTION_RATE) {
                honeyPot -= HONEY_CONSUMPTION_RATE
                println("Винни-Пух съел порцию меда. Осталось " + honeyPot + " порций меда.")
            } else {
                println("В горшке не хватает меда для Винни-Пуха!")
            }
        }
    }

    /**
     * Класс рабты пчелы в отдельном потоке
     * @param beeNumber номер пчелы
     */
    private class Bee(private val beeNumber: Int) : Runnable {
        override fun run() {
            val random = Random()
            while (true) {
                try {
                    Thread.sleep(random.nextInt(MAX_DELAY_TIME).toLong())
                    collectHoney()
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
            }
        }
        /**
         * метод для сбора меда пчелой
         */
        private fun collectHoney() {
            synchronized(HoneybeesSimulation::class.java) {
                honeyPot += HONEY_PORTION_SIZE
                println("Пчела " + beeNumber + " принесла порцию меда. В горшке " + honeyPot + " порций меда.")
            }
        }
    }
}