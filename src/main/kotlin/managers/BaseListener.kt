package managers

import org.javacord.api.event.message.MessageCreateEvent
import org.javacord.api.listener.message.MessageCreateListener

open class BaseListener: MessageCreateListener {
    override fun onMessageCreate(event: MessageCreateEvent?) {
        if(event?.messageAuthor?.id == Globals.botId) return
    }
}