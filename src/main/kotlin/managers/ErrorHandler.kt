package managers

import org.javacord.api.entity.message.embed.EmbedBuilder
import java.awt.Color

object ErrorHandler {
    fun getErrorEmbed(error: String): EmbedBuilder {
        return EmbedBuilder()
            .setTitle(error)
            .setColor(Color.RED)
    }
}