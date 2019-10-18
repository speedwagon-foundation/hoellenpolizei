package models

data class Config(
    val markup_channels: List<Long>,
    val recognisedFileTypes: List<FileType>,
    val botId: Long
)