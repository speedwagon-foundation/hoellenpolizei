import com.beust.klaxon.JsonObject
import com.beust.klaxon.Parser
import org.javacord.api.DiscordApiBuilder
import utils.parseResource
import java.io.File

fun main() {
    val token = loadCredentials()
    if (token == null) println("--Error: failed to load credentials.")
    val api = DiscordApiBuilder().setToken(token).login().join()
    api.addMessageCreateListener { messageCreateEvent ->
        messageCreateEvent.messageAttachments?.let { attachments ->
            attachments.forEach {
                //TODO convert file to output
            }
        }
    }
}

fun loadCredentials(): String? {
    val fileName = "credentials.json"
    return (parseResource(fileName) as JsonObject).string("token")
}

object Globals {
    val botId: Long = -1 //TODO read botid from config file
}