# hoellenpolizei

## How it works

When a user uploads a file to a channel the file will get read by the bot and will be printed as a code block with syntax highlighting (if supported for language) as a message into the channel. 

##### Conditions

- The file needs to be smaller than 2000 characters

## Configuration

##### Config.json

##### credentials.json

Location: resources/credentials.json

Structure: 

```json
{
  "token": "<token>"
}
```

##### config.json

Location: resources/config.json


Structure:

```json
{
  "markup_channels": [
    <channelid>,
    ...
  ],
  "recognisedFileTypes": [
    {
      "fileType": "<fileextension>",
      "highlightjs": "<highlightjs>",
      "iconUrl": "<icon file name with extension>"
    },
    ...
  ],
  "botId": 522309064622080010
}
```

Supported languages can be found [here](https://highlightjs.org/static/demo)
