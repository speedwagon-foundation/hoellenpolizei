package utils

import org.javacord.api.entity.message.Message
import org.javacord.api.entity.message.embed.EmbedBuilder
import java.awt.Color

object EmbedUtil {
    fun getFileMetaInfo(message: Message): EmbedBuilder {
        return EmbedBuilder()
                .setColor(Color.GREEN)
                .setAuthor(message.attachments.first().fileName,message.attachments.first().url,)
    }

    fun getErrorEmbed(error: String): EmbedBuilder {
        return EmbedBuilder()
            .setTitle(error)
            .setColor(Color.RED)
    }
}