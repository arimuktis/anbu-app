package com.anbu

import com.anbu.plugins.*
import io.ktor.server.application.*
import org.koin.core.module.Module

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    configureKoin()
    configureSerialization()
    configureMonitoring()
    configureRouting()
    configureDefaultHeaders()
}
