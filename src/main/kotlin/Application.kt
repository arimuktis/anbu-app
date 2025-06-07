package com.anbu

import com.anbu.plugins.configureDefaultHeaders
import com.anbu.plugins.configureKoin
import com.anbu.plugins.configureMonitoring
import com.anbu.plugins.configureRouting
import com.anbu.plugins.configureSerialization
import com.anbu.plugins.configureStatusPages
import io.ktor.server.application.*

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    configureKoin()
    configureSerialization()
    configureMonitoring()
    configureRouting()
    configureDefaultHeaders()
    configureStatusPages()
}
