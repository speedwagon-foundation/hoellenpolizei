package managers

import com.beust.klaxon.JsonObject
import utils.parseResource

class ConfigManager() {
    companion object {
        val instance = ConfigManager()
        private val associatedJsonObject: JsonObject = parseResource("config")!!
    }

    var markupChannels: MutableList<Long> = mutableListOf()
        get() {
            if (field.isNullOrEmpty()) {
                field.addAll(associatedJsonObject.array("markup_channels")!!)
            }
            return field
        }

    var allowedLanguages: MutableMap<String, String> = mutableMapOf()
        get() {
            if (field.isNullOrEmpty()) {
                field.putAll(associatedJsonObject.obj("recognisedFileTypes")?.toMap()!!.mapValues { it.value.toString() })
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