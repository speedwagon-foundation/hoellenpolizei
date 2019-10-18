import listeners.FileListener
import listeners.MessageFormatListener
import org.javacord.api.DiscordApiBuilder
import utils.parseCredentials

fun main() {
    val token: String? = parseCredentials()?.token
    if (token == null) println("--Error: failed to load credentials.")
    val api = DiscordApiBuilder().setToken(token).login().join()
    api.addMessageCreateListener(FileListener())
    api.addMessageCreateListener(MessageFormatListener())
}
