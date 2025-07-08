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
import io.ktor.server.application.*

fun main(args: Array<String>): Unit =
    io.ktor.server.netty.EngineMain.main(args)

fun Application.module() {

    val factory = MongoDatabaseFactory()

    configureKoin()
    configureSerialization()
    configureMonitoring()
    configureAuth()
    configureRouting()
    configureSession()
    configureDefaultHeaders()
    configureStatusPages()
}