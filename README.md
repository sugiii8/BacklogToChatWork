# BacklogToChatWork #

BacklogのIssueのうち、OpenになっているものをChatWorkに通知します

### モチベーション ###

* Java(Spring Boot)でのアプリケーション開発

### やったこと ###

* Javaのキャッチアップ(知識がJava6あたりで止まっていたので8での変更点をざっと抑える)
* Spring Bootの学習
	* gradle
	* Spring Boot
* 開発環境構築
	* STS
	* vscode
	* 当初はvscodeで開発したかったが、デバッグ環境構築が難しかったので、STSとvscodeを併用しました
		* デバッグ:STS, コーディング、シンタックスチェック:vscode

### セットアップ ###

* Eclipse

```
# git clone後
$ gradle eclipse
```

* Build

```
# git clone後
$ mv src/main/resources/application-template.yml src/main/resources/application.yml
$ vim src/main/resources/application.yml # Config Backlog, ChatWork
$ gradle build
$ java -jar build/libs/BacklogToChatwork-0.0.1-SNAPSHOT.jar
# localhost:8080/start
```

* test
```
$ gradle test
```

### バージョン ###
* java: `1.8.0_111`
* STS: `3.8.3.RELEASE`
* Spring Boot: `1.5.4`
* backlog4j: `2.2.0`
* ChatWork4j: `2.0`
