import java.net.HttpURLConnection
import java.net.URL

class Main

fun main() {
    val url = URL("http://localhost:9166/persons/1")
    val con: HttpURLConnection = url.openConnection() as HttpURLConnection
    con.requestMethod = "GET"
}