package managers

import org.javacord.api.event.message.MessageCreateEvent

class FileListener: BaseListener() {
    override fun onMessageCreate(event: MessageCreateEvent?) {
        super.onMessageCreate(event)

        event?.messageAttachments?.let { attachments ->
            attachments.forEach {
                //TODO convert file to output

            }
        }
    }
}