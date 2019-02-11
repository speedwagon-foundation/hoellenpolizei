package listeners

import managers.ConfigManager
import org.javacord.api.event.message.MessageCreateEvent
import org.javacord.api.listener.message.MessageCreateListener

open class BaseListener: MessageCreateListener {
    override fun onMessageCreate(event: MessageCreateEvent?) {

    }
    fun checkIfAuthorIsBot(event: MessageCreateEvent): Boolean {
        return event.messageAuthor?.id == ConfigManager.instance.botId
    }
}