package utils

import managers.ConfigManager
import managers.getByFileType
import org.javacord.api.entity.message.Message
import org.javacord.api.entity.message.embed.EmbedBuilder
import java.awt.Color
import kotlin.system.measureTimeMillis

object EmbedUtil {
    fun getFileMetaInfo(message: Message): EmbedBuilder {
        val displayName = message.author.displayName
        return EmbedBuilder()
            .setColor(Color.GREEN)
            .setAuthor(
                message.attachments.first().fileName,
                message.attachments.first().url.toString(),
                FileUtils.getIcon(
                    ConfigManager.instance.allowedLanguages.getByFileType(
                        FileUtils.getExtension(
                            message.attachments.first().fileName
                        )
                    ).iconUrl
                )
            )
            .addField("Author", displayName)
    }


    fun getErrorEmbed(error: String): EmbedBuilder {
        return EmbedBuilder()
            .setTitle(error)
            .setColor(Color.RED)
    }
}
