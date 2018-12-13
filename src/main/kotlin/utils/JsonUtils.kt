package utils

import com.beust.klaxon.Parser
import java.io.File


fun parseResource(fileName: String): Any? {
    val resourceDir = System.getProperty("user.dir")
    val fullPath = """$resourceDir\src\main\resources\$fileName"""
    return File(fullPath).let { file ->
        file.reader().use {
            Parser().parse(it)
        }
    }
}