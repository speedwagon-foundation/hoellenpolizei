package utils


import java.io.File

object FileUtils {
    fun getExtension(name: String) = name.split(".").last()
    private fun getResourceFolder() = """${System.getProperty("user.dir")}${File.separator}src${File.separator}main${File.separator}resources"""

    fun getIcon(fileName: String) = File("""${getResourceFolder()}${File.separator}icons${File.separator}$fileName""")
}
