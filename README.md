# RxAndroid Fortnite API Wrapper
[![Packagist](https://img.shields.io/packagist/l/doctrine/orm.svg)](https://github.com/whiskermrr/rxandroid-fortnite-api/blob/master/LICENSE)

## Usage

### Prerequisites
You need to create EpicGames account and download EpicGames Launcher [here](https://www.epicgames.com/fortnite/pl/buy-now/battle-royale). After this you will need to install Fortnite.

### Installation

Gradle:

```groovy
dependencies {
    implementation 'com.whiskermrr:rxjava-fortnite-api:0.3.6'
}
```

Maven:

```xml
<dependency> 
  <groupId>com.whiskermrr</groupId>
  <artifactId>rxjava-fortnite-api</artifactId>
  <version>0.3.6</version>
  <type>pom</type>
</dependency>
```

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
### Battle Royale Stats

```java
fortniteApi.getUserBattleRoyaleStats("whiskermrr")
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new SingleObserver<BattleRoyaleStats>() {
            @Override
            public void onSubscribe(Disposable d) {
                // e.g. disposables.add(d);
            }

            @Override
            public void onSuccess(BattleRoyaleStats stats) {
                // e.g. update view
            }

            @Override
            public void onError(Throwable e) {
                // e.g. notify view about error
            }
        });
```

### Blogs

Example of how to get 10 News with offset 0:

```java
fortniteApi.getBlogs(FortniteApiConstants.PATCH_NOTES, 10, 0, Locale.US.toString())
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new SingleObserver<BlogHolder>() {
            @Override
            public void onSubscribe(Disposable d) {
                // e.g. disposables.add(d);
            }

            @Override
            public void onSuccess(BlogHolder news) {
                // e.g. update recyclerview
            }

            @Override
            public void onError(Throwable e) {
                // e.g. notify view about error
            }
        });
```

### Python Script to create weapons Json file

If You have installed Python on your computer You can check <b>fortnite_weapons.py</b> file which is in the root directory of repo.<br/>
Script is getting data about all weapons in Battle Royale Mode from Gamepedia and save them in json file.<br/>
It is also capable to download all images of weapons when -img argument of the script is specified.<br/>
-img values:<br/>
0 - do not download images<br/>
1 - download images (120px)<br/>
2 - download images (240px)<br/>
3 - download images (360px)<br/>

#### How to run script
Open terminal/cmd and go to directory where <b>fornite_weapons.py</b> is located than execute this command:

```bash
    python fortnite_weapons.py -img 2
```

## Contributors
Just me :) Feel free to join me.
