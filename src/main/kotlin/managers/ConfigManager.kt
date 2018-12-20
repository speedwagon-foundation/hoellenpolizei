package managers

import com.beust.klaxon.JsonObject
import com.beust.klaxon.Klaxon
import models.FileType
import utils.parseResource
import java.io.File

class ConfigManager() {
    companion object {
        val instance = ConfigManager()
        private val associatedJsonObject: JsonObject = parseResource("config")!!
    }

    val markupChannels: MutableList<Long> = mutableListOf()
        get() {
            if (field.isNullOrEmpty()) {
                field.addAll(associatedJsonObject.array("markup_channels")!!)
            }
            return field
        }

    val allowedLanguages: MutableList<FileType> = mutableListOf()
        get() {
            if (field.isNullOrEmpty()) {
                field.addAll(Klaxon().parseArray(associatedJsonObject.array<Any>("recognisedFileTypes")!!.toJsonString())!!)
            }
            return field
        }

    var botId: Long = -1
        get() {
            if (field == (-1L)) {
                field = associatedJsonObject.long("botId")!!
            }
            return field
        }
}

fun List<FileType>.containsFileType(fileType: String) = this.map { it.fileType}.contains(fileType)

fun List<FileType>.getByFileType(fileType: String) = this.first { it.fileType == fileType }