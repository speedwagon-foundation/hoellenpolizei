package utils

import com.beust.klaxon.*
import models.Config
import models.Credentials
import java.io.File

object JsonUtils {
    private val klaxon = Klaxon()
    fun parseCredentials(): Credentials? {
        return klaxon.parse<Credentials>(readFile("credentials"))
    }

    fun parseConfig(): Config? {
        return klaxon.parse<Config>(readFile("config"))
    }

    private fun readFile(filename: String): String {
        val resourceDir = System.getProperty("user.dir")
        val fullPath = """$resourceDir${File.separator}$filename.json"""
        return File(fullPath).readText()
    }
}
