# Ktor
![Ktor](https://raw.githubusercontent.com/christopherstock/ktor-primer/main/_ASSET/readme/logo-ktor.png)
> Am [letzten MayDay](https://confluence.mayflower.de/display/MAYD/MayDay+2021-01-08) habe ich mir das Framework Ktor von JetBrains angesehen. Hier ein kleiner Erfahrungsbericht über den ersten Eindruck und meine ersten Schritte mit diesem Framework.

<hr>

# Was ist Ktor?
![JetBrains](https://raw.githubusercontent.com/christopherstock/ktor-primer/main/_ASSET/readme/logo-jetbrains.png)
> **Ktor** ist ein von **JetBrains** entwickeltes high-level Framework zur Erstellung vernetzter, asnychroner Webserver- und Webclient-Anwendungen. Das end-to-end Multiplattform-Anwendungs-Framework wurde für die Verwaltung von Webanwendungen, HTTP-Services sowie Mobile- und Browser-Anwendungen konzipiert und ermöglicht eine schnelle Realisierung von **Client-Server-Anwendungen** und **Microservices** in vernetzten Systemen. Jetbrains hat Ktor Ende 2018 veröffentlicht. Die aktuelle Version 1.5 wurde im Dezember 2020 veröffentlicht.

# Ktor verwendet Kotlin und Gradle
![Kotlin](https://raw.githubusercontent.com/christopherstock/ktor-primer/main/_ASSET/readme/logo-kotlin.png)
![Gradle](https://raw.githubusercontent.com/christopherstock/ktor-primer/main/_ASSET/readme/logo-gradle.png)
> Ktor ist in der hauseigenen Programmiersprache **Kotlin** verfasst, die zahlreiche moderne Sprachfeatures bietet. Als Package Manager wird **Gradle** verwendet. 

<hr>

# Koroutinen
> Ktor is built from the ground up using coroutines, which make it possible to express complex asynchronous constructs as if they were simple sequential code. Coroutines are also quite efficient at runtime. In addition, the use of Kotlin features allows us to provide a domain-specific language (DSL) — a concise and developer-friendly API for configuring your application with no magic, just code.

> Of course, Ktor is not the only option for building server-side applications in Kotlin. We’re pleased to see that other frameworks such as Spring and Vert.x are providing first-class support for Kotlin.

> Ktor offers unique advantages thanks to its use of coroutines and DSLs, which makes it a great option when you’re starting a new backend project or a microservice.

<hr>

# Workshop Tech Stack

Für den MayDay Workshop wurde der folgende Tech Stack verwendet:

- Ktor 1.4.0
- Kotlin 1.4.21
- JDK 1.8.0_251
- IntelliJ 2020.3.1
- IntelliJ Ktor Plugin 1.5.0

<hr>

# Kotlin zu einem Gradle Projekt hinzufügen

In ein bestehendes Gradle-Projekt kann Ktor sehr schnell eingeführt werden. Hierfür müssen lediglich die folgenden beiden Dependencies zur `build.gradle` hinzugefügt werden:
```
repositories {
    ...
    jcenter()
}
dependencies {
    ...
    implementation "io.ktor:ktor-server-core:1.0.0"
    implementation "io.ktor:ktor-server-netty:1.0.0"
}
```

## Hello World

> Schon kann Kotlin in einer neuen main-Funktion gestartet werden. Die **Ktor Hello World** ist sogar klein genug um in einen Tweet zu passen:

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
> To go beyond that, the website provides a Quickstart guide, extensive documentation for writing servers and clients, and many sample projects.

> Have a nice Ktor!

<hr>

# Ein neues Ktor Projekt erstellen

> Es gibt zwei Möglichkeiten, um ein vollständiges Grundgerüst für eine neue Ktor Applikation zu erstellen.
Über den Online Projekt ..

## Online Ktor Projekt Generator
![Gradle](https://raw.githubusercontent.com/christopherstock/ktor-primer/main/_ASSET/readme/logo-gradle.png)
> JetBrains bietet einen **Online Ktor Projekt Generator** in dem das neue Ktor-Projekt angepasst werden kann und
das neue Gradle-Projekt dann als Grundlage für unser neues Projekt verwendet werden kann.
https://start.ktor.io/#
Nicht aktivierte Server- oder Client-Extensions können jederzeit später nachinstalliert werden. 
Das Projekt kann dirket danach runtergeladenen und in IntelliJ geöffnet werden.

> Hop over to https://start.ktor.io/ to get a project template, check out the docs, and your new backend will be up and running in no time! If you need help, the friendly folks on the #ktor channel on Kotlin Slack are there for you.

## IntelliJ Plugin
![IntelliJ](https://raw.githubusercontent.com/christopherstock/ktor-primer/main/_ASSET/readme/logo-intellij.png)
> Die gleiche Funktionalität bietet das Ktor Plugin für IntelliJ:
zur schnellen Realisierung eines neuen ktor Projekts#
Wird neu angelegt und direkt darauf in IntelliJ geöffnet.

IntelliJ Plugin
> new project
> setup via Gradle

<hr>

# Bauen und Starten von Ktor via Gradle
![Gradle](https://raw.githubusercontent.com/christopherstock/ktor-primer/main/_ASSET/readme/logo-gradle.png)
> Um Ktor zu bauen und zu verwenden einzurichten, wird Gradle verwendet. Der Gradle Wrapper
verwendet die designierte Gradle-Version für das Projekt und wird daher hier bevorzugt verwendet.

## Bauen mit Watch Mode
In einem neuen Befehl kann das Projekt mit dem folgenden Befehl gebaut werden:
```
gradlew build -t
```
Die Option `-t` sorgt dafür, dass Gradle automatisch neu kompiliert, sobald an den Quellcodes Änderungen durchgeführt werden.

## Starten via Gradle Wrapper
Mit dem folgenden Befehl kann parallel zum Bauen der aktuell gebaute Stand des Projekts betrieben werden:
```
gradlew run
```

## Testen im Frontend
Anschließend kann unsere Ktor-Testanwendung über die folgende Adresse angesprochen werden:
```
http://0.0.0.0:8080/
```

<hr>

# Ein einfacher Webservice

## Routing über eine DSL (Domain Specific Language)
> Ein Server braucht Routen und die soll er jetzt auch bekommen. Ich muss dafür keinen Controller schreiben, sondern definiere diese über eine DSL:

Die Application.module() wird nun an die main angeflantscht:

```
fun main(args: Array<String>) {
    embeddedServer(
            factory = Netty,
            port = 8080,
            module = Application::module
    ).start(wait = true)
}
```

```
fun Application.module() {
    val fruitStash = mutableListOf<String>()
    routing {
        post("/fruits") {
            fruitStash.add(call.receive<String>())
            call.respond(HttpStatusCode.Created)
        }
        get("/fruits") {
            call.respond(fruitStash)
        }
    }
}
```

> Nachdem ich den Server gestartet habe, kann ein POST Request nach http://localhost:8080/fruits geschickt werden. Wenn dieser einen String, z.B. "Banane" im Body stehen hat, wird diese Banane zum fruitStash hinzugefügt. Ein GET auf dieselbe URL gibt dann diesen String (bzw. alle angelegten Früchte) wieder zurück.

> Stringly typed programming ist allerdings nicht so ganz mein Ding. Daher muss schnell ein Typ Fruit her.

```
data class Fruit(val name: String)

fun Application.module() {
    val fruitStash = mutableListOf<Fruit>()
    routing {
        post("/fruits") {
            fruitStash.add(call.receive<Fruit>())
            call.respond(Created)
        }
        get("/fruits") {
            call.respond(fruitStash)
        }
    }
}
```

Ein POST mit dem Body {"name":"banane"} wird jetzt sicher das Stück Obst in meinem Service anlegen.

<hr>

# Modulares Hinzufügen von Features

## Content Negotiation

Jackson zum Serialisieren


## Authentifizierung

Authentication
Natürlich möchte ich nur registrierten Nutzern erlauben Ressourcen anzulegen. Dafür benutze ich – richtig geraten – ein Feature.

```
dependencies {
    ...
    implementation "io.ktor:ktor-auth:1.0.0"
}
```


```
install(Authentication) {
    basic {
        validate { (name, password) ->
            if(name == "lovis" && password == "cc hamburg") { 
                UserIdPrincipal(name)
            } else {
                null
            }
        }
    }
}
...
authenticate {
    post("/fruits") {
        ...
    }
}
```

> In diesem Beispiel habe ich mich für BasicAuth entschieden, aber auch OAuth, LDAP und andere werden von Haus aus unterstützt. Nach dem Set-up im install-Block dekoriere ich einfach die Routen mit einem authenticate, bei denen ich Authentifizierung nutzen möchte.

<hr>

# Pain Points
Die folgenden Punkte musste ich erst rausfinden, bevor das Framework einwandfrei betrieben werden konnte:

## Eigene HttpEngine verwenden
You need to set a custom httpEngine
```
HttpClient(CIO)
```

## Auto-Reload Problems in Ktor 1.5
Fixed with 1.5 to 1.4
```
developmentMode if off?
```
  > Swagger UI Support? - external github repo

<hr>

# Unit Tests
![jUnit5](https://raw.githubusercontent.com/christopherstock/ktor-primer/main/_ASSET/readme/logo-junit5.png)
> Die initiale Anwendung verfügt bereits über einen Unit-Test im Verzeichnis `/test`. Die Definition der Tests ist relativ straight-forward. Die gute Lesbarkeit von Kotlin und jUnit5 ermöglicht eine schnelle Erweiterbarkeit:

```
class ApplicationTest {
    @Test
    fun testRoot() {
        withTestApplication({ module(testing = true) }) {
            handleRequest(HttpMethod.Get, "/").apply {
                assertEquals(HttpStatusCode.OK, response.status())
                assertEquals("HELLO WORLD!!", response.content)
            }
        }
    }
}
```

<hr>

# Features
Ktor bietet unter anderem eine high-level API für die folgenden Use Cases:
- get/post/put/list ?
- Server Web Framework
- kotlin
- fast dev for get, post ...

<hr>

# API Generation
![Swagger](https://raw.githubusercontent.com/christopherstock/ktor-primer/main/_ASSET/readme/logo-swagger.png)
Documentation?
> Swagger?

<hr>

# Jede Menge Ktor Beispiele!
Find lots of Ready to use Samples and sceleton sample app, like completed Chat Applications etc., on ktor.io

[Samples on the Official Ktor Website](https://ktor.io/docs/samples.html)

<hr>

# Ktor im Vergleich mit Spring Boot
> Sicher bietet Spring Boot viel mehr Funktionalität und ist vermutlich auch flexibler. Aber gerade für kleine Projekte, Microservices oder Prototypen sehe ich durchaus großes Potenzial für Ktor.

> Anders als Spring ist Ktor nämlich komplett in Kotlin geschrieben und kann deshalb Sprachfeatures wie Coroutines, reified Generics und Extension Functions viel effektiver nutzen als Spring.

> Das Zusammenbauen von Schnittstellen geht sehr schnell und man muss nicht mehrere Sekunden auf den Spring Context warten. Auch Reflection wird nur sparsam verwendet (wenn überhaupt) und die meisten Fehler erkennt man bereits zur Compile-Zeit. Die Online-Doku ist hervorragend. Die Developer Experience ist einfach flüssiger. Klar – DSLs muss man mögen, Kotlin hat hier aber schlicht den Vorteil, dass es sich um interne DSLs (also normalen Code und keine Meta-Sprache) handelt.

# Fazit
![top](https://raw.githubusercontent.com/christopherstock/ktor-primer/main/_ASSET/readme/top.png)
> Der erste Eindruck von Ktor war durchwegs positiv.

<hr>

# GitHub
![GitHub](https://github.com/christopherstock/ktor-primer/main/_ASSET/readme/logo-github.png)
> Der vollständige Code zu meinem Testprojekt befindet sich auf Github.
[ktor-primer auf GitHub](https://github.com/christopherstock/ktor-primer)
