package utils

import com.beust.klaxon.*
import models.Config
import models.Credentials
import java.io.File

fun parseCredentials(): Credentials? {
    return Klaxon().parse<Credentials>(readFile("credentials"))
}

fun parseConfig(): Config? {
    return Klaxon().parse<Config>(readFile("config"))
}

fun readFile(filename: String): String {
    val resourceDir = System.getProperty("user.dir")
    val fullPath = """$resourceDir${File.separator}src${File.separator}main${File.separator}resources${File.separator}$filename.json"""
    return File(fullPath).readText()
}