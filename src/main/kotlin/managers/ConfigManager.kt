package managers

import models.Config
import models.FileType
import utils.JsonUtils.parseConfig

class ConfigManager() {
    companion object {
        val instance = ConfigManager()
        private val config: Config = parseConfig()!!
    }

    val markupChannels: MutableList<Long> = mutableListOf()
        get() {
            if (field.isNullOrEmpty()) {
                field.addAll(config.markup_channels)
            }
            return field
        }

    val allowedLanguages: MutableList<FileType> = mutableListOf()
        get() {
            if (field.isNullOrEmpty()) {
                field.addAll(config.recognisedFileTypes)
            }
            return field
        }

    var botId: Long = -1
        get() {
            if (field == (-1L)) {
                field = config.botId
            }
            return field
        }
}

fun List<FileType>.containsFileType(fileType: String) = this.map { it.fileType}.contains(fileType)

fun List<FileType>.getByFileType(fileType: String) = this.first { it.fileType == fileType }