import org.javacord.api.DiscordApiBuilder

fun main() {
    var token = loadCredentials()
    var api =  DiscordApiBuilder().setToken(token).login().join()
    api.addMessageCreateListener {
        it.messageContent.startsWith("!ping")
        it.channel.sendMessage("hello")
    }
}

fun loadCredentials() :String {
}