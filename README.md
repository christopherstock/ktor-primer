# Ktor
![Ktor](https://raw.githubusercontent.com/christopherstock/ktor-primer/main/_ASSET/readme/logo-ktor.png)
> **Ktor** ist ein von **JetBrains** entwickeltes high-level Framework 
zur schnellen Realisierung von **Web-Backend-Anwendungen** und **Microservices**.
Es ist geschrieben in **Kotlin** und verwendet den Package Manager **Gradle**.

## Neues Projekt erstellen

Es gibt zwei Möglichkeiten, um ein vollständiges Grundgerüst für eine neue Ktor Applikation zu erstellen.
Über den Online Projekt ..

### Online Ktor Projekt Generator
![Gradle](https://raw.githubusercontent.com/christopherstock/ktor-primer/main/_ASSET/readme/logo-gradle.png)
> JetBrains bietet einen **Online Ktor Projekt Generator** in dem das neue Ktor-Projekt angepasst werden kann und
das neue Gradle-Projekt dann als Grundlage für unser neues Projekt verwendet werden kann.
https://start.ktor.io/#
Nicht aktivierte Server- oder Client-Extensions können jederzeit später nachinstalliert werden. 
Das Projekt kann dirket danach runtergeladenen und in IntelliJ geöffnet werden.

### IntelliJ Plugin
![IntelliJ](https://raw.githubusercontent.com/christopherstock/ktor-primer/main/_ASSET/readme/logo-intellij.png)
> Die gleiche Funktionalität bietet das Ktor Plugin für IntelliJ:
zur schnellen Realisierung eines neuen ktor Projekts#
Wird neu angelegt und direkt darauf in IntelliJ geöffnet.

====

## Build with Gradle

Managed via Gradle

Server Web Framework
> kotlin
> fast dev for get, post ...

IntelliJ Plugin
> new project
> setup via Gradle

## Pain Points

### Set custom HttpEngine
You need to set a custom httpEngine

```
HttpClient(CIO)
```

### Auto-Reload Problems in Ktor 1.5
Fixed with 1.5 to 1.4
```
developmentMode if off?
```
  > Swagger UI Support? - external github repo

## Bauen und Starten

### Bauen im Watch Mode
In einem neuen Befehl kann das Projekt mit dem folgenden Befehl gebaut werden:
```
gradlew build -t
```
Die Option `-t` sorgt dafür, dass Gradle automatisch neu kompiliert, sobald an den Quellcodes Änderungen durchgeführt werden.

### Starten via Gradle Wrapper
Mit dem folgenden Befehl kann parallel zum Bauen der aktuell gebaute Stand des Projekts betrieben werden:
```
gradlew run
```

### Testen im Frontend
Anschließend kann unsere Ktor-Testanwendung über die folgende Adresse angesprochen werden:
```
http://0.0.0.0:8080/
```

## Tests
Die initiale Anwendung verfügt bereits über einen Unit-Test im Verzeichnis `/test`.
Diese können ..

## Features
Ktor bietet unter anderem eine high-level API für die folgenden Use Cases:
- get/post/put/list ?
- 2
- 3 


## API Generation
Documentation?
> Swagger?

## Lots of Examples!
Find lots of Ready to use Samples and sceleton sample app, like completed Chat Applications etc., on ktor.io

## Fazit
![top](https://raw.githubusercontent.com/christopherstock/ktor-primer/main/_ASSET/readme/top.png)
> Der erste Eindruck von Ktor war durchwegs positiv.
