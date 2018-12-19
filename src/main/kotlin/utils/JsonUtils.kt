package utils

import com.beust.klaxon.*
import java.io.File

fun parseResource(fileName: String): JsonObject? {
    val resourceDir = System.getProperty("user.dir")
    val fullPath = """$resourceDir\src\main\resources\$fileName.json"""
    return File(fullPath).let { file ->
        file.reader().use {
            Parser().parse(it)
        } as JsonObject
    }
}