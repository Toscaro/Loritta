import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = Versions.JVM_TARGET
}

plugins {
    java
    kotlin("jvm")
    kotlin("plugin.serialization")
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation(project(":common"))
    implementation(project(":loritta-serializable-commons"))
    implementation(project(":pudding:client"))
    implementation(project(":temmie-discord-auth"))

    // TODO: Add Cinnamon's "common" module later

    // Kotlin Scripting
    api(kotlin("script-util"))
    api(kotlin("compiler"))
    api(kotlin("scripting-compiler"))

    // Kotlin Serialization
    api(libs.kotlinx.serialization.json)
    api(libs.kotlinx.serialization.hocon)

    // Kotlin Coroutines
    api("org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.KOTLIN_COROUTINES}")
    api("org.jetbrains.kotlinx:kotlinx-coroutines-jdk8:${Versions.KOTLIN_COROUTINES}")
    api("org.jetbrains.kotlinx:kotlinx-coroutines-debug:${Versions.KOTLIN_COROUTINES}")

    api("com.google.guava:guava:30.0-jre")

    api("org.jetbrains.kotlinx:kotlinx-html-jvm:0.7.3")
    api("org.twitter4j:twitter4j-core:[4.0,)")
    api("com.github.ben-manes.caffeine:caffeine:2.8.6")

    // Discord
    api("net.dv8tion:JDA:${Versions.JDA}")
    api("club.minnced:discord-webhooks:0.5.7")

    // Discord InteraKTions my beloved
    // We only depend in the common module here, the interactions/gateway will have the proper Discord InteraKTions modules related to them.
    api("net.perfectdreams.discordinteraktions:common:${Versions.DISCORD_INTERAKTIONS}")

    // Used to serialize state on components
    implementation("io.github.netvl.ecoji:ecoji:1.0.0")

    // We want to use Kord on our project too!
    api("dev.kord:kord-rest:${Versions.KORD}")
    api("dev.kord:kord-gateway:${Versions.KORD}")
    api("dev.kord:kord-core:${Versions.KORD}")
    api("dev.kord:kord-voice:0.8.x-20220720.101712-210")

    // Exposed & Databases
    api("org.postgresql:postgresql:42.2.18")
    api("com.impossibl.pgjdbc-ng:pgjdbc-ng:0.8.6")
    api("org.xerial:sqlite-jdbc:3.32.3.2")
    api("com.zaxxer:HikariCP:3.4.5")
    api("org.jetbrains.exposed:exposed-core:${Versions.EXPOSED}")
    api("org.jetbrains.exposed:exposed-dao:${Versions.EXPOSED}")
    api("org.jetbrains.exposed:exposed-jdbc:${Versions.EXPOSED}")
    api("net.perfectdreams.exposedpowerutils:postgres-java-time:1.0.0")
    api("pw.forst:exposed-upsert:1.1.0")
    api("redis.clients:jedis:4.3.0-m1")

    // DreamStorageService
    api("net.perfectdreams.dreamstorageservice:client:2.0.0-SNAPSHOT")

    api("org.apache.commons:commons-lang3:3.11")
    api("commons-codec:commons-codec:1.15")
    api("commons-io:commons-io:2.8.0")
    api("org.apache.commons:commons-text:1.9")
    api("org.apache.commons:commons-collections4:4.4")

    // Ktor
    implementation("io.ktor:ktor-server-core:${Versions.KTOR}")
    implementation("io.ktor:ktor-server-netty:${Versions.KTOR}")
    implementation("io.ktor:ktor-websockets:${Versions.KTOR}")
    implementation("io.ktor:ktor-client-core:${Versions.KTOR}")
    implementation("io.ktor:ktor-client-apache:${Versions.KTOR}")
    implementation("io.ktor:ktor-server-status-pages:${Versions.KTOR}")
    implementation("io.ktor:ktor-server-caching-headers:${Versions.KTOR}")
    implementation("io.ktor:ktor-server-sessions:${Versions.KTOR}")

    api("com.google.code.gson:gson:2.8.6")
    api("io.pebbletemplates:pebble:3.1.4")
    api("org.jsoup:jsoup:1.13.1")
    api("com.github.kevinsawicki:http-request:6.0")

    // Jackson
    api("com.fasterxml.jackson.core:jackson-databind:2.11.3")
    api("com.fasterxml.jackson.core:jackson-annotations:2.11.3")
    api("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:2.11.3")
    api("com.fasterxml.jackson.module:jackson-module-kotlin:2.11.3")
    api("com.fasterxml.jackson.module:jackson-module-parameter-names:2.11.3")
    api("org.honton.chas.hocon:jackson-dataformat-hocon:1.1.1")

    api("org.json:json:20190722")
    api("com.github.salomonbrys.kotson:kotson:2.5.0")
    api("com.vladsch.flexmark:flexmark-all:0.62.2")

    // Graylog GELF (Logback)
    api("de.siegmar:logback-gelf:3.0.0")

    // Prometheus
    api("io.prometheus:simpleclient:0.9.0")
    api("io.prometheus:simpleclient_hotspot:0.9.0")
    api("io.prometheus:simpleclient_common:0.9.0")

    // Sequins
    api("net.perfectdreams.sequins.text:text-utils:1.0.1")
    api("net.perfectdreams.sequins.ktor:base-route:1.0.4")

    api("net.perfectdreams.randomroleplaypictures:client:1.0.1")
    implementation("org.gagravarr:vorbis-java-core:0.8")
    api("redis.clients:jedis:4.3.0-m1")

    // zstd
    api("com.github.luben:zstd-jni:1.5.2-4")

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.5.0-M1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.5.0-M1")
    testImplementation("io.mockk:mockk:1.9.3")
    testImplementation("org.assertj:assertj-core:3.12.2")
}

tasks.test {
    useJUnitPlatform()
}

tasks {
    processResources {
        from("../../resources/") // Include folders from the resources root folder
    }

    val runnableJar = runnableJarTask(
        DEFAULT_SHADED_WITHIN_JAR_LIBRARIES,
        configurations.runtimeClasspath.get(),
        jar.get(),
        "net.perfectdreams.loritta.legacy.LorittaLauncher",
        mapOf(
            "JDA-Version" to Versions.JDA
        )
    )

    "build" {
        dependsOn(runnableJar)
    }
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}