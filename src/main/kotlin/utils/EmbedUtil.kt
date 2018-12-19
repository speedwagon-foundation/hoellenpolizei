package utils

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import managers.ConfigManager
import managers.getByFileType
import org.javacord.api.entity.message.Message
import org.javacord.api.entity.message.embed.EmbedBuilder
import java.awt.Color
import kotlin.system.measureTimeMillis

object EmbedUtil {
    fun getFileMetaInfo(message: Message): EmbedBuilder {
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
            .addField("Author",message.author.displayName)
    }


    fun getErrorEmbed(error: String): EmbedBuilder {
        return EmbedBuilder()
            .setTitle(error)
            .setColor(Color.RED)
    }
}