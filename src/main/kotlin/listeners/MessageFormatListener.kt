package listeners

import managers.ConfigManager
import org.javacord.api.entity.message.embed.EmbedBuilder
import org.javacord.api.event.message.MessageCreateEvent

class MessageFormatListener : BaseListener() {
    override fun onMessageCreate(event: MessageCreateEvent?) {
        if (super.checkIfAuthorIsBot(event!!)) return

        if (ConfigManager.instance.markupChannels.contains(event.message?.channel?.id)) {
            if (!event.messageAttachments?.isNullOrEmpty()!!) return

            if (event.messageContent.length < 2000) {
                var lang = event.messageContent.takeWhile { it != ' ' }
                val content: String
                if (ConfigManager.instance.allowedLanguages.filter { it.highlightjs == lang }.count() > 0) {
                    lang = ConfigManager.instance.allowedLanguages.first { it.fileType == lang }.fileType
                    content = event.messageContent.substring(lang.length + 1)
                } else {
                    lang = "ts"
                    content = event.messageContent
                }

                val isUrl = Regex("""(https?:\/\/(?:www\.|(?!www))[a-zA-Z0-9][a-zA-Z0-9-]+[a-zA-Z0-9]\.[^\s]{2,}|www\.[a-zA-Z0-9][a-zA-Z0-9-]+[a-zA-Z0-9]\.[^\s]{2,}|https?:\/\/(?:www\.|(?!www))[a-zA-Z0-9]+\.[^\s]{2,}|www\.[a-zA-Z0-9]+\.[^\s]{2,})""")
                val message = if(isUrl.matches(content)) {
                    content
                } else {
                    """
                    |```$lang
                    |$content
                    |```
                    """.trimMargin("|")
                }

                val embed = EmbedBuilder()
                    .setAuthor(event.message.author)
                event.channel.sendMessage(embed)
                    .thenAccept {
                        event.channel.sendMessage(message)
                        event.message.delete()
                    }
            }
        }
    }
}