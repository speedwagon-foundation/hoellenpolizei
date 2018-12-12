import com.beust.klaxon.JsonObject
import com.beust.klaxon.Klaxon
import com.beust.klaxon.Parser
import java.io.File

fun main() {
    val token = loadCredentials()
    if (token == null) println("--Error: failed to load credentials.")
}

fun loadCredentials(): String? {
    val fileName = "credentials.json"
    return (parse(fileName) as JsonObject).string("token")
}

fun parse(fileName: String): Any? {
    val resourceDir = System.getProperty("user.dir")
    val fullPath = """$resourceDir\src\main\resources\$fileName"""
    return File(fullPath).let {file ->
        file.reader().use {
            Parser().parse(it)
        }
    }
}