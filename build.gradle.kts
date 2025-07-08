
plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.ktor)
    alias(libs.plugins.kotlin.plugin.serialization)
}

group = "com.anbu"
version = "0.0.1"

kotlin {
    jvmToolchain(17)
}

application {
    mainClass.set("io.ktor.server.netty.EngineMain")

    val isDevelopment = true
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

repositories {
    mavenCentral()
    maven { url= uri("https://jitpack.io") }
}

dependencies {
    implementation(libs.ktor.server.content.negotiation)
    implementation(libs.ktor.server.auth)
    implementation(libs.ktor.client.auth)
    implementation(libs.ktor.server.sessions)
    implementation(libs.ktor.bson.kotlinx)
    implementation(libs.ktor.mongo.croutine)
    implementation(libs.ktor.google.api.client)
    implementation(libs.ktor.server.core)
    implementation(libs.ktor.server.status.page)
    implementation(libs.ktor.serialization.kotlinx.json)
    implementation(libs.ktor.server.call.logging)
    implementation(libs.ktor.server.netty)
    implementation(libs.ktor.default.headers)
    implementation(libs.ktor.koin)
    implementation(libs.ktor.koin.logger)
    implementation(libs.logback.classic)
    implementation(libs.dotenv)
    testImplementation(libs.ktor.server.test.host)
    testImplementation(libs.kotlin.test.junit)
}

tasks.getByName("build").finalizedBy("installDist")

tasks.withType<Jar> {
    // Otherwise you'll get a "No main manifest attribute" error
    manifest {
        attributes["Main-Class"] = application.mainClass
    }

    // To avoid the duplicate handling strategy error
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE

    // To add all the dependencies
    from(sourceSets.main.get().output)

    dependsOn(configurations.runtimeClasspath)
    from({
        configurations.runtimeClasspath.get().filter { it.name.endsWith("jar") }.map { zipTree(it) }
    })
}