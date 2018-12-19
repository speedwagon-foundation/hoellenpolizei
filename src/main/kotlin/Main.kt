import listeners.FileListener
import org.javacord.api.DiscordApiBuilder
import utils.parseResource

fun main() {
    val token = loadCredentials()
    if (token == null) println("--Error: failed to load credentials.")
    val api = DiscordApiBuilder().setToken(token).login().join()
    api.addMessageCreateListener(FileListener())
}

fun loadCredentials(): String? {
    val fileName = "credentials"
    return parseResource(fileName)?.string("token")
}