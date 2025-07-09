package com.anbu

import com.anbu.database.MongoDatabaseFactory
import com.anbu.plugins.configureAuth
import com.anbu.plugins.configureDefaultHeaders
import com.anbu.plugins.configureKoin
import com.anbu.plugins.configureMonitoring
import com.anbu.plugins.configureRouting
import com.anbu.plugins.configureSerialization
import com.anbu.plugins.configureSession
import com.anbu.plugins.configureStatusPages
import io.github.cdimascio.dotenv.dotenv
import io.ktor.server.application.*

fun main(args: Array<String>): Unit =
    io.ktor.server.netty.EngineMain.main(args)

fun Application.module() {

    val factory = MongoDatabaseFactory()

    val envName = System.getenv("ENV") ?: "dev"
    val dotenv = dotenv {
        filename = ".env.$envName"
        ignoreIfMissing = true
    }

    val mongoUri = dotenv["MONGO_DB_URI"] ?: error("Missing MONGO_DB_URI")

    configureKoin()
    configureSerialization()
    configureMonitoring()
    configureSession()
    configureAuth()
    configureRouting()
    configureDefaultHeaders()
    configureStatusPages()
}