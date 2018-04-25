# rxAndroid Fortnite API Wrapper
[![npm](https://img.shields.io/npm/l/express.svg)](https://github.com/whiskermrr/rxandroid-fortnite-api/blob/master/LICENSE)

## Usage

### Prerequisites
You need to create EpicGames account and download EpicGames Launcher [here](https://www.epicgames.com/fortnite/pl/buy-now/battle-royale). After this you will need to install Fortnite.

### Obtaining Tokens
Follow these steps to get your launcher and fortnite tokens:

- Install [Fiddler](https://www.telerik.com/download/fiddler) or other application for capturing HTTPS requests.
- Start EpicGames Launcher and Login (wrapper does not support 2-step verification).
- Look for request to `/account/api/oauth/token` endpoint and go to Authorization Header.
- Copy the value of header without 'basic'. This is Launcher Token.
- Launch Fortnite.
- Check for another request to `/account/api/oauth/token` endpoint and go to Authorization Header.
- Once again copy the new value of header without 'basic'. This is Fortnite Token.


### Creating API Instance

```java
FortniteApi fortniteApi = new FortniteApi(retrofit, EMAIL, PASSWORD, LAUNCHER_TOKEN, FORTNITE_TOKEN);
fortniteApi.authenticate();
```
