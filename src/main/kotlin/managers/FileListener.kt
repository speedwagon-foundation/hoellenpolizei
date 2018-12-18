package managers

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import org.javacord.api.entity.message.MessageAttachment
import org.javacord.api.event.message.MessageCreateEvent
import java.nio.charset.Charset

class FileListener : BaseListener() {
    override fun onMessageCreate(event: MessageCreateEvent?) {
        super.onMessageCreate(event)


        event?.messageAttachments?.let { attachments ->
            attachments.forEach {
                //TODO convert file to output
                it?.let { attachment ->
                    printCodeBlock(attachment)
                }
            }
        }
    }

    fun printCodeBlock(attachment: MessageAttachment) {
        println("Processing <${attachment.fileName}>")
        val fileExtension = attachment.fileName.split(".").last()

        if(Globals.recognisedFileTypes.keys.contains(fileExtension)) {
            val content = attachment.url.readText()
            val message = """
                |```${Globals.recognisedFileTypes[fileExtension]}
                |$content
                |```
            """.trimMargin("|")
            if(content.length<2000) {
                attachment.message.channel.sendMessage(message)
                attachment.message.delete()
            }
        }
    }
}