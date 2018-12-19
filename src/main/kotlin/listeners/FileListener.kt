package listeners

import managers.ConfigManager
import managers.ErrorHandler
import org.javacord.api.entity.message.MessageAttachment
import org.javacord.api.entity.message.embed.EmbedBuilder
import org.javacord.api.event.message.MessageCreateEvent
import java.awt.Color

class FileListener : BaseListener() {
    override fun onMessageCreate(event: MessageCreateEvent?) {
       if(super.checkIfAuthorIsBot(event!!)) return
        if (ConfigManager.instance.markupChannels.contains(event?.message?.channel?.id)) {
            event?.messageAttachments?.let { attachments ->
                attachments.forEach {
                    //TODO convert file to output
                    it?.let { attachment ->
                        printCodeBlock(attachment)
                    }
                }
            }
        }
    }

    fun printCodeBlock(attachment: MessageAttachment) {
        println("Processing <${attachment.fileName}>")
        if (!attachment.fileName.contains(".")) {
            attachment.message.channel.sendMessage(ErrorHandler.getErrorEmbed("Error: Unable to parse file! Reason: No File extension"))
        }

        val fileExtension = attachment.fileName.split(".").last()

        if (ConfigManager.instance.allowedLanguages.keys.contains(fileExtension)) {
            val content = attachment.url.readText()
            val message = """
                |```${ConfigManager.instance.allowedLanguages[fileExtension]}
                |$content
                |```
            """.trimMargin("|")
            if (content.length < 2000) {
                attachment.message.channel.sendMessage(message)
                attachment.message.delete()
            }
        }
    }
}