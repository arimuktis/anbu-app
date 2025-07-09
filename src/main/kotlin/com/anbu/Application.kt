package com.anbu

import com.anbu.plugins.*
import io.ktor.server.application.*

fun main(args: Array<String>): Unit =
    io.ktor.server.netty.EngineMain.main(args)

fun Application.module() {
    configureKoin()
    configureSerialization()
    configureMonitoring()
    configureSession()
    configureAuth()
    configureRouting()
    configureDefaultHeaders()
    configureStatusPages()
}