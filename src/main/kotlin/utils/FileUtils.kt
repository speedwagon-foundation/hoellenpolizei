package utils

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import java.io.File

object FileUtils {
    fun getExtension(name: String) = name.split(".").last()
    fun getResourceFolder() = """${System.getProperty("user.dir")}\src\main\resources"""

    fun getIcon(fileName: String) = File("""${getResourceFolder()}\icons\$fileName""")
}