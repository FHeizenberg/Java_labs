import org.jsoup.Jsoup
import java.io.File
import java.io.FileWriter
import java.io.IOException
/**
 * @author Novikov "iVanFromJapan" Ivan
 * @version 1.🤡         */

object HTMLLinkParser {
    @Throws(IOException::class)
    @JvmStatic
            /** На вход программы подается произвольный html-файл, необходимо все ссылки
             *  http:// не находящиеся в теге <a> обернуть тегом <a> в качестве описания использовать имя домена до первого символа «/».
             *  Например, есть ссылка https://www.bsu.edu.ru/bsu/resource/schedule/teachers/index.php?teacher=150016
             *  Необходимо заменить на <a href='https://www.bsu.edu.ru/bsu/resource/schedule/teachers/index.php?teacher=150016'>bsu.edu.ru</a>
             *  Вывести в консоль статистику по обработанному файлу:
             *  - указать ссылки с тегом <a> и их количество повторений
             *  - указать ссылки без тега <a> обработанные и их повторения
             *  Сохранить новый html-файл.
             * .*/
    fun main(args: Array<String>) {
        val input = File("src/main/resources/index.html")
        /**
         * @see "https://jsoup.org/apidocs/"
        */
        val doc = Jsoup.parse(input, "UTF-8", "")

        val links = doc.select("a[href]")
        val linkCounts: MutableMap<String, Int> = HashMap()
        for (link in links) {
            val href = link.attr("href")
            if (!href.startsWith("http://") || link.tagName().equals("a", ignoreCase = true)) {
                continue
            }
            var domain = href.substring(7)
            val slashIndex = domain.indexOf('/')
            if (slashIndex != -1) {
                domain = domain.substring(0, slashIndex)
            }
            link.attr("href", href)
            link.text(domain)
            val count = linkCounts.getOrDefault(href, 0)
            linkCounts[href] = count + 1
        }

        println("Links with <a> tag: " + links.size)
        for (tags in linkCounts) {
            println(tags.key + " with <a> tag count: " + tags.value)
        }
        val otherLinks = doc.select("a:not([href])")
        println("Links without <a> tag: " + otherLinks.size)

        val writer = FileWriter("output.html")
        writer.write(doc.outerHtml())
        writer.close()
    }
}