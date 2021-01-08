# Ktor
![Ktor](https://raw.githubusercontent.com/christopherstock/ktor-primer/main/_ASSET/readme/logo-ktor.png)

## Was ist Kotlin?
> **Ktor** ist ein von **JetBrains** entwickeltes high-level Framework zur schnellen Realisierung vernetzter,
asnychroner Server- und Client-Anwendungen. Das end-to-end Multiplattform-Anwendungs-Framework wurde 
für die Verwaltung von Webanwendungen, HTTP-Services sowie Mobile- und Browser-Anwendungen konzipiert
und ermöglicht die Realisierung von **Client-Server-Anwendungen** und **Microservices** in vernetzten Systemen.

> Es ist geschrieben in **Kotlin** und verwendet den Package Manager **Gradle**.
Jetbrains hat Ktor Ende 2018 veröffentlicht. Die aktuelle Version 1.5 wurde im Dezember 2020 veröffentlicht.
Ktor ist in der hauseigenen Programmiersprache Kotlin verfasst.

## Koroutinen
> Ktor is built from the ground up using coroutines, which make it possible to express complex asynchronous constructs as if they were simple sequential code. Coroutines are also quite efficient at runtime. In addition, the use of Kotlin features allows us to provide a domain-specific language (DSL) — a concise and developer-friendly API for configuring your application with no magic, just code.

> Of course, Ktor is not the only option for building server-side applications in Kotlin. We’re pleased to see that other frameworks such as Spring and Vert.x are providing first-class support for Kotlin, and using these frameworks is a great way to preserve your existing investment and experience. At the same time, Ktor offers unique advantages thanks to its use of coroutines and DSLs, which makes it a great option when you’re starting a new backend project or a microservice.

> Ktor is already deployed in production in a number of projects running at scale. For example, HLTV.org serves about 200 million pageviews per month and about 3.1 billion pageviews in total on Ktor. The latest release of the ThoughtWorks Technology Radar lists Ktor in their Assess category.

<hr>

## Hello World
The Hello World of Ktor is small enough to fit in a tweet:
```
fun main() {
    embeddedServer(Netty, port = 8080) {
        routing {
            get("/") {
                call.respondText("Hello World!")
            }
        }
    }.start(wait = true)
}
```
To go beyond that, the website provides a Quickstart guide, extensive documentation for writing servers and clients, and many sample projects. If you prefer videos, Ryan Harter’s KotlinConf 2018 talk is a great introduction to using Ktor on the backend.

Hop over to https://start.ktor.io/ to get a project template, check out the docs, and your new backend will be up and running in no time! If you need help, the friendly folks on the #ktor channel on Kotlin Slack are there for you.

Have a nice Ktor!

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

IntelliJ Plugin
> new project
> setup via Gradle

<hr>

## Bauen und Starten von Ktor via Gradle
![Gradle](https://raw.githubusercontent.com/christopherstock/ktor-primer/main/_ASSET/readme/logo-gradle.png)
Um Ktor zu bauen und zu verwenden einzurichten, wird Gradle verwendet. Der Gradle Wrapper
verwendet die designierte Gradle-Version für das Projekt und wird daher hier bevorzugt verwendet.

### Bauen mit Watch Mode
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

<hr>

## Pain Points
Die folgenden Punkte musste ich erst rausfinden, bevor das Framework einwandfrei betrieben werden konnte:

### Eigene HttpEngine verwenden
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

<hr>

## Tests
![jUnit5](https://raw.githubusercontent.com/christopherstock/ktor-primer/main/_ASSET/readme/logo-junit5.png)
Die initiale Anwendung verfügt bereits über einen Unit-Test im Verzeichnis `/test`.
Diese können ..

## Features
Ktor bietet unter anderem eine high-level API für die folgenden Use Cases:
- get/post/put/list ?
- Server Web Framework
- kotlin
- fast dev for get, post ...

## API Generation
![Swagger](https://raw.githubusercontent.com/christopherstock/ktor-primer/main/_ASSET/readme/logo-swagger.png)
Documentation?
> Swagger?

## Lots of Examples!
Find lots of Ready to use Samples and sceleton sample app, like completed Chat Applications etc., on ktor.io

[Samples on the Official Ktor Website](https://ktor.io/docs/samples.html)

## Fazit
![top](https://raw.githubusercontent.com/christopherstock/ktor-primer/main/_ASSET/readme/top.png)
> Der erste Eindruck von Ktor war durchwegs positiv.
