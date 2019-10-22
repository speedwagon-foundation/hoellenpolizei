import listeners.FileListener
import listeners.MessageFormatListener
import org.javacord.api.DiscordApiBuilder
import utils.JsonUtils.parseCredentials

fun main() {
    val token: String? = parseCredentials()?.token
    if (token == null) {
        println("--Error: failed to load credentials.")
    } else {
        val api = DiscordApiBuilder().setToken(token).login().join()
        api.addMessageCreateListener(FileListener())
        api.addMessageCreateListener(MessageFormatListener())
    }
}
