import java.util.*
import kotlin.system.exitProcess

object WinnieThePooh {
    /**
     * @author Novikov "iVanFromJapan" Ivan
     * @version 1.🤨¯\_(ツ)_/¯🤨        */
    /** Поле количества пчел   */
    private var honeyPot = 0
    /** Поле размера порции меда   */
    private const val PORTION_SIZE = 5
    /** Поле размера порции, приносимой пчелами   */
    private const val BEE_PORTION = 1
    /** Поле времени между поеданием меда   */
    private const val HONEY_CONSUMPTION_RATE = 2
    /** Поле максимальной задержки пчелы   */
    private const val MAX_WAIT_TIME = 5000
    @JvmStatic
    fun main(args: Array<String>) {
        val bees = arrayOfNulls<Thread>(10)
        for (i in bees.indices) {
            bees[i] = Thread(Bee())
            bees[i]?.start()
        }
        while (true) {
            try {
                Thread.sleep((HONEY_CONSUMPTION_RATE * 1000).toLong())
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
            if (honeyPot < PORTION_SIZE) {
                println("Винни-Пух помер с голодухи(((((")
                exitProcess(0)
            }
            honeyPot -= PORTION_SIZE
            println("Винни поель, меда осталось в горшке: $honeyPot")
        }
    }
    /**
     * Класс работы пчелы в отдельном потоке
     */
    class Bee : Runnable {
        private val random = Random()
        override fun run() {
            while (true) {
                try {
                    Thread.sleep(random.nextInt(MAX_WAIT_TIME).toLong())
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
                honeyPot += BEE_PORTION
                println("Пчела принесла $BEE_PORTION едениц меда. Сейчас меда в горшке: $honeyPot")
            }
        }
    }
}